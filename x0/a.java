package x0;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.RestrictTo;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final TimeInterpolator f446810a = new LinearInterpolator();

    /* renamed from: b, reason: collision with root package name */
    public static final TimeInterpolator f446811b = new FastOutSlowInInterpolator();

    /* renamed from: c, reason: collision with root package name */
    public static final TimeInterpolator f446812c = new FastOutLinearInInterpolator();

    /* renamed from: d, reason: collision with root package name */
    public static final TimeInterpolator f446813d = new LinearOutSlowInInterpolator();

    /* renamed from: e, reason: collision with root package name */
    public static final TimeInterpolator f446814e = new DecelerateInterpolator();

    public static float a(float f16, float f17, float f18) {
        return f16 + (f18 * (f17 - f16));
    }

    public static float b(float f16, float f17, @FloatRange(from = 0.0d, to = 1.0d) float f18, @FloatRange(from = 0.0d, to = 1.0d) float f19, @FloatRange(from = 0.0d, to = 1.0d) float f26) {
        if (f26 < f18) {
            return f16;
        }
        if (f26 > f19) {
            return f17;
        }
        return a(f16, f17, (f26 - f18) / (f19 - f18));
    }

    public static int c(int i3, int i16, float f16) {
        return i3 + Math.round(f16 * (i16 - i3));
    }
}
