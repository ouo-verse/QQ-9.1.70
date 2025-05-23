package tencent.im.oidb.cmd0xd50;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0xd50$RspBody extends MessageMicro<Oidb_0xd50$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 88, 96, 104}, new String[]{"rpt_msg_update_data", "uint32_over", "uint32_next_start", "rpt_uint64_unfinished_uins"}, new Object[]{null, 0, 0, 0L}, Oidb_0xd50$RspBody.class);
    public final PBRepeatMessageField<Oidb_0xd50$ExtSnsFrdData> rpt_msg_update_data = PBField.initRepeatMessage(Oidb_0xd50$ExtSnsFrdData.class);
    public final PBUInt32Field uint32_over = PBField.initUInt32(0);
    public final PBUInt32Field uint32_next_start = PBField.initUInt32(0);
    public final PBRepeatField<Long> rpt_uint64_unfinished_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
