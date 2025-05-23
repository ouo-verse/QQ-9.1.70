package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateSpaceReader$GetFeedDetailRsp extends MessageMicro<QZIntimateSpaceReader$GetFeedDetailRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"ext", "feed", "hasmore", "attach_info"}, new Object[]{null, null, Boolean.FALSE, ""}, QZIntimateSpaceReader$GetFeedDetailRsp.class);
    public QZoneBaseCommon$StCommonExt ext = new QZoneBaseCommon$StCommonExt();
    public QZIntimateSpaceReader$StClientFeed feed = new QZIntimateSpaceReader$StClientFeed();
    public final PBBoolField hasmore = PBField.initBool(false);
    public final PBStringField attach_info = PBField.initString("");
}
