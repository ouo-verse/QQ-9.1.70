package tencent.im.oidb.location;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class RoomOperate$UserData extends MessageMicro<RoomOperate$UserData> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt64Field join_time = PBField.initUInt64(0);
    public final PBDoubleField lon = PBField.initDouble(0.0d);
    public final PBDoubleField lat = PBField.initDouble(0.0d);
    public final PBDoubleField direction = PBField.initDouble(0.0d);
    public final PBUInt64Field lbs_update_ts = PBField.initUInt64(0);

    static {
        String[] strArr = {"uin", "join_time", "lon", QCircleSchemeAttr.Polymerize.LAT, "direction", "lbs_update_ts"};
        Double valueOf = Double.valueOf(0.0d);
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 25, 33, 41, 48}, strArr, new Object[]{0L, 0L, valueOf, valueOf, valueOf, 0L}, RoomOperate$UserData.class);
    }
}
