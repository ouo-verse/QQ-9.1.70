package tencent.im.s2c.msgtype0x210.submsgtype0x122;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes29.dex */
public final class submsgtype0x122$TemplParam extends MessageMicro<submsgtype0x122$TemplParam> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_name;
    public final PBBytesField bytes_value;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_name", "bytes_value"}, new Object[]{byteStringMicro, byteStringMicro}, submsgtype0x122$TemplParam.class);
    }

    public submsgtype0x122$TemplParam() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_name = PBField.initBytes(byteStringMicro);
        this.bytes_value = PBField.initBytes(byteStringMicro);
    }
}
