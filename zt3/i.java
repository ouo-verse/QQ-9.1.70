package zt3;

import com.tencent.qqlive.superplayer.vinfo.vod.TVKCGIVideoInfo;
import com.tencent.qqlive.superplayer.vinfo.vod.TVKCGIVideoInfoBuilder;
import org.w3c.dom.Document;
import zt3.c;
import zt3.d;

/* compiled from: P */
/* loaded from: classes22.dex */
public class i {

    /* renamed from: j, reason: collision with root package name */
    private static volatile int f453393j = 2000000;

    /* renamed from: a, reason: collision with root package name */
    private int f453394a;

    /* renamed from: b, reason: collision with root package name */
    private h f453395b;

    /* renamed from: c, reason: collision with root package name */
    private xt3.c f453396c;

    /* renamed from: d, reason: collision with root package name */
    private zt3.b f453397d;

    /* renamed from: e, reason: collision with root package name */
    private e f453398e;

    /* renamed from: f, reason: collision with root package name */
    private TVKCGIVideoInfo f453399f;

    /* renamed from: g, reason: collision with root package name */
    private TVKCGIVideoInfoBuilder f453400g;

    /* renamed from: h, reason: collision with root package name */
    private xt3.a f453401h = new a();

    /* renamed from: i, reason: collision with root package name */
    private xt3.b f453402i = new b();

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements xt3.a {
        a() {
        }

        @Override // xt3.a
        public void a(String str, String str2, Document document) {
            i iVar = i.this;
            iVar.f453399f = iVar.f453400g.W(document);
            i.this.f453400g.j0(str2);
            if (i.this.f453400g.D() > 0) {
                int D = i.this.f453400g.D() + 1300000;
                i.this.f453396c.b(i.this.f453394a, 101, String.format("%d;%d.%d", 101, Integer.valueOf(D), Integer.valueOf(i.this.f453400g.E())), D, str2);
            } else {
                if (i.this.f453400g.C() == 1 && i.this.f453400g.B() > 1 && i.this.f453400g.N() != 8) {
                    i.this.i();
                    return;
                }
                i.this.f453400g.u(i.this.f453395b.q());
                i.this.f453399f.s1(i.this.f453400g.O());
                i.this.f453399f.x1(i.this.f453400g.P());
                i.this.f453396c.a(i.this.f453394a, yt3.e.i(i.this.f453399f, i.this.f453395b));
            }
        }

        @Override // xt3.a
        public void b(String str, String str2, int i3) {
            i.this.f453396c.b(i.this.f453394a, 101, str2, i3, null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class b implements xt3.b {
        b() {
        }

        @Override // xt3.b
        public void a(String str, String str2, int i3) {
            i.this.f453396c.b(i.this.f453394a, 103, str2, i3, null);
        }

        @Override // xt3.b
        public void b(String str, String str2, Document document) {
            i.this.f453400g.h0(document);
            if (i.this.f453400g.D() > 0) {
                int D = i.this.f453400g.D() + 1300200;
                i.this.f453396c.b(i.this.f453394a, 103, String.format("%d;%d.%d", 103, Integer.valueOf(D), Integer.valueOf(i.this.f453400g.E())), D, null);
            } else {
                if (i.this.f453400g.B() != i.this.f453400g.Q()) {
                    i.this.i();
                    return;
                }
                i.this.f453400g.u(i.this.f453395b.q());
                i.this.f453399f.s1(i.this.f453400g.O());
                i.this.f453399f.x1(i.this.f453400g.P());
                i.this.f453396c.a(i.this.f453394a, yt3.e.i(i.this.f453399f, i.this.f453395b));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        d K;
        int B = this.f453400g.B();
        int Q = this.f453400g.Q();
        int i3 = Q + 10;
        if (i3 < B) {
            B = i3;
        }
        e eVar = this.f453398e;
        if (eVar != null) {
            eVar.c();
            this.f453398e = null;
        }
        if (this.f453395b.q().isEmpty()) {
            K = new d.b(this.f453395b.r()).O(String.valueOf(this.f453400g.G())).e0(String.valueOf(this.f453400g.R())).R(this.f453395b.i()).X(this.f453395b.o()).Y(Q + 1).N(B).W(0).V(String.valueOf(this.f453394a)).d0(0).Q(this.f453400g.H()).L(this.f453395b.b()).U(this.f453395b.l()).J(this.f453395b.a()).T(this.f453395b.k()).S(this.f453395b.j()).M(this.f453395b.e()).P(this.f453395b.h()).K();
        } else {
            K = new d.b(this.f453395b.r()).O(String.valueOf(this.f453400g.G())).e0(String.valueOf(this.f453400g.R())).R(this.f453395b.i()).X(this.f453395b.o()).Y(Q + 1).N(B).W(0).V(String.valueOf(this.f453394a)).d0(0).Q(this.f453400g.H()).L(this.f453395b.b()).U(this.f453395b.l()).J(this.f453395b.a()).T(this.f453395b.k()).S(this.f453395b.j()).M(this.f453395b.e()).P(this.f453395b.h()).Z(this.f453395b.q()).a0(this.f453400g.I()).b0(this.f453400g.L()).c0(this.f453400g.M()).K();
        }
        e eVar2 = new e(K, this.f453402i);
        this.f453398e = eVar2;
        eVar2.e();
    }

    public int h(h hVar, xt3.c cVar) {
        int i3 = f453393j;
        f453393j = i3 + 1;
        this.f453394a = i3;
        this.f453395b = hVar;
        this.f453396c = cVar;
        TVKCGIVideoInfoBuilder tVKCGIVideoInfoBuilder = new TVKCGIVideoInfoBuilder();
        this.f453400g = tVKCGIVideoInfoBuilder;
        tVKCGIVideoInfoBuilder.i0(hVar);
        zt3.b bVar = new zt3.b(new c.b(this.f453395b.r()).Q(this.f453395b.p()).B(this.f453395b.c()).H(this.f453395b.t()).I(this.f453395b.u()).C(this.f453395b.d()).A(this.f453395b.b()).E(this.f453395b.f()).F(this.f453395b.g()).J(this.f453395b.i()).L(this.f453395b.l()).P(this.f453395b.o()).O(this.f453395b.n()).M(this.f453395b.m()).N(String.valueOf(this.f453394a)).R(this.f453395b.q()).y(this.f453395b.a()).D(this.f453395b.e()).K(this.f453395b.k()).T(this.f453395b.s()).G(this.f453395b.h()).S(true).z(), this.f453401h);
        this.f453397d = bVar;
        bVar.d();
        return this.f453394a;
    }
}
