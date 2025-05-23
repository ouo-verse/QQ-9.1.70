package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.weiyun.transmission.db.JobDbManager;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateSpaceAlbum$GetMediasListReq extends MessageMicro<QZIntimateSpaceAlbum$GetMediasListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42}, new String[]{"search_type", "space_id", QCircleScheme.AttrQQPublish.PICKER_ALBUM_ID, JobDbManager.COL_UP_BATCH_ID, "attach_info"}, new Object[]{0, "", "", 0L, ""}, QZIntimateSpaceAlbum$GetMediasListReq.class);
    public final PBEnumField search_type = PBField.initEnum(0);
    public final PBStringField space_id = PBField.initString("");
    public final PBStringField album_id = PBField.initString("");
    public final PBUInt64Field batch_id = PBField.initUInt64(0);
    public final PBStringField attach_info = PBField.initString("");
}
