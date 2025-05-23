package xb0;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.events.QFSWatchLaterEvent;
import com.tencent.biz.qqcircle.immersive.utils.ba;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QFSBatchDelFromWatchLaterRequest;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudWatchlater$BatchDelFromWatchLaterRsp;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class au extends QCircleBaseShareOperation {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements VSDispatchObserver.OnVSRspCallBack<FeedCloudWatchlater$BatchDelFromWatchLaterRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeed f447695a;

        a(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
            this.f447695a = feedCloudMeta$StFeed;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudWatchlater$BatchDelFromWatchLaterRsp feedCloudWatchlater$BatchDelFromWatchLaterRsp) {
            if (z16 && j3 == 0) {
                MutableLiveData globalData = w20.a.j().getGlobalData(e30.b.class, this.f447695a.f398449id.get());
                if (globalData != null && globalData.getValue() != 0) {
                    ((e30.b) globalData.getValue()).g().opMask2.get().remove((Object) 60);
                    w20.a.j().initOrUpdateGlobalState((w20.a) globalData.getValue(), true);
                } else {
                    if (this.f447695a.opMask2.get().contains(60)) {
                        this.f447695a.opMask2.get().remove((Object) 60);
                    }
                    QLog.d("QFSSharePart", 1, "[sendRequest] cancelCollect feedBlockData=null feedId=", this.f447695a.f398449id.get());
                }
                SimpleEventBus.getInstance().dispatchEvent(new QFSWatchLaterEvent(au.this.t().feed.f398449id.get(), true));
                QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(R.string.f196524hj), 0);
                QLog.d("QFSSharePart", 1, "[sendRequest] delete watch later, feedId=", this.f447695a.f398449id.get());
                return;
            }
            if (TextUtils.isEmpty(str)) {
                str = com.tencent.biz.qqcircle.utils.h.a(R.string.f19228473);
            }
            QCircleToast.o(str, 0);
        }
    }

    public au(QCircleBaseShareOperation.a aVar) {
        super(aVar);
    }

    private void L(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            RFWLog.d("QFSSharePart", RFWLog.USR, "[reportCancelWaitWatchToDc5507] feed should not null.");
        } else {
            QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(ua0.c.c(feedCloudMeta$StFeed)).setActionType(5103).setSubActionType(2).setfpageid(q().getFromPageId()).setPageId(m()).setRequestId(ba.d(feedCloudMeta$StFeed)));
        }
    }

    private void M(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        String str = feedCloudMeta$StFeed.f398449id.get();
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        VSNetworkHelper.getInstance().sendRequest(new QFSBatchDelFromWatchLaterRequest(0, null, arrayList), new a(feedCloudMeta$StFeed));
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
                M(t().feed);
                d(QCircleDaTongConstant.ElementParamValue.CANCEL_WAIT_WATCH, null);
                L(t().feed);
                return;
            }
        }
        J("QFSSharePart");
    }

    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    protected boolean y() {
        return false;
    }
}
