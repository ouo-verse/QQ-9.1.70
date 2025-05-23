package sg;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.j;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import ho.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00052\u00020\u00012\u00020\u0002:\u0001$B\u0007\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\bH\u0014J\b\u0010\u000b\u001a\u00020\nH\u0014J\b\u0010\r\u001a\u00020\fH\u0014J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J\u0012\u0010\u0013\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014J\u0012\u0010\u0015\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u000eH\u0016R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0016\u0010\u001e\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010 \u00a8\u0006%"}, d2 = {"Lsg/c;", "Lvg/a;", "Landroid/view/View$OnClickListener;", "", "K", "J", "I", "H", "", "k", "", ReportConstant.COSTREPORT_PREFIX, "", HippyTKDListViewAdapter.X, "Landroid/view/View;", "containerView", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "v", NodeProps.ON_CLICK, "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "mRecommendTitle", "G", "mRecommendMoreDesc", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "mRecommendMoreArea", "Lcom/qzone/proxy/feedcomponent/model/j;", "Lcom/qzone/proxy/feedcomponent/model/j;", "mRecommendData", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c extends vg.a implements View.OnClickListener {

    /* renamed from: F, reason: from kotlin metadata */
    private TextView mRecommendTitle;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView mRecommendMoreDesc;

    /* renamed from: H, reason: from kotlin metadata */
    private LinearLayout mRecommendMoreArea;

    /* renamed from: I, reason: from kotlin metadata */
    private j mRecommendData;

    private final void H() {
        if (this.C == null) {
            QLog.e("QZoneFriendPostingFeedTitlePresenter", 1, "mActivity is null");
            return;
        }
        j jVar = this.mRecommendData;
        String rightJumpUrl = jVar != null ? jVar.getRightJumpUrl() : null;
        if (TextUtils.isEmpty(rightJumpUrl)) {
            return;
        }
        i.q(this.C, rightJumpUrl);
    }

    private final void I() {
        fo.b bVar = new fo.b();
        bVar.k(ExposurePolicy.REPORT_ALL);
        bVar.j(EndExposurePolicy.REPORT_NONE);
        bVar.g(ClickPolicy.REPORT_ALL);
        LinearLayout linearLayout = this.mRecommendMoreArea;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecommendMoreArea");
            linearLayout = null;
        }
        fo.c.o(linearLayout, "em_qz_friend_publish_more", bVar);
    }

    private final void J() {
        TextView textView = this.mRecommendMoreDesc;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecommendMoreDesc");
            textView = null;
        }
        j jVar = this.mRecommendData;
        textView.setText(jVar != null ? jVar.getTitleRight() : null);
    }

    private final void K() {
        TextView textView = this.mRecommendTitle;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecommendTitle");
            textView = null;
        }
        j jVar = this.mRecommendData;
        textView.setText(jVar != null ? jVar.getTitle() : null);
    }

    @Override // vg.a
    protected void A(BusinessFeedData feedData) {
        j c16 = d.f433774a.c(feedData != null ? feedData.cellUniverse : null);
        this.mRecommendData = c16;
        if (c16 == null) {
            return;
        }
        K();
        J();
        I();
    }

    @Override // vg.a
    protected void C(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.f162868n22);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026edx_view_recommend_title)");
        this.mRecommendTitle = (TextView) findViewById;
        View findViewById2 = containerView.findViewById(R.id.f162866n20);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026eedx_view_recommend_more)");
        this.mRecommendMoreDesc = (TextView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.f162867n21);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026view_recommend_more_area)");
        LinearLayout linearLayout = (LinearLayout) findViewById3;
        this.mRecommendMoreArea = linearLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecommendMoreArea");
            linearLayout = null;
        }
        linearLayout.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZoneFriendPostingFeedTitlePresenter";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        boolean z16 = false;
        if (v3 != null && v3.getId() == R.id.f162867n21) {
            z16 = true;
        }
        if (z16) {
            H();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // vg.a
    protected int s() {
        return R.id.nll;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }
}
