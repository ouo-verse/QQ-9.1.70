package tencent.im.oidb.cmd0x8f6;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x8f6$ReqBody extends MessageMicro<oidb_cmd0x8f6$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"uint32_subcmd", "msg_get_umc", "msg_dec_umc", "msg_inc_umc"}, new Object[]{0, null, null, null}, oidb_cmd0x8f6$ReqBody.class);
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
    public oidb_cmd0x8f6$GetUnreadMailCountReq msg_get_umc = new MessageMicro<oidb_cmd0x8f6$GetUnreadMailCountReq>() { // from class: tencent.im.oidb.cmd0x8f6.oidb_cmd0x8f6$GetUnreadMailCountReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], oidb_cmd0x8f6$GetUnreadMailCountReq.class);
    };
    public oidb_cmd0x8f6$DecreaseUnreadMailCountReq msg_dec_umc = new MessageMicro<oidb_cmd0x8f6$DecreaseUnreadMailCountReq>() { // from class: tencent.im.oidb.cmd0x8f6.oidb_cmd0x8f6$DecreaseUnreadMailCountReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40}, new String[]{"uint32_type", "uint32_amount", "rpt_msg_indexes", "msg_recalled_index", "uint32_data_version"}, new Object[]{0, 0, null, null, 0}, oidb_cmd0x8f6$DecreaseUnreadMailCountReq.class);
        public final PBUInt32Field uint32_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_amount = PBField.initUInt32(0);
        public final PBUInt32Field uint32_data_version = PBField.initUInt32(0);
        public final PBRepeatMessageField<oidb_cmd0x8f6$LiteMailIndex> rpt_msg_indexes = PBField.initRepeatMessage(oidb_cmd0x8f6$LiteMailIndex.class);
        public oidb_cmd0x8f6$LiteMailIndex msg_recalled_index = new MessageMicro<oidb_cmd0x8f6$LiteMailIndex>() { // from class: tencent.im.oidb.cmd0x8f6.oidb_cmd0x8f6$LiteMailIndex
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"msg_source", "bytes_feeds_id", "uint64_author_uin", "rpt_msg_concern_uin_list"}, new Object[]{null, ByteStringMicro.EMPTY, 0L, null}, oidb_cmd0x8f6$LiteMailIndex.class);
            public oidb_cmd0x8f6$SourceID msg_source = new MessageMicro<oidb_cmd0x8f6$SourceID>() { // from class: tencent.im.oidb.cmd0x8f6.oidb_cmd0x8f6$SourceID
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_source_type", "uint64_source_code"}, new Object[]{0, 0L}, oidb_cmd0x8f6$SourceID.class);
                public final PBUInt32Field uint32_source_type = PBField.initUInt32(0);
                public final PBUInt64Field uint64_source_code = PBField.initUInt64(0);
            };
            public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
            public final PBUInt64Field uint64_author_uin = PBField.initUInt64(0);
            public final PBRepeatMessageField<oidb_cmd0x8f6$ConcernInfo> rpt_msg_concern_uin_list = PBField.initRepeatMessage(oidb_cmd0x8f6$ConcernInfo.class);
        };
    };
    public oidb_cmd0x8f6$IncUnreadMailCountReq msg_inc_umc = new MessageMicro<oidb_cmd0x8f6$IncUnreadMailCountReq>() { // from class: tencent.im.oidb.cmd0x8f6.oidb_cmd0x8f6$IncUnreadMailCountReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_unread"}, new Object[]{null}, oidb_cmd0x8f6$IncUnreadMailCountReq.class);
        public final PBRepeatMessageField<oidb_cmd0x8f6$UnreadMailCountInfo> rpt_msg_unread = PBField.initRepeatMessage(oidb_cmd0x8f6$UnreadMailCountInfo.class);
    };
}
