package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleCommercialDataworksReport$UserData extends MessageMicro<QQCircleCommercialDataworksReport$UserData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 800}, new String[]{"user_action_data", "write_time"}, new Object[]{null, 0L}, QQCircleCommercialDataworksReport$UserData.class);
    public final PBRepeatMessageField<QQCircleCommercialDataworksReport$UserActionReportReq> user_action_data = PBField.initRepeatMessage(QQCircleCommercialDataworksReport$UserActionReportReq.class);
    public final PBInt64Field write_time = PBField.initInt64(0);
}
