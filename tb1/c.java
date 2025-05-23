package tb1;

import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.multimsg.d;
import com.tencent.mobileqq.multimsg.h;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c extends b {

    /* renamed from: a, reason: collision with root package name */
    private QQAppInterface f435786a;

    /* renamed from: b, reason: collision with root package name */
    private h f435787b;

    /* renamed from: c, reason: collision with root package name */
    private d f435788c;

    /* renamed from: d, reason: collision with root package name */
    HashMap<String, ArrayList<MessageRecord>> f435789d;

    /* renamed from: e, reason: collision with root package name */
    private MessageForReplyText f435790e;

    /* renamed from: f, reason: collision with root package name */
    private String f435791f;

    /* renamed from: g, reason: collision with root package name */
    private HashMap<String, ArrayList<MessageRecord>> f435792g;

    public c(QQAppInterface qQAppInterface, h hVar, HashMap<String, ArrayList<MessageRecord>> hashMap, d dVar) {
        this.f435786a = qQAppInterface;
        this.f435787b = hVar;
        this.f435788c = dVar;
        this.f435789d = hashMap;
        if (hashMap != null && !hashMap.isEmpty()) {
            for (String str : this.f435789d.keySet()) {
                Iterator<MessageRecord> it = this.f435789d.get(str).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    MessageRecord next = it.next();
                    if (next instanceof MessageForReplyText) {
                        this.f435790e = (MessageForReplyText) next;
                        this.f435791f = str;
                        break;
                    }
                }
                if (this.f435790e != null) {
                    return;
                }
            }
        }
    }

    @Override // tb1.b
    public HashMap<String, ArrayList<MessageRecord>> b() {
        int c16;
        FileManagerEntity E;
        if (this.f435792g == null) {
            this.f435792g = new HashMap<>();
            MessageForReplyText messageForReplyText = this.f435790e;
            if (messageForReplyText != null && messageForReplyText.getSourceMessage() != null && !TextUtils.isEmpty(this.f435791f)) {
                MessageRecord sourceMessage = this.f435790e.getSourceMessage();
                if ((sourceMessage instanceof MessageForFile) && (E = this.f435786a.getFileManagerDataCenter().E(sourceMessage.uniseq, sourceMessage.frienduin, sourceMessage.istroop)) != null && E.getCloudType() == 0) {
                    QLog.i("ReplyMsgForwardRequest<QFile>", 1, "getForwardMessageList. init UploadSourceMsgList, find online file.");
                    this.f435790e.setSourceMessageRecord(this.f435786a.getProxyManager().k().c(sourceMessage, HardCodeUtil.qqStr(R.string.t0k) + sourceMessage.getExtInfoFromExtStr("_m_ForwardFileName"), true));
                }
                if (FileManagerUtil.isMessageRecordOfFile(sourceMessage) && (c16 = c()) != 0 && c16 != 3000 && c16 != 1) {
                    QLog.i("ReplyMsgForwardRequest<QFile>", 1, "getForwardMessageList. init UploadSourceMsgList, find unsupport chatType file.");
                    this.f435790e.setSourceMessageRecord(this.f435786a.getProxyManager().k().c(sourceMessage, HardCodeUtil.qqStr(R.string.t0h) + sourceMessage.getExtInfoFromExtStr("_m_ForwardFileName"), true));
                }
                ArrayList<MessageRecord> arrayList = new ArrayList<>(1);
                arrayList.add(this.f435790e.getSourceMessage());
                this.f435792g.put(this.f435791f, arrayList);
            }
        }
        return this.f435792g;
    }

    @Override // tb1.b
    public int c() {
        SessionInfo sessionInfo;
        h hVar = this.f435787b;
        if (hVar == null || (sessionInfo = hVar.f251617a) == null) {
            return -1;
        }
        return sessionInfo.f179555d;
    }

    @Override // tb1.b
    public String d() {
        SessionInfo sessionInfo;
        h hVar = this.f435787b;
        if (hVar == null || (sessionInfo = hVar.f251617a) == null) {
            return "";
        }
        return String.valueOf(sessionInfo.f179557e);
    }

    @Override // tb1.b
    public String e() {
        MessageRecord messageRecord;
        h hVar = this.f435787b;
        if (hVar == null || (messageRecord = hVar.f251621e) == null) {
            return "";
        }
        return String.valueOf(messageRecord.uniseq);
    }

    @Override // tb1.b
    public void f(int i3, List<MessageRecord> list, List<MessageRecord> list2) {
        a(this.f435792g, this.f435789d);
        if (i3 == 1) {
            MessageRecord sourceMessage = this.f435790e.getSourceMessage();
            this.f435790e.setSourceMessageRecord(this.f435786a.getProxyManager().k().c(sourceMessage, HardCodeUtil.qqStr(R.string.t0j) + sourceMessage.getExtInfoFromExtStr("_m_ForwardFileName"), false));
            this.f435788c.c(1, 2, this.f435787b);
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            arrayList.addAll(list);
        }
        this.f435788c.c(0, 2, this.f435787b);
    }

    @Override // tb1.b
    public void g(String str, List<MessageRecord> list, MessageRecord messageRecord, int i3) {
        String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr("_m_ForwardFaildReason");
        String str2 = HardCodeUtil.qqStr(R.string.t0i) + messageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
        this.f435790e.setSourceMessageRecord(this.f435786a.getProxyManager().k().c(messageRecord, str2, false));
        QLog.i("ReplyMsgForwardRequest<QFile>", 1, "replaceDropForwardMsg hint[ + " + str2 + "reason[" + extInfoFromExtStr + "]");
    }
}
