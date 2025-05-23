package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleReport$StDataReportReq extends MessageMicro<QQCircleReport$StDataReportReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"dcdata", "commFieldsData"}, new Object[]{null, null}, QQCircleReport$StDataReportReq.class);
    public final PBRepeatMessageField<QQCircleReport$SingleDcData> dcdata = PBField.initRepeatMessage(QQCircleReport$SingleDcData.class);
    public final PBRepeatMessageField<QQCircleReport$SingleDcData> commFieldsData = PBField.initRepeatMessage(QQCircleReport$SingleDcData.class);
}
