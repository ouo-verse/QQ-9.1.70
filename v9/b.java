package v9;

import android.view.View;
import android.widget.TextView;
import com.qzone.reborn.albumx.common.bean.CommonAlbumListBean;
import com.qzone.reborn.base.l;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0014J*\u0010\u0011\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0014R\"\u0010\u0019\u001a\u00020\u00128\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lv9/b;", "Lcom/qzone/reborn/base/l;", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumListBean;", "Landroid/view/View$OnClickListener;", "", "u", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "", "position", "", "", "payload", "w", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "v", "()Landroid/widget/TextView;", HippyTKDListViewAdapter.X, "(Landroid/widget/TextView;)V", "mAlbumNameView", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public abstract class b extends l<CommonAlbumListBean> implements View.OnClickListener {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    protected TextView mAlbumNameView;

    /* JADX WARN: Multi-variable type inference failed */
    private final void u() {
        v().setText(((CommonAlbumListBean) this.mData).getAlbumInfo().getName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.n3s);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026zone_intimate_album_name)");
        x((TextView) findViewById);
        v().setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final TextView v() {
        TextView textView = this.mAlbumNameView;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mAlbumNameView");
        return null;
    }

    protected final void x(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.mAlbumNameView = textView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.nlt};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void onBindData(CommonAlbumListBean data, int position, List<Object> payload) {
        if (data != null) {
            u();
        }
    }
}
