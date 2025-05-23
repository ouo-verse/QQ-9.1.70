package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x87a$RspBody extends MessageMicro<oidb_0x87a$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"str_country", "str_telephone", "uint32_resend_interval", "bytes_guid"}, new Object[]{"", "", 0, ByteStringMicro.EMPTY}, oidb_0x87a$RspBody.class);
    public final PBStringField str_country = PBField.initString("");
    public final PBStringField str_telephone = PBField.initString("");
    public final PBUInt32Field uint32_resend_interval = PBField.initUInt32(0);
    public final PBBytesField bytes_guid = PBField.initBytes(ByteStringMicro.EMPTY);
}
