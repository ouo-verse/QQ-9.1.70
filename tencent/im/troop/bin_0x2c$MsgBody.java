package tencent.im.troop;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class bin_0x2c$MsgBody extends MessageMicro<bin_0x2c$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"msgResetAdmin", "msgSetAdmin", "msgChangeOwner"}, new Object[]{null, null, null}, bin_0x2c$MsgBody.class);
    public bin_0x2c$ResetAdmin msgResetAdmin = new bin_0x2c$ResetAdmin();
    public bin_0x2c$SetAdmin msgSetAdmin = new bin_0x2c$SetAdmin();
    public bin_0x2c$ChangeOwner msgChangeOwner = new bin_0x2c$ChangeOwner();
}
