package tencent.im.s2c.msgtype0x210.submsgtype0x87;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x87$MsgBody extends MessageMicro<SubMsgType0x87$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint64_friend_msg_type_flag", "rpt_msg_msg_notify", "msg_msg_notify_unread"}, new Object[]{0L, null, null}, SubMsgType0x87$MsgBody.class);
    public final PBUInt64Field uint64_friend_msg_type_flag = PBField.initUInt64(0);
    public final PBRepeatMessageField<SubMsgType0x87$MsgNotify> rpt_msg_msg_notify = PBField.initRepeatMessage(SubMsgType0x87$MsgNotify.class);
    public SubMsgType0x87$MsgNotifyUnread msg_msg_notify_unread = new MessageMicro<SubMsgType0x87$MsgNotifyUnread>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x87.SubMsgType0x87$MsgNotifyUnread
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_unreadcount"}, new Object[]{0}, SubMsgType0x87$MsgNotifyUnread.class);
        public final PBUInt32Field uint32_unreadcount = PBField.initUInt32(0);
    };
}
