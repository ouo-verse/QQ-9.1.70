package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRight$BatchVerifyCircleUnCareReq extends MessageMicro<QQCircleRight$BatchVerifyCircleUnCareReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40}, new String[]{"extInfo", "uins", "verUncare", "verBlack", "verifyType"}, new Object[]{null, 0L, 0, 0, 0}, QQCircleRight$BatchVerifyCircleUnCareReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatField<Long> uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBInt32Field verUncare = PBField.initInt32(0);
    public final PBInt32Field verBlack = PBField.initInt32(0);
    public final PBInt32Field verifyType = PBField.initInt32(0);
}
