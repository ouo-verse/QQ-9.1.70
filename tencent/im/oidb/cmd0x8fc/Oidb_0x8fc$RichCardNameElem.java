package tencent.im.oidb.cmd0x8fc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x8fc$RichCardNameElem extends MessageMicro<Oidb_0x8fc$RichCardNameElem> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ctrl;
    public final PBBytesField bytes_text;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_ctrl", "bytes_text"}, new Object[]{byteStringMicro, byteStringMicro}, Oidb_0x8fc$RichCardNameElem.class);
    }

    public Oidb_0x8fc$RichCardNameElem() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_ctrl = PBField.initBytes(byteStringMicro);
        this.bytes_text = PBField.initBytes(byteStringMicro);
    }
}
