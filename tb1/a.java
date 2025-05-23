package tb1;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.multimsg.d;
import com.tencent.mobileqq.multimsg.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a extends b {

    /* renamed from: a, reason: collision with root package name */
    private QQAppInterface f435781a;

    /* renamed from: b, reason: collision with root package name */
    private h f435782b;

    /* renamed from: c, reason: collision with root package name */
    private d f435783c;

    /* renamed from: d, reason: collision with root package name */
    HashMap<String, ArrayList<MessageRecord>> f435784d;

    /* renamed from: e, reason: collision with root package name */
    private HashMap<String, ArrayList<MessageRecord>> f435785e;

    public a(QQAppInterface qQAppInterface, h hVar, HashMap<String, ArrayList<MessageRecord>> hashMap, d dVar) {
        this.f435781a = qQAppInterface;
        this.f435782b = hVar;
        this.f435783c = dVar;
        this.f435784d = hashMap;
    }

    @Override // tb1.b
    public HashMap<String, ArrayList<MessageRecord>> b() {
        if (this.f435785e == null) {
            this.f435785e = new HashMap<>();
            for (String str : this.f435784d.keySet()) {
                ArrayList<MessageRecord> arrayList = new ArrayList<>();
                this.f435785e.put(str, arrayList);
                ArrayList<MessageRecord> arrayList2 = this.f435784d.get(str);
                for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                    MessageRecord messageRecord = arrayList2.get(i3);
                    if (messageRecord instanceof MessageForReplyText) {
                        MessageForReplyText messageForReplyText = (MessageForReplyText) messageRecord;
                        MessageRecord sourceMessage = messageForReplyText.getSourceMessage();
                        if (sourceMessage != null && FileManagerUtil.isMessageRecordOfFile(sourceMessage)) {
                            sourceMessage.isMultiMsg = messageForReplyText.isMultiMsg;
                            arrayList.add(sourceMessage);
                        } else {
                            arrayList.add(messageRecord);
                        }
                    } else {
                        arrayList.add(messageRecord);
                    }
                }
            }
        }
        return this.f435785e;
    }

    @Override // tb1.b
    public int c() {
        SessionInfo sessionInfo;
        h hVar = this.f435782b;
        if (hVar == null || (sessionInfo = hVar.f251617a) == null) {
            return -1;
        }
        return sessionInfo.f179555d;
    }

    @Override // tb1.b
    public String d() {
        SessionInfo sessionInfo;
        h hVar = this.f435782b;
        if (hVar == null || (sessionInfo = hVar.f251617a) == null) {
            return "";
        }
        return String.valueOf(sessionInfo.f179557e);
    }

    @Override // tb1.b
    public String e() {
        MessageRecord messageRecord;
        h hVar = this.f435782b;
        if (hVar == null || (messageRecord = hVar.f251621e) == null) {
            return "";
        }
        return String.valueOf(messageRecord.uniseq);
    }

    @Override // tb1.b
    public void f(int i3, List<MessageRecord> list, List<MessageRecord> list2) {
        a(this.f435785e, this.f435784d);
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            arrayList.addAll(list);
            this.f435781a.getProxyManager().k().O(arrayList, null);
        }
        if (i3 == 1) {
            this.f435783c.c(1, 2, this.f435782b);
        } else {
            this.f435783c.c(0, 2, this.f435782b);
        }
    }

    @Override // tb1.b
    public void g(String str, List<MessageRecord> list, MessageRecord messageRecord, int i3) {
        MessageRecord messageRecord2;
        if (list != null && messageRecord != null) {
            ArrayList<MessageRecord> arrayList = this.f435784d.get(str);
            if (arrayList != null) {
                messageRecord2 = arrayList.get(i3);
            } else {
                messageRecord2 = null;
            }
            if (messageRecord2 != null) {
                if (messageRecord2 instanceof MessageForReplyText) {
                    ((MessageForReplyText) messageRecord2).setSourceMessageRecord(this.f435781a.getProxyManager().k().c(messageRecord, HardCodeUtil.qqStr(R.string.f172208oc1) + messageRecord.getExtInfoFromExtStr("_m_ForwardFileName"), true));
                    return;
                }
                arrayList.set(i3, this.f435781a.getProxyManager().k().c(messageRecord, messageRecord.getExtInfoFromExtStr("_m_ForwardFaildReason"), true));
            }
        }
    }
}
