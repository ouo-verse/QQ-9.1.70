package tencent.im.oidb.location;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class RoomOperate$ReqRoomOperation extends MessageMicro<RoomOperate$ReqRoomOperation> {
    static final MessageMicro.FieldMap __fieldMap__;
    public qq_lbs_share$RoomKey room_key = new qq_lbs_share$RoomKey();
    public final PBEnumField room_operation = PBField.initEnum(1);
    public final PBEnumField client_type = PBField.initEnum(1);
    public final PBDoubleField lon = PBField.initDouble(0.0d);
    public final PBDoubleField lat = PBField.initDouble(0.0d);

    static {
        String[] strArr = {"room_key", "room_operation", AudienceReportConst.CLIENT_TYPE, "lon", QCircleSchemeAttr.Polymerize.LAT};
        Double valueOf = Double.valueOf(0.0d);
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 33, 41}, strArr, new Object[]{null, 1, 1, valueOf, valueOf}, RoomOperate$ReqRoomOperation.class);
    }
}
