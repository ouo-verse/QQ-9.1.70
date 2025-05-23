package tencent.im.s2c.msgtype0x210.submsgtype0x44;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0x44$MsgBody extends MessageMicro<submsgtype0x44$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 58, 66}, new String[]{"msg_friend_msg_sync", "msg_group_msg_sync", "msg_clean_count_msg", "msg_modify_msg_sync", "msg_waiting_msg_sync", "msg_del_msg_notify", "msg_general_notify"}, new Object[]{null, null, null, null, null, null, null}, submsgtype0x44$MsgBody.class);
    public submsgtype0x44$FriendSyncMsg msg_friend_msg_sync = new submsgtype0x44$FriendSyncMsg();
    public submsgtype0x44$GroupSyncMsg msg_group_msg_sync = new submsgtype0x44$GroupSyncMsg();
    public submsgtype0x44$ClearCountMsg msg_clean_count_msg = new submsgtype0x44$ClearCountMsg();
    public submsgtype0x44$ModifySyncMsg msg_modify_msg_sync = new MessageMicro<submsgtype0x44$ModifySyncMsg>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44$ModifySyncMsg
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_time"}, new Object[]{0}, submsgtype0x44$ModifySyncMsg.class);
        public final PBUInt32Field uint32_time = PBField.initUInt32(0);
    };
    public submsgtype0x44$WaitingSyncMsg msg_waiting_msg_sync = new MessageMicro<submsgtype0x44$WaitingSyncMsg>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44$WaitingSyncMsg
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_time"}, new Object[]{0}, submsgtype0x44$WaitingSyncMsg.class);
        public final PBUInt32Field uint32_time = PBField.initUInt32(0);
    };
    public submsgtype0x44$DelMsgNotify msg_del_msg_notify = new MessageMicro<submsgtype0x44$DelMsgNotify>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44$DelMsgNotify
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint64_sequence"}, new Object[]{0L}, submsgtype0x44$DelMsgNotify.class);
        public final PBUInt64Field uint64_sequence = PBField.initUInt64(0);
    };
    public submsgtype0x44$GeneralNotify msg_general_notify = new MessageMicro<submsgtype0x44$GeneralNotify>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44$GeneralNotify
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_msg_type", "uint64_msg_seq"}, new Object[]{0, 0L}, submsgtype0x44$GeneralNotify.class);
        public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
        public final PBUInt64Field uint64_msg_seq = PBField.initUInt64(0);
    };
}
