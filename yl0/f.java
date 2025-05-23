package yl0;

import ADV_REPORT.mobile_adv_report_req;
import android.text.TextUtils;
import com.tencent.gdt.tangram.ad.AdListScene;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes36.dex */
public class f extends h {

    /* renamed from: a, reason: collision with root package name */
    private e f450585a;

    public f(e eVar) {
        this.f450585a = eVar;
    }

    public wl0.a b() {
        String obj;
        e eVar = this.f450585a;
        if (eVar == null || eVar.a() == null) {
            return null;
        }
        mobile_adv_report_req mobile_adv_report_reqVar = new mobile_adv_report_req();
        mobile_adv_report_reqVar.cookie = this.f450585a.d();
        mobile_adv_report_reqVar.busi_param = this.f450585a.c();
        mobile_adv_report_reqVar.report_posi = 0;
        com.tencent.gdt.tangram.ad.qzone.d.b("AdImpressionEventSessionFactory", "report_posi =" + mobile_adv_report_reqVar.report_posi);
        mobile_adv_report_reqVar.client_time = System.currentTimeMillis();
        if (this.f450585a.a().getScene() != null && (this.f450585a.a().getScene() instanceof AdListScene)) {
            mobile_adv_report_reqVar.feed_index = ((AdListScene) this.f450585a.a().getScene()).getIndex();
        }
        com.tencent.gdt.tangram.ad.qzone.d.b("AdImpressionEventSessionFactory", "feed_index =" + mobile_adv_report_reqVar.feed_index);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("cookie =");
        Map<Integer, String> map = mobile_adv_report_reqVar.cookie;
        String str = "null";
        if (map == null) {
            obj = "null";
        } else {
            obj = map.toString();
        }
        sb5.append(obj);
        com.tencent.gdt.tangram.ad.qzone.d.b("AdImpressionEventSessionFactory", sb5.toString());
        StringBuilder sb6 = new StringBuilder();
        sb6.append("busi_param =");
        Map<Integer, String> map2 = mobile_adv_report_reqVar.busi_param;
        if (map2 != null) {
            str = map2.toString();
        }
        sb6.append(str);
        com.tencent.gdt.tangram.ad.qzone.d.b("AdImpressionEventSessionFactory", sb6.toString());
        mobile_adv_report_reqVar.is_impression = true;
        mobile_adv_report_reqVar.is_repeated = this.f450585a.i();
        mobile_adv_report_reqVar.is_installed = this.f450585a.h();
        if (!TextUtils.isEmpty(this.f450585a.g())) {
            mobile_adv_report_reqVar.video_playinfo = this.f450585a.g();
        }
        wl0.a aVar = new wl0.a();
        aVar.f445785a = a();
        wl0.b bVar = new wl0.b();
        aVar.f445786b = bVar;
        bVar.f445788a = mobile_adv_report_reqVar;
        return aVar;
    }
}
