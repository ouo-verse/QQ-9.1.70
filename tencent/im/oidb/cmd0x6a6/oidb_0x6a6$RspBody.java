package tencent.im.oidb.cmd0x6a6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x6a6$RspBody extends MessageMicro<oidb_0x6a6$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_read_count", "uint64_read_count", "uint32_ret_code"}, new Object[]{0, 0L, 0}, oidb_0x6a6$RspBody.class);
    public final PBUInt32Field uint32_read_count = PBField.initUInt32(0);
    public final PBUInt64Field uint64_read_count = PBField.initUInt64(0);
    public final PBUInt32Field uint32_ret_code = PBField.initUInt32(0);
}
