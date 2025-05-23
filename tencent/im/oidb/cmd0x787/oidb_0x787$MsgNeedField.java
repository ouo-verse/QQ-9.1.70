package tencent.im.oidb.cmd0x787;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x787$MsgNeedField extends MessageMicro<oidb_0x787$MsgNeedField> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_cmduin_flagex3_grocery", "rpt_member_icon"}, new Object[]{0, null}, oidb_0x787$MsgNeedField.class);
    public final PBUInt32Field uint32_cmduin_flagex3_grocery = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_0x787$MemberIcon> rpt_member_icon = PBField.initRepeatMessage(oidb_0x787$MemberIcon.class);
}
