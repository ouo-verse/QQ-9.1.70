package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRankinglist$IsCoreFanReq extends MessageMicro<QQCircleRankinglist$IsCoreFanReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"extInfo", "fanUid", "hostUid"}, new Object[]{null, "", ""}, QQCircleRankinglist$IsCoreFanReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatField<String> fanUid = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField hostUid = PBField.initString("");
}
