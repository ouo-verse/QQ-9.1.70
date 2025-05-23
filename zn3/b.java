package zn3;

import android.animation.ValueAnimator;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes22.dex */
class b implements ValueAnimator.AnimatorUpdateListener {
    private long C;
    private long D;
    private long E;
    private c F;

    /* renamed from: d, reason: collision with root package name */
    private float f452808d;

    /* renamed from: e, reason: collision with root package name */
    private float f452809e;

    /* renamed from: f, reason: collision with root package name */
    private float f452810f;

    /* renamed from: h, reason: collision with root package name */
    private long f452811h;

    /* renamed from: i, reason: collision with root package name */
    private long f452812i;

    /* renamed from: m, reason: collision with root package name */
    private long f452813m;

    public b(@NonNull c cVar) {
        this.F = cVar;
    }

    public void a(long j3, long j16) {
        long j17 = this.f452811h;
        this.f452812i = j17;
        long j18 = this.C;
        this.D = j18;
        this.f452813m = j3 - j17;
        this.E = j16 - j18;
    }

    public void b(float f16, float f17) {
        this.f452809e = f16;
        this.f452810f = f17 - f16;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float animatedFraction = this.f452809e + (this.f452810f * valueAnimator.getAnimatedFraction());
        this.f452808d = animatedFraction;
        this.F.a(animatedFraction);
        this.f452811h = this.f452812i + ((int) (((float) this.f452813m) * valueAnimator.getAnimatedFraction()));
        long animatedFraction2 = this.D + ((int) (((float) this.E) * valueAnimator.getAnimatedFraction()));
        this.C = animatedFraction2;
        this.F.b(this.f452811h, animatedFraction2);
    }
}
