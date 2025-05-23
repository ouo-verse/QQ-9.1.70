package v9;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.qzone.reborn.albumx.common.bean.CommonAlbumListBean;
import com.qzone.reborn.base.l;
import com.qzone.util.ar;
import com.tencent.mobileqq.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rn.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J*\u0010\u0010\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0014R\"\u0010\u0018\u001a\u00020\u00118\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lv9/a;", "Lcom/qzone/reborn/base/l;", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumListBean;", "Landroid/view/View$OnClickListener;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", "v", "Landroid/widget/LinearLayout;", "e", "Landroid/widget/LinearLayout;", "u", "()Landroid/widget/LinearLayout;", "w", "(Landroid/widget/LinearLayout;)V", "mAddContentView", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "mAddIconView", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public abstract class a extends l<CommonAlbumListBean> implements View.OnClickListener {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    protected LinearLayout mAddContentView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView mAddIconView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.n3f);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026timate_add_album_content)");
        w((LinearLayout) findViewById);
        View findViewById2 = containerView.findViewById(R.id.n3g);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026_intimate_add_album_icon)");
        this.mAddIconView = (ImageView) findViewById2;
        ViewGroup.LayoutParams layoutParams = u().getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = (pl.a.f426446a.o(p()) - ar.e(48.0f)) / 2;
        }
        ViewGroup.LayoutParams layoutParams2 = u().getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.width = (pl.a.f426446a.o(p()) - ar.e(48.0f)) / 2;
        }
        ImageView imageView = this.mAddIconView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddIconView");
            imageView = null;
        }
        h.a(imageView, "qui_feed_picture_collection", R.color.qui_common_icon_secondary);
        u().setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinearLayout u() {
        LinearLayout linearLayout = this.mAddContentView;
        if (linearLayout != null) {
            return linearLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mAddContentView");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v(CommonAlbumListBean data, int position, List<Object> payload) {
        u().setVisibility(0);
    }

    protected final void w(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.mAddContentView = linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.nlq};
    }
}
