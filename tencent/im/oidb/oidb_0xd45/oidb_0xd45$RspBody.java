package tencent.im.oidb.oidb_0xd45;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xd45$RspBody extends MessageMicro<oidb_0xd45$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint64_from_uin", "uint64_group_uin", "uint64_group_code", "rpt_uint64_uin_list"}, new Object[]{0L, 0L, 0L, 0L}, oidb_0xd45$RspBody.class);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBRepeatField<Long> rpt_uint64_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
