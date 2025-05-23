package qshadow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QShadowMaterialDistribution$GetRetainPageMatReq extends MessageMicro<QShadowMaterialDistribution$GetRetainPageMatReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"groupID", "serviceID", "sdkVersion"}, new Object[]{"", "", ""}, QShadowMaterialDistribution$GetRetainPageMatReq.class);
    public final PBStringField groupID = PBField.initString("");
    public final PBStringField serviceID = PBField.initString("");
    public final PBStringField sdkVersion = PBField.initString("");
}
