package qp1;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.util.Log;
import android.view.animation.DecelerateInterpolator;
import com.heytap.databaseengine.apiv3.data.Element;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qp1.ScrollStateData;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u001aB\u0015\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0019\u00a2\u0006\u0004\b;\u0010<J \u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J \u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0012\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\u000bH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u000fH\u0002J\u001e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u001e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\u000bJ\u0006\u0010\u0017\u001a\u00020\u000bJ\u0006\u0010\u0018\u001a\u00020\u000bR\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\"\u0010%\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010+\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u00101\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00104\u001a\b\u0012\u0004\u0012\u00020\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u00103R\u0018\u00107\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u00106R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u00106R\u0014\u0010:\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b9\u0010.\u00a8\u0006="}, d2 = {"Lqp1/a;", "", "", "dy", "", "touching", "targetCanConsume", "j", "k", "", "from", "", "r", "c", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/animation/ValueAnimator;", "o", DomainData.DOMAIN_NAME, "isTouching", "l", "dyConsumed", "i", h.F, "b", "p", "Lkotlin/Function0;", "a", "Lkotlin/jvm/functions/Function0;", "e", "()Lkotlin/jvm/functions/Function0;", "onScrollChanged", "Lqp1/b;", "Lqp1/b;", "f", "()Lqp1/b;", "setScrollState", "(Lqp1/b;)V", HippyTKDListViewAdapter.SCROLL_STATE, "I", "d", "()I", "setConsumedY", "(I)V", "consumedY", "Z", "g", "()Z", "setShouldMarkStopScroll", "(Z)V", "shouldMarkStopScroll", "", "Ljava/util/Set;", "cancelAnimatorsSet", "Landroid/animation/Animator;", "Landroid/animation/Animator;", "pullRefreshAnimator", "restoreAnimator", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isAnimatorRunning", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<Unit> onScrollChanged;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ScrollStateData scrollState;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int consumedY;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean shouldMarkStopScroll;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Set<Integer> cancelAnimatorsSet;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Animator pullRefreshAnimator;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Animator restoreAnimator;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"androidx/core/animation/AnimatorKt$addListener$listener$1", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animator", "", "onAnimationRepeat", "onAnimationEnd", "onAnimationCancel", "onAnimationStart", "core-ktx_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Ref.BooleanRef f429140d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f429141e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Ref.BooleanRef f429142f;

        public b(Ref.BooleanRef booleanRef, a aVar, Ref.BooleanRef booleanRef2, a aVar2) {
            this.f429140d = booleanRef;
            this.f429141e = aVar;
            this.f429142f = booleanRef2;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            this.f429142f.element = true;
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("Guild.NewHome.ScrollStateCalculator", "CollapseAnimationCancel: " + this.f429141e.cancelAnimatorsSet);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            if (!this.f429140d.element && this.f429141e.getScrollState().q(-this.f429141e.getScrollState().getCollapseHeight(), "CollapseAnimationEnd", 0)) {
                this.f429141e.e().invoke();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001d"}, d2 = {"qp1/a$c", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "Landroid/animation/ValueAnimator;", "animation", "", "onAnimationUpdate", "", "d", "Z", "isStarted", "()Z", "setStarted", "(Z)V", "", "e", "I", "getStartOffset", "()I", "setStartOffset", "(I)V", "startOffset", "", "f", UserInfo.SEX_FEMALE, "getDistance", "()F", "setDistance", "(F)V", Element.ELEMENT_NAME_DISTANCE, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean isStarted;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int startOffset;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private float distance;

        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NotNull ValueAnimator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            Object animatedValue = animation.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            float floatValue = ((Float) animatedValue).floatValue();
            if (!this.isStarted) {
                this.startOffset = a.this.getScrollState().getOffset();
                this.distance = (-a.this.getScrollState().getCollapseHeight()) - this.startOffset;
                this.isStarted = true;
            }
            if (a.this.getScrollState().q((int) (this.startOffset + (this.distance * floatValue)), "CollapseAnimation", 9)) {
                a.this.e().invoke();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"androidx/core/animation/AnimatorKt$addListener$listener$1", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animator", "", "onAnimationRepeat", "onAnimationEnd", "onAnimationCancel", "onAnimationStart", "core-ktx_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Ref.BooleanRef f429147d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f429148e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ValueAnimator f429149f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Ref.BooleanRef f429150h;

        public d(Ref.BooleanRef booleanRef, a aVar, ValueAnimator valueAnimator, Ref.BooleanRef booleanRef2, a aVar2) {
            this.f429147d = booleanRef;
            this.f429148e = aVar;
            this.f429149f = valueAnimator;
            this.f429150h = booleanRef2;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            this.f429150h.element = true;
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("Guild.NewHome.ScrollStateCalculator", "RestoreAnimationCancel: " + this.f429148e.cancelAnimatorsSet);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            if (!this.f429147d.element && !this.f429148e.cancelAnimatorsSet.contains(Integer.valueOf(System.identityHashCode(this.f429149f))) && this.f429148e.getScrollState().q(0, "RestoreAnimationEnd", 2)) {
                this.f429148e.e().invoke();
            }
            this.f429148e.cancelAnimatorsSet.remove(Integer.valueOf(System.identityHashCode(this.f429149f)));
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0015"}, d2 = {"qp1/a$e", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "Landroid/animation/ValueAnimator;", "animation", "", "onAnimationUpdate", "", "d", "Z", "isStarted", "()Z", "setStarted", "(Z)V", "", "e", "I", "a", "()I", "setStartOffset", "(I)V", "startOffset", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class e implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean isStarted;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int startOffset;

        e() {
        }

        /* renamed from: a, reason: from getter */
        public final int getStartOffset() {
            return this.startOffset;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NotNull ValueAnimator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            Object animatedValue = animation.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            float floatValue = ((Float) animatedValue).floatValue();
            if (!this.isStarted) {
                this.startOffset = a.this.getScrollState().getOffset();
                this.isStarted = true;
                Logger logger = Logger.f235387a;
                a aVar = a.this;
                if (QLog.isDevelopLevel()) {
                    Log.d("Guild.NewHome.ScrollStateCalculator", "RestoringAnimationStart: " + aVar.cancelAnimatorsSet + ", startOffset=" + getStartOffset());
                }
            }
            if (a.this.getScrollState().q((int) (floatValue * this.startOffset), "RestoreAnimation", 5)) {
                a.this.e().invoke();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"androidx/core/animation/AnimatorKt$addListener$listener$1", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animator", "", "onAnimationRepeat", "onAnimationEnd", "onAnimationCancel", "onAnimationStart", "core-ktx_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class f implements Animator.AnimatorListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ValueAnimator f429155e;

        public f(ValueAnimator valueAnimator) {
            this.f429155e = valueAnimator;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            if (a.this.getScrollState().q(a.this.getScrollState().getOffset(), "RefreshingAnimationEnd", 7)) {
                a.this.e().invoke();
            }
            a.this.cancelAnimatorsSet.remove(Integer.valueOf(System.identityHashCode(this.f429155e)));
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("Guild.NewHome.ScrollStateCalculator", "RefreshingAnimationEnd: " + a.this.cancelAnimatorsSet);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"qp1/a$g", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "Landroid/animation/ValueAnimator;", "animation", "", "onAnimationUpdate", "", "d", "Z", "isStarted", "()Z", "setStarted", "(Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class g implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean isStarted;

        g() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NotNull ValueAnimator animation) {
            int i3;
            Intrinsics.checkNotNullParameter(animation, "animation");
            Object animatedValue = animation.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            float floatValue = ((Float) animatedValue).floatValue();
            boolean z16 = this.isStarted;
            if (z16) {
                i3 = 8;
            } else if (!z16) {
                i3 = 6;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            this.isStarted = true;
            if (a.this.getScrollState().q((int) floatValue, "RefreshingAnimation", i3)) {
                a.this.e().invoke();
            }
        }
    }

    public a(@NotNull Function0<Unit> onScrollChanged) {
        Intrinsics.checkNotNullParameter(onScrollChanged, "onScrollChanged");
        this.onScrollChanged = onScrollChanged;
        this.scrollState = new ScrollStateData(0, 0, 0, false, 0, 0, 63, null);
        this.cancelAnimatorsSet = new LinkedHashSet();
    }

    private final void c(String from) {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.ScrollStateCalculator", "updateRefreshStateIfNeeded: " + from + ", " + getScrollState());
        }
        if (this.scrollState.getState() == 1 && this.scrollState.getCollapseHeight() != 0 && this.scrollState.getOffset() < (-this.scrollState.getCollapseHeight()) / 2) {
            ValueAnimator n3 = n();
            n3.start();
            this.restoreAnimator = n3;
        }
    }

    private final boolean j(int dy5, boolean touching, boolean targetCanConsume) {
        boolean z16;
        int max;
        boolean z17 = false;
        if (targetCanConsume) {
            this.consumedY = 0;
            return false;
        }
        int offset = this.scrollState.getOffset() - dy5;
        boolean o16 = this.scrollState.o(touching);
        int i3 = 3;
        boolean z18 = true;
        if (offset <= this.scrollState.getPullRefreshHeight()) {
            int offset2 = this.scrollState.getOffset();
            int state = this.scrollState.getState();
            if (this.scrollState.getIsTouching()) {
                this.shouldMarkStopScroll = false;
                max = Math.min(offset, this.scrollState.getPullRefreshHeight());
            } else {
                if (offset > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                this.shouldMarkStopScroll = z16;
                i3 = state;
                max = Math.max(this.scrollState.getOffset(), 0);
            }
            if (!this.scrollState.q(max, "handlePrePullDown", i3) && !o16) {
                z18 = false;
            }
            this.consumedY = Math.min(offset2 - this.scrollState.getOffset(), 0);
            return z18;
        }
        if (touching) {
            ScrollStateData.Companion companion = ScrollStateData.INSTANCE;
            int offset3 = this.scrollState.getOffset() + ((int) (((-dy5) * companion.a()) / (companion.a() + Math.abs(this.scrollState.getOffset() - this.scrollState.getPullRefreshHeight()))));
            if (offset3 >= this.scrollState.getPullRefreshHeight()) {
                i3 = 4;
            }
            if (this.scrollState.q(offset3, "handlePrePullDown", i3) || o16) {
                z17 = true;
            }
            o16 = z17;
        }
        this.consumedY = dy5;
        boolean z19 = !touching;
        this.shouldMarkStopScroll = z19;
        if (z19) {
            r("handlePrePullDown, stopScroll");
        }
        return o16;
    }

    private final boolean k(int dy5, boolean touching, boolean targetCanConsume) {
        boolean z16;
        int offset = this.scrollState.getOffset() - dy5;
        boolean o16 = this.scrollState.o(touching);
        boolean z17 = true;
        if (offset <= (-this.scrollState.getCollapseHeight())) {
            this.consumedY = (-this.scrollState.getCollapseHeight()) - this.scrollState.getOffset();
            if (!ScrollStateData.r(this.scrollState, -this.scrollState.getCollapseHeight(), "handlePrePullUp", 0, 4, null) && !o16) {
                z17 = false;
            }
            this.shouldMarkStopScroll = false;
            return z17;
        }
        if (!ScrollStateData.r(this.scrollState, offset, "handlePrePullUp", 0, 4, null) && !o16) {
            z16 = false;
        } else {
            z16 = true;
        }
        this.consumedY = dy5;
        if (touching || (targetCanConsume && !m())) {
            z17 = false;
        }
        this.shouldMarkStopScroll = z17;
        return z16;
    }

    private final boolean m() {
        boolean z16;
        boolean z17;
        Animator animator = this.pullRefreshAnimator;
        if (animator != null && animator.isRunning()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        Animator animator2 = this.restoreAnimator;
        if (animator2 != null && animator2.isRunning()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            return true;
        }
        return false;
    }

    private final ValueAnimator n() {
        ValueAnimator animator = ValueAnimator.ofFloat(0.0f, 1.0f);
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        animator.setDuration(150L);
        animator.setInterpolator(new DecelerateInterpolator(3.0f));
        animator.addUpdateListener(new c());
        Intrinsics.checkNotNullExpressionValue(animator, "animator");
        animator.addListener(new b(booleanRef, this, booleanRef, this));
        return animator;
    }

    private final ValueAnimator o() {
        ValueAnimator animator = ValueAnimator.ofFloat(1.0f, 0.0f);
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        animator.setInterpolator(new DecelerateInterpolator(3.0f));
        animator.addUpdateListener(new e());
        Intrinsics.checkNotNullExpressionValue(animator, "animator");
        animator.addListener(new d(booleanRef, this, animator, booleanRef, this));
        return animator;
    }

    private final void q() {
        ValueAnimator o16 = o();
        o16.setStartDelay(1000L);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.scrollState.getOffset(), this.scrollState.getPullRefreshHeight());
        ofFloat.setInterpolator(new DecelerateInterpolator(3.0f));
        ofFloat.addUpdateListener(new g());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new f(ofFloat));
        animatorSet.playSequentially(ofFloat, o16);
        animatorSet.start();
        this.pullRefreshAnimator = animatorSet;
    }

    private final void r(String from) {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.ScrollStateCalculator", "updateRefreshStateIfNeeded: " + from + ", " + getScrollState());
        }
        if (this.scrollState.getState() != 4 && this.scrollState.getState() != 3 && this.scrollState.getState() != 7) {
            return;
        }
        if (this.scrollState.getOffset() > this.scrollState.getPullRefreshHeight()) {
            q();
        } else if (this.scrollState.getOffset() > 0) {
            ValueAnimator o16 = o();
            o16.start();
            this.restoreAnimator = o16;
        }
    }

    public final void b() {
        Animator animator = this.pullRefreshAnimator;
        if (animator != null) {
            animator.cancel();
        }
    }

    /* renamed from: d, reason: from getter */
    public final int getConsumedY() {
        return this.consumedY;
    }

    @NotNull
    public final Function0<Unit> e() {
        return this.onScrollChanged;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final ScrollStateData getScrollState() {
        return this.scrollState;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getShouldMarkStopScroll() {
        return this.shouldMarkStopScroll;
    }

    public final void h() {
        r("ActionUp");
        c("ActionUp");
    }

    public final boolean i(int dy5, int dyConsumed, boolean touching) {
        return true;
    }

    public final boolean l(int dy5, boolean isTouching, boolean targetCanConsume) {
        if (dy5 < 0) {
            this.scrollState.p(1);
            return j(dy5, isTouching, targetCanConsume);
        }
        if (dy5 > 0) {
            this.scrollState.p(-1);
            return k(dy5, isTouching, targetCanConsume);
        }
        return false;
    }

    public final void p() {
        AnimatorSet animatorSet;
        Animator animator = this.pullRefreshAnimator;
        if (animator instanceof AnimatorSet) {
            animatorSet = (AnimatorSet) animator;
        } else {
            animatorSet = null;
        }
        if (animatorSet == null) {
            return;
        }
        boolean isRunning = animatorSet.isRunning();
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.ScrollStateCalculator", "playRestoreAnimatorIfNeeded: " + isRunning);
        }
        if (isRunning) {
            ArrayList<Animator> childAnimations = animatorSet.getChildAnimations();
            Intrinsics.checkNotNullExpressionValue(childAnimations, "animators.childAnimations");
            for (Animator animator2 : childAnimations) {
                if (animator2.isRunning()) {
                    this.cancelAnimatorsSet.add(Integer.valueOf(System.identityHashCode(animator2)));
                }
            }
            Animator animator3 = this.pullRefreshAnimator;
            if (animator3 != null) {
                animator3.cancel();
            }
            ValueAnimator o16 = o();
            o16.setStartDelay(150L);
            o16.start();
            this.restoreAnimator = o16;
        }
    }
}
