package tencent.im.oidb.cmd0xed2;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xed2$ReqBody extends MessageMicro<oidb_0xed2$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_key;
    public final PBBytesField bytes_signature;
    public final PBEnumField enum_reqphonetype;
    public final PBStringField str_country = PBField.initString("");
    public final PBStringField str_telephone = PBField.initString("");
    public final PBUInt32Field uint32_key_type = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 40, 50}, new String[]{"str_country", "str_telephone", "uint32_key_type", "bytes_key", "enum_reqphonetype", "bytes_signature"}, new Object[]{"", "", 0, byteStringMicro, 1, byteStringMicro}, oidb_0xed2$ReqBody.class);
    }

    public oidb_0xed2$ReqBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_key = PBField.initBytes(byteStringMicro);
        this.enum_reqphonetype = PBField.initEnum(1);
        this.bytes_signature = PBField.initBytes(byteStringMicro);
    }
}
