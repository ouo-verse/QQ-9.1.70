package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleBase$StGateWayTransfer extends MessageMicro<QQCircleBase$StGateWayTransfer> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"reqBeginTime", "reqCost"}, new Object[]{0L, 0L}, QQCircleBase$StGateWayTransfer.class);
    public final PBInt64Field reqBeginTime = PBField.initInt64(0);
    public final PBInt64Field reqCost = PBField.initInt64(0);
}
