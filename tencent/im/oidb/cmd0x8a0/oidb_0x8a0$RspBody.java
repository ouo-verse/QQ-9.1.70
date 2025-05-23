package tencent.im.oidb.cmd0x8a0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8a0$RspBody extends MessageMicro<oidb_0x8a0$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"opt_uint64_group_code", "rpt_msg_kick_result"}, new Object[]{0L, null}, oidb_0x8a0$RspBody.class);
    public final PBUInt64Field opt_uint64_group_code = PBField.initUInt64(0);
    public final PBRepeatMessageField<oidb_0x8a0$KickResult> rpt_msg_kick_result = PBField.initRepeatMessage(oidb_0x8a0$KickResult.class);
}
