package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class QQCircleCounter$GetRedPointsInfoByUserIDRsp extends MessageMicro<QQCircleCounter$GetRedPointsInfoByUserIDRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"redpoints", "timestamps"}, new Object[]{null, null}, QQCircleCounter$GetRedPointsInfoByUserIDRsp.class);
    public final PBRepeatMessageField<QQCircleCounter$SimpleRedPointInfo> redpoints = PBField.initRepeatMessage(QQCircleCounter$SimpleRedPointInfo.class);
    public final PBRepeatMessageField<QQCircleCounter$TimestampInfo> timestamps = PBField.initRepeatMessage(QQCircleCounter$TimestampInfo.class);
}
