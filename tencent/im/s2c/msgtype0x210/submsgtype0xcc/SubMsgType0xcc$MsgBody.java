package tencent.im.s2c.msgtype0x210.submsgtype0xcc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0xcc$MsgBody extends MessageMicro<SubMsgType0xcc$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cover_url;
    public final PBBytesField bytes_feed_id;
    public final PBBytesField bytes_msg_info;
    public final PBBytesField bytes_sub_type;
    public final PBBytesField bytes_union_id;
    public final PBBytesField bytes_vid;
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 50, 58, 66}, new String[]{"uint32_msg_type", "bytes_msg_info", "uint64_uin", "bytes_union_id", "bytes_sub_type", "bytes_feed_id", "bytes_vid", "bytes_cover_url"}, new Object[]{0, byteStringMicro, 0L, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, SubMsgType0xcc$MsgBody.class);
    }

    public SubMsgType0xcc$MsgBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_msg_info = PBField.initBytes(byteStringMicro);
        this.uint64_uin = PBField.initUInt64(0L);
        this.bytes_union_id = PBField.initBytes(byteStringMicro);
        this.bytes_sub_type = PBField.initBytes(byteStringMicro);
        this.bytes_feed_id = PBField.initBytes(byteStringMicro);
        this.bytes_vid = PBField.initBytes(byteStringMicro);
        this.bytes_cover_url = PBField.initBytes(byteStringMicro);
    }
}
