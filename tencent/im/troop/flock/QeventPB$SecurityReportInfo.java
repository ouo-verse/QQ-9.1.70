package tencent.im.troop.flock;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class QeventPB$SecurityReportInfo extends MessageMicro<QeventPB$SecurityReportInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"report_feed_appid", "report_user_appid", "content_id"}, new Object[]{0L, 0L, ""}, QeventPB$SecurityReportInfo.class);
    public final PBUInt64Field report_feed_appid = PBField.initUInt64(0);
    public final PBUInt64Field report_user_appid = PBField.initUInt64(0);
    public final PBStringField content_id = PBField.initString("");
}
