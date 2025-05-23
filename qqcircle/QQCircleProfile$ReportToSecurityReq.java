package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;

/* loaded from: classes29.dex */
public final class QQCircleProfile$ReportToSecurityReq extends MessageMicro<QQCircleProfile$ReportToSecurityReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"uin", "sign", "school", IProfileProtocolConst.KEY_COMPANY, "location"}, new Object[]{0L, "", "", "", ""}, QQCircleProfile$ReportToSecurityReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField sign = PBField.initString("");
    public final PBStringField school = PBField.initString("");
    public final PBStringField company = PBField.initString("");
    public final PBStringField location = PBField.initString("");
}
