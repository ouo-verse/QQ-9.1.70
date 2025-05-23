package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleSwitch$Cell_V2 extends MessageMicro<QQCircleSwitch$Cell_V2> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field shMcc = PBField.initInt32(0);
    public final PBInt32Field shMnc = PBField.initInt32(0);
    public final PBInt32Field iLac = PBField.initInt32(0);
    public final PBInt32Field iCellId = PBField.initInt32(0);
    public final PBInt32Field iRssi = PBField.initInt32(0);
    public final PBDoubleField dStationLat = PBField.initDouble(0.0d);
    public final PBDoubleField dStationLon = PBField.initDouble(0.0d);

    static {
        Double valueOf = Double.valueOf(0.0d);
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 49, 57}, new String[]{"shMcc", "shMnc", "iLac", "iCellId", "iRssi", "dStationLat", "dStationLon"}, new Object[]{0, 0, 0, 0, 0, valueOf, valueOf}, QQCircleSwitch$Cell_V2.class);
    }
}
