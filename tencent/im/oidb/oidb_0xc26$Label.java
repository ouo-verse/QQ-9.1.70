package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xc26$Label extends MessageMicro<oidb_0xc26$Label> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"bytes_name", "text_color", "edging_color", "uint32_label_type"}, new Object[]{ByteStringMicro.EMPTY, null, null, 0}, oidb_0xc26$Label.class);
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0xc26$Color text_color = new oidb_0xc26$Color();
    public oidb_0xc26$Color edging_color = new oidb_0xc26$Color();
    public final PBUInt32Field uint32_label_type = PBField.initUInt32(0);
}
