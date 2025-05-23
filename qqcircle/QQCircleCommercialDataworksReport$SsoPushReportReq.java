package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.tuxmetersdk.impl.ruleengine.JsonRuleKey;

/* loaded from: classes29.dex */
public final class QQCircleCommercialDataworksReport$SsoPushReportReq extends MessageMicro<QQCircleCommercialDataworksReport$SsoPushReportReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130, 138, 144, 152, 160, 168, 176}, new String[]{"account_type", "platform", "qimei36", "province", JsonRuleKey.OPERATOR, "app_version", "model", "os_version", "event_code", "oper_name", "module", "action", "ext1", "ext2", "ext3", "ext4", "ext5", "ext6", "ext7", "ext8", "ext9", "ext10"}, new Object[]{0, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", 0L, 0L, 0L, 0L, 0L}, QQCircleCommercialDataworksReport$SsoPushReportReq.class);
    public final PBEnumField account_type = PBField.initEnum(0);
    public final PBStringField platform = PBField.initString("");
    public final PBStringField qimei36 = PBField.initString("");
    public final PBStringField province = PBField.initString("");
    public final PBStringField operator = PBField.initString("");
    public final PBStringField app_version = PBField.initString("");
    public final PBStringField model = PBField.initString("");
    public final PBStringField os_version = PBField.initString("");
    public final PBStringField event_code = PBField.initString("");
    public final PBStringField oper_name = PBField.initString("");
    public final PBStringField module = PBField.initString("");
    public final PBStringField action = PBField.initString("");
    public final PBStringField ext1 = PBField.initString("");
    public final PBStringField ext2 = PBField.initString("");
    public final PBStringField ext3 = PBField.initString("");
    public final PBStringField ext4 = PBField.initString("");
    public final PBStringField ext5 = PBField.initString("");
    public final PBInt64Field ext6 = PBField.initInt64(0);
    public final PBInt64Field ext7 = PBField.initInt64(0);
    public final PBInt64Field ext8 = PBField.initInt64(0);
    public final PBInt64Field ext9 = PBField.initInt64(0);
    public final PBInt64Field ext10 = PBField.initInt64(0);
}
