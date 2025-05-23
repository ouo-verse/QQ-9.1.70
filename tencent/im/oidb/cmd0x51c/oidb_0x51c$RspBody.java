package tencent.im.oidb.cmd0x51c;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x51c$RspBody extends MessageMicro<oidb_0x51c$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"opt_uint32_result", "opt_bytes_errinfo", "opt_uint64_handled_uin"}, new Object[]{0, ByteStringMicro.EMPTY, 0L}, oidb_0x51c$RspBody.class);
    public final PBUInt32Field opt_uint32_result = PBField.initUInt32(0);
    public final PBBytesField opt_bytes_errinfo = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field opt_uint64_handled_uin = PBField.initUInt64(0);
}
