package tencent.im.oidb.cmd0x5e0;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x5e0$ValueBit extends MessageMicro<Oidb_0x5e0$ValueBit> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ext_flag;
    public final PBBytesField bytes_identity_flag;
    public final PBBytesField bytes_service_flag;
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"uint64_uin", "bytes_identity_flag", "bytes_ext_flag", "bytes_service_flag"}, new Object[]{0L, byteStringMicro, byteStringMicro, byteStringMicro}, Oidb_0x5e0$ValueBit.class);
    }

    public Oidb_0x5e0$ValueBit() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_identity_flag = PBField.initBytes(byteStringMicro);
        this.bytes_ext_flag = PBField.initBytes(byteStringMicro);
        this.bytes_service_flag = PBField.initBytes(byteStringMicro);
    }
}
