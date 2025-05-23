package tencent.im.oidb.cmd0x8f9;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.trunk.group_feeds.group_feeds$GroupFeedsMessage;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8f9$GroupFeedsCommentRecord extends MessageMicro<oidb_0x8f9$GroupFeedsCommentRecord> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_feeds_id;
    public final PBBytesField bytes_reserve;
    public group_feeds$GroupFeedsMessage msg_comment_content;
    public oidb_0x8f9$SourceID msg_source_id;
    public final PBUInt32Field uint32_comment_flag;
    public final PBUInt32Field uint32_comment_id;
    public final PBUInt32Field uint32_create_time;
    public final PBUInt32Field uint32_modify_time;
    public final PBUInt64Field uint64_from_uin;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 48, 56, 66, 74}, new String[]{"bytes_feeds_id", "msg_source_id", "uint64_from_uin", "uint32_comment_id", "uint32_comment_flag", "uint32_create_time", "uint32_modify_time", "bytes_reserve", "msg_comment_content"}, new Object[]{byteStringMicro, null, 0L, 0, 0, 0, 0, byteStringMicro, null}, oidb_0x8f9$GroupFeedsCommentRecord.class);
    }

    public oidb_0x8f9$GroupFeedsCommentRecord() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_feeds_id = PBField.initBytes(byteStringMicro);
        this.msg_source_id = new oidb_0x8f9$SourceID();
        this.uint64_from_uin = PBField.initUInt64(0L);
        this.uint32_comment_id = PBField.initUInt32(0);
        this.uint32_comment_flag = PBField.initUInt32(0);
        this.uint32_create_time = PBField.initUInt32(0);
        this.uint32_modify_time = PBField.initUInt32(0);
        this.bytes_reserve = PBField.initBytes(byteStringMicro);
        this.msg_comment_content = new group_feeds$GroupFeedsMessage();
    }
}
