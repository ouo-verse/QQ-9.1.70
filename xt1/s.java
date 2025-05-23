package xt1;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes14.dex */
public class s implements com.tencent.imcore.message.decoder.j {
    private boolean b(Message message) {
        int i3 = message.msgtype;
        if (i3 != -2002 && i3 != -1031) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.imcore.message.decoder.j
    public void a(Message message, IMessageManager iMessageManager, AppRuntime appRuntime) throws Exception {
        if (b(message)) {
            message.f203106msg = appRuntime.getApp().getString(R.string.f1522519w);
            try {
                MessageForPtt messageForPtt = (MessageForPtt) ((IMessageFacade) appRuntime.getRuntimeService(IMessageFacade.class, "")).getMsgItemByUniseq(message.frienduin, message.istroop, message.uniseq);
                if (messageForPtt != null) {
                    message.pttUrl = messageForPtt.url;
                    message.f203106msg = messageForPtt.getSummaryMsg();
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }
}
