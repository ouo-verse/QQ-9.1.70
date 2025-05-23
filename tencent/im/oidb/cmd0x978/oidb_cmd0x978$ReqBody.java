package tencent.im.oidb.cmd0x978;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x978$ReqBody extends MessageMicro<oidb_cmd0x978$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 90, 96}, new String[]{"uint64_uin", "uint64_client_switch", "msg_req_follow_para", "uint32_refer"}, new Object[]{0L, 0L, null, 0}, oidb_cmd0x978$ReqBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_client_switch = PBField.initUInt64(0);
    public oidb_cmd0x978$ReqFollowOperationPara msg_req_follow_para = new MessageMicro<oidb_cmd0x978$ReqFollowOperationPara>() { // from class: tencent.im.oidb.cmd0x978.oidb_cmd0x978$ReqFollowOperationPara
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 90, 98, 104}, new String[]{"op_type", "bytes_cookie", "rpt_follow_operation_info", "uint32_force_use_op_type"}, new Object[]{1, ByteStringMicro.EMPTY, null, 0}, oidb_cmd0x978$ReqFollowOperationPara.class);
        public final PBEnumField op_type = PBField.initEnum(1);
        public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBRepeatMessageField<oidb_cmd0x978$OneFollowOperationInfo> rpt_follow_operation_info = PBField.initRepeatMessage(oidb_cmd0x978$OneFollowOperationInfo.class);
        public final PBUInt32Field uint32_force_use_op_type = PBField.initUInt32(0);
    };
    public final PBUInt32Field uint32_refer = PBField.initUInt32(0);
}
