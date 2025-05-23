package tencent.im.oidb.cmd0x8f9;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.trunk.feeds_inner_define.feeds_inner_define$FaceRecordSet;
import com.trunk.group_feeds.group_feeds$GroupFeedsMessage;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8f9$GroupFeedsRecord extends MessageMicro<oidb_0x8f9$GroupFeedsRecord> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_feeds_id;
    public final PBBytesField bytes_reserve;
    public feeds_inner_define$FaceRecordSet msg_face_record;
    public group_feeds$GroupFeedsMessage msg_feeds_content;
    public oidb_0x8f9$FeedsState msg_feeds_state;
    public final PBRepeatMessageField<oidb_0x8f9$ConcernUinInfo> rpt_concern_uin_info;
    public final PBRepeatMessageField<oidb_0x8f9$GroupFeedsCommentRecord> rpt_msg_comments;
    public final PBUInt32Field uint32_comment_num;
    public final PBUInt32Field uint32_create_time;
    public final PBUInt32Field uint32_feeds_flag;
    public final PBUInt32Field uint32_modify_time;
    public final PBUInt32Field uint32_visit_count;
    public oidb_0x8f9$SourceID msg_source_id = new oidb_0x8f9$SourceID();
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_feeds_type = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 40, 48, 56, 64, 72, 82, 90, 98, 106, 114, 122}, new String[]{"msg_source_id", "uint64_from_uin", "uint32_feeds_type", "bytes_feeds_id", "uint32_feeds_flag", "uint32_create_time", "uint32_modify_time", "uint32_visit_count", "uint32_comment_num", "bytes_reserve", "msg_face_record", "msg_feeds_content", "rpt_msg_comments", "rpt_concern_uin_info", "msg_feeds_state"}, new Object[]{null, 0L, 0, byteStringMicro, 0, 0, 0, 0, 0, byteStringMicro, null, null, null, null, null}, oidb_0x8f9$GroupFeedsRecord.class);
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [tencent.im.oidb.cmd0x8f9.oidb_0x8f9$FeedsState] */
    public oidb_0x8f9$GroupFeedsRecord() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_feeds_id = PBField.initBytes(byteStringMicro);
        this.uint32_feeds_flag = PBField.initUInt32(0);
        this.uint32_create_time = PBField.initUInt32(0);
        this.uint32_modify_time = PBField.initUInt32(0);
        this.uint32_visit_count = PBField.initUInt32(0);
        this.uint32_comment_num = PBField.initUInt32(0);
        this.bytes_reserve = PBField.initBytes(byteStringMicro);
        this.msg_face_record = new feeds_inner_define$FaceRecordSet();
        this.msg_feeds_content = new group_feeds$GroupFeedsMessage();
        this.rpt_msg_comments = PBField.initRepeatMessage(oidb_0x8f9$GroupFeedsCommentRecord.class);
        this.rpt_concern_uin_info = PBField.initRepeatMessage(oidb_0x8f9$ConcernUinInfo.class);
        this.msg_feeds_state = new MessageMicro<oidb_0x8f9$FeedsState>() { // from class: tencent.im.oidb.cmd0x8f9.oidb_0x8f9$FeedsState
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_concern_flag", "uint32_readed_flag", "uint32_ignored_flag"}, new Object[]{0, 0, 0}, oidb_0x8f9$FeedsState.class);
            public final PBUInt32Field uint32_concern_flag = PBField.initUInt32(0);
            public final PBUInt32Field uint32_readed_flag = PBField.initUInt32(0);
            public final PBUInt32Field uint32_ignored_flag = PBField.initUInt32(0);
        };
    }
}
