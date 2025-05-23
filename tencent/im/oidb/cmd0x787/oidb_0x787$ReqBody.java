package tencent.im.oidb.cmd0x787;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x787$ReqBody extends MessageMicro<oidb_0x787$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 40, 50, 56, 64, 72, 80}, new String[]{"uint64_group_code", "uint64_begin_uin", "uint64_data_time", "rpt_uin_list", "opt_filter", "uint32_seq", "uint32_uin_num", "uint32_group_type", "uint32_rich_card_name_ver"}, new Object[]{0L, 0L, 0L, 0L, null, 0, 0, 0, 0}, oidb_0x787$ReqBody.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt64Field uint64_begin_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_data_time = PBField.initUInt64(0);
    public final PBRepeatField<Long> rpt_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public oidb_0x787$Filter opt_filter = new MessageMicro<oidb_0x787$Filter>() { // from class: tencent.im.oidb.cmd0x787.oidb_0x787$Filter
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 128, 136, 144, 152, 160, 168, 176, 184, 192, 200, 208, 216, 224, 232, 240, 248, 256, 264}, new String[]{"uint32_member_level_info_uin", "uint32_member_level_info_point", "uint32_member_level_info_active_day", "uint32_member_level_info_level", "uint32_member_level_info_name", "uint32_level_name", "uint32_data_time", "uint32_user_show_flag", "uint32_sys_show_flag", "uint32_time_to_update", "uint32_nick_name", "uint32_special_title", "uint32_phone", "uint32_email", "uint32_remark", "uint32_gender", "uint32_job", "uint32_office_mode", "uint32_glamour_level", "uint32_torchbearer_flag", "uint32_global_group_level", "uint32_title_id", "uint32_global_group_point", "uint32_ringtone_id", "uint32_group_honor", "uint32_membership", "uint32_level_name_new", "uint32_user_show_flag_new", "uint32_msg_need_field", "uint32_cmduin_flagex3_grocery", "uint32_member_robot_info", "uint32_member_icon", "uint32_member_info_seq"}, new Object[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, oidb_0x787$Filter.class);
        public final PBUInt32Field uint32_member_level_info_uin = PBField.initUInt32(0);
        public final PBUInt32Field uint32_member_level_info_point = PBField.initUInt32(0);
        public final PBUInt32Field uint32_member_level_info_active_day = PBField.initUInt32(0);
        public final PBUInt32Field uint32_member_level_info_level = PBField.initUInt32(0);
        public final PBUInt32Field uint32_member_level_info_name = PBField.initUInt32(0);
        public final PBUInt32Field uint32_level_name = PBField.initUInt32(0);
        public final PBUInt32Field uint32_data_time = PBField.initUInt32(0);
        public final PBUInt32Field uint32_user_show_flag = PBField.initUInt32(0);
        public final PBUInt32Field uint32_sys_show_flag = PBField.initUInt32(0);
        public final PBUInt32Field uint32_time_to_update = PBField.initUInt32(0);
        public final PBUInt32Field uint32_nick_name = PBField.initUInt32(0);
        public final PBUInt32Field uint32_special_title = PBField.initUInt32(0);
        public final PBUInt32Field uint32_phone = PBField.initUInt32(0);
        public final PBUInt32Field uint32_email = PBField.initUInt32(0);
        public final PBUInt32Field uint32_remark = PBField.initUInt32(0);
        public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
        public final PBUInt32Field uint32_job = PBField.initUInt32(0);
        public final PBUInt32Field uint32_office_mode = PBField.initUInt32(0);
        public final PBUInt32Field uint32_glamour_level = PBField.initUInt32(0);
        public final PBUInt32Field uint32_torchbearer_flag = PBField.initUInt32(0);
        public final PBUInt32Field uint32_global_group_level = PBField.initUInt32(0);
        public final PBUInt32Field uint32_title_id = PBField.initUInt32(0);
        public final PBUInt32Field uint32_global_group_point = PBField.initUInt32(0);
        public final PBUInt32Field uint32_ringtone_id = PBField.initUInt32(0);
        public final PBUInt32Field uint32_group_honor = PBField.initUInt32(0);
        public final PBUInt32Field uint32_membership = PBField.initUInt32(0);
        public final PBUInt32Field uint32_level_name_new = PBField.initUInt32(0);
        public final PBUInt32Field uint32_user_show_flag_new = PBField.initUInt32(0);
        public final PBUInt32Field uint32_msg_need_field = PBField.initUInt32(0);
        public final PBUInt32Field uint32_cmduin_flagex3_grocery = PBField.initUInt32(0);
        public final PBUInt32Field uint32_member_robot_info = PBField.initUInt32(0);
        public final PBUInt32Field uint32_member_icon = PBField.initUInt32(0);
        public final PBUInt32Field uint32_member_info_seq = PBField.initUInt32(0);
    };
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_uin_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_rich_card_name_ver = PBField.initUInt32(0);
}
