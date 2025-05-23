package qshadow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QShadowMetaMaterial$MetaAdditionalPackage extends MessageMicro<QShadowMetaMaterial$MetaAdditionalPackage> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66}, new String[]{"lowPackageUrl", "lowPackageMd5", "superLowPackageUrl", "superLowPackageMd5", "midPackageUrl", "midPackageMd5", "highPackageUrl", "highPackageMd5"}, new Object[]{"", "", "", "", "", "", "", ""}, QShadowMetaMaterial$MetaAdditionalPackage.class);
    public final PBStringField lowPackageUrl = PBField.initString("");
    public final PBStringField lowPackageMd5 = PBField.initString("");
    public final PBStringField superLowPackageUrl = PBField.initString("");
    public final PBStringField superLowPackageMd5 = PBField.initString("");
    public final PBStringField midPackageUrl = PBField.initString("");
    public final PBStringField midPackageMd5 = PBField.initString("");
    public final PBStringField highPackageUrl = PBField.initString("");
    public final PBStringField highPackageMd5 = PBField.initString("");
}
