
package autosand;

import com.mojang.brigadier.arguments.StringArgumentType;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.List;
import java.util.Locale;

public class AutoSandMod implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        License.init();

        ClientCommandRegistrationCallback.EVENT.register(
            (dispatcher, registryAccess) ->
                dispatcher.register(
                    ClientCommandManager.literal("autosand")
                        .then(ClientCommandManager.literal("key")
                            .then(ClientCommandManager.argument(
                                    "key", StringArgumentType.greedyString())
                                .executes(context -> {
                                    String key = StringArgumentType.getString(
                                        context, "key");
                                    License.activate(key);
                                    context.getSource().sendFeedback(
                                        Text.literal(
                                            "[AutoSand] Dang xac thuc key..."));
                                    return 1;
                                })))
                        .then(ClientCommandManager.literal("status")
                            .executes(context -> {
                                context.getSource().sendFeedback(
                                    Text.literal("[AutoSand] Key: "
                                        + License.status()));
                                return 1;
                            }))
                )
        );

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player != null) {
                License.refreshIfNeeded();
            }
        });
    }

    static final class License {
        private static final String VERIFY_URL =
            "https://snadpremiun.vietanduong35.workers.dev/verify";

        private static final long CHECK_INTERVAL_MS = 60_000L;

        private static final HttpClient HTTP = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(5))
            .build();

        private static Path file;
        private static volatile String storedKey;
        private static volatile boolean valid;
        private static volatile boolean checking;
        private static volatile long lastAttempt;
        private static volatile String statusText = "chua kich hoat";

        static void init() {
            file = FabricLoader.getInstance()
                .getConfigDir().resolve("autosandmod.lic");

            try {
                if (Files.exists(file)) {
                    List<String> lines =
                        Files.readAllLines(file, StandardCharsets.UTF_8);

                    if (!lines.isEmpty()) {
                        storedKey = lines.get(0).trim();
                        statusText = "cho xac thuc";
                    }
                }
            } catch (Exception e) {
                statusText = "khong doc duoc file key";
            }
        }

        static synchronized void activate(String key) {
            String cleaned = key == null ? ""
                : key.trim().toUpperCase(Locale.ROOT);

            if (cleaned.isEmpty()) {
                statusText = "chua nhap key";
                return;
            }

            storedKey = cleaned;
            valid = false;
            lastAttempt = 0L;
            statusText = "dang xac thuc";

            try {
                Files.writeString(
                    file, cleaned, StandardCharsets.UTF_8);
            } catch (Exception e) {
                statusText = "khong luu duoc key";
                return;
            }

            verifyOnline();
        }

        static synchronized void refreshIfNeeded() {
            if (storedKey == null || storedKey.isBlank() || checking) {
                return;
            }

            if (System.currentTimeMillis() - lastAttempt
                    >= CHECK_INTERVAL_MS) {
                verifyOnline();
            }
        }

        private static String escapeJson(String value) {
            return value.replace("\\", "\\\\")
                .replace("\"", "\\\"");
        }

        private static synchronized void verifyOnline() {
            MinecraftClient client = MinecraftClient.getInstance();

            if (client.player == null || storedKey == null || checking) {
                return;
            }

            checking = true;
            lastAttempt = System.currentTimeMillis();
            statusText = "dang xac thuc";

            String playerName = client.player.getName().getString();

            String body = "{\"key\":\"" + escapeJson(storedKey)
                + "\",\"authType\":\"player\",\"playerName\":\""
                + escapeJson(playerName) + "\"}";

            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(VERIFY_URL))
                .timeout(Duration.ofSeconds(8))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(
                    body, StandardCharsets.UTF_8))
                .build();

            HTTP.sendAsync(
                request, HttpResponse.BodyHandlers.ofString())
                .whenComplete((response, error) -> {
                    boolean accepted = error == null
                        && response != null
                        && response.statusCode() == 200
                        && response.body().matches(
                            "(?s).*\\\"valid\\\"\\s*:\\s*true.*");

                    synchronized (License.class) {
                        checking = false;
                        valid = accepted;

                        if (accepted) {
                            statusText = "key hop le";
                        } else if (error != null) {
                            statusText = "loi ket noi may chu";
                        } else {
                            statusText =
                                "key sai, sai ten hoac da thu hoi";
                        }
                    }

                    client.execute(() -> {
                        if (client.player != null) {
                            client.player.sendMessage(
                                Text.literal("[AutoSand] " + statusText),
                                false);
                        }
                    });
                });
        }

        static boolean valid() {
            return valid;
        }

        static String status() {
            return statusText;
        }
    }
}
