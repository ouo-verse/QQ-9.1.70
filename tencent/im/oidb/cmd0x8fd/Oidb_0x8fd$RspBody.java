package tencent.im.oidb.cmd0x8fd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x8fd$RspBody extends MessageMicro<Oidb_0x8fd$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_grp_member_info"}, new Object[]{null}, Oidb_0x8fd$RspBody.class);
    public final PBRepeatMessageField<Oidb_0x8fd$GroupMemberInfo> rpt_msg_grp_member_info = PBField.initRepeatMessage(Oidb_0x8fd$GroupMemberInfo.class);
}
