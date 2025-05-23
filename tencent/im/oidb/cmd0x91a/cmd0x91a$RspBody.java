package tencent.im.oidb.cmd0x91a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0x88d.oidb_0x88d$GroupInfo;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x91a$RspBody extends MessageMicro<cmd0x91a$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40}, new String[]{"uint32_result_status", "uint32_audit_times_max", "uint32_audit_times_remain", "group_info", "uint64_group_code"}, new Object[]{0, 0, 0, null, 0L}, cmd0x91a$RspBody.class);
    public final PBUInt32Field uint32_result_status = PBField.initUInt32(0);
    public final PBUInt32Field uint32_audit_times_max = PBField.initUInt32(0);
    public final PBUInt32Field uint32_audit_times_remain = PBField.initUInt32(0);
    public oidb_0x88d$GroupInfo group_info = new oidb_0x88d$GroupInfo();
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
}
