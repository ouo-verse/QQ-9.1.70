package tencent.im.oidb.cmd0x7a1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x7a1$RspBody extends MessageMicro<oidb_0x7a1$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint32_result", "str_errmsg", "uint64_err_uin"}, new Object[]{0, "", 0L}, oidb_0x7a1$RspBody.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBStringField str_errmsg = PBField.initString("");
    public final PBUInt64Field uint64_err_uin = PBField.initUInt64(0);
}
