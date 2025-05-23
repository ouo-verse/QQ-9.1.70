package tencent.im.oidb.cmd0x86f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x86f$ReqBody extends MessageMicro<oidb_0x86f$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_seq", "uint32_total"}, new Object[]{0L, 0}, oidb_0x86f$ReqBody.class);
    public final PBUInt64Field uint64_seq = PBField.initUInt64(0);
    public final PBUInt32Field uint32_total = PBField.initUInt32(0);
}
