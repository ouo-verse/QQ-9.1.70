package tencent.im.oidb.oidb_0xdd6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xdd6$ReqBody extends MessageMicro<oidb_0xdd6$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint64_uin", "uint64_start_time", "uint64_end_time"}, new Object[]{0L, 0L, 0L}, oidb_0xdd6$ReqBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_start_time = PBField.initUInt64(0);
    public final PBUInt64Field uint64_end_time = PBField.initUInt64(0);
}
