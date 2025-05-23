package tencent.im.oidb.cmd0x9ae;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x9ae$SmallTips extends MessageMicro<cmd0x9ae$SmallTips> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"string_tips_context", "string_tips_action_url"}, new Object[]{"", ""}, cmd0x9ae$SmallTips.class);
    public final PBStringField string_tips_context = PBField.initString("");
    public final PBStringField string_tips_action_url = PBField.initString("");
}
