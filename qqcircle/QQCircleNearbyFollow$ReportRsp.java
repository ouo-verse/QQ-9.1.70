package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleNearbyFollow$ReportRsp extends MessageMicro<QQCircleNearbyFollow$ReportRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"users", "next_interval"}, new Object[]{null, 0L}, QQCircleNearbyFollow$ReportRsp.class);
    public final PBRepeatMessageField<QQCircleNearbyFollow$User> users = PBField.initRepeatMessage(QQCircleNearbyFollow$User.class);
    public final PBInt64Field next_interval = PBField.initInt64(0);
}
