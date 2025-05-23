package qzone;

import com.qzone.album.data.model.PhotoCategorySinglePicInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZoneBaseMeta$StImage extends MessageMicro<QZoneBaseMeta$StImage> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField name = PBField.initString("");
    public final PBStringField sloc = PBField.initString("");
    public final PBStringField lloc = PBField.initString("");
    public final PBRepeatMessageField<QZoneBaseMeta$StPicSpecUrlEntry> photo_url = PBField.initRepeatMessage(QZoneBaseMeta$StPicSpecUrlEntry.class);
    public QZoneBaseMeta$StPicUrl default_url = new QZoneBaseMeta$StPicUrl();
    public final PBBoolField is_gif = PBField.initBool(false);
    public final PBEnumField type = PBField.initEnum(0);
    public final PBBoolField has_raw = PBField.initBool(false);

    static {
        String[] strArr = {"name", PhotoCategorySinglePicInfo.SLOC, "lloc", "photo_url", "default_url", "is_gif", "type", "has_raw"};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 56, 64}, strArr, new Object[]{"", "", "", null, null, bool, 0, bool}, QZoneBaseMeta$StImage.class);
    }
}
