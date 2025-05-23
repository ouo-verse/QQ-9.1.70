package uw2;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportKey;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.playerEvent.h;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.immersiveAd.d;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.immersiveAd.f;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.QAdCardExtraData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.report.ImmersiveExposureHelp;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedui.qqlive.qaduikit.immersive.QAdInteractiveImmersiveHVView;
import com.tencent.tvideo.protocol.pb.AdFeedInfo;
import com.tencent.tvideo.protocol.pb.AdImmersivePoster;
import com.tencent.tvideo.protocol.pb.AdOrderItem;
import pw2.p;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c extends tw2.b implements uw2.b {

    /* renamed from: h, reason: collision with root package name */
    protected View f440501h;

    /* renamed from: i, reason: collision with root package name */
    protected f f440502i;

    /* renamed from: j, reason: collision with root package name */
    protected AdImmersivePoster f440503j;

    /* renamed from: k, reason: collision with root package name */
    protected ImmersiveExposureHelp f440504k;

    /* renamed from: l, reason: collision with root package name */
    protected b f440505l;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class b extends com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.playerEvent.a {
        b() {
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.playerEvent.a
        protected void a(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.playerEvent.f fVar) {
            if (fVar != null) {
                Object obj = fVar.f304104e;
                if (obj instanceof AdOrderItem) {
                    this.f304096a = new rw2.a((AdOrderItem) obj);
                }
            }
        }
    }

    public c(Context context) {
        super(context);
    }

    private void n(boolean z16) {
        if (this.f437868d != null) {
            return;
        }
        p(z16);
        v();
        o();
    }

    private void o() {
        this.f440505l = new b();
        this.f440504k = new ImmersiveExposureHelp(this.f437865a, this.f440501h);
    }

    private void s() {
        RelativeLayout i3 = ((QAdInteractiveImmersiveHVView) this.f437868d).i();
        if (i3 == this.f440501h) {
            return;
        }
        this.f440501h = i3;
        this.f440504k.k(i3);
        this.f437870f.e().c(this.f440501h);
    }

    private void u() {
        f fVar = this.f440502i;
        AdFeedInfo adFeedInfo = this.f437866b;
        fVar.n(adFeedInfo, new d(adFeedInfo));
        this.f440502i.y(m());
        this.f440502i.s();
        r();
        t();
        ((com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.subcontroller.immersive.c) this.f437870f.f()).u(this.f437866b);
        ((com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.subcontroller.immersive.a) this.f437870f.d()).p(this.f440502i);
    }

    private void v() {
        ((com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.subcontroller.immersive.b) this.f437870f.e()).w(this.f440502i);
        ((com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.subcontroller.immersive.b) this.f437870f.e()).x(this.f437866b, this.f440503j);
        this.f437870f.e().c(this.f440501h);
    }

    @Override // uw2.b
    public void d(uw2.a aVar) {
        ((com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.subcontroller.immersive.a) this.f437870f.d()).q(aVar);
        ((com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.subcontroller.immersive.c) this.f437870f.f()).t(aVar);
    }

    @Override // tw2.b, tw2.a
    public void e(QAdCardExtraData qAdCardExtraData) {
        super.e(qAdCardExtraData);
        f fVar = this.f440502i;
        if (fVar != null) {
            fVar.V(qAdCardExtraData);
        }
    }

    @Override // uw2.b
    public void f(boolean z16) {
        f fVar = this.f440502i;
        if (fVar == null) {
            return;
        }
        fVar.w(z16);
        this.f440502i.s();
        s();
    }

    @Override // tw2.b, tw2.a
    public void g(AdFeedInfo adFeedInfo) {
        super.g(adFeedInfo);
        AdFeedInfo adFeedInfo2 = this.f437866b;
        if (adFeedInfo2 != null) {
            this.f440503j = (AdImmersivePoster) p.c(AdImmersivePoster.class, adFeedInfo2.data);
        }
        n(true);
        if (this.f437865a != null && this.f437866b != null) {
            this.f440504k.l();
            u();
            v();
        }
    }

    @Override // tw2.a
    @NonNull
    public View h() {
        return this.f437868d;
    }

    @Override // tw2.b
    @NonNull
    protected vw2.a j() {
        return new vw2.b(this);
    }

    public ImmersiveExposureHelp l() {
        return this.f440504k;
    }

    protected QAdVrReportParams m() {
        QAdVrReportParams qAdVrReportParams = (QAdVrReportParams) this.f437867c.a(QAdCardExtraData.AdExtraInnerKey.AD_EXTRA_KEY_IS_VR_REPORT_PARAM, null);
        if (qAdVrReportParams != null) {
            qAdVrReportParams.a(VRReportDefine$ReportKey.AD_SCREEN_STATUS, 0);
        }
        return qAdVrReportParams;
    }

    protected void p(boolean z16) {
        QAdInteractiveImmersiveHVView qAdInteractiveImmersiveHVView = new QAdInteractiveImmersiveHVView(this.f437865a);
        this.f440502i = new f(qAdInteractiveImmersiveHVView, this.f437865a);
        this.f437868d = qAdInteractiveImmersiveHVView;
        this.f440501h = qAdInteractiveImmersiveHVView.i();
    }

    public void q(int i3, Object... objArr) {
        f fVar = this.f440502i;
        if (fVar != null) {
            fVar.I(i3, objArr);
        }
    }

    protected void r() {
        h.a().c(this.f437866b, this.f440505l);
    }

    protected void t() {
        AdFeedInfo adFeedInfo = this.f437866b;
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.report.a.a(adFeedInfo, 7, 0L, 0, 0, adFeedInfo.order_item);
    }
}
