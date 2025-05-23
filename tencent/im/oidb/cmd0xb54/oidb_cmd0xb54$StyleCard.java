package tencent.im.oidb.cmd0xb54;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xb54$StyleCard extends MessageMicro<oidb_cmd0xb54$StyleCard> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_sourceid;
    public final PBBytesField bytes_style;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_sourceid", "bytes_style"}, new Object[]{byteStringMicro, byteStringMicro}, oidb_cmd0xb54$StyleCard.class);
    }

    public oidb_cmd0xb54$StyleCard() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_sourceid = PBField.initBytes(byteStringMicro);
        this.bytes_style = PBField.initBytes(byteStringMicro);
    }
}
