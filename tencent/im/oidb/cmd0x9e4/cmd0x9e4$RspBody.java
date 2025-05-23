package tencent.im.oidb.cmd0x9e4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x9e4$RspBody extends MessageMicro<cmd0x9e4$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{90, 96}, new String[]{"rpt_msg_uin_data", "rpt_uint64_unfinished_uins"}, new Object[]{null, 0L}, cmd0x9e4$RspBody.class);
    public final PBRepeatMessageField<cmd0x9e4$UdcUinData> rpt_msg_uin_data = PBField.initRepeatMessage(cmd0x9e4$UdcUinData.class);
    public final PBRepeatField<Long> rpt_uint64_unfinished_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
