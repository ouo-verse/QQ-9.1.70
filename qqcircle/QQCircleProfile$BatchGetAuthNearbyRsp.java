package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class QQCircleProfile$BatchGetAuthNearbyRsp extends MessageMicro<QQCircleProfile$BatchGetAuthNearbyRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"authRspInfos"}, new Object[]{null}, QQCircleProfile$BatchGetAuthNearbyRsp.class);
    public final PBRepeatMessageField<QQCircleProfile$AuthNearbyRspInfo> authRspInfos = PBField.initRepeatMessage(QQCircleProfile$AuthNearbyRspInfo.class);
}
