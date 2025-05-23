package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes29.dex */
public final class QQCircleProfile$AuthNearbyReq extends MessageMicro<QQCircleProfile$AuthNearbyReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"opsType"}, new Object[]{0}, QQCircleProfile$AuthNearbyReq.class);
    public final PBInt32Field opsType = PBField.initInt32(0);
}
