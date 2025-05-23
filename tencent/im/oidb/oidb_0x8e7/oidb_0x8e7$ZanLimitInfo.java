package tencent.im.oidb.oidb_0x8e7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8e7$ZanLimitInfo extends MessageMicro<oidb_0x8e7$ZanLimitInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50}, new String[]{"uint64_level", "uint64_can_free_zan_user_limit", "uint64_free_zan_user", "uint64_free_zan_total_limit", "uint64_price", "rpt_msg_user_zan_info"}, new Object[]{0L, 0L, 0L, 0L, 0L, null}, oidb_0x8e7$ZanLimitInfo.class);
    public final PBUInt64Field uint64_level = PBField.initUInt64(0);
    public final PBUInt64Field uint64_can_free_zan_user_limit = PBField.initUInt64(0);
    public final PBUInt64Field uint64_free_zan_user = PBField.initUInt64(0);
    public final PBUInt64Field uint64_free_zan_total_limit = PBField.initUInt64(0);
    public final PBUInt64Field uint64_price = PBField.initUInt64(0);
    public final PBRepeatMessageField<oidb_0x8e7$UserZanInfo> rpt_msg_user_zan_info = PBField.initRepeatMessage(oidb_0x8e7$UserZanInfo.class);
}
