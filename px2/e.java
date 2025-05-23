package px2;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.mobileqq.R;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes19.dex */
public class e {
    protected static ValueAnimator c(final View view, final View view2, final View view3, boolean z16, a aVar) {
        float f16;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        float f17 = 1.0f;
        if (z16) {
            f16 = 1.0f;
        } else {
            f16 = 0.0f;
        }
        if (z16) {
            f17 = 0.0f;
        }
        QLog.d("PlayerLandscapeUIAnimUtils", 1, "startAnim  isReverse = " + z16);
        AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
        ValueAnimator duration = ValueAnimator.ofFloat(f16, f17).setDuration(250L);
        duration.addListener(aVar);
        duration.setInterpolator(accelerateDecelerateInterpolator);
        int i3 = (int) f17;
        final boolean e16 = e(view, i3);
        if (e16) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        } else {
            marginLayoutParams = null;
        }
        final ViewGroup.MarginLayoutParams marginLayoutParams2 = marginLayoutParams;
        final int h16 = h();
        final int g16 = g(R.dimen.dhb);
        final int g17 = g(R.dimen.dh5);
        final boolean f18 = f(view2, g16, i3);
        final boolean d16 = d(view3, g17, i3);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: px2.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                e.j(f18, view2, g16, d16, view3, g17, e16, marginLayoutParams2, h16, view, valueAnimator);
            }
        });
        return duration;
    }

    private static boolean d(View view, int i3, int i16) {
        if (view == null || ((int) view.getTranslationY()) == i3 * i16) {
            return false;
        }
        return true;
    }

    private static boolean e(View view, int i3) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (view == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams()) == null) {
            return false;
        }
        if (marginLayoutParams.leftMargin == (-i3) * h()) {
            return false;
        }
        return true;
    }

    private static boolean f(View view, int i3, int i16) {
        if (view == null || ((int) view.getTranslationY()) == (-i3) * i16) {
            return false;
        }
        return true;
    }

    public static int g(int i3) {
        try {
            return QCircleApplication.APP.getResources().getDimensionPixelSize(i3);
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    public static int h() {
        return g(R.dimen.f159609dh0) + i();
    }

    public static int i() {
        int identifier = QCircleApplication.APP.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return g(identifier);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(boolean z16, View view, int i3, boolean z17, View view2, int i16, boolean z18, ViewGroup.MarginLayoutParams marginLayoutParams, int i17, View view3, ValueAnimator valueAnimator) {
        if (z16) {
            view.setTranslationY((-((Float) valueAnimator.getAnimatedValue()).floatValue()) * i3);
        }
        if (z17) {
            view2.setTranslationY(((Float) valueAnimator.getAnimatedValue()).floatValue() * i16);
        }
        if (z18 && marginLayoutParams != null) {
            marginLayoutParams.leftMargin = -((int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * i17));
            view3.setLayoutParams(marginLayoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k(View view, ValueAnimator valueAnimator) {
        if (!(valueAnimator.getAnimatedValue() instanceof Integer)) {
            return;
        }
        view.setTranslationX(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }

    public static void l(View view, View view2, View view3, a aVar) {
        c(view, view2, view3, true, aVar).start();
    }

    public static void m(View view, View view2, View view3, a aVar) {
        c(view, view2, view3, false, aVar).start();
    }

    public static void n(final View view, a aVar) {
        int h16 = h();
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        ValueAnimator duration = ValueAnimator.ofInt(0, h16).setDuration(250L);
        duration.setInterpolator(linearInterpolator);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: px2.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                e.k(view, valueAnimator);
            }
        });
        duration.addListener(aVar);
        duration.start();
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class a implements Animator.AnimatorListener {
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}
