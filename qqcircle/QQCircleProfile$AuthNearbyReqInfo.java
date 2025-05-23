package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class QQCircleProfile$AuthNearbyReqInfo extends MessageMicro<QQCircleProfile$AuthNearbyReqInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uin", "opsType", "uint64_uin"}, new Object[]{0, 0, 0L}, QQCircleProfile$AuthNearbyReqInfo.class);
    public final PBUInt32Field uin = PBField.initUInt32(0);
    public final PBInt32Field opsType = PBField.initInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
}
