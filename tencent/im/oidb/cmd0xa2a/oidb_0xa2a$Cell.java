package tencent.im.oidb.cmd0xa2a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xa2a$Cell extends MessageMicro<oidb_0xa2a$Cell> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"int32_mobile_country_code", "int32_mobile_network_code", "int32_location_area_code", "int32_cell_id", "int32_rssi"}, new Object[]{0, 0, 0, 0, 0}, oidb_0xa2a$Cell.class);
    public final PBInt32Field int32_mobile_country_code = PBField.initInt32(0);
    public final PBInt32Field int32_mobile_network_code = PBField.initInt32(0);
    public final PBInt32Field int32_location_area_code = PBField.initInt32(0);
    public final PBInt32Field int32_cell_id = PBField.initInt32(0);
    public final PBInt32Field int32_rssi = PBField.initInt32(0);
}
