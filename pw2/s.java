package pw2;

import android.content.res.Resources;
import android.util.DisplayMetrics;

/* compiled from: P */
/* loaded from: classes19.dex */
public class s {
    public static int a(float f16) {
        return (int) ((f16 * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static int b() {
        DisplayMetrics displayMetrics;
        Resources resources = qv2.b.a().getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            return 0;
        }
        return displayMetrics.heightPixels;
    }

    public static int c() {
        DisplayMetrics displayMetrics;
        Resources resources = qv2.b.a().getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            return 0;
        }
        return displayMetrics.widthPixels;
    }
}
