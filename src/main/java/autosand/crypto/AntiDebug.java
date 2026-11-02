package autosand.crypto;

import java.lang.management.ManagementFactory;
import java.util.List;

/**
 * Check anti-debug cơ bản — KHÔNG chống được người biết việc, chỉ chặn số đông người tò mò
 * gắn debugger/decompiler trực tiếp vào jar đang chạy. Gọi check() sớm trong onInitializeClient().
 *
 * check() trả false nếu phát hiện dấu hiệu debug. Bạn tự quyết định xử lý khi false:
 * - Nhẹ: tắt tính năng nhạy cảm (license check, auto-sell...), chạy "giả" (silent fail).
 * - Mạnh hơn: âm thầm làm sai lệch hành vi (ví dụ: luôn báo "key không hợp lệ") thay vì crash ngay
 *   — crash ngay quá dễ nhận biết là có anti-debug, nên người bẻ khoá sẽ tìm đúng chỗ đó để patch.
 */
public final class AntiDebug {

    private AntiDebug() { }

    public static boolean check() {
        try {
            if (jdwpAttached()) return false;
            if (suspiciousAgent()) return false;
            return true;
        } catch (Throwable t) {
            // Không rõ -> coi như an toàn, tránh crash nhầm trên máy người dùng hợp lệ.
            return true;
        }
    }

    /** Phát hiện debugger gắn qua JDWP (jdb, IntelliJ remote debug, v.v.) qua JVM input arguments. */
    private static boolean jdwpAttached() {
        List<String> args = ManagementFactory.getRuntimeMXBean().getInputArguments();
        for (String a : args) {
            String al = a.toLowerCase();
            if (al.contains("-agentlib:jdwp") || al.contains("-xrunjdwp") || al.contains("jdwp")) {
                return true;
            }
        }
        return false;
    }

    /** Phát hiện java agent lạ được nạp (một số tool decompile/patch runtime dùng javaagent). */
    private static boolean suspiciousAgent() {
        List<String> args = ManagementFactory.getRuntimeMXBean().getInputArguments();
        for (String a : args) {
            if (a.startsWith("-javaagent:")) return true;
        }
        return false;
    }
}
