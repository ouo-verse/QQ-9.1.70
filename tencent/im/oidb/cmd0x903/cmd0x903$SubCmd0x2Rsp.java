package tencent.im.oidb.cmd0x903;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x903$SubCmd0x2Rsp extends MessageMicro<cmd0x903$SubCmd0x2Rsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"rpt_uint64_uin", "opt_uint64_group_code", "uint64_rsp_end_time"}, new Object[]{0L, 0L, 0L}, cmd0x903$SubCmd0x2Rsp.class);
    public final PBRepeatField<Long> rpt_uint64_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt64Field opt_uint64_group_code = PBField.initUInt64(0);
    public final PBUInt64Field uint64_rsp_end_time = PBField.initUInt64(0);
}
