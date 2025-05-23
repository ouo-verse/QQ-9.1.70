package yl0;

import ADV_REPORT.mobile_adv_report_req;
import com.tencent.gdt.tangram.ad.AdListScene;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b extends h {

    /* renamed from: a, reason: collision with root package name */
    private a f450579a;

    public b(a aVar) {
        this.f450579a = aVar;
    }

    public wl0.a b() {
        String obj;
        a aVar = this.f450579a;
        if (aVar == null || aVar.a() == null) {
            return null;
        }
        mobile_adv_report_req mobile_adv_report_reqVar = new mobile_adv_report_req();
        mobile_adv_report_reqVar.cookie = this.f450579a.d();
        mobile_adv_report_reqVar.busi_param = this.f450579a.c();
        if (((this.f450579a.h() != null && this.f450579a.h().c()) || this.f450579a.i() == 6) && this.f450579a.g()) {
            mobile_adv_report_reqVar.report_posi = 5000;
        } else {
            mobile_adv_report_reqVar.report_posi = 5001;
        }
        if (this.f450579a.h() != null) {
            mobile_adv_report_reqVar.is_report_gdt = this.f450579a.h().b();
        }
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
        com.tencent.gdt.tangram.ad.qzone.d.b("AdClickEventSessionFactory", sb5.toString());
        StringBuilder sb6 = new StringBuilder();
        sb6.append("busi_param");
        Map<Integer, String> map2 = mobile_adv_report_reqVar.busi_param;
        if (map2 != null) {
            str = map2.toString();
        }
        sb6.append(str);
        com.tencent.gdt.tangram.ad.qzone.d.b("AdClickEventSessionFactory", sb6.toString());
        com.tencent.gdt.tangram.ad.qzone.d.b("AdClickEventSessionFactory", "report_posi =" + mobile_adv_report_reqVar.report_posi);
        mobile_adv_report_reqVar.client_time = System.currentTimeMillis();
        if (this.f450579a.a().getScene() != null && (this.f450579a.a().getScene() instanceof AdListScene)) {
            mobile_adv_report_reqVar.feed_index = ((AdListScene) this.f450579a.a().getScene()).getIndex();
            com.tencent.gdt.tangram.ad.qzone.d.b("AdClickEventSessionFactory", "feedIndex =" + mobile_adv_report_reqVar.feed_index);
        }
        mobile_adv_report_reqVar.is_impression = false;
        mobile_adv_report_reqVar.feeds_click_attachinfo = this.f450579a.k();
        com.tencent.gdt.tangram.ad.qzone.d.b("AdClickEventSessionFactory", "attachInfo =" + mobile_adv_report_reqVar.feeds_click_attachinfo);
        if (this.f450579a.j() != null && !this.f450579a.j().isEmpty()) {
            mobile_adv_report_reqVar.antispam_info = this.f450579a.j();
        }
        wl0.a aVar2 = new wl0.a();
        aVar2.f445785a = a();
        wl0.b bVar = new wl0.b();
        aVar2.f445786b = bVar;
        bVar.f445788a = mobile_adv_report_reqVar;
        return aVar2;
    }
}
