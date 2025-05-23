package wl1;

import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lwl1/a;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "x9", "onInitView", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "d", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "refreshLayout", "<init>", "()V", "e", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private SmartRefreshLayout refreshLayout;

    private final void x9(View rootView) {
        View findViewById = rootView.findViewById(R.id.v1r);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026feed_detail_content_root)");
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) findViewById;
        this.refreshLayout = smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2 = null;
        if (smartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout = null;
        }
        smartRefreshLayout.setEnableRefresh(false);
        SmartRefreshLayout smartRefreshLayout3 = this.refreshLayout;
        if (smartRefreshLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout3 = null;
        }
        smartRefreshLayout3.setEnableLoadMore(true);
        SmartRefreshLayout smartRefreshLayout4 = this.refreshLayout;
        if (smartRefreshLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        } else {
            smartRefreshLayout2 = smartRefreshLayout4;
        }
        smartRefreshLayout2.setNoMoreData(true);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        if (rootView == null) {
            return;
        }
        x9(rootView);
    }
}
