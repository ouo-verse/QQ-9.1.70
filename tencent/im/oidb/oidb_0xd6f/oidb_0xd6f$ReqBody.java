package tencent.im.oidb.oidb_0xd6f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xd6f$ReqBody extends MessageMicro<oidb_0xd6f$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint64_uin", "uint64_frd_uin", "uint32_source"}, new Object[]{0L, 0L, 0}, oidb_0xd6f$ReqBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_frd_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_source = PBField.initUInt32(0);
}
