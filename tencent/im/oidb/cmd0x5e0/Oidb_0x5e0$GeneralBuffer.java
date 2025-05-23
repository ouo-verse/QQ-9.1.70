package tencent.im.oidb.cmd0x5e0;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x5e0$GeneralBuffer extends MessageMicro<Oidb_0x5e0$GeneralBuffer> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"bytes_value", "uint64_uin"}, new Object[]{ByteStringMicro.EMPTY, 0L}, Oidb_0x5e0$GeneralBuffer.class);
    public final PBBytesField bytes_value = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
}
