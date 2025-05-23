package tencent.qun.group_effect;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class group_effect_commu$TGetMyEffectReq0x2 extends MessageMicro<group_effect_commu$TGetMyEffectReq0x2> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"group_id"}, new Object[]{0L}, group_effect_commu$TGetMyEffectReq0x2.class);
    public final PBRepeatField<Long> group_id = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
