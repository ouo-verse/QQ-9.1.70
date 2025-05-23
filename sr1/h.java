package sr1;

import android.view.ViewGroup;

/* compiled from: P */
/* loaded from: classes14.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private c f434329a;

    /* renamed from: b, reason: collision with root package name */
    private final com.tencent.mobileqq.guild.mainframe.i f434330b;

    /* renamed from: c, reason: collision with root package name */
    private final ViewGroup f434331c;

    /* renamed from: d, reason: collision with root package name */
    private final ViewGroup f434332d;

    /* renamed from: e, reason: collision with root package name */
    private final ViewGroup f434333e;

    public h(com.tencent.mobileqq.guild.mainframe.i iVar, ViewGroup viewGroup, ViewGroup viewGroup2, ViewGroup viewGroup3) {
        this.f434331c = viewGroup;
        this.f434332d = viewGroup2;
        this.f434333e = viewGroup3;
        this.f434330b = iVar;
        k();
    }

    private void k() {
        this.f434329a = new c(this);
    }

    public a a() {
        return (a) c(c.f434316e);
    }

    public ViewGroup b() {
        return this.f434332d;
    }

    public b c(int i3) {
        return this.f434329a.a(i3);
    }

    public ViewGroup d() {
        return this.f434333e;
    }

    public k e() {
        return (k) c(c.f434314c);
    }

    public ViewGroup f() {
        return this.f434331c;
    }

    public com.tencent.mobileqq.guild.mainframe.i g() {
        return this.f434330b;
    }

    public i h() {
        return (i) c(c.f434315d);
    }

    public j i() {
        return (j) c(c.f434318g);
    }

    public l j() {
        return (l) c(c.f434317f);
    }

    public boolean l() {
        return ((j) c(c.f434318g)).t();
    }

    public void m(boolean z16) {
        ((j) c(c.f434318g)).u(z16);
    }
}
