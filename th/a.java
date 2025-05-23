package th;

import com.tencent.hippy.qq.view.scroll.HippyHeaderScrollViewController;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshFooter;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshHeader;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.constant.RefreshState;
import com.tencent.richframework.widget.refresh.layout.listener.OnMultiListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\"\u0010\u0010\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016J\"\u0010\u0011\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u001a\u0010\u0014\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J:\u0010\u001c\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016J\"\u0010\u001d\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016J\"\u0010\u001e\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u001a\u0010\u001f\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0013\u001a\u00020\u0012H\u0016\u00a8\u0006\""}, d2 = {"Lth/a;", "Lcom/tencent/richframework/widget/refresh/layout/listener/OnMultiListener;", "Lcom/tencent/richframework/widget/refresh/layout/api/IRefreshLayout;", "refreshLayout", "", HippyScrollViewEventHelper.EVENT_TYPE_REFRESH, "onLoadMore", "Lcom/tencent/richframework/widget/refresh/layout/constant/RefreshState;", "oldState", "newState", "onStateChanged", "Lcom/tencent/richframework/widget/refresh/layout/api/IRefreshHeader;", "header", "", HippyHeaderScrollViewController.HEADER_HEIGHT, "maxDragHeight", "onHeaderReleased", "onHeaderStartAnimator", "", "success", "onHeaderFinish", "Lcom/tencent/richframework/widget/refresh/layout/api/IRefreshFooter;", "footer", "isDragging", "", "percent", "offset", "footerHeight", "onFooterMoving", "onFooterReleased", "onFooterStartAnimator", "onFooterFinish", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public class a implements OnMultiListener {
    @Override // com.tencent.richframework.widget.refresh.layout.listener.OnLoadMoreListener
    public void onLoadMore(IRefreshLayout refreshLayout) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
    }

    @Override // com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener
    public void onRefresh(IRefreshLayout refreshLayout) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
    }

    @Override // com.tencent.richframework.widget.refresh.layout.listener.OnStateChangedListener
    public void onStateChanged(IRefreshLayout refreshLayout, RefreshState oldState, RefreshState newState) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        Intrinsics.checkNotNullParameter(oldState, "oldState");
        Intrinsics.checkNotNullParameter(newState, "newState");
    }

    @Override // com.tencent.richframework.widget.refresh.layout.listener.OnMultiListener
    public void onFooterFinish(IRefreshFooter footer, boolean success) {
    }

    @Override // com.tencent.richframework.widget.refresh.layout.listener.OnMultiListener
    public void onHeaderFinish(IRefreshHeader header, boolean success) {
    }

    @Override // com.tencent.richframework.widget.refresh.layout.listener.OnMultiListener
    public void onFooterReleased(IRefreshFooter footer, int footerHeight, int maxDragHeight) {
    }

    @Override // com.tencent.richframework.widget.refresh.layout.listener.OnMultiListener
    public void onFooterStartAnimator(IRefreshFooter footer, int footerHeight, int maxDragHeight) {
    }

    @Override // com.tencent.richframework.widget.refresh.layout.listener.OnMultiListener
    public void onHeaderReleased(IRefreshHeader header, int headerHeight, int maxDragHeight) {
    }

    @Override // com.tencent.richframework.widget.refresh.layout.listener.OnMultiListener
    public void onHeaderStartAnimator(IRefreshHeader header, int headerHeight, int maxDragHeight) {
    }

    @Override // com.tencent.richframework.widget.refresh.layout.listener.OnMultiListener
    public void onFooterMoving(IRefreshFooter footer, boolean isDragging, float percent, int offset, int footerHeight, int maxDragHeight) {
    }
}
