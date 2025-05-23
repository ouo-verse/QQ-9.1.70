package tencent.im.group_pro_proto.msgpush;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import tencent.im.group_pro_proto.common.common$Msg;

/* loaded from: classes29.dex */
public final class msgpush$PressMsg extends MessageMicro<msgpush$PressMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msgs"}, new Object[]{null}, msgpush$PressMsg.class);
    public final PBRepeatMessageField<common$Msg> msgs = PBField.initRepeatMessage(common$Msg.class);
}
