package tencent.im.oidb.cmd0x1172;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x1172$Cmd0x1172Response extends MessageMicro<cmd0x1172$Cmd0x1172Response> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40}, new String[]{"should_issue", "url", "brief", "link_part", "effect_time"}, new Object[]{Boolean.FALSE, "", "", "", 0}, cmd0x1172$Cmd0x1172Response.class);
    public final PBBoolField should_issue = PBField.initBool(false);
    public final PBStringField url = PBField.initString("");
    public final PBStringField brief = PBField.initString("");
    public final PBStringField link_part = PBField.initString("");
    public final PBInt32Field effect_time = PBField.initInt32(0);
    public final PBStringField str_error = PBField.initString("");
}
