package tencent.im.group_pro_proto.eventflow;

import com.tencent.ams.dynamicwidget.report.LinkReportConstant$GlobalKey;
import com.tencent.gamematrix.gmcg.sdk.nonage.report.CGNonAgeReport;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.group_pro_proto.common.common$Event;
import tencent.im.group_pro_proto.common.common$MsgOpInfo;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class msg_event$Event extends MessageMicro<msg_event$Event> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42}, new String[]{"msg_seq", CGNonAgeReport.EVENT_TYPE, "event_version", LinkReportConstant$GlobalKey.EVENTS, "op_info"}, new Object[]{0L, 0L, 0L, null, null}, msg_event$Event.class);
    public final PBUInt64Field msg_seq = PBField.initUInt64(0);
    public final PBUInt64Field event_type = PBField.initUInt64(0);
    public final PBUInt64Field event_version = PBField.initUInt64(0);
    public final PBRepeatMessageField<common$Event> events = PBField.initRepeatMessage(common$Event.class);
    public common$MsgOpInfo op_info = new common$MsgOpInfo();
}
