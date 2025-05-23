package tencent.im.oidb.cmd0xafc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd$NearbyConfig;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd$SelfInfo;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xafc$RspBody extends MessageMicro<cmd0xafc$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_heart_beat_interval", "msg_self_info", "msg_config"}, new Object[]{0, null, null}, cmd0xafc$RspBody.class);
    public final PBUInt32Field uint32_heart_beat_interval = PBField.initUInt32(0);
    public oidb_0x8dd$SelfInfo msg_self_info = new oidb_0x8dd$SelfInfo();
    public oidb_0x8dd$NearbyConfig msg_config = new oidb_0x8dd$NearbyConfig();
}
