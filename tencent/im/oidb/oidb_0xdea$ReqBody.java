package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xdea$ReqBody extends MessageMicro<oidb_0xdea$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"add_barrage_req", "get_barrage_list_req", "rpt_recall_barrage_req_list", "rpt_delete_barrage_req_list", "get_topic_req", "get_comment_req"}, new Object[]{null, null, null, null, null, null}, oidb_0xdea$ReqBody.class);
    public oidb_0xdea$AddBarrageReqBody add_barrage_req = new MessageMicro<oidb_0xdea$AddBarrageReqBody>() { // from class: tencent.im.oidb.oidb_0xdea$AddBarrageReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint64_group_code", "comment", "topic"}, new Object[]{0L, null, null}, oidb_0xdea$AddBarrageReqBody.class);
        public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
        public oidb_0xdea$Comment comment = new MessageMicro<oidb_0xdea$Comment>() { // from class: tencent.im.oidb.oidb_0xdea$Comment
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBBytesField bytes_comment_msg;
            public final PBBytesField bytes_nick;
            public final PBBytesField bytes_pass_through;
            public final PBUInt32Field uint32_comment_ctime;
            public final PBUInt32Field uint32_source;
            public final PBUInt64Field uint64_comment_uin = PBField.initUInt64(0);
            public final PBUInt64Field uint64_seq = PBField.initUInt64(0);
            public final PBUInt64Field uint64_comment_location = PBField.initUInt64(0);

            static {
                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{16, 24, 32, 42, 50, 56, 66, 72}, new String[]{"uint64_comment_uin", "uint64_seq", "uint64_comment_location", "bytes_comment_msg", "bytes_pass_through", "uint32_comment_ctime", "bytes_nick", "uint32_source"}, new Object[]{0L, 0L, 0L, byteStringMicro, byteStringMicro, 0, byteStringMicro, 0}, oidb_0xdea$Comment.class);
            }

            {
                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                this.bytes_comment_msg = PBField.initBytes(byteStringMicro);
                this.bytes_pass_through = PBField.initBytes(byteStringMicro);
                this.uint32_comment_ctime = PBField.initUInt32(0);
                this.bytes_nick = PBField.initBytes(byteStringMicro);
                this.uint32_source = PBField.initUInt32(0);
            }
        };
        public oidb_0xdea$Topic topic = new MessageMicro<oidb_0xdea$Topic>() { // from class: tencent.im.oidb.oidb_0xdea$Topic
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42}, new String[]{"uint64_send_uin", "uint64_seq", "uint32_send_time", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "bytes_src_msg"}, new Object[]{0L, 0L, 0, 1, ByteStringMicro.EMPTY}, oidb_0xdea$Topic.class);
            public final PBUInt64Field uint64_send_uin = PBField.initUInt64(0);
            public final PBUInt64Field uint64_seq = PBField.initUInt64(0);
            public final PBUInt32Field uint32_send_time = PBField.initUInt32(0);
            public final PBEnumField entrance = PBField.initEnum(1);
            public final PBBytesField bytes_src_msg = PBField.initBytes(ByteStringMicro.EMPTY);
        };
    };
    public oidb_0xdea$GetBarrageListReqBody get_barrage_list_req = new MessageMicro<oidb_0xdea$GetBarrageListReqBody>() { // from class: tencent.im.oidb.oidb_0xdea$GetBarrageListReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72}, new String[]{"uint64_group_code", "uint64_barrage_seq", "uint32_last_update_time", "uint32_start_index", "uint32_barrage_count", "uint32_video_start_time", "uint32_video_end_time", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "terminal"}, new Object[]{0L, 0L, 0, 0, 0, 0, 0, 1, 0}, oidb_0xdea$GetBarrageListReqBody.class);
        public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
        public final PBUInt64Field uint64_barrage_seq = PBField.initUInt64(0);
        public final PBUInt32Field uint32_last_update_time = PBField.initUInt32(0);
        public final PBUInt32Field uint32_start_index = PBField.initUInt32(0);
        public final PBUInt32Field uint32_barrage_count = PBField.initUInt32(0);
        public final PBUInt32Field uint32_video_start_time = PBField.initUInt32(0);
        public final PBUInt32Field uint32_video_end_time = PBField.initUInt32(0);
        public final PBEnumField entrance = PBField.initEnum(1);
        public final PBEnumField terminal = PBField.initEnum(0);
    };
    public final PBRepeatMessageField<oidb_0xdea$RecallBarrageReqBody> rpt_recall_barrage_req_list = PBField.initRepeatMessage(oidb_0xdea$RecallBarrageReqBody.class);
    public final PBRepeatMessageField<oidb_0xdea$DeleteBarrageReqBody> rpt_delete_barrage_req_list = PBField.initRepeatMessage(oidb_0xdea$DeleteBarrageReqBody.class);
    public oidb_0xdea$GetTopicReqBody get_topic_req = new MessageMicro<oidb_0xdea$GetTopicReqBody>() { // from class: tencent.im.oidb.oidb_0xdea$GetTopicReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], oidb_0xdea$GetTopicReqBody.class);
    };
    public oidb_0xdea$GetCommentReqBody get_comment_req = new MessageMicro<oidb_0xdea$GetCommentReqBody>() { // from class: tencent.im.oidb.oidb_0xdea$GetCommentReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], oidb_0xdea$GetCommentReqBody.class);
    };
}
