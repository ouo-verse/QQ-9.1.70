package tencent.im.oidb.cmd0x66b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x66b$RspConfigItem extends MessageMicro<Oidb_0x66b$RspConfigItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{484008, 484018, 484026, 484034, 484040, 484050}, new String[]{"uint32_id", "str_name", "str_url", "str_picurl", "uint32_redtouch_appid", "str_tips"}, new Object[]{0, "", "", "", 0, ""}, Oidb_0x66b$RspConfigItem.class);
    public final PBUInt32Field uint32_id = PBField.initUInt32(0);
    public final PBStringField str_name = PBField.initString("");
    public final PBStringField str_url = PBField.initString("");
    public final PBStringField str_picurl = PBField.initString("");
    public final PBUInt32Field uint32_redtouch_appid = PBField.initUInt32(0);
    public final PBStringField str_tips = PBField.initString("");
}
