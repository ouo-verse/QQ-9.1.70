package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TaskCenterReader$FuelConf extends MessageMicro<TaskCenterReader$FuelConf> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"fuelcount", "isv4test", "pushtype"}, new Object[]{0, Boolean.FALSE, null}, TaskCenterReader$FuelConf.class);
    public final PBRepeatField<Integer> fuelcount = PBField.initRepeat(PBInt32Field.__repeatHelper__);
    public final PBBoolField isv4test = PBField.initBool(false);
    public final PBRepeatMessageField<TaskCenterReader$PushStyleTest> pushtype = PBField.initRepeatMessage(TaskCenterReader$PushStyleTest.class);
}
