package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleDurationReport$ReportDurationRsp extends MessageMicro<QQCircleDurationReport$ReportDurationRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"heart_beat_interval", "dialog"}, new Object[]{0L, null}, QQCircleDurationReport$ReportDurationRsp.class);
    public final PBInt64Field heart_beat_interval = PBField.initInt64(0);
    public QQCircleDurationReport$DurationDialog dialog = new QQCircleDurationReport$DurationDialog();
}
