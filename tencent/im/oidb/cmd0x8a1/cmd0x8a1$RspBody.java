package tencent.im.oidb.cmd0x8a1;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x8a1$RspBody extends MessageMicro<cmd0x8a1$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_security_buffer;
    public final PBBytesField string_sign;
    public final PBUInt32Field uint32_create_option = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_code = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_uin = PBField.initUInt32(0);
    public final PBUInt64Field uint64_owner_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_group_size = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50, 58}, new String[]{"uint32_create_option", "uint32_group_code", "uint32_group_uin", "uint64_owner_uin", "uint32_group_size", "string_sign", "bytes_security_buffer"}, new Object[]{0, 0, 0, 0L, 0, byteStringMicro, byteStringMicro}, cmd0x8a1$RspBody.class);
    }

    public cmd0x8a1$RspBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.string_sign = PBField.initBytes(byteStringMicro);
        this.bytes_security_buffer = PBField.initBytes(byteStringMicro);
    }
}
