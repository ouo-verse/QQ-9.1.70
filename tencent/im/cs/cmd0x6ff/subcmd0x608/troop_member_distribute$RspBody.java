package tencent.im.cs.cmd0x6ff.subcmd0x608;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class troop_member_distribute$RspBody extends MessageMicro<troop_member_distribute$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50}, new String[]{"uint32_result", "uint64_group_code", "uint32_group_max_member", "uint32_group_member", "rpt_msg_statistic", "msg_gender_number"}, new Object[]{0, 0L, 0, 0, null, null}, troop_member_distribute$RspBody.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt32Field uint32_group_max_member = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_member = PBField.initUInt32(0);
    public final PBRepeatMessageField<troop_member_distribute$OStatisticInfo> rpt_msg_statistic = PBField.initRepeatMessage(troop_member_distribute$OStatisticInfo.class);
    public troop_member_distribute$GenderNumber msg_gender_number = new MessageMicro<troop_member_distribute$GenderNumber>() { // from class: tencent.im.cs.cmd0x6ff.subcmd0x608.troop_member_distribute$GenderNumber
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_man_number", "uint32_woman_number", "uint32_unknow_number"}, new Object[]{0, 0, 0}, troop_member_distribute$GenderNumber.class);
        public final PBUInt32Field uint32_man_number = PBField.initUInt32(0);
        public final PBUInt32Field uint32_woman_number = PBField.initUInt32(0);
        public final PBUInt32Field uint32_unknow_number = PBField.initUInt32(0);
    };
}
