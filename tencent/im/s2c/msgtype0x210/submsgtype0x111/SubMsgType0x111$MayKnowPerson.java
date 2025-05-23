package tencent.im.s2c.msgtype0x210.submsgtype0x111;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class SubMsgType0x111$MayKnowPerson extends MessageMicro<SubMsgType0x111$MayKnowPerson> {
    static final MessageMicro.FieldMap __fieldMap__;
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
    public final PBRepeatMessageField<SubMsgType0x111$Label> rpt_msg_labels;
    public final PBStringField str_token;
    public final PBUInt32Field uint32_age;
    public final PBUInt32Field uint32_gender;
    public final PBUInt32Field uint32_qzone;
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public SubMsgType0x111$AddFriendSource msg_ios_source = new SubMsgType0x111$AddFriendSource();
    public SubMsgType0x111$AddFriendSource msg_android_source = new SubMsgType0x111$AddFriendSource();

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 66, 74, 82, 88, 98, 106, 114, 120, 128, 138, 146, 154}, new String[]{"uint64_uin", "msg_ios_source", "msg_android_source", "bytes_reason", "bytes_additive", "bytes_nick", "bytes_remark", "bytes_country", "bytes_province", "bytes_city", "uint32_age", "bytes_catelogue", "bytes_alghrithm", "bytes_richbuffer", "uint32_qzone", "uint32_gender", "bytes_mobile_name", "str_token", "rpt_msg_labels"}, new Object[]{0L, null, null, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, byteStringMicro, "", null}, SubMsgType0x111$MayKnowPerson.class);
    }

    public SubMsgType0x111$MayKnowPerson() {
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
        this.rpt_msg_labels = PBField.initRepeatMessage(SubMsgType0x111$Label.class);
    }
}
