package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xdea$RecallBarrageRspBody extends MessageMicro<oidb_0xdea$RecallBarrageRspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"int32_ret_code", "str_err_msg", "str_wording"}, new Object[]{0, "", ""}, oidb_0xdea$RecallBarrageRspBody.class);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_err_msg = PBField.initString("");
    public final PBStringField str_wording = PBField.initString("");
}
