package tencent.im.s2c.msgtype0x210.submsgtype0x3b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Submsgtype0x3b$MsgBody extends MessageMicro<Submsgtype0x3b$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 56}, new String[]{"uint32_sub_cmd", "uint64_group_code", "uint32_user_show_flag", "uint32_member_level_changed", "uint32_officemode", "uint32_member_level_new_changed"}, new Object[]{0, 0L, 0, 0, 0, 0}, Submsgtype0x3b$MsgBody.class);
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt32Field uint32_user_show_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_member_level_changed = PBField.initUInt32(0);
    public final PBUInt32Field uint32_officemode = PBField.initUInt32(0);
    public final PBUInt32Field uint32_member_level_new_changed = PBField.initUInt32(0);
}
