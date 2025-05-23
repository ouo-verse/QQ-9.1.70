package tencent.im.oidb.cmd0x962;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x962$RspBody extends MessageMicro<oidb_0x962$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42}, new String[]{"uint64_already_pay_microseconds", "uint64_play_total_microseconds", "uint64_state_microseconds", "uint32_play_state", "msg_finish_info"}, new Object[]{0L, 0L, 0L, 0, null}, oidb_0x962$RspBody.class);
    public final PBUInt64Field uint64_already_pay_microseconds = PBField.initUInt64(0);
    public final PBUInt64Field uint64_play_total_microseconds = PBField.initUInt64(0);
    public final PBRepeatField<Long> uint64_state_microseconds = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_play_state = PBField.initUInt32(0);
    public oidb_0x962$FinishInfo msg_finish_info = new oidb_0x962$FinishInfo();
}
