package tencent.im.oidb.cmd0x406;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x406$RspBody extends MessageMicro<cmd0x406$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"uint32_ret", "string_msg", "msg_group_fee_info", "msg_group_fee_list", "msg_member_list"}, new Object[]{0, "", null, null, null}, cmd0x406$RspBody.class);
    public final PBUInt32Field uint32_ret = PBField.initUInt32(0);
    public final PBStringField string_msg = PBField.initString("");
    public cmd0x406$GroupFeeInfoResult msg_group_fee_info = new MessageMicro<cmd0x406$GroupFeeInfoResult>() { // from class: tencent.im.oidb.cmd0x406.cmd0x406$GroupFeeInfoResult
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_group_fee_type", "msg_group_fee"}, new Object[]{0, null}, cmd0x406$GroupFeeInfoResult.class);
        public final PBUInt32Field uint32_group_fee_type = PBField.initUInt32(0);
        public cmd0x406$GroupFee msg_group_fee = new cmd0x406$GroupFee();
    };
    public cmd0x406$GroupFeeListResult msg_group_fee_list = new MessageMicro<cmd0x406$GroupFeeListResult>() { // from class: tencent.im.oidb.cmd0x406.cmd0x406$GroupFeeListResult
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_group_fee_type", "msg_group_fee_list"}, new Object[]{0, null}, cmd0x406$GroupFeeListResult.class);
        public final PBUInt32Field uint32_group_fee_type = PBField.initUInt32(0);
        public final PBRepeatMessageField<cmd0x406$GroupFee> msg_group_fee_list = PBField.initRepeatMessage(cmd0x406$GroupFee.class);
    };
    public cmd0x406$GroupFeeMemberListResult msg_member_list = new cmd0x406$GroupFeeMemberListResult();
}
