package tencent.im.oidb.cmd0xce5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class Oidb_0xce5$RobotRedPoint extends MessageMicro<Oidb_0xce5$RobotRedPoint> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"robot_uin", "end_ts", "role"}, new Object[]{0L, 0L, 0}, Oidb_0xce5$RobotRedPoint.class);
    public final PBUInt64Field robot_uin = PBField.initUInt64(0);
    public final PBUInt64Field end_ts = PBField.initUInt64(0);
    public final PBUInt32Field role = PBField.initUInt32(0);
}
