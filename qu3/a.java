package qu3;

import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import qu3.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J$\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\u0010"}, d2 = {"Lqu3/a;", "Lqu3/d;", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/mobileqq/data/MessageForArkApp;", "mr", "", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "Lcom/tencent/mobileqq/data/ChatMessage;", "b", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a implements d {
    private final void c(AppRuntime app, MsgRecord msgRecord, MessageForArkApp mr5) {
        mr5.ark_app_message = new ArkAppMessage();
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        if (arrayList.size() > 0) {
            MsgElement msgElement = arrayList.get(0);
            if (msgElement.elementType == 10) {
                mr5.ark_app_message.fromAppXml(msgElement.arkElement.bytesData);
            }
        }
    }

    @Override // qu3.d
    public ChatMessage a(AppRuntime appRuntime, MsgRecord msgRecord, MsgElement msgElement) {
        return d.a.a(this, appRuntime, msgRecord, msgElement);
    }

    @Override // qu3.d
    public ChatMessage b(AppRuntime app, MsgRecord msgRecord, MsgElement msgElement) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        if (msgElement == null && i.f429570a.b(msgRecord) == null) {
            return null;
        }
        MessageRecord d16 = com.tencent.mobileqq.service.message.q.d(MessageRecord.MSG_TYPE_ARK_APP);
        MessageForArkApp messageForArkApp = d16 instanceof MessageForArkApp ? (MessageForArkApp) d16 : null;
        if (messageForArkApp == null) {
            return null;
        }
        c(app, msgRecord, messageForArkApp);
        return messageForArkApp;
    }
}
