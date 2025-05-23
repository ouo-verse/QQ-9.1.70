package tencent.im.oidb.cmd0x7a0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x7a0$ReqBody extends MessageMicro<oidb_0x7a0$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40}, new String[]{"uint64_bind_uin", "msg_bind_uin_sig", "str_imei", "uint32_clt_appid", "uint32_flag"}, new Object[]{0L, null, "", 0, 0}, oidb_0x7a0$ReqBody.class);
    public final PBUInt64Field uint64_bind_uin = PBField.initUInt64(0);
    public oidb_0x7a0$LoginSig msg_bind_uin_sig = new oidb_0x7a0$LoginSig();
    public final PBStringField str_imei = PBField.initString("");
    public final PBUInt32Field uint32_clt_appid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
}
