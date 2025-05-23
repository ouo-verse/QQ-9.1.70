package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class oidb_0xb60$GetPrivilegeRsp extends MessageMicro<oidb_0xb60$GetPrivilegeRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"api_groups", "next_req_duration", "api_names"}, new Object[]{0, 0, ""}, oidb_0xb60$GetPrivilegeRsp.class);
    public final PBRepeatField<Integer> api_groups = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field next_req_duration = PBField.initUInt32(0);
    public final PBRepeatField<String> api_names = PBField.initRepeat(PBStringField.__repeatHelper__);
}
