package xb0;

import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StPushList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ar extends QCircleBaseShareOperation {
    public ar(QCircleBaseShareOperation.a aVar) {
        super(aVar);
    }

    private int L() {
        FeedCloudMeta$StPushList f16 = QCirclePushInfoManager.e().f(t().extraTypeInfo.mFeed.f398449id.get());
        if (f16 != null) {
            return f16.hasClickCount.get();
        }
        return 0;
    }

    private void M() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        String str;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = null;
        if (t().extraTypeInfo != null) {
            feedCloudMeta$StFeed = t().extraTypeInfo.mFeed;
        } else {
            feedCloudMeta$StFeed = null;
        }
        QCircleLpReportDc05501.DataBuilder pageId = ua0.c.a(feedCloudMeta$StFeed).setActionType(122).setSubActionType(2).setPageId(m());
        String str2 = "";
        if (t().extraTypeInfo == null || t().extraTypeInfo.mFeed == null) {
            str = "";
        } else {
            str = t().extraTypeInfo.mFeed.poster.f398463id.get();
        }
        QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(pageId.setToUin(str)));
        if (t().extraTypeInfo != null) {
            feedCloudMeta$StFeed2 = t().extraTypeInfo.mFeed;
        }
        QCircleLpReportDc05507.DataBuilder pageId2 = ua0.c.c(feedCloudMeta$StFeed2).setActionType(122).setSubActionType(2).setPageId(m());
        if (t().extraTypeInfo != null && t().extraTypeInfo.mFeed != null) {
            str2 = t().extraTypeInfo.mFeed.poster.f398463id.get();
        }
        QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(pageId2.setToUin(str2)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    public void G() {
        if (t() != null && t().feed != null && f() != null) {
            QCirclePushInfoManager.e().m(t().feed, null, 1);
            M();
            d(QCircleDaTongConstant.ElementParamValue.SHARE_PANEL_CANCEL, null);
            return;
        }
        J("QFSSharePart");
    }

    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    protected Map<String, Object> g() {
        HashMap hashMap = new HashMap();
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_PUSH_TIMES, Integer.valueOf(L()));
        return hashMap;
    }

    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    protected boolean y() {
        return false;
    }
}
