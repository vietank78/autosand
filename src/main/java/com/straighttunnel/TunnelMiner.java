package com.straighttunnel;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;

import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Đào đường hầm thẳng (kiểu Baritone "tunnel") với cúp 3x3.
 *
 * Cúp 3x3 phá 1 block là server phá luôn vùng 3x3 quanh nó, nên bot chỉ cần ngắm block TÂM
 * (cao hơn chân 1 block) ngay phía trước, đào rồi đi tới.
 *
 *  - Nước/lava phía trước  -> đào vòng sang bên, đi qua, rồi quay lại đúng đường cũ.
 *  - Bedrock               -> chân bị chặn thì nhảy lên bậc; hết cách thì đào vòng như nước/lava.
 *  - Máu thấp              -> ăn táo vàng (hết táo thì /shop mua).
 *  - Cúp sắp hỏng          -> /shop mua bình XP, ném xuống chân để Mending sửa.
 */
public final class TunnelMiner implements ClientModInitializer {
	// ---- cấu hình ----
	private static final float EAT_HP = 10.0f;          // máu + absorption <= giá trị này thì ăn (10 = 5 tim)
	private static final int EAT_COOLDOWN = 60;         // tick nghỉ giữa 2 lần ăn
	private static final int APPLE_BUY_CLICKS = 4;      // số lần bấm mua táo vàng trong /shop
	private static final int XP_BUY_CLICKS = 8;         // số lần bấm mua bình XP trong /shop
	private static final int LATERAL_OFFSET = 4;        // đường vòng lệch bao nhiêu block so với đường chính
	private static final int STUCK_TICKS = 80;
	private static final boolean EAT_ENCHANTED_TOO = true;
	// Trong /shop, táo vàng nằm ở danh mục con: bấm biểu tượng totem (ở giữa) trước.
	// Tìm theo TÊN (bỏ dấu, thường hoá). Sửa các từ khoá này cho khớp tên thật trong shop của bạn.
	private static final Item FOOD_CATEGORY_ICON = Items.TOTEM_OF_UNDYING;
	private static final String[] FOOD_CATEGORY_NAMES = { "totem", "do an", "thuc an", "food" };
	private static final String[] APPLE_NAMES = { "tao vang", "golden apple" };
	private static final String[] APPLE_EXCLUDE = { "phu phep", "enchanted", "than" }; // tránh táo phù phép (đắt)
	private static final String[] XP_NAMES = { "chai kinh nghiem", "kinh nghiem", "experience", "xp" };

	private enum Task { MINE, EAT, SHOP, REPAIR }
	private enum Mode { MAIN, SIDE_OUT, PASS, SIDE_BACK }

	private static boolean active = false;
	private static Task task = Task.MINE;
	private static Mode mode = Mode.MAIN;
	private static Direction mainDir = Direction.NORTH;
	private static Direction sideDir = Direction.EAST;
	private static int laneCoord = 0;
	private static int passFwdStart = 0;

	private static BlockPos lastPos = null;
	private static int stillTicks = 0;

	// eat
	private static int eatStage, eatTimer, eatCooldown, eatSwapIdx = -1;
	private static boolean shopTriedApple = false;
	// repair
	private static int repStage, repTimer, repSwapIdx = -1, repairRounds = 0;
	private static boolean shopTriedXp = false;
	// shop
	private static Item shopItem, shopCategory;
	private static String[] shopNames, shopExclude, shopCatNames;
	private static boolean shopCategoryClicked;
	private static int shopCount, shopStage, shopTimer, shopClicks;
	private static Task afterShop = Task.MINE;

	private record Plan(List<BlockPos> targets, boolean jump, boolean blocked, BlockPos floor) {}

	private static KeyBinding toggleKey;

	/** Entrypoint của mod (khai báo trong fabric.mod.json). */
	@Override
	public void onInitializeClient() {
		// 1.21.9+: KeyBinding nhận KeyBinding.Category thay vì String
		toggleKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
			"key.straighttunnel.toggle",
			InputUtil.Type.KEYSYM,
			GLFW.GLFW_KEY_K,
			KeyBinding.Category.create(Identifier.of("straighttunnel", "main"))
		));
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			while (toggleKey.wasPressed()) toggle(client);
			tick(client);
		});
	}

	// =====================================================================================
	// bật / tắt
	// =====================================================================================

	public static void toggle(MinecraftClient mc) {
		if (active) {
			stop(mc, "Đã tắt đào hầm.");
			return;
		}
		ClientPlayerEntity p = mc.player;
		if (p == null || mc.world == null) return;
		mainDir = Direction.fromHorizontalDegrees(p.getYaw());
		laneCoord = lateral(p.getBlockPos());
		mode = Mode.MAIN;
		task = Task.MINE;
		lastPos = null;
		stillTicks = 0;
		eatCooldown = 0;
		shopTriedApple = false;
		shopTriedXp = false;
		repairRounds = 0;
		eatSwapIdx = -1;
		repSwapIdx = -1;
		active = true;
		msg(mc, "Bật đào hầm 3x3 hướng " + mainDir.asString().toUpperCase() + " (nhấn K để dừng)");
	}

	public static void stop(MinecraftClient mc, String reason) {
		active = false;
		if (mc.options != null) {
			mc.options.forwardKey.setPressed(false);
			mc.options.jumpKey.setPressed(false);
			mc.options.useKey.setPressed(false);
		}
		if (mc.interactionManager != null) mc.interactionManager.cancelBlockBreaking();
		// trả lại đồ nếu đang đổi sang tay trái
		ClientPlayerEntity p = mc.player;
		if (p != null && mc.interactionManager != null && mc.currentScreen == null) {
			if (eatSwapIdx >= 0) { swapOffhand(mc, p, eatSwapIdx); eatSwapIdx = -1; }
			if (repSwapIdx >= 0) { swapOffhand(mc, p, repSwapIdx); repSwapIdx = -1; }
		}
		if (reason != null) msg(mc, reason);
	}

	// =====================================================================================
	// vòng lặp chính
	// =====================================================================================

	public static void tick(MinecraftClient mc) {
		if (!active) return;
		ClientPlayerEntity p = mc.player;
		ClientWorld w = mc.world;
		if (p == null || w == null || mc.interactionManager == null) {
			active = false;
			return;
		}
		if (p.isDead()) {
			stop(mc, "Dừng: đã chết.");
			return;
		}
		if (eatCooldown > 0) eatCooldown--;

		switch (task) {
			case SHOP -> tickShop(mc, p);
			case EAT -> tickEat(mc, p);
			case REPAIR -> tickRepair(mc, p);
			default -> {
				if (mc.currentScreen != null) {
					idle(mc);
					return;
				}
				tickMine(mc, p, w);
			}
		}
	}

	private static void idle(MinecraftClient mc) {
		mc.options.forwardKey.setPressed(false);
		mc.options.jumpKey.setPressed(false);
		if (mc.interactionManager != null) mc.interactionManager.cancelBlockBreaking();
	}

	// =====================================================================================
	// ĐÀO
	// =====================================================================================

	private static void tickMine(MinecraftClient mc, ClientPlayerEntity p, ClientWorld w) {
		// --- máu thấp -> ăn ---
		float hp = p.getHealth() + p.getAbsorptionAmount();
		if (hp <= EAT_HP && eatCooldown <= 0) {
			idle(mc);
			task = Task.EAT;
			eatStage = 0;
			eatTimer = 0;
			return;
		}

		// --- cúp sắp hỏng -> sửa ---
		ItemStack held = p.getMainHandStack();
		if (held.isEmpty()) {
			stop(mc, "Dừng: tay đang trống, hãy cầm cúp.");
			return;
		}
		if (held.isDamageable() && remaining(held) <= lowThreshold(held)) {
			idle(mc);
			beginRepair();
			return;
		}

		BlockPos feet = p.getBlockPos();

		// --- chuyển chế độ đường vòng ---
		if (mode == Mode.SIDE_OUT && Math.abs(lateral(feet) - laneCoord) >= LATERAL_OFFSET) {
			mode = Mode.PASS;
			passFwdStart = fwd(feet);
		} else if (mode == Mode.PASS && Math.abs(fwd(feet) - passFwdStart) >= 3 && returnPathClear(w, feet)) {
			mode = Mode.SIDE_BACK;
		} else if (mode == Mode.SIDE_BACK && lateral(feet) == laneCoord) {
			mode = Mode.MAIN;
			msg(mc, "Đã vòng xong, đào thẳng tiếp.");
		}

		Direction cur = currentDir();
		Plan pl = plan(w, feet, cur);
		boolean hazard = fluidAhead(w, feet, cur);

		if (mode == Mode.MAIN && (hazard || pl.blocked())) {
			Direction side = chooseSide(w, feet);
			if (side == null) {
				stop(mc, "Dừng: nước/lava/bedrock chặn, không có đường vòng an toàn.");
				return;
			}
			sideDir = side;
			mode = Mode.SIDE_OUT;
			msg(mc, hazard ? "Có nước/lava phía trước -> đi vòng." : "Bedrock chặn -> đi vòng.");
			cur = currentDir();
			pl = plan(w, feet, cur);
			hazard = fluidAhead(w, feet, cur);
		}
		if (hazard) {
			stop(mc, "Dừng: nước/lava cả ở đường vòng.");
			return;
		}
		if (pl.blocked()) {
			stop(mc, "Dừng: bedrock chặn cả ở đường vòng.");
			return;
		}

		// --- khoá góc nhìn ---
		BlockPos aim = pl.targets().isEmpty() ? feet.offset(cur).up() : pl.targets().get(0);
		Vec3d eye = p.getEyePos();
		double ax = aim.getX() + 0.5 - eye.x;
		double ay = aim.getY() + 0.5 - eye.y;
		double az = aim.getZ() + 0.5 - eye.z;
		double horiz = Math.sqrt(ax * ax + az * az);
		p.setYaw(cur.getPositiveHorizontalDegrees());
		p.setPitch((float) -Math.toDegrees(Math.atan2(ay, horiz)));

		if (!pl.targets().isEmpty()) {
			mc.options.forwardKey.setPressed(false);
			mc.options.jumpKey.setPressed(false);
			mc.interactionManager.updateBlockBreakingProgress(pl.targets().get(0), cur.getOpposite());
			p.swingHand(Hand.MAIN_HAND);
			stillTicks = 0;
			return;
		}

		mc.interactionManager.cancelBlockBreaking();
		if (!isSolid(w, pl.floor())) {
			idle(mc);
			stop(mc, "Dừng: phía trước không có sàn (hố).");
			return;
		}
		mc.options.forwardKey.setPressed(true);
		mc.options.jumpKey.setPressed(pl.jump());

		// --- phát hiện kẹt ---
		if (feet.equals(lastPos)) {
			if (++stillTicks > STUCK_TICKS) {
				stop(mc, "Dừng: bị kẹt, không tiến thêm được.");
			}
		} else {
			stillTicks = 0;
			lastPos = feet;
		}
	}

	/** Lập kế hoạch cho cột block ngay phía trước theo hướng d. */
	private static Plan plan(ClientWorld w, BlockPos feet, Direction d) {
		BlockPos a = feet.offset(d);
		BlockPos f = a;          // block ngang chân
		BlockPos h = a.up();     // block ngang đầu (= tâm 3x3)
		BlockPos t = a.up(2);    // hàng trên của 3x3
		BlockPos floor = a.down();

		boolean fBad = isUnbreakable(w, f);
		boolean hBad = isUnbreakable(w, h);
		boolean tBad = isUnbreakable(w, t);

		List<BlockPos> targets = new ArrayList<>();
		if (!fBad && !hBad) {
			// bình thường: tâm -> chân -> hàng trên (bỏ qua nếu là bedrock)
			if (isSolid(w, h)) targets.add(h);
			if (isSolid(w, f)) targets.add(f);
			if (!tBad && isSolid(w, t)) targets.add(t);
			return new Plan(targets, false, false, floor);
		}
		if (fBad && !hBad && !tBad) {
			// chân bị bedrock: đào h, t rồi nhảy lên đứng trên bedrock
			if (isSolid(w, h)) targets.add(h);
			if (isSolid(w, t)) targets.add(t);
			return new Plan(targets, true, false, f);
		}
		return new Plan(targets, false, true, floor);
	}

	private static boolean isSolid(ClientWorld w, BlockPos q) {
		return !w.getBlockState(q).getCollisionShape(w, q).isEmpty();
	}

	private static boolean isUnbreakable(ClientWorld w, BlockPos q) {
		BlockState s = w.getBlockState(q);
		return !s.getCollisionShape(w, q).isEmpty() && s.getHardness(w, q) < 0;
	}

	/** Có nước/lava trong vùng 3x3 của 3 cột phía trước (kèm 1 block sàn)? */
	private static boolean fluidAhead(ClientWorld w, BlockPos feet, Direction d) {
		Direction perp = d.rotateYClockwise();
		for (int step = 1; step <= 3; step++) {
			for (int side = -1; side <= 1; side++) {
				for (int up = -1; up <= 3; up++) {
					BlockPos q = feet.offset(d, step).offset(perp, side).up(up);
					if (!w.getFluidState(q).isEmpty()) return true;
				}
			}
		}
		return false;
	}

	/** Chọn bên để đào vòng (bên không có nước/lava). */
	private static Direction chooseSide(ClientWorld w, BlockPos feet) {
		Direction[] cands = { mainDir.rotateYClockwise(), mainDir.rotateYCounterclockwise() };
		for (Direction side : cands) {
			boolean ok = true;
			for (int i = 0; i <= LATERAL_OFFSET + 1 && ok; i++) {
				for (int f = -2; f <= 2 && ok; f++) {
					for (int y = -1; y <= 3; y++) {
						BlockPos q = feet.offset(side, i).offset(mainDir, f).up(y);
						if (!w.getFluidState(q).isEmpty()) { ok = false; break; }
					}
				}
			}
			if (ok) return side;
		}
		return null;
	}

	/** Đường quay lại làn chính (và vùng quanh nó) đã hết nước/lava chưa? */
	private static boolean returnPathClear(ClientWorld w, BlockPos feet) {
		Direction back = sideDir.getOpposite();
		int dist = Math.abs(lateral(feet) - laneCoord);
		for (int i = -1; i <= dist + 1; i++) {
			for (int f = -2; f <= 4; f++) {
				for (int y = -1; y <= 3; y++) {
					BlockPos q = feet.offset(back, i).offset(mainDir, f).up(y);
					if (!w.getFluidState(q).isEmpty()) return false;
				}
			}
		}
		return true;
	}

	private static Direction currentDir() {
		return switch (mode) {
			case MAIN, PASS -> mainDir;
			case SIDE_OUT -> sideDir;
			case SIDE_BACK -> sideDir.getOpposite();
		};
	}

	private static int lateral(BlockPos q) {
		return mainDir.getAxis() == Direction.Axis.X ? q.getZ() : q.getX();
	}

	private static int fwd(BlockPos q) {
		return mainDir.getAxis() == Direction.Axis.X ? q.getX() : q.getZ();
	}

	// =====================================================================================
	// ĂN TÁO VÀNG
	// =====================================================================================

	private static boolean isGapple(ItemStack s) {
		return s.isOf(Items.GOLDEN_APPLE) || (EAT_ENCHANTED_TOO && s.isOf(Items.ENCHANTED_GOLDEN_APPLE));
	}

	private static void tickEat(MinecraftClient mc, ClientPlayerEntity p) {
		idle(mc);
		if (mc.currentScreen != null) return;

		switch (eatStage) {
			case 0 -> {
				if (isGapple(p.getOffHandStack())) {
					eatStage = 1;
					return;
				}
				int idx = findSlot(p, TunnelMiner::isGapple);
				if (idx < 0) {
					if (shopTriedApple) {
						stop(mc, "Dừng: máu thấp, không có táo vàng và mua ở /shop không được.");
						return;
					}
					shopTriedApple = true;
					msg(mc, "Hết táo vàng -> mở /shop mua.");
					startShop(Items.GOLDEN_APPLE, APPLE_NAMES, APPLE_EXCLUDE,
						FOOD_CATEGORY_ICON, FOOD_CATEGORY_NAMES, APPLE_BUY_CLICKS, Task.EAT);
					return;
				}
				swapOffhand(mc, p, idx);
				eatSwapIdx = idx;
				eatStage = 1;
			}
			case 1 -> {
				mc.interactionManager.interactItem(p, Hand.OFF_HAND);
				mc.options.useKey.setPressed(true);
				eatStage = 2;
				eatTimer = 0;
			}
			case 2 -> {
				mc.options.useKey.setPressed(true);
				eatTimer++;
				if ((!p.isUsingItem() && eatTimer > 3) || eatTimer > 80) {
					mc.options.useKey.setPressed(false);
					if (eatSwapIdx >= 0) {
						swapOffhand(mc, p, eatSwapIdx);
						eatSwapIdx = -1;
					}
					shopTriedApple = false;
					eatCooldown = EAT_COOLDOWN;
					task = Task.MINE;
				}
			}
			default -> task = Task.MINE;
		}
	}

	// =====================================================================================
	// SỬA CÚP BẰNG BÌNH XP
	// =====================================================================================

	private static boolean isXp(ItemStack s) {
		return s.isOf(Items.EXPERIENCE_BOTTLE);
	}

	private static void beginRepair() {
		task = Task.REPAIR;
		repStage = 0;
		repTimer = 0;
		repairRounds++;
	}

	private static void tickRepair(MinecraftClient mc, ClientPlayerEntity p) {
		idle(mc);
		if (mc.currentScreen != null) return;
		ItemStack held = p.getMainHandStack();

		switch (repStage) {
			case 0 -> {
				if (countItem(p, TunnelMiner::isXp) == 0) {
					if (shopTriedXp) {
						stop(mc, "Dừng: cúp sắp hỏng, không mua được bình XP ở /shop.");
						return;
					}
					shopTriedXp = true;
					msg(mc, "Cúp sắp hỏng -> mở /shop mua bình XP.");
					startShop(Items.EXPERIENCE_BOTTLE, XP_NAMES, null, null, null, XP_BUY_CLICKS, Task.REPAIR);
					return;
				}
				shopTriedXp = false;
				if (!isXp(p.getOffHandStack())) {
					int idx = findSlot(p, TunnelMiner::isXp);
					if (idx >= 0) {
						swapOffhand(mc, p, idx);
						repSwapIdx = idx;
					}
				}
				repStage = 1;
				repTimer = 0;
			}
			case 1 -> {
				// nhìn xuống chân rồi ném bình bằng tay trái
				p.setPitch(90.0f);
				repTimer++;
				if (!isXp(p.getOffHandStack())) {
					repStage = 2;
					repTimer = 0;
					return;
				}
				if (repTimer % 2 == 0) {
					mc.interactionManager.interactItem(p, Hand.OFF_HAND);
				}
				if (held.getDamage() <= held.getMaxDamage() / 10) {
					repStage = 2;
					repTimer = 0;
				}
			}
			case 2 -> {
				p.setPitch(90.0f);
				if (++repTimer < 25) return; // chờ nhặt hết orb XP
				if (repSwapIdx >= 0) {
					swapOffhand(mc, p, repSwapIdx);
					repSwapIdx = -1;
				}
				if (remaining(held) > lowThreshold(held) * 2) {
					repairRounds = 0;
					task = Task.MINE;
					msg(mc, "Đã sửa cúp, đào tiếp.");
				} else if (repairRounds >= 4) {
					stop(mc, "Dừng: bình XP không sửa được cúp (cúp có Mending không?).");
				} else {
					beginRepair();
				}
			}
			default -> task = Task.MINE;
		}
	}

	private static int remaining(ItemStack s) {
		return s.getMaxDamage() - s.getDamage();
	}

	private static int lowThreshold(ItemStack s) {
		return Math.max(40, s.getMaxDamage() / 20);
	}

	// =====================================================================================
	// /shop
	// =====================================================================================

	/**
	 * Tìm trong /shop theo TÊN hiển thị (đã bỏ dấu, không phân biệt hoa thường) vì resource pack đổi hình item.
	 * names/exclude: từ khoá của món cần mua; category/catNames: danh mục con cần bấm trước (null = không cần).
	 */
	private static void startShop(Item item, String[] names, String[] exclude,
								  Item category, String[] catNames, int clicks, Task after) {
		task = Task.SHOP;
		shopNames = names;
		shopExclude = exclude;
		shopCategory = category;
		shopCatNames = catNames;
		shopCategoryClicked = false;
		shopItem = item;
		shopCount = clicks;
		afterShop = after;
		shopStage = 0;
		shopTimer = 0;
		shopClicks = 0;
	}

	/** Bỏ dấu tiếng Việt + thường hoá để so tên không phụ thuộc dấu/hoa thường. */
	private static String norm(String s) {
		String n = java.text.Normalizer.normalize(s, java.text.Normalizer.Form.NFD)
			.replaceAll("\\p{M}+", "")
			.replace('đ', 'd').replace('Đ', 'd');
		return n.toLowerCase(java.util.Locale.ROOT);
	}

	/** Slot shop khớp nếu đúng loại item HOẶC tên chứa từ khoá (và không chứa từ khoá loại trừ). */
	private static boolean shopMatches(ItemStack st, Item type, String[] names, String[] exclude) {
		if (st.isEmpty()) return false;
		String name = norm(st.getName().getString());
		if (exclude != null) {
			for (String x : exclude) if (name.contains(x)) return false;
		}
		if (names != null) {
			for (String k : names) if (name.contains(k)) return true;
		}
		return st.isOf(type);
	}

	private static void tickShop(MinecraftClient mc, ClientPlayerEntity p) {
		mc.options.forwardKey.setPressed(false);
		mc.options.jumpKey.setPressed(false);
		shopTimer++;

		switch (shopStage) {
			case 0 -> {
				if (mc.currentScreen != null) mc.setScreen(null);
				p.networkHandler.sendChatCommand("shop");
				shopStage = 1;
				shopTimer = 0;
			}
			case 1 -> {
				if (mc.currentScreen instanceof HandledScreen<?> && !(mc.currentScreen instanceof InventoryScreen)) {
					shopStage = 2;
					shopTimer = 0;
				} else if (shopTimer > 80) {
					stop(mc, "Dừng: /shop không mở được GUI.");
				}
			}
			case 2 -> {
				if (shopTimer < 6) return; // chờ server gửi nội dung GUI
				if (!(mc.currentScreen instanceof HandledScreen<?> hs)) {
					shopStage = 3;
					shopTimer = 0;
					return;
				}
				ScreenHandler h = hs.getScreenHandler();
				Slot target = null;
				for (Slot s : h.slots) {
					if (s.inventory instanceof PlayerInventory) continue;
					if (shopMatches(s.getStack(), shopItem, shopNames, shopExclude)) { target = s; break; }
				}
				if (target == null && shopCategory != null && !shopCategoryClicked) {
					// chưa thấy item -> bấm biểu tượng danh mục (nếu có nhiều thì lấy cái ở giữa)
					List<Slot> icons = new ArrayList<>();
					List<Slot> nonEmpty = new ArrayList<>();
					for (Slot s : h.slots) {
						if (s.inventory instanceof PlayerInventory) continue;
						if (s.getStack().isEmpty()) continue;
						nonEmpty.add(s);
						if (shopMatches(s.getStack(), shopCategory, shopCatNames, null)) icons.add(s);
					}
					if (icons.isEmpty()) {
						// không khớp theo tên/loại -> lấy ô có đồ nằm ở giữa menu
						if (nonEmpty.isEmpty()) {
							stop(mc, "Dừng: menu /shop trống.");
							return;
						}
						icons = nonEmpty;
					}
					Slot icon = icons.get(icons.size() / 2);
					mc.interactionManager.clickSlot(h.syncId, icon.id, 0, SlotActionType.PICKUP, p);
					shopCategoryClicked = true;
					shopTimer = 0; // chờ GUI danh mục load
					return;
				}
				if (target == null) {
					if (shopClicks == 0) {
						stop(mc, "Dừng: không thấy " + shopItem.getName().getString()
							+ " ngay trong /shop (có thể nằm trong danh mục con).");
					} else {
						shopStage = 3;
						shopTimer = 0;
					}
					return;
				}
				if (shopTimer < 4) return;
				shopTimer = 0;
				mc.interactionManager.clickSlot(h.syncId, target.id, 0, SlotActionType.PICKUP, p);
				if (++shopClicks >= shopCount) {
					shopStage = 3;
					shopTimer = 0;
				}
			}
			case 3 -> {
				if (shopTimer < 5) return;
				p.closeHandledScreen();
				shopStage = 4;
				shopTimer = 0;
			}
			case 4 -> {
				if (shopTimer < 4) return;
				final Item want = shopItem;
				if (countItem(p, s -> s.isOf(want)) == 0) {
					stop(mc, "Dừng: mua " + want.getName().getString() + " không được (hết tiền?).");
					return;
				}
				task = afterShop;
				eatStage = 0;
				repStage = 0;
			}
			default -> task = Task.MINE;
		}
	}

	// =====================================================================================
	// tiện ích inventory
	// =====================================================================================

	/** Tìm slot (index inventory 0..35) chứa item thoả điều kiện, -1 nếu không có. */
	private static int findSlot(ClientPlayerEntity p, Predicate<ItemStack> pred) {
		PlayerInventory inv = p.getInventory();
		for (int i = 0; i < 36; i++) {
			if (pred.test(inv.getStack(i))) return i;
		}
		return -1;
	}

	private static int countItem(ClientPlayerEntity p, Predicate<ItemStack> pred) {
		int n = 0;
		PlayerInventory inv = p.getInventory();
		for (int i = 0; i < 36; i++) {
			ItemStack s = inv.getStack(i);
			if (pred.test(s)) n += s.getCount();
		}
		ItemStack off = p.getOffHandStack();
		if (pred.test(off)) n += off.getCount();
		return n;
	}

	/** Hoán đổi slot inventory (index 0..35) với tay trái. */
	private static void swapOffhand(MinecraftClient mc, ClientPlayerEntity p, int invIdx) {
		int slotId = invIdx < 9 ? 36 + invIdx : invIdx; // hotbar = 36..44, túi đồ = 9..35
		mc.interactionManager.clickSlot(p.playerScreenHandler.syncId, slotId, 40, SlotActionType.SWAP, p);
	}

	private static void msg(MinecraftClient mc, String s) {
		if (mc.player != null) mc.player.sendMessage(Text.literal("[Tunnel] " + s), true);
	}
}
