package tencent.im.oidb.cmd0xb54;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xb54$Topic extends MessageMicro<oidb_cmd0xb54$Topic> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_title;
    public final PBBytesField bytes_url;
    public final PBStringField str_rowkey;
    public final PBUInt64Field uint64_topic_id = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"uint64_topic_id", "bytes_title", "bytes_url", "str_rowkey"}, new Object[]{0L, byteStringMicro, byteStringMicro, ""}, oidb_cmd0xb54$Topic.class);
    }

    public oidb_cmd0xb54$Topic() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_title = PBField.initBytes(byteStringMicro);
        this.bytes_url = PBField.initBytes(byteStringMicro);
        this.str_rowkey = PBField.initString("");
    }
}
