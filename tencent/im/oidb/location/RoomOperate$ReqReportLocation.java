package tencent.im.oidb.location;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class RoomOperate$ReqReportLocation extends MessageMicro<RoomOperate$ReqReportLocation> {
    static final MessageMicro.FieldMap __fieldMap__;
    public qq_lbs_share$RoomKey room_key = new qq_lbs_share$RoomKey();
    public final PBDoubleField lon = PBField.initDouble(0.0d);
    public final PBDoubleField lat = PBField.initDouble(0.0d);
    public final PBDoubleField direction = PBField.initDouble(0.0d);

    static {
        String[] strArr = {"room_key", "lon", QCircleSchemeAttr.Polymerize.LAT, "direction"};
        Double valueOf = Double.valueOf(0.0d);
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 17, 25, 33}, strArr, new Object[]{null, valueOf, valueOf, valueOf}, RoomOperate$ReqReportLocation.class);
    }
}
