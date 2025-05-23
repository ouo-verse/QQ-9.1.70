package qx2;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import uq3.k;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private boolean f430269a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f430270b = false;

    /* renamed from: c, reason: collision with root package name */
    public String f430271c = "https://film.qq.com/h5/upay/?actid=HLW_7094ZHENGJIA&tab=vip&back=1&view=half&style=halfview";

    /* renamed from: d, reason: collision with root package name */
    public boolean f430272d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: qx2.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static class C11101a {

        /* renamed from: a, reason: collision with root package name */
        static a f430273a = new a();
    }

    a() {
    }

    public static a c() {
        return C11101a.f430273a;
    }

    private void h() {
        this.f430269a = s();
    }

    private boolean s() {
        if (b() < 2) {
            return true;
        }
        return false;
    }

    public boolean a() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("tvideo_binge_watch_enable", true);
    }

    public int b() {
        return k.a().e("tvideo_fullscreen_animation_play_count_key", 0);
    }

    public boolean d(String str, int i3) {
        if (k.a().e("tvideo_config_has_show_channel_reddot_prefixe_" + str, -1) == i3) {
            return true;
        }
        return false;
    }

    public boolean e() {
        return k.a().c("tvideo_has_show_h5_privacy", false);
    }

    public void f() {
        r(b() + 1);
    }

    public void g() {
        h();
    }

    public boolean i() {
        if (this.f430269a && s()) {
            return true;
        }
        return false;
    }

    public boolean j() {
        return k.a().c("tvideo_has_pay_vip_from_h5", false);
    }

    public boolean k() {
        return this.f430270b;
    }

    public boolean l() {
        return k.a().c("tvideo_sp_is_show_next_guide_key", true);
    }

    public void m() {
        this.f430269a = false;
        r(2);
    }

    public void n(boolean z16) {
        k.a().j("tvideo_has_pay_vip_from_h5", z16);
    }

    public void o(String str, int i3) {
        k.a().m("tvideo_config_has_show_channel_reddot_prefixe_" + str, i3);
    }

    public void p(boolean z16) {
        k.a().j("tvideo_has_show_h5_privacy", z16);
    }

    public void q(boolean z16) {
        this.f430269a = z16;
    }

    public void r(int i3) {
        k.a().m("tvideo_fullscreen_animation_play_count_key", i3);
    }
}
