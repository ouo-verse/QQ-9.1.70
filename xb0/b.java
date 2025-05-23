package xb0;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.events.QFSCollectedFeedEvent;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSDoCollectRequest;
import com.tencent.biz.qqcircle.immersive.utils.QFSPublishTipsUtils;
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
import feedcloud.FeedCloudWrite$StDoCollectRsp;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b extends QCircleBaseShareOperation {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements VSDispatchObserver.OnVSRspCallBack<FeedCloudWrite$StDoCollectRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QFSDoCollectRequest f447700a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeed f447701b;

        a(QFSDoCollectRequest qFSDoCollectRequest, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
            this.f447700a = qFSDoCollectRequest;
            this.f447701b = feedCloudMeta$StFeed;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudWrite$StDoCollectRsp feedCloudWrite$StDoCollectRsp) {
            QLog.i("QFSSharePart", 1, "traceId:" + this.f447700a.getTraceId() + " isSuccess:" + z16 + " errorCode" + j3 + " msg:" + str);
            if (z16 && j3 == 0) {
                com.tencent.biz.qqcircle.immersive.personal.data.w wVar = new com.tencent.biz.qqcircle.immersive.personal.data.w(QCircleCommonUtil.getCurrentAccount());
                wVar.K();
                wVar.N(true);
                wVar.R();
                int i3 = this.f447701b.collection.count.get();
                FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f447701b;
                MutableLiveData globalData = w20.a.j().getGlobalData(e30.b.class, this.f447701b.f398449id.get());
                if (globalData != null && globalData.getValue() != 0) {
                    ((e30.b) globalData.getValue()).g().opMask2.get().add(25);
                    ((e30.b) globalData.getValue()).g().collection.count.set(i3 + 1);
                    w20.a.j().initOrUpdateGlobalState((w20.a) globalData.getValue(), true);
                    feedCloudMeta$StFeed = ((e30.b) globalData.getValue()).g();
                } else {
                    if (!this.f447701b.opMask2.get().contains(25)) {
                        this.f447701b.opMask2.get().add(25);
                        this.f447701b.collection.count.set(i3 + 1);
                    }
                    QLog.d("QFSSharePart", 1, "[sendRequest] collect feedBlockData=null feedId=", this.f447701b.f398449id.get());
                }
                QFSCollectedFeedEvent qFSCollectedFeedEvent = new QFSCollectedFeedEvent(feedCloudMeta$StFeed.f398449id.get(), true);
                qFSCollectedFeedEvent.setFeed(feedCloudMeta$StFeed);
                qFSCollectedFeedEvent.setHasCollectBox(feedCloudWrite$StDoCollectRsp.hasFavorites.get());
                SimpleEventBus.getInstance().dispatchEvent(qFSCollectedFeedEvent);
                if (b.this.t() != null) {
                    if (b.this.t().type == 14 || b.this.t().type == 15) {
                        QFSPublishTipsUtils qFSPublishTipsUtils = new QFSPublishTipsUtils();
                        qFSPublishTipsUtils.w(new View(b.this.f()), this.f447701b, feedCloudWrite$StDoCollectRsp.hasFavorites.get());
                        qFSPublishTipsUtils.t(b.this.q());
                        QLog.d("QFSSharePart", 1, "TYPE_SHARE_KUIKLY || TYPE_SHARE_NEW_CONTENT_DETAIL show collect toast");
                        return;
                    }
                    return;
                }
                return;
            }
            QCircleToast.h(R.string.f19228473, 0);
        }
    }

    public b(QCircleBaseShareOperation.a aVar) {
        super(aVar);
    }

    private void L(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        QFSDoCollectRequest a16 = new QFSDoCollectRequest.a(feedCloudMeta$StFeed).f(0).a();
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
                d(QCircleDaTongConstant.ElementParamValue.COLLECT, null);
                H(128, 2, t().extraTypeInfo, "1");
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
