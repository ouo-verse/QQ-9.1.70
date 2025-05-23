package tencent.im.oidb.cmd0x787;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x787$MemberLevelInfo extends MessageMicro<oidb_0x787$MemberLevelInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_email;
    public final PBBytesField bytes_group_honor;
    public final PBBytesField bytes_job;
    public final PBBytesField bytes_member_robot_info;
    public final PBBytesField bytes_msg_need_field;
    public final PBBytesField bytes_nick_name;
    public final PBBytesField bytes_phone;
    public final PBBytesField bytes_remark;
    public final PBBytesField bytes_special_title;
    public final PBRepeatMessageField<oidb_0x787$MemberIcon> rpt_member_icon;
    public final PBBytesField str_name;
    public final PBUInt32Field uint32_cmduin_flagex3_grocery;
    public final PBUInt32Field uint32_gender;
    public final PBUInt32Field uint32_glamour_level;
    public final PBUInt32Field uint32_global_group_level;
    public final PBUInt32Field uint32_global_group_point;
    public final PBUInt32Field uint32_membership;
    public final PBUInt32Field uint32_rich_card_name_ver;
    public final PBUInt32Field uint32_ringtone_id;
    public final PBUInt32Field uint32_special_title_expire_time;
    public final PBUInt32Field uint32_title_id;
    public final PBUInt32Field uint32_torchbearer_flag;
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_point = PBField.initUInt32(0);
    public final PBUInt32Field uint32_active_day = PBField.initUInt32(0);
    public final PBUInt32Field uint32_level = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50, 58, 64, 74, 82, 90, 96, 106, 112, 120, 128, 136, 144, 152, 160, 170, 176, 186, 192, 202, 210}, new String[]{"uint64_uin", "uint32_point", "uint32_active_day", "uint32_level", "str_name", "bytes_nick_name", "bytes_special_title", "uint32_special_title_expire_time", "bytes_phone", "bytes_email", "bytes_remark", "uint32_gender", "bytes_job", "uint32_glamour_level", "uint32_torchbearer_flag", "uint32_global_group_level", "uint32_title_id", "uint32_global_group_point", "uint32_rich_card_name_ver", "uint32_ringtone_id", "bytes_group_honor", "uint32_membership", "bytes_msg_need_field", "uint32_cmduin_flagex3_grocery", "bytes_member_robot_info", "rpt_member_icon"}, new Object[]{0L, 0, 0, 0, byteStringMicro, byteStringMicro, byteStringMicro, 0, byteStringMicro, byteStringMicro, byteStringMicro, 0, byteStringMicro, 0, 0, 0, 0, 0, 0, 0, byteStringMicro, 0, byteStringMicro, 0, byteStringMicro, null}, oidb_0x787$MemberLevelInfo.class);
    }

    public oidb_0x787$MemberLevelInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.str_name = PBField.initBytes(byteStringMicro);
        this.bytes_nick_name = PBField.initBytes(byteStringMicro);
        this.bytes_special_title = PBField.initBytes(byteStringMicro);
        this.uint32_special_title_expire_time = PBField.initUInt32(0);
        this.bytes_phone = PBField.initBytes(byteStringMicro);
        this.bytes_email = PBField.initBytes(byteStringMicro);
        this.bytes_remark = PBField.initBytes(byteStringMicro);
        this.uint32_gender = PBField.initUInt32(0);
        this.bytes_job = PBField.initBytes(byteStringMicro);
        this.uint32_glamour_level = PBField.initUInt32(0);
        this.uint32_torchbearer_flag = PBField.initUInt32(0);
        this.uint32_global_group_level = PBField.initUInt32(0);
        this.uint32_title_id = PBField.initUInt32(0);
        this.uint32_global_group_point = PBField.initUInt32(0);
        this.uint32_rich_card_name_ver = PBField.initUInt32(0);
        this.uint32_ringtone_id = PBField.initUInt32(0);
        this.bytes_group_honor = PBField.initBytes(byteStringMicro);
        this.uint32_membership = PBField.initUInt32(0);
        this.bytes_msg_need_field = PBField.initBytes(byteStringMicro);
        this.uint32_cmduin_flagex3_grocery = PBField.initUInt32(0);
        this.bytes_member_robot_info = PBField.initBytes(byteStringMicro);
        this.rpt_member_icon = PBField.initRepeatMessage(oidb_0x787$MemberIcon.class);
    }
}
