package tencent.im.oidb.cmd0x59f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x59f$Guidelines_808_web extends MessageMicro<oidb_0x59f$Guidelines_808_web> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint32_friends_recomm_flag", "uint32_groups_recomm_flag", "str_web_url"}, new Object[]{0, 0, ""}, oidb_0x59f$Guidelines_808_web.class);
    public final PBUInt32Field uint32_friends_recomm_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_groups_recomm_flag = PBField.initUInt32(0);
    public final PBStringField str_web_url = PBField.initString("");
}
