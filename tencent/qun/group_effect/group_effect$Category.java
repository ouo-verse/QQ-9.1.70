package tencent.qun.group_effect;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class group_effect$Category extends MessageMicro<group_effect$Category> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 810}, new String[]{"name", "wording", "rpt_effect_id", "rpt_effect_info"}, new Object[]{"", "", 0, null}, group_effect$Category.class);
    public final PBStringField name = PBField.initString("");
    public final PBStringField wording = PBField.initString("");
    public final PBRepeatField<Integer> rpt_effect_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatMessageField<group_effect$EffectInfo> rpt_effect_info = PBField.initRepeatMessage(group_effect$EffectInfo.class);
}
