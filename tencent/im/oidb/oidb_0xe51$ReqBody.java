package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xe51$ReqBody extends MessageMicro<oidb_0xe51$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint64_from_uin", "uint64_to_uin", "bytes_code"}, new Object[]{0L, 0L, ByteStringMicro.EMPTY}, oidb_0xe51$ReqBody.class);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0);
    public final PBBytesField bytes_code = PBField.initBytes(ByteStringMicro.EMPTY);
}
