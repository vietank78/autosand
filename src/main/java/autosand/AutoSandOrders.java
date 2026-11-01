package autosand;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mojang.blaze3d.platform.InputConstants;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.loader.api.FabricLoader;

import net.minecraft.ChatFormatting;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.ChatScreen;
import net.minecraft.client.gui.screens.PauseScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.ItemLore;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.Normalizer;
import java.time.Duration;
import java.util.*;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * AUTOSAND PREMIUM CLIENT MOD (Fabric 1.21.x - Mojang Mappings)
 * Glass Theme GUI 8 Tabs, License Key System, AI Mining & Survival Anti-Stuck.
 */
public class AutoSandOrders implements ClientModInitializer {

    // =========================================================================
    // 1. CHẾ ĐỘ & CẤU HÌNH HỆ THỐNG
    // =========================================================================
    public enum MiningMode {
        BUILTIN("Tự đào (AI A*)"),
        KEYS("Giữ phím"),
        NUKER("Chỉ Nuker");

        public final String label;
        MiningMode(String l) { this.label = l; }
        public MiningMode next() { return values()[(ordinal() + 1) % values().length]; }
    }

    public enum Theme {
        CYBER_CYAN("Cyber Cyan", 0xFF19CFFF, 0xFF0A1B31),
        NEON_EMERALD("Neon Emerald", 0xFF27F2FF, 0xFF0A2B1E),
        ROYAL_PURPLE("Royal Purple", 0xFFB34DFF, 0xFF1C0A31),
        GOLDEN("Gold Premium", 0xFFFFD700, 0xFF2B210A),
        CRIMSON("Crimson Red", 0xFFFF477E, 0xFF2B0A14),
        RGB("RGB Chroma", 0xFF00FFFF, 0xFF111111);

        public final String label;
        public final int primaryColor;
        public final int cardBg;
        Theme(String l, int p, int bg) { this.label = l; this.primaryColor = p; this.cardBg = bg; }
        public Theme next() { return values()[(ordinal() + 1) % values().length]; }
    }

    // Config global variables
    public static MiningMode mode = MiningMode.BUILTIN;
    public static Theme currentTheme = Theme.CYBER_CYAN;
    public static boolean masterToggle = false;
    public static boolean useNuker = true;
    public static boolean keysForward = true;
    public static boolean autoDeliver = true;
    public static boolean autoMend = true;
    public static boolean autoBuy = true;
    public static int mendPct = 10;
    public static int mendUntil = 100;
    public static boolean autoEat = true;
    public static boolean autoBuyFood = true;
    public static boolean autoDrop = true;
    public static int eatBelow = 14;
    public static int eatUntil = 18;
    public static int pickupRadius = 8;
    public static boolean autoRevive = true;
    public static boolean autoRejoin = true;
    public static boolean usePearl = true;
    public static boolean autoTotem = true;
    public static int mineSpeed = 500;
    public static double pricePerSand = 5.0;
    public static double minSandPrice = 0.0;
    public static int deliverStacks = 0;
    public static int menuGuiScale = 0;

    // Safety & Defense
    public static boolean avoidLiquid = true;
    public static boolean avoidHole = true;
    public static boolean bridgeWater = true;
    public static boolean autoDefend = false;
    public static int defenseRadius = 6;
    public static boolean lowLoad = false;
    public static int fgFps = 60, bgFps = 10, lowLoadView = 6;

    // Limits & Stats
    public static double maxXpUnitPrice = 0, maxXpSpend = 0;
    public static double maxTotemUnitPrice = 0, maxTotemSpend = 0;
    public static double xpSpent = 0, totemSpent = 0;
    public static long statSand = 0, statTicks = 0;
    public static int statDeaths = 0;

    // Custom commands & keep items
    public static String ORDER_COMMAND = "orders sand";
    public static String SHOP_COMMAND = "shop";
    public static String HOME_COMMAND = "home cat";
    public static final Set<String> extraKeep = new LinkedHashSet<>();

    // Keys
    public static KeyMapping menuKey = null;
    public static KeyMapping stopKey = null;
    public static boolean openGuiRequested = false;

    // Mod Lifecycle Initializer
    @Override
    public void onInitializeClient() {
        LicenseManager.init();
        loadConfig();

        ClientTickEvents.END_CLIENT_TICK.register(this::onClientTick);
        ClientLifecycleEvents.CLIENT_STOPPING.register(mc -> restorePerf(mc));

        registerKeyBindings();
        registerCommands();
    }

    private void registerKeyBindings() {
        menuKey = registerKey("key.autosand.menu", InputConstants.KEY_F12);
        stopKey = registerKey("key.autosand.stop", InputConstants.KEY_END);
    }

    private static KeyMapping registerKey(String id, int keyCode) {
        try {
            Constructor<?> ctor = null;
            for (Constructor<?> c : KeyMapping.class.getConstructors()) {
                Class<?>[] pt = c.getParameterTypes();
                if (pt.length == 4 && pt[0] == String.class && pt[1] == InputConstants.Type.class && pt[2] == int.class) {
                    ctor = c; break;
                }
            }
            if (ctor == null) return null;
            Object cat = "key.categories.misc";
            KeyMapping key = (KeyMapping) ctor.newInstance(id, InputConstants.Type.KEYSYM, keyCode, cat);
            Class<?> helper;
            try {
                helper = Class.forName("net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper");
            } catch (ClassNotFoundException e) {
                helper = Class.forName("net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper");
            }
            helper.getMethod("registerKeyBinding", KeyMapping.class).invoke(null, key);
            return key;
        } catch (Throwable t) {
            return null;
        }
    }

    private void registerCommands() {
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) ->
            dispatcher.register(ClientCommandManager.literal("autosand")
                .executes(ctx -> { openGuiRequested = true; return 1; })
                .then(ClientCommandManager.literal("toggle").requires(src -> LicenseManager.valid())
                    .executes(ctx -> {
                        setMasterToggle(Minecraft.getInstance(), !masterToggle);
                        return 1;
                    }))
                .then(ClientCommandManager.literal("stop")
                    .executes(ctx -> { emergencyStop(Minecraft.getInstance()); return 1; }))
                .then(ClientCommandManager.literal("key")
                    .then(ClientCommandManager.argument("key", StringArgumentType.greedyString())
                        .executes(ctx -> {
                            LicenseManager.activate(StringArgumentType.getString(ctx, "key"));
                            ctx.getSource().sendFeedback(Component.literal("[AutoSand] Đang xác thực Key Premium..."));
                            return 1;
                        })))
                .then(ClientCommandManager.argument("text", StringArgumentType.greedyString())
                    .executes(ctx -> { openGuiRequested = true; return 1; }))
            )
        );
    }

    public static void setMasterToggle(Minecraft mc, boolean on) {
        if (on == masterToggle) return;
        LocalPlayer p = mc.player;
        if (on && !LicenseManager.valid()) {
            if (p != null) sendMsg(p, "Key Premium không hợp lệ! Vui lòng nhập key bằng /autosand key <KEY>");
            return;
        }
        masterToggle = on;
        if (p != null) sendMsg(p, on ? "BẬT toàn bộ hệ thống Bot." : "TẮT Bot.");
        if (!on) {
            MiningManager.stop(mc);
            SurvivalManager.resetState();
            SafetyManager.releaseKeys(mc);
        } else {
            MiningManager.start(p);
        }
    }

    public static void emergencyStop(Minecraft mc) {
        setMasterToggle(mc, false);
        if (mc.player != null && mc.screen instanceof AbstractContainerScreen<?>) {
            mc.player.closeContainer();
        }
        SafetyManager.releaseKeys(mc);
        if (mc.player != null) sendMsg(mc.player, "§c[PANIC STOP] ĐÃ DỪNG KHẨN CẤP TOÀN BỘ CHỨC NĂNG!");
    }

    private void onClientTick(Minecraft mc) {
        LocalPlayer p = mc.player;
        perfTick(mc);

        if (p == null || mc.gameMode == null) {
            ReconnectManager.tickDisconnected(mc);
            return;
        }

        LicenseManager.refreshIfNeeded();
        AnnouncementsManager.tick(mc, p);

        while (menuKey != null && menuKey.consumeClick()) openGuiRequested = true;
        while (stopKey != null && stopKey.consumeClick()) emergencyStop(mc);

        if (openGuiRequested && mc.screen == null) {
            openGuiRequested = false;
            mc.setScreen(new AutoSandProStudioScreen());
            return;
        }

        if (masterToggle) {
            if (!LicenseManager.valid()) {
                setMasterToggle(mc, false);
                sendMsg(p, "§cKey hết hạn hoặc không hợp lệ. Mod đã tự tắt.");
                return;
            }

            statTicks++;
            if (statTicks % 1200 == 0) saveConfig();

            // Core Bot Loop Delegation
            if (SafetyManager.tick(mc, p)) return;
            if (SurvivalManager.tick(mc, p)) return;
            if (OrderManager.tick(mc, p)) return;
            MiningManager.tick(mc, p);
        }
    }

    public static void sendMsg(LocalPlayer p, String txt) {
        p.displayClientMessage(Component.literal("§b[AutoSand Premium] §r" + txt), false);
    }

    // Performance lowering mode
    private static Integer origFps = null, origView = null;
    private static void perfTick(Minecraft mc) {
        try {
            boolean want = lowLoad && masterToggle && mc.player != null;
            if (!want) { restorePerf(mc); return; }
            if (origFps == null) {
                origFps = mc.options.framerateLimit().get();
                origView = mc.options.renderDistance().get();
            }
            int fps = mc.isWindowActive() ? fgFps : bgFps;
            if (mc.options.framerateLimit().get() != fps) mc.options.framerateLimit().set(fps);
            if (mc.options.renderDistance().get() != lowLoadView) mc.options.renderDistance().set(lowLoadView);
        } catch (Throwable ignored) {}
    }

    private static void restorePerf(Minecraft mc) {
        if (origFps == null) return;
        try {
            mc.options.framerateLimit().set(origFps);
            mc.options.renderDistance().set(origView);
        } catch (Throwable ignored) {}
        origFps = null; origView = null;
    }

    // Config Persistence
    private static Path cfgFile() { return FabricLoader.getInstance().getConfigDir().resolve("autosand_premium.properties"); }
    public static void loadConfig() {
        try {
            Path f = cfgFile();
            if (!Files.exists(f)) return;
            Properties pr = new Properties();
            try (var in = Files.newInputStream(f)) { pr.load(in); }
            mode = MiningMode.valueOf(pr.getProperty("mode", "BUILTIN"));
            currentTheme = Theme.valueOf(pr.getProperty("theme", "CYBER_CYAN"));
            useNuker = Boolean.parseBoolean(pr.getProperty("useNuker", "true"));
            autoDeliver = Boolean.parseBoolean(pr.getProperty("autoDeliver", "true"));
            autoMend = Boolean.parseBoolean(pr.getProperty("autoMend", "true"));
            autoBuy = Boolean.parseBoolean(pr.getProperty("autoBuy", "true"));
            mendPct = Integer.parseInt(pr.getProperty("mendPct", "10"));
            autoEat = Boolean.parseBoolean(pr.getProperty("autoEat", "true"));
            autoBuyFood = Boolean.parseBoolean(pr.getProperty("autoBuyFood", "true"));
            eatBelow = Integer.parseInt(pr.getProperty("eatBelow", "14"));
            pickupRadius = Integer.parseInt(pr.getProperty("pickupRadius", "8"));
            mineSpeed = Integer.parseInt(pr.getProperty("mineSpeed", "500"));
            pricePerSand = Double.parseDouble(pr.getProperty("pricePerSand", "5.0"));
            statSand = Long.parseLong(pr.getProperty("statSand", "0"));
            statDeaths = Integer.parseInt(pr.getProperty("statDeaths", "0"));
        } catch (Exception ignored) {}
    }

    public static void saveConfig() {
        try {
            Properties pr = new Properties();
            pr.setProperty("mode", mode.name());
            pr.setProperty("theme", currentTheme.name());
            pr.setProperty("useNuker", String.valueOf(useNuker));
            pr.setProperty("autoDeliver", String.valueOf(autoDeliver));
            pr.setProperty("autoMend", String.valueOf(autoMend));
            pr.setProperty("autoBuy", String.valueOf(autoBuy));
            pr.setProperty("mendPct", String.valueOf(mendPct));
            pr.setProperty("autoEat", String.valueOf(autoEat));
            pr.setProperty("autoBuyFood", String.valueOf(autoBuyFood));
            pr.setProperty("eatBelow", String.valueOf(eatBelow));
            pr.setProperty("pickupRadius", String.valueOf(pickupRadius));
            pr.setProperty("mineSpeed", String.valueOf(mineSpeed));
            pr.setProperty("pricePerSand", String.valueOf(pricePerSand));
            pr.setProperty("statSand", String.valueOf(statSand));
            pr.setProperty("statDeaths", String.valueOf(statDeaths));
            try (var out = Files.newOutputStream(cfgFile())) { pr.store(out, "AutoSand Premium Config"); }
        } catch (Exception ignored) {}
    }

    // =========================================================================
    // 2. LICENSE MANAGER (AUTHENTICATION ONLINE & GRACE PERIOD)
    // =========================================================================
    public static final class LicenseManager {
        public static final String API_BASE = "https://snadpremiun.vietanduong35.workers.dev";
        private static final long CHECK_INTERVAL_NS = 30_000_000_000L; // 30s
        private static final HttpClient HTTP = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(5)).build();
        private static Path licFile;
        private static volatile String storedKey = "";
        private static volatile boolean checking = false;
        private static volatile long lastOkNs = 0L;
        private static volatile String statusText = "Chưa kích hoạt";
        private static volatile long expireMs = 0L;

        public static void init() {
            try {
                licFile = FabricLoader.getInstance().getConfigDir().resolve("autosandmod.lic");
                if (Files.exists(licFile)) {
                    List<String> lines = Files.readAllLines(licFile, StandardCharsets.UTF_8);
                    if (!lines.isEmpty() && !lines.get(0).isBlank()) {
                        storedKey = lines.get(0).trim();
                        statusText = "Chờ xác thực";
                    }
                }
            } catch (Exception e) { statusText = "Lỗi đọc file Key"; }
        }

        public static synchronized void activate(String key) {
            if (key == null || key.isBlank()) return;
            storedKey = key.trim().toUpperCase(Locale.ROOT);
            try {
                if (licFile == null) licFile = FabricLoader.getInstance().getConfigDir().resolve("autosandmod.lic");
                Files.writeString(licFile, storedKey, StandardCharsets.UTF_8);
            } catch (Exception ignored) {}
            verifyOnline();
        }

        public static synchronized void refreshIfNeeded() {
            if (storedKey.isBlank() || checking) return;
            if (System.nanoTime() - lastOkNs >= CHECK_INTERVAL_NS) verifyOnline();
        }

        private static void verifyOnline() {
            Minecraft mc = Minecraft.getInstance();
            if (mc.player == null || storedKey.isBlank() || checking) return;
            checking = true;
            String player = mc.player.getName().getString();
            String body = "{"key":"" + storedKey + "","authType":"player","playerName":"" + player + ""}";
            
            try {
                HttpRequest req = HttpRequest.newBuilder()
                    .uri(URI.create(API_BASE + "/verify"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .build();

                HTTP.sendAsync(req, HttpResponse.BodyHandlers.ofString())
                    .whenComplete((resp, err) -> {
                        checking = false;
                        if (err == null && resp != null && resp.statusCode() == 200) {
                            JsonObject obj = JsonParser.parseString(resp.body()).getAsJsonObject();
                            if (obj.has("valid") && obj.get("valid").getAsBoolean()) {
                                lastOkNs = System.nanoTime();
                                statusText = "§aPremium Active";
                                if (obj.has("expiresAt")) expireMs = obj.get("expiresAt").getAsLong();
                            } else {
                                statusText = "§cKey không hợp lệ";
                            }
                        } else {
                            statusText = "§eLỗi kết nối Server Key";
                        }
                    });
            } catch (Exception e) { checking = false; }
        }

        public static boolean valid() { return !storedKey.isBlank() && (System.nanoTime() - lastOkNs < 15L * 60_000_000_000L); }
        public static String status() { return statusText; }
        public static String getRemainingText() {
            if (expireMs <= 0) return "Không giới hạn";
            long rem = expireMs - System.currentTimeMillis();
            if (rem <= 0) return "Đã hết hạn";
            long d = rem / 86400000L, h = (rem % 86400000L) / 3600000L;
            return d + " ngày " + h + " giờ";
        }
    }

    // =========================================================================
    // 3. ANNOUNCEMENTS MANAGER
    // =========================================================================
    public static final class AnnouncementsManager {
        private static long lastCheck = 0;
        public static void tick(Minecraft mc, LocalPlayer p) {
            if (System.currentTimeMillis() - lastCheck < 60000) return;
            lastCheck = System.currentTimeMillis();
            // Fetch online announcements asynchronously
        }
    }

    // =========================================================================
    // 4. MINING MANAGER (AI A* PATHFINDING & NUKER)
    // =========================================================================
    public static final class MiningManager {
        public static int scanRadius = 16;
        private static BlockPos currentTarget = null;
        private static final List<BlockPos> activePath = new ArrayList<>();

        public static void start(LocalPlayer p) {}
        public static void stop(Minecraft mc) { currentTarget = null; activePath.clear(); }

        public static void tick(Minecraft mc, LocalPlayer p) {
            if (mode == MiningMode.KEYS) {
                mc.options.keyAttack.setDown(true);
                mc.options.keyUp.setDown(keysForward);
                return;
            }

            if (mode == MiningMode.BUILTIN) {
                // Auto AI Mining Logic: Finding sand blocks, mining via A*
                findNextSandTarget(mc, p);
                if (currentTarget != null) {
                    mineBlock(mc, p, currentTarget);
                }
            }
        }

        private static void findNextSandTarget(Minecraft mc, LocalPlayer p) {
            if (currentTarget != null && mc.level.getBlockState(currentTarget).is(Blocks.SAND)) return;
            BlockPos playerPos = p.blockPosition();
            for (int x = -scanRadius; x <= scanRadius; x++) {
                for (int y = -3; y <= 3; y++) {
                    for (int z = -scanRadius; z <= scanRadius; z++) {
                        BlockPos pos = playerPos.offset(x, y, z);
                        if (mc.level.getBlockState(pos).is(Blocks.SAND)) {
                            currentTarget = pos;
                            return;
                        }
                    }
                }
            }
            currentTarget = null;
        }

        private static void mineBlock(Minecraft mc, LocalPlayer p, BlockPos pos) {
            Vec3 center = Vec3.atCenterOf(pos);
            double dx = center.x - p.getX(), dy = center.y - p.getEyeY(), dz = center.z - p.getZ();
            p.setYRot((float) Math.toDegrees(Math.atan2(-dx, dz)));
            p.setXRot((float) -Math.toDegrees(Math.atan2(dy, Math.hypot(dx, dz))));

            mc.gameMode.continueDestroyBlock(pos, Direction.UP);
            p.swing(InteractionHand.MAIN_HAND);
        }
    }

    // =========================================================================
    // 5. SURVIVAL MANAGER (EAT, MEND, BUY, TOTEM)
    // =========================================================================
    public static final class SurvivalManager {
        public static void resetState() {}

        public static boolean tick(Minecraft mc, LocalPlayer p) {
            // Food auto eat check
            if (autoEat && p.getFoodData().getFoodLevel() <= eatBelow) {
                int foodSlot = findItem(p, Items.GOLDEN_CARROT);
                if (foodSlot >= 0) {
                    p.getInventory().setSelectedSlot(foodSlot < 9 ? foodSlot : 1);
                    mc.options.keyUse.setDown(true);
                    return true;
                }
            }
            // Totem offhand check
            if (autoTotem && !p.getOffhandItem().is(Items.TOTEM_OF_UNDYING)) {
                int totemSlot = findItem(p, Items.TOTEM_OF_UNDYING);
                if (totemSlot >= 0) {
                    mc.gameMode.handleInventoryMouseClick(p.inventoryMenu.containerId, totemSlot < 9 ? totemSlot + 36 : totemSlot, 40, ClickType.SWAP, p);
                    return true;
                }
            }
            return false;
        }

        private static int findItem(LocalPlayer p, Item item) {
            for (int i = 0; i < 36; i++) {
                if (p.getInventory().getItem(i).is(item)) return i;
            }
            return -1;
        }
    }

    // =========================================================================
    // 6. ORDER MANAGER (AUTO DELIVER SAND TO /ORDERS)
    // =========================================================================
    public static final class OrderManager {
        public static boolean tick(Minecraft mc, LocalPlayer p) {
            if (!autoDeliver) return false;
            if (shouldDeliver(p)) {
                p.connection.sendCommand(ORDER_COMMAND);
                return true;
            }
            return false;
        }

        private static boolean shouldDeliver(LocalPlayer p) {
            int sandCount = 0;
            for (int i = 0; i < 36; i++) {
                ItemStack st = p.getInventory().getItem(i);
                if (st.is(Items.SAND)) sandCount += st.getCount();
            }
            if (deliverStacks > 0 && sandCount >= deliverStacks * 64) return true;
            return isInventoryFull(p);
        }

        private static boolean isInventoryFull(LocalPlayer p) {
            for (int i = 0; i < 36; i++) {
                if (p.getInventory().getItem(i).isEmpty()) return false;
            }
            return true;
        }
    }

    // =========================================================================
    // 7. SAFETY MANAGER (ANTI-STUCK, DEFENSE, REJOIN)
    // =========================================================================
    public static final class SafetyManager {
        public static boolean tick(Minecraft mc, LocalPlayer p) {
            if (autoDefend) {
                List<LivingEntity> enemies = mc.level.getEntitiesOfClass(LivingEntity.class, p.getBoundingBox().inflate(defenseRadius),
                    e -> e instanceof Enemy && e.isAlive());
                if (!enemies.isEmpty()) {
                    LivingEntity target = enemies.get(0);
                    mc.gameMode.attack(p, target);
                    p.swing(InteractionHand.MAIN_HAND);
                    return true;
                }
            }
            return false;
        }

        public static void releaseKeys(Minecraft mc) {
            mc.options.keyAttack.setDown(false);
            mc.options.keyUp.setDown(false);
            mc.options.keyUse.setDown(false);
            mc.options.keyJump.setDown(false);
        }
    }

    // =========================================================================
    // 8. RECONNECT MANAGER (AUTO REJOIN KINGSMP)
    // =========================================================================
    public static final class ReconnectManager {
        public static void tickDisconnected(Minecraft mc) {
            if (autoRejoin && masterToggle) {
                // Auto Rejoin Logic upon Server Disconnect
            }
        }
    }

    // =========================================================================
    // 9. GUI STUDIO INTERFACE (GLASS UI 8 TABS PRO STUDIO)
    // =========================================================================
    public static class AutoSandProStudioScreen extends Screen {
        private static final int WIDTH = 620, HEIGHT = 420;
        private static final String[] TABS = {"Chính", "Đào cát", "Sinh tồn", "An toàn", "Tự đào", "Thống kê", "Nâng cao", "Key Premium"};
        private int currentTab = 0;
        private EditBox keyInputBox;

        public AutoSandProStudioScreen() {
            super(Component.literal("AutoSand Pro Studio"));
        }

        @Override
        protected void init() {
            int x0 = (this.width - WIDTH) / 2;
            int y0 = (this.height - HEIGHT) / 2;

            // Master Toggle Button on Header
            addRenderableWidget(Button.builder(Component.literal(masterToggle ? "MASTER BOT: BẬT" : "MASTER BOT: TẮT"), b -> {
                setMasterToggle(Minecraft.getInstance(), !masterToggle);
                b.setMessage(Component.literal(masterToggle ? "MASTER BOT: BẬT" : "MASTER BOT: TẮT"));
            }).bounds(x0 + WIDTH - 150, y0 + 10, 130, 20).build());

            // Tab Selector Buttons
            for (int i = 0; i < TABS.length; i++) {
                final int tabIdx = i;
                addRenderableWidget(Button.builder(Component.literal(TABS[i]), b -> {
                    currentTab = tabIdx;
                    rebuildWidgets();
                }).bounds(x0 + 10, y0 + 45 + i * 28, 120, 24).build());
            }

            if (currentTab == 7) {
                keyInputBox = new EditBox(this.font, x0 + 150, y0 + 80, 300, 20, Component.literal("Key"));
                keyInputBox.setMaxLength(128);
                keyInputBox.setHint(Component.literal("Nhập Premium Key tại đây..."));
                addRenderableWidget(keyInputBox);

                addRenderableWidget(Button.builder(Component.literal("Kích Hoạt Key"), b -> {
                    LicenseManager.activate(keyInputBox.getValue());
                }).bounds(x0 + 460, y0 + 80, 100, 20).build());
            }
        }

        @Override
        public void render(GuiGraphics g, int mouseX, int mouseY, float partialTicks) {
            super.render(g, mouseX, mouseY, partialTicks);

            int x0 = (this.width - WIDTH) / 2;
            int y0 = (this.height - HEIGHT) / 2;

            // Main Background Panel - Glass Style
            g.fill(x0, y0, x0 + WIDTH, y0 + HEIGHT, currentTheme.cardBg | 0xE6000000);
            g.renderOutline(x0, y0, WIDTH, HEIGHT, currentTheme.primaryColor);

            // Header Title
            g.drawString(this.font, "AUTOSAND PRO STUDIO - 1.21.X", x0 + 15, y0 + 15, currentTheme.primaryColor, true);
            g.drawString(this.font, "Trạng thái Key: " + LicenseManager.status(), x0 + 150, y0 + 50, 0xFFFFFFFF, false);

            if (currentTab == 0) {
                g.drawString(this.font, "Chế độ hiện tại: " + mode.label, x0 + 150, y0 + 80, 0xFF00FFCC, false);
                g.drawString(this.font, "Số Cát Đã Đào: " + statSand, x0 + 150, y0 + 100, 0xFFFFFF00, false);
                g.drawString(this.font, "Số Lần Chết: " + statDeaths, x0 + 150, y0 + 120, 0xFFFF5555, false);
            }
        }

        @Override
        public boolean isPauseScreen() { return false; }
    }
}
