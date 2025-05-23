package tencent.im.group_pro_proto.msg_responses_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class MsgResponsesSvr$GuildMsg extends MessageMicro<MsgResponsesSvr$GuildMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"guild_id", "channel_msg_list"}, new Object[]{0L, null}, MsgResponsesSvr$GuildMsg.class);
    public final PBUInt64Field guild_id = PBField.initUInt64(0);
    public final PBRepeatMessageField<MsgResponsesSvr$ChannelMsg> channel_msg_list = PBField.initRepeatMessage(MsgResponsesSvr$ChannelMsg.class);
}
