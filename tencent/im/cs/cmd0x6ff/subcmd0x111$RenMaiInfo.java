package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class subcmd0x111$RenMaiInfo extends MessageMicro<subcmd0x111$RenMaiInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 48}, new String[]{"uint32_sync_type", "uint32_next_start_time", "rpt_msg_group_info", "rpt_msg_frd", "rpt_uint64_del_frd", "uint32_next_interval"}, new Object[]{0, 0, null, null, 0L, 0}, subcmd0x111$RenMaiInfo.class);
    public final PBUInt32Field uint32_sync_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_next_start_time = PBField.initUInt32(0);
    public final PBRepeatMessageField<subcmd0x111$GroupInfo> rpt_msg_group_info = PBField.initRepeatMessage(subcmd0x111$GroupInfo.class);
    public final PBRepeatMessageField<subcmd0x111$OneRenMaiFrd> rpt_msg_frd = PBField.initRepeatMessage(subcmd0x111$OneRenMaiFrd.class);
    public final PBRepeatField<Long> rpt_uint64_del_frd = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_next_interval = PBField.initUInt32(0);
}
