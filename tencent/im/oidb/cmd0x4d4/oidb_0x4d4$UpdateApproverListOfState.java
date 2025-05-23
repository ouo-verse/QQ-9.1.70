package tencent.im.oidb.cmd0x4d4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x4d4$UpdateApproverListOfState extends MessageMicro<oidb_0x4d4$UpdateApproverListOfState> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"bytes_workflow_id", "uint32_data_version", "rpt_msg_state_approver_change_list"}, new Object[]{ByteStringMicro.EMPTY, 0, null}, oidb_0x4d4$UpdateApproverListOfState.class);
    public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_data_version = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_0x4d4$ApproverChangeInState> rpt_msg_state_approver_change_list = PBField.initRepeatMessage(oidb_0x4d4$ApproverChangeInState.class);
}
