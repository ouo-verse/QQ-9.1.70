package qzone;

import com.tencent.ams.dynamicwidget.report.LinkReportConstant$GlobalKey;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZoneBaseMeta$StTimeLine extends MessageMicro<QZoneBaseMeta$StTimeLine> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{LinkReportConstant$GlobalKey.EVENTS}, new Object[]{null}, QZoneBaseMeta$StTimeLine.class);
    public final PBRepeatMessageField<QZoneBaseMeta$StTimeLineEvent> events = PBField.initRepeatMessage(QZoneBaseMeta$StTimeLineEvent.class);
}
