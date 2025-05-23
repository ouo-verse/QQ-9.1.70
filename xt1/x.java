package xt1;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.message.IMessageManager;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes14.dex */
public class x implements com.tencent.imcore.message.decoder.j {
    @Override // com.tencent.imcore.message.decoder.j
    public void a(Message message, IMessageManager iMessageManager, AppRuntime appRuntime) throws Exception {
        if (message.msgtype == -2022) {
            message.f203106msg = appRuntime.getApp().getString(R.string.f158171ow);
        }
    }
}
