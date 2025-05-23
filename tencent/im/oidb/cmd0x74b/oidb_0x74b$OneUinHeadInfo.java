package tencent.im.oidb.cmd0x74b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x74b$OneUinHeadInfo extends MessageMicro<oidb_0x74b$OneUinHeadInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 34, 88}, new String[]{"uint64_uin", "uint32_timestamp", "rpt_msg_head_list", "uint64_tinyid"}, new Object[]{0L, 0, null, 0L}, oidb_0x74b$OneUinHeadInfo.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_0x74b$HeadInfo> rpt_msg_head_list = PBField.initRepeatMessage(oidb_0x74b$HeadInfo.class);
    public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0);
}
