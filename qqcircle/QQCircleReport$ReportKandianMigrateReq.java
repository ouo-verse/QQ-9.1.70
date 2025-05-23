package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleReport$ReportKandianMigrateReq extends MessageMicro<QQCircleReport$ReportKandianMigrateReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"items"}, new Object[]{null}, QQCircleReport$ReportKandianMigrateReq.class);
    public final PBRepeatMessageField<QQCircleReport$ReportKandianMigrateItem> items = PBField.initRepeatMessage(QQCircleReport$ReportKandianMigrateItem.class);
}
