package qzone;

import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class QzoneActivityPB$GetUserDragonInfoRsp extends MessageMicro<QzoneActivityPB$GetUserDragonInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"dragon_info"}, new Object[]{null}, QzoneActivityPB$GetUserDragonInfoRsp.class);
    public QzoneActivityPB$DragonInfo dragon_info = new MessageMicro<QzoneActivityPB$DragonInfo>() { // from class: qzone.QzoneActivityPB$DragonInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"show_status", "dragon_id", LocalPhotoFaceInfo.SCORE, "is_Raise"}, new Object[]{0, "", 0, Boolean.FALSE}, QzoneActivityPB$DragonInfo.class);
        public final PBInt32Field show_status = PBField.initInt32(0);
        public final PBStringField dragon_id = PBField.initString("");
        public final PBUInt32Field score = PBField.initUInt32(0);
        public final PBBoolField is_Raise = PBField.initBool(false);
    };
}
