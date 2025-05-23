package z61;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.colornote.smallscreen.UpComingMsgModel;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected QQAppInterface f452006a;

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] a(List<AIOMsgItem> list, int i3, String str, String str2) {
        int i16;
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<AIOMsgItem> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(it.next().getMsgRecord().getMsgSeq()));
        }
        AIOMsgItem aIOMsgItem = list.get(0);
        MsgRecord msgRecord = aIOMsgItem.getMsgRecord();
        if (list.size() == 1 && i3 == 1) {
            i16 = e.d(aIOMsgItem);
        } else {
            i16 = 8;
        }
        return new UpComingMsgModel(Long.toString(msgRecord.getPeerUin()), str2, arrayList, c.d(msgRecord.getChatType()), i3, i16, str).toJson().getBytes();
    }
}
