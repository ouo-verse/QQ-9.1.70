package xt1;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.guild.message.MessageRecordForBlackRobotGray;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes14.dex */
public class e implements com.tencent.imcore.message.decoder.j {
    @Override // com.tencent.imcore.message.decoder.j
    public void a(Message message, IMessageManager iMessageManager, AppRuntime appRuntime) throws Exception {
        if (message.msgtype == -4089) {
            MessageRecordForBlackRobotGray messageRecordForBlackRobotGray = new MessageRecordForBlackRobotGray();
            messageRecordForBlackRobotGray.msgData = message.msgData;
            messageRecordForBlackRobotGray.parse();
            message.f203106msg = messageRecordForBlackRobotGray.getSummaryMsg();
        }
    }
}
