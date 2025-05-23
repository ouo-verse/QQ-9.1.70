package tencent.im.oidb.cmd0x406;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x406$GroupFeeMemberListResult extends MessageMicro<cmd0x406$GroupFeeMemberListResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"int32_page_index", "uint32_member_type", "msg_member_list"}, new Object[]{0, 0, null}, cmd0x406$GroupFeeMemberListResult.class);
    public final PBInt32Field int32_page_index = PBField.initInt32(0);
    public final PBUInt32Field uint32_member_type = PBField.initUInt32(0);
    public final PBRepeatMessageField<cmd0x406$GroupFeeMember> msg_member_list = PBField.initRepeatMessage(cmd0x406$GroupFeeMember.class);
}
