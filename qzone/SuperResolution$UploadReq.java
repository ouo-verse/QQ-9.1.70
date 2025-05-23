package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.weiyun.transmission.db.JobDbManager;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SuperResolution$UploadReq extends MessageMicro<SuperResolution$UploadReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42}, new String[]{"task_id", QCircleScheme.AttrQQPublish.PICKER_ALBUM_ID, "sr_url", JobDbManager.COL_UP_BATCH_ID, "content"}, new Object[]{"", "", "", 0L, ""}, SuperResolution$UploadReq.class);
    public final PBStringField task_id = PBField.initString("");
    public final PBStringField album_id = PBField.initString("");
    public final PBStringField sr_url = PBField.initString("");
    public final PBUInt64Field batch_id = PBField.initUInt64(0);
    public final PBStringField content = PBField.initString("");
}
