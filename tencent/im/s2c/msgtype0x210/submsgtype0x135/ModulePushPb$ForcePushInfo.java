package tencent.im.s2c.msgtype0x210.submsgtype0x135;

import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class ModulePushPb$ForcePushInfo extends MessageMicro<ModulePushPb$ForcePushInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 56, 64, 74, 82}, new String[]{"action_text", "action_jump", "bg_url", "voice_url", "content", "title", "duration", "is_loop", MiniProgramLpReportDC04239.DETAIN_DIALOG_SUB_ACTION_CLICK_L, "bg_title"}, new Object[]{"", "", "", "", "", "", 0L, Boolean.FALSE, "", ""}, ModulePushPb$ForcePushInfo.class);
    public final PBStringField action_text = PBField.initString("");
    public final PBStringField action_jump = PBField.initString("");
    public final PBStringField bg_url = PBField.initString("");
    public final PBStringField voice_url = PBField.initString("");
    public final PBStringField content = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBUInt64Field duration = PBField.initUInt64(0);
    public final PBBoolField is_loop = PBField.initBool(false);
    public final PBStringField left_icon = PBField.initString("");
    public final PBStringField bg_title = PBField.initString("");
}
