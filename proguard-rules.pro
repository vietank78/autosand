# ===================== proguard-rules.pro (autosand) =====================
# Dùng với proguard-gradle (chạy SAU khi remapJar của Loom xong, trên jar đã remap sang Mojang mappings).
# Fabric/Loom KHÔNG hỗ trợ ProGuard trực tiếp trong pipeline build thường -> xem README_PROTECT.md
# để biết cách gắn 1 Gradle task riêng chạy ProGuard trên remapJar output, tạo ra bản "-obf.jar" để phát hành.

-optimizationpasses 5
-overloadaggressively
-repackageclasses ''
-allowaccessmodification
-dontpreverify
-keepattributes !SourceFile,!LineNumberTable,!LocalVariableTable,!LocalVariableTypeTable

# --- Giữ entrypoint Fabric (bắt buộc, nếu không mod sẽ không load được) ---
-keep class autosand.AutoSandOrders {
    public void onInitializeClient();
    public <init>();
}
-keep class * implements net.fabricmc.api.ClientModInitializer

# --- Nếu có dùng Mixin, PHẢI giữ nguyên các class/method @Mixin, @Inject, @Shadow, @ModifyVariable... ---
# (project hiện tại trong file bạn gửi không thấy @Mixin, bỏ qua nếu không dùng; nếu có thêm sau thì thêm:)
# -keep @org.spongepowered.asm.mixin.Mixin class * { *; }
# -keepclassmembers class * {
#     @org.spongepowered.asm.mixin.* <methods>;
#     @org.spongepowered.asm.mixin.* <fields>;
# }

# --- Giữ class StringDecryptor (tên method/field vẫn được rename, chỉ giữ CHỮ KÝ gọi được) ---
-keep,allowobfuscation class autosand.crypto.StringDecryptor {
    public static java.lang.String d(java.lang.String, java.lang.String);
}

# --- Giữ AntiDebug entrypoint gọi được từ onInitializeClient ---
-keep,allowobfuscation class autosand.crypto.AntiDebug {
    public static boolean check();
}

# --- Không đụng vào Minecraft / Fabric / Baritone / thư viện ngoài (đã có trong classpath lúc chạy, KHÔNG gộp vào jar) ---
-dontwarn net.minecraft.**
-dontwarn net.fabricmc.**
-dontwarn baritone.**
-dontwarn com.mojang.**
-dontwarn com.google.gson.**

# --- Giữ enum (ProGuard cần giữ values()/valueOf() nếu dùng reflection; project này dùng khá nhiều reflection) ---
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

# --- Project dùng reflection nhiều (Class.forName, getMethod, Constructor...) để tương thích nhiều phiên bản API.
#     ProGuard KHÔNG tự biết những class/method đó bị gọi qua reflection nên có thể bị xoá/đổi tên sai.
#     Phải liệt kê thủ công từng chỗ dùng Class.forName("...") / tên lớp literal trong code gốc. Ví dụ mẫu: ---
# -keep class net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper { *; }
# -keep class net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper { *; }
# (xem thêm ghi chú trong README_PROTECT.md — đây là phần RỦI RO NHẤT khi obfuscate project này)

# --- Loại bỏ log debug không cần thiết nếu có (tuỳ chọn) ---
# -assumenosideeffects class java.lang.System {
#     public static void out.println(...);
# }
