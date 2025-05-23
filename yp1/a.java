package yp1;

import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.guild.inbox.centerpanel.GuildNoticeUtils;
import com.tencent.mobileqq.guild.inbox.startpanel.p;
import com.tencent.mobileqq.guild.summary.c;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.qqguildsdk.data.co;

/* compiled from: P */
/* loaded from: classes13.dex */
public class a {
    public static String a(co coVar) {
        StringBuilder sb5 = new StringBuilder();
        String i3 = GuildNoticeUtils.i(coVar);
        String f16 = GuildNoticeUtils.f226106a.f(coVar, false);
        if (!TextUtils.isEmpty(i3)) {
            sb5.append(i3);
            sb5.append(MsgSummary.STR_COLON);
        }
        if (!TextUtils.isEmpty(f16)) {
            sb5.append(f16);
        }
        return sb5.toString();
    }

    public static p b(int i3) {
        p pVar = new p();
        pVar.f226295d = 1;
        pVar.f226296e = String.valueOf(i3);
        pVar.f226298h = String.valueOf(i3);
        pVar.C.f230841e = 2;
        pVar.f226300m = 0L;
        if (i3 != 5) {
            if (i3 != 6) {
                if (i3 != 7) {
                    if (i3 == 8) {
                        pVar.f226299i = "\u4e92\u52a8\u6d88\u606f";
                        pVar.D = c.b(QQGuildUIUtil.r(R.string.f1513917k));
                    }
                } else {
                    pVar.f226299i = QQGuildUIUtil.r(R.string.f139770c6);
                    pVar.D = c.b(QQGuildUIUtil.r(R.string.f1513917k));
                }
            } else {
                pVar.f226299i = QQGuildUIUtil.r(R.string.f1513517g);
                pVar.D = c.b(QQGuildUIUtil.r(R.string.f1513917k));
            }
        } else {
            pVar.f226299i = QQGuildUIUtil.r(R.string.f1514217n);
            pVar.D = c.b(QQGuildUIUtil.r(R.string.f1513917k));
        }
        return pVar;
    }
}
