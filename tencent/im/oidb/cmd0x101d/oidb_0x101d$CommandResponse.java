package tencent.im.oidb.cmd0x101d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x101d$CommandResponse extends MessageMicro<oidb_0x101d$CommandResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"commands", "bot_info"}, new Object[]{null, null}, oidb_0x101d$CommandResponse.class);
    public final PBRepeatMessageField<oidb_0x101d$FeatureInfo> commands = PBField.initRepeatMessage(oidb_0x101d$FeatureInfo.class);
    public oidb_0x101d$BotInfo bot_info = new oidb_0x101d$BotInfo();
}
