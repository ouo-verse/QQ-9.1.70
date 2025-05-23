package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class QQCircleProfile$BatchGetAuthNearbyReq extends MessageMicro<QQCircleProfile$BatchGetAuthNearbyReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"authReqInfos"}, new Object[]{null}, QQCircleProfile$BatchGetAuthNearbyReq.class);
    public final PBRepeatMessageField<QQCircleProfile$AuthNearbyReqInfo> authReqInfos = PBField.initRepeatMessage(QQCircleProfile$AuthNearbyReqInfo.class);
}
