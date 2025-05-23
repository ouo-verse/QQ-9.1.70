package qu3;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import qu3.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lqu3/h;", "Lqu3/d;", "", "c", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "Lcom/tencent/mobileqq/data/ChatMessage;", "b", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class h implements d {
    private final boolean c() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("only_text_msg_record_coverter_116275374", true);
    }

    @Override // qu3.d
    public ChatMessage a(AppRuntime appRuntime, MsgRecord msgRecord, MsgElement msgElement) {
        return d.a.a(this, appRuntime, msgRecord, msgElement);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x005b, code lost:
    
        if (r7.elements.size() > 1) goto L24;
     */
    @Override // qu3.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ChatMessage b(AppRuntime app, MsgRecord msgRecord, MsgElement msgElement) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        AIOMsgItem aIOMsgItem = new AIOMsgItem(msgRecord);
        if (com.tencent.mobileqq.aio.utils.d.Z(aIOMsgItem)) {
            return new o().a(app, msgRecord, null);
        }
        if (com.tencent.mobileqq.aio.utils.d.L(aIOMsgItem)) {
            return new l().a(app, msgRecord, null);
        }
        MessageRecord d16 = com.tencent.mobileqq.service.message.q.d(MessageRecord.MSG_TYPE_MIX);
        MessageForMixedMsg messageForMixedMsg = d16 instanceof MessageForMixedMsg ? (MessageForMixedMsg) d16 : null;
        if (messageForMixedMsg == null) {
            return null;
        }
        messageForMixedMsg.msgElemList = new ArrayList();
        if (msgRecord.elements != null) {
            boolean z16 = c();
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
