package tencent.im.oidb.cmd0xe67;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes29.dex */
public final class oidb_0xe67$GPS extends MessageMicro<oidb_0xe67$GPS> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"int32_lat", "int32_lon", "int32_alt", "int32_type"}, new Object[]{900000000, 900000000, -10000000, 0}, oidb_0xe67$GPS.class);
    public final PBInt32Field int32_lat = PBField.initInt32(900000000);
    public final PBInt32Field int32_lon = PBField.initInt32(900000000);
    public final PBInt32Field int32_alt = PBField.initInt32(-10000000);
    public final PBInt32Field int32_type = PBField.initInt32(0);
}
