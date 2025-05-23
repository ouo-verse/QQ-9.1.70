package qu3;

import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.kernel.nativeinterface.MarkdownElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.api.IMsgUtilApi;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import qu3.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ$\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lqu3/f;", "Lqu3/d;", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "Lcom/tencent/mobileqq/data/ChatMessage;", "b", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class f implements d {
    @Override // qu3.d
    public ChatMessage a(AppRuntime appRuntime, MsgRecord msgRecord, MsgElement msgElement) {
        return d.a.a(this, appRuntime, msgRecord, msgElement);
    }

    @Override // qu3.d
    public ChatMessage b(AppRuntime app, MsgRecord msgRecord, MsgElement msgElement) {
        MarkdownElement markdownElement;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        MsgElement g16 = i.f429570a.g(msgRecord);
        MsgRecord msgRecord2 = new MsgRecord();
        msgRecord2.sendStatus = 2;
        msgRecord2.msgType = 2;
        msgRecord2.peerUid = msgRecord.peerUid;
        msgRecord2.chatType = msgRecord.chatType;
        msgRecord2.sendNickName = msgRecord.sendNickName;
        msgRecord2.senderUid = msgRecord.senderUid;
        msgRecord2.sendType = msgRecord.sendType;
        msgRecord2.senderUin = msgRecord.senderUin;
        msgRecord2.msgSeq = msgRecord.msgSeq;
        msgRecord2.msgTime = msgRecord.msgTime;
        msgRecord2.avatarFlag = msgRecord.avatarFlag;
        ArrayList<MsgElement> arrayList = new ArrayList<>();
        msgRecord2.elements = arrayList;
        IMsgUtilApi iMsgUtilApi = (IMsgUtilApi) QRoute.api(IMsgUtilApi.class);
        String str = (g16 == null || (markdownElement = g16.markdownElement) == null) ? null : markdownElement.mdSummary;
        if (str == null) {
            str = "";
        }
        arrayList.add(iMsgUtilApi.createTextElement(str));
        return new o().a(app, msgRecord2, null);
    }
}
