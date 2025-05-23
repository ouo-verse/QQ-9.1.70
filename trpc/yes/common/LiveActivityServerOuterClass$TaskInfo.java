package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qqcircle.report.QCircleLpReportDc05502;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class LiveActivityServerOuterClass$TaskInfo extends MessageMicro<LiveActivityServerOuterClass$TaskInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40, 48, 58, 64, 72, 80, 88, 96, 104, 112}, new String[]{"title", "task_id", "type", "status", "current_value", "value", "award_list", "time_status", "order", "time_left", "join_total", QCircleLpReportDc05502.KEY_BEGIN_TIME, "end_time", "remaining_total"}, new Object[]{"", 0, "", 0, 0, 0, null, 0, 0, 0, 0, 0, 0, 0}, LiveActivityServerOuterClass$TaskInfo.class);
    public final PBStringField title = PBField.initString("");
    public final PBInt32Field task_id = PBField.initInt32(0);
    public final PBStringField type = PBField.initString("");
    public final PBInt32Field status = PBField.initInt32(0);
    public final PBInt32Field current_value = PBField.initInt32(0);
    public final PBInt32Field value = PBField.initInt32(0);
    public final PBRepeatMessageField<LiveActivityServerOuterClass$AwardItem> award_list = PBField.initRepeatMessage(LiveActivityServerOuterClass$AwardItem.class);
    public final PBInt32Field time_status = PBField.initInt32(0);
    public final PBInt32Field order = PBField.initInt32(0);
    public final PBInt32Field time_left = PBField.initInt32(0);
    public final PBInt32Field join_total = PBField.initInt32(0);
    public final PBUInt32Field begin_time = PBField.initUInt32(0);
    public final PBUInt32Field end_time = PBField.initUInt32(0);
    public final PBInt32Field remaining_total = PBField.initInt32(0);
}
