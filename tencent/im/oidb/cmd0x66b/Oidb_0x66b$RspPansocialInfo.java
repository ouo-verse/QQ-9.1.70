package tencent.im.oidb.cmd0x66b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class Oidb_0x66b$RspPansocialInfo extends MessageMicro<Oidb_0x66b$RspPansocialInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{482408, 482416, 482424, 482432}, new String[]{"uint32_charm", "uint32_charmlevel", "uint32_charmlevelvalue", "uint32_nextcharmlevelvalue"}, new Object[]{0, 0, 0, 0}, Oidb_0x66b$RspPansocialInfo.class);
    public final PBUInt32Field uint32_charm = PBField.initUInt32(0);
    public final PBUInt32Field uint32_charmlevel = PBField.initUInt32(0);
    public final PBUInt32Field uint32_charmlevelvalue = PBField.initUInt32(0);
    public final PBUInt32Field uint32_nextcharmlevelvalue = PBField.initUInt32(0);
}
