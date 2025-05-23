package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRelation$BatchVerifyRelationReq extends MessageMicro<QQCircleRelation$BatchVerifyRelationReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uins", "followMethod"}, new Object[]{0L, 0}, QQCircleRelation$BatchVerifyRelationReq.class);
    public final PBRepeatField<Long> uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field followMethod = PBField.initUInt32(0);
}
