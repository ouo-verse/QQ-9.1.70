package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class subcmd0x519$GetNavigationMenuRspBody extends MessageMicro<subcmd0x519$GetNavigationMenuRspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32}, new String[]{"msg_ret", "int32_is_show", "str_struct_msg", "uint32_ver_no"}, new Object[]{null, 0, "", 0}, subcmd0x519$GetNavigationMenuRspBody.class);
    public subcmd0x519$RetInfo msg_ret = new subcmd0x519$RetInfo();
    public final PBInt32Field int32_is_show = PBField.initInt32(0);
    public final PBStringField str_struct_msg = PBField.initString("");
    public final PBUInt32Field uint32_ver_no = PBField.initUInt32(0);
}
