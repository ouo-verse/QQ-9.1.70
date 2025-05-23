package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRankinglist$SetCircleFuelRankScoreReq extends MessageMicro<QQCircleRankinglist$SetCircleFuelRankScoreReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 24, 34, 42}, new String[]{"extInfo", "listTime", "userScores", "tid"}, new Object[]{null, 0, null, ""}, QQCircleRankinglist$SetCircleFuelRankScoreReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBUInt32Field listTime = PBField.initUInt32(0);
    public final PBRepeatMessageField<QQCircleRankinglist$UserScore> userScores = PBField.initRepeatMessage(QQCircleRankinglist$UserScore.class);
    public final PBStringField tid = PBField.initString("");
}
