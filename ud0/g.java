package ud0;

import td0.j;

/* compiled from: P */
/* loaded from: classes5.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static j f438815a;

    private static j a() {
        if (f438815a == null) {
            synchronized (b.class) {
                if (f438815a == null) {
                    f438815a = (j) c.a(j.class);
                }
            }
        }
        return f438815a;
    }

    public static boolean b(String str, boolean z16) {
        if (a() != null) {
            return a().isSwitchOn(str, z16);
        }
        return z16;
    }

    public static String c(String str, String str2) {
        if (a() != null) {
            return a().a(str, str2);
        }
        return str2;
    }
}
