package qzone;

import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;

/* loaded from: classes29.dex */
public final class QzoneActivityPB$ShareRsp extends MessageMicro<QzoneActivityPB$ShareRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{QZoneDTLoginReporter.SCHEMA, "display_data", "sign_ark", "addtional_msg"}, new Object[]{"", null, ByteStringMicro.EMPTY, ""}, QzoneActivityPB$ShareRsp.class);
    public final PBStringField schema = PBField.initString("");
    public QzoneActivityPB$ShareDisplayData display_data = new MessageMicro<QzoneActivityPB$ShareDisplayData>() { // from class: qzone.QzoneActivityPB$ShareDisplayData
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 64, 72}, new String[]{"activity_name", "desc1", "pic", "addtional_msg", "dragon_id", "target_user", "rank", LocalPhotoFaceInfo.SCORE}, new Object[]{"", "", "", "", "", null, 0, 0}, QzoneActivityPB$ShareDisplayData.class);
        public final PBStringField activity_name = PBField.initString("");
        public final PBStringField desc1 = PBField.initString("");
        public final PBStringField pic = PBField.initString("");
        public final PBStringField addtional_msg = PBField.initString("");
        public final PBStringField dragon_id = PBField.initString("");
        public QZoneBaseMeta$StUser target_user = new QZoneBaseMeta$StUser();
        public final PBUInt32Field rank = PBField.initUInt32(0);
        public final PBUInt32Field score = PBField.initUInt32(0);
    };
    public final PBBytesField sign_ark = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField addtional_msg = PBField.initString("");
}
