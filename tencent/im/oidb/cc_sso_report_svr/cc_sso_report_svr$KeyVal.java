package tencent.im.oidb.cc_sso_report_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.thumbplayer.report.reportv1.TPReportParams;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cc_sso_report_svr$KeyVal extends MessageMicro<cc_sso_report_svr$KeyVal> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", TPReportParams.JSON_KEY_VAL}, new Object[]{"", ""}, cc_sso_report_svr$KeyVal.class);
    public final PBStringField key = PBField.initString("");
    public final PBStringField val = PBField.initString("");
}
