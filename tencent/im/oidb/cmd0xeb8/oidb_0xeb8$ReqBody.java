package tencent.im.oidb.cmd0xeb8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xeb8$ReqBody extends MessageMicro<oidb_0xeb8$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 32, 42}, new String[]{"uint32_src", "uint32_proto_ver", "uint32_country", "str_mask_phone"}, new Object[]{0, 0, 0, ""}, oidb_0xeb8$ReqBody.class);
    public final PBUInt32Field uint32_src = PBField.initUInt32(0);
    public final PBUInt32Field uint32_proto_ver = PBField.initUInt32(0);
    public final PBUInt32Field uint32_country = PBField.initUInt32(0);
    public final PBStringField str_mask_phone = PBField.initString("");
}
