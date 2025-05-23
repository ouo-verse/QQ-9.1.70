package tencent.im.oidb.cmd0x75f;

import QTimedMessage.QTimedMessage$Message;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x75f$AddBatchReq extends MessageMicro<cmd0x75f$AddBatchReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_messages"}, new Object[]{null}, cmd0x75f$AddBatchReq.class);
    public final PBRepeatMessageField<QTimedMessage$Message> rpt_messages = PBField.initRepeatMessage(QTimedMessage$Message.class);
}
