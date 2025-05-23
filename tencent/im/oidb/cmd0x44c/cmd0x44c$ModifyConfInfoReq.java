package tencent.im.oidb.cmd0x44c;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x44c$ModifyConfInfoReq extends MessageMicro<cmd0x44c$ModifyConfInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 48}, new String[]{"uint64_conf_uin", "uint32_last_passwd_red_bag_time", "uint32_conf_meeting_origin", "msg_self_member_info", "uint32_qidian_conf_type", "uint32_conf_meeting_option"}, new Object[]{0L, 0, 0, null, 0, 0}, cmd0x44c$ModifyConfInfoReq.class);
    public final PBUInt64Field uint64_conf_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_last_passwd_red_bag_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_conf_meeting_origin = PBField.initUInt32(0);
    public cmd0x44c$ModifySelfMemberInfo msg_self_member_info = new MessageMicro<cmd0x44c$ModifySelfMemberInfo>() { // from class: tencent.im.oidb.cmd0x44c.cmd0x44c$ModifySelfMemberInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_name_card"}, new Object[]{ByteStringMicro.EMPTY}, cmd0x44c$ModifySelfMemberInfo.class);
        public final PBBytesField bytes_name_card = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public final PBUInt32Field uint32_qidian_conf_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_conf_meeting_option = PBField.initUInt32(0);
}
