package qshadow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ShadowAIGCStatus$ButtonInfo extends MessageMicro<ShadowAIGCStatus$ButtonInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50}, new String[]{"type", "detail", "text", "description", "popup_text", "retention_popup_text"}, new Object[]{0, "", "", "", "", ""}, ShadowAIGCStatus$ButtonInfo.class);
    public final PBEnumField type = PBField.initEnum(0);
    public final PBStringField detail = PBField.initString("");
    public final PBStringField text = PBField.initString("");
    public final PBStringField description = PBField.initString("");
    public final PBStringField popup_text = PBField.initString("");
    public final PBStringField retention_popup_text = PBField.initString("");
}
