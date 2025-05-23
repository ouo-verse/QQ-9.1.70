package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TaskCenterReader$EeveeMyFuel extends MessageMicro<TaskCenterReader$EeveeMyFuel> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42, 50, 58, 66, 74}, new String[]{"pushTime", "myFuelValue", "jumpURL", "vvCount", "vvReason", "vvTopTip", "vvTabTip", "clockInInfo", "fuelConf"}, new Object[]{0L, 0, "", 0, "", "", "", null, null}, TaskCenterReader$EeveeMyFuel.class);
    public final PBInt64Field pushTime = PBField.initInt64(0);
    public final PBUInt32Field myFuelValue = PBField.initUInt32(0);
    public final PBStringField jumpURL = PBField.initString("");
    public final PBInt32Field vvCount = PBField.initInt32(0);
    public final PBStringField vvReason = PBField.initString("");
    public final PBStringField vvTopTip = PBField.initString("");
    public final PBStringField vvTabTip = PBField.initString("");
    public TaskCenterReader$ClockInInfo clockInInfo = new TaskCenterReader$ClockInInfo();
    public TaskCenterReader$FuelConf fuelConf = new TaskCenterReader$FuelConf();
}
