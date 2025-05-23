package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateSpaceReader$GetFeedDetailReq extends MessageMicro<QZIntimateSpaceReader$GetFeedDetailReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"ext", "feed_id", "count", "attach_info"}, new Object[]{null, "", 0, ""}, QZIntimateSpaceReader$GetFeedDetailReq.class);
    public QZoneBaseCommon$StCommonExt ext = new QZoneBaseCommon$StCommonExt();
    public final PBStringField feed_id = PBField.initString("");
    public final PBInt32Field count = PBField.initInt32(0);
    public final PBStringField attach_info = PBField.initString("");
}
