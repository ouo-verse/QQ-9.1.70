package tencent.im.oidb.cmd0x59f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x59f$Guidelines_common_web extends MessageMicro<oidb_0x59f$Guidelines_common_web> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48, 56, 64}, new String[]{"str_web_url", "uint32_groups_recomm_flag", "uint32_set_gender", "uint32_set_birthday", "uint32_set_head", "uint32_set_school", "uint32_set_region", "uint32_set_company"}, new Object[]{"", 0, 0, 0, 0, 0, 0, 0}, oidb_0x59f$Guidelines_common_web.class);
    public final PBStringField str_web_url = PBField.initString("");
    public final PBUInt32Field uint32_groups_recomm_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_set_gender = PBField.initUInt32(0);
    public final PBUInt32Field uint32_set_birthday = PBField.initUInt32(0);
    public final PBUInt32Field uint32_set_head = PBField.initUInt32(0);
    public final PBUInt32Field uint32_set_school = PBField.initUInt32(0);
    public final PBUInt32Field uint32_set_region = PBField.initUInt32(0);
    public final PBUInt32Field uint32_set_company = PBField.initUInt32(0);
}
