package qshadow;

import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.QCircleReportHelper;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QShadowMetaMaterialRecommendation$GetMaterialRecommendationRsp extends MessageMicro<QShadowMetaMaterialRecommendation$GetMaterialRecommendationRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"Materials", QCircleReportHelper.MAP_KEY_SESSION, "ExpireTime", AECameraConstants.REQ_EXTRA}, new Object[]{null, "", 0L, ""}, QShadowMetaMaterialRecommendation$GetMaterialRecommendationRsp.class);
    public final PBRepeatMessageField<QShadowMetaMaterialRecommendation$RecommendationEntry> Materials = PBField.initRepeatMessage(QShadowMetaMaterialRecommendation$RecommendationEntry.class);
    public final PBStringField SessionID = PBField.initString("");
    public final PBInt64Field ExpireTime = PBField.initInt64(0);
    public final PBStringField Extra = PBField.initString("");
}
