package qshadow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QShadowMetaMaterialRecommendation$RecommendationEntry extends MessageMicro<QShadowMetaMaterialRecommendation$RecommendationEntry> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"MaterialInfo", "Reason", "Confidence"}, new Object[]{null, "", 0}, QShadowMetaMaterialRecommendation$RecommendationEntry.class);
    public QShadowMetaMaterial$MaterialInfo MaterialInfo = new QShadowMetaMaterial$MaterialInfo();
    public final PBStringField Reason = PBField.initString("");
    public final PBInt32Field Confidence = PBField.initInt32(0);
}
