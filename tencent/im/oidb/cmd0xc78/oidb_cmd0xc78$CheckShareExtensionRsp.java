package tencent.im.oidb.cmd0xc78;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xc78$CheckShareExtensionRsp extends MessageMicro<oidb_cmd0xc78$CheckShareExtensionRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40}, new String[]{"result", "jump_result", "jump_url", "uint32_level", "uint32_sub_level"}, new Object[]{0, 0, "", 0, 0}, oidb_cmd0xc78$CheckShareExtensionRsp.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBUInt32Field jump_result = PBField.initUInt32(0);
    public final PBStringField jump_url = PBField.initString("");
    public final PBUInt32Field uint32_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sub_level = PBField.initUInt32(0);
}
