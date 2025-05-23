package v10;

import UserGrowth.stSimpleMetaFeed;
import android.view.View;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.l;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 -2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001.B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u00a2\u0006\u0004\b*\u0010+B\u0019\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010!\u001a\u00020\u001b\u00a2\u0006\u0004\b*\u0010,J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0014J\b\u0010\b\u001a\u00020\u0003H\u0014J\u0006\u0010\t\u001a\u00020\u0003J\b\u0010\n\u001a\u00020\u0003H\u0014R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R$\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0014@\u0014X\u0094\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0012\u0010\u0019R\"\u0010!\u001a\u00020\u001b8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b\f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006/"}, d2 = {"Lv10/b;", "Lcom/tencent/biz/pubaccount/weishi/baseui/b;", "", "", "y", "E", "B", ReportConstant.COSTREPORT_PREFIX, "g", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "f", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalPageFragment;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalPageFragment;", "w", "()Lcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalPageFragment;", "fragment", "Landroid/widget/ImageView;", "D", "Landroid/widget/ImageView;", "ivFloatWindowBtn", "Landroid/view/View;", "Landroid/view/View;", HippyTKDListViewAdapter.X, "()Landroid/view/View;", "(Landroid/view/View;)V", "llFloatWindowArea", "", UserInfo.SEX_FEMALE, "Z", "v", "()Z", "(Z)V", "canShowFloatWindowArea", "LUserGrowth/stSimpleMetaFeed;", "G", "LUserGrowth/stSimpleMetaFeed;", "itemInfo", "Lb20/c;", "H", "Lb20/c;", "topFloatWindowGuide", "<init>", "(Lcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalPageFragment;)V", "(Lcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalPageFragment;Z)V", "I", "a", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public abstract class b extends com.tencent.biz.pubaccount.weishi.baseui.b<Object> {

    /* renamed from: C, reason: from kotlin metadata */
    private final WSVerticalPageFragment fragment;

    /* renamed from: D, reason: from kotlin metadata */
    private ImageView ivFloatWindowBtn;

    /* renamed from: E, reason: from kotlin metadata */
    private View llFloatWindowArea;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean canShowFloatWindowArea;

    /* renamed from: G, reason: from kotlin metadata */
    private stSimpleMetaFeed itemInfo;

    /* renamed from: H, reason: from kotlin metadata */
    private final b20.c topFloatWindowGuide;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(WSVerticalPageFragment fragment) {
        super(fragment.getContext());
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.fragment = fragment;
        this.topFloatWindowGuide = new b20.c(b());
    }

    private final void B() {
        Map<String, String> h06 = this.fragment.getPresenter().h0();
        Intrinsics.checkNotNullExpressionValue(h06, "fragment.presenter.reportExtMap");
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.G(this.fragment.getFrom(), this.fragment.getPlayScene(), this.fragment.Tc(), h06);
    }

    private final void E() {
        ImageView imageView = this.ivFloatWindowBtn;
        if (imageView == null || !this.topFloatWindowGuide.g(imageView)) {
            return;
        }
        B();
    }

    private final void y() {
        View findViewById = this.f80410e.findViewById(R.id.yo6);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.view.View");
        D(findViewById);
        if (xz.b.f449122a.c() && getCanShowFloatWindowArea()) {
            View llFloatWindowArea = getLlFloatWindowArea();
            if (llFloatWindowArea != null) {
                llFloatWindowArea.setVisibility(0);
            }
            View findViewById2 = this.f80410e.findViewById(R.id.y3c);
            Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.ImageView");
            ImageView imageView = (ImageView) findViewById2;
            this.ivFloatWindowBtn = imageView;
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener() { // from class: v10.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        b.z(b.this, view);
                    }
                });
            }
            E();
            return;
        }
        View llFloatWindowArea2 = getLlFloatWindowArea();
        if (llFloatWindowArea2 == null) {
            return;
        }
        llFloatWindowArea2.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(b this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.fragment.K3(!(this$0.fragment.getPresenter() instanceof l));
    }

    public final void A() {
        this.topFloatWindowGuide.l();
    }

    public void C(boolean z16) {
        this.canShowFloatWindowArea = z16;
    }

    protected void D(View view) {
        this.llFloatWindowArea = view;
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void f() {
        this.topFloatWindowGuide.i();
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void g() {
        if (c() instanceof com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) {
            Object c16 = c();
            Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type com.tencent.biz.pubaccount.weishi.verticalvideo.data.WSVerticalItemData");
            this.itemInfo = ((com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) c16).e();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    public void s() {
        y();
    }

    /* renamed from: v, reason: from getter */
    public boolean getCanShowFloatWindowArea() {
        return this.canShowFloatWindowArea;
    }

    /* renamed from: w, reason: from getter */
    public final WSVerticalPageFragment getFragment() {
        return this.fragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: x, reason: from getter */
    public View getLlFloatWindowArea() {
        return this.llFloatWindowArea;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(WSVerticalPageFragment fragment, boolean z16) {
        this(fragment);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        C(z16);
    }
}
