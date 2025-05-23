package tencent.im.oidb.cmd0x978;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x978$OneFollowOperationInfo extends MessageMicro<oidb_cmd0x978$OneFollowOperationInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint64_dst_uin", "uint32_op_account_type", "uint32_source"}, new Object[]{0L, 1, 0}, oidb_cmd0x978$OneFollowOperationInfo.class);
    public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0);
    public final PBEnumField uint32_op_account_type = PBField.initEnum(1);
    public final PBUInt32Field uint32_source = PBField.initUInt32(0);
}
