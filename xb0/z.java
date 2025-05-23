package xb0;

import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QCircleSetUnCareRequest;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import feedcloud.FeedCloudMeta$StFeed;
import qqcircle.QQCircleRight$SetCircleUnCareRsp;

/* compiled from: P */
/* loaded from: classes5.dex */
public class z extends QCircleBaseShareOperation {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements VSDispatchObserver.OnVSRspCallBack<QQCircleRight$SetCircleUnCareRsp> {
        a() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleRight$SetCircleUnCareRsp qQCircleRight$SetCircleUnCareRsp) {
            if (QLog.isColorLevel()) {
                QLog.d("QFSSharePart", 1, "unCare person: isSuccess" + z16 + "retCode:" + j3 + "    errMsg:" + str);
            }
            if (!z16 || j3 != 0) {
                z.this.N();
            } else {
                z.this.Q();
                SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedEvent("", 6));
            }
        }
    }

    public z(QCircleBaseShareOperation.a aVar) {
        super(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        QCircleToast.i(QCircleToast.f91645e, R.string.f19228473, 0);
    }

    private void O(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedEvent(feedCloudMeta$StFeed.f398449id.get(), 3));
        if (u() == 4) {
            P(feedCloudMeta$StFeed.poster.f398463id.get());
        } else {
            Q();
        }
    }

    private void P(String str) {
        VSNetworkHelper.getInstance().sendRequest(new QCircleSetUnCareRequest(str, 1, 0, null), R());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        if (B()) {
            QCircleToast.i(QCircleToast.f91646f, R.string.f182873hn, 0);
        }
    }

    private VSDispatchObserver.OnVSRspCallBack<QQCircleRight$SetCircleUnCareRsp> R() {
        return new a();
    }

    private FeedCloudMeta$StFeed S() {
        if (t().feed.isRecomFd.get()) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
            feedCloudMeta$StFeed.f398449id.set(t().feed.recomForward.f398458id.get());
            feedCloudMeta$StFeed.poster.set(t().feed.recomForward.poster.get());
            return feedCloudMeta$StFeed;
        }
        return t().feed;
    }

    private void T(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        int i3;
        int m3;
        if (t().extraTypeInfo != null) {
            i3 = t().extraTypeInfo.mDataPosition;
        } else {
            i3 = -1;
        }
        QCircleLpReportDc05501.DataBuilder ext3 = ua0.c.a(feedCloudMeta$StFeed).setToUin(feedCloudMeta$StFeed.poster.f398463id.get()).setActionType(65).setSubActionType(u()).setIndex(i3).setExt3(String.valueOf(feedCloudMeta$StFeed.createTime));
        if (C(57)) {
            m3 = n();
        } else {
            m3 = m();
        }
        QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(ext3.setPageId(m3)));
        d("hidden", null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    public void G() {
        if (t() != null && t().feed != null && f() != null) {
            FeedCloudMeta$StFeed S = S();
            T(S);
            O(S);
            return;
        }
        J("QFSSharePart");
    }

    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    protected boolean y() {
        return false;
    }
}
