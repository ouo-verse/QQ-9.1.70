package tencent.im.oidb.cmd0x9c6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x9c6$RspBody extends MessageMicro<cmd0x9c6$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"rpt_msg_interests", "str_error"}, new Object[]{null, ""}, cmd0x9c6$RspBody.class);
    public final PBRepeatMessageField<cmd0x9c6$InterestMsg> rpt_msg_interests = PBField.initRepeatMessage(cmd0x9c6$InterestMsg.class);
    public final PBStringField str_error = PBField.initString("");
}
