package tencent.im.longconn.longmsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class LongMsg$MsgUpReq extends MessageMicro<LongMsg$MsgUpReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_msg_content;
    public final PBBytesField bytes_msg_ukey;
    public final PBUInt32Field uint32_need_cache;
    public final PBUInt32Field uint32_store_type;
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_msg_id = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 50, 56}, new String[]{"uint32_msg_type", "uint64_dst_uin", "uint32_msg_id", "bytes_msg_content", "uint32_store_type", "bytes_msg_ukey", "uint32_need_cache"}, new Object[]{0, 0L, 0, byteStringMicro, 0, byteStringMicro, 0}, LongMsg$MsgUpReq.class);
    }

    public LongMsg$MsgUpReq() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_msg_content = PBField.initBytes(byteStringMicro);
        this.uint32_store_type = PBField.initUInt32(0);
        this.bytes_msg_ukey = PBField.initBytes(byteStringMicro);
        this.uint32_need_cache = PBField.initUInt32(0);
    }
}
