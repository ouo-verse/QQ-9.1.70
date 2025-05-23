package tencent.im.oidb.location;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes29.dex */
public final class RoomOperate$ReqAssemblyPointOperation extends MessageMicro<RoomOperate$ReqAssemblyPointOperation> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField poi_address;
    public final PBBytesField poi_name;
    public qq_lbs_share$RoomKey room_key = new qq_lbs_share$RoomKey();
    public final PBEnumField point_operation = PBField.initEnum(1);
    public final PBDoubleField lon = PBField.initDouble(0.0d);
    public final PBDoubleField lat = PBField.initDouble(0.0d);

    static {
        String[] strArr = {"room_key", "point_operation", "lon", QCircleSchemeAttr.Polymerize.LAT, "poi_name", "poi_address"};
        Double valueOf = Double.valueOf(0.0d);
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 25, 33, 42, 50}, strArr, new Object[]{null, 1, valueOf, valueOf, byteStringMicro, byteStringMicro}, RoomOperate$ReqAssemblyPointOperation.class);
    }

    public RoomOperate$ReqAssemblyPointOperation() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.poi_name = PBField.initBytes(byteStringMicro);
        this.poi_address = PBField.initBytes(byteStringMicro);
    }
}
