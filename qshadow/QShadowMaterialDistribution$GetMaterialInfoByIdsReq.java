package qshadow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QShadowMaterialDistribution$GetMaterialInfoByIdsReq extends MessageMicro<QShadowMaterialDistribution$GetMaterialInfoByIdsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"groupID", "serviceID", "sdkVersion", "materialIDs"}, new Object[]{"", "", "", ""}, QShadowMaterialDistribution$GetMaterialInfoByIdsReq.class);
    public final PBStringField groupID = PBField.initString("");
    public final PBStringField serviceID = PBField.initString("");
    public final PBStringField sdkVersion = PBField.initString("");
    public final PBRepeatField<String> materialIDs = PBField.initRepeat(PBStringField.__repeatHelper__);
}
