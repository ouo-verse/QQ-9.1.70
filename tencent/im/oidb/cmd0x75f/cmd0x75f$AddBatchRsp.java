package tencent.im.oidb.cmd0x75f;

import QTimedMessage.QTimedMessage$Message;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x75f$AddBatchRsp extends MessageMicro<cmd0x75f$AddBatchRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"rpt_messages", "rpt_failures"}, new Object[]{null, null}, cmd0x75f$AddBatchRsp.class);
    public final PBRepeatMessageField<QTimedMessage$Message> rpt_messages = PBField.initRepeatMessage(QTimedMessage$Message.class);
    public final PBRepeatMessageField<QTimedMessage$Message> rpt_failures = PBField.initRepeatMessage(QTimedMessage$Message.class);
}
