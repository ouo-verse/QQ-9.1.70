package wtlogin.qrlogin.scanresult;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class QrLogin$AutoRenewTicketInfo extends MessageMicro<QrLogin$AutoRenewTicketInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField is_show_switch = PBField.initBool(false);
    public final PBBoolField is_open_switch = PBField.initBool(false);
    public final PBStringField tips_title = PBField.initString("");
    public final PBStringField tips_template = PBField.initString("");

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"is_show_switch", "is_open_switch", "tips_title", "tips_template"}, new Object[]{bool, bool, "", ""}, QrLogin$AutoRenewTicketInfo.class);
    }
}
