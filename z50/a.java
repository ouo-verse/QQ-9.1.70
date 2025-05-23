package z50;

import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqcircle.beans.QCircleAvatarLayerBean;
import com.tencent.biz.qqcircle.immersive.part.u;
import com.tencent.biz.qqcircle.immersive.utils.n;
import com.tencent.biz.qqcircle.requests.QCircleGetMyPendantBannerRequest;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarDecorateView;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.engineering.preload.inter.OnTaskListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.lang.ref.WeakReference;
import java.util.Map;
import qqcircle.QQCirclePendant$GetMyPendantBannerRsp;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends u implements View.OnClickListener {
    private Size C;
    private QQCirclePendant$GetMyPendantBannerRsp D;
    private QCircleAvatarLayerBean E;

    /* renamed from: d, reason: collision with root package name */
    private View f451938d;

    /* renamed from: e, reason: collision with root package name */
    private QCircleAvatarView f451939e;

    /* renamed from: f, reason: collision with root package name */
    private QCircleAvatarDecorateView f451940f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f451941h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f451942i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f451943m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: z50.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C11654a implements VSDispatchObserver.OnVSRspCallBack<QQCirclePendant$GetMyPendantBannerRsp> {
        C11654a() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCirclePendant$GetMyPendantBannerRsp qQCirclePendant$GetMyPendantBannerRsp) {
            QLog.d(a.this.getTAG(), 1, baseRequest.get$cmd() + ", onReceive: dispatch Success:" + z16 + " | TraceId:" + baseRequest.getTraceId() + " | SeqId:" + baseRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str + " | isCache:" + baseRequest.isEnableCache());
            a.this.C9(z16, j3, str, qQCirclePendant$GetMyPendantBannerRsp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class b implements OnTaskListener {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<a> f451945a;

        b(a aVar) {
            this.f451945a = new WeakReference<>(aVar);
        }

        @Override // com.tencent.mobileqq.engineering.preload.inter.OnTaskListener
        public void onComplete(Object[] objArr) {
            a aVar;
            WeakReference<a> weakReference = this.f451945a;
            if (weakReference != null && (aVar = weakReference.get()) != null) {
                aVar.F9(objArr);
            }
        }
    }

    public a(QCircleAvatarLayerBean qCircleAvatarLayerBean) {
        this.E = qCircleAvatarLayerBean;
    }

    private String A9() {
        QCircleAvatarLayerBean qCircleAvatarLayerBean = this.E;
        if (qCircleAvatarLayerBean != null && qCircleAvatarLayerBean.getUser().iconDecorate != null) {
            return this.E.getUser().iconDecorate.f398453id.get();
        }
        return "";
    }

    private void B9() {
        String str;
        QQCirclePendant$GetMyPendantBannerRsp qQCirclePendant$GetMyPendantBannerRsp = this.D;
        if (qQCirclePendant$GetMyPendantBannerRsp != null) {
            str = qQCirclePendant$GetMyPendantBannerRsp.jump_url.get();
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e(getTAG(), 1, "[handleBannerClick] mJumpUrl is empty");
        } else {
            com.tencent.biz.qqcircle.launcher.c.g(getContext(), str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C9(boolean z16, long j3, String str, QQCirclePendant$GetMyPendantBannerRsp qQCirclePendant$GetMyPendantBannerRsp) {
        QLog.d(getTAG(), 1, "[handleGetMyPendantBannerSuccess] isSuccess: " + z16 + ", retCode: " + j3 + ", errMsg: " + str);
        if (z16 && j3 == 0 && qQCirclePendant$GetMyPendantBannerRsp != null) {
            this.f451938d.setVisibility(0);
            QCircleAvatarLayerBean qCircleAvatarLayerBean = this.E;
            if (qCircleAvatarLayerBean != null) {
                this.f451939e.setUser(qCircleAvatarLayerBean.getUser(), this.C);
                this.f451940f.setUser(this.E.getUser());
            }
            this.f451941h.setText(qQCirclePendant$GetMyPendantBannerRsp.title.get());
            if (TextUtils.isEmpty(qQCirclePendant$GetMyPendantBannerRsp.subtitle.get())) {
                this.f451942i.setVisibility(8);
            } else {
                this.f451942i.setVisibility(0);
                this.f451942i.setText(qQCirclePendant$GetMyPendantBannerRsp.subtitle.get());
            }
            this.f451943m.setText(qQCirclePendant$GetMyPendantBannerRsp.bttn_text.get());
            this.D = qQCirclePendant$GetMyPendantBannerRsp;
            z9();
            return;
        }
        this.f451938d.setVisibility(8);
    }

    private void D9() {
        String A9 = A9();
        if (TextUtils.isEmpty(A9)) {
            QLog.e(getTAG(), 1, "[loadMyPendantBannerInfo] decorateId is empty");
            return;
        }
        String a16 = com.tencent.biz.qqcircle.preload.task.d.a(A9);
        if (PreLoader.exists(a16)) {
            E9(a16);
        } else {
            G9(A9);
        }
    }

    private void E9(String str) {
        QLog.d(getTAG(), 1, "[loadPreloadResult] preloadId: " + str);
        PreLoader.addListener(str, new b(this));
    }

    private void G9(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e(getTAG(), 1, "[requestMyPendantBannerInfo] decorateId is empty");
            return;
        }
        QLog.d(getTAG(), 1, "[requestMyPendantBannerInfo] decorateId: " + str);
        VSNetworkHelper.getInstance().sendRequest(new QCircleGetMyPendantBannerRequest(str), new C11654a());
    }

    private void z9() {
        VideoReport.setElementId(this.f451938d, QCircleDaTongConstant.ElementId.EM_XSJ_PENDANT_GUIDE);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        QQCirclePendant$GetMyPendantBannerRsp qQCirclePendant$GetMyPendantBannerRsp = this.D;
        if (qQCirclePendant$GetMyPendantBannerRsp != null) {
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PENDANT_TYPE, Integer.valueOf(qQCirclePendant$GetMyPendantBannerRsp.status.get()));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PENDANT_ID, A9());
        }
        VideoReport.setElementParams(this.f451938d, buildElementParams);
    }

    public void F9(Object[] objArr) {
        if (objArr.length >= 4 && (objArr[0] instanceof Boolean) && (objArr[1] instanceof Long) && (objArr[2] instanceof String)) {
            if (objArr[3] instanceof QQCirclePendant$GetMyPendantBannerRsp) {
                QLog.d("QFSAvatarLayerDecorateBannerPart", 1, "[onPreloadComplete] success, " + com.tencent.biz.qqcircle.preload.task.d.a(A9()));
                C9(((Boolean) objArr[0]).booleanValue(), ((Long) objArr[1]).longValue(), (String) objArr[2], (QQCirclePendant$GetMyPendantBannerRsp) objArr[3]);
                return;
            }
            return;
        }
        QLog.e(getTAG(), 1, "[onPreloadComplete] fail");
        G9(A9());
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSAvatarLayerDecorateBannerPart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null) {
            B9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f451938d = view.findViewById(R.id.f33960xv);
        this.f451939e = (QCircleAvatarView) view.findViewById(R.id.f33940xt);
        this.f451940f = (QCircleAvatarDecorateView) view.findViewById(R.id.f33970xw);
        this.f451941h = (TextView) view.findViewById(R.id.f33990xy);
        this.f451942i = (TextView) view.findViewById(R.id.f33980xx);
        this.f451943m = (TextView) view.findViewById(R.id.f33950xu);
        this.f451938d.setOnClickListener(this);
        this.C = n.a(getContext(), R.dimen.czs);
        D9();
    }
}
