package tencent.im.qqwallet;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QWalletPubAdReport$TerminalInfor extends MessageMicro<QWalletPubAdReport$TerminalInfor> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 56, 66}, new String[]{"model", "appid", "edition", AppConstants.Preferences.QQ_VERSION, "device_name", "client_os", "root_flag", "device_id"}, new Object[]{"", "", "", "", "", "", 0, ""}, QWalletPubAdReport$TerminalInfor.class);
    public final PBStringField model = PBField.initString("");
    public final PBStringField appid = PBField.initString("");
    public final PBStringField edition = PBField.initString("");
    public final PBStringField qq_version = PBField.initString("");
    public final PBStringField device_name = PBField.initString("");
    public final PBStringField client_os = PBField.initString("");
    public final PBInt32Field root_flag = PBField.initInt32(0);
    public final PBStringField device_id = PBField.initString("");
}
