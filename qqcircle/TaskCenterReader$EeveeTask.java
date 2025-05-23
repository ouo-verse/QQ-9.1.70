package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TaskCenterReader$EeveeTask extends MessageMicro<TaskCenterReader$EeveeTask> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42}, new String[]{"push_time", "my_fuel_value", "jump_url", "vv_count", "vv_reason"}, new Object[]{0L, 0, "", 0, ""}, TaskCenterReader$EeveeTask.class);
    public final PBInt64Field push_time = PBField.initInt64(0);
    public final PBUInt32Field my_fuel_value = PBField.initUInt32(0);
    public final PBStringField jump_url = PBField.initString("");
    public final PBInt32Field vv_count = PBField.initInt32(0);
    public final PBStringField vv_reason = PBField.initString("");
}
