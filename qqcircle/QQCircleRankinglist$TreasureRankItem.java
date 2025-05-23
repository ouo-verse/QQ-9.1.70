package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import feedcloud.FeedCloudMeta$StUser;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRankinglist$TreasureRankItem extends MessageMicro<QQCircleRankinglist$TreasureRankItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34}, new String[]{QCircleAlphaUserReporter.KEY_USER, "RankNo", "rocketNum", "rankImg"}, new Object[]{null, 0, 0L, ""}, QQCircleRankinglist$TreasureRankItem.class);
    public FeedCloudMeta$StUser user = new FeedCloudMeta$StUser();
    public final PBInt32Field RankNo = PBField.initInt32(0);
    public final PBUInt64Field rocketNum = PBField.initUInt64(0);
    public final PBStringField rankImg = PBField.initString("");
}
