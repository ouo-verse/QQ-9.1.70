package tencent.im.onlinestatus;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class BusinessInfo$LocationPoiInfo extends MessageMicro<BusinessInfo$LocationPoiInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field flag;
    public final PBBytesField poi_address;
    public final PBBytesField poi_name;
    public final PBUInt64Field operatoruin = PBField.initUInt64(0);
    public final PBDoubleField longitude = PBField.initDouble(0.0d);
    public final PBDoubleField latitude = PBField.initDouble(0.0d);
    public final PBDoubleField direction = PBField.initDouble(0.0d);
    public final PBUInt64Field update_time = PBField.initUInt64(0);

    static {
        Double valueOf = Double.valueOf(0.0d);
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 17, 25, 33, 40, 50, 58, 64}, new String[]{"operatoruin", "longitude", "latitude", "direction", "update_time", "poi_name", "poi_address", "flag"}, new Object[]{0L, valueOf, valueOf, valueOf, 0L, byteStringMicro, byteStringMicro, 0}, BusinessInfo$LocationPoiInfo.class);
    }

    public BusinessInfo$LocationPoiInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.poi_name = PBField.initBytes(byteStringMicro);
        this.poi_address = PBField.initBytes(byteStringMicro);
        this.flag = PBField.initUInt32(0);
    }
}
