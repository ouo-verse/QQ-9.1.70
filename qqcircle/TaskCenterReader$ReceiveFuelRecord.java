package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TaskCenterReader$ReceiveFuelRecord extends MessageMicro<TaskCenterReader$ReceiveFuelRecord> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"uid", "fuelValue"}, new Object[]{"", 0L}, TaskCenterReader$ReceiveFuelRecord.class);
    public final PBStringField uid = PBField.initString("");
    public final PBInt64Field fuelValue = PBField.initInt64(0);
}
