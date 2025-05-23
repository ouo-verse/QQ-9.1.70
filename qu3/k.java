package qu3;

import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.aio.msg.api.IAIOMsgItemApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import qu3.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ$\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lqu3/k;", "Lqu3/d;", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "Lcom/tencent/mobileqq/data/ChatMessage;", "b", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class k implements d {
    @Override // qu3.d
    public ChatMessage a(AppRuntime appRuntime, MsgRecord msgRecord, MsgElement msgElement) {
        return d.a.a(this, appRuntime, msgRecord, msgElement);
    }

    @Override // qu3.d
    public ChatMessage b(AppRuntime app, MsgRecord msgRecord, MsgElement msgElement) {
        List<MsgElement> tempList;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        MessageRecord d16 = com.tencent.mobileqq.service.message.q.d(-1000);
        ChatMessage chatMessage = d16 instanceof ChatMessage ? (ChatMessage) d16 : null;
        if (chatMessage == null) {
            return null;
        }
        if (msgElement != null) {
            tempList = CollectionsKt__CollectionsJVMKt.listOf(msgElement);
        } else {
            tempList = Collections.emptyList();
        }
        Intrinsics.checkNotNullExpressionValue(tempList, "tempList");
        if (!tempList.isEmpty()) {
            chatMessage.f203106msg = ((IAIOMsgItemApi) QRoute.api(IAIOMsgItemApi.class)).buildContent(tempList).toString();
        }
        return chatMessage;
    }
}
