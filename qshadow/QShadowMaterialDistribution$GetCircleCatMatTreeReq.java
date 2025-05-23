package qshadow;

import android.net.http.Headers;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QShadowMaterialDistribution$GetCircleCatMatTreeReq extends MessageMicro<QShadowMaterialDistribution$GetCircleCatMatTreeReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"groupID", "serviceID", "sdkVersion", Headers.ETAG}, new Object[]{"", "", "", ""}, QShadowMaterialDistribution$GetCircleCatMatTreeReq.class);
    public final PBStringField groupID = PBField.initString("");
    public final PBStringField serviceID = PBField.initString("");
    public final PBStringField sdkVersion = PBField.initString("");
    public final PBStringField etag = PBField.initString("");
}
