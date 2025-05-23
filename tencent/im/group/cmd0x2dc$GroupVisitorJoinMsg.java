package tencent.im.group;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x2dc$GroupVisitorJoinMsg extends MessageMicro<cmd0x2dc$GroupVisitorJoinMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"uint64_group_uin", "uint64_group_code", "rpt_msg_visitor_join_info", "uint32_op_flag"}, new Object[]{0L, 0L, null, 0}, cmd0x2dc$GroupVisitorJoinMsg.class);
    public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBRepeatMessageField<cmd0x2dc$VisitorJoinInfo> rpt_msg_visitor_join_info = PBField.initRepeatMessage(cmd0x2dc$VisitorJoinInfo.class);
    public final PBUInt32Field uint32_op_flag = PBField.initUInt32(0);
}
