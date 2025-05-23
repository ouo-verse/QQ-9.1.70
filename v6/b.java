package v6;

import android.view.animation.Interpolator;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b implements Interpolator {
    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f16) {
        double d16 = f16;
        return (float) (((-1.33333d) * d16 * d16) + (d16 * 2.33333d));
    }
}
