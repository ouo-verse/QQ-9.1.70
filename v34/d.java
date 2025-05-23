package v34;

import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.robot.discoveryv2.common.data.SingleCategoryLoadType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"Lv34/d;", "Lv34/a;", "Lv34/f;", "pageReserveParams", "Landroid/widget/FrameLayout;", "pageReserveLayout", "", "c", "e", "a", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class d implements a {
    private final void c(final PageReserveParams pageReserveParams, FrameLayout pageReserveLayout) {
        QUIEmptyState.Builder halfScreenState = new QUIEmptyState.Builder(pageReserveLayout.getContext()).setThemeType(0).setImageType(5).setBackgroundColorType(0).setHalfScreenState(false);
        String string = pageReserveLayout.getContext().getString(R.string.f222236cz);
        Intrinsics.checkNotNullExpressionValue(string, "pageReserveLayout.contex\u2026t_common_load_error_tips)");
        QUIEmptyState.Builder desc = halfScreenState.setDesc(string);
        String string2 = pageReserveLayout.getContext().getString(R.string.f222226cy);
        Intrinsics.checkNotNullExpressionValue(string2, "pageReserveLayout.contex\u2026_common_click_retry_tips)");
        QUIEmptyState build = desc.setButton(string2, new View.OnClickListener() { // from class: v34.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.d(d.this, pageReserveParams, view);
            }
        }).build();
        pageReserveLayout.setVisibility(0);
        pageReserveLayout.addView(build);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(d this$0, PageReserveParams pageReserveParams, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(pageReserveParams, "$pageReserveParams");
        this$0.e(pageReserveParams);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void e(PageReserveParams pageReserveParams) {
        if (FastClickUtils.isFastDoubleClick("PageReserveLoadFailedStrategyonRetryBtnClick")) {
            return;
        }
        pageReserveParams.getViewModel().a2(SingleCategoryLoadType.LOAD_CATEGORY_FIRST);
    }

    @Override // v34.a
    public void a(@NotNull PageReserveParams pageReserveParams, @NotNull FrameLayout pageReserveLayout) {
        Intrinsics.checkNotNullParameter(pageReserveParams, "pageReserveParams");
        Intrinsics.checkNotNullParameter(pageReserveLayout, "pageReserveLayout");
        pageReserveLayout.removeAllViews();
        c(pageReserveParams, pageReserveLayout);
    }
}
