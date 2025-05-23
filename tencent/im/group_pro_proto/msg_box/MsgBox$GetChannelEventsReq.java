package tencent.im.group_pro_proto.msg_box;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class MsgBox$GetChannelEventsReq extends MessageMicro<MsgBox$GetChannelEventsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"guilds"}, new Object[]{null}, MsgBox$GetChannelEventsReq.class);
    public final PBRepeatMessageField<MsgBox$Guild> guilds = PBField.initRepeatMessage(MsgBox$Guild.class);
}
