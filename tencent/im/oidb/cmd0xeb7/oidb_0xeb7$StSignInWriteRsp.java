package tencent.im.oidb.cmd0xeb7;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xeb7$StSignInWriteRsp extends MessageMicro<oidb_0xeb7$StSignInWriteRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"ret", "doneInfo", "groupScore"}, new Object[]{null, null, null}, oidb_0xeb7$StSignInWriteRsp.class);
    public oidb_0xeb7$Ret ret = new oidb_0xeb7$Ret();
    public oidb_0xeb7$SignInStatusDoneInfo doneInfo = new oidb_0xeb7$SignInStatusDoneInfo();
    public oidb_0xeb7$SignInStatusGroupScore groupScore = new oidb_0xeb7$SignInStatusGroupScore();
}
