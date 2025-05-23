package tencent.im.oidb.cmd0xfc2;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xfc2$ChannelInfo extends MessageMicro<oidb_0xfc2$ChannelInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{24, 32}, new String[]{"uint64_guild_id", "uint64_channel_id"}, new Object[]{0L, 0L}, oidb_0xfc2$ChannelInfo.class);
    public final PBUInt64Field uint64_guild_id = PBField.initUInt64(0);
    public final PBUInt64Field uint64_channel_id = PBField.initUInt64(0);
}
