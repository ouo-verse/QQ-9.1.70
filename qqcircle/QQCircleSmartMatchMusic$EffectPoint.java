package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class QQCircleSmartMatchMusic$EffectPoint extends MessageMicro<QQCircleSmartMatchMusic$EffectPoint> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"effectId", "type", "time", "duration"}, new Object[]{"", "", 0, 0}, QQCircleSmartMatchMusic$EffectPoint.class);
    public final PBStringField effectId = PBField.initString("");
    public final PBStringField type = PBField.initString("");
    public final PBUInt32Field time = PBField.initUInt32(0);
    public final PBUInt32Field duration = PBField.initUInt32(0);
}
