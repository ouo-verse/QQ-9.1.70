package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRankinglist$BatchGetCircleFuelMedalRsp extends MessageMicro<QQCircleRankinglist$BatchGetCircleFuelMedalRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "data"}, new Object[]{null, null}, QQCircleRankinglist$BatchGetCircleFuelMedalRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<QQCircleRankinglist$CircleFuelMedalInfo> data = PBField.initRepeatMessage(QQCircleRankinglist$CircleFuelMedalInfo.class);
}
