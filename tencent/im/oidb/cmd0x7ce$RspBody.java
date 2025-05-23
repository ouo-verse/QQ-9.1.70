package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x7ce$RspBody extends MessageMicro<cmd0x7ce$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"rpt_msg_appoints_info", "uint32_secure_flag", "str_secure_tips"}, new Object[]{null, 0, ""}, cmd0x7ce$RspBody.class);
    public final PBRepeatMessageField<cmd0x7ce$AppintDetail> rpt_msg_appoints_info = PBField.initRepeatMessage(cmd0x7ce$AppintDetail.class);
    public final PBUInt32Field uint32_secure_flag = PBField.initUInt32(0);
    public final PBStringField str_secure_tips = PBField.initString("");
}
