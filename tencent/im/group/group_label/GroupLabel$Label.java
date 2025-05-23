package tencent.im.group.group_label;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GroupLabel$Label extends MessageMicro<GroupLabel$Label> {
    public static final int BYTES_NAME_FIELD_NUMBER = 1;
    public static final int EDGING_COLOR_FIELD_NUMBER = 4;
    public static final int ENUM_TYPE_FIELD_NUMBER = 2;
    public static final int TEXT_COLOR_FIELD_NUMBER = 3;
    public static final int UINT32_LABEL_ATTR_FIELD_NUMBER = 5;
    public static final int UINT32_LABEL_TYPE_FIELD_NUMBER = 6;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40, 48}, new String[]{"bytes_name", "enum_type", "text_color", "edging_color", "uint32_label_attr", "uint32_label_type"}, new Object[]{ByteStringMicro.EMPTY, 1, null, null, 0, 0}, GroupLabel$Label.class);
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_type = PBField.initEnum(1);
    public GroupLabel$Color text_color = new MessageMicro<GroupLabel$Color>() { // from class: tencent.im.group.group_label.GroupLabel$Color
        public static final int UINT32_B_FIELD_NUMBER = 3;
        public static final int UINT32_G_FIELD_NUMBER = 2;
        public static final int UINT32_R_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_r", "uint32_g", "uint32_b"}, new Object[]{0, 0, 0}, GroupLabel$Color.class);
        public final PBUInt32Field uint32_r = PBField.initUInt32(0);
        public final PBUInt32Field uint32_g = PBField.initUInt32(0);
        public final PBUInt32Field uint32_b = PBField.initUInt32(0);
    };
    public GroupLabel$Color edging_color = new MessageMicro<GroupLabel$Color>() { // from class: tencent.im.group.group_label.GroupLabel$Color
        public static final int UINT32_B_FIELD_NUMBER = 3;
        public static final int UINT32_G_FIELD_NUMBER = 2;
        public static final int UINT32_R_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_r", "uint32_g", "uint32_b"}, new Object[]{0, 0, 0}, GroupLabel$Color.class);
        public final PBUInt32Field uint32_r = PBField.initUInt32(0);
        public final PBUInt32Field uint32_g = PBField.initUInt32(0);
        public final PBUInt32Field uint32_b = PBField.initUInt32(0);
    };
    public final PBUInt32Field uint32_label_attr = PBField.initUInt32(0);
    public final PBUInt32Field uint32_label_type = PBField.initUInt32(0);
}
