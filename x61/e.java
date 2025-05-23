package x61;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.activity.i;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.pic.l;
import com.tencent.mobileqq.pic.v;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes10.dex */
public class e {
    public void a(AppInterface appInterface, String str, String str2, String str3, int i3, String str4, String str5, String str6) {
        String str7;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("doReport, fromUin = ");
            if (appInterface != null && appInterface.getCurrentAccountUin() != null) {
                str7 = appInterface.getCurrentAccountUin();
            } else {
                str7 = "";
            }
            sb5.append(str7);
            sb5.append(", toUin = ");
            sb5.append(str);
            sb5.append(" , subAction = ");
            sb5.append(str2);
            sb5.append(", actionName = ");
            sb5.append(str3);
            sb5.append(" , fromType = ");
            sb5.append(i3);
            sb5.append(" ,r2 = ");
            sb5.append(str4);
            sb5.append(" , r4 = ");
            sb5.append(str5);
            sb5.append(" , r5 = ");
            sb5.append(str6);
            QLog.d("AdEmoReportUtil", 2, sb5.toString());
        }
        ReportController.o(appInterface, "dc00898", "", str, str2, str3, i3, 0, str4, "", str5, str6);
    }

    public int b(p pVar) {
        if (pVar == null) {
            return 0;
        }
        int i3 = pVar.f179555d;
        if (i3 == 1) {
            return 1;
        }
        if (i3 == 0) {
            return 2;
        }
        if (i.a(i3)) {
            return 3;
        }
        return 4;
    }

    public boolean c(ChatMessage chatMessage) {
        PicMessageExtraData picMessageExtraData;
        if (chatMessage == null || !(chatMessage instanceof MessageForPic) || (picMessageExtraData = ((MessageForPic) chatMessage).picExtraData) == null || picMessageExtraData.imageBizType != 9) {
            return false;
        }
        return true;
    }

    public void d(AppInterface appInterface, p pVar, MessageForPic messageForPic) {
        String str;
        String str2;
        if (appInterface != null && messageForPic != null && c(messageForPic)) {
            if (QLog.isColorLevel()) {
                QLog.d("AdEmoReportUtil", 2, "reportAdEmoAddFav, picMsg.uniseq = " + messageForPic.uniseq);
            }
            String str3 = messageForPic.md5;
            if (pVar == null) {
                if (str3 == null) {
                    str2 = "";
                } else {
                    str2 = str3;
                }
                a(appInterface, "", "0X800B129", "0X800B129", 0, "", str2, "");
                return;
            }
            String str4 = pVar.f179557e;
            int b16 = b(pVar);
            if (str3 == null) {
                str = "";
            } else {
                str = str3;
            }
            a(appInterface, str4, "0X800B129", "0X800B129", b16, "", str, "");
        }
    }

    public void e(AppInterface appInterface, p pVar, String str, int i3, String str2, String str3) {
        if (appInterface != null && pVar != null && str != null && str2 != null && str3 != null) {
            if (QLog.isColorLevel()) {
                QLog.d("AdEmoReportUtil", 2, "reportAdEmoSend, imgUrl = " + str + " , index = " + i3 + " , imgMd5 = " + str2 + " , keyWord = " + str3);
            }
            a(appInterface, pVar.f179557e, "0X800B125", str, b(pVar), String.valueOf(i3 + 1), str2, str3);
        }
    }

    public void f(AppInterface appInterface, p pVar, String str, int i3, String str2, String str3) {
        if (appInterface != null && pVar != null && str != null && str2 != null && str3 != null) {
            if (QLog.isColorLevel()) {
                QLog.d("AdEmoReportUtil", 2, "reportAdEmoShow, imgUrl = " + str + " , index = " + i3 + " , imgMd5 = " + str2 + " , keyWord = " + str3);
            }
            a(appInterface, pVar.f179557e, "0X800B124", str, b(pVar), String.valueOf(i3 + 1), str2, str3);
        }
    }

    public void g(AppInterface appInterface, String str, ArrayList<ChatMessage> arrayList, int i3) {
        if (appInterface != null && str != null && arrayList != null) {
            Iterator<ChatMessage> it = arrayList.iterator();
            while (it.hasNext()) {
                ChatMessage next = it.next();
                if (c(next)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("AdEmoReportUtil", 2, "reportForwardAdEmoMulti, picMsg.uniseq = " + next.uniseq);
                    }
                    String str2 = ((MessageForPic) next).md5;
                    if (str2 == null) {
                        str2 = "";
                    }
                    a(appInterface, str, "0X800B128", "0X800B128", i3, "", str2, "");
                }
            }
        }
    }

    public void h(AppInterface appInterface, p pVar, com.tencent.mobileqq.pic.p pVar2) {
        PicMessageExtraData picMessageExtraData;
        String str;
        v vVar;
        if (appInterface != null && pVar != null && pVar2 != null && (picMessageExtraData = pVar2.E) != null && picMessageExtraData.imageBizType == 9) {
            l lVar = pVar2.D;
            if (lVar == null || (vVar = lVar.f258731f) == null || (str = vVar.J) == null) {
                str = "";
            }
            String str2 = str;
            if (QLog.isColorLevel()) {
                QLog.d("AdEmoReportUtil", 2, "reportForwardSingleAdEmo ");
            }
            a(appInterface, pVar.f179557e, "0X800B128", "0X800B128", 1, "", str2, "");
        }
    }

    public void i(AppInterface appInterface, p pVar, String str) {
        if (appInterface != null && pVar != null && str != null) {
            int b16 = b(pVar);
            if (QLog.isColorLevel()) {
                QLog.d("AdEmoReportUtil", 2, "reportHitKeyWord, keyword = " + str + ", sessionType = " + b16);
            }
            a(appInterface, pVar.f179557e, "0X800B123", "0X800B123", b16, "", "", str);
        }
    }
}
