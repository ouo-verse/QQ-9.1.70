package ud0;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static volatile td0.a f438802a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile Boolean f438803b;

    /* renamed from: c, reason: collision with root package name */
    private static volatile Application f438804c;

    public static Context a() {
        if (b() != null) {
            return b().getApplication();
        }
        if (f438804c == null) {
            f438804c = c();
        }
        return f438804c;
    }

    private static td0.a b() {
        if (f438802a == null) {
            synchronized (b.class) {
                if (f438802a == null) {
                    f438802a = (td0.a) c.a(td0.a.class);
                }
            }
        }
        return f438802a;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0061 A[RETURN] */
    @SuppressLint({"PrivateApi", "DiscouragedPrivateApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Application c() {
        Application application;
        Exception e16;
        Application application2;
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", new Class[0]);
            declaredMethod.setAccessible(true);
            application = (Application) declaredMethod.invoke(null, new Object[0]);
            try {
                d.g("QUIApplication", d.f438811e, "curApp class1:" + application);
            } catch (Exception e17) {
                e = e17;
                d.b("QUIApplication", d.f438811e, "getCurApplication e:" + e.getMessage(), e);
                if (application == null) {
                }
            }
        } catch (Exception e18) {
            e = e18;
            application = null;
        }
        if (application == null) {
            return application;
        }
        try {
            Method declaredMethod2 = Class.forName("android.app.AppGlobals").getDeclaredMethod("getInitialApplication", new Class[0]);
            declaredMethod2.setAccessible(true);
            application2 = (Application) declaredMethod2.invoke(null, new Object[0]);
            try {
                d.g("QUIApplication", d.f438811e, "curApp class2:" + application2);
            } catch (Exception e19) {
                e16 = e19;
                d.b("QUIApplication", d.f438811e, "getCurApplication e:" + e16.getMessage(), e16);
                return application2;
            }
        } catch (Exception e26) {
            Application application3 = application;
            e16 = e26;
            application2 = application3;
        }
        return application2;
    }

    public static boolean d() {
        ApplicationInfo applicationInfo;
        boolean z16;
        try {
            if (f438803b != null) {
                return f438803b.booleanValue();
            }
            if (a() != null) {
                applicationInfo = a().getApplicationInfo();
            } else {
                applicationInfo = null;
            }
            if (applicationInfo != null && (applicationInfo.flags & 2) != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            f438803b = Boolean.valueOf(z16);
            return f438803b.booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }
}
