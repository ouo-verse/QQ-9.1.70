package u9;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.reborn.albumx.common.bean.CommonGridItemData;
import com.qzone.reborn.base.l;
import com.tencent.mobileqq.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0014J*\u0010\u0010\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0014R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lu9/e;", "Lcom/qzone/reborn/base/l;", "Lcom/qzone/reborn/albumx/common/bean/CommonGridItemData;", "", "v", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "", "position", "", "", "payload", "u", "Landroid/widget/LinearLayout;", "e", "Landroid/widget/LinearLayout;", "llContentLayout", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "tvTime", "<init>", "()V", h.F, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class e extends l<CommonGridItemData> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LinearLayout llContentLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView tvTime;

    /* JADX WARN: Multi-variable type inference failed */
    private final void v() {
        TextView textView = null;
        if (((CommonGridItemData) this.mData).getBatchBean().getBatchInfo().getShowTime().length() == 0) {
            TextView textView2 = this.tvTime;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvTime");
            } else {
                textView = textView2;
            }
            textView.setVisibility(8);
            return;
        }
        TextView textView3 = this.tvTime;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTime");
            textView3 = null;
        }
        textView3.setVisibility(0);
        TextView textView4 = this.tvTime;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTime");
        } else {
            textView = textView4;
        }
        textView.setText(((CommonGridItemData) this.mData).getBatchBean().getBatchInfo().getShowTime());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.mfp);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.ll_content_layout)");
        this.llContentLayout = (LinearLayout) findViewById;
        View findViewById2 = containerView.findViewById(R.id.nkb);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewById(R.id.tv_time)");
        this.tvTime = (TextView) findViewById2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.n4b};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void onBindData(CommonGridItemData data, int position, List<Object> payload) {
        if (data != null) {
            v();
        }
    }
}
