package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x87c$RspBody extends MessageMicro<oidb_0x87c$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_guid;
    public final PBBytesField bytes_key;
    public final PBStringField str_country = PBField.initString("");
    public final PBStringField str_telephone = PBField.initString("");
    public final PBUInt32Field uint32_key_type = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42}, new String[]{"str_country", "str_telephone", "uint32_key_type", "bytes_key", "bytes_guid"}, new Object[]{"", "", 0, byteStringMicro, byteStringMicro}, oidb_0x87c$RspBody.class);
    }

    public oidb_0x87c$RspBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_key = PBField.initBytes(byteStringMicro);
        this.bytes_guid = PBField.initBytes(byteStringMicro);
    }
}
