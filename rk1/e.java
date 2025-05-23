package rk1;

import android.text.TextUtils;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildPublishTaskChangeBean;
import com.tencent.mobileqq.guild.feed.util.ak;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes13.dex */
public class e extends b {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ok1.a
    public String k() {
        return "deleteMedia";
    }

    @Override // ok1.a
    protected boolean o(String str, String str2, String str3) {
        String g16 = g(MiniAppGetGameTaskTicketServlet.KEY_TASKID);
        ak.l(j());
        if (TextUtils.isEmpty(g16)) {
            QLog.e("DeleteMediaMethod", 1, "DeleteMediaMethod KEY_TASK_ID is empty!");
            return false;
        }
        GuildPublishTaskChangeBean guildPublishTaskChangeBean = new GuildPublishTaskChangeBean();
        guildPublishTaskChangeBean.getDeleteMediaList().add(g16);
        mn1.b.k(2, guildPublishTaskChangeBean);
        return true;
    }
}
