package r00;

import android.os.SystemClock;
import com.tencent.biz.pubaccount.weishi.report.WSStatisticsReporter;
import com.tencent.biz.pubaccount.weishi.report.f;
import com.tencent.gamematrix.gmcg.sdk.nonage.report.CGNonAgeReport;
import com.tencent.tuxmeterqui.config.TuxDialogBundleKey;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static final Map<String, Long> f430446b = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    private b f430447a;

    public a(b bVar) {
        this.f430447a = bVar;
    }

    private static WSStatisticsReporter.Builder a() {
        return new WSStatisticsReporter.Builder().setSopName("web_active").setFlush(true);
    }

    private static void b(WSStatisticsReporter.Builder builder, String str) {
        builder.build(str).report();
    }

    private static Map<String, String> c(b bVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("spid", bVar.b());
        hashMap.put("web_test_id ", bVar.c());
        hashMap.put(TuxDialogBundleKey.WEB_URL, bVar.d());
        hashMap.put("share_scenes_from", bVar.a());
        return hashMap;
    }

    private static WSStatisticsReporter.Builder d(b bVar) {
        return a().addParams("feed_id", "").addParams("owner_id", "").addParams("action_id", "1000001").addExtParams(c(bVar));
    }

    private Long e() {
        Long l3 = f430446b.get("web_active");
        if (l3 == null) {
            return 0L;
        }
        return Long.valueOf(SystemClock.elapsedRealtime() - l3.longValue());
    }

    public void f() {
        Long e16 = e();
        Map<String, String> c16 = c(this.f430447a);
        c16.put("exp_duration", String.valueOf(e16));
        b(d(this.f430447a).addParams("position", "back").addExtParams(c16), "gzh_click");
    }

    public void g() {
        Long e16 = e();
        Map<String, String> c16 = c(this.f430447a);
        c16.put("exp_duration", String.valueOf(e16));
        b(d(this.f430447a).addParams("position", "back_homepage").addExtParams(c16), "gzh_click");
    }

    public void h() {
        f.k("QQ_official_account");
        f430446b.put("web_active", Long.valueOf(SystemClock.elapsedRealtime()));
        b(a().addParams(CGNonAgeReport.EVENT_TYPE, "1").addExtParams(c(this.f430447a)), "gzh_pageview");
    }

    public void i() {
        b(a().addParams("position", "web_active_exp").addExtParams(c(this.f430447a)), "gzh_exposure");
    }

    public void j() {
        b(a().addParams(CGNonAgeReport.EVENT_TYPE, "2").addParams("page_live_time", e().toString()).addExtParams(c(this.f430447a)), "gzh_pageview");
    }
}
