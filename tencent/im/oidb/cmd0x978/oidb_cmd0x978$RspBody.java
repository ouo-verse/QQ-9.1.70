package tencent.im.oidb.cmd0x978;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x978$RspBody extends MessageMicro<oidb_cmd0x978$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 90}, new String[]{"uint64_uin", "msg_rsp_follow_op_result"}, new Object[]{0L, null}, oidb_cmd0x978$RspBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public oidb_cmd0x978$RspFollowOperationResult msg_rsp_follow_op_result = new MessageMicro<oidb_cmd0x978$RspFollowOperationResult>() { // from class: tencent.im.oidb.cmd0x978.oidb_cmd0x978$RspFollowOperationResult
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 90, 98}, new String[]{"op_type", "bytes_cookie", "rpt_follow_operation_result"}, new Object[]{1, ByteStringMicro.EMPTY, null}, oidb_cmd0x978$RspFollowOperationResult.class);
        public final PBEnumField op_type = PBField.initEnum(1);
        public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBRepeatMessageField<oidb_cmd0x978$OneFollowOperationResult> rpt_follow_operation_result = PBField.initRepeatMessage(oidb_cmd0x978$OneFollowOperationResult.class);
    };
}
