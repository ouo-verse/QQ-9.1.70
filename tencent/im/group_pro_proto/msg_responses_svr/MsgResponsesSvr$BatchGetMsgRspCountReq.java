package tencent.im.group_pro_proto.msg_responses_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class MsgResponsesSvr$BatchGetMsgRspCountReq extends MessageMicro<MsgResponsesSvr$BatchGetMsgRspCountReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"guild_msg_list"}, new Object[]{null}, MsgResponsesSvr$BatchGetMsgRspCountReq.class);
    public final PBRepeatMessageField<MsgResponsesSvr$GuildMsg> guild_msg_list = PBField.initRepeatMessage(MsgResponsesSvr$GuildMsg.class);
}
