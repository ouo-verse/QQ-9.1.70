package tencent.im.oidb.cmd0xce5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.redtouch.RedTouchWebviewHandler;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0xce5$RspBody extends MessageMicro<Oidb_0xce5$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 42}, new String[]{"robot_info", "role", "max_robot_num", "robot_redpoint_list"}, new Object[]{null, 0, 0, null}, Oidb_0xce5$RspBody.class);
    public final PBRepeatMessageField<Oidb_0xce5$RobotInfo> robot_info = PBField.initRepeatMessage(Oidb_0xce5$RobotInfo.class);
    public final PBUInt32Field role = PBField.initUInt32(0);
    public final PBUInt32Field max_robot_num = PBField.initUInt32(0);
    public Oidb_0xce5$RobotRedPointList robot_redpoint_list = new MessageMicro<Oidb_0xce5$RobotRedPointList>() { // from class: tencent.im.oidb.cmd0xce5.Oidb_0xce5$RobotRedPointList
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{RedTouchWebviewHandler.PLUGIN_NAMESPACE, "cache_time", "role"}, new Object[]{null, 0L, 0}, Oidb_0xce5$RobotRedPointList.class);
        public final PBRepeatMessageField<Oidb_0xce5$RobotRedPoint> redpoint = PBField.initRepeatMessage(Oidb_0xce5$RobotRedPoint.class);
        public final PBUInt64Field cache_time = PBField.initUInt64(0);
        public final PBUInt32Field role = PBField.initUInt32(0);
    };
}
