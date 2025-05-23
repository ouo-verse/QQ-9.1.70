package wz3;

import android.content.res.Resources;

/* compiled from: P */
/* loaded from: classes25.dex */
public class e {
    private static float a() {
        Resources a16 = g.a();
        if (a16 == null) {
            return 0.0f;
        }
        return a16.getDisplayMetrics().density;
    }

    public static int b(float f16) {
        float a16 = a();
        if (a16 <= 0.0f) {
            return 0;
        }
        return Math.round(f16 / a16);
    }
}
