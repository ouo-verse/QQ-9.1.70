package z0;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.core.graphics.ColorUtils;
import g1.b;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a {
    @ColorInt
    public static int a(@ColorInt int i3, @IntRange(from = 0, to = 255) int i16) {
        return ColorUtils.setAlphaComponent(i3, (Color.alpha(i3) * i16) / 255);
    }

    @ColorInt
    public static int b(@NonNull Context context, @AttrRes int i3, @ColorInt int i16) {
        TypedValue a16 = b.a(context, i3);
        if (a16 != null) {
            return a16.data;
        }
        return i16;
    }

    @ColorInt
    public static int c(Context context, @AttrRes int i3, String str) {
        return b.d(context, i3, str);
    }

    @ColorInt
    public static int d(@NonNull View view, @AttrRes int i3) {
        return b.e(view, i3);
    }

    @ColorInt
    public static int e(@NonNull View view, @AttrRes int i3, @ColorInt int i16) {
        return b(view.getContext(), i3, i16);
    }

    public static boolean f(@ColorInt int i3) {
        if (i3 != 0 && ColorUtils.calculateLuminance(i3) > 0.5d) {
            return true;
        }
        return false;
    }

    @ColorInt
    public static int g(@ColorInt int i3, @ColorInt int i16) {
        return ColorUtils.compositeColors(i16, i3);
    }

    @ColorInt
    public static int h(@ColorInt int i3, @ColorInt int i16, @FloatRange(from = 0.0d, to = 1.0d) float f16) {
        return g(i3, ColorUtils.setAlphaComponent(i16, Math.round(Color.alpha(i16) * f16)));
    }

    @ColorInt
    public static int i(@NonNull View view, @AttrRes int i3, @AttrRes int i16, @FloatRange(from = 0.0d, to = 1.0d) float f16) {
        return h(d(view, i3), d(view, i16), f16);
    }
}
