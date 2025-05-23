package tencent.im.oidb.cmd0x8f9;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8f9$ReqBody extends MessageMicro<oidb_0x8f9$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98}, new String[]{"msg_source_id", "msg_req_by_top", "msg_req_by_time", "msg_req_by_id", "msg_req_comment_by_top", "msg_req_by_type", "msg_req_get_theme_list", "msg_req_themecont_by_top", "msg_req_async_feeds", "msg_req_get_litemail_list_by_uin", "msg_set_all_litemail_readed_by_endtime", "msg_req_get_latest_node_info"}, new Object[]{null, null, null, null, null, null, null, null, null, null, null, null}, oidb_0x8f9$ReqBody.class);
    public oidb_0x8f9$SourceID msg_source_id = new oidb_0x8f9$SourceID();
    public oidb_0x8f9$GetFeedsByTopReq msg_req_by_top = new MessageMicro<oidb_0x8f9$GetFeedsByTopReq>() { // from class: tencent.im.oidb.cmd0x8f9.oidb_0x8f9$GetFeedsByTopReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"int32_req_start", "uint32_req_num"}, new Object[]{0, 0}, oidb_0x8f9$GetFeedsByTopReq.class);
        public final PBInt32Field int32_req_start = PBField.initInt32(0);
        public final PBUInt32Field uint32_req_num = PBField.initUInt32(0);
    };
    public oidb_0x8f9$GetFeedsByTimeReq msg_req_by_time = new MessageMicro<oidb_0x8f9$GetFeedsByTimeReq>() { // from class: tencent.im.oidb.cmd0x8f9.oidb_0x8f9$GetFeedsByTimeReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_begin_time", "uint32_end_time", "uint32_req_num"}, new Object[]{0, 0, 0}, oidb_0x8f9$GetFeedsByTimeReq.class);
        public final PBUInt32Field uint32_begin_time = PBField.initUInt32(0);
        public final PBUInt32Field uint32_end_time = PBField.initUInt32(0);
        public final PBUInt32Field uint32_req_num = PBField.initUInt32(0);
    };
    public oidb_0x8f9$GetFeedsByIDReq msg_req_by_id = new MessageMicro<oidb_0x8f9$GetFeedsByIDReq>() { // from class: tencent.im.oidb.cmd0x8f9.oidb_0x8f9$GetFeedsByIDReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_feeds_id"}, new Object[]{ByteStringMicro.EMPTY}, oidb_0x8f9$GetFeedsByIDReq.class);
        public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public oidb_0x8f9$GetCommentsByTopReq msg_req_comment_by_top = new MessageMicro<oidb_0x8f9$GetCommentsByTopReq>() { // from class: tencent.im.oidb.cmd0x8f9.oidb_0x8f9$GetCommentsByTopReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"bytes_feeds_id", "int32_req_start", "uint32_req_num"}, new Object[]{ByteStringMicro.EMPTY, 0, 0}, oidb_0x8f9$GetCommentsByTopReq.class);
        public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBInt32Field int32_req_start = PBField.initInt32(0);
        public final PBUInt32Field uint32_req_num = PBField.initUInt32(0);
    };
    public oidb_0x8f9$GetFeedsByTypeReq msg_req_by_type = new MessageMicro<oidb_0x8f9$GetFeedsByTypeReq>() { // from class: tencent.im.oidb.cmd0x8f9.oidb_0x8f9$GetFeedsByTypeReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_feeds_type", "int32_req_start", "uint32_req_num"}, new Object[]{0, 0, 0}, oidb_0x8f9$GetFeedsByTypeReq.class);
        public final PBUInt32Field uint32_feeds_type = PBField.initUInt32(0);
        public final PBInt32Field int32_req_start = PBField.initInt32(0);
        public final PBUInt32Field uint32_req_num = PBField.initUInt32(0);
    };
    public oidb_0x8f9$GetFeedsByTopReq msg_req_get_theme_list = new MessageMicro<oidb_0x8f9$GetFeedsByTopReq>() { // from class: tencent.im.oidb.cmd0x8f9.oidb_0x8f9$GetFeedsByTopReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"int32_req_start", "uint32_req_num"}, new Object[]{0, 0}, oidb_0x8f9$GetFeedsByTopReq.class);
        public final PBInt32Field int32_req_start = PBField.initInt32(0);
        public final PBUInt32Field uint32_req_num = PBField.initUInt32(0);
    };
    public oidb_0x8f9$GetCommentsByTopReq msg_req_themecont_by_top = new MessageMicro<oidb_0x8f9$GetCommentsByTopReq>() { // from class: tencent.im.oidb.cmd0x8f9.oidb_0x8f9$GetCommentsByTopReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"bytes_feeds_id", "int32_req_start", "uint32_req_num"}, new Object[]{ByteStringMicro.EMPTY, 0, 0}, oidb_0x8f9$GetCommentsByTopReq.class);
        public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBInt32Field int32_req_start = PBField.initInt32(0);
        public final PBUInt32Field uint32_req_num = PBField.initUInt32(0);
    };
    public oidb_0x8f9$GetAsyncMsgFeedsReq msg_req_async_feeds = new MessageMicro<oidb_0x8f9$GetAsyncMsgFeedsReq>() { // from class: tencent.im.oidb.cmd0x8f9.oidb_0x8f9$GetAsyncMsgFeedsReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"int32_req_start", "uint32_req_num"}, new Object[]{0, 0}, oidb_0x8f9$GetAsyncMsgFeedsReq.class);
        public final PBInt32Field int32_req_start = PBField.initInt32(0);
        public final PBUInt32Field uint32_req_num = PBField.initUInt32(0);
    };
    public oidb_0x8f9$GetLiteMailListByUinReq msg_req_get_litemail_list_by_uin = new MessageMicro<oidb_0x8f9$GetLiteMailListByUinReq>() { // from class: tencent.im.oidb.cmd0x8f9.oidb_0x8f9$GetLiteMailListByUinReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"uint32_end_time", "rpt_msg_litemail_list", "uint32_amount", "msg_filter"}, new Object[]{0, null, 0, null}, oidb_0x8f9$GetLiteMailListByUinReq.class);
        public final PBUInt32Field uint32_end_time = PBField.initUInt32(0);
        public final PBRepeatMessageField<oidb_0x8f9$LiteMailBrief> rpt_msg_litemail_list = PBField.initRepeatMessage(oidb_0x8f9$LiteMailBrief.class);
        public final PBUInt32Field uint32_amount = PBField.initUInt32(0);
        public oidb_0x8f9$LiteMailFilter msg_filter = new MessageMicro<oidb_0x8f9$LiteMailFilter>() { // from class: tencent.im.oidb.cmd0x8f9.oidb_0x8f9$LiteMailFilter
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_filter_type"}, new Object[]{0}, oidb_0x8f9$LiteMailFilter.class);
            public final PBUInt32Field uint32_filter_type = PBField.initUInt32(0);
        };
    };
    public oidb_0x8f9$SetAllLiteMailReadedByEndTimeReq msg_set_all_litemail_readed_by_endtime = new MessageMicro<oidb_0x8f9$SetAllLiteMailReadedByEndTimeReq>() { // from class: tencent.im.oidb.cmd0x8f9.oidb_0x8f9$SetAllLiteMailReadedByEndTimeReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_end_time"}, new Object[]{0}, oidb_0x8f9$SetAllLiteMailReadedByEndTimeReq.class);
        public final PBUInt32Field uint32_end_time = PBField.initUInt32(0);
    };
    public oidb_0x8f9$GetLatestNodeInfoReq msg_req_get_latest_node_info = new MessageMicro<oidb_0x8f9$GetLatestNodeInfoReq>() { // from class: tencent.im.oidb.cmd0x8f9.oidb_0x8f9$GetLatestNodeInfoReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_node_type", "uint32_unread_count_flag"}, new Object[]{0, 0}, oidb_0x8f9$GetLatestNodeInfoReq.class);
        public final PBUInt32Field uint32_node_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_unread_count_flag = PBField.initUInt32(0);
    };
}
