package tencent.im.oidb.cmd0x7f5;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x7f5$Label extends MessageMicro<cmd0x7f5$Label> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40, 48}, new String[]{"bytes_name", "enum_type", "text_color", "edging_color", "uint32_label_attr", "uint32_label_type"}, new Object[]{ByteStringMicro.EMPTY, 1, null, null, 0, 0}, cmd0x7f5$Label.class);
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_type = PBField.initEnum(1);
    public cmd0x7f5$Color text_color = new MessageMicro<cmd0x7f5$Color>() { // from class: tencent.im.oidb.cmd0x7f5.cmd0x7f5$Color
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_r", "uint32_g", "uint32_b"}, new Object[]{0, 0, 0}, cmd0x7f5$Color.class);
        public final PBUInt32Field uint32_r = PBField.initUInt32(0);
        public final PBUInt32Field uint32_g = PBField.initUInt32(0);
        public final PBUInt32Field uint32_b = PBField.initUInt32(0);
    };
    public cmd0x7f5$Color edging_color = new MessageMicro<cmd0x7f5$Color>() { // from class: tencent.im.oidb.cmd0x7f5.cmd0x7f5$Color
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_r", "uint32_g", "uint32_b"}, new Object[]{0, 0, 0}, cmd0x7f5$Color.class);
        public final PBUInt32Field uint32_r = PBField.initUInt32(0);
        public final PBUInt32Field uint32_g = PBField.initUInt32(0);
        public final PBUInt32Field uint32_b = PBField.initUInt32(0);
    };
    public final PBUInt32Field uint32_label_attr = PBField.initUInt32(0);
    public final PBUInt32Field uint32_label_type = PBField.initUInt32(0);
}
