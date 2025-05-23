package qzone;

import com.qzone.album.data.model.PhotoCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZoneBaseMeta$FeedExtInfo extends MessageMicro<QZoneBaseMeta$FeedExtInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40}, new String[]{"app_id", "type_id", "unused1", "unused2", PhotoCacheData.OWNER_UIN}, new Object[]{0, 0, "", "", 0L}, QZoneBaseMeta$FeedExtInfo.class);
    public final PBInt32Field app_id = PBField.initInt32(0);
    public final PBInt32Field type_id = PBField.initInt32(0);
    public final PBStringField unused1 = PBField.initString("");
    public final PBStringField unused2 = PBField.initString("");
    public final PBUInt64Field owner_uin = PBField.initUInt64(0);
}
