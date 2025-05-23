package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class QQCircleProfile$StBatchGetUserIconDecorateReq extends MessageMicro<QQCircleProfile$StBatchGetUserIconDecorateReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uin"}, new Object[]{0}, QQCircleProfile$StBatchGetUserIconDecorateReq.class);
    public final PBRepeatField<Integer> uin = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}
