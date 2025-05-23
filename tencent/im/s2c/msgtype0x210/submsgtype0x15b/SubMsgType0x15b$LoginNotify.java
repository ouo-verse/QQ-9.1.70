package tencent.im.s2c.msgtype0x210.submsgtype0x15b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x15b$LoginNotify extends MessageMicro<SubMsgType0x15b$LoginNotify> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_title;
    public final PBBytesField bytes_wording;
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_seq", "bytes_title", "bytes_wording"}, new Object[]{0, byteStringMicro, byteStringMicro}, SubMsgType0x15b$LoginNotify.class);
    }

    public SubMsgType0x15b$LoginNotify() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_title = PBField.initBytes(byteStringMicro);
        this.bytes_wording = PBField.initBytes(byteStringMicro);
    }
}
