package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZoneTagFeedList$GetTagFeedListReq extends MessageMicro<QZoneTagFeedList$GetTagFeedListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"ext", "attach_info", "tag_id"}, new Object[]{null, "", ""}, QZoneTagFeedList$GetTagFeedListReq.class);
    public QZoneBaseCommon$StCommonExt ext = new QZoneBaseCommon$StCommonExt();
    public final PBStringField attach_info = PBField.initString("");
    public final PBStringField tag_id = PBField.initString("");
}
