package yn4;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.core.view.animation.PathInterpolatorCompat;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b {

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f450676d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f450677e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ float f450678f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ View f450679h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ d f450680i;

        a(boolean z16, float f16, float f17, View view, d dVar) {
            this.f450676d = z16;
            this.f450677e = f16;
            this.f450678f = f17;
            this.f450679h = view;
            this.f450680i = dVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (this.f450676d) {
                floatValue = new OvershootInterpolator().getInterpolation(floatValue);
            }
            float f16 = this.f450677e;
            float f17 = f16 + ((this.f450678f - f16) * floatValue);
            this.f450679h.setScaleX(f17);
            this.f450679h.setScaleY(f17);
            d dVar = this.f450680i;
            if (dVar != null) {
                dVar.a(this.f450679h, floatValue);
                if (floatValue >= 1.0f) {
                    this.f450680i.b(this.f450679h);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: yn4.b$b, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public class C11623b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f450681d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f450682e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f450683f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ float f450684h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ float f450685i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ d f450686m;

        C11623b(float f16, float f17, View view, float f18, float f19, d dVar) {
            this.f450681d = f16;
            this.f450682e = f17;
            this.f450683f = view;
            this.f450684h = f18;
            this.f450685i = f19;
            this.f450686m = dVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            float f16 = this.f450681d;
            this.f450683f.setAlpha(f16 + ((this.f450682e - f16) * floatValue));
            float f17 = this.f450684h;
            float f18 = f17 + ((this.f450685i - f17) * floatValue);
            this.f450683f.setScaleX(f18);
            this.f450683f.setScaleY(f18);
            d dVar = this.f450686m;
            if (dVar != null) {
                dVar.a(this.f450683f, floatValue);
                if (floatValue >= 1.0f) {
                    this.f450686m.b(this.f450683f);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f450687d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f450688e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f450689f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ d f450690h;

        c(float f16, float f17, View view, d dVar) {
            this.f450687d = f16;
            this.f450688e = f17;
            this.f450689f = view;
            this.f450690h = dVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            float f16 = this.f450687d;
            this.f450689f.setAlpha(f16 + ((this.f450688e - f16) * floatValue));
            d dVar = this.f450690h;
            if (dVar != null) {
                dVar.a(this.f450689f, floatValue);
                if (floatValue >= 1.0f) {
                    this.f450690h.b(this.f450689f);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface d {
        void a(View view, float f16);

        void b(View view);

        void onAnimationStart(View view);
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public static Interpolator f450691a = PathInterpolatorCompat.create(0.0f, 0.0f, 0.2f, 1.0f);

        /* renamed from: b, reason: collision with root package name */
        public static Interpolator f450692b = PathInterpolatorCompat.create(0.4f, 0.0f, 1.0f, 1.0f);
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public static Interpolator f450693a = PathInterpolatorCompat.create(0.1f, 0.8f, 0.2f, 1.0f);

        /* renamed from: b, reason: collision with root package name */
        public static Interpolator f450694b = PathInterpolatorCompat.create(0.1f, 0.8f, 0.2f, 1.0f);
    }

    public static void a(View view, float f16, float f17, long j3, Interpolator interpolator, d dVar) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(j3);
        if (interpolator == null) {
            interpolator = new DecelerateInterpolator();
        }
        ofFloat.setInterpolator(interpolator);
        ofFloat.addUpdateListener(new c(f16, f17, view, dVar));
        ofFloat.start();
        if (dVar != null) {
            dVar.onAnimationStart(view);
        }
    }

    public static void b(View view, d dVar) {
        g(view, 1.0f, 0.5f, 1.0f, 0.0f, 225L, e.f450692b, dVar);
    }

    public static void c(View view) {
        a(view, 0.7f, 0.0f, 225L, e.f450692b, null);
    }

    public static void d(View view) {
        g(view, 0.5f, 1.0f, 0.0f, 1.0f, 225L, e.f450691a, null);
    }

    public static void e(View view) {
        a(view, 0.0f, 0.7f, 225L, e.f450691a, null);
    }

    public static void f(View view, float f16, float f17, long j3, d dVar, boolean z16) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(j3);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addUpdateListener(new a(z16, f16, f17, view, dVar));
        ofFloat.start();
        if (dVar != null) {
            dVar.onAnimationStart(view);
        }
    }

    public static void g(View view, float f16, float f17, float f18, float f19, long j3, Interpolator interpolator, d dVar) {
        Interpolator decelerateInterpolator;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(j3);
        if (interpolator != null) {
            decelerateInterpolator = interpolator;
        } else {
            decelerateInterpolator = new DecelerateInterpolator();
        }
        ofFloat.setInterpolator(decelerateInterpolator);
        ofFloat.addUpdateListener(new C11623b(f18, f19, view, f16, f17, dVar));
        ofFloat.start();
        if (dVar != null) {
            dVar.onAnimationStart(view);
        }
    }
}
