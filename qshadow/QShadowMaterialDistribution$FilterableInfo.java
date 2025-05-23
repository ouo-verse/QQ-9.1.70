package qshadow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QShadowMaterialDistribution$FilterableInfo extends MessageMicro<QShadowMaterialDistribution$FilterableInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"filterableField", "filterableEnumValue"}, new Object[]{"", ""}, QShadowMaterialDistribution$FilterableInfo.class);
    public final PBStringField filterableField = PBField.initString("");
    public final PBRepeatField<String> filterableEnumValue = PBField.initRepeat(PBStringField.__repeatHelper__);
}
