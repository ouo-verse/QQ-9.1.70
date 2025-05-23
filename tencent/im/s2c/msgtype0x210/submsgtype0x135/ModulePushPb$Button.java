package tencent.im.s2c.msgtype0x210.submsgtype0x135;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class ModulePushPb$Button extends MessageMicro<ModulePushPb$Button> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"desc", "str_url", "uint32_type"}, new Object[]{"", "", 0}, ModulePushPb$Button.class);
    public final PBStringField desc = PBField.initString("");
    public final PBStringField str_url = PBField.initString("");
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
}
