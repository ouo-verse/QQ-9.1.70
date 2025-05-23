package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class QQCircleProfile$AuthNearbyRsp extends MessageMicro<QQCircleProfile$AuthNearbyRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"authNearby"}, new Object[]{0}, QQCircleProfile$AuthNearbyRsp.class);
    public final PBUInt32Field authNearby = PBField.initUInt32(0);
}
