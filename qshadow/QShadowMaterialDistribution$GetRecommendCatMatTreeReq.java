package qshadow;

import android.net.http.Headers;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QShadowMaterialDistribution$GetRecommendCatMatTreeReq extends MessageMicro<QShadowMaterialDistribution$GetRecommendCatMatTreeReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 50, 58, 66}, new String[]{"groupID", "serviceID", "sdkVersion", Headers.ETAG, "materialID", "cateID"}, new Object[]{"", "", "", "", "", ""}, QShadowMaterialDistribution$GetRecommendCatMatTreeReq.class);
    public final PBStringField groupID = PBField.initString("");
    public final PBStringField serviceID = PBField.initString("");
    public final PBStringField sdkVersion = PBField.initString("");
    public final PBStringField etag = PBField.initString("");
    public final PBStringField materialID = PBField.initString("");
    public final PBStringField cateID = PBField.initString("");
}
