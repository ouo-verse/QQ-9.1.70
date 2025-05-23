package rm4;

import com.tencent.mobileqq.utils.p;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.timi.game.env.ServerEnv;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {
    public static Object a(String str, Object obj) {
        return p.c(BaseApplication.getContext(), e(), MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount(), str, obj);
    }

    public static boolean b(String str, boolean z16) {
        Object a16 = a(str, Boolean.valueOf(z16));
        if (a16 instanceof Boolean) {
            return ((Boolean) a16).booleanValue();
        }
        return z16;
    }

    public static int c(String str, int i3) {
        Object a16 = a(str, Integer.valueOf(i3));
        if (a16 instanceof Integer) {
            return ((Integer) a16).intValue();
        }
        return i3;
    }

    public static long d(String str, long j3) {
        Object a16 = a(str, Long.valueOf(j3));
        if (a16 instanceof Long) {
            return ((Long) a16).longValue();
        }
        return j3;
    }

    private static String e() {
        return "tg_personal_sp_" + ServerEnv.b();
    }

    public static String f(String str, String str2) {
        Object a16 = a(str, str2);
        if (a16 instanceof String) {
            return (String) a16;
        }
        return str2;
    }

    public static void g(String str, Object obj) {
        p.e(BaseApplication.getContext(), e(), MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount(), true, str, obj);
    }

    public static void h(String str, boolean z16) {
        g(str, Boolean.valueOf(z16));
    }

    public static void i(String str, int i3) {
        g(str, Integer.valueOf(i3));
    }

    public static void j(String str, long j3) {
        g(str, Long.valueOf(j3));
    }

    public static void k(String str, String str2) {
        g(str, str2);
    }
}
