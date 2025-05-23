package qqcircle;

import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StExternalMedalWallInfo;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StFollowRecomInfo;
import feedcloud.FeedCloudMeta$StGuidePublishBubble;
import feedcloud.FeedCloudMeta$StShare;
import feedcloud.FeedCloudMeta$StUser;

/* loaded from: classes29.dex */
public final class QQCircleMainPageProfile$GetQQProfileFeedListRsp extends MessageMicro<QQCircleMainPageProfile$GetQQProfileFeedListRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField busiPublisherEntrance;
    public final PBBytesField busiRspData;
    public final PBUInt32Field fansValueStyle;
    public FeedCloudMeta$StFollowRecomInfo followRecomInfo;
    public FeedCloudMeta$StGuidePublishBubble guidePublishBubble;
    public final PBBoolField isFirstLogin;
    public final PBUInt32Field isPenguinUser;
    public final PBUInt32Field likedFeedCount;
    public final PBUInt32Field likedNum;
    public FeedCloudMeta$StExternalMedalWallInfo medalWall;
    public final PBUInt32Field newAddedFansCount;
    public final PBStringField pmBeginShow;
    public final PBUInt32Field pushRocketCount;
    public final PBEnumField videoPlayCtl;
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public FeedCloudMeta$StUser user = new FeedCloudMeta$StUser();
    public final PBUInt32Field feedCount = PBField.initUInt32(0);
    public final PBUInt32Field fansCount = PBField.initUInt32(0);
    public final PBUInt32Field followCount = PBField.initUInt32(0);
    public final PBRepeatMessageField<FeedCloudMeta$StFeed> vecFeed = PBField.initRepeatMessage(FeedCloudMeta$StFeed.class);
    public final PBUInt32Field isFinish = PBField.initUInt32(0);
    public FeedCloudMeta$StShare share = new FeedCloudMeta$StShare();
    public final PBStringField feedAttchInfo = PBField.initString("");

    static {
        String[] strArr = {"extInfo", QCircleAlphaUserReporter.KEY_USER, QFSSearchBaseRequest.EXTRA_KEY_FEED_COUNT, "fansCount", "followCount", "vecFeed", "isFinish", "share", "feedAttchInfo", "busiRspData", "pmBeginShow", "fansValueStyle", "guidePublishBubble", "isFirstLogin", "pushRocketCount", "followRecomInfo", "medalWall", "likedNum", "likedFeedCount", "isPenguinUser", "busiPublisherEntrance", "newAddedFansCount", "videoPlayCtl"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 50, 56, 66, 74, 82, 90, 96, 106, 112, 120, 130, 138, 144, 152, 160, 170, 176, 200}, strArr, new Object[]{null, null, 0, 0, 0, null, 0, null, "", byteStringMicro, "", 0, null, Boolean.FALSE, 0, null, null, 0, 0, 0, byteStringMicro, 0, 0}, QQCircleMainPageProfile$GetQQProfileFeedListRsp.class);
    }

    public QQCircleMainPageProfile$GetQQProfileFeedListRsp() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.busiRspData = PBField.initBytes(byteStringMicro);
        this.pmBeginShow = PBField.initString("");
        this.fansValueStyle = PBField.initUInt32(0);
        this.guidePublishBubble = new FeedCloudMeta$StGuidePublishBubble();
        this.isFirstLogin = PBField.initBool(false);
        this.pushRocketCount = PBField.initUInt32(0);
        this.followRecomInfo = new FeedCloudMeta$StFollowRecomInfo();
        this.medalWall = new FeedCloudMeta$StExternalMedalWallInfo();
        this.likedNum = PBField.initUInt32(0);
        this.likedFeedCount = PBField.initUInt32(0);
        this.isPenguinUser = PBField.initUInt32(0);
        this.busiPublisherEntrance = PBField.initBytes(byteStringMicro);
        this.newAddedFansCount = PBField.initUInt32(0);
        this.videoPlayCtl = PBField.initEnum(0);
    }
}
