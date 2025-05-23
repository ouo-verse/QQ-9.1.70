package tencent.im.s2c.msgtype0x210.submsgtype0xc7;

import com.tencent.mobileqq.msf.core.c0.g;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import com.tencent.tbs.reader.ITbsReaderTool;
import cooperation.qzone.api.QZoneContant;
import cooperation.qzone.util.WnsError;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0xc7$ForwardBody extends MessageMicro<submsgtype0xc7$ForwardBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24002, ITbsReaderTool.CALL_HOST_ABILITY_JUMP2BROWSER}, new String[]{"uint32_notify_type", "uint32_op_type", "msg_hot_friend_notify", "msg_relational_chain_change"}, new Object[]{0, 0, null, null}, submsgtype0xc7$ForwardBody.class);
    public final PBUInt32Field uint32_notify_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_op_type = PBField.initUInt32(0);
    public submsgtype0xc7$HotFriendNotify msg_hot_friend_notify = new MessageMicro<submsgtype0xc7$HotFriendNotify>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7$HotFriendNotify
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_boat_wording;
        public final PBBytesField bytes_key_wording;
        public final PBBytesField bytes_wildcard_wording;
        public final PBUInt32Field loverKeyBusinessType;
        public final PBBytesField loverKeyLinkWording;
        public final PBBytesField loverKeyMainWording;
        public final PBUInt32Field loverKeySubBusinessType;
        public submsgtype0xc7$FriendShipFlagNotify msg_friendship_flag_notify;
        public final PBUInt32Field uint32_boat_days;
        public final PBUInt32Field uint32_boat_flag;
        public final PBUInt32Field uint32_boat_level;
        public final PBUInt32Field uint32_key_flag;
        public final PBUInt32Field uint32_key_hot_days;
        public final PBUInt32Field uint32_key_hot_level;
        public final PBUInt32Field uint32_key_trans_flag;
        public final PBUInt32Field uint32_last_boat_time;
        public final PBUInt32Field uint32_lover_flag;
        public final PBUInt32Field uint32_notify_type;
        public final PBUInt64Field uint64_last_key_time;
        public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0);
        public final PBUInt32Field uint32_praise_hot_level = PBField.initUInt32(0);
        public final PBUInt32Field uint32_chat_hot_level = PBField.initUInt32(0);
        public final PBUInt32Field uint32_praise_hot_days = PBField.initUInt32(0);
        public final PBUInt32Field uint32_chat_hot_days = PBField.initUInt32(0);
        public final PBUInt32Field uint32_close_level = PBField.initUInt32(0);
        public final PBUInt32Field uint32_close_days = PBField.initUInt32(0);
        public final PBUInt32Field uint32_praise_flag = PBField.initUInt32(0);
        public final PBUInt32Field uint32_chat_flag = PBField.initUInt32(0);
        public final PBUInt32Field uint32_close_flag = PBField.initUInt32(0);
        public final PBUInt64Field uint64_notify_time = PBField.initUInt64(0);
        public final PBUInt64Field uint64_last_praise_time = PBField.initUInt64(0);
        public final PBUInt64Field uint64_last_chat_time = PBField.initUInt64(0);
        public final PBUInt32Field uint32_qzone_hot_level = PBField.initUInt32(0);
        public final PBUInt32Field uint32_qzone_hot_days = PBField.initUInt32(0);
        public final PBUInt32Field uint32_qzone_flag = PBField.initUInt32(0);
        public final PBUInt64Field uint64_last_qzone_time = PBField.initUInt64(0);
        public final PBUInt32Field uint32_show_recheck_entry = PBField.initUInt32(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 128, 136, 408, 418, 800, 1600, 1608, QZoneContant.QZ_START_FEED_DETAIL_REQ, 1624, 1634, 1640, 1648, 1656, 1666, 1674, WnsError.WNS_CODE_DIS_STAT_BEGIN, JsonGrayBusiId.GROUP_AIO_UNREAD_MSG_AI_SUMMARY, 2416, 2424, 2434, g.T0, 3210}, new String[]{"uint64_dst_uin", "uint32_praise_hot_level", "uint32_chat_hot_level", "uint32_praise_hot_days", "uint32_chat_hot_days", "uint32_close_level", "uint32_close_days", "uint32_praise_flag", "uint32_chat_flag", "uint32_close_flag", "uint64_notify_time", "uint64_last_praise_time", "uint64_last_chat_time", "uint32_qzone_hot_level", "uint32_qzone_hot_days", "uint32_qzone_flag", "uint64_last_qzone_time", "uint32_show_recheck_entry", "bytes_wildcard_wording", "uint32_lover_flag", "uint32_key_hot_level", "uint32_key_hot_days", "uint32_key_flag", "uint64_last_key_time", "bytes_key_wording", "uint32_key_trans_flag", "loverKeyBusinessType", "loverKeySubBusinessType", "loverKeyMainWording", "loverKeyLinkWording", "uint32_boat_level", "uint32_boat_days", "uint32_boat_flag", "uint32_last_boat_time", "bytes_boat_wording", "uint32_notify_type", "msg_friendship_flag_notify"}, new Object[]{0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0L, 0L, 0L, 0, 0, 0, 0L, 0, byteStringMicro, 0, 0, 0, 0, 0L, byteStringMicro, 0, 0, 0, byteStringMicro, byteStringMicro, 0, 0, 0, 0, byteStringMicro, 0, null}, submsgtype0xc7$HotFriendNotify.class);
        }

        /* JADX WARN: Type inference failed for: r0v14, types: [tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7$FriendShipFlagNotify] */
        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_wildcard_wording = PBField.initBytes(byteStringMicro);
            this.uint32_lover_flag = PBField.initUInt32(0);
            this.uint32_key_hot_level = PBField.initUInt32(0);
            this.uint32_key_hot_days = PBField.initUInt32(0);
            this.uint32_key_flag = PBField.initUInt32(0);
            this.uint64_last_key_time = PBField.initUInt64(0L);
            this.bytes_key_wording = PBField.initBytes(byteStringMicro);
            this.uint32_key_trans_flag = PBField.initUInt32(0);
            this.loverKeyBusinessType = PBField.initUInt32(0);
            this.loverKeySubBusinessType = PBField.initUInt32(0);
            this.loverKeyMainWording = PBField.initBytes(byteStringMicro);
            this.loverKeyLinkWording = PBField.initBytes(byteStringMicro);
            this.uint32_boat_level = PBField.initUInt32(0);
            this.uint32_boat_days = PBField.initUInt32(0);
            this.uint32_boat_flag = PBField.initUInt32(0);
            this.uint32_last_boat_time = PBField.initUInt32(0);
            this.bytes_boat_wording = PBField.initBytes(byteStringMicro);
            this.uint32_notify_type = PBField.initUInt32(0);
            this.msg_friendship_flag_notify = new MessageMicro<submsgtype0xc7$FriendShipFlagNotify>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7$FriendShipFlagNotify
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64}, new String[]{"uint64_dst_uin", "uint32_level_1", "uint32_level_2", "uint32_continuity_days", "uint32_chat_flag", "uint64_last_chat_time", "uint64_notify_time", "uint32_seq"}, new Object[]{0L, 0, 0, 0, 0, 0L, 0L, 0}, submsgtype0xc7$FriendShipFlagNotify.class);
                public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0);
                public final PBUInt32Field uint32_level_1 = PBField.initUInt32(0);
                public final PBUInt32Field uint32_level_2 = PBField.initUInt32(0);
                public final PBUInt32Field uint32_continuity_days = PBField.initUInt32(0);
                public final PBUInt32Field uint32_chat_flag = PBField.initUInt32(0);
                public final PBUInt64Field uint64_last_chat_time = PBField.initUInt64(0);
                public final PBUInt64Field uint64_notify_time = PBField.initUInt64(0);
                public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
            };
        }
    };
    public submsgtype0xc7$RelationalChainChange msg_relational_chain_change = new submsgtype0xc7$RelationalChainChange();
}
