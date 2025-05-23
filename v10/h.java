package v10;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.RelativeLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.weishi.q;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi.z;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\b\u001a\u00020\u0003H\u0014J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\f\u001a\u00020\u0003H\u0014J\b\u0010\r\u001a\u00020\u0003H\u0014J\b\u0010\u000e\u001a\u00020\u0003H\u0014\u00a8\u0006\u0015"}, d2 = {"Lv10/h;", "Lv10/b;", "Landroid/view/View$OnClickListener;", "", "G", UserInfo.SEX_FEMALE, "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ReportConstant.COSTREPORT_PREFIX, "Landroid/view/View;", "v", NodeProps.ON_CLICK, "g", tl.h.F, "f", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalPageFragment;", "fragment", "", "canShowFloatWindowArea", "<init>", "(Lcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalPageFragment;Z)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class h extends b implements View.OnClickListener {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(WSVerticalPageFragment fragment, boolean z16) {
        super(fragment, z16);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
    }

    private final void F() {
        if (hf0.a.a("vertical_video_top_homepage_click")) {
            x.i("AbsWsUIGroup", "fast click, ignored: vertical video top homepage");
            return;
        }
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.K(getFragment().getFrom(), getFragment().getPlayScene(), getFragment().Th());
        z.l(getFragment().getBaseActivity(), new q("from_float_window", 0, false));
        getFragment().getBaseActivity().finish();
    }

    private final void G() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.u(getFragment().getFrom(), getFragment().getPlayScene(), getFragment().Th());
        getFragment().getBaseActivity().doOnBackPressed();
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected int q() {
        return R.layout.d0r;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // v10.b, com.tencent.biz.pubaccount.weishi.baseui.b
    public void s() {
        super.s();
        View p16 = p(R.id.p8h);
        Intrinsics.checkNotNull(p16, "null cannot be cast to non-null type android.widget.RelativeLayout");
        com.tencent.biz.pubaccount.weishi.verticalvideo.utils.e.r(getFragment().getBaseActivity(), (RelativeLayout) p16);
        p(R.id.p8i).setOnClickListener(this);
        View p17 = p(R.id.f163258p52);
        p17.setOnClickListener(this);
        p(R.id.p8g).setOnClickListener(this);
        GradientDrawable a16 = ba.a(b().getResources().getColor(R.color.aet), ba.f81737l);
        Intrinsics.checkNotNullExpressionValue(a16, "createRoundRectangleDraw\u2026_15DP.toFloat()\n        )");
        p17.setBackgroundDrawable(a16);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.p8i) {
            G();
            return;
        }
        boolean z16 = true;
        if ((valueOf == null || valueOf.intValue() != R.id.f163258p52) && (valueOf == null || valueOf.intValue() != R.id.p8g)) {
            z16 = false;
        }
        if (z16) {
            F();
        }
    }

    @Override // v10.b, com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void f() {
    }

    @Override // v10.b, com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void g() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void h() {
    }
}
