package tencent.im.oidb.cmd0x989;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import tencent.qun.group_effect.group_effect$EffectInfo;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x989$RspBody extends MessageMicro<oidb_0x989$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"wording", "effect_info"}, new Object[]{"", null}, oidb_0x989$RspBody.class);
    public final PBStringField wording = PBField.initString("");
    public group_effect$EffectInfo effect_info = new group_effect$EffectInfo();
}
