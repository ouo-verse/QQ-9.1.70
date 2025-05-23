package qu3;

import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.AppRuntime;
import qu3.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ$\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lqu3/j;", "Lqu3/d;", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "Lcom/tencent/mobileqq/data/ChatMessage;", "b", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class j implements d {
    @Override // qu3.d
    public ChatMessage a(AppRuntime appRuntime, MsgRecord msgRecord, MsgElement msgElement) {
        return d.a.a(this, appRuntime, msgRecord, msgElement);
    }

    @Override // qu3.d
    public ChatMessage b(AppRuntime app, MsgRecord msgRecord, MsgElement msgElement) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        MessageRecord d16 = com.tencent.mobileqq.service.message.q.d(MessageRecord.MSG_TYPE_STRUCT_MSG);
        byte[] bArr = null;
        MessageForStructing messageForStructing = d16 instanceof MessageForStructing ? (MessageForStructing) d16 : null;
        if (messageForStructing == null) {
            return null;
        }
        if (msgElement == null && (msgElement = i.f429570a.j(msgRecord)) == null) {
            return null;
        }
        String str = msgElement.multiForwardMsgElement.xmlContent;
        if (str != null) {
            bArr = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bArr, "this as java.lang.String).getBytes(charset)");
        }
        if (bArr != null) {
            try {
                messageForStructing.structingMsg = com.tencent.mobileqq.structmsg.i.g(bArr, 0);
            } catch (Exception e16) {
                QLog.e("NTMsgFav", 1, "getStructMsgFromXmlBuff ", e16);
            }
        }
        AbsStructMsg absStructMsg = messageForStructing.structingMsg;
        if (absStructMsg != null) {
            absStructMsg.message = messageForStructing;
        }
        return messageForStructing;
    }
}
