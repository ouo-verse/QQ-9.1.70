package tencent.im.oidb.cmd0x101d;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x101d$BatchBotGetRequest extends MessageMicro<oidb_0x101d$BatchBotGetRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42}, new String[]{"uins", WidgetCacheConstellationData.NUM, "guild_id", "channel_id", "client_info"}, new Object[]{0L, 0, 0L, 0L, null}, oidb_0x101d$BatchBotGetRequest.class);
    public final PBRepeatField<Long> uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field num = PBField.initUInt32(0);
    public final PBUInt64Field guild_id = PBField.initUInt64(0);
    public final PBUInt64Field channel_id = PBField.initUInt64(0);
    public oidb_0x101d$ClientInfo client_info = new oidb_0x101d$ClientInfo();
}
