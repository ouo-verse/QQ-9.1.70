package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes29.dex */
public final class QZIntimateSpaceWriter$StPublishFeedReq extends MessageMicro<QZIntimateSpaceWriter$StPublishFeedReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"ext_info", "feed", "from", "sync_qzone"}, new Object[]{null, null, 0, Boolean.FALSE}, QZIntimateSpaceWriter$StPublishFeedReq.class);
    public QZoneBaseCommon$StCommonExt ext_info = new QZoneBaseCommon$StCommonExt();
    public QZoneBaseMeta$StFeed feed = new QZoneBaseMeta$StFeed();
    public final PBInt32Field from = PBField.initInt32(0);
    public final PBBoolField sync_qzone = PBField.initBool(false);
}
