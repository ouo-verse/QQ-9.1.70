package tencent.im.oidb.cmd0x686;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x686$NearbyCharmNotify extends MessageMicro<Oidb_0x686$NearbyCharmNotify> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 74, 80}, new String[]{"uint32_pop_flag", "uint32_old_charm", "uint32_old_charm_level", "uint32_old_prof_percent", "uint32_new_charm", "uint32_new_charm_level", "uint32_new_prof_percent", "uint32_next_level_threshold", "str_tips_content", "uint32_cur_level_threshold"}, new Object[]{0, 0, 0, 0, 0, 0, 0, 0, "", 0}, Oidb_0x686$NearbyCharmNotify.class);
    public final PBUInt32Field uint32_pop_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_old_charm = PBField.initUInt32(0);
    public final PBUInt32Field uint32_old_charm_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_old_prof_percent = PBField.initUInt32(0);
    public final PBUInt32Field uint32_new_charm = PBField.initUInt32(0);
    public final PBUInt32Field uint32_new_charm_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_new_prof_percent = PBField.initUInt32(0);
    public final PBUInt32Field uint32_next_level_threshold = PBField.initUInt32(0);
    public final PBStringField str_tips_content = PBField.initString("");
    public final PBUInt32Field uint32_cur_level_threshold = PBField.initUInt32(0);
}
