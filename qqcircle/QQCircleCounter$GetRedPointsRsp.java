package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class QQCircleCounter$GetRedPointsRsp extends MessageMicro<QQCircleCounter$GetRedPointsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"reds", "pollInterval"}, new Object[]{null, 0L}, QQCircleCounter$GetRedPointsRsp.class);
    public final PBRepeatMessageField<QQCircleCounter$RedPointInfo> reds = PBField.initRepeatMessage(QQCircleCounter$RedPointInfo.class);
    public final PBInt64Field pollInterval = PBField.initInt64(0);
}
