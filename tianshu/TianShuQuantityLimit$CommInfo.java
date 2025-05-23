package tianshu;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TianShuQuantityLimit$CommInfo extends MessageMicro<TianShuQuantityLimit$CommInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 26, 34, 40, 50, 58, 66, 74, 82, 90, 96, 106, 114, 122, 128, 162, 170}, new String[]{"lUin", "strDeviceInfo", "stGps", "iBid", "strUserIp", "strApp", "strOs", "strVersion", "strOpenId", "strCityCode", "iNetWorkEnv", "strQua", "strQimei", "strUid", "bLocationAuthorization", "strExpSeq", "traceId"}, new Object[]{0L, "", null, 0, "", "", "", "", "", "", 0, "", "", "", Boolean.FALSE, "", ""}, TianShuQuantityLimit$CommInfo.class);
    public final PBUInt64Field lUin = PBField.initUInt64(0);
    public final PBStringField strDeviceInfo = PBField.initString("");
    public TianShuQuantityLimit$Gps stGps = new MessageMicro<TianShuQuantityLimit$Gps>() { // from class: tianshu.TianShuQuantityLimit$Gps
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{QCircleSchemeAttr.Polymerize.LAT, "lon", "accuracy"}, new Object[]{0, 0, 0}, TianShuQuantityLimit$Gps.class);
        public final PBInt32Field lat = PBField.initInt32(0);
        public final PBInt32Field lon = PBField.initInt32(0);
        public final PBInt32Field accuracy = PBField.initInt32(0);
    };
    public final PBUInt32Field iBid = PBField.initUInt32(0);
    public final PBStringField strUserIp = PBField.initString("");
    public final PBStringField strApp = PBField.initString("");
    public final PBStringField strOs = PBField.initString("");
    public final PBStringField strVersion = PBField.initString("");
    public final PBStringField strOpenId = PBField.initString("");
    public final PBStringField strCityCode = PBField.initString("");
    public final PBInt32Field iNetWorkEnv = PBField.initInt32(0);
    public final PBStringField strQua = PBField.initString("");
    public final PBStringField strQimei = PBField.initString("");
    public final PBStringField strUid = PBField.initString("");
    public final PBBoolField bLocationAuthorization = PBField.initBool(false);
    public final PBStringField strExpSeq = PBField.initString("");
    public final PBStringField traceId = PBField.initString("");
}
