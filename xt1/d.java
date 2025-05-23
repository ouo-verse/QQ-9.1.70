package xt1;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes14.dex */
public class d implements com.tencent.imcore.message.decoder.j {
    @Override // com.tencent.imcore.message.decoder.j
    public void a(Message message, IMessageManager iMessageManager, AppRuntime appRuntime) throws Exception {
        int i3 = message.msgtype;
        if (i3 == -5008 || i3 == -5017) {
            ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).getArkMsgSummary(message);
        }
    }
}
