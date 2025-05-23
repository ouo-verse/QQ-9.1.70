package tencent.im.oidb.cmd0x6e5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x6e5$RspBody extends MessageMicro<oidb_cmd0x6e5$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 90, 96, 104}, new String[]{"uint64_uin", "rpt_interest_label_list", "rpt_uint32_default_interest_label_id_list", "rpt_uint64_last_interest_label_id_list"}, new Object[]{0L, null, 0, 0L}, oidb_cmd0x6e5$RspBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBRepeatMessageField<oidb_cmd0x6e5$InterestLabelInfo> rpt_interest_label_list = PBField.initRepeatMessage(oidb_cmd0x6e5$InterestLabelInfo.class);
    public final PBRepeatField<Integer> rpt_uint32_default_interest_label_id_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatField<Long> rpt_uint64_last_interest_label_id_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
