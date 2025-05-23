package z43;

import android.view.animation.Interpolator;

/* compiled from: P */
/* loaded from: classes20.dex */
abstract class c implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    private final float[] f451888a;

    /* renamed from: b, reason: collision with root package name */
    private final float f451889b;

    public c(float[] fArr) {
        this.f451888a = fArr;
        this.f451889b = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f16) {
        if (f16 >= 1.0f) {
            return 1.0f;
        }
        if (f16 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f451888a;
        int min = Math.min((int) ((fArr.length - 1) * f16), fArr.length - 2);
        float f17 = this.f451889b;
        float f18 = (f16 - (min * f17)) / f17;
        float[] fArr2 = this.f451888a;
        float f19 = fArr2[min];
        return f19 + (f18 * (fArr2[min + 1] - f19));
    }
}
