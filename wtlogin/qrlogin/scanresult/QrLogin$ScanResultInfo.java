package wtlogin.qrlogin.scanresult;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class QrLogin$ScanResultInfo extends MessageMicro<QrLogin$ScanResultInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50}, new String[]{"scan_result", "safe_info", "risk_info", "reject_info", "tips_ctrl", "auto_renew_ticket_info"}, new Object[]{0, null, null, null, null, null}, QrLogin$ScanResultInfo.class);
    public final PBEnumField scan_result = PBField.initEnum(0);
    public QrLogin$SafeInfo safe_info = new MessageMicro<QrLogin$SafeInfo>() { // from class: wtlogin.qrlogin.scanresult.QrLogin$SafeInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"str_tips_template", "str_login_loc", "str_appname", "str_new_tips_template"}, new Object[]{"", "", "", ""}, QrLogin$SafeInfo.class);
        public final PBStringField str_tips_template = PBField.initString("");
        public final PBStringField str_login_loc = PBField.initString("");
        public final PBStringField str_appname = PBField.initString("");
        public final PBStringField str_new_tips_template = PBField.initString("");
    };
    public QrLogin$RiskInfo risk_info = new QrLogin$RiskInfo();
    public QrLogin$RejectInfo reject_info = new QrLogin$RejectInfo();
    public QrLogin$TipsCtrl tips_ctrl = new QrLogin$TipsCtrl();
    public QrLogin$AutoRenewTicketInfo auto_renew_ticket_info = new QrLogin$AutoRenewTicketInfo();
}
