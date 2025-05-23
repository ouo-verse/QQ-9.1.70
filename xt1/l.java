package xt1;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.guild.temp.api.IGuildMarkdownApi;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes14.dex */
public class l implements com.tencent.imcore.message.decoder.j {
    @Override // com.tencent.imcore.message.decoder.j
    public void a(Message message, IMessageManager iMessageManager, AppRuntime appRuntime) throws Exception {
        if (message.msgtype == -4052 && message.f203106msg != null) {
            message.f203106msg = ((IGuildMarkdownApi) QRoute.api(IGuildMarkdownApi.class)).parse(message);
        }
    }
}
