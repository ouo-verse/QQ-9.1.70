package xt1;

import android.text.TextUtils;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.data.MessageForFile;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes14.dex */
public class h implements com.tencent.imcore.message.decoder.j {
    @Override // com.tencent.imcore.message.decoder.j
    public void a(Message message, IMessageManager iMessageManager, AppRuntime appRuntime) throws Exception {
        String str;
        String trim;
        if (message.msgtype == -2005) {
            if (!TextUtils.isEmpty(message.f203106msg)) {
                MessageForFile messageForFile = new MessageForFile();
                messageForFile.f203106msg = message.f203106msg;
                messageForFile.doParse();
                str = messageForFile.fileName;
            } else {
                str = null;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(appRuntime.getApp().getString(R.string.f145800sg));
            if (TextUtils.isEmpty(str)) {
                trim = "";
            } else {
                trim = str.trim();
            }
            sb5.append(trim);
            message.f203106msg = sb5.toString();
        }
    }
}
