package xb0;

import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.utils.ba;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QFSBatchAddToWatchLaterRequest;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import com.tencent.biz.qui.toast.QUIBottomToast;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudWatchlater$AddWatchLaterEntry;
import feedcloud.FeedCloudWatchlater$BatchAddToWatchLaterRsp;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class av extends QCircleBaseShareOperation {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements VSDispatchObserver.OnVSRspCallBack<FeedCloudWatchlater$BatchAddToWatchLaterRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeed f447697a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: xb0.av$a$a, reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class ViewOnClickListenerC11537a implements View.OnClickListener {
            ViewOnClickListenerC11537a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                com.tencent.biz.qqcircle.launcher.c.H0(av.this.f(), new QCircleInitBean());
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        a(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
            this.f447697a = feedCloudMeta$StFeed;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudWatchlater$BatchAddToWatchLaterRsp feedCloudWatchlater$BatchAddToWatchLaterRsp) {
            if (z16 && j3 == 0) {
                MutableLiveData globalData = w20.a.j().getGlobalData(e30.b.class, this.f447697a.f398449id.get());
                if (globalData != null && globalData.getValue() != 0) {
                    ((e30.b) globalData.getValue()).g().opMask2.get().add(60);
                    w20.a.j().initOrUpdateGlobalState((w20.a) globalData.getValue(), true);
                } else if (!this.f447697a.opMask2.get().contains(60)) {
                    this.f447697a.opMask2.get().add(60);
                    if (av.this.t() != null && av.this.t().feedBlockData != null) {
                        w20.a.j().initOrUpdateGlobalState((w20.a) av.this.t().feedBlockData, true);
                    }
                }
                QLog.d("QFSSharePart", 1, "[sendRequest] add watch later, feedId=", this.f447697a.f398449id.get());
                QUIBottomToast.g(av.this.f(), 2, "\u5df2\u6dfb\u52a0\u5230\"\u7a0d\u540e\u518d\u770b\"", com.tencent.biz.qqcircle.utils.h.a(R.string.f1908743_), new ViewOnClickListenerC11537a(), 0).n();
                return;
            }
            if (TextUtils.isEmpty(str)) {
                str = com.tencent.biz.qqcircle.utils.h.a(R.string.f19228473);
            }
            QCircleToast.o(str, 0);
        }
    }

    public av(QCircleBaseShareOperation.a aVar) {
        super(aVar);
    }

    private void L(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            RFWLog.d("QFSSharePart", RFWLog.USR, "[reportCancelWaitWatchToDc5507] feed should not null.");
        } else {
            QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(ua0.c.c(feedCloudMeta$StFeed)).setActionType(5102).setSubActionType(2).setfpageid(q().getFromPageId()).setPageId(m()).setRequestId(ba.d(feedCloudMeta$StFeed)));
        }
    }

    private void M(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        String str = feedCloudMeta$StFeed.f398449id.get();
        ArrayList arrayList = new ArrayList();
        FeedCloudWatchlater$AddWatchLaterEntry feedCloudWatchlater$AddWatchLaterEntry = new FeedCloudWatchlater$AddWatchLaterEntry();
        feedCloudWatchlater$AddWatchLaterEntry.watch_time.set(w20.a.j().b());
        feedCloudWatchlater$AddWatchLaterEntry.feed_id.set(str);
        arrayList.add(feedCloudWatchlater$AddWatchLaterEntry);
        VSNetworkHelper.getInstance().sendRequest(new QFSBatchAddToWatchLaterRequest(arrayList), new a(feedCloudMeta$StFeed));
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
                d(QCircleDaTongConstant.ElementParamValue.WAIT_WATCH, null);
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
