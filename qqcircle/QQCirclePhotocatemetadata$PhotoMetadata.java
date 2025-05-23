package qqcircle;

import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QQCirclePhotocatemetadata$PhotoMetadata extends MessageMicro<QQCirclePhotocatemetadata$PhotoMetadata> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 48, 56, 66, 74, 80, 93}, new String[]{"id", "path", "mimeType", "time", "modifyTime", "width", "height", "exif", ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "favourite", "qualityScore"}, new Object[]{"", "", "", 0L, 0L, 0, 0, null, null, 0, Float.valueOf(0.0f)}, QQCirclePhotocatemetadata$PhotoMetadata.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f429309id = PBField.initString("");
    public final PBStringField path = PBField.initString("");
    public final PBStringField mimeType = PBField.initString("");
    public final PBInt64Field time = PBField.initInt64(0);
    public final PBInt64Field modifyTime = PBField.initInt64(0);
    public final PBInt32Field width = PBField.initInt32(0);
    public final PBInt32Field height = PBField.initInt32(0);
    public QQCirclePhotocatemetadata$PhotoExifInfo exif = new MessageMicro<QQCirclePhotocatemetadata$PhotoExifInfo>() { // from class: qqcircle.QQCirclePhotocatemetadata$PhotoExifInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50, 58, 66, 74, 82, 90}, new String[]{"orientation", "flash", "latitude", "longitude", "make", "model", "whiteBalance", "exposureTime", "aperture", "focalLength", "iso"}, new Object[]{0, 0, 0L, 0L, "", "", "", "", "", "", ""}, QQCirclePhotocatemetadata$PhotoExifInfo.class);
        public final PBInt32Field orientation = PBField.initInt32(0);
        public final PBInt32Field flash = PBField.initInt32(0);
        public final PBInt64Field latitude = PBField.initInt64(0);
        public final PBInt64Field longitude = PBField.initInt64(0);
        public final PBStringField make = PBField.initString("");
        public final PBStringField model = PBField.initString("");
        public final PBStringField whiteBalance = PBField.initString("");
        public final PBStringField exposureTime = PBField.initString("");
        public final PBStringField aperture = PBField.initString("");
        public final PBStringField focalLength = PBField.initString("");
        public final PBStringField iso = PBField.initString("");
    };
    public final PBRepeatMessageField<QQCirclePhotocatemetadata$PhotoTagInfo> tags = PBField.initRepeatMessage(QQCirclePhotocatemetadata$PhotoTagInfo.class);
    public final PBInt32Field favourite = PBField.initInt32(0);
    public final PBFloatField qualityScore = PBField.initFloat(0.0f);
}
