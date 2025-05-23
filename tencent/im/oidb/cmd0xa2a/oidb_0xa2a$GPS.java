package tencent.im.oidb.cmd0xa2a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class oidb_0xa2a$GPS extends MessageMicro<oidb_0xa2a$GPS> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"int64_latitude", "int64_longitude", "int64_altitude", "uint32_gps_type"}, new Object[]{0L, 0L, 0L, 0}, oidb_0xa2a$GPS.class);
    public final PBInt64Field int64_latitude = PBField.initInt64(0);
    public final PBInt64Field int64_longitude = PBField.initInt64(0);
    public final PBInt64Field int64_altitude = PBField.initInt64(0);
    public final PBUInt32Field uint32_gps_type = PBField.initUInt32(0);
}
