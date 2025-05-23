package xb0;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.events.QFSCommentOrReplySharePanelClickEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSDoTopProfileEvent;
import com.tencent.biz.qqcircle.immersive.request.QFSDoTopProfileFeedRequest;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ap extends QCircleBaseShareOperation {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements VSDispatchObserver.OnVSRspCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QFSDoTopProfileFeedRequest f447690a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeed f447691b;

        a(QFSDoTopProfileFeedRequest qFSDoTopProfileFeedRequest, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
            this.f447690a = qFSDoTopProfileFeedRequest;
            this.f447691b = feedCloudMeta$StFeed;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
            QLog.i("QFSSharePart", 1, "traceId:" + this.f447690a.getTraceId() + " isSuccess:" + z16 + " errorCode" + j3 + " msg:" + str);
            if (z16 && j3 == 0) {
                QCircleToast.h(R.string.f196224gq, 0);
                this.f447691b.opMask2.get().remove((Object) 20);
                SimpleEventBus.getInstance().dispatchEvent(new QFSDoTopProfileEvent(this.f447691b.f398449id.get(), false));
                MutableLiveData globalData = w20.a.j().getGlobalData(e30.b.class, this.f447691b.f398449id.get());
                if (globalData != null && globalData.getValue() != 0) {
                    ((e30.b) globalData.getValue()).g().opMask2.get().remove((Object) 20);
                    w20.a.j().initOrUpdateGlobalState((w20.a) globalData.getValue(), true);
                    return;
                }
                return;
            }
            QCircleToast.h(R.string.f19228473, 0);
        }
    }

    public ap(QCircleBaseShareOperation.a aVar) {
        super(aVar);
    }

    private void L(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            QLog.i("QFSSharePart", 1, "[sendDeleteFeedRequest] return: feed = null");
        } else {
            QFSDoTopProfileFeedRequest qFSDoTopProfileFeedRequest = new QFSDoTopProfileFeedRequest(feedCloudMeta$StFeed, 1);
            VSNetworkHelper.getInstance().sendRequest(qFSDoTopProfileFeedRequest, new a(qFSDoTopProfileFeedRequest, feedCloudMeta$StFeed));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    public void G() {
        QCircleShareInfo t16 = t();
        if (t16 != null && t16.feed != null && f() != null) {
            if (t16.type == 12) {
                SimpleEventBus.getInstance().dispatchEvent(new QFSCommentOrReplySharePanelClickEvent(2, t16.feed.f398449id.get(), t16.contextHashCode, t16.comment, null));
            } else {
                L(t().feed);
            }
            d(QCircleDaTongConstant.ElementParamValue.CANCEL_TOP, null);
            return;
        }
        J("QFSSharePart");
    }

    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    protected boolean y() {
        return false;
    }
}
