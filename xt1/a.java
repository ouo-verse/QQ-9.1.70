package xt1;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.data.MessageForAniSticker;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a implements com.tencent.imcore.message.decoder.j {
    @Override // com.tencent.imcore.message.decoder.j
    public void a(Message message, IMessageManager iMessageManager, AppRuntime appRuntime) throws Exception {
        byte[] bArr;
        if (message.msgtype == -8018 && (bArr = message.msgData) != null && bArr.length > 0) {
            MessageForAniSticker messageForAniSticker = new MessageForAniSticker();
            messageForAniSticker.deserializeMsgData(message.msgData);
            message.f203106msg = messageForAniSticker.getSummaryMsg();
        }
    }
}
