package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StImage;
import feedcloud.FeedCloudMeta$StShare;

/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StSchoolPageData extends MessageMicro<QQCircleFeedBase$StSchoolPageData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 64, 74}, new String[]{"schoolName", "coverInfo", "subsidiaryFieldDesc", "pageCopywritingDesc", "fuelCircleRankItem", "urlInfo", "rankName", "guildType", "shareInfo"}, new Object[]{"", null, null, "", null, null, "", 0, null}, QQCircleFeedBase$StSchoolPageData.class);
    public final PBStringField schoolName = PBField.initString("");
    public FeedCloudMeta$StImage coverInfo = new FeedCloudMeta$StImage();
    public final PBRepeatMessageField<FeedCloudCommon$Entry> subsidiaryFieldDesc = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
    public final PBStringField pageCopywritingDesc = PBField.initString("");
    public final PBRepeatMessageField<QQCircleRankinglist$RankingItem> fuelCircleRankItem = PBField.initRepeatMessage(QQCircleRankinglist$RankingItem.class);
    public final PBRepeatMessageField<FeedCloudCommon$Entry> urlInfo = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
    public final PBStringField rankName = PBField.initString("");
    public final PBEnumField guildType = PBField.initEnum(0);
    public FeedCloudMeta$StShare shareInfo = new FeedCloudMeta$StShare();
}
