package qzone;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.weiyun.transmission.db.JobDbManager;
import s4.c;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZoneBaseMeta$StMedia extends MessageMicro<QZoneBaseMeta$StMedia> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 56, 64, 72, 82, 90, 98, 106, 112, 120, 128, 136}, new String[]{"type", "image", "video", "desc", "lbs", "uploader", JobDbManager.COL_UP_BATCH_ID, c.UPLOAD_TIME, "upload_order", "like", "comment", "upload_user", "ext", "shoot_time", "link_id", "op_mask", "lbs_source"}, new Object[]{0, null, null, "", null, "", 0L, 0L, 0, null, null, null, null, 0L, 0L, 0, 0}, QZoneBaseMeta$StMedia.class);
    public final PBEnumField type = PBField.initEnum(0);
    public QZoneBaseMeta$StImage image = new QZoneBaseMeta$StImage();
    public QZoneBaseMeta$StVideo video = new QZoneBaseMeta$StVideo();
    public final PBStringField desc = PBField.initString("");
    public QZoneBaseMeta$StLBS lbs = new QZoneBaseMeta$StLBS();
    public final PBStringField uploader = PBField.initString("");
    public final PBUInt64Field batch_id = PBField.initUInt64(0);
    public final PBUInt64Field upload_time = PBField.initUInt64(0);
    public final PBUInt32Field upload_order = PBField.initUInt32(0);
    public QZoneBaseMeta$StMediaLike like = new MessageMicro<QZoneBaseMeta$StMediaLike>() { // from class: qzone.QZoneBaseMeta$StMediaLike
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"key", WidgetCacheConstellationData.NUM, "liked"}, new Object[]{"", 0, Boolean.FALSE}, QZoneBaseMeta$StMediaLike.class);
        public final PBStringField key = PBField.initString("");
        public final PBInt32Field num = PBField.initInt32(0);
        public final PBBoolField liked = PBField.initBool(false);
    };
    public QZoneBaseMeta$StMediaComment comment = new MessageMicro<QZoneBaseMeta$StMediaComment>() { // from class: qzone.QZoneBaseMeta$StMediaComment
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{WidgetCacheConstellationData.NUM}, new Object[]{0}, QZoneBaseMeta$StMediaComment.class);
        public final PBInt32Field num = PBField.initInt32(0);
    };
    public QZoneBaseMeta$StUser upload_user = new QZoneBaseMeta$StUser();
    public final PBRepeatMessageField<QZoneBaseCommon$Entry> ext = PBField.initRepeatMessage(QZoneBaseCommon$Entry.class);
    public final PBUInt64Field shoot_time = PBField.initUInt64(0);
    public final PBUInt64Field link_id = PBField.initUInt64(0);
    public final PBRepeatField<Integer> op_mask = PBField.initRepeat(PBEnumField.__repeatHelper__);
    public final PBEnumField lbs_source = PBField.initEnum(0);
}
