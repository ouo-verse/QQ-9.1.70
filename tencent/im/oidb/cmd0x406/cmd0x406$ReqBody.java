package tencent.im.oidb.cmd0x406;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x406$ReqBody extends MessageMicro<cmd0x406$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"uint64_group_id", "msg_group_fee_info", "msg_group_fee_list", "msg_member_list"}, new Object[]{0L, null, null, null}, cmd0x406$ReqBody.class);
    public final PBUInt64Field uint64_group_id = PBField.initUInt64(0);
    public cmd0x406$GroupFeeInfoQuery msg_group_fee_info = new MessageMicro<cmd0x406$GroupFeeInfoQuery>() { // from class: tencent.im.oidb.cmd0x406.cmd0x406$GroupFeeInfoQuery
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"string_project_id", "uint32_group_fee_type", "msg_group_fee_opt"}, new Object[]{"", 0, null}, cmd0x406$GroupFeeInfoQuery.class);
        public final PBStringField string_project_id = PBField.initString("");
        public final PBUInt32Field uint32_group_fee_type = PBField.initUInt32(0);
        public cmd0x406$GroupFee msg_group_fee_opt = new cmd0x406$GroupFee();
    };
    public cmd0x406$GroupFeeListQuery msg_group_fee_list = new MessageMicro<cmd0x406$GroupFeeListQuery>() { // from class: tencent.im.oidb.cmd0x406.cmd0x406$GroupFeeListQuery
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_group_fee_type", "msg_group_fee_opt"}, new Object[]{0, null}, cmd0x406$GroupFeeListQuery.class);
        public final PBUInt32Field uint32_group_fee_type = PBField.initUInt32(0);
        public cmd0x406$GroupFee msg_group_fee_opt = new cmd0x406$GroupFee();
    };
    public cmd0x406$GroupFeeMemberListQuery msg_member_list = new cmd0x406$GroupFeeMemberListQuery();
}
