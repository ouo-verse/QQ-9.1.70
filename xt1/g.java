package xt1;

import android.text.TextUtils;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.guild.message.MessageRecordForDirectMessageWelcome;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes14.dex */
public class g implements com.tencent.imcore.message.decoder.j {
    @Override // com.tencent.imcore.message.decoder.j
    public void a(Message message, IMessageManager iMessageManager, AppRuntime appRuntime) throws Exception {
        if (message.msgtype == -4090) {
            MessageRecordForDirectMessageWelcome messageRecordForDirectMessageWelcome = new MessageRecordForDirectMessageWelcome();
            messageRecordForDirectMessageWelcome.msgData = message.msgData;
            messageRecordForDirectMessageWelcome.parse();
            String valueOf = String.valueOf(messageRecordForDirectMessageWelcome.getTips(appRuntime));
            if (TextUtils.isEmpty(valueOf)) {
                message.f203106msg = messageRecordForDirectMessageWelcome.f203106msg;
            } else {
                message.f203106msg = valueOf;
            }
        }
    }
}
