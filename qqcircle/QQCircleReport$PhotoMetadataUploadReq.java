package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class QQCircleReport$PhotoMetadataUploadReq extends MessageMicro<QQCircleReport$PhotoMetadataUploadReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"AddPhotoMetadatas", "DelPhotoMetadatas", "uploadComplete"}, new Object[]{null, null, Boolean.FALSE}, QQCircleReport$PhotoMetadataUploadReq.class);
    public final PBRepeatMessageField<QQCirclePhotocatemetadata$PhotoMetadata> AddPhotoMetadatas = PBField.initRepeatMessage(QQCirclePhotocatemetadata$PhotoMetadata.class);
    public final PBRepeatMessageField<QQCirclePhotocatemetadata$PhotoMetadata> DelPhotoMetadatas = PBField.initRepeatMessage(QQCirclePhotocatemetadata$PhotoMetadata.class);
    public final PBBoolField uploadComplete = PBField.initBool(false);
}
