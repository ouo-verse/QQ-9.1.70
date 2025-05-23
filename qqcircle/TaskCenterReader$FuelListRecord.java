package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TaskCenterReader$FuelListRecord extends MessageMicro<TaskCenterReader$FuelListRecord> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40}, new String[]{"behaviorType", "opName", "optTime", "fuelValue", "leftFuel"}, new Object[]{0, "", 0, 0, 0}, TaskCenterReader$FuelListRecord.class);
    public final PBEnumField behaviorType = PBField.initEnum(0);
    public final PBStringField opName = PBField.initString("");
    public final PBUInt32Field optTime = PBField.initUInt32(0);
    public final PBInt32Field fuelValue = PBField.initInt32(0);
    public final PBInt32Field leftFuel = PBField.initInt32(0);
}
