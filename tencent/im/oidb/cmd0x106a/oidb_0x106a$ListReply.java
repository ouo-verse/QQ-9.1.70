package tencent.im.oidb.cmd0x106a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x106a$ListReply extends MessageMicro<oidb_0x106a$ListReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40}, new String[]{"added_list", "recommend_list", "total_recommend", "role", "robot_max_num"}, new Object[]{null, null, 0, 0, 0}, oidb_0x106a$ListReply.class);
    public final PBRepeatMessageField<oidb_0x106a$RobotInfo> added_list = PBField.initRepeatMessage(oidb_0x106a$RobotInfo.class);
    public final PBRepeatMessageField<oidb_0x106a$RobotInfo> recommend_list = PBField.initRepeatMessage(oidb_0x106a$RobotInfo.class);
    public final PBUInt32Field total_recommend = PBField.initUInt32(0);
    public final PBUInt32Field role = PBField.initUInt32(0);
    public final PBUInt32Field robot_max_num = PBField.initUInt32(0);
}
