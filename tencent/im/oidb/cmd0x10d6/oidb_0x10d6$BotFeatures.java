package tencent.im.oidb.cmd0x10d6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x10d6$BotFeatures extends MessageMicro<oidb_0x10d6$BotFeatures> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"bot_info", "service_info", "command_info"}, new Object[]{null, null, null}, oidb_0x10d6$BotFeatures.class);
    public oidb_0x10d6$BotInfo bot_info = new oidb_0x10d6$BotInfo();
    public final PBRepeatMessageField<oidb_0x10d6$FeatureInfo> service_info = PBField.initRepeatMessage(oidb_0x10d6$FeatureInfo.class);
    public final PBRepeatMessageField<oidb_0x10d6$FeatureInfo> command_info = PBField.initRepeatMessage(oidb_0x10d6$FeatureInfo.class);
}
