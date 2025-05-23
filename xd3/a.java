package xd3;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.luggage.wxa.c8.c;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J;\u0010\f\u001a\u00020\u000b2\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\f\u0010\rJC\u0010\u0011\u001a\u00020\u000b2\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u000e\u00a8\u0006\u0018"}, d2 = {"Lxd3/a;", "", "", "Landroid/view/View;", "views", "", "duration", "", "show", "Landroid/animation/AnimatorListenerAdapter;", "listener", "", "a", "([Landroid/view/View;JZLandroid/animation/AnimatorListenerAdapter;)V", "", "startAlpha", "endAlpha", "b", "([Landroid/view/View;JFFLandroid/animation/AnimatorListenerAdapter;)V", "button", "scale", "c", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f447833a = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"xd3/a$a", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: xd3.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static final class C11541a extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f447834d;

        C11541a(View view) {
            this.f447834d = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            this.f447834d.setScaleX(1.0f);
            this.f447834d.setScaleY(1.0f);
        }
    }

    a() {
    }

    public final void b(View[] views, long duration, float startAlpha, float endAlpha, AnimatorListenerAdapter listener) {
        Intrinsics.checkNotNullParameter(views, "views");
        ArrayList arrayList = new ArrayList();
        for (View view : views) {
            view.setAlpha(startAlpha);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, c.f123400v, startAlpha, endAlpha);
            ofFloat.setDuration(duration);
            arrayList.add(ofFloat);
        }
        if (listener != null) {
            ((ObjectAnimator) arrayList.get(0)).addListener(listener);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    public final void c(View button, float scale) {
        Intrinsics.checkNotNullParameter(button, "button");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(button, BasicAnimation.KeyPath.SCALE_X, scale);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(button, BasicAnimation.KeyPath.SCALE_Y, scale);
        ofFloat.setDuration(200L);
        ofFloat2.setDuration(200L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat2.setInterpolator(new DecelerateInterpolator());
        if (scale == 1.0f) {
            ofFloat.addListener(new C11541a(button));
        }
        ofFloat.start();
        ofFloat2.start();
    }

    public final void a(View[] views, long duration, boolean show, AnimatorListenerAdapter listener) {
        Intrinsics.checkNotNullParameter(views, "views");
        ArrayList arrayList = new ArrayList();
        float f16 = show ? 0.0f : 1.0f;
        float f17 = show ? 1.0f : 0.0f;
        for (View view : views) {
            if (show) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(1.0f);
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, c.f123400v, f16, f17);
            ofFloat.setDuration(duration);
            arrayList.add(ofFloat);
        }
        if (listener != null) {
            ((ObjectAnimator) arrayList.get(0)).addListener(listener);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }
}
