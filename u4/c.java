package u4;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

/* compiled from: P */
/* loaded from: classes36.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    private static c f438206a;

    public static c a() {
        if (f438206a == null) {
            com.qzone.album.env.common.b.a();
        }
        return f438206a;
    }

    public static void j(c cVar) {
        f438206a = cVar;
    }

    public abstract void A(Activity activity, int i3);

    public abstract void B(Activity activity, String str);

    public abstract void C(Activity activity);

    public abstract Intent b(Activity activity);

    public abstract int c(Activity activity);

    public abstract int d(Activity activity);

    public abstract int e(Activity activity);

    public abstract int f(Activity activity);

    public abstract String g(Activity activity);

    public abstract void h(Activity activity, int i3, int i16);

    public abstract void i(Activity activity);

    public abstract boolean k(Activity activity);

    public abstract void l(Activity activity);

    public abstract void m(Activity activity);

    public abstract void n(Activity activity);

    public abstract void o(Activity activity);

    public abstract void p(Activity activity);

    public abstract void q(Activity activity);

    public abstract void r(String str, String str2, String str3);

    public abstract void s(Activity activity, View.OnClickListener onClickListener);

    public abstract void t(Activity activity, String str);

    public abstract void u(Activity activity, int i3);

    public abstract void v(Activity activity, int i3);

    public abstract void w(Activity activity, int i3);

    public abstract void x(Activity activity, View.OnClickListener onClickListener);

    public abstract void y(Activity activity, int i3, int i16, int i17, int i18);

    public abstract void z(Activity activity, String str);
}
