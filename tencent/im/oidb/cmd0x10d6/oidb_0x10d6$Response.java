package tencent.im.oidb.cmd0x10d6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x10d6$Response extends MessageMicro<oidb_0x10d6$Response> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"services"}, new Object[]{null}, oidb_0x10d6$Response.class);
    public final PBRepeatMessageField<oidb_0x10d6$BotService> services = PBField.initRepeatMessage(oidb_0x10d6$BotService.class);
}
