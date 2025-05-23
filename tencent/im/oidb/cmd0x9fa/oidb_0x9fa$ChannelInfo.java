package tencent.im.oidb.cmd0x9fa;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x9fa$ChannelInfo extends MessageMicro<oidb_0x9fa$ChannelInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint64_uin", "uint32_channel_status", "uint64_channel_optime"}, new Object[]{0L, 0, 0L}, oidb_0x9fa$ChannelInfo.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_channel_status = PBField.initUInt32(0);
    public final PBUInt64Field uint64_channel_optime = PBField.initUInt64(0);
}
