package tencent.im.oidb.cmd0xf12;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xf12$RspBody extends MessageMicro<oidb_0xf12$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"uint32_guidecardid", "uint32_guidecardtype", "str_main_msg", "str_secondary_msg"}, new Object[]{0, 0, "", ""}, oidb_0xf12$RspBody.class);
    public final PBUInt32Field uint32_guidecardid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_guidecardtype = PBField.initUInt32(0);
    public final PBStringField str_main_msg = PBField.initString("");
    public final PBStringField str_secondary_msg = PBField.initString("");
}
