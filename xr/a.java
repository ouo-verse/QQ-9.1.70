package xr;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.mobileqq.widget.f;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: xr.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public class C11560a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f448418d;

        C11560a(c cVar) {
            this.f448418d = cVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            c cVar = this.f448418d;
            if (cVar != null) {
                cVar.onAnimationUpdate(valueAnimator);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    public interface c {
        void a(ValueAnimator valueAnimator);

        void b(ValueAnimator valueAnimator);

        void c(ValueAnimator valueAnimator);

        void onAnimationUpdate(ValueAnimator valueAnimator);
    }

    private static ValueAnimator b(ValueAnimator valueAnimator, c cVar, long j3) {
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.addUpdateListener(new C11560a(cVar));
        valueAnimator.addListener(new b(cVar, valueAnimator));
        valueAnimator.setDuration(j3);
        return valueAnimator;
    }

    public static ValueAnimator a(long j3, float f16, float f17, c cVar) {
        return b(ValueAnimator.ofFloat(f16, f17), cVar, j3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public class b extends f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f448419d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ValueAnimator f448420e;

        b(c cVar, ValueAnimator valueAnimator) {
            this.f448419d = cVar;
            this.f448420e = valueAnimator;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            c cVar = this.f448419d;
            if (cVar != null) {
                cVar.c(this.f448420e);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            c cVar = this.f448419d;
            if (cVar != null) {
                cVar.a(this.f448420e);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c cVar = this.f448419d;
            if (cVar != null) {
                cVar.b(this.f448420e);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    public static class d implements c {
        @Override // xr.a.c
        public void a(ValueAnimator valueAnimator) {
        }

        @Override // xr.a.c
        public void b(ValueAnimator valueAnimator) {
        }

        @Override // xr.a.c
        public void c(ValueAnimator valueAnimator) {
        }
    }
}
