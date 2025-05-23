package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleReader$FuelInfo extends MessageMicro<QQCircleReader$FuelInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"userId", "myFuel"}, new Object[]{"", 0}, QQCircleReader$FuelInfo.class);
    public final PBStringField userId = PBField.initString("");
    public final PBUInt32Field myFuel = PBField.initUInt32(0);
}
