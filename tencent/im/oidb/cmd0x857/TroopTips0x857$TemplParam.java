package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes29.dex */
public final class TroopTips0x857$TemplParam extends MessageMicro<TroopTips0x857$TemplParam> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_name;
    public final PBBytesField bytes_value;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_name", "bytes_value"}, new Object[]{byteStringMicro, byteStringMicro}, TroopTips0x857$TemplParam.class);
    }

    public TroopTips0x857$TemplParam() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_name = PBField.initBytes(byteStringMicro);
        this.bytes_value = PBField.initBytes(byteStringMicro);
    }
}
