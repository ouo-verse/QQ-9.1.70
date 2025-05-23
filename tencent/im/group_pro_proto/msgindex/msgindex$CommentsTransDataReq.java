package tencent.im.group_pro_proto.msgindex;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class msgindex$CommentsTransDataReq extends MessageMicro<msgindex$CommentsTransDataReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"query_items"}, new Object[]{null}, msgindex$CommentsTransDataReq.class);
    public final PBRepeatMessageField<ChannelMsg> query_items = PBField.initRepeatMessage(ChannelMsg.class);

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class ChannelMsg extends MessageMicro<ChannelMsg> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"guild_id", "channel_id", "msgs"}, new Object[]{0L, 0L, null}, ChannelMsg.class);
        public final PBUInt64Field guild_id = PBField.initUInt64(0);
        public final PBUInt64Field channel_id = PBField.initUInt64(0);
        public final PBRepeatMessageField<msgindex$Msg> msgs = PBField.initRepeatMessage(msgindex$Msg.class);
    }
}
