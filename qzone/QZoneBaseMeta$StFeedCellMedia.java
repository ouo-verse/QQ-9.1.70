package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.weiyun.transmission.db.JobDbManager;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZoneBaseMeta$StFeedCellMedia extends MessageMicro<QZoneBaseMeta$StFeedCellMedia> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 50, 56, 64}, new String[]{"media_items", "album_name", QCircleScheme.AttrQQPublish.PICKER_ALBUM_ID, "upload_num", JobDbManager.COL_UP_BATCH_ID, "album_cover", "album_upload_num", "long_pics_browsing_mode"}, new Object[]{null, "", "", 0, 0L, null, 0, Boolean.FALSE}, QZoneBaseMeta$StFeedCellMedia.class);
    public final PBRepeatMessageField<QZoneBaseMeta$StMedia> media_items = PBField.initRepeatMessage(QZoneBaseMeta$StMedia.class);
    public final PBStringField album_name = PBField.initString("");
    public final PBStringField album_id = PBField.initString("");
    public final PBInt32Field upload_num = PBField.initInt32(0);
    public final PBUInt64Field batch_id = PBField.initUInt64(0);
    public QZoneBaseMeta$StImage album_cover = new QZoneBaseMeta$StImage();
    public final PBInt32Field album_upload_num = PBField.initInt32(0);
    public final PBBoolField long_pics_browsing_mode = PBField.initBool(false);
}
