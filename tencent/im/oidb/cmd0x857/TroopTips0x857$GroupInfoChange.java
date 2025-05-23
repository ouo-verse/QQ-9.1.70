package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TroopTips0x857$GroupInfoChange extends MessageMicro<TroopTips0x857$GroupInfoChange> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104}, new String[]{"uint32_group_honor_switch", "uint32_group_member_level_switch", "uint32_group_flagext4", "uint32_appeal_deadline", "uint32_group_flag", "uint32_secure_level", "uint32_group_flagext3", "uint32_group_class_ext", "uint32_group_info_ext_seq", "uint32_group_flagext", "uint64_conf_uin", "uint32_conf_max_msg_seq", "uint32_conf_to_group_time"}, new Object[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0L, 0, 0}, TroopTips0x857$GroupInfoChange.class);
    public final PBUInt32Field uint32_group_honor_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_member_level_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_flagext4 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_appeal_deadline = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_secure_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_flagext3 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_class_ext = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_info_ext_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_flagext = PBField.initUInt32(0);
    public final PBUInt64Field uint64_conf_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_conf_max_msg_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_conf_to_group_time = PBField.initUInt32(0);
}
