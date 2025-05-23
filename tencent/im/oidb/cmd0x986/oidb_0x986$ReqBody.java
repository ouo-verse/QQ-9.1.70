package tencent.im.oidb.cmd0x986;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x986$ReqBody extends MessageMicro<oidb_0x986$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"uint64_group_code", "uint64_from_uin", "uint32_msg_seq", "uint32_msg_time", "uint64_start_uin"}, new Object[]{0L, 0L, 0, 0, 0L}, oidb_0x986$ReqBody.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_msg_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_start_uin = PBField.initUInt64(0);
}
