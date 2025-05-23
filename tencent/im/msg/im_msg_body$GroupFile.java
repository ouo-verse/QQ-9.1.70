package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class im_msg_body$GroupFile extends MessageMicro<im_msg_body$GroupFile> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_batch_id;
    public final PBBytesField bytes_batch_item_id;
    public final PBBytesField bytes_file_id;
    public final PBBytesField bytes_file_key;
    public final PBBytesField bytes_filename;
    public final PBBytesField bytes_mark;
    public final PBBytesField bytes_pb_reserve;
    public final PBUInt32Field uint32_feed_msg_time;
    public final PBUInt64Field uint64_file_size;
    public final PBUInt64Field uint64_sequence;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 50, 56, 66, 72, 82}, new String[]{"bytes_filename", "uint64_file_size", "bytes_file_id", "bytes_batch_id", "bytes_file_key", "bytes_mark", "uint64_sequence", "bytes_batch_item_id", "uint32_feed_msg_time", "bytes_pb_reserve"}, new Object[]{byteStringMicro, 0L, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0L, byteStringMicro, 0, byteStringMicro}, im_msg_body$GroupFile.class);
    }

    public im_msg_body$GroupFile() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_filename = PBField.initBytes(byteStringMicro);
        this.uint64_file_size = PBField.initUInt64(0L);
        this.bytes_file_id = PBField.initBytes(byteStringMicro);
        this.bytes_batch_id = PBField.initBytes(byteStringMicro);
        this.bytes_file_key = PBField.initBytes(byteStringMicro);
        this.bytes_mark = PBField.initBytes(byteStringMicro);
        this.uint64_sequence = PBField.initUInt64(0L);
        this.bytes_batch_item_id = PBField.initBytes(byteStringMicro);
        this.uint32_feed_msg_time = PBField.initUInt32(0);
        this.bytes_pb_reserve = PBField.initBytes(byteStringMicro);
    }
}
