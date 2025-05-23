package tencent.im.oidb.cmd0x101d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x101d$Request extends MessageMicro<oidb_0x101d$Request> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42}, new String[]{"guild_id", "channel_id", "filter", "uins", "client_info"}, new Object[]{0L, 0L, 0, 0L, null}, oidb_0x101d$Request.class);
    public final PBUInt64Field guild_id = PBField.initUInt64(0);
    public final PBUInt64Field channel_id = PBField.initUInt64(0);
    public final PBInt32Field filter = PBField.initInt32(0);
    public final PBRepeatField<Long> uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public oidb_0x101d$ClientInfo client_info = new oidb_0x101d$ClientInfo();
}
