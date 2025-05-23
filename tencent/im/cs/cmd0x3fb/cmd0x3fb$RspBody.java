package tencent.im.cs.cmd0x3fb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x3fb$RspBody extends MessageMicro<cmd0x3fb$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42, 48, 56, 66, 74, 80}, new String[]{"int32_ret", "int32_gray_flag", "str_url", "int32_color", "rpt_msg_buffer_ex_data", "int32_enter_glive_strategy", "uint64_to_guin", "str_update_title", "str_update_content", "int32_pre_download_toggle"}, new Object[]{0, 0, "", 0, null, 0, 0L, "", "", 0}, cmd0x3fb$RspBody.class);
    public final PBInt32Field int32_ret = PBField.initInt32(0);
    public final PBInt32Field int32_gray_flag = PBField.initInt32(0);
    public final PBStringField str_url = PBField.initString("");
    public final PBInt32Field int32_color = PBField.initInt32(0);
    public final PBRepeatMessageField<cmd0x3fb$BufferExData> rpt_msg_buffer_ex_data = PBField.initRepeatMessage(cmd0x3fb$BufferExData.class);
    public final PBInt32Field int32_enter_glive_strategy = PBField.initInt32(0);
    public final PBUInt64Field uint64_to_guin = PBField.initUInt64(0);
    public final PBStringField str_update_title = PBField.initString("");
    public final PBStringField str_update_content = PBField.initString("");
    public final PBInt32Field int32_pre_download_toggle = PBField.initInt32(0);
}
