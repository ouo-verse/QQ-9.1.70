package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleDurationReport$ReportDurationReq extends MessageMicro<QQCircleDurationReport$ReportDurationReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uin", "type", "duration"}, new Object[]{0L, 0, 0L}, QQCircleDurationReport$ReportDurationReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBInt64Field duration = PBField.initInt64(0);
}
