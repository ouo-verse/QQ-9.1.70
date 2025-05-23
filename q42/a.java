package q42;

import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import t42.d;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a extends MSFServlet {
    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        ToServiceMsg toServiceMsg;
        if (intent != null) {
            toServiceMsg = (ToServiceMsg) intent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
            fromServiceMsg.attributes.put(FromServiceMsg.class.getSimpleName(), toServiceMsg);
        } else {
            toServiceMsg = new ToServiceMsg("", fromServiceMsg.getUin(), fromServiceMsg.getServiceCmd());
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("ICGameSdkServlet", 4, "onReceive, cmd[" + fromServiceMsg.getServiceCmd() + "]");
        }
        AppInterface a16 = d.a();
        if (a16 != null && toServiceMsg != null) {
            a16.receiveToService(toServiceMsg, fromServiceMsg);
        } else {
            QLog.e("ICGameSdkServlet", 1, "[onReceive] appInterface is null!");
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        if (intent != null) {
            ToServiceMsg toServiceMsg = (ToServiceMsg) intent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
            if (toServiceMsg != null) {
                packet.setSSOCommand(toServiceMsg.getServiceCmd());
                packet.putSendData(toServiceMsg.getWupBuffer());
                packet.setTimeout(toServiceMsg.getTimeout());
                packet.setAttributes(toServiceMsg.getAttributes());
                if (QLog.isDevelopLevel()) {
                    QLog.i("ICGameSdkServlet", 4, "send, cmd[" + toServiceMsg.getServiceCmd() + "]");
                    return;
                }
                return;
            }
            QLog.e("ICGameSdkServlet", 1, "[onSend] toMsg is null");
            return;
        }
        QLog.e("ICGameSdkServlet", 1, "[onSend] request is null");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.MSFServlet
    public void sendToMSF(Intent intent, ToServiceMsg toServiceMsg) {
        if (toServiceMsg != null) {
            toServiceMsg.addAttribute(MobileQQServiceBase.REQ_PB_PROTOCOL_FLAG, Boolean.TRUE);
            toServiceMsg.extraData.putString("moduleId", d.c());
        }
        super.sendToMSF(intent, toServiceMsg);
    }
}
