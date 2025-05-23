package xt1;

import ActionMsg.MsgBody;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.message.IMessageManager;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes14.dex */
public class p implements com.tencent.imcore.message.decoder.j {
    @Override // com.tencent.imcore.message.decoder.j
    public void a(Message message, IMessageManager iMessageManager, AppRuntime appRuntime) throws Exception {
        int i3;
        if (com.tencent.mobileqq.utils.c.h(message.msgtype) || (i3 = message.msgtype) == -3001 || i3 == -30002 || i3 == -30003) {
            try {
                MsgBody a16 = com.tencent.mobileqq.utils.c.a(message.f203106msg);
                message.f203106msg = a16.f24895msg;
                message.action = a16.action;
                message.shareAppID = a16.shareAppID;
                message.actMsgContentValue = a16.actMsgContentValue;
            } catch (Exception e16) {
                throw e16;
            }
        }
    }
}
