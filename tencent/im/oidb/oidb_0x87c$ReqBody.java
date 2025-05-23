package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x87c$ReqBody extends MessageMicro<oidb_0x87c$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40}, new String[]{"str_country", "str_telephone", "str_sms_code", "bytes_guid", "enum_butype"}, new Object[]{"", "", "", ByteStringMicro.EMPTY, 0}, oidb_0x87c$ReqBody.class);
    public final PBStringField str_country = PBField.initString("");
    public final PBStringField str_telephone = PBField.initString("");
    public final PBStringField str_sms_code = PBField.initString("");
    public final PBBytesField bytes_guid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_butype = PBField.initEnum(0);
}
