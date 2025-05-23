package tencent.im.lbs;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class member_lbs$Wifi extends MessageMicro<member_lbs$Wifi> {
    public static final int INT32_RSSI_FIELD_NUMBER = 2;
    public static final int INT64_MAC_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"int64_mac", "int32_rssi"}, new Object[]{0L, 0}, member_lbs$Wifi.class);
    public final PBInt64Field int64_mac = PBField.initInt64(0);
    public final PBInt32Field int32_rssi = PBField.initInt32(0);
}
