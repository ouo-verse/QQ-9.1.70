package xb;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.reborn.albumx.common.bean.CommonAlbumListBean;
import com.tencent.mobileqq.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0014J*\u0010\u0011\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0014R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0014\u00a8\u0006 "}, d2 = {"Lxb/c;", "Lcom/qzone/reborn/base/l;", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumListBean;", "", "getLogTag", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", "u", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "tvAlbumType", "f", "tvAlbumPersonNum", "Landroid/widget/LinearLayout;", tl.h.F, "Landroid/widget/LinearLayout;", "llAlbumTypeLayout", "i", "tvSplitText", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c extends com.qzone.reborn.base.l<CommonAlbumListBean> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView tvAlbumType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView tvAlbumPersonNum;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private LinearLayout llAlbumTypeLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView tvSplitText;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumxAlbumListAlbumTypeSection";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.nhp);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.tv_album_type)");
        this.tvAlbumType = (TextView) findViewById;
        View findViewById2 = containerView.findViewById(R.id.nho);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026R.id.tv_album_person_num)");
        this.tvAlbumPersonNum = (TextView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.f162795mo3);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026albumx_album_type_layout)");
        this.llAlbumTypeLayout = (LinearLayout) findViewById3;
        View findViewById4 = containerView.findViewById(R.id.njg);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewById(R.id.tv_num_split)");
        this.tvSplitText = (TextView) findViewById4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.nly};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v11, types: [android.widget.LinearLayout] */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void onBindData(CommonAlbumListBean data, int position, List<Object> payload) {
        String a16;
        if (data == null) {
            return;
        }
        TextView textView = null;
        switch (data.getAlbumInfo().getQzAlbumType()) {
            case 8:
                a16 = com.qzone.util.l.a(R.string.f134488y);
                break;
            case 9:
                a16 = com.qzone.util.l.a(R.string.f1345090);
                break;
            case 10:
            default:
                a16 = null;
                break;
            case 11:
                a16 = com.qzone.util.l.a(R.string.f134468w);
                break;
            case 12:
                a16 = com.qzone.util.l.a(R.string.f134478x);
                break;
        }
        if (TextUtils.isEmpty(a16)) {
            ?? r65 = this.llAlbumTypeLayout;
            if (r65 == 0) {
                Intrinsics.throwUninitializedPropertyAccessException("llAlbumTypeLayout");
            } else {
                textView = r65;
            }
            textView.setVisibility(8);
            return;
        }
        LinearLayout linearLayout = this.llAlbumTypeLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llAlbumTypeLayout");
            linearLayout = null;
        }
        linearLayout.setVisibility(0);
        TextView textView2 = this.tvAlbumType;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvAlbumType");
            textView2 = null;
        }
        textView2.setText(a16);
        if (data.getAlbumInfo().getShareAlbum().getShareNums() == 1) {
            TextView textView3 = this.tvAlbumPersonNum;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvAlbumPersonNum");
                textView3 = null;
            }
            textView3.setVisibility(8);
            TextView textView4 = this.tvSplitText;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvSplitText");
            } else {
                textView = textView4;
            }
            textView.setVisibility(8);
            return;
        }
        TextView textView5 = this.tvAlbumPersonNum;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvAlbumPersonNum");
            textView5 = null;
        }
        textView5.setVisibility(0);
        TextView textView6 = this.tvSplitText;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvSplitText");
            textView6 = null;
        }
        textView6.setVisibility(0);
        TextView textView7 = this.tvAlbumPersonNum;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvAlbumPersonNum");
        } else {
            textView = textView7;
        }
        textView.setText(this.mRootView.getResources().getString(R.string.f1341380, Integer.valueOf(data.getAlbumInfo().getShareAlbum().getShareNums())));
    }
}
