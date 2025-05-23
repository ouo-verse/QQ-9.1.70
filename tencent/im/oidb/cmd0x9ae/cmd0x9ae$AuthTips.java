package tencent.im.oidb.cmd0x9ae;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x9ae$AuthTips extends MessageMicro<cmd0x9ae$AuthTips> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82}, new String[]{"string_tips_title", "string_tips_context", "string_tips_action", "string_tips_action_url", "string_lbutton", "string_rbutton", "string_tbutton", "string_mbutton", "string_bbutton", "string_mask_phone"}, new Object[]{"", "", "", "", "", "", "", "", "", ""}, cmd0x9ae$AuthTips.class);
    public final PBStringField string_tips_title = PBField.initString("");
    public final PBStringField string_tips_context = PBField.initString("");
    public final PBStringField string_tips_action = PBField.initString("");
    public final PBStringField string_tips_action_url = PBField.initString("");
    public final PBStringField string_lbutton = PBField.initString("");
    public final PBStringField string_rbutton = PBField.initString("");
    public final PBStringField string_tbutton = PBField.initString("");
    public final PBStringField string_mbutton = PBField.initString("");
    public final PBStringField string_bbutton = PBField.initString("");
    public final PBStringField string_mask_phone = PBField.initString("");
}
