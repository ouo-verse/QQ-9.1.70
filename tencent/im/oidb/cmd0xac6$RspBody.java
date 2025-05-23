package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xac6$RspBody extends MessageMicro<cmd0xac6$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 32, 40, 72, 80, 90}, new String[]{"rpt_results", "uint32_metal_count", "uint32_metal_total", "int32_new_count", "int32_upgrade_count", "str_prompt_params"}, new Object[]{null, 0, 0, 0, 0, ""}, cmd0xac6$RspBody.class);
    public final PBRepeatMessageField<cmd0xac6$operate_result> rpt_results = PBField.initRepeatMessage(cmd0xac6$operate_result.class);
    public final PBUInt32Field uint32_metal_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_metal_total = PBField.initUInt32(0);
    public final PBInt32Field int32_new_count = PBField.initInt32(0);
    public final PBInt32Field int32_upgrade_count = PBField.initInt32(0);
    public final PBStringField str_prompt_params = PBField.initString("");
}
