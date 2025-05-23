package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZoneBaseMeta$StVideo extends MessageMicro<QZoneBaseMeta$StVideo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 48, 58, 64, 72}, new String[]{"id", "url", "cover", "width", "height", "video_time", "video_url", "size", "has_raw"}, new Object[]{"", "", null, 0, 0, 0L, null, 0L, Boolean.FALSE}, QZoneBaseMeta$StVideo.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f430340id = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public QZoneBaseMeta$StImage cover = new QZoneBaseMeta$StImage();
    public final PBInt32Field width = PBField.initInt32(0);
    public final PBInt32Field height = PBField.initInt32(0);
    public final PBUInt64Field video_time = PBField.initUInt64(0);
    public final PBRepeatMessageField<QZoneBaseMeta$StPicSpecUrlEntry> video_url = PBField.initRepeatMessage(QZoneBaseMeta$StPicSpecUrlEntry.class);
    public final PBUInt64Field size = PBField.initUInt64(0);
    public final PBBoolField has_raw = PBField.initBool(false);
}
