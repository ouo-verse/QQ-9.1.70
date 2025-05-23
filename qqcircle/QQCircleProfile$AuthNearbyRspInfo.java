package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class QQCircleProfile$AuthNearbyRspInfo extends MessageMicro<QQCircleProfile$AuthNearbyRspInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uin", "authNearby", "uint64_uin"}, new Object[]{0, 0, 0L}, QQCircleProfile$AuthNearbyRspInfo.class);
    public final PBUInt32Field uin = PBField.initUInt32(0);
    public final PBUInt32Field authNearby = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
}
