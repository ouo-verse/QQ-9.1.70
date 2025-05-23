package tencent.im.oidb.cmd0x101d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x101d$BotFeatures extends MessageMicro<oidb_0x101d$BotFeatures> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bot_info", "feature_info"}, new Object[]{null, null}, oidb_0x101d$BotFeatures.class);
    public oidb_0x101d$BotInfo bot_info = new oidb_0x101d$BotInfo();
    public final PBRepeatMessageField<oidb_0x101d$FeatureInfo> feature_info = PBField.initRepeatMessage(oidb_0x101d$FeatureInfo.class);
}
