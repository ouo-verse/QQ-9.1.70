package xb0;

import android.view.View;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSOpenNegativePanelEvent;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import com.tencent.biz.qui.toast.QUIBottomToast;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleFeedBase$NewUninterest;
import qqcircle.QQCircleFeedBase$StFeedBusiReqData;

/* compiled from: P */
/* loaded from: classes5.dex */
public class v extends QCircleBaseShareOperation {

    /* renamed from: u, reason: collision with root package name */
    private final List<String> f447732u;

    /* renamed from: v, reason: collision with root package name */
    private final List<String> f447733v;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeed f447734d;

        a(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
            this.f447734d = feedCloudMeta$StFeed;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            QCircleReportBean q16;
            EventCollector.getInstance().onViewClickedBefore(view);
            QFSOpenNegativePanelEvent qFSOpenNegativePanelEvent = new QFSOpenNegativePanelEvent(this.f447734d, v.this.f447732u, v.this.f447733v);
            if (v.this.q() == null) {
                q16 = new QCircleReportBean();
            } else {
                q16 = v.this.q();
            }
            qFSOpenNegativePanelEvent.setReportBean(q16);
            SimpleEventBus.getInstance().dispatchEvent(qFSOpenNegativePanelEvent);
            VideoReport.reportEvent("ev_xsj_abnormal_clck", v.this.P(this.f447734d));
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public v(QCircleBaseShareOperation.a aVar) {
        super(aVar);
        this.f447732u = new ArrayList();
        this.f447733v = new ArrayList();
    }

    private void O() {
        if (h() != null) {
            h().a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> P(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        if (feedCloudMeta$StFeed != null) {
            buildElementParams.put("xsj_feed_id", feedCloudMeta$StFeed.f398449id.get());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, feedCloudMeta$StFeed.poster.f398463id.get());
        }
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_FEED_QUALITY_FEEDBACK_COLLECT_GUIDE_BAR);
        if (q() != null) {
            buildElementParams.put("xsj_custom_pgid", q().getDtPageId());
        }
        return buildElementParams;
    }

    private boolean Q(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        int i3;
        int i16;
        if (feedCloudMeta$StFeed == null) {
            return false;
        }
        QQCircleFeedBase$StFeedBusiReqData qQCircleFeedBase$StFeedBusiReqData = new QQCircleFeedBase$StFeedBusiReqData();
        try {
            qQCircleFeedBase$StFeedBusiReqData.mergeFrom(feedCloudMeta$StFeed.busiData.get().toByteArray());
            QQCircleFeedBase$NewUninterest qQCircleFeedBase$NewUninterest = qQCircleFeedBase$StFeedBusiReqData.new_uninterest.get();
            i3 = qQCircleFeedBase$NewUninterest.not_want_watch.size();
            try {
                i16 = qQCircleFeedBase$NewUninterest.feedback_question.size();
            } catch (InvalidProtocolBufferMicroException e16) {
                e = e16;
                i16 = 0;
            }
            try {
                this.f447732u.addAll(qQCircleFeedBase$NewUninterest.not_want_watch.get());
                this.f447733v.addAll(qQCircleFeedBase$NewUninterest.feedback_question.get());
                QLog.d("QCircleDisLikeOperation", 1, "[hasDetailNegativeData] first category size = " + i3 + ", second category size = " + i16);
            } catch (InvalidProtocolBufferMicroException e17) {
                e = e17;
                QLog.e("QCircleDisLikeOperation", 1, "parse feedBusinessReqData except:" + e.toString());
                return i3 == 0 ? false : false;
            }
        } catch (InvalidProtocolBufferMicroException e18) {
            e = e18;
            i3 = 0;
            i16 = 0;
        }
        if (i3 == 0 && i16 != 0) {
            return true;
        }
    }

    private FeedCloudMeta$StFeed R() {
        if (t().feed.isRecomFd.get()) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
            feedCloudMeta$StFeed.f398449id.set(t().feed.recomForward.f398458id.get());
            feedCloudMeta$StFeed.poster.set(t().feed.recomForward.poster.get());
            return feedCloudMeta$StFeed;
        }
        return t().feed;
    }

    private void S(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3, int i16) {
        int i17;
        int m3;
        if (t().extraTypeInfo != null) {
            i17 = t().extraTypeInfo.mDataPosition;
        } else {
            i17 = -1;
        }
        QCircleLpReportDc05501.DataBuilder ext3 = ua0.c.a(feedCloudMeta$StFeed).setToUin(t().feed.poster.f398463id.get()).setActionType(i3).setSubActionType(i16).setIndex(i17).setExt3(String.valueOf(feedCloudMeta$StFeed.createTime));
        if (C(57)) {
            m3 = n();
        } else {
            m3 = m();
        }
        QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(ext3.setPageId(m3)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    public void G() {
        if (t() != null && t().feed != null && f() != null) {
            FeedCloudMeta$StFeed R = R();
            d(QCircleDaTongConstant.ElementParamValue.UNINTEREST, null);
            S(R, 78, 2);
            if (Q(R)) {
                O();
                SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedEvent(R.f398449id.get(), 3));
                QUIBottomToast.g(f(), 2, com.tencent.biz.qqcircle.utils.h.a(R.string.f1920046b), com.tencent.biz.qqcircle.utils.h.a(R.string.f19080433), new a(R), 0).n();
                VideoReport.reportEvent("ev_xsj_abnormal_imp", P(R));
                return;
            }
            return;
        }
        J("QCircleDisLikeOperation");
    }

    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    protected boolean y() {
        return false;
    }
}
