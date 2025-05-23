package rk1;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.tencent.mobileqq.guild.feed.jsbridge.methods.publish.helper.GuildUploadHelper;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildPublishTaskChangeBean;
import com.tencent.mobileqq.guild.feed.util.ak;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes13.dex */
public class w extends rk1.b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class a extends TypeToken<List<b>> {
        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static class b {

        @SerializedName(MiniAppGetGameTaskTicketServlet.KEY_TASKID)
        public String taskId;

        b() {
        }
    }

    private void p(GuildPublishTaskChangeBean guildPublishTaskChangeBean, String str) {
        List list;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            list = (List) new Gson().fromJson(str, new a().getType());
        } catch (Exception e16) {
            QLog.e("PublishNotifyTaskChangeMethod", 1, "PublishNotifyTaskChangeMethod.addMediaChangeList encounter exception", e16);
            list = null;
        }
        if (list != null && !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                guildPublishTaskChangeBean.getCurrentShowMediaList().add(((b) it.next()).taskId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ok1.a
    public String k() {
        return "notifyTaskChange";
    }

    @Override // ok1.a
    protected boolean o(String str, String str2, String str3) {
        String g16 = g("images");
        String g17 = g("videos");
        ak.k(g16, g17);
        if (TextUtils.isEmpty(g16) && TextUtils.isEmpty(g17)) {
            QLog.e("PublishNotifyTaskChangeMethod", 1, "cannot receive any media task id fullJson: " + j());
            return false;
        }
        if (TextUtils.isEmpty(GuildUploadHelper.i().h())) {
            QLog.e("PublishNotifyTaskChangeMethod", 1, "getCurrentMainTaskId is empty!");
            return false;
        }
        GuildPublishTaskChangeBean guildPublishTaskChangeBean = new GuildPublishTaskChangeBean();
        p(guildPublishTaskChangeBean, g16);
        p(guildPublishTaskChangeBean, g17);
        mn1.b.k(1, guildPublishTaskChangeBean);
        return true;
    }
}
