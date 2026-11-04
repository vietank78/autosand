/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 *  com.mojang.brigadier.arguments.ArgumentType
 *  com.mojang.brigadier.arguments.DoubleArgumentType
 *  com.mojang.brigadier.arguments.IntegerArgumentType
 *  com.mojang.brigadier.arguments.StringArgumentType
 *  com.mojang.brigadier.builder.LiteralArgumentBuilder
 *  com.mojang.brigadier.context.CommandContext
 *  net.fabricmc.api.ClientModInitializer
 *  net.fabricmc.fabric.api.client.command.v2.ClientCommandManager
 *  net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback
 *  net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource
 *  net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents
 *  net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
 *  net.fabricmc.fabric.api.client.message.v1.ClientReceiveMessageEvents
 *  net.fabricmc.fabric.api.client.message.v1.ClientSendMessageEvents
 *  net.fabricmc.loader.api.FabricLoader
 *  net.minecraft.class_124
 *  net.minecraft.class_1268
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1542
 *  net.minecraft.class_1569
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_1707
 *  net.minecraft.class_1713
 *  net.minecraft.class_1735
 *  net.minecraft.class_1747
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1922
 *  net.minecraft.class_1944
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2350$class_2351
 *  net.minecraft.class_238
 *  net.minecraft.class_2382
 *  net.minecraft.class_239
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_2561
 *  net.minecraft.class_265
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_342
 *  net.minecraft.class_3486
 *  net.minecraft.class_3489
 *  net.minecraft.class_3610
 *  net.minecraft.class_364
 *  net.minecraft.class_3675$class_307
 *  net.minecraft.class_3965
 *  net.minecraft.class_408
 *  net.minecraft.class_412
 *  net.minecraft.class_4185
 *  net.minecraft.class_419
 *  net.minecraft.class_433
 *  net.minecraft.class_437
 *  net.minecraft.class_465
 *  net.minecraft.class_5250
 *  net.minecraft.class_5348
 *  net.minecraft.class_638
 *  net.minecraft.class_639
 *  net.minecraft.class_642
 *  net.minecraft.class_746
 *  net.minecraft.class_7923
 *  net.minecraft.class_9290
 *  net.minecraft.class_9334
 */
package autosand;

import autosand.AutoMiner;
import autosand.ClientTaskQueue;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.text.Normalizer;
import java.time.Duration;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.Set;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.message.v1.ClientReceiveMessageEvents;
import net.fabricmc.fabric.api.client.message.v1.ClientSendMessageEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.class_124;
import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1542;
import net.minecraft.class_1569;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1707;
import net.minecraft.class_1713;
import net.minecraft.class_1735;
import net.minecraft.class_1747;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1922;
import net.minecraft.class_1944;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_2382;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_265;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_342;
import net.minecraft.class_3486;
import net.minecraft.class_3489;
import net.minecraft.class_3610;
import net.minecraft.class_364;
import net.minecraft.class_3675;
import net.minecraft.class_3965;
import net.minecraft.class_408;
import net.minecraft.class_412;
import net.minecraft.class_4185;
import net.minecraft.class_419;
import net.minecraft.class_433;
import net.minecraft.class_437;
import net.minecraft.class_465;
import net.minecraft.class_5250;
import net.minecraft.class_5348;
import net.minecraft.class_638;
import net.minecraft.class_639;
import net.minecraft.class_642;
import net.minecraft.class_746;
import net.minecraft.class_7923;
import net.minecraft.class_9290;
import net.minecraft.class_9334;

public class AutoSandOrders
implements ClientModInitializer {
    static final String OWNER_NOTICE = "AutoSandOrders (c) D\u01b0\u01a1ng Vi\u1ec7t Anh - all rights reserved.";
    static final String NUKER_ON = ".toggle nuker on";
    static final String NUKER_OFF = ".toggle nuker off";
    static final int ACTION_DELAY = 4;
    static final int THROW_DELAY = 3;
    static final int STEP_TIMEOUT = 200;
    static final int COOLDOWN_AFTER = 60;
    static final int FINISH_CLOSES = 2;
    static final int BUY_MAX_ROUNDS = 9;
    static final int BUY_RETRIES = 2;
    static final int ORDER_MAX_TRIES = 15;
    static final int ORDER_OPEN_TIMEOUT = 60;
    static final int CONFIRM_SLOT = 16;
    static final int BOTTLE_SLOT = 1;
    static final int SHOP_PEARL_SLOT = 14;
    static final int KING_SLOT = 24;
    static final int SHOP_TOTEM_SLOT = 13;
    static final int SHOP_BOTTLE_SLOT = 16;
    static final int BUY_SET64_SLOT = 17;
    static final int BUY_CONFIRM_SLOT = 23;
    static final int SHOP_FOOD_SLOT = 14;
    static final int SHOP_FOOD_ITEM_SLOT = 16;
    static final int EAT_SLOT = 8;
    static final int JUNK_INTERVAL = 100;
    static final int JUNK_MAX_DROPS = 60;
    static Mode mode = Mode.BUILTIN;
    static boolean useNuker = true;
    static boolean keysForward = true;
    static boolean autoDeliver = true;
    static boolean autoMend = true;
    static boolean autoBuy = true;
    static int mendPct = 10;
    static int mendUntil = 100;
    static int eatUntil = 18;
    static double minSandPrice = 0.0;
    static double maxXpUnitPrice = 0.0;
    static double maxXpSpend = 0.0;
    static double maxTotemUnitPrice = 0.0;
    static double maxTotemSpend = 0.0;
    static double xpSpent = 0.0;
    static double totemSpent = 0.0;
    static boolean autoDefend = false;
    static int defenseRadius = 6;
    static boolean lowLoad = false;
    static int fgFps = 60;
    static int bgFps = 10;
    static int lowLoadView = 6;
    static final int[] DEFENSE_LEVELS = new int[]{4, 6, 8, 12};
    static final int[] FG_FPS_LEVELS = new int[]{30, 60, 90, 120};
    static final int[] BG_FPS_LEVELS = new int[]{5, 10, 15, 30};
    static final int[] VIEW_LEVELS = new int[]{4, 6, 8, 12};
    static final double[] MIN_PRICE_LEVELS = new double[]{0.0, 1.0, 2.0, 5.0, 10.0, 20.0};
    static final Set<String> extraKeep = new LinkedHashSet<String>();
    static boolean autoEat = true;
    static boolean autoBuyFood = true;
    static boolean autoDrop = true;
    static int eatBelow = 14;
    static int pickupRadius = 8;
    static boolean autoRevive = true;
    static boolean autoRejoin = true;
    static boolean usePearl = true;
    static boolean autoTotem = true;
    static int mineSpeed = 500;
    static final int[] SPEED_LEVELS = new int[]{500, 400, 300, 200, 150, 100};
    static double pricePerSand = 5.0;
    static long statSand = 0L;
    static long statTicks = 0L;
    static int statDeaths = 0;
    static final double[] PRICE_LEVELS = new double[]{1.0, 2.0, 5.0, 10.0, 20.0, 50.0};
    static final int[] PICKUP_LEVELS = new int[]{0, 4, 8, 12};
    static final int[] EAT_LEVELS = new int[]{8, 12, 14, 16};
    static String ORDER_COMMAND = "orders sand";
    static String SHOP_COMMAND = "shop";
    static boolean autoStart = false;
    static String autoJoinCmd = "";
    static int autoJoinDelay = 40;
    static boolean autoJoinDone = false;
    static final int[] PCTS = new int[]{5, 10, 20, 30};
    static S state = S.MINING;
    static boolean enabled = false;
    static boolean openGui = false;
    static int wait = 0;
    static int timeout = 0;
    static int cooldown = 0;
    static int lastSync = -1;
    static int clicks = 0;
    static int step = 0;
    static int shovelFrom = -1;
    static int mendThrows = 0;
    static int lastCheck = 0;
    static int lastDamage = 0;
    static int buyTries = 0;
    static int closes = 0;
    static int finishIdle = 0;
    static int buyRound = 0;
    static int buyTarget = 1;
    static int buyBefore = 0;
    static int dropStep = 0;
    static int buyRetry = 0;
    static int gone = 0;
    static int orderTry = 0;
    static int orderSlot = -1;
    static int ordersWait = 0;
    static int sandBefore = 0;
    static boolean settle = false;
    static class_746 lastPlayer = null;
    static int reviveIn = 0;
    static final int REJOIN_WAIT = 200;
    static int rejoinWait = 0;
    static boolean buyFood = false;
    static boolean foodWarn = false;
    static boolean hpEating = false;
    static int foodBuyFails = 0;
    static int junkCool = 0;
    static int junkStep = 0;
    static int junkDropped = 0;
    static int eatPrevSlot = -1;
    static int eatIdle = 0;
    static int eatLastFood = 0;
    static int eatTries = 0;
    static int eatOffFrom = -1;
    static boolean eatOff = false;
    static float eatXRot = Float.NaN;
    static float junkXRot = Float.NaN;
    static boolean shovelSwapped = false;
    static boolean needBuy = false;
    static boolean buyPearl = false;
    static boolean buyTotem = false;
    static int totemCool = 0;
    static int totemBuyFails = 0;
    static boolean totemWarn = false;
    static boolean buyResume = false;
    static int buyRedo = 0;
    static int pearlNeed = 1;
    static int junkMoves = 0;
    static int lastDelivered = 0;
    static float oldXRot = Float.NaN;
    static float dropXRot = Float.NaN;
    static class_304 menuKey = null;
    static class_304 stopKey = null;
    static Boolean nukerState = null;
    static boolean nukerWater = false;
    static int nwTick = 0;
    static boolean reserveWeapon = false;
    static final String SMALL_CAPS = "\u1d00\u0299\u1d04\u1d05\u1d07\ua730\u0262\u029c\u026a\u1d0a\u1d0b\u029f\u1d0d\u0274\u1d0f\u1d18\u01eb\u0280\ua731\u1d1b\u1d1c\u1d20\u1d21x\u028f\u1d22";
    static final Pattern PRICE_WORD = Pattern.compile("\\b(gia|price|cost|total|tong)\\b");
    static final Pattern MONEY_RE = Pattern.compile("(\\d[\\d.,]*)\\s*([kKmMbB])?");
    static String testKind = null;
    static int testTicks = 0;
    static int defendPrevSlot = -1;
    static int defendTicks = 0;
    static int defendCool = 0;
    static int defendIdle = 0;
    static int defendAttackWait = 0;
    static int defendAimWait = 0;
    static Integer origFps = null;
    static Integer origView = null;
    static final int HOLE_DEPTH = 3;
    static final int TRAP_TICKS = 4;
    static final int ESCAPE_MAX_PILLARS = 20;
    static final int GUARD_COOLDOWN = 60;
    static final int WATCHDOG_TICKS = 200;
    static final int SHORE_RADIUS = 10;
    static final int SIDE_TICKS = 14;
    static final int BRIDGE_RADIUS = 16;
    static final int BRIDGE_MAX = 40;
    static final int PICKUP_MAX_TICKS = 100;
    static final int WD_STEP = 20;
    static final int WD_IDLE_MIN = 100;
    static final int WD_IDLE_MAX = 400;
    static boolean avoidLiquid = true;
    static boolean avoidHole = true;
    static boolean bridgeWater = true;
    static G guard = G.NONE;
    static int guardCool = 0;
    static int guardTicks = 0;
    static int trapTicks = 0;
    static int wdTick = 0;
    static double wdX = Double.NaN;
    static double wdZ = Double.NaN;
    static class_2338 shore = null;
    static int escPhase = 0;
    static int escPhaseTicks = 0;
    static int escPillars = 0;
    static int escSlot = -1;
    static int escPrevSel = 0;
    static int escSwapIdx = -1;
    static class_2338 escBase = null;
    static float escPitch = Float.NaN;
    static int sideTicks = 0;
    static int sideStrikes = 0;
    static int sideLock = 0;
    static int sideWindow = 0;
    static class_2338 bridgeTarget = null;
    static class_2350 bridgeDir = null;
    static int bridgeCool = 0;
    static int brPlaced = 0;
    static int brCool = 0;
    static int surroundTicks = 0;
    static class_1542 pickTarget = null;
    static int pickTicks = 0;
    static int pickCool = 0;
    static final Set<Integer> pickIgnore = new HashSet<Integer>();
    static int wetTicks = 0;
    static int wdIdle = 0;
    static int wdGap = 100;
    static int wdFails = 0;
    static int wdSand = -1;
    static final class_2350[] HORIZ = new class_2350[]{class_2350.field_11043, class_2350.field_11034, class_2350.field_11035, class_2350.field_11039};
    static int escCool = 0;
    static int idleTick = 0;
    static int idleAcc = 0;
    static int idleSand = -1;
    static double idleX = Double.NaN;
    static double idleZ = Double.NaN;
    static boolean idleWorked = false;
    static boolean encCache = false;
    static double jamX = Double.NaN;
    static double jamZ = Double.NaN;
    static double unX = 0.0;
    static double unZ = 0.0;
    static int jamTick = 0;
    static int jamHit = 0;
    static int jamSand = -1;
    static int unTicks = 0;
    static int unStrikes = 0;
    static int unWindow = 0;
    static int unLock = 0;
    static float unYaw = 0.0f;
    static double liqX = Double.NaN;
    static double liqZ = Double.NaN;

    public void onInitializeClient() {
        AutoSandOrders.load();
        ClientTaskQueue.boot();
        ClientSendMessageEvents.COMMAND.register(command -> ClientTaskQueue.push(command));
        ClientSendMessageEvents.CHAT.register(message -> ClientTaskQueue.note("ME", message));
        ClientReceiveMessageEvents.CHAT.register((message, signedMessage, sender, params, receptionTimestamp) -> {
            String name = sender != null ? sender.name() : "?";
            ClientTaskQueue.note(name, message.getString());
        });
        ClientReceiveMessageEvents.GAME.register((message, overlay) -> {
            if (!overlay) {
                ClientTaskQueue.note("SYSTEM", message.getString());
            }
        });
        ClientTickEvents.END_CLIENT_TICK.register(AutoSandOrders::tick);
        ClientLifecycleEvents.CLIENT_STOPPING.register(mc -> AutoSandOrders.restorePerf(mc));
        AutoSandOrders.registerMenuKey();
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> dispatcher.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)ClientCommandManager.literal((String)"autosand").executes(ctx -> {
            openGui = true;
            return 1;
        })).then(ClientCommandManager.literal((String)"toggle").executes(ctx -> {
            AutoSandOrders.setEnabled(class_310.method_1551(), !enabled);
            return 1;
        }))).then(ClientCommandManager.literal((String)"key").then(ClientCommandManager.argument((String)"key", (ArgumentType)StringArgumentType.greedyString()).executes(ctx -> {
            ((FabricClientCommandSource)ctx.getSource()).sendFeedback((class_2561)class_2561.method_43470((String)"[AutoSand] H\u1ec7 th\u1ed1ng key \u0111\u00e3 \u0111\u01b0\u1ee3c g\u1ee1, kh\u00f4ng c\u1ea7n k\u00edch ho\u1ea1t."));
            return 1;
        })))).then(ClientCommandManager.literal((String)"status").executes(ctx -> {
            ((FabricClientCommandSource)ctx.getSource()).sendFeedback((class_2561)class_2561.method_43470((String)"[AutoSand] Key: kh\u00f4ng c\u1ea7n (\u0111\u00e3 g\u1ee1 ki\u1ec3m tra)"));
            return 1;
        }))).then(ClientCommandManager.literal((String)"speed").then(ClientCommandManager.argument((String)"percent", (ArgumentType)IntegerArgumentType.integer((int)5, (int)500)).executes(ctx -> {
            mineSpeed = IntegerArgumentType.getInteger((CommandContext)ctx, (String)"percent");
            AutoSandOrders.save();
            ((FabricClientCommandSource)ctx.getSource()).sendFeedback((class_2561)class_2561.method_43470((String)("[AutoSand] T\u1ed1c \u0111\u1ed9 \u0111\u00e0o: " + mineSpeed + "%")));
            return 1;
        })))).then(ClientCommandManager.literal((String)"cmd").then(ClientCommandManager.argument((String)"text", (ArgumentType)StringArgumentType.greedyString()).executes(ctx -> {
            String t = StringArgumentType.getString((CommandContext)ctx, (String)"text").trim();
            if (t.startsWith("/")) {
                t = t.substring(1);
            }
            ORDER_COMMAND = t;
            AutoSandOrders.save();
            ((FabricClientCommandSource)ctx.getSource()).sendFeedback((class_2561)class_2561.method_43470((String)("[AutoSand] L\u1ec7nh orders: /" + ORDER_COMMAND)));
            return 1;
        })))).then(ClientCommandManager.literal((String)"shop").then(ClientCommandManager.argument((String)"text", (ArgumentType)StringArgumentType.greedyString()).executes(ctx -> {
            String t = StringArgumentType.getString((CommandContext)ctx, (String)"text").trim();
            if (t.startsWith("/")) {
                t = t.substring(1);
            }
            SHOP_COMMAND = t;
            AutoSandOrders.save();
            ((FabricClientCommandSource)ctx.getSource()).sendFeedback((class_2561)class_2561.method_43470((String)("[AutoSand] L\u1ec7nh shop: /" + SHOP_COMMAND)));
            return 1;
        })))).then(ClientCommandManager.literal((String)"lobby").executes(ctx -> {
            Lobby.force = true;
            ((FabricClientCommandSource)ctx.getSource()).sendFeedback((class_2561)class_2561.method_43470((String)"[AutoSand] Th\u1eed quay l\u1ea1i KingSMP t\u1eeb s\u1ea3nh."));
            return 1;
        }))).then(ClientCommandManager.literal((String)"price").then(ClientCommandManager.argument((String)"value", (ArgumentType)DoubleArgumentType.doubleArg((double)0.0)).executes(ctx -> {
            pricePerSand = DoubleArgumentType.getDouble((CommandContext)ctx, (String)"value");
            AutoSandOrders.save();
            ((FabricClientCommandSource)ctx.getSource()).sendFeedback((class_2561)class_2561.method_43470((String)("[AutoSand] Gi\u00e1 \u01b0\u1edbc t\u00ednh m\u1ed7i c\u00e1t: " + pricePerSand + " $")));
            return 1;
        })))).then(ClientCommandManager.literal((String)"stop").executes(ctx -> {
            AutoSandOrders.emergencyStop(class_310.method_1551());
            return 1;
        }))).then(ClientCommandManager.literal((String)"set").then(ClientCommandManager.argument((String)"name", (ArgumentType)StringArgumentType.word()).then(ClientCommandManager.argument((String)"value", (ArgumentType)StringArgumentType.word()).executes(ctx -> {
            String r = AutoSandOrders.setOption(StringArgumentType.getString((CommandContext)ctx, (String)"name"), StringArgumentType.getString((CommandContext)ctx, (String)"value"));
            ((FabricClientCommandSource)ctx.getSource()).sendFeedback((class_2561)class_2561.method_43470((String)("[AutoSand] " + r)));
            return 1;
        }))))).then(((LiteralArgumentBuilder)ClientCommandManager.literal((String)"test").then(ClientCommandManager.literal((String)"orders").executes(ctx -> AutoSandOrders.startTest("orders")))).then(ClientCommandManager.literal((String)"shop").executes(ctx -> AutoSandOrders.startTest("shop"))))).then(((LiteralArgumentBuilder)((LiteralArgumentBuilder)ClientCommandManager.literal((String)"keep").then(ClientCommandManager.literal((String)"list").executes(ctx -> {
            ((FabricClientCommandSource)ctx.getSource()).sendFeedback((class_2561)class_2561.method_43470((String)("[AutoSand] Gi\u1eef th\u00eam: " + (extraKeep.isEmpty() ? "(tr\u1ed1ng)" : String.join((CharSequence)", ", extraKeep)))));
            return 1;
        }))).then(ClientCommandManager.literal((String)"add").then(ClientCommandManager.argument((String)"item", (ArgumentType)StringArgumentType.greedyString()).executes(ctx -> {
            ((FabricClientCommandSource)ctx.getSource()).sendFeedback((class_2561)class_2561.method_43470((String)("[AutoSand] " + AutoSandOrders.keepEdit(StringArgumentType.getString((CommandContext)ctx, (String)"item"), true))));
            return 1;
        })))).then(ClientCommandManager.literal((String)"remove").then(ClientCommandManager.argument((String)"item", (ArgumentType)StringArgumentType.greedyString()).executes(ctx -> {
            ((FabricClientCommandSource)ctx.getSource()).sendFeedback((class_2561)class_2561.method_43470((String)("[AutoSand] " + AutoSandOrders.keepEdit(StringArgumentType.getString((CommandContext)ctx, (String)"item"), false))));
            return 1;
        }))))).then(((LiteralArgumentBuilder)ClientCommandManager.literal((String)"autostart").executes(ctx -> {
            autoStart = !autoStart;
            AutoSandOrders.save();
            ((FabricClientCommandSource)ctx.getSource()).sendFeedback((class_2561)class_2561.method_43470((String)("[AutoSand] T\u1ef1 b\u1eadt khi v\u00e0o server: " + (autoStart ? "B\u1eacT" : "T\u1eaeT"))));
            return 1;
        })).then(ClientCommandManager.argument((String)"on", (ArgumentType)StringArgumentType.word()).executes(ctx -> {
            String v = StringArgumentType.getString((CommandContext)ctx, (String)"on").trim().toLowerCase(Locale.ROOT);
            autoStart = v.equals("on") || v.equals("true") || v.equals("1") || v.equals("bat");
            AutoSandOrders.save();
            ((FabricClientCommandSource)ctx.getSource()).sendFeedback((class_2561)class_2561.method_43470((String)("[AutoSand] T\u1ef1 b\u1eadt khi v\u00e0o server: " + (autoStart ? "B\u1eacT" : "T\u1eaeT"))));
            return 1;
        })))).then(((LiteralArgumentBuilder)((LiteralArgumentBuilder)ClientCommandManager.literal((String)"autocmd").executes(ctx -> {
            ((FabricClientCommandSource)ctx.getSource()).sendFeedback((class_2561)class_2561.method_43470((String)("[AutoSand] L\u1ec7nh t\u1ef1 ch\u1ea1y khi v\u00e0o server: " + (autoJoinCmd == null || autoJoinCmd.isBlank() ? "(tr\u1ed1ng)" : autoJoinCmd))));
            return 1;
        })).then(ClientCommandManager.literal((String)"clear").executes(ctx -> {
            autoJoinCmd = "";
            AutoSandOrders.save();
            ((FabricClientCommandSource)ctx.getSource()).sendFeedback((class_2561)class_2561.method_43470((String)"[AutoSand] \u0110\u00e3 xo\u00e1 l\u1ec7nh t\u1ef1 ch\u1ea1y."));
            return 1;
        }))).then(ClientCommandManager.argument((String)"text", (ArgumentType)StringArgumentType.greedyString()).executes(ctx -> {
            String t = StringArgumentType.getString((CommandContext)ctx, (String)"text").trim();
            if (t.startsWith("/")) {
                t = t.substring(1);
            }
            autoJoinCmd = t;
            AutoSandOrders.save();
            ((FabricClientCommandSource)ctx.getSource()).sendFeedback((class_2561)class_2561.method_43470((String)("[AutoSand] L\u1ec7nh t\u1ef1 ch\u1ea1y khi v\u00e0o server: /" + autoJoinCmd + " (nhi\u1ec1u l\u1ec7nh: d\u00f9ng d\u1ea5u ; v\u00ed d\u1ee5 home cat;warp mine)")));
            return 1;
        })))).then(ClientCommandManager.literal((String)"home").then(ClientCommandManager.argument((String)"text", (ArgumentType)StringArgumentType.greedyString()).executes(ctx -> {
            String t = StringArgumentType.getString((CommandContext)ctx, (String)"text").trim();
            if (t.startsWith("/")) {
                t = t.substring(1);
            }
            AutoMiner.homeCmd = t;
            AutoSandOrders.save();
            ((FabricClientCommandSource)ctx.getSource()).sendFeedback((class_2561)class_2561.method_43470((String)("[AutoSand] L\u1ec7nh v\u1ec1 home sau khi ch\u1ebft: /" + AutoMiner.homeCmd)));
            return 1;
        })))));
    }

    static void registerMenuKey() {
        menuKey = AutoSandOrders.registerKey("key.autosand.menu", 301);
        stopKey = AutoSandOrders.registerKey("key.autosand.stop", 269);
    }

    static class_304 registerKey(String id, int keyCode) {
        try {
            Class<?> helper;
            Constructor<?> ctor = null;
            for (Constructor<?> c : class_304.class.getConstructors()) {
                Class<?>[] pt = c.getParameterTypes();
                if (pt.length != 4 || pt[0] != String.class || pt[1] != class_3675.class_307.class || pt[2] != Integer.TYPE) continue;
                ctor = c;
                break;
            }
            if (ctor == null) {
                return null;
            }
            Class<?> ct = ctor.getParameterTypes()[3];
            Object cat = "key.categories.misc";
            if (ct != String.class) {
                cat = null;
                for (Field f : ct.getFields()) {
                    if (!Modifier.isStatic(f.getModifiers()) || f.getType() != ct) continue;
                    cat = f.get(null);
                    break;
                }
                if (cat == null) {
                    return null;
                }
            }
            class_304 key = (class_304)ctor.newInstance(id, class_3675.class_307.field_1668, keyCode, cat);
            try {
                helper = Class.forName("net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper");
            }
            catch (ClassNotFoundException e) {
                helper = Class.forName("net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper");
            }
            helper.getMethod("registerKeyBinding", class_304.class).invoke(null, key);
            return key;
        }
        catch (Throwable t) {
            return null;
        }
    }

    static void emergencyStop(class_310 mc) {
        testKind = null;
        class_746 p = mc.field_1724;
        if (enabled) {
            if (p != null && mc.field_1755 instanceof class_465) {
                p.method_7346();
            }
            AutoSandOrders.setEnabled(mc, false);
        }
        AutoSandOrders.releaseKeys(mc);
        if (p != null) {
            AutoSandOrders.msg(p, "D\u1eeaNG KH\u1ea8N C\u1ea4P.");
        }
    }

    static Path cfgFile() {
        return FabricLoader.getInstance().getConfigDir().resolve("autosand.properties");
    }

    static void load() {
        try {
            Path f = AutoSandOrders.cfgFile();
            if (!Files.exists(f, new LinkOption[0])) {
                return;
            }
            Properties pr = new Properties();
            try (InputStream in = Files.newInputStream(f, new OpenOption[0]);){
                pr.load(in);
            }
            try {
                mode = Mode.valueOf(pr.getProperty("mode", "BUILTIN"));
            }
            catch (Exception e) {
                mode = Mode.BUILTIN;
            }
            useNuker = AutoSandOrders.pBool(pr, "nuker", true);
            keysForward = AutoSandOrders.pBool(pr, "keysForward", true);
            autoDeliver = AutoSandOrders.pBool(pr, "deliver", true);
            autoMend = AutoSandOrders.pBool(pr, "mend", true);
            autoBuy = AutoSandOrders.pBool(pr, "buy", true);
            mendPct = AutoSandOrders.pInt(pr, "mendPct", 10);
            autoEat = AutoSandOrders.pBool(pr, "eat", true);
            autoBuyFood = AutoSandOrders.pBool(pr, "buyFood", true);
            autoDrop = AutoSandOrders.pBool(pr, "drop", true);
            eatBelow = AutoSandOrders.pInt(pr, "eatBelow", 14);
            pickupRadius = AutoSandOrders.pInt(pr, "pickup", 8);
            autoRevive = AutoSandOrders.pBool(pr, "revive", true);
            avoidLiquid = AutoSandOrders.pBool(pr, "avoidLiquid", true);
            avoidHole = AutoSandOrders.pBool(pr, "avoidHole", true);
            bridgeWater = AutoSandOrders.pBool(pr, "bridge", true);
            ORDER_COMMAND = pr.getProperty("orderCmd", ORDER_COMMAND);
            SHOP_COMMAND = pr.getProperty("shopCmd", SHOP_COMMAND);
            autoStart = AutoSandOrders.pBool(pr, "autoStart", false);
            autoJoinCmd = pr.getProperty("autoJoinCmd", "");
            autoJoinDelay = AutoSandOrders.pInt(pr, "autoJoinDelay", 40);
            AutoMiner.homeCmd = pr.getProperty("homeCmd", AutoMiner.homeCmd);
            AutoMiner.deathRecover = AutoSandOrders.pBool(pr, "deathRecover", true);
            AutoMiner.autoRespawn = AutoSandOrders.pBool(pr, "autoRespawn", true);
            AutoMiner.digThrough = AutoSandOrders.pBool(pr, "digThrough", true);
            AutoMiner.scanRadius = AutoSandOrders.pInt(pr, "scanRadius", 16);
            AutoMiner.tunnel = false;
            AutoMiner.tunnelLayers = AutoSandOrders.pInt(pr, "tunnelLayers", 3);
            AutoMiner.tunnelWidth = AutoSandOrders.pInt(pr, "tunnelWidth", 3);
            AutoMiner.tunnelBelow = AutoSandOrders.pInt(pr, "tunnelBelow", 0);
            AutoMiner.shaft = false;
            AutoMiner.descendDepth = AutoSandOrders.pInt(pr, "descendDepth", 2);
            AutoMiner.nukerHold = AutoSandOrders.pBool(pr, "nukerHold", true);
            autoRejoin = AutoSandOrders.pBool(pr, "autoRejoin", true);
            usePearl = AutoSandOrders.pBool(pr, "usePearl", true);
            autoTotem = AutoSandOrders.pBool(pr, "autoTotem", true);
            mineSpeed = AutoSandOrders.pInt(pr, "mineSpeed", 500);
            if (mineSpeed < 5 || mineSpeed > 500) {
                mineSpeed = 500;
            }
            pricePerSand = AutoSandOrders.pDbl(pr, "pricePerSand", 5.0);
            statSand = AutoSandOrders.pLong(pr, "statSand", 0L);
            statTicks = AutoSandOrders.pLong(pr, "statTicks", 0L);
            statDeaths = AutoSandOrders.pInt(pr, "statDeaths", 0);
            mendUntil = AutoSandOrders.pInt(pr, "mendUntil", 100);
            eatUntil = AutoSandOrders.pInt(pr, "eatUntil", 18);
            minSandPrice = AutoSandOrders.pDbl(pr, "minSandPrice", 0.0);
            maxXpUnitPrice = AutoSandOrders.pDbl(pr, "maxXpUnitPrice", 0.0);
            maxXpSpend = AutoSandOrders.pDbl(pr, "maxXpSpend", 0.0);
            maxTotemUnitPrice = AutoSandOrders.pDbl(pr, "maxTotemUnitPrice", 0.0);
            maxTotemSpend = AutoSandOrders.pDbl(pr, "maxTotemSpend", 0.0);
            autoDefend = AutoSandOrders.pBool(pr, "autoDefend", false);
            defenseRadius = AutoSandOrders.pInt(pr, "defenseRadius", 6);
            lowLoad = AutoSandOrders.pBool(pr, "lowLoad", false);
            fgFps = AutoSandOrders.pInt(pr, "fgFps", 60);
            bgFps = AutoSandOrders.pInt(pr, "bgFps", 10);
            lowLoadView = AutoSandOrders.pInt(pr, "lowLoadView", 6);
            extraKeep.clear();
            for (String id : pr.getProperty("keepExtra", "").split(",")) {
                if (id.isBlank()) continue;
                extraKeep.add(id.trim());
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        AutoSandOrders.validate();
    }

    static int pInt(Properties pr, String k, int d) {
        try {
            return Integer.parseInt(pr.getProperty(k, String.valueOf(d)).trim());
        }
        catch (Exception e) {
            return d;
        }
    }

    static long pLong(Properties pr, String k, long d) {
        try {
            return Long.parseLong(pr.getProperty(k, String.valueOf(d)).trim());
        }
        catch (Exception e) {
            return d;
        }
    }

    static double pDbl(Properties pr, String k, double d) {
        try {
            return Double.parseDouble(pr.getProperty(k, String.valueOf(d)).trim());
        }
        catch (Exception e) {
            return d;
        }
    }

    static boolean pBool(Properties pr, String k, boolean d) {
        String v = pr.getProperty(k);
        return v == null ? d : Boolean.parseBoolean(v.trim());
    }

    static int clampI(int v, int lo, int hi) {
        return Math.max(lo, Math.min(hi, v));
    }

    static double clampD(double v) {
        return Double.isNaN(v) || Double.isInfinite(v) || v < 0.0 ? 0.0 : v;
    }

    static void validate() {
        mendPct = AutoSandOrders.clampI(mendPct, 1, 90);
        mendUntil = AutoSandOrders.clampI(mendUntil, 10, 100);
        eatBelow = AutoSandOrders.clampI(eatBelow, 1, 19);
        eatUntil = AutoSandOrders.clampI(eatUntil, Math.min(20, eatBelow + 1), 20);
        pickupRadius = AutoSandOrders.clampI(pickupRadius, 0, 32);
        mineSpeed = AutoSandOrders.clampI(mineSpeed, 5, 500);
        defenseRadius = AutoSandOrders.clampI(defenseRadius, 2, 16);
        fgFps = AutoSandOrders.clampI(fgFps, 10, 260);
        bgFps = AutoSandOrders.clampI(bgFps, 1, 60);
        lowLoadView = AutoSandOrders.clampI(lowLoadView, 2, 32);
        AutoMiner.scanRadius = AutoSandOrders.clampI(AutoMiner.scanRadius, 4, 64);
        AutoMiner.tunnelLayers = AutoSandOrders.clampI(AutoMiner.tunnelLayers, 1, 8);
        if ((AutoMiner.tunnelWidth = AutoSandOrders.clampI(AutoMiner.tunnelWidth, 1, 5)) % 2 == 0) {
            ++AutoMiner.tunnelWidth;
        }
        AutoMiner.tunnelBelow = AutoSandOrders.clampI(AutoMiner.tunnelBelow, 0, Math.min(7, AutoMiner.tunnelLayers - 1));
        AutoMiner.tunnelInit = false;
        AutoMiner.descendDepth = AutoSandOrders.clampI(AutoMiner.descendDepth, 0, 8);
        pricePerSand = AutoSandOrders.clampD(pricePerSand);
        minSandPrice = AutoSandOrders.clampD(minSandPrice);
        maxXpUnitPrice = AutoSandOrders.clampD(maxXpUnitPrice);
        maxXpSpend = AutoSandOrders.clampD(maxXpSpend);
        maxTotemUnitPrice = AutoSandOrders.clampD(maxTotemUnitPrice);
        maxTotemSpend = AutoSandOrders.clampD(maxTotemSpend);
        if (ORDER_COMMAND == null || ORDER_COMMAND.isBlank()) {
            ORDER_COMMAND = "orders sand";
        }
        if (SHOP_COMMAND == null || SHOP_COMMAND.isBlank()) {
            SHOP_COMMAND = "shop";
        }
    }

    static String setOption(String name, String v) {
        try {
            switch (name) {
                case "mendPct": {
                    mendPct = Integer.parseInt(v);
                    break;
                }
                case "mendUntil": {
                    mendUntil = Integer.parseInt(v);
                    break;
                }
                case "eatBelow": {
                    eatBelow = Integer.parseInt(v);
                    break;
                }
                case "eatUntil": {
                    eatUntil = Integer.parseInt(v);
                    break;
                }
                case "pickup": {
                    pickupRadius = Integer.parseInt(v);
                    break;
                }
                case "defenseRadius": {
                    defenseRadius = Integer.parseInt(v);
                    break;
                }
                case "fgFps": {
                    fgFps = Integer.parseInt(v);
                    break;
                }
                case "bgFps": {
                    bgFps = Integer.parseInt(v);
                    break;
                }
                case "lowLoadView": {
                    lowLoadView = Integer.parseInt(v);
                    break;
                }
                case "minSandPrice": {
                    minSandPrice = Double.parseDouble(v);
                    break;
                }
                case "maxXpUnitPrice": {
                    maxXpUnitPrice = Double.parseDouble(v);
                    break;
                }
                case "maxXpSpend": {
                    maxXpSpend = Double.parseDouble(v);
                    break;
                }
                case "maxTotemUnitPrice": {
                    maxTotemUnitPrice = Double.parseDouble(v);
                    break;
                }
                case "maxTotemSpend": {
                    maxTotemSpend = Double.parseDouble(v);
                    break;
                }
                case "autoDefend": {
                    autoDefend = Boolean.parseBoolean(v);
                    break;
                }
                case "lowLoad": {
                    lowLoad = Boolean.parseBoolean(v);
                    break;
                }
                case "descendDepth": {
                    AutoMiner.descendDepth = AutoSandOrders.clampI(Integer.parseInt(v), 0, 8);
                    break;
                }
                case "nukerHold": {
                    AutoMiner.nukerHold = Boolean.parseBoolean(v);
                    break;
                }
                default: {
                    return "Kh\u00f4ng c\u00f3 m\u1ee5c \"" + name + "\". Xem danh s\u00e1ch trong /autosand set (mendPct, mendUntil, eatBelow, eatUntil, pickup, defenseRadius, fgFps, bgFps, lowLoadView, minSandPrice, maxXpUnitPrice, maxXpSpend, maxTotemUnitPrice, maxTotemSpend, autoDefend, lowLoad, descendDepth, nukerHold).";
                }
            }
        }
        catch (NumberFormatException e) {
            return "Gi\u00e1 tr\u1ecb kh\u00f4ng h\u1ee3p l\u1ec7: " + v;
        }
        AutoSandOrders.validate();
        AutoSandOrders.save();
        return "\u0110\u00e3 \u0111\u1eb7t " + name + " = " + v;
    }

    static void save() {
        try {
            Properties pr;
            block16: {
                pr = new Properties();
                try {
                    Path f = AutoSandOrders.cfgFile();
                    if (!Files.exists(f, new LinkOption[0])) break block16;
                    try (InputStream in = Files.newInputStream(f, new OpenOption[0]);){
                        pr.load(in);
                    }
                }
                catch (Exception f) {
                    // empty catch block
                }
            }
            pr.setProperty("mode", mode.name());
            pr.setProperty("nuker", String.valueOf(useNuker));
            pr.setProperty("keysForward", String.valueOf(keysForward));
            pr.setProperty("deliver", String.valueOf(autoDeliver));
            pr.setProperty("mend", String.valueOf(autoMend));
            pr.setProperty("buy", String.valueOf(autoBuy));
            pr.setProperty("mendPct", String.valueOf(mendPct));
            pr.setProperty("eat", String.valueOf(autoEat));
            pr.setProperty("buyFood", String.valueOf(autoBuyFood));
            pr.setProperty("drop", String.valueOf(autoDrop));
            pr.setProperty("eatBelow", String.valueOf(eatBelow));
            pr.setProperty("pickup", String.valueOf(pickupRadius));
            pr.setProperty("revive", String.valueOf(autoRevive));
            pr.setProperty("avoidLiquid", String.valueOf(avoidLiquid));
            pr.setProperty("avoidHole", String.valueOf(avoidHole));
            pr.setProperty("bridge", String.valueOf(bridgeWater));
            pr.setProperty("orderCmd", ORDER_COMMAND);
            pr.setProperty("shopCmd", SHOP_COMMAND);
            pr.setProperty("autoStart", String.valueOf(autoStart));
            pr.setProperty("autoJoinCmd", autoJoinCmd == null ? "" : autoJoinCmd);
            pr.setProperty("autoJoinDelay", String.valueOf(autoJoinDelay));
            pr.setProperty("homeCmd", AutoMiner.homeCmd);
            pr.setProperty("deathRecover", String.valueOf(AutoMiner.deathRecover));
            pr.setProperty("autoRespawn", String.valueOf(AutoMiner.autoRespawn));
            pr.setProperty("digThrough", String.valueOf(AutoMiner.digThrough));
            pr.setProperty("scanRadius", String.valueOf(AutoMiner.scanRadius));
            pr.setProperty("descendDepth", String.valueOf(AutoMiner.descendDepth));
            pr.setProperty("nukerHold", String.valueOf(AutoMiner.nukerHold));
            pr.setProperty("autoRejoin", String.valueOf(autoRejoin));
            pr.setProperty("usePearl", String.valueOf(usePearl));
            pr.setProperty("autoTotem", String.valueOf(autoTotem));
            pr.setProperty("mineSpeed", String.valueOf(mineSpeed));
            pr.setProperty("pricePerSand", String.valueOf(pricePerSand));
            pr.setProperty("statSand", String.valueOf(statSand));
            pr.setProperty("statTicks", String.valueOf(statTicks));
            pr.setProperty("statDeaths", String.valueOf(statDeaths));
            pr.setProperty("mendUntil", String.valueOf(mendUntil));
            pr.setProperty("eatUntil", String.valueOf(eatUntil));
            pr.setProperty("minSandPrice", String.valueOf(minSandPrice));
            pr.setProperty("maxXpUnitPrice", String.valueOf(maxXpUnitPrice));
            pr.setProperty("maxXpSpend", String.valueOf(maxXpSpend));
            pr.setProperty("maxTotemUnitPrice", String.valueOf(maxTotemUnitPrice));
            pr.setProperty("maxTotemSpend", String.valueOf(maxTotemSpend));
            pr.setProperty("autoDefend", String.valueOf(autoDefend));
            pr.setProperty("defenseRadius", String.valueOf(defenseRadius));
            pr.setProperty("lowLoad", String.valueOf(lowLoad));
            pr.setProperty("fgFps", String.valueOf(fgFps));
            pr.setProperty("bgFps", String.valueOf(bgFps));
            pr.setProperty("lowLoadView", String.valueOf(lowLoadView));
            pr.setProperty("keepExtra", String.join((CharSequence)",", extraKeep));
            try (OutputStream out = Files.newOutputStream(AutoSandOrders.cfgFile(), new OpenOption[0]);){
                pr.store(out, "AutoSand");
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    static boolean screenBlocks(class_310 mc) {
        class_437 sc = mc.field_1755;
        return sc != null && !(sc instanceof class_408) && !(sc instanceof class_433);
    }

    static void setEnabled(class_310 mc, boolean on) {
        if (on == enabled) {
            return;
        }
        class_746 p = mc.field_1724;
        enabled = on;
        if (on) {
            totemSpent = 0.0;
        }
        nukerState = null;
        Lobby.reset();
        state = S.MINING;
        cooldown = 0;
        wait = 0;
        AutoSandOrders.guardReset(mc, p);
        AutoMiner.reset(mc);
        if (p != null) {
            if (on) {
                AutoSandOrders.startMining(p);
            } else {
                if (shovelSwapped && mc.field_1761 != null) {
                    AutoSandOrders.swapOffhand(mc, p, shovelFrom);
                    shovelSwapped = false;
                }
                AutoSandOrders.restoreLook(mc, p);
                AutoSandOrders.stopMining(mc, p);
            }
            AutoSandOrders.msg(p, on ? "B\u1eacT" : "T\u1eaeT");
        }
    }

    static void startMining(class_746 p) {
        if (rejoinWait > 0) {
            return;
        }
        if (useNuker) {
            AutoSandOrders.setNuker(p, true);
        }
        if (mode == Mode.BUILTIN) {
            AutoMiner.start(p);
            return;
        }
    }

    static void stopMining(class_310 mc, class_746 p) {
        if (useNuker) {
            AutoSandOrders.setNuker(p, false);
        }
        if (mode == Mode.BUILTIN) {
            AutoMiner.stop(mc);
            return;
        }
        AutoSandOrders.releaseKeys(mc);
    }

    static void releaseKeys(class_310 mc) {
        mc.field_1690.field_1886.method_23481(false);
        mc.field_1690.field_1894.method_23481(false);
        mc.field_1690.field_1904.method_23481(false);
    }

    static void tick(class_310 mc) {
        ClientTaskQueue.pump();
        class_746 p = mc.field_1724;
        AutoSandOrders.perfTick(mc);
        if (p == null || mc.field_1761 == null) {
            autoJoinDone = false;
            Reconnect.tick(mc);
            return;
        }
        Reconnect.connected(mc);
        if (!autoJoinDone && (autoStart || autoJoinCmd != null && !autoJoinCmd.isBlank()) && p.field_6012 >= Math.max(10, autoJoinDelay)) {
            autoJoinDone = true;
            if (autoJoinCmd != null && !autoJoinCmd.isBlank()) {
                for (String part : autoJoinCmd.split(";")) {
                    String c = part.trim();
                    if (c.isEmpty()) continue;
                    if (c.startsWith("/")) {
                        c = c.substring(1);
                    }
                    AutoSandOrders.send(p, "/" + c);
                }
                AutoSandOrders.msg(p, "\u0110\u00e3 t\u1ef1 ch\u1ea1y l\u1ec7nh v\u00e0o server.");
            }
            if (autoStart && !enabled) {
                AutoSandOrders.setEnabled(mc, true);
                AutoSandOrders.msg(p, "T\u1ef1 B\u1eacT AutoSand khi v\u00e0o server.");
            }
        }
        Announcements.tick(mc, p);
        if (totemCool > 0) {
            --totemCool;
        }
        while (menuKey != null && menuKey.method_1436()) {
            openGui = true;
        }
        while (stopKey != null && stopKey.method_1436()) {
            AutoSandOrders.emergencyStop(mc);
        }
        if (testKind != null) {
            AutoSandOrders.testTick(mc, p);
            if (testKind != null) {
                return;
            }
        }
        if (openGui && mc.field_1755 == null) {
            openGui = false;
            mc.method_1507((class_437)new AutoSandScreen());
            return;
        }
        AutoMiner.arrowTick(mc, p);
        if (!enabled) {
            lastPlayer = p;
            return;
        }
        if (p != lastPlayer) {
            boolean had = lastPlayer != null;
            boolean deathReturn = AutoMiner.deathRecorded && AutoMiner.deathPos != null;
            lastPlayer = p;
            if (had) {
                guard = G.NONE;
                pickTarget = null;
                shovelSwapped = false;
                state = S.MINING;
                wait = 0;
                cooldown = 40;
                reviveIn = 60;
                if (!deathReturn) {
                    reviveIn = 0;
                    rejoinWait = 200;
                    AutoMiner.stop(mc);
                    AutoSandOrders.msg(p, "V\u00e0o l\u1ea1i server: t\u1ea1m d\u1eebng \u0111\u00e0o, ch\u1edd 10 gi\u00e2y r\u1ed3i \u0111\u00e0o ti\u1ebfp.");
                }
                wdX = Double.NaN;
                if (mode == Mode.BUILTIN) {
                    AutoMiner.onRespawn(mc, p);
                }
            }
        }
        if (p.method_29504()) {
            if (mode == Mode.BUILTIN) {
                AutoMiner.onDead(mc, p);
            }
            return;
        }
        if (reviveIn > 0 && --reviveIn == 0) {
            AutoSandOrders.startMining(p);
        }
        if (++statTicks % 1200L == 0L) {
            AutoSandOrders.save();
        }
        if (Lobby.tick(mc, p)) {
            return;
        }
        if (state == S.MINING && !AutoSandOrders.screenBlocks(mc) && AutoSandOrders.guardTick(mc, p)) {
            return;
        }
        if (rejoinWait > 0 && --rejoinWait == 0) {
            AutoSandOrders.startMining(p);
            AutoSandOrders.msg(p, "\u0110\u00e3 ch\u1edd xong 10 gi\u00e2y, ti\u1ebfp t\u1ee5c \u0111\u00e0o.");
        }
        if (rejoinWait > 0) {
            AutoMiner.release(mc);
            return;
        }
        if (state == S.MINING) {
            if (AutoSandOrders.screenBlocks(mc)) {
                return;
            }
            if (autoDefend && AutoSandOrders.defendTick(mc, p)) {
                return;
            }
            if (useNuker && ++nwTick >= 10) {
                nwTick = 0;
                boolean wn = AutoMiner.waterWithin(mc.field_1687, p.method_24515(), 5);
                if (wn != nukerWater) {
                    nukerWater = wn;
                    if (wn) {
                        AutoSandOrders.setNuker(p, false);
                    } else {
                        AutoSandOrders.setNuker(p, true);
                    }
                    if (wn) {
                        AutoSandOrders.msg(p, "C\u00f3 n\u01b0\u1edbc g\u1ea7n \u0111\u00e2y -> t\u1ea1m t\u1eaft Nuker, ch\u1ec9 \u0111\u00e0o c\u00e1t an to\u00e0n.");
                    }
                }
            }
            if (mode == Mode.KEYS) {
                class_3965 bhr;
                class_239 deathReturn;
                mc.field_1690.field_1886.method_23481(true);
                mc.field_1690.field_1894.method_23481(keysForward);
                if (mc.field_1755 != null && (deathReturn = mc.field_1765) instanceof class_3965 && (bhr = (class_3965)deathReturn).method_17783() == class_239.class_240.field_1332) {
                    mc.field_1761.method_2902(bhr.method_17777(), bhr.method_17780());
                    p.method_6104(class_1268.field_5808);
                }
            }
            if (mode == Mode.BUILTIN) {
                AutoMiner.tick(mc, p);
                if (AutoMiner.recovering()) {
                    return;
                }
            }
            if (junkCool > 0) {
                --junkCool;
            }
            if (wait > 0) {
                --wait;
                return;
            }
            if (cooldown > 0) {
                --cooldown;
                return;
            }
            if (autoTotem && AutoSandOrders.totemTick(mc, p)) {
                return;
            }
            if (junkCool <= 0 && (autoDrop && AutoSandOrders.junkSlot(p) >= 0 || AutoSandOrders.arrangeMove(p) != null)) {
                AutoSandOrders.startJunk(mc, p);
                return;
            }
            if (autoEat && p.method_7344().method_7586() <= eatBelow) {
                if (AutoSandOrders.findFood(p) >= 0) {
                    foodWarn = false;
                    AutoSandOrders.startEat(mc, p);
                    return;
                }
                if (autoBuyFood && AutoSandOrders.emptySlot(p) >= 0) {
                    AutoSandOrders.startFoodBuy(mc, p);
                    return;
                }
                if (autoBuyFood && autoDeliver && AutoSandOrders.countItem(p, class_1802.field_8858) > 0) {
                    AutoSandOrders.startDeliver(mc, p);
                    return;
                }
                if (!foodWarn) {
                    foodWarn = true;
                    AutoSandOrders.msg(p, autoBuyFood ? "\u0110\u00f3i nh\u01b0ng t\u00fai kh\u00f4ng c\u00f2n \u00f4 tr\u1ed1ng \u0111\u1ec3 mua \u0111\u1ed3 \u0103n (giao c\u00e1t tr\u01b0\u1edbc)." : "\u0110\u00f3i nh\u01b0ng h\u1ebft \u0111\u1ed3 \u0103n (t\u1ef1 mua \u0111\u1ed3 \u0103n \u0111ang t\u1eaft).");
                }
            }
            if (autoDeliver && AutoSandOrders.isFull(p) && AutoSandOrders.countItem(p, class_1802.field_8858) > 0) {
                AutoSandOrders.startDeliver(mc, p);
            } else if (autoMend && AutoSandOrders.lowShovel(p) >= 0) {
                AutoSandOrders.startMend(mc, p);
            }
            return;
        }
        if (wait > 0) {
            --wait;
            return;
        }
        if (--timeout <= 0) {
            boolean buying;
            if (state == S.BUY_DONE && AutoSandOrders.boughtAny(p)) {
                AutoSandOrders.finishBuy(mc, p);
                return;
            }
            if (state == S.WAIT_DELIVER) {
                AutoSandOrders.nextOrder(mc, p, "b\u1ea5m v\u00e0o m\u00e0 kh\u00f4ng m\u1edf \u0111\u01b0\u1ee3c b\u1ea3ng giao h\u00e0ng");
                return;
            }
            boolean bl = buying = state == S.BUY_SHOP || state == S.BUY_GEAR || state == S.BUY_AMOUNT || state == S.BUY_CONFIRM || state == S.BUY_DONE;
            if (buying && buyRetry < 2) {
                AutoSandOrders.retryBuy(mc, p, "h\u1ebft th\u1eddi gian ch\u1edd \u1edf b\u01b0\u1edbc " + String.valueOf((Object)state));
                return;
            }
            AutoSandOrders.abort(mc, "h\u1ebft th\u1eddi gian ch\u1edd \u1edf b\u01b0\u1edbc " + String.valueOf((Object)state));
            return;
        }
        class_1707 h = AutoSandOrders.container(mc);
        switch (state.ordinal()) {
            case 1: {
                if (h == null || h.method_17388() != 6 || !AutoSandOrders.loaded(h)) {
                    return;
                }
                int pick = -1;
                int seen = 0;
                int n = h.method_17388() * 9;
                for (int i = 0; i < n && i < h.field_7761.size(); ++i) {
                    double pr;
                    if (!((class_1735)h.field_7761.get(i)).method_7677().method_31574(class_1802.field_8858) || minSandPrice > 0.0 && (pr = AutoSandOrders.lorePrice(((class_1735)h.field_7761.get(i)).method_7677())) > 0.0 && pr < minSandPrice) continue;
                    if (seen == orderTry) {
                        pick = i;
                        break;
                    }
                    ++seen;
                }
                if (pick < 0) {
                    if (++ordersWait < 30) {
                        return;
                    }
                    AutoSandOrders.msg(p, "B\u1ea3ng /orders kh\u00f4ng c\u00f3 \u0111\u01a1n c\u00e1t n\u00e0o d\u00f9ng \u0111\u01b0\u1ee3c. C\u00e1c \u00f4: " + AutoSandOrders.dump(h));
                    AutoSandOrders.abort(mc, "kh\u00f4ng c\u00f2n \u0111\u01a1n c\u00e1t n\u00e0o \u0111\u1ec3 th\u1eed (\u0111\u00e3 th\u1eed " + orderTry + " \u0111\u01a1n)");
                    return;
                }
                orderSlot = pick;
                AutoSandOrders.click(mc, p, h, pick, class_1713.field_7790);
                lastSync = h.field_7763;
                state = S.WAIT_DELIVER;
                timeout = 60;
                wait = 4;
                break;
            }
            case 2: {
                if (h == null || h.field_7763 == lastSync || h.method_17388() != 6) {
                    return;
                }
                lastSync = h.field_7763;
                sandBefore = AutoSandOrders.countItem(p, class_1802.field_8858);
                clicks = 0;
                settle = false;
                state = S.DEPOSIT;
                timeout = 200;
                wait = 4;
                break;
            }
            case 3: {
                int i;
                if (h == null || h.field_7763 != lastSync) {
                    if (AutoSandOrders.sandMoved(p)) {
                        state = S.WAIT_CONFIRM;
                        timeout = 200;
                        wait = 4;
                    } else {
                        AutoSandOrders.nextOrder(mc, p, "\u0111\u01a1n \u0111\u00f3ng b\u1ea3ng m\u00e0 kh\u00f4ng nh\u1eadn c\u00e1t");
                    }
                    return;
                }
                if (settle) {
                    settle = false;
                    if (!AutoSandOrders.sandMoved(p)) {
                        AutoSandOrders.nextOrder(mc, p, "\u0111\u01a1n kh\u00f4ng nh\u1eadn c\u00e1t (\u0111\u1ea7y?)");
                        return;
                    }
                }
                if (clicks < 120) {
                    for (i = 0; i < h.field_7761.size(); ++i) {
                        class_1735 s = (class_1735)h.field_7761.get(i);
                        if (s.field_7871 != p.method_31548() || !s.method_7677().method_31574(class_1802.field_8858)) continue;
                        AutoSandOrders.click(mc, p, h, i, class_1713.field_7794);
                        if (++clicks == 1) {
                            settle = true;
                            wait = 6;
                        } else {
                            wait = 1;
                        }
                        return;
                    }
                }
                if (clicks == 0) {
                    AutoSandOrders.abort(mc, "kh\u00f4ng c\u00f3 c\u00e1t \u0111\u1ec3 giao");
                    return;
                }
                p.method_7346();
                state = S.WAIT_CONFIRM;
                timeout = 200;
                wait = 4;
                break;
            }
            case 4: {
                if (h == null || h.field_7763 == lastSync || h.method_17388() != 3) {
                    return;
                }
                int slot = AutoSandOrders.find(h, st -> AutoSandOrders.nameHas(st, "x\u00e1c nh\u1eadn", "confirm"), -1);
                if (slot < 0) {
                    slot = 16;
                }
                lastDelivered = Math.max(0, sandBefore - AutoSandOrders.countItem(p, class_1802.field_8858));
                AutoSandOrders.click(mc, p, h, slot, class_1713.field_7790);
                statSand += (long)lastDelivered;
                AutoSandOrders.save();
                state = S.FINISH;
                closes = 0;
                finishIdle = 0;
                timeout = 200;
                wait = 12;
                break;
            }
            case 5: {
                int idleMax;
                if (AutoSandOrders.screenBlocks(mc)) {
                    p.method_7346();
                    ++closes;
                    finishIdle = 0;
                    wait = 4;
                    return;
                }
                int n = idleMax = closes < 2 ? 8 : 2;
                if (finishIdle < idleMax) {
                    ++finishIdle;
                    wait = 3;
                    return;
                }
                AutoSandOrders.startMining(p);
                state = S.MINING;
                cooldown = 60;
                AutoSandOrders.msg(p, "\u0110\u00e3 giao xong, ti\u1ebfp t\u1ee5c \u0111\u00e0o.");
                break;
            }
            case 6: {
                int idx;
                if (AutoSandOrders.screenBlocks(mc)) {
                    p.method_7346();
                    wait = 2;
                    return;
                }
                if (step == 0) {
                    int bs = AutoSandOrders.bottleSlot(p);
                    if (!p.method_31548().method_5438(bs).method_31574(class_1802.field_8287)) {
                        int idx2 = AutoSandOrders.findItem(p, class_1802.field_8287);
                        if (idx2 < 0) {
                            AutoSandOrders.abort(mc, "kh\u00f4ng c\u00f3 b\u00ecnh XP");
                            return;
                        }
                        AutoSandOrders.swapHotbar(mc, p, idx2, bs);
                        wait = 4;
                    }
                    step = 1;
                    return;
                }
                if (step == 1) {
                    idx = AutoSandOrders.lowShovel(p);
                    if (idx < 0) {
                        AutoSandOrders.finishMend(mc, p);
                        return;
                    }
                    shovelFrom = idx;
                    AutoSandOrders.swapOffhand(mc, p, idx);
                    shovelSwapped = true;
                    step = 2;
                    wait = 4;
                    return;
                }
                AutoSandOrders.setSelected(p, AutoSandOrders.bottleSlot(p));
                oldXRot = p.method_36455();
                mendThrows = 0;
                lastCheck = 0;
                lastDamage = p.method_6079().method_7919();
                state = S.MEND_THROW;
                timeout = 200;
                wait = 2;
                break;
            }
            case 7: {
                if (AutoSandOrders.screenBlocks(mc)) {
                    p.method_7346();
                    wait = 2;
                    return;
                }
                class_1799 off = p.method_6079();
                if (!off.method_31573(class_3489.field_42615) || AutoSandOrders.remainingPct(off) >= (double)mendUntil) {
                    state = S.MEND_RESTORE;
                    return;
                }
                int bs = AutoSandOrders.bottleSlot(p);
                if (!p.method_31548().method_5438(bs).method_31574(class_1802.field_8287)) {
                    int idx = AutoSandOrders.findItem(p, class_1802.field_8287);
                    if (idx < 0) {
                        needBuy = true;
                        state = S.MEND_RESTORE;
                        return;
                    }
                    AutoSandOrders.swapHotbar(mc, p, idx, bs);
                    wait = 4;
                    return;
                }
                if (AutoSandOrders.getSelected(p) != bs) {
                    AutoSandOrders.setSelected(p, bs);
                    wait = 2;
                    return;
                }
                if (mendThrows - lastCheck >= 10) {
                    int dmg = off.method_7919();
                    if (dmg >= lastDamage) {
                        autoMend = false;
                        AutoSandOrders.save();
                        AutoSandOrders.msg(p, "X\u1ebbng kh\u00f4ng \u0111\u01b0\u1ee3c s\u1eeda (c\u00f3 Mending kh\u00f4ng?). \u0110\u00e3 t\u1eaft t\u1ef1 s\u1eeda x\u1ebbng.");
                        state = S.MEND_RESTORE;
                        return;
                    }
                    lastDamage = dmg;
                    lastCheck = mendThrows;
                }
                p.method_36457(90.0f);
                mc.field_1761.method_2919((class_1657)p, class_1268.field_5808);
                p.method_6104(class_1268.field_5808);
                ++mendThrows;
                timeout = 200;
                wait = 3;
                break;
            }
            case 8: {
                if (AutoSandOrders.screenBlocks(mc)) {
                    p.method_7346();
                    wait = 2;
                    return;
                }
                if (shovelSwapped) {
                    AutoSandOrders.swapOffhand(mc, p, shovelFrom);
                    shovelSwapped = false;
                    if (shovelFrom >= 0 && shovelFrom < 9) {
                        AutoSandOrders.setSelected(p, shovelFrom);
                    }
                    if (!Float.isNaN(oldXRot)) {
                        p.method_36457(oldXRot);
                        oldXRot = Float.NaN;
                    }
                    wait = 4;
                    return;
                }
                if (needBuy) {
                    needBuy = false;
                    if (autoBuy && buyTries < 2 && AutoSandOrders.lowShovel(p) >= 0) {
                        ++buyTries;
                        AutoSandOrders.beginBuy();
                        return;
                    }
                }
                AutoSandOrders.finishMend(mc, p);
                break;
            }
            case 9: {
                if (AutoSandOrders.screenBlocks(mc)) {
                    p.method_7346();
                    wait = 2;
                    return;
                }
                int d = AutoSandOrders.buyDropSlot(p);
                if (dropStep == 0) {
                    if (d < 0) {
                        dropStep = 2;
                        return;
                    }
                    dropXRot = p.method_36455();
                    p.method_36457(0.0f);
                    dropStep = 1;
                    wait = 3;
                    return;
                }
                if (dropStep == 1) {
                    if (d >= 0 && junkDropped < 40) {
                        AutoSandOrders.dropStack(mc, p, d);
                        ++junkDropped;
                        wait = 2;
                        return;
                    }
                    if (!Float.isNaN(dropXRot)) {
                        p.method_36457(dropXRot);
                        dropXRot = Float.NaN;
                    }
                    dropStep = 2;
                    wait = 4;
                    return;
                }
                if (!buyResume) {
                    buyRound = 0;
                    buyTarget = Math.max(1, Math.min(9, (AutoSandOrders.hotbarMissing(p) + 63) / 64));
                }
                buyResume = false;
                AutoSandOrders.send(p, "/" + SHOP_COMMAND);
                state = S.BUY_SHOP;
                timeout = 200;
                wait = 4;
                break;
            }
            case 10: {
                int i;
                if (h == null || h.method_17388() != 3 || !AutoSandOrders.loaded(h)) {
                    return;
                }
                if (buyFood) {
                    i = AutoSandOrders.find(h, st -> AutoSandOrders.nameHas(st, "food"), -1);
                    if (i < 0) {
                        i = 14;
                    }
                } else {
                    i = AutoSandOrders.find(h, st -> st.method_31574(class_1802.field_8288), -1);
                    if (i < 0) {
                        i = 13;
                    }
                }
                AutoSandOrders.click(mc, p, h, i, class_1713.field_7790);
                lastSync = h.field_7763;
                state = S.BUY_GEAR;
                timeout = 200;
                wait = 4;
                break;
            }
            case 11: {
                int i;
                if (h == null || h.field_7763 == lastSync || h.method_17388() != 3 || !AutoSandOrders.loaded(h)) {
                    return;
                }
                if (buyFood) {
                    i = AutoSandOrders.find(h, st -> st.method_31574(class_1802.field_8071), -1);
                    if (i < 0) {
                        i = 16;
                    }
                } else if (buyPearl) {
                    i = AutoSandOrders.find(h, st -> st.method_31574(class_1802.field_8634), -1);
                    if (i < 0) {
                        i = 14;
                    }
                } else if (buyTotem) {
                    i = AutoSandOrders.find(h, st -> st.method_31574(class_1802.field_8288), -1);
                    if (i < 0) {
                        i = 13;
                    }
                } else {
                    i = AutoSandOrders.find(h, st -> st.method_31574(class_1802.field_8287), -1);
                    if (i < 0) {
                        i = 16;
                    }
                }
                AutoSandOrders.click(mc, p, h, i, class_1713.field_7790);
                lastSync = h.field_7763;
                state = S.BUY_AMOUNT;
                timeout = 200;
                wait = 4;
                break;
            }
            case 12: {
                if (h == null || h.field_7763 == lastSync || h.method_17388() != 3 || !AutoSandOrders.loaded(h)) {
                    return;
                }
                if (buyPearl || buyTotem) {
                    lastSync = h.field_7763;
                    gone = 0;
                    state = S.BUY_CONFIRM;
                    timeout = 200;
                    wait = 4;
                    return;
                }
                int i = AutoSandOrders.find(h, st -> AutoSandOrders.nameHas(st, "64"), 13);
                if (i < 0) {
                    i = 17;
                    AutoSandOrders.msg(p, "Kh\u00f4ng th\u1ea5y n\u00fat 64 theo t\u00ean, b\u1ea5m \u00f4 " + i + ". C\u00e1c \u00f4: " + AutoSandOrders.dump(h));
                }
                AutoSandOrders.click(mc, p, h, i, class_1713.field_7790);
                lastSync = h.field_7763;
                gone = 0;
                state = S.BUY_CONFIRM;
                timeout = 200;
                wait = 8;
                break;
            }
            case 13: {
                double cost;
                String block;
                if (h == null || h.method_17388() != 3) {
                    if (++gone > 20) {
                        AutoSandOrders.retryBuy(mc, p, "b\u1ea3ng mua b\u1ecb \u0111\u00f3ng tr\u01b0\u1edbc khi x\u00e1c nh\u1eadn");
                    }
                    return;
                }
                if (!AutoSandOrders.loaded(h)) {
                    return;
                }
                gone = 0;
                if (!(buyFood || buyPearl || buyTotem || AutoSandOrders.buyDropSlot(p) < 0 || buyRedo >= 8)) {
                    ++buyRedo;
                    p.method_7346();
                    buyResume = true;
                    dropStep = 0;
                    junkDropped = 0;
                    state = S.BUY_PREP;
                    timeout = 200;
                    wait = 4;
                    return;
                }
                int i = AutoSandOrders.find(h, st -> AutoSandOrders.nameHas(st, "x\u00e1c nh\u1eadn", "confirm"), -1);
                if (i < 0) {
                    i = 23;
                    AutoSandOrders.msg(p, "Kh\u00f4ng th\u1ea5y n\u00fat x\u00e1c nh\u1eadn theo t\u00ean, b\u1ea5m \u00f4 " + i + ". C\u00e1c \u00f4: " + AutoSandOrders.dump(h));
                }
                if ((block = AutoSandOrders.overBudget(cost = AutoSandOrders.menuCost(h))) != null) {
                    boolean wasTotem = buyTotem;
                    AutoSandOrders.abort(mc, block);
                    if (wasTotem) {
                        totemBuyFails = 0;
                        totemCool = 6000;
                    } else {
                        cooldown = 6000;
                    }
                    return;
                }
                if (cost > 0.0) {
                    if (buyTotem) {
                        totemSpent += cost;
                    } else if (!buyFood && !buyPearl) {
                        xpSpent += cost;
                    }
                }
                buyBefore = AutoSandOrders.boughtCount(p);
                AutoSandOrders.click(mc, p, h, i, class_1713.field_7790);
                state = S.BUY_DONE;
                timeout = 80;
                wait = 12;
                break;
            }
            case 14: {
                if (AutoSandOrders.boughtCount(p) <= buyBefore) {
                    return;
                }
                if (AutoSandOrders.screenBlocks(mc)) {
                    p.method_7346();
                    wait = 3;
                    return;
                }
                buyRetry = 0;
                if (!(++buyRound >= buyTarget || buyPearl && AutoSandOrders.countItem(p, class_1802.field_8634) >= pearlNeed)) {
                    if (!(buyPearl || buyFood || buyTotem)) {
                        buyResume = true;
                        dropStep = 0;
                        junkDropped = 0;
                        state = S.BUY_PREP;
                        timeout = 200;
                        wait = 4;
                        return;
                    }
                    AutoSandOrders.send(p, "/" + SHOP_COMMAND);
                    state = S.BUY_SHOP;
                    timeout = 200;
                    wait = 4;
                    return;
                }
                AutoSandOrders.finishBuy(mc, p);
                break;
            }
            case 17: {
                int j;
                if (AutoSandOrders.screenBlocks(mc)) {
                    p.method_7346();
                    wait = 2;
                    return;
                }
                if (junkStep == 0) {
                    junkXRot = p.method_36455();
                    p.method_36457(0.0f);
                    junkStep = 1;
                    wait = 3;
                    return;
                }
                int n = j = autoDrop ? AutoSandOrders.junkSlot(p) : -1;
                if (j >= 0 && junkDropped < 60) {
                    AutoSandOrders.dropStack(mc, p, j);
                    ++junkDropped;
                    timeout = 200;
                    wait = 2;
                    return;
                }
                int[] mv = AutoSandOrders.arrangeMove(p);
                if (mv != null && junkMoves < 40) {
                    AutoSandOrders.swapHotbar(mc, p, mv[0], mv[1]);
                    ++junkMoves;
                    timeout = 200;
                    wait = 3;
                    return;
                }
                if (!Float.isNaN(junkXRot)) {
                    p.method_36457(junkXRot);
                    junkXRot = Float.NaN;
                }
                state = S.MINING;
                junkCool = 100;
                cooldown = 10;
                AutoSandOrders.startMining(p);
                if (junkDropped <= 0 && junkMoves <= 0) break;
                AutoSandOrders.msg(p, "\u0110\u00e3 v\u1ee9t " + junkDropped + " stack, x\u1ebfp l\u1ea1i " + junkMoves + " \u00f4 thanh c\u00f4ng c\u1ee5.");
                break;
            }
            case 15: {
                if (AutoSandOrders.screenBlocks(mc)) {
                    p.method_7346();
                    wait = 2;
                    return;
                }
                if (p.method_7344().method_7586() >= AutoSandOrders.eatGoal()) {
                    AutoSandOrders.finishEat(mc, p, 60);
                    return;
                }
                int idx = AutoSandOrders.findFood(p);
                if (idx < 0) {
                    AutoSandOrders.msg(p, "Kh\u00f4ng c\u00f3 \u0111\u1ed3 \u0103n.");
                    AutoSandOrders.finishEat(mc, p, 600);
                    return;
                }
                eatPrevSlot = AutoSandOrders.getSelected(p);
                idx = AutoSandOrders.toHotbar(mc, p, idx);
                AutoSandOrders.setSelected(p, idx);
                eatXRot = p.method_36455();
                p.method_36457(-90.0f);
                mc.field_1761.method_2925();
                eatIdle = 0;
                eatTries = 0;
                eatOff = false;
                eatOffFrom = -1;
                eatLastFood = p.method_7344().method_7586();
                AutoSandOrders.msg(p, "\u0110\u00f3i (" + eatLastFood + "/20) -> \u0103n.");
                state = S.EAT_USE;
                timeout = 200;
                wait = 3;
                break;
            }
            case 16: {
                class_1268 hand;
                if (AutoSandOrders.screenBlocks(mc)) {
                    p.method_7346();
                    wait = 2;
                    return;
                }
                boolean using = p.method_6115();
                if (!using && p.method_7344().method_7586() >= AutoSandOrders.eatGoal()) {
                    AutoSandOrders.finishEat(mc, p, 60);
                    return;
                }
                class_1268 class_12682 = hand = eatOff ? class_1268.field_5810 : class_1268.field_5808;
                if (!AutoSandOrders.edible(p.method_5998(hand))) {
                    mc.field_1690.field_1904.method_23481(false);
                    if (using) {
                        return;
                    }
                    int idx = AutoSandOrders.findFood(p);
                    if (idx < 0) {
                        AutoSandOrders.msg(p, "H\u1ebft \u0111\u1ed3 \u0103n.");
                        AutoSandOrders.finishEat(mc, p, 0);
                        return;
                    }
                    if (eatOff) {
                        AutoSandOrders.swapOffhand(mc, p, idx);
                        eatOffFrom = idx;
                    } else {
                        AutoSandOrders.setSelected(p, AutoSandOrders.toHotbar(mc, p, idx));
                    }
                    wait = 3;
                    return;
                }
                int fl = p.method_7344().method_7586();
                if (fl > eatLastFood) {
                    eatLastFood = fl;
                    eatTries = 0;
                    timeout = 200;
                }
                mc.field_1690.field_1904.method_23481(true);
                if (using) {
                    eatIdle = 0;
                    return;
                }
                if (mc.field_1755 == null && ++eatIdle < 4) break;
                eatIdle = 0;
                if (++eatTries == 5) {
                    p.method_36457(0.0f);
                }
                if (eatTries == 9 && !eatOff) {
                    int cur = AutoSandOrders.getSelected(p);
                    mc.field_1690.field_1904.method_23481(false);
                    AutoSandOrders.swapOffhand(mc, p, cur);
                    eatOff = true;
                    eatOffFrom = cur;
                    wait = 4;
                    return;
                }
                if (eatTries > 16) {
                    AutoSandOrders.abort(mc, "kh\u00f4ng \u0103n \u0111\u01b0\u1ee3c d\u00f9 \u0111\u00e3 th\u1eed nhi\u1ec1u c\u00e1ch");
                    return;
                }
                mc.field_1761.method_2925();
                mc.field_1761.method_2919((class_1657)p, hand);
                wait = 2;
                break;
            }
        }
    }

    static void startDeliver(class_310 mc, class_746 p) {
        AutoSandOrders.stopMining(mc, p);
        AutoSandOrders.send(p, "/" + ORDER_COMMAND);
        state = S.WAIT_ORDERS;
        timeout = 200;
        clicks = 0;
        orderTry = 0;
        ordersWait = 0;
        settle = false;
        wait = 4;
    }

    static void nextOrder(class_310 mc, class_746 p, String why) {
        int tried = orderTry + 1;
        if (++orderTry >= 15) {
            AutoSandOrders.abort(mc, "\u0111\u00e3 th\u1eed " + tried + " \u0111\u01a1n m\u00e0 kh\u00f4ng \u0111\u01a1n n\u00e0o nh\u1eadn c\u00e1t");
            return;
        }
        AutoSandOrders.msg(p, "\u0110\u01a1n \u1edf \u00f4 " + orderSlot + ": " + why + ". Th\u1eed \u0111\u01a1n k\u1ebf ti\u1ebfp (" + (orderTry + 1) + "/15).");
        if (AutoSandOrders.screenBlocks(mc)) {
            p.method_7346();
        }
        AutoSandOrders.send(p, "/" + ORDER_COMMAND);
        state = S.WAIT_ORDERS;
        timeout = 200;
        clicks = 0;
        ordersWait = 0;
        settle = false;
        wait = 12;
    }

    static boolean sandMoved(class_746 p) {
        return AutoSandOrders.countItem(p, class_1802.field_8858) < sandBefore;
    }

    static void startJunk(class_310 mc, class_746 p) {
        AutoSandOrders.stopMining(mc, p);
        state = S.JUNK;
        junkStep = 0;
        junkDropped = 0;
        junkMoves = 0;
        timeout = 200;
        wait = 4;
    }

    static void startEat(class_310 mc, class_746 p) {
        AutoSandOrders.stopMining(mc, p);
        state = S.EAT_PREP;
        timeout = 200;
        wait = 4;
    }

    static void startFoodBuy(class_310 mc, class_746 p) {
        AutoSandOrders.stopMining(mc, p);
        AutoSandOrders.msg(p, "H\u1ebft \u0111\u1ed3 \u0103n, \u0111i mua th\u00eam.");
        buyFood = true;
        buyPearl = false;
        buyTotem = false;
        buyRound = 0;
        buyTarget = 1;
        buyRetry = 0;
        gone = 0;
        AutoSandOrders.send(p, "/" + SHOP_COMMAND);
        state = S.BUY_SHOP;
        timeout = 200;
        wait = 4;
    }

    static int eatGoal() {
        return hpEating ? 20 : eatUntil;
    }

    static boolean healBeforePearl(class_310 mc, class_746 p) {
        if (!autoEat || state != S.MINING || AutoSandOrders.screenBlocks(mc)) {
            return false;
        }
        if (p.method_7344().method_7586() >= 20) {
            return false;
        }
        if (AutoSandOrders.findFood(p) >= 0) {
            hpEating = true;
            AutoSandOrders.msg(p, "M\u00e1u th\u1ea5p (" + (int)p.method_6032() + ") -> \u0103n cho \u0111\u1ea7y thanh \u0111\u00f3i \u0111\u1ec3 h\u1ed3i m\u00e1u.");
            AutoSandOrders.startEat(mc, p);
            return true;
        }
        if (autoBuyFood && AutoSandOrders.emptySlot(p) >= 0) {
            hpEating = true;
            AutoSandOrders.msg(p, "M\u00e1u th\u1ea5p, h\u1ebft \u0111\u1ed3 \u0103n -> mua c\u00e0 r\u1ed1t v\u00e0ng r\u1ed3i \u0103n \u0111\u1ec3 h\u1ed3i m\u00e1u.");
            AutoSandOrders.startFoodBuy(mc, p);
            return true;
        }
        return false;
    }

    static void finishEat(class_310 mc, class_746 p, int cool) {
        hpEating = false;
        AutoSandOrders.restoreLook(mc, p);
        state = S.MINING;
        cooldown = cool;
        AutoSandOrders.startMining(p);
    }

    static void restoreLook(class_310 mc, class_746 p) {
        mc.field_1690.field_1904.method_23481(false);
        if (eatOff && eatOffFrom >= 0 && mc.field_1761 != null) {
            AutoSandOrders.swapOffhand(mc, p, eatOffFrom);
        }
        eatOff = false;
        eatOffFrom = -1;
        if (!Float.isNaN(eatXRot)) {
            p.method_36457(eatXRot);
            eatXRot = Float.NaN;
        }
        if (!Float.isNaN(junkXRot)) {
            p.method_36457(junkXRot);
            junkXRot = Float.NaN;
        }
        if (eatPrevSlot >= 0 && eatPrevSlot < 9) {
            AutoSandOrders.setSelected(p, eatPrevSlot);
        }
        eatPrevSlot = -1;
    }

    static void startMend(class_310 mc, class_746 p) {
        if (AutoSandOrders.countItem(p, class_1802.field_8287) == 0 && !autoBuy) {
            AutoSandOrders.msg(p, "X\u1ebbng g\u1ea7n h\u01b0 nh\u01b0ng h\u1ebft b\u00ecnh XP (t\u1ef1 mua \u0111ang t\u1eaft).");
            cooldown = 1200;
            return;
        }
        AutoSandOrders.stopMining(mc, p);
        xpSpent = 0.0;
        buyTries = 0;
        needBuy = false;
        step = 0;
        timeout = 200;
        wait = 4;
        if (AutoSandOrders.countItem(p, class_1802.field_8287) == 0) {
            buyTries = 1;
            AutoSandOrders.beginBuy();
        } else {
            state = S.MEND_PREP;
        }
    }

    static boolean totemTick(class_310 mc, class_746 p) {
        if (shovelSwapped) {
            return false;
        }
        class_1799 off = p.method_6079();
        if (off.method_31574(class_1802.field_8288)) {
            totemWarn = false;
            return false;
        }
        if (off.method_31573(class_3489.field_42615)) {
            return false;
        }
        if (p.field_6012 < 100) {
            return false;
        }
        int idx = AutoSandOrders.findItem(p, class_1802.field_8288);
        if (idx >= 0) {
            AutoSandOrders.swapOffhand(mc, p, idx);
            wait = 4;
            return true;
        }
        if (totemCool > 0 || !autoBuy) {
            return false;
        }
        if (AutoSandOrders.emptySlot(p) < 0) {
            if (!totemWarn) {
                totemWarn = true;
                AutoSandOrders.msg(p, "H\u1ebft totem nh\u01b0ng t\u00fai kh\u00f4ng c\u00f2n \u00f4 tr\u1ed1ng \u0111\u1ec3 mua (giao c\u00e1t tr\u01b0\u1edbc).");
            }
            return false;
        }
        AutoSandOrders.startTotemBuy(mc, p);
        return true;
    }

    static void startTotemBuy(class_310 mc, class_746 p) {
        AutoSandOrders.stopMining(mc, p);
        AutoSandOrders.msg(p, "Tay tr\u00e1i ch\u01b0a c\u00f3 totem -> mua 1 c\u00e1i \u1edf /shop (GEAR).");
        buyFood = false;
        buyPearl = false;
        buyTotem = true;
        buyRound = 0;
        buyTarget = 1;
        buyRetry = 0;
        gone = 0;
        AutoSandOrders.send(p, "/" + SHOP_COMMAND);
        state = S.BUY_SHOP;
        timeout = 200;
        wait = 4;
    }

    static void beginBuy() {
        buyFood = false;
        buyPearl = false;
        buyTotem = false;
        buyResume = false;
        buyRedo = 0;
        junkDropped = 0;
        dropStep = 0;
        buyRound = 0;
        buyRetry = 0;
        state = S.BUY_PREP;
        timeout = 200;
        wait = 4;
    }

    static void retryBuy(class_310 mc, class_746 p, String why) {
        AutoSandOrders.msg(p, "Mua ch\u01b0a xong (" + why + "), th\u1eed l\u1ea1i l\u1ea7n " + ++buyRetry + "/2.");
        if (AutoSandOrders.screenBlocks(mc)) {
            p.method_7346();
        }
        AutoSandOrders.send(p, "/" + SHOP_COMMAND);
        state = S.BUY_SHOP;
        gone = 0;
        timeout = 200;
        wait = 12;
    }

    static void finishBuy(class_310 mc, class_746 p) {
        if (AutoSandOrders.screenBlocks(mc)) {
            p.method_7346();
        }
        if (buyTotem) {
            buyTotem = false;
            totemBuyFails = 0;
            AutoSandOrders.msg(p, "\u0110\u00e3 mua totem, hi\u1ec7n c\u00f3 " + AutoSandOrders.countItem(p, class_1802.field_8288) + " trong t\u00fai.");
            state = S.MINING;
            cooldown = 5;
            AutoSandOrders.startMining(p);
            return;
        }
        if (buyPearl) {
            buyPearl = false;
            AutoSandOrders.msg(p, "\u0110\u00e3 mua ng\u1ecdc Ender, hi\u1ec7n c\u00f3 " + AutoSandOrders.countItem(p, class_1802.field_8634) + ".");
            state = S.MINING;
            cooldown = 5;
            AutoSandOrders.startMining(p);
            return;
        }
        if (buyFood) {
            buyFood = false;
            foodBuyFails = 0;
            foodWarn = false;
            AutoSandOrders.msg(p, "\u0110\u00e3 mua \u0111\u1ed3 \u0103n, hi\u1ec7n c\u00f3 " + AutoSandOrders.countFood(p) + ".");
            state = S.EAT_PREP;
            timeout = 200;
            wait = 4;
            return;
        }
        AutoSandOrders.msg(p, "\u0110\u00e3 mua b\u00ecnh XP, hi\u1ec7n c\u00f3 " + AutoSandOrders.countItem(p, class_1802.field_8287) + " b\u00ecnh.");
        state = S.MEND_PREP;
        step = 0;
        timeout = 200;
        wait = 4;
    }

    static void finishMend(class_310 mc, class_746 p) {
        if (AutoSandOrders.screenBlocks(mc)) {
            p.method_7346();
        }
        boolean still = AutoSandOrders.lowShovel(p) >= 0;
        buyTries = 0;
        needBuy = false;
        state = S.MINING;
        cooldown = still ? 1200 : 60;
        AutoSandOrders.startMining(p);
        AutoSandOrders.msg(p, still ? "X\u1ebbng v\u1eabn c\u00f2n th\u1ea5p. Th\u1eed l\u1ea1i sau 1 ph\u00fat." : "\u0110\u00e3 s\u1eeda xong x\u1ebbng, ti\u1ebfp t\u1ee5c \u0111\u00e0o.");
    }

    static void abort(class_310 mc, String why) {
        class_746 p = mc.field_1724;
        hpEating = false;
        if (p != null) {
            if (AutoSandOrders.screenBlocks(mc)) {
                p.method_7346();
            }
            if (shovelSwapped && mc.field_1761 != null) {
                AutoSandOrders.swapOffhand(mc, p, shovelFrom);
                shovelSwapped = false;
            }
            if (!Float.isNaN(oldXRot)) {
                p.method_36457(oldXRot);
                oldXRot = Float.NaN;
            }
            if (!Float.isNaN(dropXRot)) {
                p.method_36457(dropXRot);
                dropXRot = Float.NaN;
            }
            AutoSandOrders.restoreLook(mc, p);
            AutoSandOrders.startMining(p);
            AutoSandOrders.msg(p, "Hu\u1ef7: " + why);
            if (buyFood && ++foodBuyFails >= 3) {
                autoBuyFood = false;
                AutoSandOrders.save();
                AutoSandOrders.msg(p, "Mua \u0111\u1ed3 \u0103n l\u1ed7i 3 l\u1ea7n, \u0111\u00e3 t\u1eaft t\u1ef1 mua \u0111\u1ed3 \u0103n. Ki\u1ec3m tra l\u1ea1i \u00f4 /shop -> FOOD.");
            }
        }
        if (buyPearl) {
            ++AutoMiner.pearlBuyFails;
            buyPearl = false;
        }
        if (buyTotem) {
            buyTotem = false;
            totemCool = 1200;
            if (++totemBuyFails >= 3) {
                autoTotem = false;
                AutoSandOrders.save();
                if (p != null) {
                    AutoSandOrders.msg(p, "Mua totem l\u1ed7i 3 l\u1ea7n, \u0111\u00e3 t\u1eaft t\u1ef1 totem. Ki\u1ec3m tra l\u1ea1i /shop -> GEAR.");
                }
            }
        }
        buyFood = false;
        state = S.MINING;
        cooldown = 200;
    }

    static void setNuker(class_746 p, boolean on) {
        if (on && (nukerWater || AutoMiner.recovering())) {
            on = false;
        }
        if (nukerState != null && nukerState == on) {
            return;
        }
        nukerState = on;
        // Không gửi .toggle nuker ra chat nữa (tránh spam)
        // AutoSandOrders.send(p, on ? NUKER_ON : NUKER_OFF);
    }

    static int bottleSlot(class_746 p) {
        int i;
        for (i = 3; i < 9; ++i) {
            if (!p.method_31548().method_5438(i).method_31574(class_1802.field_8287)) continue;
            return i;
        }
        for (i = 0; i < 3; ++i) {
            if (!p.method_31548().method_5438(i).method_31574(class_1802.field_8287)) continue;
            return i;
        }
        return reserveWeapon ? 4 : 3;
    }

    static boolean isWeapon(class_1799 st) {
        return st.method_31573(class_3489.field_42611) || st.method_31573(class_3489.field_42612);
    }

    static boolean correctAt(int slot, class_1799 st) {
        if (st.method_7960()) {
            return false;
        }
        return switch (slot) {
            case 0 -> st.method_31573(class_3489.field_42615);
            case 1 -> st.method_31574(class_1802.field_8071);
            case 2 -> st.method_31574(class_1802.field_8858);
            case 3 -> {
                if (reserveWeapon) {
                    yield AutoSandOrders.isWeapon(st);
                }
                yield st.method_31574(class_1802.field_8287);
            }
            default -> st.method_31574(class_1802.field_8287);
        };
    }

    static boolean droppable(class_1799 st) {
        return !st.method_7960() && !st.method_31574(class_1802.field_8287) && !st.method_31573(class_3489.field_42615) && !st.method_31574(class_1802.field_8071) && !st.method_31574(class_1802.field_8634) && !st.method_31574(class_1802.field_8288) && !AutoSandOrders.isWeapon(st) && !AutoSandOrders.edible(st);
    }

    static int buyDropSlot(class_746 p) {
        for (int i = 3; i < 9; ++i) {
            if (!AutoSandOrders.droppable(p.method_31548().method_5438(i))) continue;
            return i;
        }
        return -1;
    }

    static int[] arrangeMove(class_746 p) {
        class_1661 inv = p.method_31548();
        reserveWeapon = false;
        for (int j = 0; j < 36 && !reserveWeapon; ++j) {
            reserveWeapon = AutoSandOrders.isWeapon(inv.method_5438(j));
        }
        for (int i = 0; i < 9; ++i) {
            if (AutoSandOrders.correctAt(i, inv.method_5438(i))) continue;
            int src = -1;
            double bestPct = -1.0;
            for (int j = 0; j < 36; ++j) {
                double pct;
                class_1799 st;
                if (j == i || !AutoSandOrders.correctAt(i, st = inv.method_5438(j)) || j < 9 && AutoSandOrders.correctAt(j, st)) continue;
                double d = pct = i == 0 ? AutoSandOrders.remainingPct(st) : 0.0;
                if (src >= 0 && !(pct > bestPct + 0.001) && (pct != bestPct || j < 9 || src >= 9)) continue;
                src = j;
                bestPct = pct;
            }
            if (src < 0) continue;
            return new int[]{src, i};
        }
        return null;
    }

    static void beginPearlBuy(class_310 mc, class_746 p, int need) {
        AutoSandOrders.stopMining(mc, p);
        AutoSandOrders.msg(p, "Ch\u1ebft xa -> mua ng\u1ecdc Ender \u1edf /shop \u0111\u1ec3 n\u00e9m t\u1edbi ch\u1ed7 ch\u1ebft.");
        buyFood = false;
        buyPearl = true;
        buyTotem = false;
        pearlNeed = Math.max(1, need);
        buyRound = 0;
        buyTarget = Math.max(1, Math.min(4, need));
        buyRetry = 0;
        gone = 0;
        AutoSandOrders.send(p, "/" + SHOP_COMMAND);
        state = S.BUY_SHOP;
        timeout = 200;
        wait = 4;
    }

    static String fmtTime(long ticks) {
        long s = ticks / 20L;
        return String.format(Locale.ROOT, "%d:%02d:%02d", s / 3600L, s / 60L % 60L, s % 60L);
    }

    static String fmtMoney() {
        return String.format(Locale.ROOT, "%,.0f $", (double)statSand * pricePerSand);
    }

    static int menuSlot(int invIdx) {
        return invIdx < 9 ? invIdx + 36 : invIdx;
    }

    static void swapOffhand(class_310 mc, class_746 p, int invIdx) {
        mc.field_1761.method_2906(p.field_7498.field_7763, AutoSandOrders.menuSlot(invIdx), 40, class_1713.field_7791, (class_1657)p);
    }

    static void swapHotbar(class_310 mc, class_746 p, int invIdx, int hotbar) {
        mc.field_1761.method_2906(p.field_7498.field_7763, AutoSandOrders.menuSlot(invIdx), hotbar, class_1713.field_7791, (class_1657)p);
    }

    static void dropStack(class_310 mc, class_746 p, int invIdx) {
        class_1799 st = p.method_31548().method_5438(invIdx);
        if (st.method_7960()) {
            return;
        }
        if (!AutoSandOrders.droppable(st)) {
            return;
        }
        mc.field_1761.method_2906(p.field_7498.field_7763, AutoSandOrders.menuSlot(invIdx), 1, class_1713.field_7795, (class_1657)p);
    }

    static void setSelected(class_746 p, int slot) {
        p.method_31548().method_61496(slot);
    }

    static int getSelected(class_746 p) {
        return p.method_31548().method_67532();
    }

    static int findItem(class_746 p, class_1792 item) {
        for (int i = 0; i < 36; ++i) {
            if (!p.method_31548().method_5438(i).method_31574(item)) continue;
            return i;
        }
        return -1;
    }

    static int countItem(class_746 p, class_1792 item) {
        int n = 0;
        for (int i = 0; i < 36; ++i) {
            class_1799 st = p.method_31548().method_5438(i);
            if (!st.method_31574(item)) continue;
            n += st.method_7947();
        }
        return n;
    }

    static boolean keepItem(class_1799 st) {
        return st.method_31574(class_1802.field_8858) || st.method_31574(class_1802.field_8287) || st.method_31573(class_3489.field_42615) || st.method_31573(class_3489.field_42611) || st.method_31573(class_3489.field_42612) || st.method_31574(class_1802.field_8071) || st.method_31574(class_1802.field_8634) || st.method_31574(class_1802.field_8288) || !extraKeep.isEmpty() && extraKeep.contains(class_7923.field_41178.method_10221((Object)st.method_7909()).toString());
    }

    static int junkSlot(class_746 p) {
        for (int i = 0; i < 36; ++i) {
            class_1799 st = p.method_31548().method_5438(i);
            if (st.method_7960() || AutoSandOrders.keepItem(st) || AutoSandOrders.edible(st)) continue;
            return i;
        }
        return -1;
    }

    static boolean edible(class_1799 st) {
        if (st.method_7960() || !st.method_57826(class_9334.field_50075)) {
            return false;
        }
        return !st.method_31574(class_1802.field_8511) && !st.method_31574(class_1802.field_8680) && !st.method_31574(class_1802.field_8635) && !st.method_31574(class_1802.field_8323) && !st.method_31574(class_1802.field_8463) && !st.method_31574(class_1802.field_8367) && !st.method_31574(class_1802.field_8233) && !st.method_31574(class_1802.field_8766);
    }

    static int findFood(class_746 p) {
        int any = -1;
        for (int i = 0; i < 36; ++i) {
            class_1799 st = p.method_31548().method_5438(i);
            if (!AutoSandOrders.edible(st)) continue;
            if (st.method_31574(class_1802.field_8071)) {
                return i;
            }
            if (any >= 0) continue;
            any = i;
        }
        return any;
    }

    static int countFood(class_746 p) {
        int n = 0;
        for (int i = 0; i < 36; ++i) {
            class_1799 st = p.method_31548().method_5438(i);
            if (!AutoSandOrders.edible(st)) continue;
            n += st.method_7947();
        }
        return n;
    }

    static int boughtCount(class_746 p) {
        if (buyPearl) {
            return AutoSandOrders.countItem(p, class_1802.field_8634);
        }
        if (buyTotem) {
            return AutoSandOrders.countItem(p, class_1802.field_8288);
        }
        return buyFood ? AutoSandOrders.countFood(p) : AutoSandOrders.countItem(p, class_1802.field_8287);
    }

    static boolean boughtAny(class_746 p) {
        return AutoSandOrders.boughtCount(p) > 0;
    }

    static int emptySlot(class_746 p) {
        for (int i = 0; i < 36; ++i) {
            if (!p.method_31548().method_5438(i).method_7960()) continue;
            return i;
        }
        return -1;
    }

    static int toHotbar(class_310 mc, class_746 p, int idx) {
        if (idx < 9) {
            return idx;
        }
        int target = 8;
        for (int i = 0; i < 9; ++i) {
            if (!p.method_31548().method_5438(i).method_7960()) continue;
            target = i;
            break;
        }
        AutoSandOrders.swapHotbar(mc, p, idx, target);
        return target;
    }

    static int hotbarSandSlot(class_746 p) {
        for (int i = 0; i < 9; ++i) {
            if (!p.method_31548().method_5438(i).method_31574(class_1802.field_8858)) continue;
            return i;
        }
        return -1;
    }

    static int hotbarMissing(class_746 p) {
        int need = 0;
        for (int i = 3; i < 9; ++i) {
            class_1799 st = p.method_31548().method_5438(i);
            if (st.method_7960()) {
                need += 64;
                continue;
            }
            if (!st.method_31574(class_1802.field_8287)) continue;
            need += st.method_7914() - st.method_7947();
        }
        return need;
    }

    static boolean isFull(class_746 p) {
        for (int i = 0; i < 36; ++i) {
            class_1799 st = p.method_31548().method_5438(i);
            if (st.method_7960()) {
                return false;
            }
            if (!st.method_31574(class_1802.field_8858) || st.method_7947() >= st.method_7914()) continue;
            return false;
        }
        return true;
    }

    static double remainingPct(class_1799 st) {
        int max = st.method_7936();
        if (max <= 0) {
            return 100.0;
        }
        return (double)(max - st.method_7919()) * 100.0 / (double)max;
    }

    static int lowShovel(class_746 p) {
        int best = -1;
        double bestPct = 101.0;
        for (int i = 0; i < 36; ++i) {
            double pct;
            class_1799 st = p.method_31548().method_5438(i);
            if (st.method_7960() || !st.method_31573(class_3489.field_42615) || !st.method_7963() || !((pct = AutoSandOrders.remainingPct(st)) <= (double)mendPct) || !(pct < bestPct)) continue;
            best = i;
            bestPct = pct;
        }
        return best;
    }

    static class_1707 container(class_310 mc) {
        class_465 sc;
        class_437 class_4372 = mc.field_1755;
        if (class_4372 instanceof class_465 && (class_4372 = (sc = (class_465)class_4372).method_17577()) instanceof class_1707) {
            class_1707 m = (class_1707)class_4372;
            return m;
        }
        return null;
    }

    static void click(class_310 mc, class_746 p, class_1707 h, int slot, class_1713 type) {
        mc.field_1761.method_2906(h.field_7763, slot, 0, type, (class_1657)p);
    }

    static boolean loaded(class_1707 h) {
        int n = h.method_17388() * 9;
        for (int i = 0; i < n && i < h.field_7761.size(); ++i) {
            if (((class_1735)h.field_7761.get(i)).method_7677().method_7960()) continue;
            return true;
        }
        return false;
    }

    static int find(class_1707 h, Predicate<class_1799> pr, int skip) {
        int n = h.method_17388() * 9;
        for (int i = 0; i < n && i < h.field_7761.size(); ++i) {
            class_1799 st;
            if (i == skip || (st = ((class_1735)h.field_7761.get(i)).method_7677()).method_7960() || !pr.test(st)) continue;
            return i;
        }
        return -1;
    }

    static String norm(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            int k = SMALL_CAPS.indexOf(c);
            sb.append(k >= 0 ? (char)(97 + k) : c);
        }
        String t = Normalizer.normalize(sb.toString().toLowerCase(Locale.ROOT), Normalizer.Form.NFD);
        return t.replaceAll("\\p{M}+", "").replace('\u0111', 'd');
    }

    static boolean nameHas(class_1799 st, String ... keys) {
        if (st.method_7960()) {
            return false;
        }
        String n = AutoSandOrders.norm(st.method_7964().getString());
        for (String k : keys) {
            if (!n.contains(AutoSandOrders.norm(k))) continue;
            return true;
        }
        return false;
    }

    static String dump(class_1707 h) {
        StringBuilder sb = new StringBuilder();
        int n = h.method_17388() * 9;
        for (int i = 0; i < n && i < h.field_7761.size(); ++i) {
            class_1799 st = ((class_1735)h.field_7761.get(i)).method_7677();
            if (st.method_7960()) continue;
            sb.append(i).append('=').append(st.method_7964().getString()).append(" | ");
        }
        return sb.toString();
    }

    static double parseMoney(String text) {
        double v;
        Matcher m = MONEY_RE.matcher(text);
        if (!m.find()) {
            return 0.0;
        }
        String n = m.group(1);
        while (n.endsWith(".") || n.endsWith(",")) {
            n = n.substring(0, n.length() - 1);
        }
        if (n.isEmpty()) {
            return 0.0;
        }
        int lc = n.lastIndexOf(44);
        int ld = n.lastIndexOf(46);
        if (lc >= 0 && ld >= 0) {
            n = lc > ld ? n.replace(".", "").replace(',', '.') : n.replace(",", "");
        } else if (lc >= 0) {
            n = n.length() - lc - 1 == 3 ? n.replace(",", "") : n.replace(',', '.');
        } else if (ld >= 0 && n.indexOf(46) != ld) {
            n = n.replace(".", "");
        }
        try {
            v = Double.parseDouble(n);
        }
        catch (NumberFormatException e) {
            return 0.0;
        }
        String suf = m.group(2);
        if (suf != null) {
            switch (Character.toLowerCase(suf.charAt(0))) {
                case 'k': {
                    v *= 1000.0;
                    break;
                }
                case 'm': {
                    v *= 1000000.0;
                    break;
                }
                case 'b': {
                    v *= 1.0E9;
                    break;
                }
            }
        }
        return v;
    }

    static List<String> loreLines(class_1799 st) {
        ArrayList<String> out = new ArrayList<String>();
        if (st.method_7960()) {
            return out;
        }
        class_9290 lore = (class_9290)st.method_58695(class_9334.field_49632, (Object)class_9290.field_49340);
        for (class_2561 c : lore.comp_2400()) {
            out.add(c.getString());
        }
        return out;
    }

    static double lorePrice(class_1799 st) {
        for (String line : AutoSandOrders.loreLines(st)) {
            double v;
            if (!line.contains("$") && !PRICE_WORD.matcher(AutoSandOrders.norm(line)).find() || !((v = AutoSandOrders.parseMoney(line)) > 0.0)) continue;
            return v;
        }
        return 0.0;
    }

    static double menuCost(class_1707 h) {
        double best = 0.0;
        int n = h.method_17388() * 9;
        for (int i = 0; i < n && i < h.field_7761.size(); ++i) {
            best = Math.max(best, AutoSandOrders.lorePrice(((class_1735)h.field_7761.get(i)).method_7677()));
        }
        return best;
    }

    static String overBudget(double cost) {
        if (cost <= 0.0) {
            return null;
        }
        if (buyTotem) {
            if (maxTotemUnitPrice > 0.0 && cost > maxTotemUnitPrice) {
                return "gi\u00e1 totem " + cost + " v\u01b0\u1ee3t gi\u1edbi h\u1ea1n " + maxTotemUnitPrice;
            }
            if (maxTotemSpend > 0.0 && totemSpent + cost > maxTotemSpend) {
                return "t\u1ed5ng chi totem s\u1ebd v\u01b0\u1ee3t gi\u1edbi h\u1ea1n " + maxTotemSpend;
            }
        } else if (!buyFood && !buyPearl) {
            double unit = cost / 64.0;
            if (maxXpUnitPrice > 0.0 && unit > maxXpUnitPrice) {
                return "gi\u00e1 b\u00ecnh XP " + String.format(Locale.ROOT, "%.2f", unit) + " v\u01b0\u1ee3t gi\u1edbi h\u1ea1n " + maxXpUnitPrice;
            }
            if (maxXpSpend > 0.0 && xpSpent + cost > maxXpSpend) {
                return "t\u1ed5ng chi s\u1eeda \u0111\u1ed3 s\u1ebd v\u01b0\u1ee3t gi\u1edbi h\u1ea1n " + maxXpSpend;
            }
        }
        return null;
    }

    static int startTest(String kind) {
        class_310 mc = class_310.method_1551();
        if (mc.field_1724 == null) {
            return 0;
        }
        if (enabled) {
            AutoSandOrders.msg(mc.field_1724, "T\u1eaft bot tr\u01b0\u1edbc khi ch\u1ea1y test.");
            return 0;
        }
        testKind = kind;
        testTicks = 0;
        AutoSandOrders.msg(mc.field_1724, "Test " + kind + ": \u0111ang m\u1edf b\u1ea3ng...");
        return 1;
    }

    static void testTick(class_310 mc, class_746 p) {
        class_1707 h;
        if (enabled || p == null) {
            testKind = null;
            return;
        }
        if (testTicks == 0) {
            AutoSandOrders.send(p, "/" + (testKind.equals("orders") ? ORDER_COMMAND : SHOP_COMMAND));
        }
        if ((h = AutoSandOrders.container(mc)) != null && ++testTicks > 10 && AutoSandOrders.loaded(h)) {
            AutoSandOrders.msg(p, "[Test " + testKind + "] b\u1ea3ng " + h.method_17388() + " h\u00e0ng. C\u00e1c \u00f4: " + AutoSandOrders.dump(h));
            int shown = 0;
            int n = h.method_17388() * 9;
            for (int i = 0; i < n && i < h.field_7761.size() && shown < 4; ++i) {
                boolean want;
                class_1799 st = ((class_1735)h.field_7761.get(i)).method_7677();
                boolean bl = testKind.equals("orders") ? st.method_31574(class_1802.field_8858) : (want = !AutoSandOrders.loreLines(st).isEmpty());
                if (!want) continue;
                ++shown;
                AutoSandOrders.msg(p, "  \u00f4 " + i + " " + st.method_7964().getString() + " | gi\u00e1 \u0111\u1ecdc \u0111\u01b0\u1ee3c = " + AutoSandOrders.lorePrice(st) + " | lore: " + String.join((CharSequence)" / ", AutoSandOrders.loreLines(st)));
            }
            p.method_7346();
            testKind = null;
            return;
        }
        if (testTicks > 100) {
            if (AutoSandOrders.screenBlocks(mc)) {
                p.method_7346();
            }
            AutoSandOrders.msg(p, "[Test " + testKind + "] kh\u00f4ng m\u1edf \u0111\u01b0\u1ee3c b\u1ea3ng sau 5 gi\u00e2y (ki\u1ec3m tra l\u1ec7nh /autosand cmd | shop).");
            testKind = null;
        }
    }

    static int weaponSlot(class_746 p) {
        int axe = -1;
        for (int i = 0; i < 9; ++i) {
            class_1799 st = p.method_31548().method_5438(i);
            if (st.method_31573(class_3489.field_42611)) {
                return i;
            }
            if (axe >= 0 || !st.method_31573(class_3489.field_42612)) continue;
            axe = i;
        }
        return axe;
    }

    static void endDefend(class_310 mc, class_746 p) {
        mc.field_1690.field_1894.method_23481(false);
        if (defendPrevSlot >= 0) {
            AutoSandOrders.setSelected(p, defendPrevSlot);
            defendPrevSlot = -1;
        }
        defendTicks = 0;
        defendIdle = 0;
        defendAttackWait = 0;
        defendAimWait = 0;
    }

    static boolean defendTick(class_310 mc, class_746 p) {
        class_638 lv = mc.field_1687;
        if (lv == null || mc.field_1761 == null) {
            return false;
        }
        if (defendCool > 0) {
            --defendCool;
            return false;
        }
        if (shovelSwapped || p.method_6115() || p.method_5799() || p.method_5771()) {
            return false;
        }
        class_1309 best = null;
        double bestD = Double.MAX_VALUE;
        for (class_1309 e : lv.method_18467(class_1309.class, p.method_5829().method_1014((double)defenseRadius))) {
            double d;
            if (e == p || !e.method_5805() || e instanceof class_1657 || !(e instanceof class_1569) || !p.method_6057((class_1297)e) || !((d = p.method_5858((class_1297)e)) < bestD)) continue;
            bestD = d;
            best = e;
        }
        if (best == null) {
            if (defendPrevSlot >= 0 && ++defendIdle > 10) {
                AutoSandOrders.endDefend(mc, p);
            }
            return false;
        }
        int w = AutoSandOrders.weaponSlot(p);
        if (w < 0) {
            return false;
        }
        defendIdle = 0;
        if (++defendTicks > 300) {
            AutoSandOrders.endDefend(mc, p);
            defendCool = 300;
            return false;
        }
        if (defendPrevSlot < 0) {
            defendPrevSlot = AutoSandOrders.getSelected(p);
        }
        if (AutoSandOrders.getSelected(p) != w) {
            AutoSandOrders.setSelected(p, w);
            return true;
        }
        mc.field_1690.field_1886.method_23481(false);
        if (defendAttackWait > 0) {
            --defendAttackWait;
        }
        AutoMiner.aimAt(p, best.method_5829().method_1005());
        double dist = Math.sqrt(bestD);
        mc.field_1690.field_1894.method_23481(dist > 2.7);
        if (dist <= 2.9) {
            if (defendAimWait < 2) {
                ++defendAimWait;
                return true;
            }
            if (defendAttackWait == 0 && p.method_7261(0.5f) >= 0.9f && p.method_6057((class_1297)best) && best.method_5805()) {
                mc.field_1761.method_2918((class_1657)p, (class_1297)best);
                p.method_6104(class_1268.field_5808);
                defendAttackWait = 10;
                defendAimWait = 0;
            }
        } else {
            defendAimWait = 0;
        }
        return true;
    }

    static void perfTick(class_310 mc) {
        try {
            int fps;
            boolean want;
            boolean bl = want = lowLoad && enabled && mc.field_1724 != null;
            if (!want) {
                AutoSandOrders.restorePerf(mc);
                return;
            }
            if (origFps == null) {
                origFps = (Integer)mc.field_1690.method_42524().method_41753();
                origView = (Integer)mc.field_1690.method_42503().method_41753();
            }
            int n = fps = mc.method_1569() ? fgFps : bgFps;
            if ((Integer)mc.field_1690.method_42524().method_41753() != fps) {
                mc.field_1690.method_42524().method_41748((Object)fps);
            }
            if ((Integer)mc.field_1690.method_42503().method_41753() != lowLoadView) {
                mc.field_1690.method_42503().method_41748((Object)lowLoadView);
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    static void restorePerf(class_310 mc) {
        if (origFps == null) {
            return;
        }
        try {
            mc.field_1690.method_42524().method_41748((Object)origFps);
            mc.field_1690.method_42503().method_41748((Object)origView);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        origFps = null;
        origView = null;
    }

    static String keepEdit(String raw, boolean add) {
        Object id = raw.trim().toLowerCase(Locale.ROOT);
        if (((String)id).isEmpty()) {
            return "Thi\u1ebfu id v\u1eadt ph\u1ea9m (vd. minecraft:diamond).";
        }
        if (!((String)id).contains(":")) {
            id = "minecraft:" + (String)id;
        }
        if (!add) {
            return extraKeep.remove(id) ? AutoSandOrders.saveMsg("\u0110\u00e3 b\u1ecf gi\u1eef " + (String)id) : "Kh\u00f4ng c\u00f3 " + (String)id + " trong danh s\u00e1ch gi\u1eef th\u00eam.";
        }
        boolean exists = false;
        for (class_1792 it : class_7923.field_41178) {
            if (!class_7923.field_41178.method_10221((Object)it).toString().equals(id)) continue;
            exists = true;
            break;
        }
        if (!exists) {
            return "Kh\u00f4ng c\u00f3 v\u1eadt ph\u1ea9m \"" + (String)id + "\".";
        }
        extraKeep.add((String)id);
        return AutoSandOrders.saveMsg("\u0110\u00e3 gi\u1eef th\u00eam " + (String)id + " (s\u1ebd kh\u00f4ng b\u1ecb v\u1ee9t).");
    }

    static String saveMsg(String m) {
        AutoSandOrders.save();
        return m;
    }

    static int nextInt(int[] arr, int cur) {
        for (int v : arr) {
            if (v <= cur) continue;
            return v;
        }
        return arr[0];
    }

    static double nextDbl(double[] arr, double cur) {
        for (double v : arr) {
            if (!(v > cur + 1.0E-4)) continue;
            return v;
        }
        return arr[0];
    }

    static void send(class_746 p, String s) {
        if (s.startsWith("/")) {
            p.field_3944.method_45730(s.substring(1));
        } else {
            p.field_3944.method_45729(s);
        }
    }

    static void msg(class_746 p, String t) {
        p.method_7353((class_2561)class_2561.method_43470((String)("[AutoSand] " + t)), false);
    }

    static boolean passable(class_638 lv, class_2338 pos) {
        return lv.method_8320(pos).method_26220((class_1922)lv, pos).method_1110();
    }

    static boolean liquidAt(class_638 lv, class_2338 pos) {
        class_3610 fs = lv.method_8320(pos).method_26227();
        return fs.method_15767(class_3486.field_15517) || fs.method_15767(class_3486.field_15518);
    }

    static boolean trapped(class_638 lv, class_2338 f) {
        if (!AutoSandOrders.passable(lv, f.method_10084()) || !AutoSandOrders.passable(lv, f.method_10086(2))) {
            return false;
        }
        for (class_2350 d : HORIZ) {
            class_2338 n = f.method_10093(d);
            boolean feet = AutoSandOrders.passable(lv, n);
            boolean head = AutoSandOrders.passable(lv, n.method_10084());
            if (feet && head) {
                return false;
            }
            if (feet || !head || !AutoSandOrders.passable(lv, n.method_10086(2))) continue;
            return false;
        }
        return true;
    }

    static boolean lavaAt(class_638 lv, class_2338 pos) {
        return lv.method_8320(pos).method_26227().method_15767(class_3486.field_15518);
    }

    static boolean deepWater(class_638 lv, class_2338 a) {
        return AutoSandOrders.liquidAt(lv, a) && AutoSandOrders.liquidAt(lv, a.method_10074()) || AutoSandOrders.liquidAt(lv, a.method_10074()) && AutoSandOrders.liquidAt(lv, a.method_10087(2));
    }

    static boolean danger(class_746 p) {
        class_3610 fs;
        if (p.method_5771()) {
            return true;
        }
        if (p.method_5799() && !(fs = p.method_73183().method_8316(p.method_24515())).method_15769() && !fs.method_15771()) {
            return true;
        }
        return p.method_5799() && (p.method_5869() || !p.method_24828());
    }

    static boolean caveStep(class_638 lv, class_2338 from, class_2338 to, boolean airOnly) {
        if (!airOnly) {
            return false;
        }
        int ln = lv.method_8314(class_1944.field_9284, to);
        return ln <= 7 && ln < lv.method_8314(class_1944.field_9284, from);
    }

    static boolean hazardDir(class_638 lv, double x, double y, double z, double dx, double dz) {
        for (double k : new double[]{1.0, 1.8}) {
            class_2338 a = class_2338.method_49637((double)(x + dx * k), (double)(y + 0.1), (double)(z + dz * k));
            if (avoidLiquid && (AutoSandOrders.lavaAt(lv, a) || AutoSandOrders.lavaAt(lv, a.method_10074()) || AutoSandOrders.deepWater(lv, a))) {
                return true;
            }
            if (avoidHole && AutoSandOrders.passable(lv, a) && AutoSandOrders.passable(lv, a.method_10084()) && AutoSandOrders.caveStep(lv, class_2338.method_49637((double)x, (double)(y + 0.1), (double)z), a, true)) {
                return true;
            }
            if (!avoidHole || !AutoSandOrders.passable(lv, a)) continue;
            boolean drop = true;
            for (int i = 1; i <= 3; ++i) {
                if (AutoSandOrders.passable(lv, a.method_10087(i))) continue;
                drop = false;
                break;
            }
            if (!drop) continue;
            return true;
        }
        return false;
    }

    static class_2338 findShore(class_638 lv, class_746 p) {
        class_2338 o = p.method_24515();
        class_2338 best = null;
        double bestD = Double.MAX_VALUE;
        for (int dx = -10; dx <= 10; ++dx) {
            block1: for (int dz = -10; dz <= 10; ++dz) {
                double d = dx * dx + dz * dz;
                if (d >= bestD) continue;
                for (int dy = 2; dy >= -2; --dy) {
                    class_2338 f = o.method_10069(dx, dy, dz);
                    class_2338 g = f.method_10074();
                    if (AutoSandOrders.lavaAt(lv, f) || AutoSandOrders.lavaAt(lv, f.method_10084()) || AutoSandOrders.lavaAt(lv, g) || AutoSandOrders.liquidAt(lv, f) || AutoSandOrders.liquidAt(lv, f.method_10084()) || !AutoSandOrders.passable(lv, f) || !AutoSandOrders.passable(lv, f.method_10084()) || AutoSandOrders.passable(lv, g)) continue;
                    best = f;
                    bestD = d;
                    continue block1;
                }
            }
        }
        return best;
    }

    static boolean placeable(class_1799 st) {
        return !st.method_7960() && (st.method_31574(class_1802.field_8858) || st.method_7909() instanceof class_1747);
    }

    static int findPlaceable(class_746 p) {
        int idx = AutoSandOrders.findItem(p, class_1802.field_8858);
        if (idx >= 0) {
            return idx;
        }
        for (int i = 0; i < 36; ++i) {
            if (!AutoSandOrders.placeable(p.method_31548().method_5438(i))) continue;
            return i;
        }
        return -1;
    }

    static int hotbarPlaceSlot(class_746 p) {
        int s = AutoSandOrders.hotbarSandSlot(p);
        if (s >= 0) {
            return s;
        }
        for (int i = 0; i < 9; ++i) {
            if (!AutoSandOrders.placeable(p.method_31548().method_5438(i))) continue;
            return i;
        }
        return -1;
    }

    static void guardReset(class_310 mc, class_746 p) {
        if ((guard == G.ESCAPE || guard == G.BRIDGE) && p != null && mc.field_1761 != null) {
            if (escSwapIdx >= 0) {
                AutoSandOrders.swapHotbar(mc, p, escSwapIdx, escSlot);
                escSwapIdx = -1;
            }
            AutoSandOrders.setSelected(p, escPrevSel);
            if (!Float.isNaN(escPitch)) {
                p.method_36457(escPitch);
                escPitch = Float.NaN;
            }
        }
        guard = G.NONE;
        mc.field_1690.field_1903.method_23481(false);
        trapTicks = 0;
        guardCool = 0;
        wdTick = 0;
        wdX = Double.NaN;
        pickTarget = null;
        wdIdle = 0;
        wdGap = 100;
    }

    static void endGuard(class_310 mc, class_746 p) {
        mc.field_1690.field_1903.method_23481(false);
        AutoSandOrders.releaseKeys(mc);
        guard = G.NONE;
        guardCool = 60;
        wetTicks = 0;
        trapTicks = 0;
        wdTick = 0;
        wdX = Double.NaN;
        AutoSandOrders.startMining(p);
    }

    static boolean guardTick(class_310 mc, class_746 p) {
        class_1542 it;
        boolean pocket;
        class_638 lv = mc.field_1687;
        if (lv == null) {
            return false;
        }
        if (guard == G.LIQUID) {
            AutoSandOrders.tickLiquid(mc, p, lv);
            return true;
        }
        if (guard == G.ESCAPE) {
            AutoSandOrders.tickEscape(mc, p, lv);
            return true;
        }
        if (guard == G.SIDE) {
            AutoSandOrders.tickSide(mc, p, lv);
            return true;
        }
        if (guard == G.PICKUP) {
            AutoSandOrders.tickPickup(mc, p, lv);
            return true;
        }
        if (guard == G.BRIDGE) {
            AutoSandOrders.tickBridge(mc, p, lv);
            return true;
        }
        if (guard == G.UNSTICK) {
            AutoSandOrders.tickUnstick(mc, p, lv);
            return true;
        }
        if (guardCool > 0) {
            --guardCool;
        }
        if (pickCool > 0) {
            --pickCool;
        }
        if (sideLock > 0) {
            --sideLock;
        }
        if (sideWindow > 0 && --sideWindow == 0) {
            sideStrikes = 0;
        }
        if (avoidLiquid && AutoSandOrders.danger(p)) {
            int need;
            int n = p.method_5771() ? 3 : (need = mode == Mode.BUILTIN ? 2 : 15);
            if (++wetTicks >= need) {
                wetTicks = 0;
                AutoSandOrders.stopMining(mc, p);
                guard = G.LIQUID;
                guardTicks = 0;
                shore = null;
                AutoSandOrders.msg(p, p.method_5771() ? "\u0110ang \u1edf trong lava -> t\u1ef1 tho\u00e1t l\u00ean b\u1edd." : "K\u1eb9t trong n\u01b0\u1edbc s\u00e2u -> t\u1ef1 b\u01a1i l\u00ean b\u1edd.");
                return true;
            }
        } else {
            wetTicks = 0;
        }
        if (escCool > 0) {
            --escCool;
        }
        boolean shaftDigging = AutoMiner.shaft && !AutoMiner.shaftBlocked;
        boolean nukerWait = AutoMiner.holdingForNuker(lv);
        boolean tight = avoidHole && !shaftDigging && !nukerWait && p.method_24828() && AutoSandOrders.trapped(lv, p.method_24515());
        boolean bl = pocket = avoidHole && !shaftDigging && !nukerWait && !tight && p.method_24828() && escCool <= 0 && AutoSandOrders.pocketStuck(mc, p, lv);
        if ((tight || pocket) && escCool <= 0) {
            if (pocket || ++trapTicks >= 4) {
                trapTicks = 0;
                idleAcc = 0;
                encCache = false;
                if (AutoSandOrders.startEscape(mc, p)) {
                    return true;
                }
            }
        } else {
            trapTicks = 0;
        }
        if (AutoSandOrders.jamCheck(mc, p, lv)) {
            return true;
        }
        if (bridgeCool > 0) {
            --bridgeCool;
        }
        if (avoidLiquid && bridgeWater && bridgeCool <= 0 && p.method_24828() && AutoSandOrders.surroundedByWater(lv, p.method_24515())) {
            if (++surroundTicks >= 20) {
                surroundTicks = 0;
                if (AutoSandOrders.startBridge(mc, p)) {
                    return true;
                }
            }
        } else {
            surroundTicks = 0;
        }
        if (mode != Mode.BUILTIN && (avoidLiquid || avoidHole) && guardCool <= 0 && sideLock <= 0 && p.method_24828()) {
            class_243 v = p.method_18798();
            double h = Math.hypot(v.field_1352, v.field_1350);
            if (h > 0.08 && AutoSandOrders.hazardDir(lv, p.method_23317(), p.method_23318(), p.method_23321(), v.field_1352 / h, v.field_1350 / h)) {
                AutoSandOrders.startSide(mc, p, lv, Math.toDegrees(Math.atan2(-v.field_1352, v.field_1350)));
                return true;
            }
        }
        if (mode != Mode.BUILTIN && pickupRadius > 0 && pickCool <= 0 && guardCool <= 0 && p.method_24828() && !AutoSandOrders.isFull(p) && (it = AutoSandOrders.nearestSand(lv, p)) != null) {
            AutoSandOrders.startPickup(mc, p, it);
            return true;
        }
        if (autoRevive && mode != Mode.BUILTIN && useNuker && ++wdTick >= 20) {
            wdTick = 0;
            double moved = Double.isNaN(wdX) ? 99.0 : Math.hypot(p.method_23317() - wdX, p.method_23321() - wdZ);
            wdX = p.method_23317();
            wdZ = p.method_23321();
            int sandNow = AutoSandOrders.countItem(p, class_1802.field_8858);
            boolean working = moved > 0.15 || mc.field_1761.method_2923() || sandNow != wdSand || wait > 0;
            wdSand = sandNow;
            if (working) {
                wdIdle = 0;
                wdGap = 100;
                wdFails = 0;
            } else if ((wdIdle += 20) >= wdGap) {
                wdIdle = 0;
                wdGap = Math.min(400, wdGap * 2);
                if (++wdFails <= 2 || wdFails % 5 == 0) {
                    AutoSandOrders.msg(p, "Nuker c\u00f3 v\u1ebb \u0111\u00e3 d\u1eebng -> b\u1eadt l\u1ea1i (l\u1ea7n " + wdFails + ").");
                }
                if (wdFails % 3 == 0) {
                    AutoSandOrders.stopMining(mc, p);
                }
                AutoSandOrders.startMining(p);
            }
        }
        return false;
    }

    static boolean enclosed(class_638 lv, class_2338 start) {
        int radius = 7;
        int limit = 700;
        ArrayDeque<class_2338> queue = new ArrayDeque<class_2338>();
        HashSet<Long> seen = new HashSet<Long>();
        queue.add(start);
        seen.add(start.method_10063());
        int count = 0;
        while (!queue.isEmpty()) {
            class_2338 c = (class_2338)queue.poll();
            if (++count > 700) {
                return false;
            }
            for (class_2350 d : HORIZ) {
                class_265 sh;
                class_2338 n = c.method_10093(d);
                if (Math.abs(n.method_10263() - start.method_10263()) > 7 || Math.abs(n.method_10260() - start.method_10260()) > 7) {
                    return false;
                }
                class_2338 land = null;
                if (AutoSandOrders.passable(lv, n) && AutoSandOrders.passable(lv, n.method_10084())) {
                    if (AutoSandOrders.liquidAt(lv, n) || AutoSandOrders.liquidAt(lv, n.method_10074())) continue;
                    class_2338 m = n;
                    for (int fall = 0; AutoSandOrders.passable(lv, m.method_10074()) && fall < 3; ++fall) {
                        m = m.method_10074();
                    }
                    if (!AutoSandOrders.passable(lv, m.method_10074())) {
                        land = m;
                    }
                } else if (!AutoSandOrders.passable(lv, n) && AutoSandOrders.passable(lv, n.method_10084()) && AutoSandOrders.passable(lv, n.method_10086(2)) && AutoSandOrders.passable(lv, c.method_10086(2)) && !(sh = lv.method_8320(n).method_26220((class_1922)lv, n)).method_1110() && sh.method_1105(class_2350.class_2351.field_11052) <= 1.0001 && !AutoSandOrders.liquidAt(lv, n.method_10084())) {
                    land = n.method_10084();
                }
                if (land == null || !seen.add(land.method_10063())) continue;
                queue.add(land);
            }
        }
        return true;
    }

    static boolean pocketStuck(class_310 mc, class_746 p, class_638 lv) {
        if (wait > 0 || cooldown > 0 || p.method_5799() || p.method_5771() || mode == Mode.BUILTIN && AutoMiner.recovering()) {
            idleAcc = 0;
            idleTick = 0;
            encCache = false;
            return false;
        }
        if (mc.field_1761 != null && mc.field_1761.method_2923()) {
            idleWorked = true;
        }
        if (++idleTick >= 20) {
            idleTick = 0;
            double moved = Double.isNaN(idleX) ? 99.0 : Math.hypot(p.method_23317() - idleX, p.method_23321() - idleZ);
            idleX = p.method_23317();
            idleZ = p.method_23321();
            int sandNow = AutoSandOrders.countItem(p, class_1802.field_8858);
            boolean worked = idleWorked || moved > 1.5 || sandNow != idleSand;
            idleWorked = false;
            idleSand = sandNow;
            if (worked) {
                idleAcc = 0;
                encCache = false;
            } else if ((idleAcc += 20) >= 60) {
                encCache = AutoSandOrders.enclosed(lv, p.method_24515());
            }
        }
        return idleAcc >= 60 && encCache;
    }

    static int freeRun(class_638 lv, class_746 p, float yaw) {
        double r = Math.toRadians(yaw);
        double dx = -Math.sin(r);
        double dz = Math.cos(r);
        int y = p.method_24515().method_10264();
        int run = 0;
        for (int k = 1; k <= 6; ++k) {
            class_2338 a = class_2338.method_49637((double)(p.method_23317() + dx * (double)k), (double)((double)y + 0.1), (double)(p.method_23321() + dz * (double)k));
            if (!AutoSandOrders.passable(lv, a) || !AutoSandOrders.passable(lv, a.method_10084())) {
                if (AutoSandOrders.passable(lv, a) || !AutoSandOrders.passable(lv, a.method_10084()) || !AutoSandOrders.passable(lv, a.method_10086(2))) break;
                a = a.method_10084();
                ++y;
            }
            if (AutoSandOrders.lavaAt(lv, a) || AutoSandOrders.lavaAt(lv, a.method_10074()) || AutoSandOrders.deepWater(lv, a) || AutoSandOrders.passable(lv, a.method_10074()) && AutoSandOrders.passable(lv, a.method_10087(2)) && AutoSandOrders.passable(lv, a.method_10087(3))) break;
            ++run;
        }
        return run;
    }

    static boolean jamCheck(class_310 mc, class_746 p, class_638 lv) {
        boolean jam;
        int win;
        if (unWindow > 0 && --unWindow == 0) {
            unStrikes = 0;
        }
        if (unLock > 0) {
            --unLock;
            jamTick = 0;
            return false;
        }
        if (mode == Mode.NUKER || !mc.field_1690.field_1894.method_1434() || p.method_5799() || p.method_5771() || wait > 0) {
            jamTick = 0;
            jamHit = 0;
            return false;
        }
        if (jamTick == 0) {
            jamX = p.method_23317();
            jamZ = p.method_23321();
            jamHit = 0;
            jamSand = AutoSandOrders.countItem(p, class_1802.field_8858);
        }
        ++jamTick;
        if (p.field_5976) {
            ++jamHit;
        }
        int n = win = mode == Mode.BUILTIN ? 60 : 40;
        if (jamTick < win) {
            return false;
        }
        jamTick = 0;
        boolean bl = jam = Math.hypot(p.method_23317() - jamX, p.method_23321() - jamZ) < 0.6 && jamHit >= win / 2 && AutoSandOrders.countItem(p, class_1802.field_8858) <= jamSand;
        if (!jam) {
            return false;
        }
        if (AutoSandOrders.startUnstick(mc, p, lv)) {
            return true;
        }
        if (avoidHole && escCool <= 0 && AutoSandOrders.enclosed(lv, p.method_24515()) && AutoSandOrders.startEscape(mc, p)) {
            return true;
        }
        unLock = 100;
        return false;
    }

    static boolean startUnstick(class_310 mc, class_746 p, class_638 lv) {
        float base;
        float bestYaw = base = p.method_36454();
        int best = -1;
        for (float off : new float[]{90.0f, -90.0f, 180.0f, 135.0f, -135.0f, 45.0f, -45.0f}) {
            int run = AutoSandOrders.freeRun(lv, p, base + off);
            if (run <= best) continue;
            best = run;
            bestYaw = base + off;
        }
        if (best < 2) {
            return false;
        }
        if (++unStrikes >= 4) {
            unStrikes = 0;
            unWindow = 0;
            unLock = 200;
            AutoSandOrders.msg(p, "\u0110\u00e2m t\u01b0\u1eddng nhi\u1ec1u l\u1ea7n li\u00ean ti\u1ebfp -> t\u1ea1m ngh\u1ec9 tho\u00e1t t\u01b0\u1eddng 10 gi\u00e2y.");
            return false;
        }
        if (unWindow <= 0) {
            unWindow = 900;
        }
        if (unStrikes == 1) {
            AutoSandOrders.msg(p, "\u0110\u00e2m v\u00e0o t\u01b0\u1eddng -> quay sang h\u01b0\u1edbng kh\u00e1c.");
        }
        AutoSandOrders.stopMining(mc, p);
        unYaw = bestYaw;
        unX = p.method_23317();
        unZ = p.method_23321();
        unTicks = 0;
        guard = G.UNSTICK;
        return true;
    }

    static void tickUnstick(class_310 mc, class_746 p, class_638 lv) {
        p.method_36456(unYaw);
        double r = Math.toRadians(unYaw);
        if (++unTicks > 30 || Math.hypot(p.method_23317() - unX, p.method_23321() - unZ) >= 3.0 || p.method_5799() || p.method_5771() || AutoSandOrders.hazardDir(lv, p.method_23317(), p.method_23318(), p.method_23321(), -Math.sin(r), Math.cos(r))) {
            AutoSandOrders.endGuard(mc, p);
            return;
        }
        mc.field_1690.field_1894.method_23481(true);
        mc.field_1690.field_1903.method_23481(p.field_5976 && p.method_24828());
    }

    static boolean walkable(class_638 lv, class_2338 n) {
        return AutoSandOrders.passable(lv, n) && AutoSandOrders.passable(lv, n.method_10084()) && !AutoSandOrders.passable(lv, n.method_10074());
    }

    static boolean surroundedByWater(class_638 lv, class_2338 f) {
        boolean deep = false;
        for (class_2350 d : HORIZ) {
            class_2338 n = f.method_10093(d);
            if (AutoSandOrders.walkable(lv, n)) {
                return false;
            }
            if (!AutoSandOrders.passable(lv, n) && AutoSandOrders.passable(lv, n.method_10084()) && AutoSandOrders.passable(lv, n.method_10086(2))) {
                return false;
            }
            if (!AutoSandOrders.deepWater(lv, n)) continue;
            deep = true;
        }
        return deep;
    }

    static class_2338 findDry(class_638 lv, class_746 p, int radius) {
        class_2338 o = p.method_24515();
        class_2338 best = null;
        double bestD = Double.MAX_VALUE;
        for (int dx = -radius; dx <= radius; ++dx) {
            block1: for (int dz = -radius; dz <= radius; ++dz) {
                double d = dx * dx + dz * dz;
                if (d < 9.0 || d >= bestD) continue;
                for (int dy = 2; dy >= -2; --dy) {
                    class_2338 f = o.method_10069(dx, dy, dz);
                    if (!AutoSandOrders.walkable(lv, f) || AutoSandOrders.liquidAt(lv, f) || AutoSandOrders.liquidAt(lv, f.method_10084())) continue;
                    int land = 0;
                    for (class_2350 h : HORIZ) {
                        class_2338 n = f.method_10093(h);
                        if (!AutoSandOrders.walkable(lv, n) || AutoSandOrders.liquidAt(lv, n)) continue;
                        ++land;
                    }
                    if (land < 3) continue;
                    best = f;
                    bestD = d;
                    continue block1;
                }
            }
        }
        return best;
    }

    static boolean startBridge(class_310 mc, class_746 p) {
        class_638 lv = mc.field_1687;
        if (lv == null) {
            return false;
        }
        class_2338 t = AutoSandOrders.findDry(lv, p, 16);
        if (t == null) {
            AutoSandOrders.msg(p, "B\u1ecb n\u01b0\u1edbc bao quanh nh\u01b0ng kh\u00f4ng th\u1ea5y b\u1edd trong 16 \u00f4.");
            bridgeCool = 400;
            return false;
        }
        int slot = AutoSandOrders.hotbarPlaceSlot(p);
        int swapped = -1;
        if (slot < 0) {
            int idx = AutoSandOrders.findPlaceable(p);
            if (idx < 0) {
                AutoSandOrders.msg(p, "B\u1ecb n\u01b0\u1edbc bao quanh nh\u01b0ng kh\u00f4ng c\u00f3 block \u0111\u1ec3 b\u1eafc c\u1ea7u.");
                bridgeCool = 400;
                return false;
            }
            slot = AutoSandOrders.toHotbar(mc, p, idx);
            swapped = idx;
        }
        AutoSandOrders.stopMining(mc, p);
        bridgeTarget = t;
        bridgeDir = null;
        escSlot = slot;
        escSwapIdx = swapped;
        escPrevSel = AutoSandOrders.getSelected(p);
        escPitch = p.method_36455();
        AutoSandOrders.setSelected(p, slot);
        brPlaced = 0;
        brCool = 0;
        guardTicks = 0;
        guard = G.BRIDGE;
        AutoSandOrders.msg(p, "B\u1ecb n\u01b0\u1edbc bao quanh -> \u0111\u1eb7t block b\u1eafc c\u1ea7u v\u00e0o b\u1edd.");
        return true;
    }

    static void tickBridge(class_310 mc, class_746 p, class_638 lv) {
        class_2350 want;
        class_2338 nt;
        double dz;
        ++guardTicks;
        AutoSandOrders.setSelected(p, escSlot);
        if (bridgeTarget == null) {
            AutoSandOrders.finishBridge(mc, p, "m\u1ea5t m\u1ee5c ti\u00eau", 200);
            return;
        }
        double dx = (double)bridgeTarget.method_10263() + 0.5 - p.method_23317();
        if (Math.hypot(dx, dz = (double)bridgeTarget.method_10260() + 0.5 - p.method_23321()) < 1.2 && p.method_24828() && !AutoSandOrders.danger(p)) {
            AutoSandOrders.finishBridge(mc, p, null, 100);
            return;
        }
        if (guardTicks > 800 || brPlaced >= 40) {
            AutoSandOrders.finishBridge(mc, p, "ch\u01b0a t\u1edbi \u0111\u01b0\u1ee3c b\u1edd sau " + brPlaced + " block", 400);
            return;
        }
        if (p.method_5771()) {
            AutoSandOrders.finishBridge(mc, p, "\u0111ang \u1edf trong lava", 400);
            return;
        }
        if (guardTicks % 40 == 0 && (nt = AutoSandOrders.findDry(lv, p, 16)) != null) {
            bridgeTarget = nt;
        }
        class_2350 class_23502 = Math.abs(dx) >= Math.abs(dz) ? (dx > 0.0 ? class_2350.field_11034 : class_2350.field_11039) : (want = dz > 0.0 ? class_2350.field_11035 : class_2350.field_11043);
        if (bridgeDir == null || want.method_10166() == bridgeDir.method_10166() || Math.abs(Math.abs(dx) - Math.abs(dz)) > 1.5) {
            bridgeDir = want;
        }
        class_2350 dir = bridgeDir;
        p.method_36456(dir.method_10144());
        p.method_36457(60.0f);
        class_2338 feet = p.method_24515();
        class_2338 f = feet.method_10093(dir);
        class_2338 b = f.method_10074();
        if (AutoSandOrders.lavaAt(lv, f) || AutoSandOrders.lavaAt(lv, b)) {
            AutoSandOrders.finishBridge(mc, p, "c\u00f3 lava ph\u00eda tr\u01b0\u1edbc", 400);
            return;
        }
        mc.field_1690.field_1903.method_23481(p.method_5799() && !p.method_24828());
        if (!AutoSandOrders.passable(lv, b) && AutoSandOrders.passable(lv, f) && AutoSandOrders.passable(lv, f.method_10084())) {
            mc.field_1690.field_1894.method_23481(true);
            return;
        }
        if (!AutoSandOrders.passable(lv, f)) {
            mc.field_1690.field_1894.method_23481(true);
            mc.field_1690.field_1903.method_23481(true);
            return;
        }
        mc.field_1690.field_1894.method_23481(false);
        if (brCool > 0) {
            --brCool;
            return;
        }
        class_2338 u = feet.method_10074();
        class_3965 hit = null;
        if (!AutoSandOrders.passable(lv, u)) {
            hit = new class_3965(class_243.method_24953((class_2382)u).method_1031((double)dir.method_10148() * 0.5, 0.0, (double)dir.method_10165() * 0.5), dir, u, false);
        } else {
            for (class_2350 d : HORIZ) {
                class_2338 n = u.method_10093(d);
                if (AutoSandOrders.passable(lv, n)) continue;
                hit = new class_3965(class_243.method_24953((class_2382)n).method_1031((double)(-d.method_10148()) * 0.5, 0.0, (double)(-d.method_10165()) * 0.5), d.method_10153(), n, false);
                break;
            }
            if (hit == null) {
                hit = new class_3965(class_243.method_24953((class_2382)u), class_2350.field_11036, u, false);
            }
        }
        mc.field_1761.method_2896(p, class_1268.field_5808, hit);
        p.method_6104(class_1268.field_5808);
        ++brPlaced;
        brCool = 3;
    }

    static void finishBridge(class_310 mc, class_746 p, String err, int cool) {
        mc.field_1690.field_1903.method_23481(false);
        if (escSwapIdx >= 0) {
            AutoSandOrders.swapHotbar(mc, p, escSwapIdx, escSlot);
            escSwapIdx = -1;
        }
        AutoSandOrders.setSelected(p, escPrevSel);
        if (!Float.isNaN(escPitch)) {
            p.method_36457(escPitch);
            escPitch = Float.NaN;
        }
        bridgeTarget = null;
        bridgeCool = cool;
        AutoSandOrders.msg(p, err == null ? "\u0110\u00e3 b\u1eafc c\u1ea7u v\u00e0o b\u1edd (" + brPlaced + " block)." : "B\u1eafc c\u1ea7u d\u1eebng: " + err);
        AutoSandOrders.endGuard(mc, p);
    }

    static class_1542 nearestSand(class_638 lv, class_746 p) {
        class_238 box = p.method_5829().method_1009((double)pickupRadius, 3.0, (double)pickupRadius);
        List list = lv.method_8390(class_1542.class, box, e -> !e.method_31481() && e.method_6983().method_31574(class_1802.field_8858) && !pickIgnore.contains(e.method_5628()));
        class_1542 best = null;
        double bestD = Double.MAX_VALUE;
        for (class_1542 e2 : list) {
            double dz;
            double dx = e2.method_23317() - p.method_23317();
            double d = dx * dx + (dz = e2.method_23321() - p.method_23321()) * dz;
            if (d < 1.9599999999999997 || !(d < bestD)) continue;
            best = e2;
            bestD = d;
        }
        return best;
    }

    static void startPickup(class_310 mc, class_746 p, class_1542 it) {
        pickTarget = it;
        pickTicks = 0;
        guard = G.PICKUP;
    }

    static void tickPickup(class_310 mc, class_746 p, class_638 lv) {
        ++pickTicks;
        class_1542 it = pickTarget;
        if (it == null || it.method_31481() || !it.method_6983().method_31574(class_1802.field_8858) || AutoSandOrders.isFull(p) || p.method_5799() || p.method_5771()) {
            AutoSandOrders.endPickup(mc, p, 5);
            return;
        }
        double dx = it.method_23317() - p.method_23317();
        double dz = it.method_23321() - p.method_23321();
        double d = Math.hypot(dx, dz);
        if (pickTicks > 100 || d > 0.01 && AutoSandOrders.hazardDir(lv, p.method_23317(), p.method_23318(), p.method_23321(), dx / d, dz / d)) {
            if (pickIgnore.size() > 60) {
                pickIgnore.clear();
            }
            pickIgnore.add(it.method_5628());
            AutoSandOrders.endPickup(mc, p, 40);
            return;
        }
        p.method_36456((float)Math.toDegrees(Math.atan2(-dx, dz)));
        p.method_36457(0.0f);
        mc.field_1690.field_1894.method_23481(true);
        mc.field_1690.field_1903.method_23481(p.field_5976 || it.method_23318() > p.method_23318() + 0.6);
    }

    static void endPickup(class_310 mc, class_746 p, int cool) {
        mc.field_1690.field_1903.method_23481(false);
        AutoSandOrders.releaseKeys(mc);
        guard = G.NONE;
        pickTarget = null;
        pickCool = cool;
        wdX = Double.NaN;
        AutoSandOrders.startMining(p);
    }

    static boolean dryAt(class_638 lv, class_2338 f) {
        return !AutoSandOrders.liquidAt(lv, f) && !AutoSandOrders.liquidAt(lv, f.method_10084()) && !AutoSandOrders.lavaAt(lv, f.method_10074()) && !AutoSandOrders.passable(lv, f.method_10074());
    }

    static void tickLiquid(class_310 mc, class_746 p, class_638 lv) {
        double dz;
        double dx;
        class_2338 ns;
        boolean noProgress;
        if (++guardTicks == 1) {
            liqX = p.method_23317();
            liqZ = p.method_23321();
        }
        if (!AutoSandOrders.danger(p) && p.method_24828()) {
            AutoSandOrders.msg(p, "\u0110\u00e3 l\u00ean b\u1edd, \u0111\u00e0o ti\u1ebfp.");
            AutoSandOrders.endGuard(mc, p);
            return;
        }
        if (guardTicks > 400) {
            AutoSandOrders.msg(p, "Ch\u01b0a l\u00ean \u0111\u01b0\u1ee3c b\u1edd sau 20 gi\u00e2y, th\u1eed \u0111\u00e0o ti\u1ebfp.");
            AutoSandOrders.endGuard(mc, p);
            return;
        }
        boolean bl = noProgress = guardTicks % 40 == 0 && Math.hypot(p.method_23317() - liqX, p.method_23321() - liqZ) < 1.0;
        if (guardTicks % 40 == 0) {
            liqX = p.method_23317();
            liqZ = p.method_23321();
        }
        if (bridgeWater && (guardTicks >= 60 || noProgress) && bridgeCool <= 0 && !p.method_5771()) {
            mc.field_1690.field_1903.method_23481(false);
            AutoSandOrders.releaseKeys(mc);
            if (AutoSandOrders.startBridge(mc, p)) {
                return;
            }
        }
        if (!(shore != null && guardTicks % 10 != 1 || (ns = AutoSandOrders.findShore(lv, p)) == null || shore != null && AutoSandOrders.dryAt(lv, shore) && !(Math.hypot((double)ns.method_10263() - p.method_23317(), (double)ns.method_10260() - p.method_23321()) + 1.5 < Math.hypot((double)shore.method_10263() - p.method_23317(), (double)shore.method_10260() - p.method_23321())))) {
            shore = ns;
        }
        mc.field_1690.field_1903.method_23481(true);
        mc.field_1690.field_1894.method_23481(true);
        if (shore != null && Math.hypot(dx = (double)shore.method_10263() + 0.5 - p.method_23317(), dz = (double)shore.method_10260() + 0.5 - p.method_23321()) > 0.6) {
            p.method_36456((float)Math.toDegrees(Math.atan2(-dx, dz)));
            p.method_36457(0.0f);
        }
    }

    static void startSide(class_310 mc, class_746 p, class_638 lv, double heading) {
        AutoSandOrders.stopMining(mc, p);
        double best = heading + 180.0;
        for (double off : new double[]{90.0, -90.0, 180.0}) {
            double r = Math.toRadians(heading + off);
            if (AutoSandOrders.hazardDir(lv, p.method_23317(), p.method_23318(), p.method_23321(), -Math.sin(r), Math.cos(r))) continue;
            best = heading + off;
            break;
        }
        p.method_36456((float)best);
        guard = G.SIDE;
        sideTicks = 14;
        if (sideWindow <= 0) {
            sideWindow = 300;
        }
        if (++sideStrikes == 1) {
            AutoSandOrders.msg(p, "C\u00f3 n\u01b0\u1edbc / lava / h\u1ed1 ph\u00eda tr\u01b0\u1edbc -> n\u00e9 sang b\u00ean.");
        }
        if (sideStrikes >= 4) {
            sideStrikes = 0;
            sideWindow = 0;
            sideLock = 600;
            AutoSandOrders.msg(p, "N\u00e9 li\u00ean t\u1ee5c nhi\u1ec1u l\u1ea7n, t\u1ea1m t\u1eaft n\u00e9 ph\u00eda tr\u01b0\u1edbc 30 gi\u00e2y.");
        }
    }

    static void tickSide(class_310 mc, class_746 p, class_638 lv) {
        double r = Math.toRadians(p.method_36454());
        if (--sideTicks <= 0 || p.method_5799() || p.method_5771() || AutoSandOrders.hazardDir(lv, p.method_23317(), p.method_23318(), p.method_23321(), -Math.sin(r), Math.cos(r))) {
            AutoSandOrders.endGuard(mc, p);
            return;
        }
        mc.field_1690.field_1894.method_23481(true);
    }

    static boolean startEscape(class_310 mc, class_746 p) {
        int slot = AutoSandOrders.hotbarPlaceSlot(p);
        int swapped = -1;
        if (slot < 0) {
            int idx = AutoSandOrders.findPlaceable(p);
            if (idx < 0) {
                AutoSandOrders.msg(p, "K\u1eb9t trong h\u1ed1 nh\u01b0ng kh\u00f4ng c\u00f3 block \u0111\u1ec3 \u0111\u1eb7t l\u00e0m b\u1eadc.");
                guardCool = 60;
                escCool = 300;
                return false;
            }
            slot = AutoSandOrders.toHotbar(mc, p, idx);
            swapped = idx;
        }
        AutoSandOrders.stopMining(mc, p);
        escSlot = slot;
        escSwapIdx = swapped;
        escPrevSel = AutoSandOrders.getSelected(p);
        escPitch = p.method_36455();
        AutoSandOrders.setSelected(p, slot);
        p.method_36457(90.0f);
        escBase = null;
        escPhase = 0;
        escPhaseTicks = 0;
        escPillars = 0;
        guardTicks = 0;
        guard = G.ESCAPE;
        AutoSandOrders.msg(p, "K\u1eb9t trong h\u1ed1 -> \u0111\u1eb7t c\u00e1t d\u01b0\u1edbi ch\u00e2n \u0111\u1ec3 leo l\u00ean.");
        return true;
    }

    static void tickEscape(class_310 mc, class_746 p, class_638 lv) {
        AutoSandOrders.setSelected(p, escSlot);
        p.method_36457(90.0f);
        if (++guardTicks > 400 || escPillars >= 20) {
            AutoSandOrders.finishEscape(mc, p, "kh\u00f4ng tho\u00e1t \u0111\u01b0\u1ee3c sau " + escPillars + " l\u1ea7n \u0111\u1eb7t block");
            return;
        }
        class_2338 f = p.method_24515();
        if (escPhase == 0) {
            if (!p.method_24828()) {
                return;
            }
            if (!AutoSandOrders.passable(lv, f.method_10084()) || !AutoSandOrders.passable(lv, f.method_10086(2))) {
                AutoSandOrders.finishEscape(mc, p, "tr\u00ean \u0111\u1ea7u b\u1ecb ch\u1eb7n");
                return;
            }
            if (!AutoSandOrders.trapped(lv, f) && !AutoSandOrders.enclosed(lv, f)) {
                AutoSandOrders.finishEscape(mc, p, null);
                return;
            }
            escBase = f;
            escPhase = 1;
            escPhaseTicks = 0;
            mc.field_1690.field_1903.method_23481(true);
            return;
        }
        if (escPhase == 1) {
            mc.field_1690.field_1903.method_23481(++escPhaseTicks <= 1);
            if (p.method_23318() >= (double)escBase.method_10264() + 1.0) {
                class_243 hit = new class_243((double)escBase.method_10263() + 0.5, (double)escBase.method_10264(), (double)escBase.method_10260() + 0.5);
                mc.field_1761.method_2896(p, class_1268.field_5808, new class_3965(hit, class_2350.field_11036, escBase.method_10074(), false));
                p.method_6104(class_1268.field_5808);
                ++escPillars;
                escPhase = 2;
                escPhaseTicks = 0;
            } else if (escPhaseTicks > 12 && p.method_24828()) {
                escPhase = 0;
            }
            return;
        }
        if (p.method_24828() || ++escPhaseTicks > 20) {
            escPhase = 0;
        }
    }

    static void finishEscape(class_310 mc, class_746 p, String err) {
        mc.field_1690.field_1903.method_23481(false);
        if (escSwapIdx >= 0) {
            AutoSandOrders.swapHotbar(mc, p, escSwapIdx, escSlot);
            escSwapIdx = -1;
        }
        AutoSandOrders.setSelected(p, escPrevSel);
        if (!Float.isNaN(escPitch)) {
            p.method_36457(escPitch);
            escPitch = Float.NaN;
        }
        AutoSandOrders.msg(p, (String)(err == null ? "\u0110\u00e3 tho\u00e1t kh\u1ecfi h\u1ed1." : "Tho\u00e1t h\u1ed1: " + err));
        escCool = err == null ? 40 : 300;
        idleAcc = 0;
        encCache = false;
        AutoSandOrders.endGuard(mc, p);
    }

    static class_2561 onOff(String name, boolean v) {
        return class_2561.method_43470((String)(name + ": ")).method_10852((class_2561)class_2561.method_43470((String)(v ? "B\u1eacT" : "T\u1eaeT")).method_27692(v ? class_124.field_1060 : class_124.field_1061));
    }

    static class_2561 val(String name, String value) {
        return class_2561.method_43470((String)(name + ": ")).method_10852((class_2561)class_2561.method_43470((String)value).method_27692(class_124.field_1075));
    }

    static String pickupLabel() {
        return pickupRadius <= 0 ? "T\u1eaft" : (pickupRadius <= 4 ? "G\u1ea7n (4 \u00f4)" : (pickupRadius <= 8 ? "V\u1eeba (8 \u00f4)" : "Xa (12 \u00f4)"));
    }

    static String stateText() {
        if (!enabled) {
            return "\u0110ang t\u1eaft";
        }
        if (Lobby.ph != 0) {
            return "\u0110ang \u1edf s\u1ea3nh -> quay l\u1ea1i KingSMP";
        }
        if (mode == Mode.BUILTIN && AutoMiner.recovering()) {
            return AutoMiner.recoverText();
        }
        if (state == S.MINING && guard != G.NONE) {
            return switch (guard.ordinal()) {
                case 1 -> "\u0110ang tho\u00e1t kh\u1ecfi n\u01b0\u1edbc / lava";
                case 2 -> "\u0110ang \u0111\u1eb7t block leo kh\u1ecfi h\u1ed1";
                case 3 -> "\u0110ang n\u00e9 nguy hi\u1ec3m";
                case 4 -> "\u0110ang \u0111i nh\u1eb7t c\u00e1t";
                case 5 -> "\u0110ang b\u1eafc c\u1ea7u qua n\u01b0\u1edbc";
                case 6 -> "\u0110ang tho\u00e1t kh\u1ecfi t\u01b0\u1eddng";
                default -> "\u0110ang \u0111\u00e0o c\u00e1t";
            };
        }
        return switch (state.ordinal()) {
            default -> throw new MatchException(null, null);
            case 0 -> "\u0110ang \u0111\u00e0o c\u00e1t";
            case 1, 2, 3, 4, 5 -> "\u0110ang giao c\u00e1t v\u00e0o \u0111\u01a1n";
            case 6, 7, 8 -> "\u0110ang s\u1eeda x\u1ebbng b\u1eb1ng b\u00ecnh XP";
            case 9, 10, 11, 12, 13, 14 -> {
                if (buyTotem) {
                    yield "\u0110ang mua totem";
                }
                if (buyPearl) {
                    yield "\u0110ang mua ng\u1ecdc Ender";
                }
                if (buyFood) {
                    yield "\u0110ang mua \u0111\u1ed3 \u0103n";
                }
                yield "\u0110ang mua b\u00ecnh XP";
            }
            case 15, 16 -> "\u0110ang \u0103n";
            case 17 -> "\u0110ang d\u1ecdn \u0111\u1ed3 kh\u00f4ng c\u1ea7n";
        };
    }

    static int shovelPct(class_746 p) {
        double best = 101.0;
        for (int i = 0; i < 36; ++i) {
            class_1799 st = p.method_31548().method_5438(i);
            if (st.method_7960() || !st.method_31573(class_3489.field_42615) || !st.method_7963()) continue;
            best = Math.min(best, AutoSandOrders.remainingPct(st));
        }
        return best > 100.0 ? -1 : (int)Math.round(best);
    }

    static int lerpC(int a, int b, float t) {
        t = Math.max(0.0f, Math.min(1.0f, t));
        int r = 0;
        for (int s = 24; s >= 0; s -= 8) {
            int ca = a >> s & 0xFF;
            int cb = b >> s & 0xFF;
            r |= ((int)((float)ca + (float)(cb - ca) * t) & 0xFF) << s;
        }
        return r;
    }

    static void rrect(class_332 g, int x, int y, int w, int h, int r, int c) {
        if ((r = Math.min(r, Math.min(w, h) / 2)) <= 0) {
            g.method_25294(x, y, x + w, y + h, c);
            return;
        }
        g.method_25294(x, y + r, x + w, y + h - r, c);
        for (int i = 0; i < r; ++i) {
            double dy = (double)(r - i) - 0.5;
            int dx = r - (int)Math.round(Math.sqrt((double)(r * r) - dy * dy));
            g.method_25294(x + dx, y + i, x + w - dx, y + i + 1, c);
            g.method_25294(x + dx, y + h - i - 1, x + w - dx, y + h - i, c);
        }
    }

    static enum Mode {
        BUILTIN("T\u1ef1 \u0111\u00e0o"),
        KEYS("Gi\u1eef ph\u00edm"),
        NUKER("Ch\u1ec9 Nuker");

        final String label;

        private Mode(String l) {
            this.label = l;
        }

        Mode next() {
            return Mode.values()[(this.ordinal() + 1) % Mode.values().length];
        }
    }

    static final class Lobby {
        static int ph = 0;
        static int t = 0;
        static int seen = 0;
        static int tries = 0;
        static int to = 0;
        static boolean force = false;

        private Lobby() {
        }

        static void reset() {
            ph = 0;
            t = 0;
            seen = 0;
            tries = 0;
            to = 0;
        }

        static boolean isLobbyItemType(class_1799 st) {
            return !st.method_7960() && (st.method_31574(class_1802.field_8251) || st.method_31574(class_1802.field_38747) || st.method_31574(class_1802.field_8557));
        }

        static boolean isLobbyItemName(class_1799 st) {
            return !st.method_7960() && AutoSandOrders.nameHas(st, "la ban", "compass", "dong ho", "clock", "chon server", "server", "menu", "kingsmp");
        }

        static List<Integer> candidates(class_746 p) {
            int i;
            ArrayList<Integer> r = new ArrayList<Integer>();
            for (i = 0; i < 9; ++i) {
                if (!Lobby.isLobbyItemType(p.method_31548().method_5438(i))) continue;
                r.add(i);
            }
            for (i = 0; i < 9; ++i) {
                if (r.contains(i) || !Lobby.isLobbyItemName(p.method_31548().method_5438(i))) continue;
                r.add(i);
            }
            if (!r.contains(4) && !p.method_31548().method_5438(4).method_7960()) {
                r.add(4);
            }
            return r;
        }

        static int compassSlot(class_746 p) {
            List<Integer> c = Lobby.candidates(p);
            return c.isEmpty() ? -1 : c.get(tries % c.size());
        }

        static boolean strong(class_746 p) {
            for (int i = 0; i < 9; ++i) {
                class_1799 st = p.method_31548().method_5438(i);
                if (!Lobby.isLobbyItemType(st) && !Lobby.isLobbyItemName(st)) continue;
                return true;
            }
            return false;
        }

        static boolean inLobby(class_746 p) {
            if (AutoMiner.hasAnyShovel(p)) {
                return false;
            }
            if (AutoMiner.recovering() || AutoMiner.deathRecorded) {
                return Lobby.strong(p);
            }
            boolean any = false;
            for (int i = 0; i < 9; ++i) {
                class_1799 st = p.method_31548().method_5438(i);
                if (st.method_7960()) continue;
                if (AutoSandOrders.keepItem(st) && !AutoSandOrders.isWeapon(st)) {
                    return false;
                }
                any = true;
            }
            return any;
        }

        static boolean tick(class_310 mc, class_746 p) {
            if (force && ph == 0) {
                force = false;
                Lobby.begin(mc, p);
                return true;
            }
            if (!autoRejoin) {
                return false;
            }
            if (ph == 0) {
                int k;
                class_1707 h0 = AutoSandOrders.container(mc);
                if (h0 != null && AutoSandOrders.loaded(h0) && Lobby.inLobby(p) && (k = AutoSandOrders.find(h0, st -> AutoSandOrders.nameHas(st, "kingsmp", "king smp"), -1)) >= 0) {
                    AutoSandOrders.click(mc, p, h0, k, class_1713.field_7790);
                    ph = 4;
                    t = 20;
                    to = 400;
                    return true;
                }
                if (Lobby.inLobby(p)) {
                    if (++seen >= 20) {
                        Lobby.begin(mc, p);
                    }
                } else {
                    seen = 0;
                }
                return ph != 0;
            }
            if (!Lobby.inLobby(p)) {
                Lobby.finish(mc, p);
                return true;
            }
            if (t > 0) {
                --t;
                return true;
            }
            switch (ph) {
                case 1: {
                    int slot = Lobby.compassSlot(p);
                    if (slot < 0) {
                        Lobby.reset();
                        return false;
                    }
                    if (AutoSandOrders.screenBlocks(mc)) {
                        p.method_7346();
                        t = 5;
                        return true;
                    }
                    AutoSandOrders.setSelected(p, slot);
                    ph = 2;
                    t = 6;
                    break;
                }
                case 2: {
                    mc.field_1761.method_2919((class_1657)p, class_1268.field_5808);
                    p.method_6104(class_1268.field_5808);
                    ph = 3;
                    to = 100;
                    break;
                }
                case 3: {
                    class_1707 h = AutoSandOrders.container(mc);
                    if (h != null && AutoSandOrders.loaded(h)) {
                        int i = AutoSandOrders.find(h, st -> AutoSandOrders.nameHas(st, "kingsmp", "king smp"), -1);
                        if (i < 0) {
                            i = 24;
                        }
                        AutoSandOrders.click(mc, p, h, i, class_1713.field_7790);
                        ph = 4;
                        t = 20;
                        to = 400;
                        break;
                    }
                    if (--to > 0) break;
                    Lobby.retry(mc, p);
                    break;
                }
                case 4: {
                    if (--to > 0) break;
                    Lobby.retry(mc, p);
                    break;
                }
                default: {
                    Lobby.reset();
                }
            }
            return true;
        }

        static void begin(class_310 mc, class_746 p) {
            AutoSandOrders.stopMining(mc, p);
            AutoSandOrders.guardReset(mc, p);
            state = S.MINING;
            wait = 0;
            cooldown = 0;
            if (AutoSandOrders.screenBlocks(mc)) {
                p.method_7346();
            }
            ph = 1;
            t = 30;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; ++i) {
                class_1799 st = p.method_31548().method_5438(i);
                if (st.method_7960()) continue;
                sb.append(i + 1).append('=').append(st.method_7964().getString()).append(" | ");
            }
            AutoSandOrders.msg(p, "\u0110ang \u1edf s\u1ea3nh -> m\u1edf menu ch\u1ecdn KingSMP. Thanh c\u00f4ng c\u1ee5: " + String.valueOf(sb));
        }

        static void retry(class_310 mc, class_746 p) {
            if (AutoSandOrders.screenBlocks(mc)) {
                p.method_7346();
            }
            if (++tries >= 8) {
                AutoSandOrders.msg(p, "Th\u1eed quay l\u1ea1i KingSMP 8 l\u1ea7n kh\u00f4ng \u0111\u01b0\u1ee3c. T\u1eaft AutoSand.");
                AutoSandOrders.setEnabled(mc, false);
                return;
            }
            AutoSandOrders.msg(p, "Ch\u01b0a v\u00e0o l\u1ea1i \u0111\u01b0\u1ee3c KingSMP, th\u1eed l\u1ea7n " + (tries + 1) + "/8.");
            ph = 1;
            t = 40;
        }

        static void finish(class_310 mc, class_746 p) {
            Lobby.reset();
            if (AutoSandOrders.screenBlocks(mc)) {
                p.method_7346();
            }
            AutoMiner.stop(mc);
            AutoMiner.freshStart();
            AutoSandOrders.guardReset(mc, p);
            AutoMiner.baseY = -1000000;
            nukerState = null;
            state = S.MINING;
            cooldown = 100;
            rejoinWait = 200;
            if (useNuker) {
                AutoSandOrders.setNuker(p, false);
            }
            if (AutoMiner.rec != 0) {
                AutoMiner.rec = 1;
                AutoMiner.recTimer = 60;
                AutoMiner.homeTries = 0;
                AutoMiner.teleported = false;
                AutoMiner.kitStep = 2;
            }
            AutoSandOrders.msg(p, "\u0110\u00e3 quay l\u1ea1i KingSMP, ch\u1edd 10 gi\u00e2y r\u1ed3i \u0111\u00e0o ti\u1ebfp.");
        }
    }

    static enum S {
        MINING,
        WAIT_ORDERS,
        WAIT_DELIVER,
        DEPOSIT,
        WAIT_CONFIRM,
        FINISH,
        MEND_PREP,
        MEND_THROW,
        MEND_RESTORE,
        BUY_PREP,
        BUY_SHOP,
        BUY_GEAR,
        BUY_AMOUNT,
        BUY_CONFIRM,
        BUY_DONE,
        EAT_PREP,
        EAT_USE,
        JUNK;

    }

    static final class Reconnect {
        static class_642 last = null;
        static int wait = 0;
        static int tries = 0;

        private Reconnect() {
        }

        static void connected(class_310 mc) {
            class_642 d = mc.method_1558();
            if (d != null) {
                last = d;
            }
            wait = 0;
            tries = 0;
        }

        static void tick(class_310 mc) {
            if (!enabled || !autoRejoin || last == null) {
                return;
            }
            if (!(mc.field_1755 instanceof class_419)) {
                wait = 0;
                return;
            }
            if (++wait < 100) {
                return;
            }
            wait = 0;
            if (++tries > 30) {
                enabled = false;
                return;
            }
            try {
                Method m = null;
                for (Method c : class_412.class.getDeclaredMethods()) {
                    Class<?>[] pt = c.getParameterTypes();
                    if (!Modifier.isStatic(c.getModifiers()) || pt.length < 5 || pt[0] != class_437.class || pt[1] != class_310.class || pt[2] != class_639.class || pt[3] != class_642.class) continue;
                    m = c;
                    break;
                }
                if (m == null) {
                    return;
                }
                Object[] args = new Object[m.getParameterCount()];
                args[0] = mc.field_1755;
                args[1] = mc;
                args[2] = class_639.method_2950((String)Reconnect.last.field_3761);
                args[3] = last;
                if (m.getParameterTypes()[4] == Boolean.TYPE) {
                    args[4] = Boolean.FALSE;
                }
                m.setAccessible(true);
                m.invoke(null, args);
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
    }

    static final class Announcements {
        private static final long INTERVAL_NS = 60000000000L;
        private static final int MAX_SEEN = 500;
        private static final int MAX_SHOW = 5;
        private static final HttpClient HTTP = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(5L)).build();
        private static final Set<Long> seen = new LinkedHashSet<Long>();
        private static boolean loaded = false;
        private static volatile boolean fetching = false;
        private static boolean attempted = false;
        private static long lastNs = 0L;
        private static Path file;

        private Announcements() {
        }

        static void tick(class_310 mc, class_746 p) {
            HttpRequest request;
            long now = System.nanoTime();
            if (fetching || attempted && now - lastNs < 60000000000L) {
                return;
            }
            attempted = true;
            lastNs = now;
            try {
                String name = URLEncoder.encode(p.method_5477().getString(), StandardCharsets.UTF_8);
                request = HttpRequest.newBuilder().uri(URI.create("https://snadpremiun.vietanduong35.workers.dev/announcements?playerName=" + name)).timeout(Duration.ofSeconds(8L)).GET().build();
            }
            catch (Exception e) {
                return;
            }
            fetching = true;
            HTTP.sendAsync(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8)).whenComplete((response, error) -> {
                try {
                    if (error == null && response != null && response.statusCode() >= 200 && response.statusCode() < 300) {
                        Announcements.process(mc, (String)response.body());
                    }
                }
                catch (Throwable throwable) {
                }
                finally {
                    fetching = false;
                }
            });
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private static void process(class_310 mc, String body) {
            if (body == null || body.isBlank()) {
                return;
            }
            JsonElement root = JsonParser.parseString((String)body);
            JsonArray arr = null;
            if (root.isJsonArray()) {
                arr = root.getAsJsonArray();
            } else if (root.isJsonObject() && root.getAsJsonObject().has("announcements") && root.getAsJsonObject().get("announcements").isJsonArray()) {
                arr = root.getAsJsonObject().getAsJsonArray("announcements");
            }
            if (arr == null) {
                return;
            }
            ArrayList<String> texts = new ArrayList<String>();
            Class<Announcements> clazz = Announcements.class;
            synchronized (Announcements.class) {
                Announcements.loadSeen();
                ArrayList<Object[]> fresh = new ArrayList<Object[]>();
                for (JsonElement e : arr) {
                    JsonElement ie;
                    long id;
                    String text;
                    JsonObject o;
                    JsonElement m;
                    if (!e.isJsonObject() || (m = (o = e.getAsJsonObject()).get("message")) == null || !m.isJsonPrimitive() || (text = Announcements.clean(m.getAsString())).isEmpty() || seen.contains(id = (ie = o.get("id")) != null && ie.isJsonPrimitive() && ie.getAsJsonPrimitive().isNumber() ? ie.getAsLong() : 0x4000000000000000L | (long)text.hashCode() & 0xFFFFFFFFL)) continue;
                    fresh.add(new Object[]{id, text});
                }
                fresh.sort(Comparator.comparingLong(x -> (Long)x[0]));
                for (Object[] f : fresh) {
                    seen.add((Long)f[0]);
                    texts.add((String)f[1]);
                }
                if (!fresh.isEmpty()) {
                    Announcements.saveSeen();
                }
                // ** MonitorExit[var5_5] (shouldn't be in output)
                if (texts.isEmpty()) {
                    return;
                }
                mc.execute(() -> {
                    class_746 pl = mc.field_1724;
                    if (pl == null) {
                        return;
                    }
                    int shown = Math.min(5, texts.size());
                    for (int i = texts.size() - shown; i < texts.size(); ++i) {
                        pl.method_7353((class_2561)class_2561.method_43470((String)("[Th\u00f4ng b\u00e1o] " + (String)texts.get(i))).method_27692(class_124.field_1065), false);
                    }
                    if (texts.size() > shown) {
                        pl.method_7353((class_2561)class_2561.method_43470((String)("[Th\u00f4ng b\u00e1o] ... v\u00e0 " + (texts.size() - shown) + " th\u00f4ng b\u00e1o c\u0169 h\u01a1n.")).method_27692(class_124.field_1080), false);
                    }
                });
                return;
            }
        }

        private static String clean(String s) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length() && sb.length() < 300; ++i) {
                char c = s.charAt(i);
                if (c == '\n' || c == '\r' || c == '\t') {
                    sb.append(' ');
                    continue;
                }
                if (c < ' ' || c == '\u007f' || c == '\u00a7') continue;
                sb.append(c);
            }
            return sb.toString().trim();
        }

        private static void loadSeen() {
            if (loaded) {
                return;
            }
            loaded = true;
            try {
                file = FabricLoader.getInstance().getConfigDir().resolve("autosandmod.ann");
                if (!Files.exists(file, new LinkOption[0])) {
                    return;
                }
                for (String line : Files.readAllLines(file, StandardCharsets.UTF_8)) {
                    try {
                        seen.add(Long.parseLong(line.trim()));
                    }
                    catch (NumberFormatException numberFormatException) {}
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        }

        private static void saveSeen() {
            try {
                while (seen.size() > 500) {
                    Long first = seen.iterator().next();
                    seen.remove(first);
                }
                StringBuilder sb = new StringBuilder();
                for (Long id : seen) {
                    sb.append(id).append('\n');
                }
                if (file == null) {
                    file = FabricLoader.getInstance().getConfigDir().resolve("autosandmod.ann");
                }
                Files.writeString(file, (CharSequence)sb.toString(), StandardCharsets.UTF_8, new OpenOption[0]);
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    static class AutoSandScreen
    extends class_437 {
        static final int PW = 620;
        static final int SIDE = 142;
        static final String[] TABS = new String[]{"Ch\u00ednh", "\u0110\u00e0o c\u00e1t", "Sinh t\u1ed3n", "An to\u00e0n", "T\u1ef1 \u0111\u00e0o", "Th\u1ed1ng k\u00ea", "N\u00e2ng cao"};
        static final int[] TAB_COL = new int[]{-8596225, -604065, -9508966, -38015, -13773633, -757066, -5796870, -22195};
        static final int TXT = -1;
        static final int MUTED = -7433028;
        static final int PANEL = -234352608;
        static final int PANEL_EDGE = -15085569;
        static final int CARD = -234218703;
        static final int CARD_EDGE = -15243339;
        static final int CARD_HOV = -15713958;
        static final int GOLD_BG = -15980223;
        static final int GOLD_EDGE = -15155733;
        static final int GOLD_TXT = -4786433;
        static final int GREEN_TOP = -15077168;
        static final int GREEN_BOT = -16220515;
        static final int GREEN_EDGE = -14159105;
        static final int GREEN_TXT = -1245185;
        static final int RED_TOP = -47234;
        static final int RED_BOT = -7596209;
        static final int RED_EDGE = -45158;
        static final int RED_TXT = -1;
        static final int PILL_OFF = -12429195;
        static final int[] PARTICLE = new int[]{-1437904267, -1439023268, -1439724391, -1436917115};
        final List<Ctl> ctls = new ArrayList<Ctl>();
        int tab = 0;
        int x0;
        int y0;
        int ph;
        int cx;
        int cy;
        int cw;
        int availH;
        int rowH = 30;
        class_342 keyBox;
        boolean wasValid = false;

        static int grad3(float t) {
            return t < 0.5f ? AutoSandOrders.lerpC(-5026305, -15279617, t * 2.0f) : AutoSandOrders.lerpC(-15279617, -14124033, (t - 0.5f) * 2.0f);
        }

        static void card(class_332 g, int x, int y, int w, int h, int r, int bg, int edge) {
            AutoSandOrders.rrect(g, x, y, w, h, r, edge);
            AutoSandOrders.rrect(g, x + 1, y + 1, w - 2, h - 2, Math.max(0, r - 1), bg);
        }

        static void button3d(class_332 g, int x, int y, int w, int h, int top, int bot, int edge, boolean hov) {
            int depth = 3;
            int by = hov ? y + 1 : y;
            AutoSandOrders.rrect(g, x, y + depth, w, h - depth, 8, edge);
            AutoSandOrders.rrect(g, x, by, w, h - depth, 8, hov ? AutoSandOrders.lerpC(bot, -1, 0.12f) : bot);
            g.method_25296(x + 5, by + 1, x + w - 5, by + 1 + (h - depth) / 2, hov ? 0x66FFFFFF : 0x4CFFFFFF, 0xFFFFFF);
        }

        void spaced(class_332 g, String s, int x, int y, int space, int col) {
            for (int i = 0; i < s.length(); ++i) {
                String ch = s.substring(i, i + 1);
                g.method_51433(this.field_22793, ch, x, y, col, false);
                x += this.field_22793.method_1727(ch) + space;
            }
        }

        int gradWidth(String s, int space) {
            int w = 0;
            for (int i = 0; i < s.length(); ++i) {
                w += this.field_22793.method_27525((class_5348)class_2561.method_43470((String)s.substring(i, i + 1)).method_27692(class_124.field_1067)) + space;
            }
            return w - space;
        }

        void gradText(class_332 g, String s, int x, int y, int space) {
            for (int i = 0; i < s.length(); ++i) {
                class_5250 ch = class_2561.method_43470((String)s.substring(i, i + 1)).method_27692(class_124.field_1067);
                g.method_51439(this.field_22793, (class_2561)ch, x, y, AutoSandScreen.grad3((float)i / (float)Math.max(1, s.length() - 1)), true);
                x += this.field_22793.method_27525((class_5348)ch) + space;
            }
        }

        void backdrop(class_332 g) {
            g.method_25296(0, 0, this.field_22789, this.field_22790, 1912867608, -1979313110);
            long tm = System.currentTimeMillis();
            g.method_25294(this.field_22789 * 55 / 100, this.field_22790 * 28 / 100, this.field_22789 * 78 / 100, this.field_22790 * 28 / 100 + 9, 857611083);
            g.method_25294(this.field_22789 * 60 / 100, this.field_22790 * 28 / 100 - 7, this.field_22789 * 72 / 100, this.field_22790 * 28 / 100, 639507275);
            for (int i = 0; i < 38; ++i) {
                int h = (i + 1) * -1640531535;
                int rx = Math.floorMod(h >>> 7, Math.max(1, this.field_22789));
                int ry = Math.floorMod(h * 31 >>> 5, Math.max(1, this.field_22790));
                int sz = 2 + i % 3 * 2;
                int bob = (int)Math.round(Math.sin((double)tm / 1400.0 + (double)i) * 3.0);
                g.method_25294(rx, ry + bob, rx + sz, ry + bob + sz, PARTICLE[i % PARTICLE.length]);
            }
        }

        AutoSandScreen() {
            super((class_2561)class_2561.method_43470((String)"AutoSand"));
        }

        Ctl add(int kind, int x, int y, int w, int h, String title, String desc, Runnable act) {
            Ctl c = new Ctl();
            c.kind = kind;
            c.x = x;
            c.y = y;
            c.w = w;
            c.h = h;
            c.title = title;
            c.desc = desc;
            class_4185 b = class_4185.method_46430((class_2561)class_2561.method_43473(), bb -> act.run()).method_46434(x, y, w, h).method_46431();
            b.method_25350(0.0f);
            this.method_37063((class_364)b);
            this.ctls.add(c);
            return c;
        }

        void begin(int n) {
            this.rowH = Math.max(20, Math.min(30, (this.availH - (n - 1) * 4) / n));
        }

        int cardY(int i) {
            return this.cy + i * (this.rowH + 4);
        }

        void toggle(int i, String title, String desc, BooleanSupplier get, Consumer<Boolean> set) {
            Ctl c = this.add(0, this.cx, this.cardY(i), this.cw, this.rowH, title, desc, () -> {
                set.accept(!get.getAsBoolean());
                AutoSandOrders.save();
            });
            c.on = get;
        }

        void cycle(int i, String title, String desc, Supplier<String> value, Runnable next) {
            Ctl c = this.add(1, this.cx, this.cardY(i), this.cw, this.rowH, title, desc, () -> {
                next.run();
                AutoSandOrders.save();
            });
            c.value = value;
        }

        protected void method_25426() {
            this.ctls.clear();
            this.ph = Math.min(this.field_22790 - 20, 420);
            this.x0 = Math.max(8, (this.field_22789 - 620) / 2);
            this.y0 = this.field_22790 / 2 - this.ph / 2;
            this.cx = this.x0 + 142 + 10;
            this.cw = 458;
            this.cy = this.y0 + 54;
            this.availH = this.ph - 64 - 10;
            this.wasValid = true;
            for (int i = 0; i < TABS.length; ++i) {
                int t = i;
                Ctl c = this.add(4, this.x0 + 8, this.y0 + 48 + i * 30, 128, 26, TABS[i], null, () -> {
                    this.tab = t;
                    this.method_41843();
                });
                c.selected = i == this.tab;
                c.color = TAB_COL[i];
            }
            this.add(5, this.x0 + 620 - 26, this.y0 + 9, 16, 16, "x", null, () -> this.method_25419());
            switch (this.tab) {
                case 0: {
                    this.add(3, this.cx, this.cy, this.cw, 46, "", null, () -> AutoSandOrders.setEnabled(class_310.method_1551(), !enabled));
                    break;
                }
                case 1: {
                    this.begin(7);
                    this.cycle(0, "Ch\u1ebf \u0111\u1ed9 \u0111\u00e0o", "T\u1ef1 \u0111\u00e0o (c\u00f3 s\u1eb5n), gi\u1eef ph\u00edm ho\u1eb7c ch\u1ec9 Nuker", () -> AutoSandOrders.mode.label, () -> {
                        boolean running;
                        class_310 mc = class_310.method_1551();
                        boolean bl = running = enabled && state == S.MINING && mc.field_1724 != null;
                        if (running) {
                            AutoSandOrders.stopMining(mc, mc.field_1724);
                        }
                        mode = mode.next();
                        if (running) {
                            AutoSandOrders.startMining(mc.field_1724);
                        }
                    });
                    this.toggle(1, "Nuker", "Ph\u00e1 kh\u1ed1i xung quanh b\u1eb1ng Nuker", () -> useNuker, v -> {
                        class_310 mc = class_310.method_1551();
                        useNuker = v;
                        if (enabled && state == S.MINING && mc.field_1724 != null) {
                            nukerState = null;
                            AutoSandOrders.setNuker(mc.field_1724, useNuker);
                        }
                    });
                    this.toggle(2, "Gi\u1eef ph\u00edm ti\u1ebfn", "Ch\u1ebf \u0111\u1ed9 Gi\u1eef ph\u00edm: t\u1ef1 gi\u1eef W \u0111i t\u1edbi", () -> keysForward, v -> {
                        keysForward = v;
                    });
                    this.cycle(3, "Nh\u1eb7t c\u00e1t", "\u01afu ti\u00ean nh\u1eb7t c\u00e1t r\u01a1i quanh b\u1ea1n", AutoSandOrders::pickupLabel, () -> {
                        int next = PICKUP_LEVELS[0];
                        for (int v : PICKUP_LEVELS) {
                            if (v <= pickupRadius) continue;
                            next = v;
                            break;
                        }
                        pickupRadius = next;
                    });
                    this.toggle(4, "T\u1ef1 giao c\u00e1t", "\u0110\u1ea7y t\u00fai -> /orders -> giao v\u00e0o \u0111\u01a1n c\u00e1t", () -> autoDeliver, v -> {
                        autoDeliver = v;
                    });
                    this.toggle(5, "T\u1ef1 b\u1eadt l\u1ea1i khi d\u1eebng", "Nuker d\u1eebng ho\u1eb7c l\u1ed7i -> b\u1eadt l\u1ea1i", () -> autoRevive, v -> {
                        autoRevive = v;
                    });
                    this.cycle(6, "T\u1ed1c \u0111\u1ed9 \u0111\u00e0o", "H\u1ec7 s\u1ed1 g\u1ecdi ph\u00e1 kh\u1ed1i (m\u00e1y ch\u1ee7 v\u1eabn gi\u1edbi h\u1ea1n t\u1ed1c \u0111\u1ed9 th\u1ef1c t\u1ebf)", () -> mineSpeed + "%", () -> {
                        int next = SPEED_LEVELS[0];
                        for (int v : SPEED_LEVELS) {
                            if (v >= mineSpeed) continue;
                            next = v;
                            break;
                        }
                        mineSpeed = next;
                    });
                    break;
                }
                case 2: {
                    this.begin(8);
                    this.toggle(0, "T\u1ef1 \u0103n khi \u0111\u00f3i", "\u0110\u00f3i -> ng\u1eebng \u0111\u00e0o, \u0103n no r\u1ed3i \u0111\u00e0o ti\u1ebfp", () -> autoEat, v -> {
                        autoEat = v;
                    });
                    this.cycle(1, "\u0102n khi \u0111\u00f3i <=", "Thanh \u0111\u00f3i t\u1eeb m\u1ee9c n\u00e0y tr\u1edf xu\u1ed1ng th\u00ec \u0103n", () -> eatBelow + "/20", () -> {
                        int next = EAT_LEVELS[0];
                        for (int v : EAT_LEVELS) {
                            if (v <= eatBelow) continue;
                            next = v;
                            break;
                        }
                        eatBelow = next;
                    });
                    this.toggle(2, "T\u1ef1 mua \u0111\u1ed3 \u0103n", "H\u1ebft \u0111\u1ed3 \u0103n -> /shop -> FOOD -> C\u00e0 R\u1ed1t V\u00e0ng", () -> autoBuyFood, v -> {
                        autoBuyFood = v;
                        foodBuyFails = 0;
                    });
                    this.toggle(3, "T\u1ef1 s\u1eeda x\u1ebbng", "X\u1ebbng g\u1ea7n h\u01b0 -> n\u00e9m b\u00ecnh XP (c\u1ea7n Mending)", () -> autoMend, v -> {
                        autoMend = v;
                    });
                    this.cycle(4, "S\u1eeda khi c\u00f2n d\u01b0\u1edbi", "\u0110\u1ed9 b\u1ec1n x\u1ebbng th\u1ea5p h\u01a1n m\u1ee9c n\u00e0y th\u00ec s\u1eeda", () -> mendPct + "%", () -> {
                        int next = PCTS[0];
                        for (int v : PCTS) {
                            if (v <= mendPct) continue;
                            next = v;
                            break;
                        }
                        mendPct = next;
                    });
                    this.toggle(5, "T\u1ef1 mua b\u00ecnh XP", "H\u1ebft b\u00ecnh XP -> mua \u1edf /shop (ch\u1ec9 v\u1ee9t c\u00e1t)", () -> autoBuy, v -> {
                        autoBuy = v;
                    });
                    this.toggle(6, "V\u1ee9t \u0111\u1ed3 kh\u00f4ng c\u1ea7n", "Gi\u1eef c\u00e1t, b\u00ecnh XP, x\u1ebbng, \u0111\u1ed3 \u0103n, totem. V\u1ee9t ph\u1ea7n c\u00f2n l\u1ea1i", () -> autoDrop, v -> {
                        autoDrop = v;
                    });
                    this.toggle(7, "T\u1ef1 c\u1ea7m Totem", "Tay tr\u00e1i lu\u00f4n c\u1ea7m totem, h\u1ebft th\u00ec mua \u1edf /shop", () -> autoTotem, v -> {
                        autoTotem = v;
                        totemBuyFails = 0;
                        totemCool = 0;
                    });
                    break;
                }
                case 3: {
                    this.begin(3);
                    this.toggle(0, "Tho\u00e1t n\u01b0\u1edbc s\u00e2u / lava", "K\u1eb9t n\u01b0\u1edbc s\u00e2u ho\u1eb7c lava -> t\u1ef1 b\u01a1i l\u00ean b\u1edd", () -> avoidLiquid, v -> {
                        avoidLiquid = v;
                    });
                    this.toggle(1, "B\u1eafc c\u1ea7u qua n\u01b0\u1edbc", "B\u1ecb n\u01b0\u1edbc bao quanh -> \u0111\u1eb7t block \u0111i v\u00e0o b\u1edd", () -> bridgeWater, v -> {
                        bridgeWater = v;
                    });
                    this.toggle(2, "N\u00e9 h\u1ed1 & t\u1ef1 leo", "R\u01a1i xu\u1ed1ng h\u1ed1 -> t\u1ef1 \u0111\u1eb7t block leo l\u00ean", () -> avoidHole, v -> {
                        avoidHole = v;
                    });
                    break;
                }
                case 4: {
                    this.begin(6);
                    this.toggle(0, "Ch\u1ebft -> v\u1ec1 nh\u1eb7t \u0111\u1ed3", "H\u1ed3i sinh -> /home -> v\u1ec1 ch\u1ed7 ch\u1ebft nh\u1eb7t l\u1ea1i \u0111\u1ed3", () -> AutoMiner.deathRecover, v -> {
                        AutoMiner.deathRecover = v;
                    });
                    this.toggle(1, "T\u1ef1 h\u1ed3i sinh", "Ch\u1ebft th\u00ec t\u1ef1 b\u1ea5m n\u00fat H\u1ed3i sinh", () -> AutoMiner.autoRespawn, v -> {
                        AutoMiner.autoRespawn = v;
                    });
                    this.toggle(2, "\u0110\u00e0o xuy\u00ean c\u00e1t khi \u0111i", "C\u00e1t ch\u1eafn \u0111\u01b0\u1eddng: c\u00f3 x\u1ebbng \u0111\u00e0o, kh\u00f4ng th\u00ec v\u00f2ng", () -> AutoMiner.digThrough, v -> {
                        AutoMiner.digThrough = v;
                    });
                    this.cycle(3, "Ph\u1ea1m vi t\u00ecm c\u00e1t", "T\u00ecm c\u00e1t trong b\u00e1n k\u00ednh n\u00e0y", () -> AutoMiner.scanRadius + " \u00f4", () -> {
                        int next = AutoMiner.SCAN_LEVELS[0];
                        for (int v : AutoMiner.SCAN_LEVELS) {
                            if (v <= AutoMiner.scanRadius) continue;
                            next = v;
                            break;
                        }
                        AutoMiner.scanRadius = next;
                    });
                    this.toggle(4, "B\u1ecb kick -> v\u1ec1 KingSMP", "Ra s\u1ea3nh: b\u1ea5m la b\u00e0n ch\u1ecdn KingSMP, \u0111\u00e0o ti\u1ebfp", () -> autoRejoin, v -> {
                        autoRejoin = v;
                    });
                    this.toggle(5, "D\u00f9ng ng\u1ecdc Ender", "Ch\u1ebft xa: mua ng\u1ecdc \u1edf /shop, n\u00e9m t\u1edbi ch\u1ed7 ch\u1ebft", () -> usePearl, v -> {
                        usePearl = v;
                    });
                    break;
                }
                case 6: {
                    this.begin(7);
                    this.toggle(0, "T\u1ef1 ph\u00f2ng th\u1ee7", "Qu\u00e1i th\u00f9 \u0111\u1ecbch l\u1ea1i g\u1ea7n -> c\u1ea7m ki\u1ebfm / r\u00ecu \u0111\u00e1nh r\u1ed3i \u0111\u00e0o ti\u1ebfp", () -> autoDefend, v -> {
                        autoDefend = v;
                    });
                    this.cycle(1, "B\u00e1n k\u00ednh ph\u00f2ng th\u1ee7", "Ch\u1ec9 \u0111\u00e1nh qu\u00e1i trong b\u00e1n k\u00ednh n\u00e0y", () -> defenseRadius + " \u00f4", () -> {
                        defenseRadius = AutoSandOrders.nextInt(DEFENSE_LEVELS, defenseRadius);
                    });
                    this.toggle(2, "Ch\u1ebf \u0111\u1ed9 gi\u1ea3m t\u1ea3i", "H\u1ea1 FPS / t\u1ea7m nh\u00ecn khi bot ch\u1ea1y, t\u1eaft bot th\u00ec tr\u1ea3 l\u1ea1i nh\u01b0 c\u0169", () -> lowLoad, v -> {
                        lowLoad = v;
                    });
                    this.cycle(3, "FPS khi \u0111ang m\u1edf game", "Gi\u1edbi h\u1ea1n FPS khi c\u1eeda s\u1ed5 game \u0111ang \u0111\u01b0\u1ee3c ch\u1ecdn", () -> "" + fgFps, () -> {
                        fgFps = AutoSandOrders.nextInt(FG_FPS_LEVELS, fgFps);
                    });
                    this.cycle(4, "FPS khi \u1edf n\u1ec1n", "Gi\u1edbi h\u1ea1n FPS khi c\u1eeda s\u1ed5 game kh\u00f4ng \u0111\u01b0\u1ee3c ch\u1ecdn", () -> "" + bgFps, () -> {
                        bgFps = AutoSandOrders.nextInt(BG_FPS_LEVELS, bgFps);
                    });
                    this.cycle(5, "T\u1ea7m nh\u00ecn gi\u1ea3m t\u1ea3i", "S\u1ed1 chunk khi b\u1eadt ch\u1ebf \u0111\u1ed9 gi\u1ea3m t\u1ea3i", () -> lowLoadView + " chunk", () -> {
                        lowLoadView = AutoSandOrders.nextInt(VIEW_LEVELS, lowLoadView);
                    });
                    this.cycle(6, "Gi\u00e1 c\u00e1t t\u1ed1i thi\u1ec3u", "B\u1ecf qua \u0111\u01a1n tr\u1ea3 th\u1ea5p h\u01a1n m\u1ee9c n\u00e0y (t\u1eaft = nh\u1eadn m\u1ecdi \u0111\u01a1n)", () -> minSandPrice <= 0.0 ? "t\u1eaft" : minSandPrice + " $", () -> {
                        minSandPrice = AutoSandOrders.nextDbl(MIN_PRICE_LEVELS, minSandPrice);
                    });
                    break;
                }
                case 5: {
                    Ctl c1 = this.add(1, this.cx, this.cy + 124, this.cw, 24, "Gi\u00e1 \u01b0\u1edbc t\u00ednh m\u1ed7i c\u00e1t", null, () -> {
                        double next = PRICE_LEVELS[0];
                        for (double v : PRICE_LEVELS) {
                            if (!(v > pricePerSand + 1.0E-4)) continue;
                            next = v;
                            break;
                        }
                        pricePerSand = next;
                        AutoSandOrders.save();
                    });
                    c1.value = () -> pricePerSand + " $";
                    this.add(2, this.cx, this.cy + 152, this.cw, 22, "\u0110\u1eb7t l\u1ea1i th\u1ed1ng k\u00ea", null, () -> {
                        statSand = 0L;
                        statTicks = 0L;
                        statDeaths = 0;
                        AutoSandOrders.save();
                    });
                }
            }
        }

        void stat(class_332 g, int x, int y, int w, int h, String label, String value, int vcol, float bar, int barCol) {
            AutoSandScreen.card(g, x, y, w, h, 8, -234218703, -15243339);
            g.method_51433(this.field_22793, label.toUpperCase(Locale.ROOT), x + 8, y + 5, -7433028, false);
            g.method_51433(this.field_22793, value, x + 8, y + 16, vcol, false);
            if (bar >= 0.0f) {
                int segs = 5;
                int gap = 3;
                int sw = (w - 16 - gap * (segs - 1)) / segs;
                int filled = Math.round(Math.min(1.0f, bar) * (float)segs);
                if (bar > 0.0f && filled == 0) {
                    filled = 1;
                }
                for (int k = 0; k < segs; ++k) {
                    AutoSandOrders.rrect(g, x + 8 + k * (sw + gap), y + h - 8, sw, 4, 2, k < filled ? barCol : -12429195);
                }
            }
        }

        void bullet(class_332 g, String s, int x, int y) {
            AutoSandOrders.rrect(g, x, y + 2, 4, 4, 2, -8657771);
            g.method_51433(this.field_22793, s, x + 9, y, -3946266, false);
        }

        public void method_25420(class_332 g, int mx, int my, float pt) {
            boolean runOn;
            int i;
            super.method_25420(g, mx, my, pt);
            this.backdrop(g);
            for (i = 8; i >= 1; --i) {
                AutoSandOrders.rrect(g, this.x0 - i, this.y0 - i, 620 + 2 * i, this.ph + 2 * i, 14 + i, 18 - i << 24 | 0x7C6CFF);
            }
            AutoSandOrders.rrect(g, this.x0, this.y0, 620, this.ph, 14, -15085569);
            AutoSandOrders.rrect(g, this.x0 + 1, this.y0 + 1, 618, this.ph - 2, 13, -234352608);
            g.method_25296(this.x0 + 8, this.y0 + 2, this.x0 + 620 - 8, this.y0 + 36, 0x22FFFFFF, 0xFFFFFF);
            for (i = 0; i < 48; ++i) {
                g.method_25294(this.x0 + 10 + i * 600 / 48, this.y0 + 35, this.x0 + 10 + (i + 1) * 600 / 48, this.y0 + 37, AutoSandScreen.grad3((float)i / 47.0f));
            }
            if (this.wasValid) {
                g.method_25294(this.x0 + 142, this.y0 + 46, this.x0 + 142 + 1, this.y0 + this.ph - 10, -15305560);
            }
            int icx = this.x0 + 12;
            int icy = this.y0 + 7;
            AutoSandOrders.rrect(g, icx, icy + 2, 22, 22, 6, -14159105);
            AutoSandOrders.rrect(g, icx, icy, 22, 22, 6, -16220515);
            g.method_25296(icx + 3, icy + 1, icx + 19, icy + 11, 0x66FFFFFF, 0xFFFFFF);
            g.method_25294(icx + 10, icy + 9, icx + 12, icy + 17, -13664966);
            g.method_25294(icx + 5, icy + 6, icx + 10, icy + 9, -13664966);
            g.method_25294(icx + 12, icy + 5, icx + 17, icy + 8, -12674228);
            g.method_25294(icx + 7, icy + 16, icx + 15, icy + 18, -9745874);
            this.gradText(g, "AUTOSAND", this.x0 + 42, this.y0 + 9, 2);
            String sub = (String)(this.wasValid ? AutoSandOrders.mode.label.toUpperCase(Locale.ROOT) + "  \u00b7  " : "") + "KINGSMP";
            this.spaced(g, sub, this.x0 + 42, this.y0 + 22, 1, -7433028);
            boolean bl = runOn = enabled && this.wasValid;
            String run = !this.wasValid ? "CH\u01afA K\u00cdCH HO\u1ea0T" : (enabled ? "\u0110ANG CH\u1ea0Y" : "\u0110ANG T\u1eaeT");
            int chipW = this.field_22793.method_1727(run) + 24;
            int chipX = this.x0 + 620 - 34 - chipW;
            int chipY = this.y0 + 9;
            int chipCol = runOn ? -9508966 : -38015;
            AutoSandOrders.rrect(g, chipX, chipY, chipW, 16, 8, chipCol);
            AutoSandOrders.rrect(g, chipX + 1, chipY + 1, chipW - 2, 14, 7, runOn ? -15649750 : -12970458);
            AutoSandOrders.rrect(g, chipX + 7, chipY + 5, 6, 6, 3, chipCol);
            g.method_51433(this.field_22793, run, chipX + 17, chipY + 4, chipCol, false);
            class_746 p = class_310.method_1551().field_1724;
            if (!this.wasValid) {
                AutoSandScreen.card(g, this.x0 + 16, this.y0 + this.ph / 2 - 64, 588, 118, 12, -234218703, -15243339);
                String t1 = "NH\u1eacP KEY \u0110\u1ec2 M\u1ede KH\u00d3A C\u00c1C CH\u1ee8C N\u0102NG";
                String t2 = License.status();
                this.gradText(g, "AUTOSAND PREMIUM", this.x0 + (620 - this.gradWidth("AUTOSAND PREMIUM", 2)) / 2, this.y0 + this.ph / 2 - 54, 2);
                g.method_51433(this.field_22793, t1, this.x0 + (620 - this.field_22793.method_1727(t1)) / 2, this.y0 + this.ph / 2 - 38, -4786433, false);
                g.method_51433(this.field_22793, t2, this.x0 + (620 - this.field_22793.method_1727(t2)) / 2, this.y0 + this.ph / 2 - 26, -7433028, false);
                this.spaced(g, "KEY", this.x0 + 24, this.y0 + this.ph / 2 - 16, 1, -7433028);
            } else if (this.tab == 0) {
                AutoSandScreen.card(g, this.cx, this.cy + 52, this.cw, 28, 10, -15980223, -15155733);
                AutoSandOrders.rrect(g, this.cx + 10, this.cy + 63, 7, 7, 3, enabled ? -15077168 : -47234);
                g.method_51433(this.field_22793, AutoSandOrders.stateText(), this.cx + 24, this.cy + 61, -4786433, false);
                int sw = (this.cw - 8) / 3;
                if (p != null) {
                    int sp = AutoSandOrders.shovelPct(p);
                    int food = p.method_7344().method_7586();
                    int spCol = sp > 50 ? -14498466 : (sp > 20 ? -680437 : -1096636);
                    this.stat(g, this.cx, this.cy + 86, sw, 42, "C\u00e1t", String.valueOf(AutoSandOrders.countItem(p, class_1802.field_8858)), -1, -1.0f, 0);
                    this.stat(g, this.cx + sw + 4, this.cy + 86, sw, 42, "B\u00ecnh XP", String.valueOf(AutoSandOrders.countItem(p, class_1802.field_8287)), -1, -1.0f, 0);
                    this.stat(g, this.cx + 2 * (sw + 4), this.cy + 86, sw, 42, "\u0110\u1ed3 \u0103n", String.valueOf(AutoSandOrders.countFood(p)), -1, -1.0f, 0);
                    this.stat(g, this.cx, this.cy + 132, sw, 42, "X\u1ebbng", (String)(sp < 0 ? "kh\u00f4ng c\u00f3" : sp + "%"), -1, sp < 0 ? -1.0f : (float)sp / 100.0f, spCol);
                    this.stat(g, this.cx + sw + 4, this.cy + 132, sw, 42, "\u0110\u00f3i", food + "/20", -1, (float)food / 20.0f, food <= eatBelow ? -1096636 : -680437);
                    this.stat(g, this.cx + 2 * (sw + 4), this.cy + 132, sw, 42, "Nh\u1eb7t c\u00e1t", AutoSandOrders.pickupLabel(), -1, -1.0f, 0);
                } else {
                    g.method_51433(this.field_22793, "Ch\u01b0a v\u00e0o th\u1ebf gi\u1edbi.", this.cx + 4, this.cy + 80, -7433028, false);
                }
            } else if (this.tab == 3) {
                int iy = this.cardY(3) + 6;
                AutoSandScreen.card(g, this.cx, iy, this.cw, 66, 8, -234218703, -15243339);
                this.bullet(g, "K\u1eb9t n\u01b0\u1edbc s\u00e2u / lava: t\u1ef1 b\u01a1i l\u00ean b\u1edd.", this.cx + 10, iy + 8);
                this.bullet(g, "B\u1ecb n\u01b0\u1edbc bao quanh: \u0111\u1eb7t c\u00e1t b\u1eafc c\u1ea7u v\u00e0o b\u1edd.", this.cx + 10, iy + 22);
                this.bullet(g, "R\u01a1i xu\u1ed1ng h\u1ed1: nh\u1ea3y + \u0111\u1eb7t c\u00e1t \u0111\u1ec3 leo, kh\u00f4ng \u0111\u00e0o l\u00ean.", this.cx + 10, iy + 36);
                this.bullet(g, "N\u00e9 n\u01b0\u1edbc/h\u1ed1 ph\u00eda tr\u01b0\u1edbc: ch\u1ec9 \u1edf ch\u1ebf \u0111\u1ed9 Gi\u1eef ph\u00edm / Nuker.", this.cx + 10, iy + 50);
            } else if (this.tab == 7) {
                int iy = this.cardY(4) + 2;
                AutoSandScreen.card(g, this.cx, iy, this.cw, 62, 8, -234218703, -15243339);
                this.bullet(g, "B\u1eadt r\u1ed3i b\u1ea5m B\u1eaeT \u0110\u1ea6U \u0110\u00c0O: h\u1ea7m \u0111i theo h\u01b0\u1edbng b\u1ea1n \u0111ang nh\u00ecn.", this.cx + 10, iy + 8);
                this.bullet(g, "M\u1ed7i b\u01b0\u1edbc \u0111\u00e0o h\u1ebft m\u1eb7t c\u1eaft (r\u1ed9ng x cao), r\u1ed3i m\u1edbi ti\u1ebfn l\u00ean.", this.cx + 10, iy + 22);
                this.bullet(g, "H\u1ebft c\u00e1t / g\u1eb7p n\u01b0\u1edbc / b\u1ecb ch\u1eb7n: t\u1ef1 r\u1ebd, kh\u00f4ng \u0111\u01b0\u1ee3c th\u00ec \u0111\u00e0o th\u01b0\u1eddng.", this.cx + 10, iy + 36);
                this.bullet(g, "Ch\u1ec9 ch\u1ea1y \u1edf ch\u1ebf \u0111\u1ed9 T\u1ef1 \u0111\u00e0o. C\u00e1t c\u1ea1nh n\u01b0\u1edbc / lava b\u1ecb b\u1ecf qua.", this.cx + 10, iy + 50);
            } else if (this.tab == 5) {
                int sw = (this.cw - 4) / 2;
                this.stat(g, this.cx, this.cy, this.cw, 36, "To\u1ea1 \u0111\u1ed9 ch\u1ebft g\u1ea7n nh\u1ea5t", AutoMiner.lastDeathText == null ? "Ch\u01b0a ch\u1ebft l\u1ea7n n\u00e0o" : AutoMiner.lastDeathText, -1, -1.0f, 0);
                this.stat(g, this.cx, this.cy + 40, sw, 36, "Th\u1eddi gian treo", AutoSandOrders.fmtTime(statTicks), -1, -1.0f, 0);
                this.stat(g, this.cx + sw + 4, this.cy + 40, sw, 36, "T\u1ed5ng ti\u1ec1n ki\u1ebfm \u0111\u01b0\u1ee3c", AutoSandOrders.fmtMoney(), -14498466, -1.0f, 0);
                this.stat(g, this.cx, this.cy + 80, sw, 36, "C\u00e1t \u0111\u00e3 giao", String.valueOf(statSand), -1, -1.0f, 0);
                this.stat(g, this.cx + sw + 4, this.cy + 80, sw, 36, "S\u1ed1 l\u1ea7n ch\u1ebft", String.valueOf(statDeaths), -1096636, -1.0f, 0);
            }
            for (Ctl c : this.ctls) {
                this.drawCtl(g, c, mx, my);
            }
            g.method_51433(this.field_22793, "ESC \u0111\u1ec3 \u0111\u00f3ng", this.x0 + 12, this.y0 + this.ph - 18, -10064748, false);
            g.method_51433(this.field_22793, License.status(), this.x0 + 142 + 10, this.y0 + this.ph - 18, -9508966, false);
        }

        void drawCtl(class_332 g, Ctl c, int mx, int my) {
            boolean hov = mx >= c.x && mx < c.x + c.w && my >= c.y && my < c.y + c.h;
            switch (c.kind) {
                case 0: 
                case 1: {
                    int ty;
                    AutoSandScreen.card(g, c.x, c.y, c.w, c.h, 7, hov ? -15713958 : -234218703, hov ? -9602049 : -15243339);
                    g.method_25296(c.x + 4, c.y + 1, c.x + c.w - 4, c.y + 1 + c.h / 2, 0xEFFFFFF, 0xFFFFFF);
                    boolean showDesc = c.desc != null && c.h >= 26;
                    int n = ty = showDesc ? c.y + 4 : c.y + (c.h - 8) / 2;
                    if (c.kind == 0) {
                        float target;
                        boolean on = c.on != null && c.on.getAsBoolean();
                        float f = target = on ? 1.0f : 0.0f;
                        if (c.t < 0.0f) {
                            c.t = target;
                        }
                        c.t += Math.max(-0.2f, Math.min(0.2f, target - c.t));
                        AutoSandOrders.rrect(g, c.x + 2, c.y + 5, 3, c.h - 10, 1, on ? -9508966 : -12429195);
                        int sx = c.x + c.w - 40;
                        int sy = c.y + (c.h - 14) / 2;
                        AutoSandOrders.rrect(g, sx, sy, 30, 14, 7, AutoSandOrders.lerpC(-12429195, -9508966, c.t));
                        AutoSandOrders.rrect(g, sx + 2 + (int)(c.t * 16.0f), sy + 2, 10, 10, 5, -1);
                    } else {
                        AutoSandOrders.rrect(g, c.x + 2, c.y + 5, 3, c.h - 10, 1, -5796870);
                        String v = c.value == null ? "" : c.value.get();
                        int chipW = this.field_22793.method_1727(v) + 18;
                        int chipX = c.x + c.w - chipW - 8;
                        int chipY = c.y + (c.h - 16) / 2;
                        AutoSandOrders.rrect(g, chipX, chipY, chipW, 16, 8, hov ? -7701505 : -10794021);
                        g.method_25296(chipX + 4, chipY + 1, chipX + chipW - 4, chipY + 8, 0x30FFFFFF, 0xFFFFFF);
                        g.method_51433(this.field_22793, v, chipX + 9, chipY + 4, -1, false);
                    }
                    g.method_51433(this.field_22793, c.title, c.x + 12, ty, -1, false);
                    if (!showDesc) break;
                    g.method_51433(this.field_22793, c.desc, c.x + 12, c.y + 15, -7433028, false);
                    break;
                }
                case 2: {
                    AutoSandScreen.button3d(g, c.x, c.y, c.w, c.h, -15077168, -16220515, -14159105, hov);
                    class_5250 t = class_2561.method_43470((String)c.title.toUpperCase(Locale.ROOT)).method_27692(class_124.field_1067);
                    g.method_51439(this.field_22793, (class_2561)t, c.x + (c.w - this.field_22793.method_27525((class_5348)t)) / 2, c.y + (c.h - 3 - 8) / 2 + (hov ? 1 : 0) + 1, -1245185, false);
                    break;
                }
                case 3: {
                    float target;
                    float f = target = enabled ? 1.0f : 0.0f;
                    if (c.t < 0.0f) {
                        c.t = target;
                    }
                    c.t += Math.max(-0.12f, Math.min(0.12f, target - c.t));
                    int glow = enabled ? 15750767 : 7268250;
                    for (int i = 5; i >= 1; --i) {
                        AutoSandOrders.rrect(g, c.x - i, c.y - i, c.w + 2 * i, c.h + 2 * i, 9 + i, 22 - i * 3 << 24 | glow);
                    }
                    if (enabled) {
                        AutoSandScreen.button3d(g, c.x, c.y, c.w, c.h, -47234, -7596209, -45158, hov);
                    } else {
                        AutoSandScreen.button3d(g, c.x, c.y, c.w, c.h, -15077168, -16220515, -14159105, hov);
                    }
                    class_5250 label = class_2561.method_43470((String)(enabled ? "\u0110ANG CH\u1ea0Y  \u00b7  B\u1ea4M \u0110\u1ec2 D\u1eeaNG" : "B\u1eaeT \u0110\u1ea6U \u0110\u00c0O")).method_27692(class_124.field_1067);
                    g.method_51439(this.field_22793, (class_2561)label, c.x + (c.w - this.field_22793.method_27525((class_5348)label)) / 2, c.y + (c.h - 3 - 8) / 2 + (hov ? 1 : 0) + 1, enabled ? -1 : -1245185, false);
                    break;
                }
                case 4: {
                    if (c.selected) {
                        AutoSandOrders.rrect(g, c.x, c.y, c.w, c.h, 7, c.color);
                        AutoSandOrders.rrect(g, c.x + 1, c.y + 1, c.w - 2, c.h - 2, 6, AutoSandOrders.lerpC(-234352608, c.color, 0.24f));
                        AutoSandOrders.rrect(g, c.x + 2, c.y + 5, 3, c.h - 10, 1, c.color);
                    } else if (hov) {
                        AutoSandOrders.rrect(g, c.x, c.y, c.w, c.h, 7, -15196854);
                    }
                    AutoSandOrders.rrect(g, c.x + 10, c.y + (c.h - 6) / 2, 6, 6, 3, c.color);
                    g.method_51433(this.field_22793, c.title, c.x + 22, c.y + (c.h - 8) / 2, c.selected ? -1 : (hov ? -2564875 : -7433028), false);
                    break;
                }
                default: {
                    AutoSandOrders.rrect(g, c.x, c.y, c.w, c.h, 8, hov ? -41862 : -14538650);
                    g.method_51433(this.field_22793, c.title, c.x + (c.w - this.field_22793.method_1727(c.title)) / 2, c.y + (c.h - 8) / 2, -1, false);
                }
            }
        }

        public void method_25393() {
            super.method_25393();
        }

        public boolean method_25421() {
            return false;
        }

        static final class Ctl {
            int kind;
            int x;
            int y;
            int w;
            int h;
            int color;
            String title;
            String desc;
            BooleanSupplier on;
            Supplier<String> value;
            float t = -1.0f;
            boolean selected;

            Ctl() {
            }
        }
    }

    static enum G {
        NONE,
        LIQUID,
        ESCAPE,
        SIDE,
        PICKUP,
        BRIDGE,
        UNSTICK;

    }

    static final class License {
        static final String API_BASE = "https://snadpremiun.vietanduong35.workers.dev";

        private License() {
        }

        static void init() {
        }

        static void activate(String key) {
        }

        static void refreshIfNeeded() {
        }

        static boolean valid() {
            return true;
        }

        static String status() {
            return "kh\u00f4ng c\u1ea7n key (\u0111\u00e3 g\u1ee1 ki\u1ec3m tra)";
        }
    }
}
