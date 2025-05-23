package tencent.im.group_pro_proto.eventflow;

import com.tencent.ams.dynamicwidget.report.LinkReportConstant$GlobalKey;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.group_pro_proto.common.common$Event;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class msg_event$AddRsp extends MessageMicro<msg_event$AddRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"event_version", LinkReportConstant$GlobalKey.EVENTS}, new Object[]{0L, null}, msg_event$AddRsp.class);
    public final PBUInt64Field event_version = PBField.initUInt64(0);
    public final PBRepeatMessageField<common$Event> events = PBField.initRepeatMessage(common$Event.class);
}
