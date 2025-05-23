package tencent.im.group_pro_proto.msg_responses_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class MsgResponsesSvr$ChannelMsgInfo extends MessageMicro<MsgResponsesSvr$ChannelMsgInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"channel_id", "msg_resp_data"}, new Object[]{0L, null}, MsgResponsesSvr$ChannelMsgInfo.class);
    public final PBUInt64Field channel_id = PBField.initUInt64(0);
    public final PBRepeatMessageField<MsgResponsesSvr$MsgRespData> msg_resp_data = PBField.initRepeatMessage(MsgResponsesSvr$MsgRespData.class);
}
