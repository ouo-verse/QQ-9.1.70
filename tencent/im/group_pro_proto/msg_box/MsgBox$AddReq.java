package tencent.im.group_pro_proto.msg_box;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class MsgBox$AddReq extends MessageMicro<MsgBox$AddReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"uin_events"}, new Object[]{null}, MsgBox$AddReq.class);
    public final PBRepeatMessageField<MsgBox$UinEvent> uin_events = PBField.initRepeatMessage(MsgBox$UinEvent.class);
}
