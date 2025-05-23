package tencent.im.oidb.cmd0xbbb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xbbb$ReqBody extends MessageMicro<oidb_cmd0xbbb$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 58, 64, 74}, new String[]{"uint32_age", "uint32_sex", "str_city", "bytes_city", "msg_phone_type", "uint32_debug", "msg_location_info"}, new Object[]{0, 0, "", ByteStringMicro.EMPTY, null, 0, null}, oidb_cmd0xbbb$ReqBody.class);
    public final PBUInt32Field uint32_age = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sex = PBField.initUInt32(0);
    public final PBStringField str_city = PBField.initString("");
    public final PBBytesField bytes_city = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_cmd0xbbb$PhoneInfo msg_phone_type = new MessageMicro<oidb_cmd0xbbb$PhoneInfo>() { // from class: tencent.im.oidb.cmd0xbbb.oidb_cmd0xbbb$PhoneInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_appid;
        public final PBBytesField bytes_client_ip;
        public final PBBytesField bytes_muid;
        public final PBBytesField bytes_os_ver;
        public final PBBytesField bytes_qq_ver;
        public final PBUInt32Field uint32_carrier;
        public final PBUInt32Field uint32_conn;
        public final PBUInt32Field uint32_muid_type;
        public final PBUInt32Field uint32_os_type;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42, 50, 58, 66, 72}, new String[]{"bytes_muid", "uint32_conn", "uint32_carrier", "uint32_muid_type", "bytes_os_ver", "bytes_qq_ver", "bytes_client_ip", "bytes_appid", "uint32_os_type"}, new Object[]{byteStringMicro, 0, 0, 0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0}, oidb_cmd0xbbb$PhoneInfo.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_muid = PBField.initBytes(byteStringMicro);
            this.uint32_conn = PBField.initUInt32(0);
            this.uint32_carrier = PBField.initUInt32(0);
            this.uint32_muid_type = PBField.initUInt32(0);
            this.bytes_os_ver = PBField.initBytes(byteStringMicro);
            this.bytes_qq_ver = PBField.initBytes(byteStringMicro);
            this.bytes_client_ip = PBField.initBytes(byteStringMicro);
            this.bytes_appid = PBField.initBytes(byteStringMicro);
            this.uint32_os_type = PBField.initUInt32(0);
        }
    };
    public final PBUInt32Field uint32_debug = PBField.initUInt32(0);
    public oidb_cmd0xbbb$LocationInfo msg_location_info = new MessageMicro<oidb_cmd0xbbb$LocationInfo>() { // from class: tencent.im.oidb.cmd0xbbb.oidb_cmd0xbbb$LocationInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_city;
        public final PBBytesField bytes_city_code;
        public final PBBytesField bytes_country;
        public final PBBytesField bytes_province;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{90, 98, 106, 114}, new String[]{"bytes_country", "bytes_province", "bytes_city", "bytes_city_code"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, oidb_cmd0xbbb$LocationInfo.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_country = PBField.initBytes(byteStringMicro);
            this.bytes_province = PBField.initBytes(byteStringMicro);
            this.bytes_city = PBField.initBytes(byteStringMicro);
            this.bytes_city_code = PBField.initBytes(byteStringMicro);
        }
    };
}
