package qshadow;

import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ShadowInspirationAI$InspirationAIReq extends MessageMicro<ShadowInspirationAI$InspirationAIReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{AECameraConstants.REQ_BUSI_ID, AECameraConstants.REQ_MEDIA_INFOS, AECameraConstants.REQ_EXTRA, "ReqID"}, new Object[]{"", null, "", ""}, ShadowInspirationAI$InspirationAIReq.class);
    public final PBStringField BusiID = PBField.initString("");
    public final PBRepeatMessageField<ShadowInspirationAI$InspirationMediaInfo> MediaInfos = PBField.initRepeatMessage(ShadowInspirationAI$InspirationMediaInfo.class);
    public final PBStringField Extra = PBField.initString("");
    public final PBStringField ReqID = PBField.initString("");
}
