package tencent.im.oidb.cmd0xe84;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xe84$Condition extends MessageMicro<oidb_0xe84$Condition> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_date;
    public final PBBytesField bytes_key;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_key", "bytes_date"}, new Object[]{byteStringMicro, byteStringMicro}, oidb_0xe84$Condition.class);
    }

    public oidb_0xe84$Condition() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_key = PBField.initBytes(byteStringMicro);
        this.bytes_date = PBField.initBytes(byteStringMicro);
    }
}
