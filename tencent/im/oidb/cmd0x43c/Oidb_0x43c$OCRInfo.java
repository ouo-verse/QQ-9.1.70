package tencent.im.oidb.cmd0x43c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x43c$OCRInfo extends MessageMicro<Oidb_0x43c$OCRInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField name = PBField.initString("");
    public final PBRepeatField<Long> uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBRepeatField<String> mobiles = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBFloatField name_dependLevel = PBField.initFloat(0.0f);
    public final PBFloatField uins_dependLevel = PBField.initFloat(0.0f);
    public final PBFloatField mobiles_dependLevel = PBField.initFloat(0.0f);

    static {
        Float valueOf = Float.valueOf(0.0f);
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 37, 45, 53}, new String[]{"name", "uins", "mobiles", "name_dependLevel", "uins_dependLevel", "mobiles_dependLevel"}, new Object[]{"", 0L, "", valueOf, valueOf, valueOf}, Oidb_0x43c$OCRInfo.class);
    }
}
