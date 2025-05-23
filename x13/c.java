package x13;

import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.state.square.api.MessageRecordType;
import com.tencent.state.square.api.SquareBaseMessageRecord;
import com.tencent.state.square.api.SquareMessageRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lx13/c;", "Lx13/b;", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "contact", "Lcom/tencent/state/square/api/SquareBaseMessageRecord;", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c implements b {
    @Override // x13.b
    public SquareBaseMessageRecord a(RecentContactInfo contact) {
        Intrinsics.checkNotNullParameter(contact, "contact");
        g a16 = a.f447051a.a(contact);
        SquareMessageRecord squareMessageRecord = new SquareMessageRecord(String.valueOf(a16.s().peerUin), MessageRecordType.RECORD_TYPE_FRIEND);
        squareMessageRecord.setUnreadCount((int) a16.x().b());
        squareMessageRecord.setForbiddenNotify(!com.tencent.mobileqq.vas.message.c.f310029a.a(r0));
        String str = a16.s().peerName;
        Intrinsics.checkNotNullExpressionValue(str, "chatItem.originData.peerName");
        squareMessageRecord.setNickName(str);
        squareMessageRecord.setLastMsg(a16.v().f().toString());
        squareMessageRecord.setLastMsgUid(a16.s().msgId);
        squareMessageRecord.setLastTimeStamp(a16.s().msgTime);
        squareMessageRecord.setMsgType(d.a(a16.s().abstractContent));
        squareMessageRecord.setSummaryData(d.b(a16));
        squareMessageRecord.setUnReadMark(a16.x().b() == 0 && (((int) a16.s().unreadFlag) == 1));
        return squareMessageRecord;
    }
}
