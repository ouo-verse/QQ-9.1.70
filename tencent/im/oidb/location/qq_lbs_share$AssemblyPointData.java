package tencent.im.oidb.location;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.tuxmetersdk.impl.ruleengine.JsonRuleKey;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;

/* loaded from: classes29.dex */
public final class qq_lbs_share$AssemblyPointData extends MessageMicro<qq_lbs_share$AssemblyPointData> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField poi_address;
    public final PBBytesField poi_name;
    public final PBUInt64Field operator = PBField.initUInt64(0);
    public final PBEnumField operation = PBField.initEnum(1);
    public final PBDoubleField lon = PBField.initDouble(0.0d);
    public final PBDoubleField lat = PBField.initDouble(0.0d);
    public final PBUInt64Field update_ts = PBField.initUInt64(0);

    static {
        String[] strArr = {JsonRuleKey.OPERATOR, QCircleDaTongConstant.ElementParamValue.OPERATION, "lon", QCircleSchemeAttr.Polymerize.LAT, "update_ts", "poi_name", "poi_address"};
        Double valueOf = Double.valueOf(0.0d);
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 25, 33, 40, 50, 58}, strArr, new Object[]{0L, 1, valueOf, valueOf, 0L, byteStringMicro, byteStringMicro}, qq_lbs_share$AssemblyPointData.class);
    }

    public qq_lbs_share$AssemblyPointData() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.poi_name = PBField.initBytes(byteStringMicro);
        this.poi_address = PBField.initBytes(byteStringMicro);
    }
}
