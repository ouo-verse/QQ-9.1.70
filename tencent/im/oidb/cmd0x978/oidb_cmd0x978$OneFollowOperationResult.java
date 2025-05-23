package tencent.im.oidb.cmd0x978;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x978$OneFollowOperationResult extends MessageMicro<oidb_cmd0x978$OneFollowOperationResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 88}, new String[]{"uint64_dst_uin", "uint32_op_account_type", "uint32_op_result", "enum_follow_status", "uint32_guide_type"}, new Object[]{0L, 1, 0, 0, 0}, oidb_cmd0x978$OneFollowOperationResult.class);
    public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0);
    public final PBEnumField uint32_op_account_type = PBField.initEnum(1);
    public final PBUInt32Field uint32_op_result = PBField.initUInt32(0);
    public final PBEnumField enum_follow_status = PBField.initEnum(0);
    public final PBUInt32Field uint32_guide_type = PBField.initUInt32(0);
}
