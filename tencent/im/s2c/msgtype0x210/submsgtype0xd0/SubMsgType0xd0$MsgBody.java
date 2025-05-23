package tencent.im.s2c.msgtype0x210.submsgtype0xd0;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0xd0$MsgBody extends MessageMicro<SubMsgType0xd0$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_big_v_union_id;
    public final PBBytesField bytes_cover_url;
    public final PBBytesField bytes_hot_topic_name;
    public final PBBytesField bytes_link;
    public final PBBytesField bytes_msg_info;
    public final PBBytesField bytes_pgc_column_union_id;
    public final PBBytesField bytes_sub_type;
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pgc_type;
    public final PBUInt64Field uint64_big_v_id;
    public final PBUInt64Field uint64_hot_topic_id;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40, 50, 56, 66, 74, 82, 90}, new String[]{"uint32_msg_type", "bytes_msg_info", "uint64_hot_topic_id", "bytes_hot_topic_name", "uint64_big_v_id", "bytes_big_v_union_id", "uint32_pgc_type", "bytes_pgc_column_union_id", "bytes_link", "bytes_sub_type", "bytes_cover_url"}, new Object[]{0, byteStringMicro, 0L, byteStringMicro, 0L, byteStringMicro, 0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, SubMsgType0xd0$MsgBody.class);
    }

    public SubMsgType0xd0$MsgBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_msg_info = PBField.initBytes(byteStringMicro);
        this.uint64_hot_topic_id = PBField.initUInt64(0L);
        this.bytes_hot_topic_name = PBField.initBytes(byteStringMicro);
        this.uint64_big_v_id = PBField.initUInt64(0L);
        this.bytes_big_v_union_id = PBField.initBytes(byteStringMicro);
        this.uint32_pgc_type = PBField.initUInt32(0);
        this.bytes_pgc_column_union_id = PBField.initBytes(byteStringMicro);
        this.bytes_link = PBField.initBytes(byteStringMicro);
        this.bytes_sub_type = PBField.initBytes(byteStringMicro);
        this.bytes_cover_url = PBField.initBytes(byteStringMicro);
    }
}
