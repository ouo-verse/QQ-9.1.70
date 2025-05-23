package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.weiyun.transmission.db.JobDbManager;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateSpaceAlbum$DeleteMediasByBatchReq extends MessageMicro<QZIntimateSpaceAlbum$DeleteMediasByBatchReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"space_id", QCircleScheme.AttrQQPublish.PICKER_ALBUM_ID, JobDbManager.COL_UP_BATCH_ID}, new Object[]{"", "", 0L}, QZIntimateSpaceAlbum$DeleteMediasByBatchReq.class);
    public final PBStringField space_id = PBField.initString("");
    public final PBStringField album_id = PBField.initString("");
    public final PBUInt64Field batch_id = PBField.initUInt64(0);
}
