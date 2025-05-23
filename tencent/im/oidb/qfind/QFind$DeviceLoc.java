package tencent.im.oidb.qfind;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QFind$DeviceLoc extends MessageMicro<QFind$DeviceLoc> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"timestamp", QCircleSchemeAttr.Polymerize.LAT, "lon", "gps_type", "uint32_precision"}, new Object[]{0, 0, 0, 0, 0}, QFind$DeviceLoc.class);
    public final PBUInt32Field timestamp = PBField.initUInt32(0);
    public final PBUInt32Field lat = PBField.initUInt32(0);
    public final PBUInt32Field lon = PBField.initUInt32(0);
    public final PBUInt32Field gps_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_precision = PBField.initUInt32(0);
}
