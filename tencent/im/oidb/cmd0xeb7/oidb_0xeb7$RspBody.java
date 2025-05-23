package tencent.im.oidb.cmd0xeb7;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xeb7$RspBody extends MessageMicro<oidb_0xeb7$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"signInStatusRsp", "signInWriteRsp"}, new Object[]{null, null}, oidb_0xeb7$RspBody.class);
    public oidb_0xeb7$StSignInStatusRsp signInStatusRsp = new oidb_0xeb7$StSignInStatusRsp();
    public oidb_0xeb7$StSignInWriteRsp signInWriteRsp = new oidb_0xeb7$StSignInWriteRsp();
}
