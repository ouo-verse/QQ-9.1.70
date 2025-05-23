package tencent.im.label.comm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class PersonalityTagComm$LabelDuplicate extends MessageMicro<PersonalityTagComm$LabelDuplicate> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_is_ori_label", "uint64_ori_label_id", "rpt_uint64_all_id"}, new Object[]{0, 0L, 0L}, PersonalityTagComm$LabelDuplicate.class);
    public final PBUInt32Field uint32_is_ori_label = PBField.initUInt32(0);
    public final PBUInt64Field uint64_ori_label_id = PBField.initUInt64(0);
    public final PBRepeatField<Long> rpt_uint64_all_id = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
