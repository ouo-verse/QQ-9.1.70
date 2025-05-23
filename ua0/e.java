package ua0;

import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StLiteBanner;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class e {
    public static void a(FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str) {
        FeedCloudMeta$StLiteBanner feedCloudMeta$StLiteBanner;
        int i3;
        if (feedCloudMeta$StFeed == null) {
            feedCloudMeta$StLiteBanner = null;
        } else {
            feedCloudMeta$StLiteBanner = feedCloudMeta$StFeed.liteBanner;
        }
        if (feedCloudMeta$StLiteBanner == null) {
            return;
        }
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_custom_pgid", str);
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_GUIDE_PANEL);
        if (feedCloudMeta$StLiteBanner.tianshuEntry.has()) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_GUIDE_PANEL_SOURCE, Integer.valueOf(i3));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_CUSTOMIZED_BUSINESS_TYPE, Integer.valueOf(feedCloudMeta$StLiteBanner.business_type.get()));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ACTIVITY_TASK_ID, feedCloudMeta$StLiteBanner.activityID.get());
        buildElementParams.put("xsj_operation_activity_id", feedCloudMeta$StLiteBanner.activityID.get());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_GAME_ID, QCirclePluginUtil.getValueFromListEntry(feedCloudMeta$StLiteBanner.extInfo.get(), QCircleDaTongConstant.ElementParamKey.XSJ_GAME_ID));
        VideoReport.reportEvent("ev_xsj_abnormal_clck", buildElementParams);
    }

    public static void b(FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str) {
        FeedCloudMeta$StLiteBanner feedCloudMeta$StLiteBanner;
        int i3;
        if (feedCloudMeta$StFeed == null) {
            feedCloudMeta$StLiteBanner = null;
        } else {
            feedCloudMeta$StLiteBanner = feedCloudMeta$StFeed.liteBanner;
        }
        if (feedCloudMeta$StLiteBanner == null) {
            return;
        }
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_custom_pgid", str);
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_GUIDE_PANEL);
        if (feedCloudMeta$StLiteBanner.tianshuEntry.has()) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_GUIDE_PANEL_SOURCE, Integer.valueOf(i3));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_CUSTOMIZED_BUSINESS_TYPE, Integer.valueOf(feedCloudMeta$StLiteBanner.business_type.get()));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ACTIVITY_TASK_ID, feedCloudMeta$StLiteBanner.activityID.get());
        buildElementParams.put("xsj_operation_activity_id", feedCloudMeta$StLiteBanner.activityID.get());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_GAME_ID, QCirclePluginUtil.getValueFromListEntry(feedCloudMeta$StLiteBanner.extInfo.get(), QCircleDaTongConstant.ElementParamKey.XSJ_GAME_ID));
        VideoReport.reportEvent("ev_xsj_abnormal_imp", buildElementParams);
    }
}
