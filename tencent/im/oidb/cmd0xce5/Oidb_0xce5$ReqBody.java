package tencent.im.oidb.cmd0xce5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0xce5$ReqBody extends MessageMicro<Oidb_0xce5$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"group_id", "robot_info"}, new Object[]{0L, null}, Oidb_0xce5$ReqBody.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0);
    public final PBRepeatMessageField<Oidb_0xce5$RobotInfo> robot_info = PBField.initRepeatMessage(Oidb_0xce5$RobotInfo.class);
}
