package xb0;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.events.QFSCommentOrReplySharePanelClickEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSDoTopProfileEvent;
import com.tencent.biz.qqcircle.immersive.personal.model.QFSPersonalTabIndexManager;
import com.tencent.biz.qqcircle.immersive.request.QFSDoTopProfileFeedRequest;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class an extends QCircleBaseShareOperation {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements VSDispatchObserver.OnVSRspCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QFSDoTopProfileFeedRequest f447684a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeed f447685b;

        a(QFSDoTopProfileFeedRequest qFSDoTopProfileFeedRequest, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
            this.f447684a = qFSDoTopProfileFeedRequest;
            this.f447685b = feedCloudMeta$StFeed;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
            int i3;
            QLog.i("QFSSharePart", 1, "traceId:" + this.f447684a.getTraceId() + " isSuccess:" + z16 + " errorCode" + j3 + " msg:" + str);
            if (z16 && j3 == 0) {
                QCircleToast.h(R.string.f195964g1, 0);
                this.f447685b.opMask2.get().add(20);
                SimpleEventBus.getInstance().dispatchEvent(new QFSDoTopProfileEvent(this.f447685b.f398449id.get(), true));
                MutableLiveData globalData = w20.a.j().getGlobalData(e30.b.class, this.f447685b.f398449id.get());
                if (globalData != null && globalData.getValue() != 0) {
                    ((e30.b) globalData.getValue()).g().opMask2.get().add(20);
                    w20.a.j().initOrUpdateGlobalState((w20.a) globalData.getValue(), true);
                    return;
                }
                return;
            }
            if (j3 == 10047) {
                if (QFSPersonalTabIndexManager.f88726a.h()) {
                    i3 = R.string.f193764a3;
                } else {
                    i3 = R.string.f19190462;
                }
                QCircleToast.h(i3, 0);
                an.this.M();
                return;
            }
            QCircleToast.h(R.string.f19228473, 0);
        }
    }

    public an(QCircleBaseShareOperation.a aVar) {
        super(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_SET_TOP_MAX_TOAST);
        buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        buildElementParams.put("xsj_action_type", QCircleDaTongConstant.ElementParamValue.TOP_MAX_PANEL_EXP);
        if (w20.a.j().k() > 0) {
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ACTION_VIDEO_LOCATION, Long.valueOf(w20.a.j().k()));
        }
        VideoReport.reportEvent("ev_xsj_sharepanel_action", null, buildElementParams);
    }

    private void N(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        QFSDoTopProfileFeedRequest qFSDoTopProfileFeedRequest = new QFSDoTopProfileFeedRequest(feedCloudMeta$StFeed, 0);
        VSNetworkHelper.getInstance().sendRequest(qFSDoTopProfileFeedRequest, new a(qFSDoTopProfileFeedRequest, feedCloudMeta$StFeed));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    public void G() {
        QCircleShareInfo t16 = t();
        if (t16 != null && t16.feed != null && f() != null) {
            if (t16.type == 12) {
                SimpleEventBus.getInstance().dispatchEvent(new QFSCommentOrReplySharePanelClickEvent(1, t16.feed.f398449id.get(), t16.contextHashCode, t16.comment, null));
            } else {
                N(t16.feed);
            }
            d(QCircleDaTongConstant.ElementParamValue.SET_TOP, null);
            return;
        }
        J("QFSSharePart");
    }

    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    protected boolean y() {
        return false;
    }
}
