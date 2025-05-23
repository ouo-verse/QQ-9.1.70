package tencent.im.group;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class group_member_info$RspBody extends MessageMicro<group_member_info$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40}, new String[]{"uint64_group_code", "uint32_self_role", "msg_meminfo", "bool_self_location_shared", "uint32_group_type"}, new Object[]{0L, 0, null, Boolean.FALSE, 0}, group_member_info$RspBody.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt32Field uint32_self_role = PBField.initUInt32(0);
    public group_member_info$MemberInfo msg_meminfo = new group_member_info$MemberInfo();
    public final PBBoolField bool_self_location_shared = PBField.initBool(false);
    public final PBUInt32Field uint32_group_type = PBField.initUInt32(0);
}
