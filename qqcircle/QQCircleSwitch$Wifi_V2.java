package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleSwitch$Wifi_V2 extends MessageMicro<QQCircleSwitch$Wifi_V2> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"strMac", "iRssi"}, new Object[]{"", 0}, QQCircleSwitch$Wifi_V2.class);
    public final PBStringField strMac = PBField.initString("");
    public final PBInt32Field iRssi = PBField.initInt32(0);
}
