package tencent.im.oidb.cmd0x6df;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x6df$ReqBody extends MessageMicro<Oidb_0x6df$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"uint32_src", "str_country_code", "str_phone", "dev_info"}, new Object[]{0, "", "", null}, Oidb_0x6df$ReqBody.class);
    public final PBUInt32Field uint32_src = PBField.initUInt32(0);
    public final PBStringField str_country_code = PBField.initString("");
    public final PBStringField str_phone = PBField.initString("");
    public Oidb_0x6df$DevInfo dev_info = new MessageMicro<Oidb_0x6df$DevInfo>() { // from class: tencent.im.oidb.cmd0x6df.Oidb_0x6df$DevInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_androidid;
        public final PBBytesField bytes_guid;
        public final PBBytesField bytes_imei;
        public final PBBytesField bytes_vendorid;
        public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
        public final PBUInt32Field uint32_wifi;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 48}, new String[]{"uint32_appid", "bytes_imei", "bytes_guid", "bytes_vendorid", "bytes_androidid", "uint32_wifi"}, new Object[]{0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0}, Oidb_0x6df$DevInfo.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_imei = PBField.initBytes(byteStringMicro);
            this.bytes_guid = PBField.initBytes(byteStringMicro);
            this.bytes_vendorid = PBField.initBytes(byteStringMicro);
            this.bytes_androidid = PBField.initBytes(byteStringMicro);
            this.uint32_wifi = PBField.initUInt32(0);
        }
    };
}
