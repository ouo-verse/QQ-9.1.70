package qk1;

import com.google.gson.Gson;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedReportBean;
import com.tencent.mobileqq.guild.feed.event.GuildFeedReportEvent;
import com.tencent.mobileqq.guild.feed.util.bl;
import com.tencent.mobileqq.guild.feed.webbundle.t;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes13.dex */
public class c extends ok1.a {
    private void p(GuildFeedReportBean guildFeedReportBean) {
        ok1.c cVar;
        String str;
        boolean z16;
        if (guildFeedReportBean != null && (cVar = this.f423064e) != null) {
            WebViewPlugin a16 = ok1.d.a(cVar, "offline");
            if (!(a16 instanceof OfflinePlugin)) {
                return;
            }
            if (((OfflinePlugin) a16).T) {
                str = "1";
            } else {
                str = "0";
            }
            t b16 = ok1.d.b(this.f423064e);
            if (b16 != null && b16.n()) {
                z16 = true;
            } else {
                z16 = false;
            }
            for (GuildFeedReportBean.ReportBean reportBean : guildFeedReportBean.getReportList()) {
                Map<String, String> params = reportBean.getParams();
                if (params == null) {
                    params = new HashMap<>();
                }
                params.put("is_hit_index_offline", str);
                if (z16) {
                    params.put("is_hit_detail_cache_data", "1");
                }
                reportBean.setParams(params);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ok1.a
    public String k() {
        return "reportTask";
    }

    @Override // ok1.a
    protected boolean o(String str, String str2, String str3) {
        GuildFeedReportBean guildFeedReportBean = (GuildFeedReportBean) new Gson().fromJson(j(), GuildFeedReportBean.class);
        p(guildFeedReportBean);
        bl.c().b(new GuildFeedReportEvent(guildFeedReportBean, true), true);
        return true;
    }
}
