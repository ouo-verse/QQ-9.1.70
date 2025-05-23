package tb4;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.util.SparseArray;
import android.view.animation.LinearInterpolator;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 *2\u00020\u0001:\u0001+B\u0015\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u0004J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0006\u0010\u0010\u001a\u00020\u0004R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0018R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010\"\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR$\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\t0#j\b\u0012\u0004\u0012\u00020\t`$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006,"}, d2 = {"Ltb4/b;", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "Ltb4/c;", "progress", "", "j", "g", "e", h.F, "Ltb4/e;", "l", "c", "f", "Landroid/animation/ValueAnimator;", "animation", "onAnimationUpdate", "d", "", "Ltb4/d;", "Ljava/util/List;", "mTotalStateConfig", "Ltb4/c;", "mCurrentProgress", "", "I", "mFakeProgress", "Landroid/util/SparseArray;", "", "Landroid/util/SparseArray;", "mStageStartTime", "i", "Landroid/animation/ValueAnimator;", "mKeepUpAnim", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mWaitAnim", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/HashSet;", "mListenerPool", "<init>", "(Ljava/util/List;)V", "D", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: C, reason: from kotlin metadata */
    private final HashSet<e> mListenerPool;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final List<StageProgressConfig> mTotalStateConfig;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private StageProgress mCurrentProgress;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mFakeProgress;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final SparseArray<Long> mStageStartTime;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ValueAnimator mKeepUpAnim;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ValueAnimator mWaitAnim;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"tb4/b$b", "Loc4/a;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: tb4.b$b, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static final class C11282b extends oc4.a {
        C11282b() {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            QLog.i("MultiStageProgressGenerator_", 1, "onAnimationEnd keepUpAnim end, mWaitAnim=" + b.this.mWaitAnim);
            ValueAnimator valueAnimator = b.this.mWaitAnim;
            if (valueAnimator != null) {
                valueAnimator.start();
            }
        }
    }

    public b(List<StageProgressConfig> mTotalStateConfig) {
        Intrinsics.checkNotNullParameter(mTotalStateConfig, "mTotalStateConfig");
        this.mTotalStateConfig = mTotalStateConfig;
        this.mCurrentProgress = new StageProgress(0, 0);
        this.mStageStartTime = new SparseArray<>();
        this.mListenerPool = new HashSet<>();
    }

    private final void e() {
        Iterator<T> it = this.mListenerPool.iterator();
        while (it.hasNext()) {
            ((e) it.next()).e8(this.mFakeProgress, this.mCurrentProgress, this.mTotalStateConfig);
        }
        QLog.d("MultiStageProgressGenerator_", 4, "onAnimationUpdate mFakeProgress:" + this.mFakeProgress);
    }

    private final void g() {
        Object obj;
        long coerceAtMost;
        long coerceAtLeast;
        int stage = this.mCurrentProgress.getStage();
        Iterator<T> it = this.mTotalStateConfig.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (((StageProgressConfig) obj).getStage() == stage) {
                    break;
                }
            }
        }
        StageProgressConfig stageProgressConfig = (StageProgressConfig) obj;
        if (stageProgressConfig == null) {
            return;
        }
        int c16 = this.mCurrentProgress.c(stageProgressConfig);
        int i3 = this.mFakeProgress;
        int finalProgress = stageProgressConfig.getFinalProgress();
        Long stageStartTime = this.mStageStartTime.get(this.mCurrentProgress.getStage());
        long currentTimeMillis = System.currentTimeMillis();
        Intrinsics.checkNotNullExpressionValue(stageStartTime, "stageStartTime");
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(currentTimeMillis - stageStartTime.longValue(), stageProgressConfig.getPredictDuration());
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(coerceAtMost, 0L);
        QLog.i("MultiStageProgressGenerator_", 1, "updateAnim stage:" + stage + ", currentProgress:" + c16 + ", fakeProgress:" + i3 + ", stageFinalProgress:" + finalProgress + ", stageStartTime:" + stageStartTime + ", stageAnimUsedTime:" + coerceAtLeast);
        ValueAnimator valueAnimator = this.mWaitAnim;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.mWaitAnim = null;
        ValueAnimator valueAnimator2 = this.mKeepUpAnim;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        this.mKeepUpAnim = null;
        if (c16 == 100) {
            this.mFakeProgress = 100;
            e();
            return;
        }
        if (i3 < c16) {
            this.mWaitAnim = ValueAnimator.ofInt(c16, finalProgress);
            long predictDuration = stageProgressConfig.getPredictDuration() - coerceAtLeast;
            ValueAnimator valueAnimator3 = this.mWaitAnim;
            if (valueAnimator3 != null) {
                valueAnimator3.setDuration(predictDuration);
            }
            ValueAnimator valueAnimator4 = this.mWaitAnim;
            if (valueAnimator4 != null) {
                valueAnimator4.addUpdateListener(this);
            }
            ValueAnimator valueAnimator5 = this.mWaitAnim;
            if (valueAnimator5 != null) {
                valueAnimator5.setInterpolator(new LinearInterpolator());
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(i3, c16);
            this.mKeepUpAnim = ofInt;
            if (ofInt != null) {
                ofInt.setDuration(300L);
            }
            ValueAnimator valueAnimator6 = this.mKeepUpAnim;
            if (valueAnimator6 != null) {
                valueAnimator6.setInterpolator(new LinearInterpolator());
            }
            ValueAnimator valueAnimator7 = this.mKeepUpAnim;
            if (valueAnimator7 != null) {
                valueAnimator7.addUpdateListener(this);
            }
            ValueAnimator valueAnimator8 = this.mKeepUpAnim;
            if (valueAnimator8 != null) {
                valueAnimator8.addListener(new C11282b());
            }
            ValueAnimator valueAnimator9 = this.mKeepUpAnim;
            if (valueAnimator9 != null) {
                valueAnimator9.start();
                return;
            }
            return;
        }
        this.mWaitAnim = ValueAnimator.ofInt(i3, finalProgress);
        long predictDuration2 = stageProgressConfig.getPredictDuration() - coerceAtLeast;
        ValueAnimator valueAnimator10 = this.mWaitAnim;
        if (valueAnimator10 != null) {
            valueAnimator10.setDuration(predictDuration2);
        }
        ValueAnimator valueAnimator11 = this.mWaitAnim;
        if (valueAnimator11 != null) {
            valueAnimator11.addUpdateListener(this);
        }
        ValueAnimator valueAnimator12 = this.mWaitAnim;
        if (valueAnimator12 != null) {
            valueAnimator12.setInterpolator(new LinearInterpolator());
        }
        ValueAnimator valueAnimator13 = this.mWaitAnim;
        if (valueAnimator13 != null) {
            valueAnimator13.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(b this$0, StageProgress progress) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(progress, "$progress");
        this$0.j(progress);
    }

    private final void j(StageProgress progress) {
        QLog.i("MultiStageProgressGenerator_", 1, "updateProgressInner " + progress);
        if (this.mStageStartTime.get(progress.getStage()) == null) {
            this.mStageStartTime.put(progress.getStage(), Long.valueOf(System.currentTimeMillis()));
        }
        this.mCurrentProgress = progress;
        g();
    }

    public final void c(e l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        this.mListenerPool.add(l3);
    }

    public final void d() {
        ValueAnimator valueAnimator = this.mWaitAnim;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.mWaitAnim = null;
        ValueAnimator valueAnimator2 = this.mKeepUpAnim;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        this.mKeepUpAnim = null;
        this.mListenerPool.clear();
    }

    public final void f() {
        this.mCurrentProgress = new StageProgress(0, 0);
        this.mFakeProgress = 0;
        this.mStageStartTime.clear();
        ValueAnimator valueAnimator = this.mWaitAnim;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.mWaitAnim = null;
        ValueAnimator valueAnimator2 = this.mKeepUpAnim;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        this.mKeepUpAnim = null;
    }

    public final void h(final StageProgress progress) {
        Intrinsics.checkNotNullParameter(progress, "progress");
        QLog.i("MultiStageProgressGenerator_", 1, "updateProgress " + progress);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: tb4.a
            @Override // java.lang.Runnable
            public final void run() {
                b.i(b.this, progress);
            }
        });
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator animation) {
        Object animatedValue = animation != null ? animation.getAnimatedValue() : null;
        Integer num = animatedValue instanceof Integer ? (Integer) animatedValue : null;
        this.mFakeProgress = num != null ? num.intValue() : 0;
        e();
    }
}
