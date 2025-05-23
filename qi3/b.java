package qi3;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.util.Property;
import android.view.View;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.luggage.wxa.c8.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002J\u0016\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fJ \u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0015"}, d2 = {"Lqi3/b;", "", "Landroid/view/View;", "view", "", "duration", "Landroid/animation/AnimatorSet;", "i", "Landroid/animation/ObjectAnimator;", "b", "imageView", h.F, "Landroid/animation/Animator$AnimatorListener;", "listener", "d", "", "targetScale", "", "e", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f428962a = new b();

    b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(View view, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(view, "$view");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        view.setScaleX(floatValue);
        view.setScaleY(floatValue);
    }

    public final ObjectAnimator b(View view, long duration) {
        Intrinsics.checkNotNullParameter(view, "view");
        ObjectAnimator fadeInAnimator = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 0.0f, 1.0f);
        fadeInAnimator.setDuration(duration);
        fadeInAnimator.start();
        Intrinsics.checkNotNullExpressionValue(fadeInAnimator, "fadeInAnimator");
        return fadeInAnimator;
    }

    public final AnimatorSet d(View imageView, Animator.AnimatorListener listener) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Intrinsics.checkNotNullParameter(listener, "listener");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, BasicAnimation.KeyPath.SCALE_X, 0.9f);
        ofFloat.setDuration(150L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, BasicAnimation.KeyPath.SCALE_Y, 0.9f);
        ofFloat2.setDuration(150L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, BasicAnimation.KeyPath.SCALE_X, 1.0f);
        ofFloat3.setDuration(50L);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView, BasicAnimation.KeyPath.SCALE_Y, 1.0f);
        ofFloat4.setDuration(50L);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(imageView, c.f123400v, 0.0f);
        ofFloat5.setDuration(50L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.play(ofFloat3).with(ofFloat4).after(ofFloat);
        animatorSet.play(ofFloat5).after(ofFloat3);
        animatorSet.addListener(listener);
        return animatorSet;
    }

    public final void e(final View view, float targetScale, long duration) {
        Intrinsics.checkNotNullParameter(view, "view");
        ValueAnimator ofFloat = ValueAnimator.ofFloat(view.getScaleX(), targetScale);
        ofFloat.setDuration(duration);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: qi3.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.g(view, valueAnimator);
            }
        });
        ofFloat.start();
    }

    public final ObjectAnimator h(View imageView) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "translationY", 0.0f, 10.0f);
        ofFloat.setDuration(500L);
        ofFloat.setRepeatMode(2);
        ofFloat.setRepeatCount(-1);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(imageView, \"tran\u2026imator.INFINITE\n        }");
        return ofFloat;
    }

    public final AnimatorSet i(View view, long duration) {
        Intrinsics.checkNotNullParameter(view, "view");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", 500.0f, 0.0f);
        ofFloat.setDuration(duration);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, c.f123400v, 0.0f, 1.0f);
        ofFloat2.setDuration(duration);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.start();
        return animatorSet;
    }

    public static /* synthetic */ ObjectAnimator c(b bVar, View view, long j3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j3 = 500;
        }
        return bVar.b(view, j3);
    }

    public static /* synthetic */ void f(b bVar, View view, float f16, long j3, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            j3 = 200;
        }
        bVar.e(view, f16, j3);
    }
}
