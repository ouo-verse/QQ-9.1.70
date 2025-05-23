package tencent.im.troop.flock;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* loaded from: classes29.dex */
public final class QeventPB$GPS extends MessageMicro<QeventPB$GPS> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{QCircleSchemeAttr.Polymerize.LAT, "lon", "e_type", QCircleSchemeAttr.Polymerize.ALT}, new Object[]{0L, 0L, 0L, 0L}, QeventPB$GPS.class);
    public final PBInt64Field lat = PBField.initInt64(0);
    public final PBInt64Field lon = PBField.initInt64(0);
    public final PBInt64Field e_type = PBField.initInt64(0);
    public final PBInt64Field alt = PBField.initInt64(0);
}
