package tencent.im.oidb.cmd0xe09;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xe09$OnlineInfo extends MessageMicro<oidb_0xe09$OnlineInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint64_friend_uin", "uint32_status", "uint32_ext_online_status", "uint64_act_time"}, new Object[]{0L, 0, 0, 0L}, oidb_0xe09$OnlineInfo.class);
    public final PBUInt64Field uint64_friend_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_status = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ext_online_status = PBField.initUInt32(0);
    public final PBUInt64Field uint64_act_time = PBField.initUInt64(0);
}
