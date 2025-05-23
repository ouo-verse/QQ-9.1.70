package tencent.im.oidb.cmd0x8fd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x8fd$LevelName extends MessageMicro<Oidb_0x8fd$LevelName> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_level", "str_name"}, new Object[]{0, ""}, Oidb_0x8fd$LevelName.class);
    public final PBUInt32Field uint32_level = PBField.initUInt32(0);
    public final PBStringField str_name = PBField.initString("");
}
