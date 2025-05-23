package tencent.im.oidb.cmd0xeb7;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xeb7$ReqBody extends MessageMicro<oidb_0xeb7$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"signInStatusReq", "signInWriteReq"}, new Object[]{null, null}, oidb_0xeb7$ReqBody.class);
    public oidb_0xeb7$StSignInStatusReq signInStatusReq = new oidb_0xeb7$StSignInStatusReq();
    public oidb_0xeb7$StSignInWriteReq signInWriteReq = new oidb_0xeb7$StSignInWriteReq();
}
