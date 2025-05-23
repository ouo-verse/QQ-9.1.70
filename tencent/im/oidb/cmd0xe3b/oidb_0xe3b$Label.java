package tencent.im.oidb.cmd0xe3b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xe3b$Label extends MessageMicro<oidb_0xe3b$Label> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"bytes_name", "text_color", "edging_color", "uint32_label_type"}, new Object[]{ByteStringMicro.EMPTY, null, null, 0}, oidb_0xe3b$Label.class);
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0xe3b$Color text_color = new MessageMicro<oidb_0xe3b$Color>() { // from class: tencent.im.oidb.cmd0xe3b.oidb_0xe3b$Color
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_r", "uint32_g", "uint32_b"}, new Object[]{0, 0, 0}, oidb_0xe3b$Color.class);
        public final PBUInt32Field uint32_r = PBField.initUInt32(0);
        public final PBUInt32Field uint32_g = PBField.initUInt32(0);
        public final PBUInt32Field uint32_b = PBField.initUInt32(0);
    };
    public oidb_0xe3b$Color edging_color = new MessageMicro<oidb_0xe3b$Color>() { // from class: tencent.im.oidb.cmd0xe3b.oidb_0xe3b$Color
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_r", "uint32_g", "uint32_b"}, new Object[]{0, 0, 0}, oidb_0xe3b$Color.class);
        public final PBUInt32Field uint32_r = PBField.initUInt32(0);
        public final PBUInt32Field uint32_g = PBField.initUInt32(0);
        public final PBUInt32Field uint32_b = PBField.initUInt32(0);
    };
    public final PBUInt32Field uint32_label_type = PBField.initUInt32(0);
}
