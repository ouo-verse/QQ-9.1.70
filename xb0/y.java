package xb0;

import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.events.QFSOpenSettingPermissionWindowEvent;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class y extends QCircleBaseShareOperation {
    public y(QCircleBaseShareOperation.a aVar) {
        super(aVar);
    }

    private void L(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        QFSOpenSettingPermissionWindowEvent qFSOpenSettingPermissionWindowEvent = new QFSOpenSettingPermissionWindowEvent(feedCloudMeta$StFeed, true);
        qFSOpenSettingPermissionWindowEvent.mHashCode = f().hashCode();
        SimpleEventBus.getInstance().dispatchEvent(qFSOpenSettingPermissionWindowEvent);
    }

    private void M(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_MULTIMEDIA);
        buildElementParams.put("xsj_feed_id", feedCloudMeta$StFeed.f398449id.get());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, feedCloudMeta$StFeed.poster.f398463id.get());
        buildElementParams.put("xsj_action_type", QCircleDaTongConstant.ElementParamValue.DOWNLOAD_CLCK);
        if (q() != null) {
            buildElementParams.put("xsj_custom_pgid", q().getDtPageId());
        }
        VideoReport.reportEvent("ev_xsj_sharepanel_action", buildElementParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    public void G() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        QCircleShareInfo t16 = t();
        if (t16 != null && (feedCloudMeta$StFeed = t16.feed) != null) {
            M(feedCloudMeta$StFeed);
            L(t16.feed);
        } else {
            J("QFSSharePart");
        }
    }

    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    protected boolean y() {
        return false;
    }
}
