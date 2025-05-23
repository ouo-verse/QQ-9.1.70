package tencent.im.group_pro_proto.eventflow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class msg_event$GuildCount extends MessageMicro<msg_event$GuildCount> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"guild_id", "channels"}, new Object[]{0L, null}, msg_event$GuildCount.class);
    public final PBUInt64Field guild_id = PBField.initUInt64(0);
    public final PBRepeatMessageField<msg_event$ChannelCount> channels = PBField.initRepeatMessage(msg_event$ChannelCount.class);
}
