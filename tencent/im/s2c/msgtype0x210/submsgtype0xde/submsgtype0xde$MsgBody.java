package tencent.im.s2c.msgtype0x210.submsgtype0xde;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0xde$MsgBody extends MessageMicro<submsgtype0xde$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_union_id;
    public final PBBytesField bytes_vid;
    public final PBBytesField bytes_video_cover;
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uid;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42}, new String[]{"uint32_msg_type", "bytes_union_id", "uint64_uid", "bytes_vid", "bytes_video_cover"}, new Object[]{0, byteStringMicro, 0L, byteStringMicro, byteStringMicro}, submsgtype0xde$MsgBody.class);
    }

    public submsgtype0xde$MsgBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_union_id = PBField.initBytes(byteStringMicro);
        this.uint64_uid = PBField.initUInt64(0L);
        this.bytes_vid = PBField.initBytes(byteStringMicro);
        this.bytes_video_cover = PBField.initBytes(byteStringMicro);
    }
}
