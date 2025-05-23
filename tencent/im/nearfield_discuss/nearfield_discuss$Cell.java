package tencent.im.nearfield_discuss;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nearfield_discuss$Cell extends MessageMicro<nearfield_discuss$Cell> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"int32_mcc", "int32_mnc", "int32_lac", "int32_cellid", "int32_rssi"}, new Object[]{-1, -1, -1, -1, 0}, nearfield_discuss$Cell.class);
    public final PBInt32Field int32_mcc = PBField.initInt32(-1);
    public final PBInt32Field int32_mnc = PBField.initInt32(-1);
    public final PBInt32Field int32_lac = PBField.initInt32(-1);
    public final PBInt32Field int32_cellid = PBField.initInt32(-1);
    public final PBInt32Field int32_rssi = PBField.initInt32(0);
}
