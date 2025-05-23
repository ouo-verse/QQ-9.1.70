package tencent.im.oidb.cmd0xbde;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xbde$TopicInfo extends MessageMicro<oidb_cmd0xbde$TopicInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_topic_cover_url;
    public final PBBytesField bytes_topic_name;
    public final PBBytesField bytes_topic_summary;
    public final PBBytesField bytes_topic_url;
    public final PBUInt64Field uint64_discuss_num;
    public final PBUInt64Field uint64_read_num;
    public final PBUInt64Field uint64_topic_id = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 48, 56}, new String[]{"uint64_topic_id", "bytes_topic_name", "bytes_topic_url", "bytes_topic_cover_url", "bytes_topic_summary", "uint64_read_num", "uint64_discuss_num"}, new Object[]{0L, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0L, 0L}, oidb_cmd0xbde$TopicInfo.class);
    }

    public oidb_cmd0xbde$TopicInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_topic_name = PBField.initBytes(byteStringMicro);
        this.bytes_topic_url = PBField.initBytes(byteStringMicro);
        this.bytes_topic_cover_url = PBField.initBytes(byteStringMicro);
        this.bytes_topic_summary = PBField.initBytes(byteStringMicro);
        this.uint64_read_num = PBField.initUInt64(0L);
        this.uint64_discuss_num = PBField.initUInt64(0L);
    }
}
