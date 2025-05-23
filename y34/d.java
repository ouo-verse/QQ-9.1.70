package y34;

import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.robot.discoveryv2.common.data.FirstScreenFetchArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"Ly34/d;", "Ly34/b;", "Ly34/f;", "reserveParams", "Landroid/widget/FrameLayout;", "reserveLayout", "", "c", "e", "a", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class d implements b {
    private final void c(final ReserveParams reserveParams, FrameLayout reserveLayout) {
        QUIEmptyState.Builder halfScreenState = new QUIEmptyState.Builder(reserveLayout.getContext()).setThemeType(0).setImageType(5).setBackgroundColorType(0).setHalfScreenState(false);
        String string = reserveLayout.getContext().getString(R.string.f222236cz);
        Intrinsics.checkNotNullExpressionValue(string, "reserveLayout.context.ge\u2026t_common_load_error_tips)");
        QUIEmptyState.Builder desc = halfScreenState.setDesc(string);
        String string2 = reserveLayout.getContext().getString(R.string.f222226cy);
        Intrinsics.checkNotNullExpressionValue(string2, "reserveLayout.context.ge\u2026_common_click_retry_tips)");
        reserveLayout.addView(desc.setButton(string2, new View.OnClickListener() { // from class: y34.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.d(d.this, reserveParams, view);
            }
        }).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(d this$0, ReserveParams reserveParams, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(reserveParams, "$reserveParams");
        this$0.e(reserveParams);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void e(ReserveParams reserveParams) {
        if (FastClickUtils.isFastDoubleClick("LoadFailedDisplayStrategyonRetryBtnClick")) {
            return;
        }
        reserveParams.getViewModel().M1().a(new FirstScreenFetchArgs(reserveParams.getUin()));
    }

    @Override // y34.b
    public void a(@NotNull ReserveParams reserveParams, @NotNull FrameLayout reserveLayout) {
        Intrinsics.checkNotNullParameter(reserveParams, "reserveParams");
        Intrinsics.checkNotNullParameter(reserveLayout, "reserveLayout");
        reserveLayout.removeAllViews();
        c(reserveParams, reserveLayout);
    }
}
