package tencent.im.oidb.cmd0x10d6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x10d6$CommandResponse extends MessageMicro<oidb_0x10d6$CommandResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"commands", "bot_info"}, new Object[]{null, null}, oidb_0x10d6$CommandResponse.class);
    public final PBRepeatMessageField<oidb_0x10d6$FeatureInfo> commands = PBField.initRepeatMessage(oidb_0x10d6$FeatureInfo.class);
    public oidb_0x10d6$BotInfo bot_info = new oidb_0x10d6$BotInfo();
}
