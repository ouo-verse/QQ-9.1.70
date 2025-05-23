package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateSpaceWriter$StDeleteFeedReq extends MessageMicro<QZIntimateSpaceWriter$StDeleteFeedReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"ext_info", "feed", "from", "is_delete_photo"}, new Object[]{null, null, 0, Boolean.FALSE}, QZIntimateSpaceWriter$StDeleteFeedReq.class);
    public QZoneBaseCommon$StCommonExt ext_info = new QZoneBaseCommon$StCommonExt();
    public QZoneBaseMeta$StFeed feed = new QZoneBaseMeta$StFeed();
    public final PBInt32Field from = PBField.initInt32(0);
    public final PBBoolField is_delete_photo = PBField.initBool(false);
}
