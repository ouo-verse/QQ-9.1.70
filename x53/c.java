package x53;

import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.wink.edit.manager.WinkDataBaseServiceHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes21.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static String f447253a = "WinkSendService";

    /* renamed from: b, reason: collision with root package name */
    public static volatile int f447254b;

    public static void a(ToServiceMsg toServiceMsg, String str, Class<? extends MSFServlet> cls) {
        String serviceCmd = toServiceMsg.getServiceCmd();
        boolean z16 = true;
        UniPacket uniPacket = new UniPacket(true);
        uniPacket.setEncodeName("utf-8");
        int i3 = f447254b;
        f447254b = i3 + 1;
        uniPacket.setRequestId(i3);
        WinkDataBaseServiceHandler winkDataBaseServiceHandler = (WinkDataBaseServiceHandler) com.tencent.mobileqq.wink.b.a().getBusinessHandler(str);
        if (winkDataBaseServiceHandler != null && winkDataBaseServiceHandler.F2(toServiceMsg, uniPacket)) {
            toServiceMsg.putWupBuffer(uniPacket.encode());
        } else {
            z16 = false;
        }
        if (z16) {
            NewIntent newIntent = new NewIntent(com.tencent.mobileqq.wink.b.c(), cls);
            newIntent.putExtra(ToServiceMsg.class.getSimpleName(), toServiceMsg);
            newIntent.putExtra("receive_handler", str);
            com.tencent.mobileqq.wink.b.a().startServlet(newIntent);
            toServiceMsg.extraData.putLong("sendtimekey", System.currentTimeMillis());
            return;
        }
        FromServiceMsg fromServiceMsg = new FromServiceMsg(com.tencent.mobileqq.wink.b.b().getCurrentAccountUin(), serviceCmd);
        if (winkDataBaseServiceHandler != null) {
            try {
                winkDataBaseServiceHandler.onReceive(toServiceMsg, fromServiceMsg, null);
            } catch (Exception e16) {
                e16.printStackTrace();
                w53.b.d(f447253a, winkDataBaseServiceHandler.getClass().getSimpleName() + " onReceive error,", e16);
            }
        }
    }
}
