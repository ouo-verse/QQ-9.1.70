package qu3;

import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qqnt.aio.msg.api.IAIOMsgItemApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import qu3.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J$\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\u000f"}, d2 = {"Lqu3/n;", "Lqu3/d;", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/mobileqq/data/ChatMessage;", "c", "", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "b", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class n implements d {
    private final boolean d() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("only_text_msg_record_coverter_116275374", true);
    }

    @Override // qu3.d
    public ChatMessage a(AppRuntime appRuntime, MsgRecord msgRecord, MsgElement msgElement) {
        return d.a.a(this, appRuntime, msgRecord, msgElement);
    }

    @Override // qu3.d
    public ChatMessage b(AppRuntime app, MsgRecord msgRecord, MsgElement msgElement) {
        List filterNotNull;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("fav_9030_116882957", true)) {
            return c(app, msgRecord);
        }
        MessageRecord d16 = com.tencent.mobileqq.service.message.q.d(MessageRecord.MSG_TYPE_REPLY_TEXT);
        MessageForReplyText messageForReplyText = d16 instanceof MessageForReplyText ? (MessageForReplyText) d16 : null;
        if (messageForReplyText == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<MsgElement> elements = msgRecord.elements;
        if (elements != null) {
            Intrinsics.checkNotNullExpressionValue(elements, "elements");
            filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(elements);
            if (filterNotNull != null) {
                Iterator it = filterNotNull.iterator();
                while (it.hasNext()) {
                    arrayList.add((MsgElement) it.next());
                }
            }
        }
        if (!arrayList.isEmpty()) {
            CharSequence buildContent = ((IAIOMsgItemApi) QRoute.api(IAIOMsgItemApi.class)).buildContent(arrayList);
            messageForReplyText.charStr = buildContent.toString();
            messageForReplyText.f203106msg = buildContent.toString();
        }
        return messageForReplyText;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002a, code lost:
    
        if (r8.elements.size() > 1) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ChatMessage c(AppRuntime app, MsgRecord msgRecord) {
        MessageRecord d16 = com.tencent.mobileqq.service.message.q.d(MessageRecord.MSG_TYPE_MIX);
        MessageForMixedMsg messageForMixedMsg = d16 instanceof MessageForMixedMsg ? (MessageForMixedMsg) d16 : null;
        if (messageForMixedMsg == null) {
            return null;
        }
        messageForMixedMsg.msgElemList = new ArrayList();
        if (msgRecord.elements != null) {
            boolean z16 = d();
            Iterator<MsgElement> it = msgRecord.elements.iterator();
            while (it.hasNext()) {
                MsgElement next = it.next();
                if (next.textElement == null && next.faceElement == null) {
                    if (next.videoElement != null) {
                        messageForMixedMsg.msgElemList.add(new p().a(app, msgRecord, next));
                    } else if (next.picElement != null) {
                        messageForMixedMsg.msgElemList.add(new l().a(app, msgRecord, next));
                    }
                } else if (z16) {
                    messageForMixedMsg.msgElemList.add(new k().a(app, msgRecord, next));
                } else {
                    messageForMixedMsg.msgElemList.add(new o().a(app, msgRecord, next));
                }
            }
        }
        return messageForMixedMsg;
    }
}
