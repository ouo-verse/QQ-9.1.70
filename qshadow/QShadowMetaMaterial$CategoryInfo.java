package qshadow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QShadowMetaMaterial$CategoryInfo extends MessageMicro<QShadowMetaMaterial$CategoryInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"id", "name", "thumbUrl", "subCategories", "materials", "dynamicFields"}, new Object[]{"", "", "", null, null, null}, QShadowMetaMaterial$CategoryInfo.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f429483id = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField thumbUrl = PBField.initString("");
    public final PBRepeatMessageField<QShadowMetaMaterial$CategoryInfo> subCategories = PBField.initRepeatMessage(QShadowMetaMaterial$CategoryInfo.class);
    public final PBRepeatMessageField<QShadowMetaMaterial$MaterialInfo> materials = PBField.initRepeatMessage(QShadowMetaMaterial$MaterialInfo.class);
    public final PBRepeatMessageField<QShadowMetaMaterial$AdditionalEntry> dynamicFields = PBField.initRepeatMessage(QShadowMetaMaterial$AdditionalEntry.class);
}
