package tencent.im.group_pro_proto.eventflow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class msg_event$CountReq extends MessageMicro<msg_event$CountReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"guilds"}, new Object[]{null}, msg_event$CountReq.class);
    public final PBRepeatMessageField<msg_event$GuildCount> guilds = PBField.initRepeatMessage(msg_event$GuildCount.class);
}
