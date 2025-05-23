package tencent.im.oidb.cmd0xce5;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0xce5$RobotInfo extends MessageMicro<Oidb_0xce5$RobotInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 48, 58, 66, 72, 80, 90, 98, 104, 112, 120, 128, 136, 144, 154}, new String[]{"robot_uin", "name", "status", "desc", "enabled_groups", "welcome_msg", "call_name", "show_invite", "offline", "verify", AdMetricTag.FALLBACK, "join_time", "order", "appid", "api_mark", "miniapp_ids", "robot_type", "extra_info"}, new Object[]{0L, "", 0, "", 0, "", "", 0, 0, "", "", 0, 0, 0L, 0L, 0L, 0, ""}, Oidb_0xce5$RobotInfo.class);
    public final PBUInt64Field robot_uin = PBField.initUInt64(0);
    public final PBStringField name = PBField.initString("");
    public final PBUInt32Field status = PBField.initUInt32(0);
    public final PBStringField desc = PBField.initString("");
    public final PBUInt32Field enabled_groups = PBField.initUInt32(0);
    public final PBStringField welcome_msg = PBField.initString("");
    public final PBStringField call_name = PBField.initString("");
    public final PBUInt32Field show_invite = PBField.initUInt32(0);
    public final PBUInt32Field offline = PBField.initUInt32(0);
    public final PBStringField verify = PBField.initString("");
    public final PBRepeatField<String> fallback = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBUInt32Field join_time = PBField.initUInt32(0);
    public final PBUInt32Field order = PBField.initUInt32(0);
    public final PBUInt64Field appid = PBField.initUInt64(0);
    public final PBUInt64Field api_mark = PBField.initUInt64(0);
    public final PBRepeatField<Long> miniapp_ids = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field robot_type = PBField.initUInt32(0);
    public final PBStringField extra_info = PBField.initString("");
}
