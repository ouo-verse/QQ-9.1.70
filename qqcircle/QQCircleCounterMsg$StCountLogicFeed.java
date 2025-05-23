package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleCounterMsg$StCountLogicFeed extends MessageMicro<QQCircleCounterMsg$StCountLogicFeed> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34}, new String[]{"feedId", "author", "createTs", "values"}, new Object[]{"", 0, 0, null}, QQCircleCounterMsg$StCountLogicFeed.class);
    public final PBStringField feedId = PBField.initString("");
    public final PBUInt32Field author = PBField.initUInt32(0);
    public final PBUInt32Field createTs = PBField.initUInt32(0);
    public final PBRepeatMessageField<QQCircleCounterMsg$StCountLogicValue> values = PBField.initRepeatMessage(QQCircleCounterMsg$StCountLogicValue.class);
}
