package tencent.im.group_pro_proto.eventflow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class msg_event$GetBatchReq extends MessageMicro<msg_event$GetBatchReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"guilds"}, new Object[]{null}, msg_event$GetBatchReq.class);
    public final PBRepeatMessageField<msg_event$GuildEvents> guilds = PBField.initRepeatMessage(msg_event$GuildEvents.class);
}
