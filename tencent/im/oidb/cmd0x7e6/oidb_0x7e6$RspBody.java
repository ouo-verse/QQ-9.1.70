package tencent.im.oidb.cmd0x7e6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x7e6$RspBody extends MessageMicro<oidb_0x7e6$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42}, new String[]{"opt_uint32_switch_on", "opt_uint32_num", "rpt_string_pics", "opt_uint64_group_id", "opt_string_url"}, new Object[]{0, 0, "", 0L, ""}, oidb_0x7e6$RspBody.class);
    public final PBUInt32Field opt_uint32_switch_on = PBField.initUInt32(0);
    public final PBUInt32Field opt_uint32_num = PBField.initUInt32(0);
    public final PBRepeatField<String> rpt_string_pics = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBUInt64Field opt_uint64_group_id = PBField.initUInt64(0);
    public final PBStringField opt_string_url = PBField.initString("");
}
