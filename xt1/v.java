package xt1;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.guild.message.GuildSubscribeChannelGray;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes14.dex */
public class v implements com.tencent.imcore.message.decoder.j {
    @Override // com.tencent.imcore.message.decoder.j
    public void a(Message message, IMessageManager iMessageManager, AppRuntime appRuntime) throws Exception {
        if (message.msgtype == -4091) {
            GuildSubscribeChannelGray guildSubscribeChannelGray = new GuildSubscribeChannelGray();
            guildSubscribeChannelGray.msgData = message.msgData;
            guildSubscribeChannelGray.parse();
            message.f203106msg = guildSubscribeChannelGray.getSummaryMsg();
        }
    }
}
