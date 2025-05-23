package ty4;

import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class d {
    public static String a(String str) {
        String[] split = str.split("_");
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < split.length; i3++) {
            sb5.append(split[i3].substring(0, 1).toUpperCase());
            sb5.append(split[i3].substring(1));
        }
        return sb5.toString();
    }

    public static void b(String str) {
        Log.d("X2J_Ano", str);
    }

    public static void c(String str) {
        Log.e("X2J_Ano", str);
    }

    public static void d(String str, Throwable th5) {
        Log.e("X2J_Ano", str + ", Throwable : " + Log.getStackTraceString(th5));
    }

    public static void e(View view) {
        Drawable background = view.getBackground();
        if (background != null && background.getPadding(new Rect())) {
            view.setPadding(0, 0, 0, 0);
        }
    }

    private static void f(TextView textView, Typeface typeface, int i3, int i16) {
        boolean z16;
        Typeface create;
        if (i16 < 0) {
            textView.setTypeface(typeface, i3);
            return;
        }
        if (Build.VERSION.SDK_INT <= 27) {
            textView.setTypeface(typeface, i3);
            return;
        }
        int min = Math.min(1000, i16);
        if ((i3 & 2) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        create = Typeface.create(typeface, min, z16);
        textView.setTypeface(create);
    }

    public static void g(Object obj, Class cls, String str, Object obj2) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(obj, obj2);
        } catch (Exception e16) {
            d("setField", e16);
        }
    }

    public static void h(TextView textView, int i3, String str, Typeface typeface, int i16, int i17) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26 = false;
        if (str != null) {
            f(textView, Typeface.create(str, 0), i16, i17);
            return;
        }
        int i18 = i3 & 4095;
        if (i18 == 129) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (i18 == 225) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (i18 == 18) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (!z16 && !z17 && !z18) {
            z19 = false;
        } else {
            z19 = true;
        }
        if (z19 || (textView.getInputType() & 4095) == 129) {
            z26 = true;
        }
        if (z26) {
            typeface = Typeface.MONOSPACE;
        }
        f(textView, typeface, i16, i17);
    }
}
