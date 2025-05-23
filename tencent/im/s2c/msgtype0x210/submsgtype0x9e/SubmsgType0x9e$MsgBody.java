package tencent.im.s2c.msgtype0x210.submsgtype0x9e;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubmsgType0x9e$MsgBody extends MessageMicro<SubmsgType0x9e$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_url;
    public final PBBytesField bytes_wording;
    public final PBUInt32Field uint32_auth_key;
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"uint32_type", "bytes_wording", "bytes_url", "uint32_auth_key"}, new Object[]{0, byteStringMicro, byteStringMicro, 0}, SubmsgType0x9e$MsgBody.class);
    }

    public SubmsgType0x9e$MsgBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_wording = PBField.initBytes(byteStringMicro);
        this.bytes_url = PBField.initBytes(byteStringMicro);
        this.uint32_auth_key = PBField.initUInt32(0);
    }
}
