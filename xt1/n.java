package xt1;

import android.text.TextUtils;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes14.dex */
public class n implements com.tencent.imcore.message.decoder.j {
    @Override // com.tencent.imcore.message.decoder.j
    public void a(Message message, IMessageManager iMessageManager, AppRuntime appRuntime) throws Exception {
        MarkFaceMessage markFaceMessage;
        if (message.msgtype == -2007) {
            try {
                markFaceMessage = (MarkFaceMessage) MessagePkgUtils.getObjectFromBytes(message.msgData);
            } catch (Exception e16) {
                QLog.e("Q.msg.BaseMessageManager", 1, "parse MarkFaceMessage: ", e16);
                markFaceMessage = null;
            }
            if (markFaceMessage != null && !TextUtils.isEmpty(markFaceMessage.faceName)) {
                message.f203106msg = "[" + markFaceMessage.faceName + "]";
                return;
            }
            message.f203106msg = appRuntime.getApp().getString(R.string.f143500m9);
        }
    }
}
