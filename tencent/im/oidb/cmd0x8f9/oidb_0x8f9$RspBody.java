package tencent.im.oidb.cmd0x8f9;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8f9$RspBody extends MessageMicro<oidb_0x8f9$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48, 56, 66, 74, 82}, new String[]{"msg_source_id", "msg_result_msg", "rpt_feeds_recored", "rpt_feeds_comments", "uint32_last_modify_time", "uint32_feeds_rsp_flag", "uint32_unread_num", "msg_litemail_list", "msg_set_all_litemail_readed_by_endtime", "msg_rsp_get_latest_node_info"}, new Object[]{null, null, null, null, 0, 0, 0, null, null, null}, oidb_0x8f9$RspBody.class);
    public oidb_0x8f9$SourceID msg_source_id = new oidb_0x8f9$SourceID();
    public oidb_0x8f9$ResultMsg msg_result_msg = new oidb_0x8f9$ResultMsg();
    public final PBRepeatMessageField<oidb_0x8f9$GroupFeedsRecord> rpt_feeds_recored = PBField.initRepeatMessage(oidb_0x8f9$GroupFeedsRecord.class);
    public final PBRepeatMessageField<oidb_0x8f9$GroupFeedsCommentRecord> rpt_feeds_comments = PBField.initRepeatMessage(oidb_0x8f9$GroupFeedsCommentRecord.class);
    public final PBUInt32Field uint32_last_modify_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_feeds_rsp_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_unread_num = PBField.initUInt32(0);
    public oidb_0x8f9$GetLiteMailListByUinRsp msg_litemail_list = new MessageMicro<oidb_0x8f9$GetLiteMailListByUinRsp>() { // from class: tencent.im.oidb.cmd0x8f9.oidb_0x8f9$GetLiteMailListByUinRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42}, new String[]{"uint32_start_time", "uint32_end_time", "rpt_msg_litemail_list", "uint32_result", "bytes_err_msg"}, new Object[]{0, 0, null, 0, ByteStringMicro.EMPTY}, oidb_0x8f9$GetLiteMailListByUinRsp.class);
        public final PBUInt32Field uint32_start_time = PBField.initUInt32(0);
        public final PBUInt32Field uint32_end_time = PBField.initUInt32(0);
        public final PBRepeatMessageField<oidb_0x8f9$LiteMail> rpt_msg_litemail_list = PBField.initRepeatMessage(oidb_0x8f9$LiteMail.class);
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);
        public final PBBytesField bytes_err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public oidb_0x8f9$SetAllLiteMailReadedByEndTimeRsp msg_set_all_litemail_readed_by_endtime = new MessageMicro<oidb_0x8f9$SetAllLiteMailReadedByEndTimeRsp>() { // from class: tencent.im.oidb.cmd0x8f9.oidb_0x8f9$SetAllLiteMailReadedByEndTimeRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_result", "bytes_err_msg"}, new Object[]{0, ByteStringMicro.EMPTY}, oidb_0x8f9$SetAllLiteMailReadedByEndTimeRsp.class);
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);
        public final PBBytesField bytes_err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public oidb_0x8f9$GetLatestNodeInfoRsp msg_rsp_get_latest_node_info = new MessageMicro<oidb_0x8f9$GetLatestNodeInfoRsp>() { // from class: tencent.im.oidb.cmd0x8f9.oidb_0x8f9$GetLatestNodeInfoRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"uint32_result", "bytes_err_msg", "msg_litemail_brief", "msg_unread_cnt_info"}, new Object[]{0, ByteStringMicro.EMPTY, null, null}, oidb_0x8f9$GetLatestNodeInfoRsp.class);
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);
        public final PBBytesField bytes_err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
        public oidb_0x8f9$LiteMailBrief msg_litemail_brief = new MessageMicro<oidb_0x8f9$LiteMailBrief>() { // from class: tencent.im.oidb.cmd0x8f9.oidb_0x8f9$LiteMailBrief
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBBytesField bytes_feeds_id;
            public final PBBytesField bytes_feeds_summary;
            public oidb_0x8f9$SourceID msg_source_id;
            public final PBUInt32Field uint32_create_time;
            public final PBUInt32Field uint32_last_modify_time;
            public final PBUInt32Field uint32_my_read_status;
            public final PBUInt32Field uint32_summary_truncate_flag;
            public final PBUInt64Field uint64_author_uin;

            static {
                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 48, 58, 64}, new String[]{"bytes_feeds_id", "msg_source_id", "uint32_last_modify_time", "uint32_create_time", "uint32_my_read_status", "uint64_author_uin", "bytes_feeds_summary", "uint32_summary_truncate_flag"}, new Object[]{byteStringMicro, null, 0, 0, 0, 0L, byteStringMicro, 0}, oidb_0x8f9$LiteMailBrief.class);
            }

            {
                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                this.bytes_feeds_id = PBField.initBytes(byteStringMicro);
                this.msg_source_id = new oidb_0x8f9$SourceID();
                this.uint32_last_modify_time = PBField.initUInt32(0);
                this.uint32_create_time = PBField.initUInt32(0);
                this.uint32_my_read_status = PBField.initUInt32(0);
                this.uint64_author_uin = PBField.initUInt64(0L);
                this.bytes_feeds_summary = PBField.initBytes(byteStringMicro);
                this.uint32_summary_truncate_flag = PBField.initUInt32(0);
            }
        };
        public oidb_0x8f9$UnreadMailCountInfo msg_unread_cnt_info = new MessageMicro<oidb_0x8f9$UnreadMailCountInfo>() { // from class: tencent.im.oidb.cmd0x8f9.oidb_0x8f9$UnreadMailCountInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint64_uin", "uint32_unread_count", "uint32_data_version"}, new Object[]{0L, 0, 0}, oidb_0x8f9$UnreadMailCountInfo.class);
            public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
            public final PBUInt32Field uint32_unread_count = PBField.initUInt32(0);
            public final PBUInt32Field uint32_data_version = PBField.initUInt32(0);
        };
    };
}
