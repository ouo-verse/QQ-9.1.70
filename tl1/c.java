package tl1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u001a\u00bc\u0001\u0010\u0011\u001a\u00020\u000e*\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u00032\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\f\u001a\u00020\u00012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u001a \u0010\u0013\u001a\u00020\u0004*\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0012\u001a\u00020\u0004H\u0002\u001a \u0010\u0014\u001a\u00020\t*\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u00032\u0006\u0010\u0012\u001a\u00020\u0004H\u0002\u00a8\u0006\u0015"}, d2 = {"Landroid/view/View;", "", "animDuration", "Lkotlin/Pair;", "", BasicAnimation.KeyPath.SCALE_X, BasicAnimation.KeyPath.SCALE_Y, "translationX", "translationY", "Landroid/graphics/Rect;", "clipBounds", com.tencent.luggage.wxa.c8.c.f123400v, "alphaStartDelay", "Lkotlin/Function0;", "", "onAnimationStart", "onAnimationEnd", "e", "v", "c", "d", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"tl1/c$a", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "isReverse", "", "onAnimationStart", "onAnimationEnd", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f436518d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f436519e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f436520f;

        a(Function0<Unit> function0, Function0<Unit> function02, View view) {
            this.f436518d = function0;
            this.f436519e = function02;
            this.f436520f = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            Function0<Unit> function0 = this.f436519e;
            if (function0 != null) {
                function0.invoke();
            }
            View view = this.f436520f;
            if (view != null) {
                view.setClipBounds(null);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation, boolean isReverse) {
            Function0<Unit> function0 = this.f436518d;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    private static final float c(Pair<Float, Float> pair, float f16) {
        return pair.getFirst().floatValue() + ((pair.getSecond().floatValue() - pair.getFirst().floatValue()) * f16);
    }

    private static final Rect d(Pair<Rect, Rect> pair, float f16) {
        return new Rect((int) (pair.getFirst().left + ((pair.getSecond().left - pair.getFirst().left) * f16)), (int) (pair.getFirst().top + ((pair.getSecond().top - pair.getFirst().top) * f16)), (int) (pair.getFirst().right + ((pair.getSecond().right - pair.getFirst().right) * f16)), (int) (pair.getFirst().bottom + ((pair.getSecond().bottom - pair.getFirst().bottom) * f16)));
    }

    public static final void e(@Nullable final View view, long j3, @NotNull final Pair<Float, Float> scaleX, @NotNull final Pair<Float, Float> scaleY, @NotNull final Pair<Float, Float> translationX, @NotNull final Pair<Float, Float> translationY, @NotNull final Pair<Rect, Rect> clipBounds, @NotNull final Pair<Float, Float> alpha, long j16, @Nullable Function0<Unit> function0, @Nullable Function0<Unit> function02) {
        List listOf;
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(scaleX, "scaleX");
        Intrinsics.checkNotNullParameter(scaleY, "scaleY");
        Intrinsics.checkNotNullParameter(translationX, "translationX");
        Intrinsics.checkNotNullParameter(translationY, "translationY");
        Intrinsics.checkNotNullParameter(clipBounds, "clipBounds");
        Intrinsics.checkNotNullParameter(alpha, "alpha");
        Log.i("FeedDetailAnimTool", "performAnimation: target\n scaleX = " + scaleX + " scaleY = " + scaleY + "\ntranslationX = " + translationX + " translationY = " + translationY + "\nclipBounds = " + clipBounds + "\nalpha = " + alpha + "\n");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Float[]{scaleX.getFirst(), scaleX.getSecond(), scaleY.getFirst(), scaleY.getSecond()});
        List list = listOf;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                float floatValue = ((Number) it.next()).floatValue();
                if (!Float.isInfinite(floatValue) && !Float.isNaN(floatValue)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    z17 = false;
                    break;
                }
            }
        }
        z17 = true;
        if (!z17) {
            return;
        }
        if (view != null) {
            view.setScaleX(scaleX.getFirst().floatValue());
        }
        if (view != null) {
            view.setScaleY(scaleY.getFirst().floatValue());
        }
        if (view != null) {
            view.setTranslationX(translationX.getFirst().floatValue());
        }
        if (view != null) {
            view.setTranslationY(translationY.getFirst().floatValue());
        }
        if (view != null) {
            view.setClipBounds(clipBounds.getFirst());
        }
        if (view != null) {
            view.setAlpha(alpha.getFirst().floatValue());
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tl1.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                c.g(view, clipBounds, scaleX, scaleY, translationX, translationY, valueAnimator);
            }
        });
        ofFloat.setDuration(j3);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tl1.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                c.h(view, alpha, valueAnimator);
            }
        });
        ofFloat2.setDuration(67L);
        ofFloat2.setStartDelay(j16);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.addListener(new a(function0, function02, view));
        animatorSet.start();
    }

    public static /* synthetic */ void f(View view, long j3, Pair pair, Pair pair2, Pair pair3, Pair pair4, Pair pair5, Pair pair6, long j16, Function0 function0, Function0 function02, int i3, Object obj) {
        long j17;
        long j18;
        Function0 function03;
        Function0 function04;
        if ((i3 & 1) != 0) {
            j17 = 200;
        } else {
            j17 = j3;
        }
        if ((i3 & 128) != 0) {
            j18 = 0;
        } else {
            j18 = j16;
        }
        if ((i3 & 256) != 0) {
            function03 = null;
        } else {
            function03 = function0;
        }
        if ((i3 & 512) != 0) {
            function04 = null;
        } else {
            function04 = function02;
        }
        e(view, j17, pair, pair2, pair3, pair4, pair5, pair6, j18, function03, function04);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(View view, Pair clipBounds, Pair scaleX, Pair scaleY, Pair translationX, Pair translationY, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(clipBounds, "$clipBounds");
        Intrinsics.checkNotNullParameter(scaleX, "$scaleX");
        Intrinsics.checkNotNullParameter(scaleY, "$scaleY");
        Intrinsics.checkNotNullParameter(translationX, "$translationX");
        Intrinsics.checkNotNullParameter(translationY, "$translationY");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        if (view != null) {
            view.setClipBounds(d(clipBounds, floatValue));
        }
        if (view != null) {
            view.setScaleX(c(scaleX, floatValue));
        }
        if (view != null) {
            view.setScaleY(c(scaleY, floatValue));
        }
        if (view != null) {
            view.setTranslationX(c(translationX, floatValue));
        }
        if (view != null) {
            view.setTranslationY(c(translationY, floatValue));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(View view, Pair alpha, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(alpha, "$alpha");
        if (view != null) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            view.setAlpha(c(alpha, ((Float) animatedValue).floatValue()));
        }
    }
}
