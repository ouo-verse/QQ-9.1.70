package tencent.im.oidb.cmd0x59f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x59f$WelcomeMenu extends MessageMicro<oidb_0x59f$WelcomeMenu> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{88, 98, 106, 114}, new String[]{"uint32_id", "str_icon_url", "str_wording", "str_target_url"}, new Object[]{0, "", "", ""}, oidb_0x59f$WelcomeMenu.class);
    public final PBUInt32Field uint32_id = PBField.initUInt32(0);
    public final PBStringField str_icon_url = PBField.initString("");
    public final PBStringField str_wording = PBField.initString("");
    public final PBStringField str_target_url = PBField.initString("");
}
