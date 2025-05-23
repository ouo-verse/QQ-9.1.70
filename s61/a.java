package s61;

import com.tencent.imcore.message.ad;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForSafeGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static int f433387a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static int f433388b = 1;

    public static MessageRecord a(QQAppInterface qQAppInterface, p pVar, MessageForReplyText.SourceMsgInfo sourceMsgInfo) {
        if (pVar.f179555d == 0) {
            return c(qQAppInterface, pVar, sourceMsgInfo);
        }
        return b(qQAppInterface, pVar, sourceMsgInfo);
    }

    public static MessageRecord b(QQAppInterface qQAppInterface, p pVar, MessageForReplyText.SourceMsgInfo sourceMsgInfo) {
        List<MessageRecord> t06 = qQAppInterface.getMessageFacade().t0(pVar.f179557e, pVar.f179555d, sourceMsgInfo.mSourceMsgSeq, 0L);
        if (t06 != null && t06.size() > 0) {
            for (int i3 = 0; i3 < t06.size(); i3++) {
                MessageRecord messageRecord = t06.get(i3);
                if (!ad.B(messageRecord) && !(messageRecord instanceof MessageForSafeGrayTips)) {
                    return messageRecord;
                }
            }
            return null;
        }
        return null;
    }

    public static MessageRecord c(QQAppInterface qQAppInterface, p pVar, MessageForReplyText.SourceMsgInfo sourceMsgInfo) {
        return d(qQAppInterface, pVar.f179557e, pVar.f179555d, sourceMsgInfo.mSourceMsgTime, sourceMsgInfo.origUid);
    }

    public static MessageRecord d(QQAppInterface qQAppInterface, String str, int i3, long j3, long j16) {
        List<MessageRecord> v06 = qQAppInterface.getMessageFacade().v0(str, i3, j3, j16);
        if (v06 != null && v06.size() > 0) {
            for (int i16 = 0; i16 < v06.size(); i16++) {
                MessageRecord messageRecord = v06.get(i16);
                if (!ad.z(messageRecord) && !(messageRecord instanceof MessageForSafeGrayTips)) {
                    return messageRecord;
                }
            }
            return null;
        }
        return null;
    }
}
