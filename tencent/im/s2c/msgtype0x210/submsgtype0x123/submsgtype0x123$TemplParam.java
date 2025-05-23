package tencent.im.s2c.msgtype0x210.submsgtype0x123;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes29.dex */
public final class submsgtype0x123$TemplParam extends MessageMicro<submsgtype0x123$TemplParam> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField name;
    public final PBBytesField value;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"name", "value"}, new Object[]{byteStringMicro, byteStringMicro}, submsgtype0x123$TemplParam.class);
    }

    public submsgtype0x123$TemplParam() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.name = PBField.initBytes(byteStringMicro);
        this.value = PBField.initBytes(byteStringMicro);
    }
}
