package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QQCircleSmartMatchMusic$StuckPointData extends MessageMicro<QQCircleSmartMatchMusic$StuckPointData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"name", "effectPoints"}, new Object[]{"", null}, QQCircleSmartMatchMusic$StuckPointData.class);
    public final PBStringField name = PBField.initString("");
    public final PBRepeatMessageField<QQCircleSmartMatchMusic$EffectPoint> effectPoints = PBField.initRepeatMessage(QQCircleSmartMatchMusic$EffectPoint.class);
}
