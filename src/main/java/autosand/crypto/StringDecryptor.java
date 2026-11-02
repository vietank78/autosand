package autosand.crypto;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * Giải mã các chuỗi nhạy cảm (URL server, v.v.) đã mã hoá sẵn lúc build bằng StringEncryptTool.
 * Tên class này được ProGuard giữ lại (không xoá), nhưng method/field bên trong vẫn bị rename
 * (xem -keep,allowobfuscation trong proguard-rules.pro).
 *
 * GIỚI HẠN THỰC TẾ: key AES nằm trong chính class file (dù chia nhỏ). Người kiên trì vẫn có thể
 * đặt breakpoint ngay tại hàm d() và đọc giá trị trả về lúc runtime. Đây là giới hạn chung của
 * MỌI kỹ thuật string-encryption, kể cả công cụ trả phí (Allatori, ZKM...). Mục tiêu ở đây chỉ là
 * chặn việc "Ctrl+F tìm URL trong JD-GUI", không phải chặn tuyệt đối.
 */
public final class StringDecryptor {

    private StringDecryptor() { }

    // Key chia nhỏ thành mảng int, ghép runtime để khó bị grep ra ngay trong bytecode dạng chuỗi liên tục.
    private static final byte[] KEY = buildKey();

    private static byte[] buildKey() {
        int[] parts = {
            0x4B, 0x65, 0x79, 0x31, 0x32, 0x33, 0x34, 0x35,
            0x36, 0x37, 0x38, 0x39, 0x30, 0x41, 0x42, 0x43
        };
        byte[] key = new byte[parts.length];
        for (int i = 0; i < parts.length; i++) key[i] = (byte) parts[i];
        return key;
    }

    /** cipherTextBase64 + ivBase64 do StringEncryptTool sinh ra lúc build. */
    public static String d(String cipherTextBase64, String ivBase64) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec keySpec = new SecretKeySpec(KEY, "AES");
            IvParameterSpec ivSpec = new IvParameterSpec(Base64.getDecoder().decode(ivBase64));
            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
            byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(cipherTextBase64));
            return new String(decrypted, "UTF-8");
        } catch (Exception e) {
            // Không log chi tiết lỗi (tránh lộ gợi ý về thuật toán/khoá qua stacktrace nếu bị bắt lỗi).
            throw new RuntimeException("Decrypt failed");
        }
    }
}
