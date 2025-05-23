package qshadow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QShadowMetaMaterial$MetaSdkInfo extends MessageMicro<QShadowMetaMaterial$MetaSdkInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"SdkVersion", "Sdk"}, new Object[]{"", 0}, QShadowMetaMaterial$MetaSdkInfo.class);
    public final PBStringField SdkVersion = PBField.initString("");
    public final PBInt32Field Sdk = PBField.initInt32(0);
}
