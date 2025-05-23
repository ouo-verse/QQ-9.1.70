package qqcircle;

import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StRelationInfo;
import feedcloud.FeedCloudMeta$StUser;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRankinglist$CreatorRankItem extends MessageMicro<QQCircleRankinglist$CreatorRankItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 50, 56, 64}, new String[]{QCircleAlphaUserReporter.KEY_USER, MessageForQCircleFeed.MSG_QCIRCLE_FEED_LEY_BUSI_DATA, "relation", "rankNo", "feeds", "recReasonText", "interactionIdx", "newStarIdx"}, new Object[]{null, null, null, 0, null, "", 0L, 0L}, QQCircleRankinglist$CreatorRankItem.class);
    public FeedCloudMeta$StUser user = new FeedCloudMeta$StUser();
    public QQCircleRankinglist$RankItemBusiData busiData = new MessageMicro<QQCircleRankinglist$RankItemBusiData>() { // from class: qqcircle.QQCircleRankinglist$RankItemBusiData
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50, 58, 66, 74}, new String[]{"fansNum", "followNum", "feedNum", "certification", "purpleVDesc", "blueVDesc", "recDesc", "intro", "eUID"}, new Object[]{0L, 0L, 0, 0, "", "", "", "", ""}, QQCircleRankinglist$RankItemBusiData.class);
        public final PBInt64Field fansNum = PBField.initInt64(0);
        public final PBInt64Field followNum = PBField.initInt64(0);
        public final PBInt32Field feedNum = PBField.initInt32(0);
        public final PBInt32Field certification = PBField.initInt32(0);
        public final PBStringField purpleVDesc = PBField.initString("");
        public final PBStringField blueVDesc = PBField.initString("");
        public final PBStringField recDesc = PBField.initString("");
        public final PBStringField intro = PBField.initString("");
        public final PBStringField eUID = PBField.initString("");
    };
    public FeedCloudMeta$StRelationInfo relation = new FeedCloudMeta$StRelationInfo();
    public final PBInt32Field rankNo = PBField.initInt32(0);
    public final PBRepeatMessageField<FeedCloudMeta$StFeed> feeds = PBField.initRepeatMessage(FeedCloudMeta$StFeed.class);
    public final PBStringField recReasonText = PBField.initString("");
    public final PBInt64Field interactionIdx = PBField.initInt64(0);
    public final PBInt64Field newStarIdx = PBField.initInt64(0);
}
