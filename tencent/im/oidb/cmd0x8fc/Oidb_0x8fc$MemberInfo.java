package tencent.im.oidb.cmd0x8fc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x8fc$MemberInfo extends MessageMicro<Oidb_0x8fc$MemberInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_comm_rich_card_name;
    public final PBBytesField bytes_email;
    public final PBBytesField bytes_group_honor;
    public final PBBytesField bytes_job;
    public final PBBytesField bytes_phone;
    public final PBBytesField bytes_remark;
    public final PBBytesField bytes_special_title;
    public final PBBytesField bytes_uin_name;
    public final PBBytesField member_card_name;
    public final PBRepeatMessageField<Oidb_0x8fc$CardNameElem> rpt_rich_card_name;
    public final PBUInt32Field uint32_cmduin_flag_ex3_grocery;
    public final PBUInt32Field uint32_cmduin_flag_ex3_mask;
    public final PBUInt32Field uint32_gender;
    public final PBUInt32Field uint32_ringtone_id;
    public final PBUInt32Field uint32_special_title_expire_time;
    public final PBUInt32Field uint32_tribe_level;
    public final PBUInt32Field uint32_tribe_point;
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_point = PBField.initUInt32(0);
    public final PBUInt32Field uint32_active_day = PBField.initUInt32(0);
    public final PBUInt32Field uint32_level = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 58, 66, 74, 82, 90, 96, 106, 112, 120, 130, 138, 144, 154, 160, 168}, new String[]{"uint64_uin", "uint32_point", "uint32_active_day", "uint32_level", "bytes_special_title", "uint32_special_title_expire_time", "bytes_uin_name", "member_card_name", "bytes_phone", "bytes_email", "bytes_remark", "uint32_gender", "bytes_job", "uint32_tribe_level", "uint32_tribe_point", "rpt_rich_card_name", "bytes_comm_rich_card_name", "uint32_ringtone_id", "bytes_group_honor", "uint32_cmduin_flag_ex3_grocery", "uint32_cmduin_flag_ex3_mask"}, new Object[]{0L, 0, 0, 0, byteStringMicro, 0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0, byteStringMicro, 0, 0, null, byteStringMicro, 0, byteStringMicro, 0, 0}, Oidb_0x8fc$MemberInfo.class);
    }

    public Oidb_0x8fc$MemberInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_special_title = PBField.initBytes(byteStringMicro);
        this.uint32_special_title_expire_time = PBField.initUInt32(0);
        this.bytes_uin_name = PBField.initBytes(byteStringMicro);
        this.member_card_name = PBField.initBytes(byteStringMicro);
        this.bytes_phone = PBField.initBytes(byteStringMicro);
        this.bytes_email = PBField.initBytes(byteStringMicro);
        this.bytes_remark = PBField.initBytes(byteStringMicro);
        this.uint32_gender = PBField.initUInt32(0);
        this.bytes_job = PBField.initBytes(byteStringMicro);
        this.uint32_tribe_level = PBField.initUInt32(0);
        this.uint32_tribe_point = PBField.initUInt32(0);
        this.rpt_rich_card_name = PBField.initRepeatMessage(Oidb_0x8fc$CardNameElem.class);
        this.bytes_comm_rich_card_name = PBField.initBytes(byteStringMicro);
        this.uint32_ringtone_id = PBField.initUInt32(0);
        this.bytes_group_honor = PBField.initBytes(byteStringMicro);
        this.uint32_cmduin_flag_ex3_grocery = PBField.initUInt32(0);
        this.uint32_cmduin_flag_ex3_mask = PBField.initUInt32(0);
    }
}
