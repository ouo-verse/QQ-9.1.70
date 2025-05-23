package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xc0c$ReqBody extends MessageMicro<oidb_0xc0c$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42}, new String[]{"uint64_uin", "uint32_task_type", "bytes_rowkey", "uint64_feeds_id", "msg_video_from_type"}, new Object[]{0L, 0, ByteStringMicro.EMPTY, 0L, null}, oidb_0xc0c$ReqBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_task_type = PBField.initUInt32(0);
    public final PBBytesField bytes_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0);
    public oidb_0xc0c$VideoSrcType msg_video_from_type = new MessageMicro<oidb_0xc0c$VideoSrcType>() { // from class: tencent.im.oidb.oidb_0xc0c$VideoSrcType
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_source_type", "video_from_type"}, new Object[]{0, 0}, oidb_0xc0c$VideoSrcType.class);
        public final PBUInt32Field uint32_source_type = PBField.initUInt32(0);
        public final PBInt32Field video_from_type = PBField.initInt32(0);
    };
}
