package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StDittoFeed;
import feedcloud.FeedCloudMeta$StImage;
import feedcloud.FeedCloudMeta$StTagInfo;

/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StTagPageData extends MessageMicro<QQCircleFeedBase$StTagPageData> {
    static final MessageMicro.FieldMap __fieldMap__;
    public FeedCloudMeta$StTagInfo tagInfo = new FeedCloudMeta$StTagInfo();
    public final PBStringField tagDesc = PBField.initString("");
    public final PBRepeatMessageField<QQCircleRankinglist$RankingItem> fuelCircleRankItem = PBField.initRepeatMessage(QQCircleRankinglist$RankingItem.class);
    public final PBRepeatMessageField<FeedCloudCommon$Entry> subsidiaryFieldDesc = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
    public final PBRepeatMessageField<FeedCloudCommon$Entry> urlInfo = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
    public final PBStringField rankName = PBField.initString("");
    public final PBStringField activityCopywritingDesc = PBField.initString("");
    public final PBStringField headBackgroundPic = PBField.initString("");
    public FeedCloudMeta$StDittoFeed dittoFeed = new FeedCloudMeta$StDittoFeed();
    public FeedCloudMeta$StImage coverInfo = new FeedCloudMeta$StImage();
    public final PBBoolField isShowTagMedal = PBField.initBool(false);
    public QQCircleFeedBase$MedalToast medalToast = new QQCircleFeedBase$MedalToast();
    public QQCircleFeedBase$StTagPageTabInfo tabInfo = new QQCircleFeedBase$StTagPageTabInfo();
    public final PBBoolField hideUserRankHintText = PBField.initBool(false);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 88, 98, 106, 112}, new String[]{"tagInfo", "tagDesc", "fuelCircleRankItem", "subsidiaryFieldDesc", "urlInfo", "rankName", "activityCopywritingDesc", "headBackgroundPic", "dittoFeed", "coverInfo", "isShowTagMedal", "medalToast", "tabInfo", "hideUserRankHintText"}, new Object[]{null, "", null, null, null, "", "", "", null, null, bool, null, null, bool}, QQCircleFeedBase$StTagPageData.class);
    }
}
