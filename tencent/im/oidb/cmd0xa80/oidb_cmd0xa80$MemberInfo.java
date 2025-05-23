package tencent.im.oidb.cmd0xa80;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xa80$MemberInfo extends MessageMicro<oidb_cmd0xa80$MemberInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72}, new String[]{"uint64_member_uin", "uint64_flag_ex_pos", "uint32_heartbeat_time", "uint64_group_msg_mask", "uint32_group_msg_hide_switch", "uint32_group_msg_preview_switch", "uint32_group_ringtone_switch", "uint32_group_vibrate_switch", "uint32_group_ringtone_id"}, new Object[]{0L, 0L, 0, 0L, 0, 0, 0, 0, 0}, oidb_cmd0xa80$MemberInfo.class);
    public final PBUInt64Field uint64_member_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_flag_ex_pos = PBField.initUInt64(0);
    public final PBUInt32Field uint32_heartbeat_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_msg_mask = PBField.initUInt64(0);
    public final PBUInt32Field uint32_group_msg_hide_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_msg_preview_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_ringtone_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_vibrate_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_ringtone_id = PBField.initUInt32(0);
}
