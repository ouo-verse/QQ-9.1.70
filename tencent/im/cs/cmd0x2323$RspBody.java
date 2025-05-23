package tencent.im.cs;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x2323$RspBody extends MessageMicro<cmd0x2323$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"ret", "body_msg"}, new Object[]{0, null}, cmd0x2323$RspBody.class);
    public final PBInt32Field ret = PBField.initInt32(0);
    public final PBRepeatMessageField<cmd0x2323$BodyMsg> body_msg = PBField.initRepeatMessage(cmd0x2323$BodyMsg.class);
}
