package wtlogin.qrlogin.scanresult;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class QrLogin$RiskInfo extends MessageMicro<QrLogin$RiskInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"str_tips_template", "str_login_loc", "str_appname", "str_new_tips_template"}, new Object[]{"", "", "", ""}, QrLogin$RiskInfo.class);
    public final PBStringField str_tips_template = PBField.initString("");
    public final PBStringField str_login_loc = PBField.initString("");
    public final PBStringField str_appname = PBField.initString("");
    public final PBStringField str_new_tips_template = PBField.initString("");
}
