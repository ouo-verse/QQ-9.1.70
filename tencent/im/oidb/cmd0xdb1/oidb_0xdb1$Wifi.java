package tencent.im.oidb.cmd0xdb1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xdb1$Wifi extends MessageMicro<oidb_0xdb1$Wifi> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_mac", "int32_rssi"}, new Object[]{0L, 0}, oidb_0xdb1$Wifi.class);
    public final PBUInt64Field uint64_mac = PBField.initUInt64(0);
    public final PBInt32Field int32_rssi = PBField.initInt32(0);
}
