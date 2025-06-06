package tencent.im.s2c.msgtype0x210.submsgtype0x116;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0x116$MsgBody extends MessageMicro<submsgtype0x116$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 48}, new String[]{"rpt_msg_member_join", "rpt_msg_member_quit", "uint32_group_id", "uint32_room_id", "uint32_invite_list_total_count", "enum_event_type"}, new Object[]{null, null, 0, 0, 0, 1}, submsgtype0x116$MsgBody.class);
    public final PBRepeatMessageField<submsgtype0x116$MemberInfo> rpt_msg_member_join = PBField.initRepeatMessage(submsgtype0x116$MemberInfo.class);
    public final PBRepeatMessageField<submsgtype0x116$MemberInfo> rpt_msg_member_quit = PBField.initRepeatMessage(submsgtype0x116$MemberInfo.class);
    public final PBUInt32Field uint32_group_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_room_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_invite_list_total_count = PBField.initUInt32(0);
    public final PBEnumField enum_event_type = PBField.initEnum(1);
}
