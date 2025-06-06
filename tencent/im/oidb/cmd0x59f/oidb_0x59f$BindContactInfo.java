package tencent.im.oidb.cmd0x59f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x59f$BindContactInfo extends MessageMicro<oidb_0x59f$BindContactInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40}, new String[]{"str_mobile", "str_nation_code", "uint32_bind_time", "bool_inactive", "uint32_bind_type"}, new Object[]{"", "", 0, Boolean.FALSE, 0}, oidb_0x59f$BindContactInfo.class);
    public final PBStringField str_mobile = PBField.initString("");
    public final PBStringField str_nation_code = PBField.initString("");
    public final PBUInt32Field uint32_bind_time = PBField.initUInt32(0);
    public final PBBoolField bool_inactive = PBField.initBool(false);
    public final PBUInt32Field uint32_bind_type = PBField.initUInt32(0);
}
