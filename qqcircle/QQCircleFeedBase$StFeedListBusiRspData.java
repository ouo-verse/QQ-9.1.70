package qqcircle;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.view.FilterEnum;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StDittoFeed;
import feedcloud.FeedCloudMeta$StImage;
import feedcloud.FeedCloudMeta$StTagInfo;
import feedcloud.FeedCloudMeta$StUser;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StFeedListBusiRspData extends MessageMicro<QQCircleFeedBase$StFeedListBusiRspData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 56, 64, 74, 82, 88, 98, 106, 114, 122, 130, 138, 144, 154, 160, 170, 178, 186, 194, 202, 210, 218, 226, 234, 242, 250, 258, 266, 274, FilterEnum.MIC_PTU_BAIXI, 290, 298, 306, 314}, new String[]{"exploredPageData", "schoolPageData", "campanyPageData", "cityPageData", "tagPageData", "followPageData", "NoUse", "opMask", "refreshAttachInfo", "gpsPageData", "rspTimestamp", "fashionCopyPageData", "newUserPymkPageData", "commSchemaCollectPageData", "schemaTrans", "homeButtonBubbleData", "backflowPymkPageData", "pageLayoutType", "photoSelectorRecomPageData", "rspExpireAt", "musicPageData", "unifiedTagPageData", "qqSubscriptionPageData", "getPrePullInfoRsp", "entrySchema", "publisherButton", "getPrePullInfoRspV2", "middlePageData", "album_page_data", "bannerData", "tagChallengePageRsp", "editProfileButton", "recentWatchPageData", "hotTagData", "pushBoxInfo", "searchBubbleInfo", "activityPublisherButton", "galleryQzoneEmptyPageData", "favoritesFeedsPageRsp"}, new Object[]{null, null, null, null, null, null, 0, 0, "", null, 0L, null, null, null, "", null, null, 1, null, 0L, null, null, null, null, "", null, null, null, null, null, null, null, null, null, null, null, null, null, null}, QQCircleFeedBase$StFeedListBusiRspData.class);
    public final PBRepeatField<Integer> NoUse;
    public QQCircleFeedBase$StPublisherButton activityPublisherButton;
    public QQCircleFeedBase$AlbumPageData album_page_data;
    public QQCircleFeedBase$StBackflowPymkPageData backflowPymkPageData;
    public final PBRepeatMessageField<FeedCloudMeta$StDittoFeed> bannerData;
    public QQCircleFeedBase$StCommSchemaCollectPageData commSchemaCollectPageData;
    public QQCircleFeedBase$StEditProfileButton editProfileButton;
    public final PBStringField entrySchema;
    public QQCircleFeedBase$StFashionCopyPageData fashionCopyPageData;
    public QQCircleFeedBase$StFavoritesFeedsPageRsp favoritesFeedsPageRsp;
    public QQCircleFeedBase$StGalleryQzoneEmptyPageData galleryQzoneEmptyPageData;
    public QQCircleFeedBase$StGetPrePullInfoRsp getPrePullInfoRsp;
    public QQCircleFeedBase$StGetPrePullInfoRspV2 getPrePullInfoRspV2;
    public QQCircleFeedBase$StGpsPageData gpsPageData;
    public QQCircleFeedBase$StHomeButtonBubbleData homeButtonBubbleData;
    public QQCircleFeedBase$StHotTagData hotTagData;
    public QQCircleFeedBase$StMiddlePageData middlePageData;
    public QQCircleFeedBase$StMusicPageData musicPageData;
    public QQCircleFeedBase$StNewUserPymkPageData newUserPymkPageData;
    public final PBRepeatField<Integer> opMask;
    public final PBEnumField pageLayoutType;
    public QQCircleFeedBase$StPhotoSelectorRecomPageData photoSelectorRecomPageData;
    public QQCircleFeedBase$StPublisherButton publisherButton;
    public QQCircleFeedBase$StUserPushBoxInfo pushBoxInfo;
    public QQCircleFeedBase$StQQSubscriptionPageData qqSubscriptionPageData;
    public QQCircleFeedBase$StRecentWatchPageData recentWatchPageData;
    public final PBStringField refreshAttachInfo;
    public final PBInt64Field rspExpireAt;
    public final PBInt64Field rspTimestamp;
    public final PBStringField schemaTrans;
    public QQCircleFeedBase$StSearchBubbleInfo searchBubbleInfo;
    public QQCircleFeedBase$StTagChallengePageRsp tagChallengePageRsp;
    public QQCircleFeedBase$StUnifiedTagPageData unifiedTagPageData;
    public QQCircleFeedBase$StExplorePageData exploredPageData = new MessageMicro<QQCircleFeedBase$StExplorePageData>() { // from class: qqcircle.QQCircleFeedBase$StExplorePageData
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"recomTagList"}, new Object[]{null}, QQCircleFeedBase$StExplorePageData.class);
        public final PBRepeatMessageField<FeedCloudMeta$StTagInfo> recomTagList = PBField.initRepeatMessage(FeedCloudMeta$StTagInfo.class);
    };
    public QQCircleFeedBase$StSchoolPageData schoolPageData = new QQCircleFeedBase$StSchoolPageData();
    public QQCircleFeedBase$StCampanyPageData campanyPageData = new MessageMicro<QQCircleFeedBase$StCampanyPageData>() { // from class: qqcircle.QQCircleFeedBase$StCampanyPageData
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"campanyName"}, new Object[]{""}, QQCircleFeedBase$StCampanyPageData.class);
        public final PBStringField campanyName = PBField.initString("");
    };
    public QQCircleFeedBase$StCityPageData cityPageData = new MessageMicro<QQCircleFeedBase$StCityPageData>() { // from class: qqcircle.QQCircleFeedBase$StCityPageData
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"cityName", "pageAttachBusiInfo"}, new Object[]{"", null}, QQCircleFeedBase$StCityPageData.class);
        public final PBStringField cityName = PBField.initString("");
        public final PBRepeatMessageField<FeedCloudCommon$Entry> pageAttachBusiInfo = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
    };
    public QQCircleFeedBase$StTagPageData tagPageData = new QQCircleFeedBase$StTagPageData();
    public QQCircleFeedBase$StFollowPageData followPageData = new MessageMicro<QQCircleFeedBase$StFollowPageData>() { // from class: qqcircle.QQCircleFeedBase$StFollowPageData
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"recomCircileCertification", "tipsTitle", "dittoFeed", "busiReport"}, new Object[]{null, "", null, ByteStringMicro.EMPTY}, QQCircleFeedBase$StFollowPageData.class);
        public QQCircleBase$UserCircleInfo recomCircileCertification = new QQCircleBase$UserCircleInfo();
        public final PBStringField tipsTitle = PBField.initString("");
        public FeedCloudMeta$StDittoFeed dittoFeed = new FeedCloudMeta$StDittoFeed();
        public final PBBytesField busiReport = PBField.initBytes(ByteStringMicro.EMPTY);
    };

    /* JADX WARN: Type inference failed for: r0v0, types: [qqcircle.QQCircleFeedBase$StExplorePageData] */
    /* JADX WARN: Type inference failed for: r0v2, types: [qqcircle.QQCircleFeedBase$StCampanyPageData] */
    /* JADX WARN: Type inference failed for: r0v21, types: [qqcircle.QQCircleFeedBase$StSearchBubbleInfo] */
    /* JADX WARN: Type inference failed for: r0v23, types: [qqcircle.QQCircleFeedBase$StGalleryQzoneEmptyPageData] */
    /* JADX WARN: Type inference failed for: r0v3, types: [qqcircle.QQCircleFeedBase$StCityPageData] */
    /* JADX WARN: Type inference failed for: r0v5, types: [qqcircle.QQCircleFeedBase$StFollowPageData] */
    /* JADX WARN: Type inference failed for: r1v8, types: [qqcircle.QQCircleFeedBase$StGetPrePullInfoRsp] */
    /* JADX WARN: Type inference failed for: r3v2, types: [qqcircle.QQCircleFeedBase$StNewUserPymkPageData] */
    /* JADX WARN: Type inference failed for: r3v3, types: [qqcircle.QQCircleFeedBase$StCommSchemaCollectPageData] */
    /* JADX WARN: Type inference failed for: r3v5, types: [qqcircle.QQCircleFeedBase$StHomeButtonBubbleData] */
    /* JADX WARN: Type inference failed for: r3v6, types: [qqcircle.QQCircleFeedBase$StBackflowPymkPageData] */
    /* JADX WARN: Type inference failed for: r3v9, types: [qqcircle.QQCircleFeedBase$StPhotoSelectorRecomPageData] */
    public QQCircleFeedBase$StFeedListBusiRspData() {
        PBUInt32Field pBUInt32Field = PBUInt32Field.__repeatHelper__;
        this.NoUse = PBField.initRepeat(pBUInt32Field);
        this.opMask = PBField.initRepeat(pBUInt32Field);
        this.refreshAttachInfo = PBField.initString("");
        this.gpsPageData = new QQCircleFeedBase$StGpsPageData();
        this.rspTimestamp = PBField.initInt64(0L);
        this.fashionCopyPageData = new QQCircleFeedBase$StFashionCopyPageData();
        this.newUserPymkPageData = new MessageMicro<QQCircleFeedBase$StNewUserPymkPageData>() { // from class: qqcircle.QQCircleFeedBase$StNewUserPymkPageData
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"backgroundImage", "friends", "content"}, new Object[]{null, null, ""}, QQCircleFeedBase$StNewUserPymkPageData.class);
            public FeedCloudMeta$StImage backgroundImage = new FeedCloudMeta$StImage();
            public final PBRepeatMessageField<FeedCloudMeta$StUser> friends = PBField.initRepeatMessage(FeedCloudMeta$StUser.class);
            public final PBStringField content = PBField.initString("");
        };
        this.commSchemaCollectPageData = new MessageMicro<QQCircleFeedBase$StCommSchemaCollectPageData>() { // from class: qqcircle.QQCircleFeedBase$StCommSchemaCollectPageData
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"title"}, new Object[]{""}, QQCircleFeedBase$StCommSchemaCollectPageData.class);
            public final PBStringField title = PBField.initString("");
        };
        this.schemaTrans = PBField.initString("");
        this.homeButtonBubbleData = new MessageMicro<QQCircleFeedBase$StHomeButtonBubbleData>() { // from class: qqcircle.QQCircleFeedBase$StHomeButtonBubbleData
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"triggerFeedIndex"}, new Object[]{0}, QQCircleFeedBase$StHomeButtonBubbleData.class);
            public final PBUInt32Field triggerFeedIndex = PBField.initUInt32(0);
        };
        this.backflowPymkPageData = new MessageMicro<QQCircleFeedBase$StBackflowPymkPageData>() { // from class: qqcircle.QQCircleFeedBase$StBackflowPymkPageData
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50}, new String[]{"enterBackflowTimestamp", "isFrequencyHit", "backgroundImage", "backflowPymkDescEntry", "friends", "content"}, new Object[]{0L, Boolean.FALSE, null, null, null, ""}, QQCircleFeedBase$StBackflowPymkPageData.class);
            public final PBUInt64Field enterBackflowTimestamp = PBField.initUInt64(0);
            public final PBBoolField isFrequencyHit = PBField.initBool(false);
            public FeedCloudMeta$StImage backgroundImage = new FeedCloudMeta$StImage();
            public final PBRepeatMessageField<QQCircleFeedBase$BackflowPymkDescEntry> backflowPymkDescEntry = PBField.initRepeatMessage(QQCircleFeedBase$BackflowPymkDescEntry.class);
            public final PBRepeatMessageField<FeedCloudMeta$StUser> friends = PBField.initRepeatMessage(FeedCloudMeta$StUser.class);
            public final PBStringField content = PBField.initString("");
        };
        this.pageLayoutType = PBField.initEnum(1);
        this.photoSelectorRecomPageData = new MessageMicro<QQCircleFeedBase$StPhotoSelectorRecomPageData>() { // from class: qqcircle.QQCircleFeedBase$StPhotoSelectorRecomPageData
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"isNegative"}, new Object[]{Boolean.FALSE}, QQCircleFeedBase$StPhotoSelectorRecomPageData.class);
            public final PBBoolField isNegative = PBField.initBool(false);
        };
        this.rspExpireAt = PBField.initInt64(0L);
        this.musicPageData = new QQCircleFeedBase$StMusicPageData();
        this.unifiedTagPageData = new QQCircleFeedBase$StUnifiedTagPageData();
        this.qqSubscriptionPageData = new QQCircleFeedBase$StQQSubscriptionPageData();
        this.getPrePullInfoRsp = new MessageMicro<QQCircleFeedBase$StGetPrePullInfoRsp>() { // from class: qqcircle.QQCircleFeedBase$StGetPrePullInfoRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"prePullMD"}, new Object[]{null}, QQCircleFeedBase$StGetPrePullInfoRsp.class);
            public QQCircleFeedBase$PrePullMetaData prePullMD = new QQCircleFeedBase$PrePullMetaData();
        };
        this.entrySchema = PBField.initString("");
        this.publisherButton = new QQCircleFeedBase$StPublisherButton();
        this.getPrePullInfoRspV2 = new QQCircleFeedBase$StGetPrePullInfoRspV2();
        this.middlePageData = new QQCircleFeedBase$StMiddlePageData();
        this.album_page_data = new QQCircleFeedBase$AlbumPageData();
        this.bannerData = PBField.initRepeatMessage(FeedCloudMeta$StDittoFeed.class);
        this.tagChallengePageRsp = new QQCircleFeedBase$StTagChallengePageRsp();
        this.editProfileButton = new QQCircleFeedBase$StEditProfileButton();
        this.recentWatchPageData = new QQCircleFeedBase$StRecentWatchPageData();
        this.hotTagData = new QQCircleFeedBase$StHotTagData();
        this.pushBoxInfo = new QQCircleFeedBase$StUserPushBoxInfo();
        this.searchBubbleInfo = new MessageMicro<QQCircleFeedBase$StSearchBubbleInfo>() { // from class: qqcircle.QQCircleFeedBase$StSearchBubbleInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48}, new String[]{"texts", "count", "timeout", "position", "duration", WidgetCacheConstellationData.INTERVAL}, new Object[]{null, 0, 0L, 0, 0L, 0L}, QQCircleFeedBase$StSearchBubbleInfo.class);
            public final PBRepeatMessageField<QQCircleFeedBase$SearchText> texts = PBField.initRepeatMessage(QQCircleFeedBase$SearchText.class);
            public final PBUInt32Field count = PBField.initUInt32(0);
            public final PBInt64Field timeout = PBField.initInt64(0);
            public final PBUInt32Field position = PBField.initUInt32(0);
            public final PBInt64Field duration = PBField.initInt64(0);
            public final PBInt64Field interval = PBField.initInt64(0);
        };
        this.activityPublisherButton = new QQCircleFeedBase$StPublisherButton();
        this.galleryQzoneEmptyPageData = new MessageMicro<QQCircleFeedBase$StGalleryQzoneEmptyPageData>() { // from class: qqcircle.QQCircleFeedBase$StGalleryQzoneEmptyPageData
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], QQCircleFeedBase$StGalleryQzoneEmptyPageData.class);
        };
        this.favoritesFeedsPageRsp = new QQCircleFeedBase$StFavoritesFeedsPageRsp();
    }
}
