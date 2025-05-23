package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZoneTagFeedList$GetTagFeedListHeadReq extends MessageMicro<QZoneTagFeedList$GetTagFeedListHeadReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"tag_id"}, new Object[]{""}, QZoneTagFeedList$GetTagFeedListHeadReq.class);
    public final PBStringField tag_id = PBField.initString("");
}
