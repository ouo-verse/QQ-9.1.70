package tencent.im.label.comm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class PersonalityTagComm$UserLabel extends MessageMicro<PersonalityTagComm$UserLabel> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48, 56}, new String[]{"rpt_msg_label", "uint32_remain_quota", "uint32_max_photo_quota", "uint32_total_photo", "uint32_total_praise", "uint32_unread_praise", "uint64_last_prise_uin"}, new Object[]{null, 0, 0, 0, 0, 0, 0L}, PersonalityTagComm$UserLabel.class);
    public final PBRepeatMessageField<PersonalityTagComm$LabelInfo> rpt_msg_label = PBField.initRepeatMessage(PersonalityTagComm$LabelInfo.class);
    public final PBUInt32Field uint32_remain_quota = PBField.initUInt32(0);
    public final PBUInt32Field uint32_max_photo_quota = PBField.initUInt32(0);
    public final PBUInt32Field uint32_total_photo = PBField.initUInt32(0);
    public final PBUInt32Field uint32_total_praise = PBField.initUInt32(0);
    public final PBUInt32Field uint32_unread_praise = PBField.initUInt32(0);
    public final PBUInt64Field uint64_last_prise_uin = PBField.initUInt64(0);
}
