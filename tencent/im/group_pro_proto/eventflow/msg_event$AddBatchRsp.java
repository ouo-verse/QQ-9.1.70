package tencent.im.group_pro_proto.eventflow;

import com.tencent.ams.dynamicwidget.report.LinkReportConstant$GlobalKey;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class msg_event$AddBatchRsp extends MessageMicro<msg_event$AddBatchRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{LinkReportConstant$GlobalKey.EVENTS}, new Object[]{null}, msg_event$AddBatchRsp.class);
    public final PBRepeatMessageField<msg_event$Event> events = PBField.initRepeatMessage(msg_event$Event.class);
}
