package ud0;

import android.content.Context;
import android.widget.Toast;

/* compiled from: P */
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static volatile td0.h f438814a;

    private static td0.h a() {
        if (f438814a == null) {
            synchronized (e.class) {
                if (f438814a == null) {
                    f438814a = (td0.h) c.a(td0.h.class);
                }
            }
        }
        return f438814a;
    }

    public static void b(Context context, int i3, String str, int i16) {
        f438814a = a();
        if (f438814a == null) {
            Toast.makeText(context, str, i16).show();
        } else {
            f438814a.a(context, i3, str, i16);
        }
    }
}
