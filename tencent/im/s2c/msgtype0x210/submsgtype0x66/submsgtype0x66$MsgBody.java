package tencent.im.s2c.msgtype0x210.submsgtype0x66;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0x66$MsgBody extends MessageMicro<submsgtype0x66$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_notify_text;
    public final PBBytesField bytes_push_data;
    public final PBUInt32Field uint32_push_flag;
    public final PBUInt32Field uint32_timestamp;
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40}, new String[]{"uint32_type", "bytes_push_data", "uint32_timestamp", "bytes_notify_text", "uint32_push_flag"}, new Object[]{0, byteStringMicro, 0, byteStringMicro, 0}, submsgtype0x66$MsgBody.class);
    }

    public submsgtype0x66$MsgBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_push_data = PBField.initBytes(byteStringMicro);
        this.uint32_timestamp = PBField.initUInt32(0);
        this.bytes_notify_text = PBField.initBytes(byteStringMicro);
        this.uint32_push_flag = PBField.initUInt32(0);
    }
}
