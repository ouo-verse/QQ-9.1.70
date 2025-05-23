package xt1;

import android.text.TextUtils;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes14.dex */
public class y implements com.tencent.imcore.message.decoder.j {
    @Override // com.tencent.imcore.message.decoder.j
    public void a(Message message, IMessageManager iMessageManager, AppRuntime appRuntime) throws Exception {
        if (message.msgtype != -2025 || message.msgData == null) {
            return;
        }
        try {
            MessageForQQWalletMsg messageForQQWalletMsg = new MessageForQQWalletMsg();
            messageForQQWalletMsg.msgData = message.msgData;
            messageForQQWalletMsg.parse();
            message.f203106msg = b(appRuntime, messageForQQWalletMsg) + messageForQQWalletMsg.getMsgSummary();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("Q.msg.BaseMessageManager", 2, e16.toString());
            }
        }
    }

    String b(AppRuntime appRuntime, MessageForQQWalletMsg messageForQQWalletMsg) {
        if (((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isPersonalRedPacketMsg(messageForQQWalletMsg)) {
            if (c(appRuntime, messageForQQWalletMsg)) {
                return HardCodeUtil.qqStr(R.string.f1517818m);
            }
            return HardCodeUtil.qqStr(R.string.f1517218g);
        }
        if (((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isRedPacketMsg(messageForQQWalletMsg)) {
            return HardCodeUtil.qqStr(R.string.f146600um);
        }
        return "";
    }

    boolean c(AppRuntime appRuntime, MessageForQQWalletMsg messageForQQWalletMsg) {
        QQWalletRedPacketMsg qQWalletRedPacketMsg;
        List<Long> list;
        String selfTinyId = ((IGPSService) appRuntime.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
        if (!TextUtils.isEmpty(selfTinyId) && messageForQQWalletMsg != null && (qQWalletRedPacketMsg = messageForQQWalletMsg.mQQWalletRedPacketMsg) != null && (list = qQWalletRedPacketMsg.specifyUinList) != null) {
            Iterator<Long> it = list.iterator();
            while (it.hasNext()) {
                if (selfTinyId.equals(String.valueOf(it.next()))) {
                    return true;
                }
            }
        }
        return false;
    }
}
