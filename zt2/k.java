package zt2;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.Foreground;

/* compiled from: P */
/* loaded from: classes19.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private static List<String> f453212a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private static boolean f453213b;

    public static void a(String str) {
        f453212a.add(str);
    }

    public static void b() {
        f453212a.clear();
        f453213b = false;
    }

    public static boolean c() {
        boolean z16 = f453213b;
        if (z16) {
            f453213b = false;
        }
        return z16;
    }

    public static boolean d(String str) {
        if (e.f453199a.k() && f453212a.contains(str)) {
            return true;
        }
        return false;
    }

    public static void e() {
        QLog.d("TVideoSilentLoginUtil", 1, "loginSilent");
        e.f453199a.m(Foreground.getTopActivity(), null);
    }

    public static void f() {
        if (!e.f453199a.k()) {
            f453213b = true;
        }
    }
}
