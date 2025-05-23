package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class ExtBufForUI$PublicAccount extends MessageMicro<ExtBufForUI$PublicAccount> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40, 48, 56}, new String[]{"msgHasRead", "msgId", "shouldReport", "msgTemplateId", "sendFlag", "msgUnreadFlag", "msgExtraInfoType"}, new Object[]{0, "", 0, "", 0, 0, 0}, ExtBufForUI$PublicAccount.class);
    public final PBInt32Field msgHasRead = PBField.initInt32(0);
    public final PBStringField msgId = PBField.initString("");
    public final PBInt32Field shouldReport = PBField.initInt32(0);
    public final PBStringField msgTemplateId = PBField.initString("");
    public final PBInt32Field sendFlag = PBField.initInt32(0);
    public final PBInt32Field msgUnreadFlag = PBField.initInt32(0);
    public final PBInt32Field msgExtraInfoType = PBField.initInt32(0);
}
