package tencent.im.s2c.msgtype0x210.submsgtype0x51;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x51$DevInfo extends MessageMicro<SubMsgType0x51$DevInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField dev_name;
    public final PBBytesField dev_type;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"dev_type", "dev_name"}, new Object[]{byteStringMicro, byteStringMicro}, SubMsgType0x51$DevInfo.class);
    }

    public SubMsgType0x51$DevInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.dev_type = PBField.initBytes(byteStringMicro);
        this.dev_name = PBField.initBytes(byteStringMicro);
    }
}
