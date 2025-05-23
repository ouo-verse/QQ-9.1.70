package tencent.qun.group_effect;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class group_effect$EffectIndex extends MessageMicro<group_effect$EffectIndex> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"rpt_effect_id"}, new Object[]{0}, group_effect$EffectIndex.class);
    public final PBRepeatField<Integer> rpt_effect_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}
