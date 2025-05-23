package tencent.im.oidb.cmd0x82a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x82a$RspBody extends MessageMicro<cmd0x82a$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_status"}, new Object[]{null}, cmd0x82a$RspBody.class);
    public final PBRepeatMessageField<cmd0x82a$MsgStatus> msg_status = PBField.initRepeatMessage(cmd0x82a$MsgStatus.class);
}
