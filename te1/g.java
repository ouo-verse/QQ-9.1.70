package te1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import te1.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u0016\u0010\n\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\t\u00a8\u0006\r"}, d2 = {"Lte1/g;", "", "Landroid/view/View;", "view", "Lcom/tencent/qqnt/aio/anisticker/drawable/g;", "animationCallback", "", "b", "", "I", "startHeight", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f435886a = new g();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int startHeight;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"te1/g$a", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "onAnimationCancel", "onAnimationStart", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f435888d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f435889e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.tencent.qqnt.aio.anisticker.drawable.g f435890f;

        a(View view, int i3, com.tencent.qqnt.aio.anisticker.drawable.g gVar) {
            this.f435888d = view;
            this.f435889e = i3;
            this.f435890f = gVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(View view) {
            Intrinsics.checkNotNullParameter(view, "$view");
            view.getLayoutParams().height = 0;
            view.setVisibility(0);
            view.requestLayout();
            view.setLayerType(2, null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            this.f435888d.setTag(R.id.uy6, Boolean.FALSE);
            com.tencent.qqnt.aio.anisticker.drawable.g gVar = this.f435890f;
            if (gVar != null) {
                gVar.onStop(false);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            this.f435888d.setTag(R.id.uy6, Boolean.FALSE);
            if (this.f435889e == 0) {
                this.f435888d.setVisibility(8);
            } else {
                this.f435888d.getLayoutParams().height = -2;
                this.f435888d.requestLayout();
            }
            com.tencent.qqnt.aio.anisticker.drawable.g gVar = this.f435890f;
            if (gVar != null) {
                gVar.onStop(true);
            }
            this.f435888d.setLayerType(0, null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            Logger logger = Logger.f235387a;
            int i3 = this.f435889e;
            logger.d().d("ExpandAnimationHelper", 1, "onAnimationStart targetHeight " + i3 + " ");
            if (this.f435889e != 0) {
                this.f435888d.getLayoutParams().height = 0;
                this.f435888d.setVisibility(4);
                this.f435888d.requestLayout();
                final View view = this.f435888d;
                view.post(new Runnable() { // from class: te1.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.a.b(view);
                    }
                });
            }
            com.tencent.qqnt.aio.anisticker.drawable.g gVar = this.f435890f;
            if (gVar != null) {
                gVar.onStart();
            }
        }
    }

    g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(View view, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(view, "$view");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        view.getLayoutParams().height = ((Integer) animatedValue).intValue();
        view.requestLayout();
    }

    public final void b(@NotNull final View view, @Nullable com.tencent.qqnt.aio.anisticker.drawable.g animationCallback) {
        View view2;
        int i3;
        int measuredHeight;
        int height;
        Intrinsics.checkNotNullParameter(view, "view");
        Object tag = view.getTag(R.id.uy6);
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.areEqual(tag, bool)) {
            return;
        }
        Object parent = view.getParent();
        if (parent instanceof View) {
            view2 = (View) parent;
        } else {
            view2 = null;
        }
        if (view2 != null) {
            i3 = view2.getWidth();
        } else {
            i3 = UIUtil.f112434a.x().getDisplayMetrics().widthPixels;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        if (view.getVisibility() == 0) {
            measuredHeight = 0;
        } else {
            measuredHeight = view.getMeasuredHeight();
        }
        if (view.getHeight() == measuredHeight && view.getVisibility() == 0) {
            return;
        }
        view.setTag(R.id.uy6, bool);
        if (measuredHeight != 0) {
            height = 0;
        } else {
            height = view.getHeight();
        }
        startHeight = height;
        ValueAnimator ofInt = ValueAnimator.ofInt(height, measuredHeight);
        ofInt.setDuration(300L);
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: te1.e
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                g.c(view, valueAnimator);
            }
        });
        ofInt.addListener(new a(view, measuredHeight, animationCallback));
        ofInt.start();
    }
}
