package ud0;

import android.content.Context;
import td0.l;

/* compiled from: P */
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static volatile l f438817a;

    public static boolean a(Context context) {
        l c16 = c();
        if (c16 == null) {
            return true;
        }
        return c16.checkPermission(context);
    }

    public static void b(Context context) {
        l c16 = c();
        if (c16 == null) {
            return;
        }
        c16.enterPermissionRequestDialog(context);
    }

    private static l c() {
        if (f438817a == null) {
            synchronized (e.class) {
                if (f438817a == null) {
                    f438817a = (l) c.a(l.class);
                }
            }
        }
        return f438817a;
    }
}
