package tencent.im.group_pro_proto.msg_responses_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class MsgResponsesSvr$MsgCnt extends MessageMicro<MsgResponsesSvr$MsgCnt> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_id", "emoji_reaction"}, new Object[]{null, null}, MsgResponsesSvr$MsgCnt.class);
    public MsgResponsesSvr$MsgId msg_id = new MsgResponsesSvr$MsgId();
    public final PBRepeatMessageField<MsgResponsesSvr$EmojiReaction> emoji_reaction = PBField.initRepeatMessage(MsgResponsesSvr$EmojiReaction.class);
}
