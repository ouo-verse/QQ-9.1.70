package xb0;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.events.QFSCollectedFeedEvent;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSDoCollectRequest;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ao extends QCircleBaseShareOperation {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements VSDispatchObserver.OnVSRspCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QFSDoCollectRequest f447687a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeed f447688b;

        a(QFSDoCollectRequest qFSDoCollectRequest, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
            this.f447687a = qFSDoCollectRequest;
            this.f447688b = feedCloudMeta$StFeed;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
            QLog.i("QFSSharePart", 1, "traceId:" + this.f447687a.getTraceId() + " isSuccess:" + z16 + " errorCode" + j3 + " msg:" + str);
            if (z16 && j3 == 0) {
                com.tencent.biz.qqcircle.immersive.personal.data.w wVar = new com.tencent.biz.qqcircle.immersive.personal.data.w(QCircleCommonUtil.getCurrentAccount());
                wVar.K();
                wVar.N(false);
                wVar.R();
                int i3 = this.f447688b.collection.count.get();
                FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f447688b;
                if (ao.this.t().type == 14) {
                    QCircleToast.p(com.tencent.biz.qqcircle.utils.h.a(R.string.f188533wy), 0, true);
                } else {
                    QCircleToast.h(R.string.f188533wy, 0);
                }
                MutableLiveData globalData = w20.a.j().getGlobalData(e30.b.class, this.f447688b.f398449id.get());
                if (globalData != null && globalData.getValue() != 0) {
                    ((e30.b) globalData.getValue()).g().opMask2.get().remove((Object) 25);
                    ((e30.b) globalData.getValue()).g().collection.count.set(i3 - 1);
                    w20.a.j().initOrUpdateGlobalState((w20.a) globalData.getValue(), true);
                    feedCloudMeta$StFeed = ((e30.b) globalData.getValue()).g();
                } else {
                    this.f447688b.opMask2.get().remove((Object) 25);
                    this.f447688b.collection.count.set(i3 - 1);
                    QLog.d("QFSSharePart", 1, "[sendRequest] cancelCollect feedBlockData=null feedId=", this.f447688b.f398449id.get());
                }
                QFSCollectedFeedEvent qFSCollectedFeedEvent = new QFSCollectedFeedEvent(feedCloudMeta$StFeed.f398449id.get(), false);
                qFSCollectedFeedEvent.setFeed(feedCloudMeta$StFeed);
                SimpleEventBus.getInstance().dispatchEvent(qFSCollectedFeedEvent);
                return;
            }
            QCircleToast.h(R.string.f19228473, 0);
        }
    }

    public ao(QCircleBaseShareOperation.a aVar) {
        super(aVar);
    }

    private void L(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        QFSDoCollectRequest a16 = new QFSDoCollectRequest.a(feedCloudMeta$StFeed).f(1).a();
        VSNetworkHelper.getInstance().sendRequest(a16, new a(a16, feedCloudMeta$StFeed));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    public void G() {
        if (t() != null && t().feed != null && f() != null) {
            if (!HostNetworkUtils.isNetworkAvailable()) {
                QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(R.string.f181603e8), 0);
                QLog.d("QFSSharePart", 4, "network not available");
                return;
            } else {
                L(t().feed);
                d(QCircleDaTongConstant.ElementParamValue.COLLECT_CANCEL, null);
                H(128, 2, t().extraTypeInfo, "2");
                return;
            }
        }
        J("QFSSharePart");
    }

    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    protected boolean y() {
        return true;
    }
}
