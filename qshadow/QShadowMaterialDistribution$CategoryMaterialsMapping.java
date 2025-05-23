package qshadow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QShadowMaterialDistribution$CategoryMaterialsMapping extends MessageMicro<QShadowMaterialDistribution$CategoryMaterialsMapping> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"id", "name", "thumbUrl", "dynamicFields", "materialIDs", "subCategoryMaterialsMapping"}, new Object[]{"", "", "", null, "", null}, QShadowMaterialDistribution$CategoryMaterialsMapping.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f429482id = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField thumbUrl = PBField.initString("");
    public final PBRepeatMessageField<QShadowMetaMaterial$AdditionalEntry> dynamicFields = PBField.initRepeatMessage(QShadowMetaMaterial$AdditionalEntry.class);
    public final PBRepeatField<String> materialIDs = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatMessageField<QShadowMaterialDistribution$CategoryMaterialsMapping> subCategoryMaterialsMapping = PBField.initRepeatMessage(QShadowMaterialDistribution$CategoryMaterialsMapping.class);
}
