package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class oidb_0xc26$MayKnowPerson extends MessageMicro<oidb_0xc26$MayKnowPerson> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatMessageField<oidb_0xc26$BusiData> busi_info;
    public final PBBytesField bytes_additive;
    public final PBBytesField bytes_alghrithm;
    public final PBBytesField bytes_catelogue;
    public final PBBytesField bytes_city;
    public final PBBytesField bytes_country;
    public final PBBytesField bytes_mobile_name;
    public final PBBytesField bytes_nick;
    public final PBBytesField bytes_province;
    public final PBBytesField bytes_reason;
    public final PBBytesField bytes_remark;
    public final PBBytesField bytes_richbuffer;
    public final PBRepeatMessageField<oidb_0xc26$MultiReason> multi_reason;
    public final PBUInt32Field qzone_feeds_cnt;
    public final PBStringField qzone_jump_url;
    public final PBRepeatMessageField<oidb_0xc26$QzoneMediaInfo> qzone_media_infos;
    public final PBRepeatMessageField<oidb_0xc26$Label> rpt_msg_labels;
    public final PBStringField str_token;
    public final PBUInt32Field uint32_age;
    public final PBUInt32Field uint32_gender;
    public final PBUInt32Field uint32_online_state;
    public final PBUInt32Field uint32_qzone;
    public final PBUInt32Field uint32_sourceid;
    public final PBUInt64Field uint64_category_in_group;
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public oidb_0xc26$AddFriendSource msg_ios_source = new oidb_0xc26$AddFriendSource();
    public oidb_0xc26$AddFriendSource msg_android_source = new oidb_0xc26$AddFriendSource();

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 66, 74, 82, 88, 98, 106, 114, 120, 128, 138, 146, 152, 162, 168, 176, 184, 194, 202, 210, 218}, new String[]{"uint64_uin", "msg_ios_source", "msg_android_source", "bytes_reason", "bytes_additive", "bytes_nick", "bytes_remark", "bytes_country", "bytes_province", "bytes_city", "uint32_age", "bytes_catelogue", "bytes_alghrithm", "bytes_richbuffer", "uint32_qzone", "uint32_gender", "bytes_mobile_name", "str_token", "uint32_online_state", "rpt_msg_labels", "uint32_sourceid", "uint64_category_in_group", "qzone_feeds_cnt", "qzone_media_infos", "qzone_jump_url", "multi_reason", "busi_info"}, new Object[]{0L, null, null, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, byteStringMicro, "", 0, null, 0, 0L, 0, null, "", null, null}, oidb_0xc26$MayKnowPerson.class);
    }

    public oidb_0xc26$MayKnowPerson() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_reason = PBField.initBytes(byteStringMicro);
        this.bytes_additive = PBField.initBytes(byteStringMicro);
        this.bytes_nick = PBField.initBytes(byteStringMicro);
        this.bytes_remark = PBField.initBytes(byteStringMicro);
        this.bytes_country = PBField.initBytes(byteStringMicro);
        this.bytes_province = PBField.initBytes(byteStringMicro);
        this.bytes_city = PBField.initBytes(byteStringMicro);
        this.uint32_age = PBField.initUInt32(0);
        this.bytes_catelogue = PBField.initBytes(byteStringMicro);
        this.bytes_alghrithm = PBField.initBytes(byteStringMicro);
        this.bytes_richbuffer = PBField.initBytes(byteStringMicro);
        this.uint32_qzone = PBField.initUInt32(0);
        this.uint32_gender = PBField.initUInt32(0);
        this.bytes_mobile_name = PBField.initBytes(byteStringMicro);
        this.str_token = PBField.initString("");
        this.uint32_online_state = PBField.initUInt32(0);
        this.rpt_msg_labels = PBField.initRepeatMessage(oidb_0xc26$Label.class);
        this.uint32_sourceid = PBField.initUInt32(0);
        this.uint64_category_in_group = PBField.initUInt64(0L);
        this.qzone_feeds_cnt = PBField.initUInt32(0);
        this.qzone_media_infos = PBField.initRepeatMessage(oidb_0xc26$QzoneMediaInfo.class);
        this.qzone_jump_url = PBField.initString("");
        this.multi_reason = PBField.initRepeatMessage(oidb_0xc26$MultiReason.class);
        this.busi_info = PBField.initRepeatMessage(oidb_0xc26$BusiData.class);
    }
}
