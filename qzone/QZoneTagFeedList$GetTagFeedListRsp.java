package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZoneTagFeedList$GetTagFeedListRsp extends MessageMicro<QZoneTagFeedList$GetTagFeedListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"ext", "attach_info", "feed", "has_finish"}, new Object[]{null, "", null, Boolean.FALSE}, QZoneTagFeedList$GetTagFeedListRsp.class);
    public QZoneBaseCommon$StCommonExt ext = new QZoneBaseCommon$StCommonExt();
    public final PBStringField attach_info = PBField.initString("");
    public final PBRepeatMessageField<QZoneBaseMeta$StFeed> feed = PBField.initRepeatMessage(QZoneBaseMeta$StFeed.class);
    public final PBBoolField has_finish = PBField.initBool(false);
}
