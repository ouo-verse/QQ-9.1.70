package z61;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.i;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.filemanager.fileassistant.util.h;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mobileqq.utils.ac;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class c extends a {

    /* renamed from: b, reason: collision with root package name */
    static HashMap<Integer, Integer> f452007b;

    static {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        f452007b = hashMap;
        hashMap.put(0, 10021);
        f452007b.put(1, 0);
        f452007b.put(2, 1);
        f452007b.put(3, 3000);
        f452007b.put(4, 10014);
        f452007b.put(5, 1035);
        f452007b.put(30, 1035);
        f452007b.put(6, 9000);
        f452007b.put(7, 5000);
        f452007b.put(8, 7);
        f452007b.put(9, 10016);
        f452007b.put(100, 1000);
        f452007b.put(101, 1022);
        f452007b.put(103, 1008);
        f452007b.put(115, 10019);
        f452007b.put(99, 10021);
        f452007b.put(102, 10021);
    }

    public c(QQAppInterface qQAppInterface) {
        this.f452006a = qQAppInterface;
    }

    public static int d(int i3) {
        if (f452007b.containsKey(Integer.valueOf(i3))) {
            return f452007b.get(Integer.valueOf(i3)).intValue();
        }
        return 10021;
    }

    public ColorNote b(List<AIOMsgItem> list, long j3, int i3, String str) {
        String string;
        boolean z16;
        long peerUin;
        String f16;
        if (list != null && list.size() != 0) {
            if (j3 != -1) {
                string = this.f452006a.getApplication().getString(R.string.yus) + MsgSummary.STR_COLON + b.c(j3);
            } else {
                string = this.f452006a.getApplication().getString(R.string.yur);
            }
            MsgRecord msgRecord = list.get(0).getMsgRecord();
            String l3 = Long.toString(msgRecord.getPeerUin());
            if (msgRecord.getChatType() != 2 && msgRecord.getChatType() != 3) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                peerUin = msgRecord.getSenderUin();
            } else {
                peerUin = msgRecord.getPeerUin();
            }
            String l16 = Long.toString(peerUin);
            if (TextUtils.equals(l3, h.g(this.f452006a))) {
                l16 = h.g(this.f452006a);
            }
            if (z16) {
                l3 = ac.y(this.f452006a, Long.toString(msgRecord.getSenderUin()));
            } else if (msgRecord.getPeerName() != null) {
                l3 = msgRecord.getPeerName();
            }
            if (list.size() != 1) {
                f16 = l3 + "\u7684" + list.size() + "\u6761\u6d88\u606f";
            } else {
                f16 = e.f(this.f452006a, list.get(0));
            }
            String builder = new Uri.Builder().scheme(ProtocolDownloaderConstants.PROTOCAL_UIN_DRAWABLE).appendQueryParameter("type", String.valueOf(c(msgRecord, this.f452006a))).appendQueryParameter("uin", l16).toString();
            ColorNote.a aVar = new ColorNote.a();
            aVar.g(android.R.array.emailAddressTypes).i(e.j(j3)).c(0).d(f16).h(string).e(builder).f(a(list, i3, str, Long.toString(msgRecord.getPeerUin())));
            return aVar.a();
        }
        return null;
    }

    int c(MsgRecord msgRecord, QQAppInterface qQAppInterface) {
        if (msgRecord != null) {
            return ((Integer) i.n(qQAppInterface, d(msgRecord.getChatType()), Long.toString(msgRecord.getPeerUin())).first).intValue();
        }
        return 4;
    }
}
