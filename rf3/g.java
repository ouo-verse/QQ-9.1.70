package rf3;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.tencent.mobileqq.zplan.card.impl.view.avatar.ZPlanAvatarCard;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001b2\u00020\u0001:\u0001\u0007B\u001f\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0011R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lrf3/g;", "", "Landroid/view/MotionEvent;", "ev", "", "c", "b", "a", "", "d", "Landroid/content/Context;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/zplan/card/impl/view/avatar/ZPlanAvatarCard;", "Lcom/tencent/mobileqq/zplan/card/impl/view/avatar/ZPlanAvatarCard;", "cardView", "Lrf3/e;", "Lrf3/e;", "animHelper", "Landroid/graphics/PointF;", "Landroid/graphics/PointF;", "mLastDownPoint", "e", "Z", "mMoveJudgeDown", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/zplan/card/impl/view/avatar/ZPlanAvatarCard;Lrf3/e;)V", "f", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ZPlanAvatarCard cardView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final e animHelper;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private PointF mLastDownPoint;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mMoveJudgeDown;

    public g(Context context, ZPlanAvatarCard cardView, e animHelper) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cardView, "cardView");
        Intrinsics.checkNotNullParameter(animHelper, "animHelper");
        this.context = context;
        this.cardView = cardView;
        this.animHelper = animHelper;
    }

    private final void a() {
        com.tencent.sqshow.zootopia.avatar.b H = this.cardView.H();
        if (H != null) {
            H.c();
        }
    }

    private final void b() {
        com.tencent.sqshow.zootopia.avatar.b H = this.cardView.H();
        if (H != null) {
            H.h();
        }
    }

    public final boolean d(MotionEvent ev5) {
        com.tencent.sqshow.zootopia.avatar.b H = this.cardView.H();
        if (H == null) {
            return this.cardView.P(ev5);
        }
        boolean z16 = H.getState() == 1;
        boolean isLoadingShowing = H.isLoadingShowing();
        if (!z16) {
            this.animHelper.y(false);
        } else if (isLoadingShowing) {
            this.animHelper.y(true);
        } else {
            c(ev5);
        }
        return this.cardView.P(ev5);
    }

    private final void c(MotionEvent ev5) {
        if (ev5 == null) {
            return;
        }
        int action = ev5.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    PointF pointF = this.mLastDownPoint;
                    if (pointF == null || this.mMoveJudgeDown) {
                        return;
                    }
                    float abs = Math.abs(ev5.getRawX() - pointF.x);
                    float abs2 = Math.abs(ev5.getRawY() - pointF.y);
                    if (abs == 0.0f) {
                        if (abs2 == 0.0f) {
                            QLog.w("ZPlanAvatarCardTouchHelper_", 1, "interceptWhenAvatarShowing ACTION_MOVE all 0");
                            return;
                        }
                    }
                    if (abs == 0.0f) {
                        a();
                        this.animHelper.y(true);
                        return;
                    }
                    double abs3 = (Math.abs((float) Math.atan(abs2 / abs)) / 3.141592653589793d) * 180;
                    QLog.w("ZPlanAvatarCardTouchHelper_", 1, "interceptWhenAvatarShowing ACTION_MOVE dx:" + abs + ", dy:" + abs2 + ", angle:" + abs3);
                    if (abs3 >= 45.0d) {
                        a();
                        this.animHelper.y(true);
                    } else {
                        b();
                        this.animHelper.y(false);
                    }
                    this.mMoveJudgeDown = true;
                    return;
                }
                if (action != 3) {
                    return;
                }
            }
            QLog.i("ZPlanAvatarCardTouchHelper_", 1, "interceptWhenAvatarShowing ACTION_CANCEL " + ev5);
            this.animHelper.y(true);
            b();
            this.mMoveJudgeDown = false;
            this.mLastDownPoint = null;
            return;
        }
        this.mLastDownPoint = new PointF(ev5.getRawX(), ev5.getRawY());
        QLog.i("ZPlanAvatarCardTouchHelper_", 1, "interceptWhenAvatarShowing ACTION_DOWN " + ev5);
        this.animHelper.y(true);
        b();
        this.mMoveJudgeDown = false;
    }
}
