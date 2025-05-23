package xr;

import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;

/* compiled from: P */
/* loaded from: classes36.dex */
public class c extends ValueAnimator {

    /* renamed from: d, reason: collision with root package name */
    private boolean f448425d = false;

    /* renamed from: e, reason: collision with root package name */
    private d f448426e;

    public c() {
        setInterpolator(new AccelerateDecelerateInterpolator());
    }

    public boolean a() {
        return this.f448425d;
    }

    @Override // android.animation.ValueAnimator
    public void setObjectValues(Object... objArr) {
        super.setObjectValues(objArr);
        if (this.f448426e == null) {
            this.f448426e = new d();
        }
        setEvaluator(this.f448426e);
    }

    public void b(b bVar, b bVar2) {
        setObjectValues(bVar, bVar2);
        this.f448425d = b.a(bVar, bVar2);
    }
}
