package qu3;

import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.WalletAio;
import com.tencent.qqnt.kernel.nativeinterface.WalletElement;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import qu3.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ$\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lqu3/q;", "Lqu3/d;", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "Lcom/tencent/mobileqq/data/ChatMessage;", "b", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class q implements d {
    @Override // qu3.d
    public ChatMessage a(AppRuntime appRuntime, MsgRecord msgRecord, MsgElement msgElement) {
        return d.a.a(this, appRuntime, msgRecord, msgElement);
    }

    @Override // qu3.d
    public ChatMessage b(AppRuntime app, MsgRecord msgRecord, MsgElement msgElement) {
        Object obj;
        WalletElement walletElement;
        WalletAio walletAio;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        MessageRecord d16 = com.tencent.mobileqq.service.message.q.d(-1000);
        String str = null;
        ChatMessage chatMessage = d16 instanceof ChatMessage ? (ChatMessage) d16 : null;
        if (chatMessage == null) {
            return null;
        }
        if (msgElement == null || (walletElement = msgElement.walletElement) == null) {
            ArrayList<MsgElement> arrayList = msgRecord.elements;
            Intrinsics.checkNotNullExpressionValue(arrayList, "msgRecord.elements");
            Iterator<T> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((MsgElement) obj).walletElement != null) {
                    break;
                }
            }
            MsgElement msgElement2 = (MsgElement) obj;
            walletElement = msgElement2 != null ? msgElement2.walletElement : null;
        }
        if (walletElement != null && (walletAio = walletElement.receiver) != null) {
            str = walletAio.notice;
        }
        if (str == null) {
            str = "";
        }
        chatMessage.f203106msg = str;
        return chatMessage;
    }
}
