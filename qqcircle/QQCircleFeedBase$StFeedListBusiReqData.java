package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import feedcloud.FeedCloudMeta$FeedAlbum;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StFeedMusic;
import feedcloud.FeedCloudMeta$StGPSV2;
import feedcloud.FeedCloudMeta$StUnifiedTag;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StFeedListBusiReqData extends MessageMicro<QQCircleFeedBase$StFeedListBusiReqData> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField tabAttachInfo = PBField.initString("");
    public FeedCloudMeta$StGPSV2 gpsInfo = new FeedCloudMeta$StGPSV2();
    public final PBBoolField isReqLayer = PBField.initBool(false);
    public final PBStringField tagId = PBField.initString("");
    public final PBStringField tagName = PBField.initString("");
    public final PBBoolField noRecom = PBField.initBool(false);
    public final PBStringField refreshAttachInfo = PBField.initString("");
    public FeedCloudMeta$StFeed detailFeed = new FeedCloudMeta$StFeed();
    public final PBUInt64Field groupNumber = PBField.initUInt64(0);
    public QQCircleFeedBase$StSimulateData simulateInfo = new QQCircleFeedBase$StSimulateData();
    public final PBInt32Field pullSceneType = PBField.initInt32(0);
    public final PBStringField schemaTrans = PBField.initString("");
    public QQCircleFeedBase$StPageRedPointInfo RedPointInfo = new QQCircleFeedBase$StPageRedPointInfo();
    public final PBStringField entrySchema = PBField.initString("");
    public final PBBoolField isCloudSealReq = PBField.initBool(false);
    public final PBUInt32Field pymkSourcePage = PBField.initUInt32(0);
    public final PBBoolField isNewPageStyle = PBField.initBool(false);
    public final PBEnumField allPushPageLayoutType = PBField.initEnum(1);
    public final PBStringField lightSDKVersion = PBField.initString("");
    public final PBEnumField pageLayoutType = PBField.initEnum(1);
    public final PBInt64Field lastPrePullAt = PBField.initInt64(0);
    public FeedCloudMeta$StFeedMusic musicInfo = new FeedCloudMeta$StFeedMusic();
    public FeedCloudMeta$StUnifiedTag unifiedTagInfo = new FeedCloudMeta$StUnifiedTag();
    public QQCircleFeedBase$StGetPrePullInfoReq getPrePullInfoReq = new MessageMicro<QQCircleFeedBase$StGetPrePullInfoReq>() { // from class: qqcircle.QQCircleFeedBase$StGetPrePullInfoReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"prePullT", "entranceMod", "prePullMD"}, new Object[]{0, 0, null}, QQCircleFeedBase$StGetPrePullInfoReq.class);
        public final PBEnumField prePullT = PBField.initEnum(0);
        public final PBEnumField entranceMod = PBField.initEnum(0);
        public QQCircleFeedBase$PrePullMetaData prePullMD = new QQCircleFeedBase$PrePullMetaData();
    };
    public QQCircleFeedBase$StGetPrePullInfoReqV2 getPrePullInfoReqV2 = new QQCircleFeedBase$StGetPrePullInfoReqV2();
    public FeedCloudMeta$FeedAlbum album_info = new FeedCloudMeta$FeedAlbum();
    public QQCircleFeedBase$StTagChallengePageReq tagChallengePageReq = new QQCircleFeedBase$StTagChallengePageReq();
    public QQCircleFeedBase$StMainPageSortFeedListReq mainPageSortFeedListReq = new QQCircleFeedBase$StMainPageSortFeedListReq();
    public QQCircleFeedBase$StViewedFeedData viewed_feed_data = new QQCircleFeedBase$StViewedFeedData();
    public QQCircleFeedBase$StFavoritesFeedsPageReq favoritesFeedsPage = new QQCircleFeedBase$StFavoritesFeedsPageReq();

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 48, 58, 66, 72, 90, 96, 106, 114, 122, 128, 136, 144, 152, 162, 168, 176, 186, 194, 202, 210, 218, 226, 234, 242, 250}, new String[]{"tabAttachInfo", "gpsInfo", "isReqLayer", "tagId", "tagName", "noRecom", "refreshAttachInfo", "detailFeed", "groupNumber", "simulateInfo", "pullSceneType", "schemaTrans", "RedPointInfo", "entrySchema", "isCloudSealReq", "pymkSourcePage", "isNewPageStyle", "allPushPageLayoutType", "lightSDKVersion", "pageLayoutType", "lastPrePullAt", "musicInfo", "unifiedTagInfo", "getPrePullInfoReq", "getPrePullInfoReqV2", "album_info", "tagChallengePageReq", "mainPageSortFeedListReq", "viewed_feed_data", "favoritesFeedsPage"}, new Object[]{"", null, bool, "", "", bool, "", null, 0L, null, 0, "", null, "", bool, 0, bool, 1, "", 1, 0L, null, null, null, null, null, null, null, null, null}, QQCircleFeedBase$StFeedListBusiReqData.class);
    }
}
