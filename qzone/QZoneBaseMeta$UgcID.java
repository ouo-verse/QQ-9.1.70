package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.weiyun.transmission.db.JobDbManager;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZoneBaseMeta$UgcID extends MessageMicro<QZoneBaseMeta$UgcID> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 56}, new String[]{"app_id", "uin", "ctime", QCircleScheme.AttrQQPublish.PICKER_ALBUM_ID, "lloc", JobDbManager.COL_UP_BATCH_ID, "utime"}, new Object[]{0, 0L, 0L, "", "", "", 0L}, QZoneBaseMeta$UgcID.class);
    public final PBUInt32Field app_id = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt64Field ctime = PBField.initUInt64(0);
    public final PBStringField album_id = PBField.initString("");
    public final PBStringField lloc = PBField.initString("");
    public final PBStringField batch_id = PBField.initString("");
    public final PBUInt64Field utime = PBField.initUInt64(0);
}
