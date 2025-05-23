package tencent.im.oidb.cmd0x9c9;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x9c9$ReqBody extends MessageMicro<cmd0x9c9$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_birthday;
    public final PBBytesField bytes_hometown;
    public final PBBytesField bytes_hometown_district;
    public final PBBytesField bytes_location;
    public final PBBytesField bytes_location_district;
    public final PBBytesField bytes_reqbody_5ea;
    public final PBBytesField bytes_reqbody_9c7;
    public final PBBytesField bytes_reqbody_tag;
    public final PBBytesField bytes_stranger_declare;
    public final PBStringField str_company;
    public final PBStringField str_stranger_nick;
    public final PBUInt32Field uint32_age;
    public final PBUInt32Field uint32_face_flag;
    public final PBUInt32Field uint32_gift_visible;
    public final PBUInt32Field uint32_guide_flag;
    public final PBUInt32Field uint32_interest_visible;
    public final PBUInt32Field uint32_love_status;
    public final PBUInt32Field uint32_profession;
    public final PBUInt32Field uint32_qzone_visible;
    public final PBUInt32Field uint32_stranger_profile_flag;
    public final PBStringField str_nick = PBField.initString("");
    public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
    public final PBStringField str_college = PBField.initString("");
    public final PBUInt32Field uint32_constellation = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{160018, 160072, 160170, 160176, 160258, 160296, 160330, 160346, 192018, 192066, 208026, 216274, 216282, 216288, 216296, 322488, 322496, 323968, 334448, 335896, 335984, 480010, 480018, 480026}, new String[]{"str_nick", "uint32_gender", "str_college", "uint32_constellation", "bytes_location", "uint32_age", "bytes_location_district", "bytes_hometown_district", "bytes_hometown", "str_company", "bytes_birthday", "str_stranger_nick", "bytes_stranger_declare", "uint32_love_status", "uint32_profession", "uint32_qzone_visible", "uint32_interest_visible", "uint32_stranger_profile_flag", "uint32_gift_visible", "uint32_face_flag", "uint32_guide_flag", "bytes_reqbody_5ea", "bytes_reqbody_9c7", "bytes_reqbody_tag"}, new Object[]{"", 0, "", 0, byteStringMicro, 0, byteStringMicro, byteStringMicro, byteStringMicro, "", byteStringMicro, "", byteStringMicro, 0, 0, 0, 0, 0, 0, 0, 0, byteStringMicro, byteStringMicro, byteStringMicro}, cmd0x9c9$ReqBody.class);
    }

    public cmd0x9c9$ReqBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_birthday = PBField.initBytes(byteStringMicro);
        this.bytes_location = PBField.initBytes(byteStringMicro);
        this.uint32_age = PBField.initUInt32(0);
        this.bytes_location_district = PBField.initBytes(byteStringMicro);
        this.bytes_hometown_district = PBField.initBytes(byteStringMicro);
        this.bytes_hometown = PBField.initBytes(byteStringMicro);
        this.str_company = PBField.initString("");
        this.str_stranger_nick = PBField.initString("");
        this.bytes_stranger_declare = PBField.initBytes(byteStringMicro);
        this.uint32_love_status = PBField.initUInt32(0);
        this.uint32_profession = PBField.initUInt32(0);
        this.uint32_qzone_visible = PBField.initUInt32(0);
        this.uint32_interest_visible = PBField.initUInt32(0);
        this.uint32_stranger_profile_flag = PBField.initUInt32(0);
        this.uint32_gift_visible = PBField.initUInt32(0);
        this.bytes_reqbody_5ea = PBField.initBytes(byteStringMicro);
        this.bytes_reqbody_9c7 = PBField.initBytes(byteStringMicro);
        this.bytes_reqbody_tag = PBField.initBytes(byteStringMicro);
        this.uint32_face_flag = PBField.initUInt32(0);
        this.uint32_guide_flag = PBField.initUInt32(0);
    }
}
