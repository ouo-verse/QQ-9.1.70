package tencent.im.oidb.cmd0x5e0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class Oidb_0x5e0$ProfileInfo extends MessageMicro<Oidb_0x5e0$ProfileInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint64_uin", "rpt_msg_profile_info"}, new Object[]{0L, null}, Oidb_0x5e0$ProfileInfo.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBRepeatMessageField<Oidb_0x5e0$ProfileTvInfo> rpt_msg_profile_info = PBField.initRepeatMessage(Oidb_0x5e0$ProfileTvInfo.class);
}
