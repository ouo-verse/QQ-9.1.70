package tencent.im.oidb.cmd0x8fd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x8fd$GroupMemberInfo extends MessageMicro<Oidb_0x8fd$GroupMemberInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"uint64_group_code", "uint32_show_flag", "uint32_sys_show_flag", "rpt_msg_level_name"}, new Object[]{0L, 0, 0, null}, Oidb_0x8fd$GroupMemberInfo.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt32Field uint32_show_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sys_show_flag = PBField.initUInt32(0);
    public final PBRepeatMessageField<Oidb_0x8fd$LevelName> rpt_msg_level_name = PBField.initRepeatMessage(Oidb_0x8fd$LevelName.class);
}
