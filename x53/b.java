package x53;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.wink.edit.manager.WinkDataBaseServiceHandler;
import com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes21.dex */
public class b extends MSFServlet {
    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        ToServiceMsg toServiceMsg;
        String name = WinkDataServiceHandler.class.getName();
        if (intent != null) {
            toServiceMsg = (ToServiceMsg) intent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
            if (!TextUtils.isEmpty(intent.getStringExtra("receive_handler"))) {
                name = intent.getStringExtra("receive_handler");
            }
            fromServiceMsg.attributes.put(FromServiceMsg.class.getSimpleName(), toServiceMsg);
        } else {
            toServiceMsg = new ToServiceMsg("", fromServiceMsg.getUin(), fromServiceMsg.getServiceCmd());
        }
        w53.b.a("WinkMsfServlet", "onReceive... handler:" + name);
        WinkDataBaseServiceHandler winkDataBaseServiceHandler = (WinkDataBaseServiceHandler) com.tencent.mobileqq.wink.b.a().getBusinessHandler(name);
        winkDataBaseServiceHandler.onReceive(toServiceMsg, fromServiceMsg, winkDataBaseServiceHandler.D2(toServiceMsg, fromServiceMsg));
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        if (intent != null) {
            ToServiceMsg toServiceMsg = (ToServiceMsg) intent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
            w53.b.a("WinkMsfServlet", " onSend runhw:" + toServiceMsg);
            if (toServiceMsg != null) {
                packet.setSSOCommand(toServiceMsg.getServiceCmd());
                packet.putSendData(toServiceMsg.getWupBuffer());
                packet.setTimeout(toServiceMsg.getTimeout());
                packet.setAttributes(toServiceMsg.getAttributes());
                if (!toServiceMsg.isNeedCallback()) {
                    packet.setNoResponse();
                }
            }
        }
    }
}
