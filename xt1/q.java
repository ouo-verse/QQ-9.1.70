package xt1;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.guild.message.GuildMsgNotifySettingGray;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes14.dex */
public class q implements com.tencent.imcore.message.decoder.j {
    @Override // com.tencent.imcore.message.decoder.j
    public void a(Message message, IMessageManager iMessageManager, AppRuntime appRuntime) throws Exception {
        if (message.msgtype == -4092) {
            GuildMsgNotifySettingGray guildMsgNotifySettingGray = new GuildMsgNotifySettingGray();
            guildMsgNotifySettingGray.msgData = message.msgData;
            guildMsgNotifySettingGray.parse();
            message.f203106msg = guildMsgNotifySettingGray.getSummaryMsg();
        }
    }
}
