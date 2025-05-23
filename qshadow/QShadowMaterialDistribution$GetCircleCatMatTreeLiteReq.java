package qshadow;

import android.net.http.Headers;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QShadowMaterialDistribution$GetCircleCatMatTreeLiteReq extends MessageMicro<QShadowMaterialDistribution$GetCircleCatMatTreeLiteReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48}, new String[]{"groupID", "serviceID", "sdkVersion", Headers.ETAG, "enableCDN", "sortType"}, new Object[]{"", "", "", "", Boolean.FALSE, 0}, QShadowMaterialDistribution$GetCircleCatMatTreeLiteReq.class);
    public final PBStringField groupID = PBField.initString("");
    public final PBStringField serviceID = PBField.initString("");
    public final PBStringField sdkVersion = PBField.initString("");
    public final PBStringField etag = PBField.initString("");
    public final PBBoolField enableCDN = PBField.initBool(false);
    public final PBInt32Field sortType = PBField.initInt32(0);
}
