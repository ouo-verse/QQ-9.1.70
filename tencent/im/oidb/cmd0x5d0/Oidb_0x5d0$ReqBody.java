package tencent.im.oidb.cmd0x5d0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x5d0$ReqBody extends MessageMicro<Oidb_0x5d0$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint32_start_time", "rpt_uint32_fieldlist", "rpt_uint64_uinlist", "uint64_bind_uin"}, new Object[]{0, 0, 0L, 0L}, Oidb_0x5d0$ReqBody.class);
    public final PBUInt32Field uint32_start_time = PBField.initUInt32(0);
    public final PBRepeatField<Integer> rpt_uint32_fieldlist = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatField<Long> rpt_uint64_uinlist = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt64Field uint64_bind_uin = PBField.initUInt64(0);
}
