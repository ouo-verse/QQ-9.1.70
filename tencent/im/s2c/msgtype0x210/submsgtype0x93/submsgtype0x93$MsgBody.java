package tencent.im.s2c.msgtype0x210.submsgtype0x93;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0x93$MsgBody extends MessageMicro<submsgtype0x93$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_msg_type", "msg_umc_changed", "msg_state_changed"}, new Object[]{0, null, null}, submsgtype0x93$MsgBody.class);
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
    public submsgtype0x93$UnreadMailCountChanged msg_umc_changed = new MessageMicro<submsgtype0x93$UnreadMailCountChanged>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x93.submsgtype0x93$UnreadMailCountChanged
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_umc"}, new Object[]{null}, submsgtype0x93$UnreadMailCountChanged.class);
        public submsgtype0x93$UnreadMailCountInfo msg_umc = new MessageMicro<submsgtype0x93$UnreadMailCountInfo>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x93.submsgtype0x93$UnreadMailCountInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_unread_count", "uint32_data_version"}, new Object[]{0, 0}, submsgtype0x93$UnreadMailCountInfo.class);
            public final PBUInt32Field uint32_unread_count = PBField.initUInt32(0);
            public final PBUInt32Field uint32_data_version = PBField.initUInt32(0);
        };
    };
    public submsgtype0x93$StateChangeNotify msg_state_changed = new MessageMicro<submsgtype0x93$StateChangeNotify>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x93.submsgtype0x93$StateChangeNotify
        public static final int MSG_TYPE_ADD_COMMENT = 2;
        public static final int MSG_TYPE_CANCEL_INGORE = 5;
        public static final int MSG_TYPE_CREATE = 1;
        public static final int MSG_TYPE_DEL = 6;
        public static final int MSG_TYPE_DEL_INDEX = 7;
        public static final int MSG_TYPE_INGORED = 4;
        public static final int MSG_TYPE_READED = 3;
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_ext_msg;
        public final PBBytesField bytes_feeds_id;
        public final PBEnumField enum_msg_type;
        public submsgtype0x93$SourceID msg_source_id = new submsgtype0x93$SourceID();
        public final PBRepeatMessageField<submsgtype0x93$LiteMailIndexInfo> rpt_msg_lite_mail_index;
        public final PBUInt64Field uint64_req_uin;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 40, 50}, new String[]{"msg_source_id", "bytes_feeds_id", "enum_msg_type", "bytes_ext_msg", "uint64_req_uin", "rpt_msg_lite_mail_index"}, new Object[]{null, byteStringMicro, 1, byteStringMicro, 0L, null}, submsgtype0x93$StateChangeNotify.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_feeds_id = PBField.initBytes(byteStringMicro);
            this.enum_msg_type = PBField.initEnum(1);
            this.bytes_ext_msg = PBField.initBytes(byteStringMicro);
            this.uint64_req_uin = PBField.initUInt64(0L);
            this.rpt_msg_lite_mail_index = PBField.initRepeatMessage(submsgtype0x93$LiteMailIndexInfo.class);
        }
    };
}
