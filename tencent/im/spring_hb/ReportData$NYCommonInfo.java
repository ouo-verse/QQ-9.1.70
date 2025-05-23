package tencent.im.spring_hb;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ReportData$NYCommonInfo extends MessageMicro<ReportData$NYCommonInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 48, 56, 66, 74}, new String[]{"adcode", "platform", "qqVersion", "model", "ver", "appid", "net", "brand", AppConstants.VIPKey.KEY_FOR_VIP_TYPE}, new Object[]{"", 0, "", "", "", 0, 0, "", ""}, ReportData$NYCommonInfo.class);
    public final PBStringField adcode = PBField.initString("");
    public final PBUInt32Field platform = PBField.initUInt32(0);
    public final PBStringField qqVersion = PBField.initString("");
    public final PBStringField model = PBField.initString("");
    public final PBStringField ver = PBField.initString("");
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBUInt32Field net = PBField.initUInt32(0);
    public final PBStringField brand = PBField.initString("");
    public final PBStringField vip_type = PBField.initString("");
}
