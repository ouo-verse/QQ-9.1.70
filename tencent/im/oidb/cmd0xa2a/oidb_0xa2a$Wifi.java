package tencent.im.oidb.cmd0xa2a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xa2a$Wifi extends MessageMicro<oidb_0xa2a$Wifi> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"int64_mac", "int32_rssi"}, new Object[]{0L, 0}, oidb_0xa2a$Wifi.class);
    public final PBInt64Field int64_mac = PBField.initInt64(0);
    public final PBInt32Field int32_rssi = PBField.initInt32(0);
}
