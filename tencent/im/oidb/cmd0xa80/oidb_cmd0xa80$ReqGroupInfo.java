package tencent.im.oidb.cmd0xa80;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xa80$ReqGroupInfo extends MessageMicro<oidb_cmd0xa80$ReqGroupInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40}, new String[]{"uint64_group_code", "rpt_msg_member_info", "uint32_op", "uint32_client_type", "uint64_root_code"}, new Object[]{0L, null, 0, 0, 0L}, oidb_cmd0xa80$ReqGroupInfo.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBRepeatMessageField<oidb_cmd0xa80$MemberInfo> rpt_msg_member_info = PBField.initRepeatMessage(oidb_cmd0xa80$MemberInfo.class);
    public final PBUInt32Field uint32_op = PBField.initUInt32(0);
    public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_root_code = PBField.initUInt64(0);
}
