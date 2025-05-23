package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class ModifyPwdDisplayInfo$RspBody extends MessageMicro<ModifyPwdDisplayInfo$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"uint32_display_flag", "str_hori_bar_content", "str_bar_url", "uint32_next_access_time"}, new Object[]{0, "", "", 0}, ModifyPwdDisplayInfo$RspBody.class);
    public final PBUInt32Field uint32_display_flag = PBField.initUInt32(0);
    public final PBStringField str_hori_bar_content = PBField.initString("");
    public final PBStringField str_bar_url = PBField.initString("");
    public final PBUInt32Field uint32_next_access_time = PBField.initUInt32(0);
}
