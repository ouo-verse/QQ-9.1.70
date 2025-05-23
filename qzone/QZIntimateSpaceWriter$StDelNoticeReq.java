package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateSpaceWriter$StDelNoticeReq extends MessageMicro<QZIntimateSpaceWriter$StDelNoticeReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"ext_info", "from", "notice_id"}, new Object[]{null, 0, ""}, QZIntimateSpaceWriter$StDelNoticeReq.class);
    public QZoneBaseCommon$StCommonExt ext_info = new QZoneBaseCommon$StCommonExt();
    public final PBInt32Field from = PBField.initInt32(0);
    public final PBStringField notice_id = PBField.initString("");
}
