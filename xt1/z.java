package xt1;

import android.text.TextUtils;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.guild.message.MessageRecordForGuildWelcome;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes14.dex */
public class z implements com.tencent.imcore.message.decoder.j {
    @Override // com.tencent.imcore.message.decoder.j
    public void a(Message message, IMessageManager iMessageManager, AppRuntime appRuntime) throws Exception {
        if (message.msgtype == -4028) {
            MessageRecordForGuildWelcome messageRecordForGuildWelcome = new MessageRecordForGuildWelcome();
            messageRecordForGuildWelcome.msgData = message.msgData;
            messageRecordForGuildWelcome.parse();
            String valueOf = String.valueOf(messageRecordForGuildWelcome.getTitle(appRuntime));
            if (TextUtils.isEmpty(valueOf)) {
                message.f203106msg = messageRecordForGuildWelcome.f203106msg;
            } else {
                message.f203106msg = valueOf;
            }
        }
    }
}
