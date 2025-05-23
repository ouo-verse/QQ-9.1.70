package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRankinglist$SetUserScoreReq extends MessageMicro<QQCircleRankinglist$SetUserScoreReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 40}, new String[]{"extInfo", "listType", "listTime", "userScores", "listClass"}, new Object[]{null, 0, 0, null, 0}, QQCircleRankinglist$SetUserScoreReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBInt32Field listType = PBField.initInt32(0);
    public final PBUInt32Field listTime = PBField.initUInt32(0);
    public final PBRepeatMessageField<QQCircleRankinglist$UserScore> userScores = PBField.initRepeatMessage(QQCircleRankinglist$UserScore.class);
    public final PBInt32Field listClass = PBField.initInt32(0);
}
