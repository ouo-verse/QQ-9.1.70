package tencent.im.s2c.msgtype0x210.submsgtype0x116;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0x116$MemberInfo extends MessageMicro<submsgtype0x116$MemberInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint64_member_uin", "uint32_invite_timestamp", "uint32_terminal_type", "uint32_client_version"}, new Object[]{0L, 0, 0, 0}, submsgtype0x116$MemberInfo.class);
    public final PBUInt64Field uint64_member_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_invite_timestamp = PBField.initUInt32(0);
    public final PBUInt32Field uint32_terminal_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_client_version = PBField.initUInt32(0);
}
