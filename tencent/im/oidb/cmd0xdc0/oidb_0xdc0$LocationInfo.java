package tencent.im.oidb.cmd0xdc0;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xdc0$LocationInfo extends MessageMicro<oidb_0xdc0$LocationInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_city;
    public final PBBytesField bytes_city_code;
    public final PBBytesField bytes_country;
    public final PBBytesField bytes_province;
    public final PBUInt32Field uint32_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_order = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 90, 98, 106, 114}, new String[]{"uint32_id", "uint32_order", "bytes_country", "bytes_province", "bytes_city", "bytes_city_code"}, new Object[]{0, 0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, oidb_0xdc0$LocationInfo.class);
    }

    public oidb_0xdc0$LocationInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_country = PBField.initBytes(byteStringMicro);
        this.bytes_province = PBField.initBytes(byteStringMicro);
        this.bytes_city = PBField.initBytes(byteStringMicro);
        this.bytes_city_code = PBField.initBytes(byteStringMicro);
    }
}
