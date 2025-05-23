package tencent.im.cs.cmd0x3fe;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x3fe$Medal extends MessageMicro<cmd0x3fe$Medal> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50}, new String[]{"uint32_id", "uint32_level", "uint32_type", "str_icon_url", "str_head_icon_url", "str_name"}, new Object[]{0, 0, 0, "", "", ""}, cmd0x3fe$Medal.class);
    public final PBUInt32Field uint32_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBStringField str_icon_url = PBField.initString("");
    public final PBStringField str_head_icon_url = PBField.initString("");
    public final PBStringField str_name = PBField.initString("");
}
