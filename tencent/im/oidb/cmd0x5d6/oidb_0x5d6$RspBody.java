package tencent.im.oidb.cmd0x5d6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x5d6$RspBody extends MessageMicro<oidb_0x5d6$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_Seq", "str_wording", "rpt_msg_update_result"}, new Object[]{0, "", null}, oidb_0x5d6$RspBody.class);
    public final PBUInt32Field uint32_Seq = PBField.initUInt32(0);
    public final PBStringField str_wording = PBField.initString("");
    public final PBRepeatMessageField<oidb_0x5d6$SnsUpateResult> rpt_msg_update_result = PBField.initRepeatMessage(oidb_0x5d6$SnsUpateResult.class);
}
