package qzone;

import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class QzoneActivityPB$SetUserScoreReq extends MessageMicro<QzoneActivityPB$SetUserScoreReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{LocalPhotoFaceInfo.SCORE}, new Object[]{0}, QzoneActivityPB$SetUserScoreReq.class);
    public final PBUInt32Field score = PBField.initUInt32(0);
}
