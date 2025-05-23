package qshadow;

import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.QCircleReportHelper;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QShadowMetaMaterialRecommendation$GetMaterialRecommendationReq extends MessageMicro<QShadowMetaMaterialRecommendation$GetMaterialRecommendationReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 50, 58, 66, 74}, new String[]{AECameraConstants.REQ_BUSI_ID, "Images", "MediaType", "SdkVersion", QCircleReportHelper.MAP_KEY_SESSION, "XsjSessionID", AECameraConstants.REQ_MEDIA_INFOS, "ImageUrls", AECameraConstants.REQ_EXTRA}, new Object[]{0, ByteStringMicro.EMPTY, 0, "", "", "", null, "", ""}, QShadowMetaMaterialRecommendation$GetMaterialRecommendationReq.class);
    public final PBEnumField BusiID = PBField.initEnum(0);
    public final PBRepeatField<ByteStringMicro> Images = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBEnumField MediaType = PBField.initEnum(0);
    public final PBStringField SdkVersion = PBField.initString("");
    public final PBStringField SessionID = PBField.initString("");
    public final PBStringField XsjSessionID = PBField.initString("");
    public final PBRepeatMessageField<QShadowMetaMaterialRecommendation$MediaInfo> MediaInfos = PBField.initRepeatMessage(QShadowMetaMaterialRecommendation$MediaInfo.class);
    public final PBRepeatField<String> ImageUrls = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField Extra = PBField.initString("");
}
