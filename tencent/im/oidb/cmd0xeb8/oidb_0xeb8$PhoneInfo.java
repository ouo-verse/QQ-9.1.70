package tencent.im.oidb.cmd0xeb8;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class oidb_0xeb8$PhoneInfo extends MessageMicro<oidb_0xeb8$PhoneInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42}, new String[]{"uint32_phone_type", "str_country_code", "str_phone", "uint32_phone_status", "bytes_vas_phone"}, new Object[]{0, "", "", 0, ByteStringMicro.EMPTY}, oidb_0xeb8$PhoneInfo.class);
    public final PBUInt32Field uint32_phone_type = PBField.initUInt32(0);
    public final PBStringField str_country_code = PBField.initString("");
    public final PBStringField str_phone = PBField.initString("");
    public final PBUInt32Field uint32_phone_status = PBField.initUInt32(0);
    public final PBBytesField bytes_vas_phone = PBField.initBytes(ByteStringMicro.EMPTY);
}
