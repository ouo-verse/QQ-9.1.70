package re4;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static c f431177a;

    public static void a(String str, String str2) {
        c cVar = f431177a;
        if (cVar != null) {
            cVar.log(str, str2);
            return;
        }
        Log.e(str, "\u672a\u6ce8\u518clogger msg:" + str2);
    }

    public static void b(String str, String str2) {
        a(str, "|E| " + str2);
    }

    public static void c(String str, String str2, Throwable th5) {
        a(str, "|E|" + str2 + '\n' + Log.getStackTraceString(th5));
    }

    public static void d(String str, String str2) {
        a(str, "|I| " + str2);
    }

    public static void e(c cVar) {
        f431177a = cVar;
    }

    public static void f(String str, String str2) {
        a(str, "|W| " + str2);
    }
}
