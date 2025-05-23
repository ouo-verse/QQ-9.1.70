package tencent.im.oidb;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class qqconnect$IOSAppInfo extends MessageMicro<qqconnect$IOSAppInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{ReportDataBuilder.KEY_BUNDLE_ID, "url_scheme", "store_id"}, new Object[]{"", "", ""}, qqconnect$IOSAppInfo.class);
    public final PBStringField bundle_id = PBField.initString("");
    public final PBStringField url_scheme = PBField.initString("");
    public final PBStringField store_id = PBField.initString("");
}
