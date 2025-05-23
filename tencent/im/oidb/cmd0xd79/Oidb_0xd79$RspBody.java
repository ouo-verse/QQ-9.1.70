package tencent.im.oidb.cmd0xd79;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0xd79$RspBody extends MessageMicro<Oidb_0xd79$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42}, new String[]{"uint32_ret", "uint64_seq", "uint64_uin", "uint32_compress_flag", "bytes_raw_content"}, new Object[]{0, 0L, 0L, 0, ByteStringMicro.EMPTY}, Oidb_0xd79$RspBody.class);
    public final PBUInt32Field uint32_ret = PBField.initUInt32(0);
    public final PBUInt64Field uint64_seq = PBField.initUInt64(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_compress_flag = PBField.initUInt32(0);
    public final PBBytesField bytes_raw_content = PBField.initBytes(ByteStringMicro.EMPTY);
}
