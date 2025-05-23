package xt1;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.message.api.IGuildNicknameApi;
import com.tencent.mobileqq.guild.message.msgtype.MessageForGuildRevokeGrayTip;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes14.dex */
public class t implements com.tencent.imcore.message.decoder.j {
    private boolean b(Message message, AppRuntime appRuntime) {
        if (!ch.u0(appRuntime, message.frienduin) && !ch.h0(message.frienduin)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.imcore.message.decoder.j
    public void a(Message message, IMessageManager iMessageManager, AppRuntime appRuntime) throws Exception {
        if (message.msgtype == -4050) {
            MessageForGuildRevokeGrayTip messageForGuildRevokeGrayTip = new MessageForGuildRevokeGrayTip();
            messageForGuildRevokeGrayTip.msgData = message.msgData;
            messageForGuildRevokeGrayTip.parse();
            IGuildNicknameApi iGuildNicknameApi = (IGuildNicknameApi) QRoute.api(IGuildNicknameApi.class);
            boolean needUpdateNick = messageForGuildRevokeGrayTip.getNeedUpdateNick();
            if (needUpdateNick && messageForGuildRevokeGrayTip.getOperatorTid().equals(messageForGuildRevokeGrayTip.getRevokeSenderUin())) {
                message.f203106msg = iGuildNicknameApi.getDisplayName(appRuntime, String.valueOf(((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).getGuildIdFromMR(message)), messageForGuildRevokeGrayTip.getOperatorTid(), messageForGuildRevokeGrayTip) + " " + messageForGuildRevokeGrayTip.getWording();
                message.saveExtInfoToExtStr("RevokeGrayTipOperatorTid", messageForGuildRevokeGrayTip.getOperatorTid());
                return;
            }
            if (needUpdateNick && b(message, appRuntime)) {
                message.f203106msg = ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).getAdminRevokeWord(appRuntime, messageForGuildRevokeGrayTip, su1.c.b(message));
                message.saveExtInfoToExtStr("RevokeGrayTipOperatorTid", messageForGuildRevokeGrayTip.getOperatorTid());
            } else {
                message.f203106msg = messageForGuildRevokeGrayTip.getWording();
                message.saveExtInfoToExtStr("RevokeGrayTipOperatorTid", "");
            }
        }
    }
}
