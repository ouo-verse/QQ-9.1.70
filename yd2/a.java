package yd2;

import android.text.TextUtils;
import android.util.ArrayMap;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, String> f450194a;

    static {
        ArrayMap arrayMap = new ArrayMap();
        f450194a = arrayMap;
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_FOLLOWING_PAGE, "QCircleFollowingPage");
        arrayMap.put("pg_xsj_explore_page", "QCircleExplorePage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_NEARBY_PAGE, "QCircleNearbyPage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_LAYER_PAGE, "QCircleLayerPage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_FEED_DETAILS_AND_REC, "QCircleFeedDetailsAndRecPage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_PROFILE_ZUOPIN, "QCircleProfileZuoPinPage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_PROFILE_DONGTAI, "QCircleProfileDongTaiPage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_PROFILE_TUIGUO, "QCircleProfileTuiguoPage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_PROFILE_EDIT_PAGE, "QCircleProfileEditPage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_PORTFOLIO_POI, "QCirclePortfolioPoiPage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_PORTFOLIO_FILTER, "QCirclePortfolioFilterPage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_TOPIC_AGG_PAGE, "QCircleTopicAggPagePage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_CAMPUS_AGG_PAGE, "QCircleCampusAggPage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_MY_MESSAGE_PAGE, "QCircleMyMessagePage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_PRIVATE_MESSAGE_PAGE, "QCirclePrivateMessagePage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_MORE_PAGE, "QCircleMorePage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_FLOWPAGE_REC_BY_QZONE, "QCircleFlowpageRecByQzonePage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_FLOWPAGE_ROBOT_HASHTAG, "QCircleFlowpageRobotHashtagPage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_FLOWPAGE_ROBOT_DAILY_REPORT, "QCircleFlowpageRobotDailyReportPage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_FOLWPAGE_GROUP_UPDATES, "QCircleFlowpageGroupUpdatesPage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_CHOOSE_MEDIA_PAGE, "QCircleChooseMediaPage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_CHOOSE_PAGE_PREVIEW_PICS, "QCircleChoosePagePreviewPicsPage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_CHOOSE_PAGE_PREVIEW_VIDEOS, "QCircleChoosePagePreviewVideosPage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_SHOOTING_PAGE, "QCircleShootingPage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_EDIT_PICS, "QCircleEditPicsPage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_EDIT_VIDEOS, "QCircleEditVideosPage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_PUBLISH_PAGE, "QCirclePublishPage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_PUBLISH_PAGE_PREVIEW_PICS, "QCirclePublishPagePreviewPicsPage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_PUBLISH_PAGE_PREVIEW_VIDEOS, "QCirclePublishPagePreviewVideosPage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_PUBLISH_PAGE_POI, "QCirclePublishPagePoiPage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_NEW_ENTRY_PAGE, "QCircleNewEntryPage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_FEED_DETAILS_MIDDLE, "QCircleFeedDetailsAndRecV865Page");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_FLOWPAGE_REC_BY_QZONE_V865, "QCircleFlowpageRecByQzoneV865Page");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_FLOWPAGE_GROUP_UPDATES_V865, "QCircleFlowpageGroupUpdatesV865Page");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_REFLOW_ENTRY_PAGE, "QCircleReflowEntryPage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_FULL_SCREEN_PAGE, "QCircleFullScreenPage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_PUBLISH_DRAFTBOX_PAGE, "QCirclePublishDraftboxPage");
        arrayMap.put("pg_xsj_profile_page", "QCircleProfilePage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_RECENT_WATCHED_PAGE, "QCircleRecentWatchedPage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_MUSIC_AGG_PAGE, "QCircleMusicAggPage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_MATERIAL_AGG_PAGE, "QCircleMaterialAggPage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_DYH_FOLLOWING_PAGE, "QCircleFollowingPage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_DYH_EXPLORE_PAGE, "QCircleExplorePage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_SETTING_PRIVACY_PAGE, "QCircleSettingPrivacyPage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_ATLAS_LAYER_PAGE, "QCircleAtlasLayerPage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_CIRCLE_PICTEXT_PAGE, "QCirclePictextPage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_PLAYER_SETTING_PAGE, "QCirclePlayerSettingPage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_ALBUM_PAGE, "QCircleAlbumPage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_INFORM_SETTING_PAGE, "QCircleInformSettingPage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_TOPIC_CHALLENGE_AGG_PAGE, "QCircleTopicChallengeAggPage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_CIRCLE_SELECTED_PAGE, "QCircleSelectedPage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_SEARCH_PAGE, "QCircleSearchPage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_SEARCH_RESULT_PAGE, "QCircleSearchResultPage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_SEARCH_CONNECTIVE_PAGE, "QCircleSearchConnectivePage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_TOPIC_VERTICAL_SEARCH_PAGE, "QCircleTopicVerticalSearchPage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_USER_VERTICAL_SEARCH_PAGE, "QCircleUserVerticalSearchPage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_PRIVATE_VIDEO_DETAIL_PAGE, "QCirclePrivateVideoDetailPage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_NEW_MESSAGE_PAGE, "QCircleNewMessagePage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_NEW_MESSAGE_FEATURE_PAGE, "QCircleNewMessageFeaturePage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_NEW_MESSAGE_DRAWER_PAGE, "QCircleMessageDrawerPage");
        arrayMap.put(QCircleDaTongConstant.PageId.PG_XSJ_MESSAGE_BOX_PAGE, "QCircleMessageBoxPage");
        arrayMap.put(QCircleDaTongConstant.ElementId.EM_XSJ_CMTPANEL, "QCircleCommentPanelPage");
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return f450194a.get(str);
    }
}
