package tencent.im.oidb.cmd0x6df;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class Oidb_0x6df$PhoneInfo extends MessageMicro<Oidb_0x6df$PhoneInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"uint32_type", "str_country_code", "str_phone", "uint32_bu_status"}, new Object[]{0, "", "", 0}, Oidb_0x6df$PhoneInfo.class);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBStringField str_country_code = PBField.initString("");
    public final PBStringField str_phone = PBField.initString("");
    public final PBUInt32Field uint32_bu_status = PBField.initUInt32(0);
}
