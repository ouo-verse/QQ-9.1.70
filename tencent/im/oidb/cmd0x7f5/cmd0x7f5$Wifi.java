package tencent.im.oidb.cmd0x7f5;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x7f5$Wifi extends MessageMicro<cmd0x7f5$Wifi> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"bytes_mac", "uint32_rssi"}, new Object[]{ByteStringMicro.EMPTY, 0}, cmd0x7f5$Wifi.class);
    public final PBBytesField bytes_mac = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_rssi = PBField.initUInt32(0);
}
