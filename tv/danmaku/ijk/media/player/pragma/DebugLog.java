package tv.danmaku.ijk.media.player.pragma;

import com.tencent.oskplayer.support.log.Logger;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes30.dex */
public class DebugLog {
    public static final boolean ENABLE_DEBUG = true;
    public static final boolean ENABLE_ERROR = true;
    public static final boolean ENABLE_INFO = true;
    public static final boolean ENABLE_VERBOSE = true;
    public static final boolean ENABLE_WARN = true;

    public static void d(String str, String str2) {
        Logger.g().d(str, str2);
    }

    public static void dfmt(String str, String str2, Object... objArr) {
        Logger.g().d(str, String.format(Locale.US, str2, objArr));
    }

    public static void e(String str, String str2) {
        Logger.g().e(str, str2);
    }

    public static void efmt(String str, String str2, Object... objArr) {
        Logger.g().e(str, String.format(Locale.US, str2, objArr));
    }

    public static void i(String str, String str2) {
        Logger.g().i(str, str2);
    }

    public static void ifmt(String str, String str2, Object... objArr) {
        Logger.g().i(str, String.format(Locale.US, str2, objArr));
    }

    public static void printCause(Throwable th5) {
        Throwable cause = th5.getCause();
        if (cause != null) {
            th5 = cause;
        }
        printStackTrace(th5);
    }

    public static void printStackTrace(Throwable th5) {
        th5.printStackTrace();
    }

    public static void v(String str, String str2) {
        Logger.g().v(str, str2);
    }

    public static void vfmt(String str, String str2, Object... objArr) {
        Logger.g().v(str, String.format(Locale.US, str2, objArr));
    }

    public static void w(String str, String str2) {
        Logger.g().w(str, str2);
    }

    public static void wfmt(String str, String str2, Object... objArr) {
        Logger.g().w(str, String.format(Locale.US, str2, objArr));
    }

    public static void d(String str, String str2, Throwable th5) {
        Logger.g().d(str, str2, th5);
    }

    public static void e(String str, String str2, Throwable th5) {
        Logger.g().e(str, str2, th5);
    }

    public static void i(String str, String str2, Throwable th5) {
        Logger.g().i(str, str2, th5);
    }

    public static void v(String str, String str2, Throwable th5) {
        Logger.g().v(str, str2, th5);
    }

    public static void w(String str, String str2, Throwable th5) {
        Logger.g().w(str, str2, th5);
    }
}
