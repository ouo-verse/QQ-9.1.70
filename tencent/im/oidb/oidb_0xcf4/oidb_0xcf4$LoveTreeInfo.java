package tencent.im.oidb.oidb_0xcf4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xcf4$LoveTreeInfo extends MessageMicro<oidb_0xcf4$LoveTreeInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 48}, new String[]{"str_use_tree_icon", "uint32_lack_water_flag", "str_drop_icon", "str_jump_url", "str_jump_h5_url", "uint32_level"}, new Object[]{"", 0, "", "", "", 0}, oidb_0xcf4$LoveTreeInfo.class);
    public final PBStringField str_use_tree_icon = PBField.initString("");
    public final PBUInt32Field uint32_lack_water_flag = PBField.initUInt32(0);
    public final PBStringField str_drop_icon = PBField.initString("");
    public final PBStringField str_jump_url = PBField.initString("");
    public final PBStringField str_jump_h5_url = PBField.initString("");
    public final PBUInt32Field uint32_level = PBField.initUInt32(0);
}
