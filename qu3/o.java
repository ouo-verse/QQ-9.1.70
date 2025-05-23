package qu3;

import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.aio.msg.api.IAIOMsgItemApi;
import com.tencent.qqnt.kernel.nativeinterface.FaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import qu3.d;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u0010\u001a\u00020\u0002\"\b\b\u0000\u0010\u000e*\u00020\n*\b\u0012\u0004\u0012\u00028\u00000\u000fJ\u001a\u0010\u0011\u001a\u00020\u0004\"\b\b\u0000\u0010\u000e*\u00020\n*\b\u0012\u0004\u0012\u00028\u00000\u000f\u00a8\u0006\u0014"}, d2 = {"Lqu3/o;", "Lqu3/d;", "", "emoServerId", "", "d", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "Lcom/tencent/mobileqq/data/ChatMessage;", "b", "T", "", "c", "e", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class o implements d {
    private final boolean d(int emoServerId) {
        return QQSysFaceUtil.isBigStickerById(QQSysFaceUtil.convertToLocal(emoServerId));
    }

    @Override // qu3.d
    public ChatMessage a(AppRuntime appRuntime, MsgRecord msgRecord, MsgElement msgElement) {
        return d.a.a(this, appRuntime, msgRecord, msgElement);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0037  */
    @Override // qu3.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ChatMessage b(AppRuntime app, MsgRecord msgRecord, MsgElement msgElement) {
        boolean z16;
        MsgElement msgElement2;
        List<MsgElement> list;
        List filterNotNull;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        if (msgElement == null || msgElement.faceElement == null) {
            ArrayList<MsgElement> arrayList = msgRecord.elements;
            if (arrayList == null) {
                return null;
            }
            z16 = false;
            if (!e(arrayList) || !d(c(arrayList))) {
                msgElement2 = null;
                if (!z16) {
                    return new e().a(app, msgRecord, msgElement2);
                }
                MessageRecord d16 = com.tencent.mobileqq.service.message.q.d(-1000);
                MessageForText messageForText = d16 instanceof MessageForText ? (MessageForText) d16 : null;
                if (messageForText == null) {
                    return null;
                }
                if (msgElement != null) {
                    list = CollectionsKt__CollectionsJVMKt.listOf(msgElement);
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList<MsgElement> elements = msgRecord.elements;
                    if (elements != null) {
                        Intrinsics.checkNotNullExpressionValue(elements, "elements");
                        filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(elements);
                        if (filterNotNull != null) {
                            Iterator it = filterNotNull.iterator();
                            while (it.hasNext()) {
                                arrayList2.add((MsgElement) it.next());
                            }
                        }
                    }
                    list = arrayList2;
                }
                if (!list.isEmpty()) {
                    messageForText.f203106msg = ((IAIOMsgItemApi) QRoute.api(IAIOMsgItemApi.class)).buildContent(list).toString();
                }
                return messageForText;
            }
            msgElement2 = arrayList.get(0);
        } else {
            msgElement2 = msgElement;
        }
        z16 = true;
        if (!z16) {
        }
    }

    public final <T extends MsgElement> int c(List<? extends T> list) {
        Object orNull;
        FaceElement faceElement;
        Intrinsics.checkNotNullParameter(list, "<this>");
        orNull = CollectionsKt___CollectionsKt.getOrNull(list, 0);
        MsgElement msgElement = (MsgElement) orNull;
        if (msgElement == null || (faceElement = msgElement.faceElement) == null) {
            return 0;
        }
        return faceElement.faceIndex;
    }

    public final <T extends MsgElement> boolean e(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return list.size() == 1 && list.get(0).faceElement != null;
    }
}
