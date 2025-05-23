package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class QZIntimateSpaceWriter$StPublishFeedRsp extends MessageMicro<QZIntimateSpaceWriter$StPublishFeedRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"ext_info", "feed", "next_publish_time"}, new Object[]{null, null, 0L}, QZIntimateSpaceWriter$StPublishFeedRsp.class);
    public QZoneBaseCommon$StCommonExt ext_info = new QZoneBaseCommon$StCommonExt();
    public QZoneBaseMeta$StFeed feed = new QZoneBaseMeta$StFeed();
    public final PBUInt64Field next_publish_time = PBField.initUInt64(0);
}
