package tencent.im.oidb.cmd0x5eb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x5eb$RspBody extends MessageMicro<oidb_0x5eb$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{90, 96}, new String[]{"rpt_msg_uin_data", "rpt_uint64_unfinished_uins"}, new Object[]{null, 0L}, oidb_0x5eb$RspBody.class);
    public final PBRepeatMessageField<oidb_0x5eb$UdcUinData> rpt_msg_uin_data = PBField.initRepeatMessage(oidb_0x5eb$UdcUinData.class);
    public final PBRepeatField<Long> rpt_uint64_unfinished_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
