package tencent.qun.group_effect;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class group_effect$EffectConfig extends MessageMicro<group_effect$EffectConfig> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"rpt_banner", "rpt_category"}, new Object[]{null, null}, group_effect$EffectConfig.class);
    public final PBRepeatMessageField<group_effect$Banner> rpt_banner = PBField.initRepeatMessage(group_effect$Banner.class);
    public final PBRepeatMessageField<group_effect$Category> rpt_category = PBField.initRepeatMessage(group_effect$Category.class);
}
