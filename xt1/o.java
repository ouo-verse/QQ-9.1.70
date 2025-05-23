package xt1;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes14.dex */
public class o implements com.tencent.imcore.message.decoder.j {
    @Override // com.tencent.imcore.message.decoder.j
    public void a(Message message, IMessageManager iMessageManager, AppRuntime appRuntime) {
        if (message.msgtype == -1035) {
            ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).decodeMixTypeMsg(message, iMessageManager);
            String str = message.f203106msg;
            if (str != null && str.contains("[\u77ed\u89c6\u9891]")) {
                message.f203106msg = message.f203106msg.replace("[\u77ed\u89c6\u9891]", "[\u89c6\u9891]");
            }
        }
    }
}
