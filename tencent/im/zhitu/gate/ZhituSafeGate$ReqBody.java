package tencent.im.zhitu.gate;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ZhituSafeGate$ReqBody extends MessageMicro<ZhituSafeGate$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint64_src_uin", "uint32_src_term", "bytes_other"}, new Object[]{0L, 0, ByteStringMicro.EMPTY}, ZhituSafeGate$ReqBody.class);
    public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_src_term = PBField.initUInt32(0);
    public final PBBytesField bytes_other = PBField.initBytes(ByteStringMicro.EMPTY);
}
