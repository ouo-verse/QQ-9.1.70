package pz;

import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import UserGrowth.stSimpleMetaFeed;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.weishi.drama.g;
import com.tencent.biz.pubaccount.weishi.player.i;

/* compiled from: P */
/* loaded from: classes36.dex */
public abstract class b extends a {

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.biz.pubaccount.weishi.player.e f428079h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.biz.pubaccount.weishi.player.a f428080i;

    public b(ViewGroup viewGroup, int i3, int i16, com.tencent.biz.pubaccount.weishi.drama.c cVar) {
        super(viewGroup, i3, i16, cVar);
    }

    private int f(stSimpleMetaFeed stsimplemetafeed) {
        ViewGroup m3 = m();
        ImageView l3 = l();
        stMetaUgcVideoSeg stmetaugcvideoseg = stsimplemetafeed.video;
        return i.g(null, new i.d(m3, l3, stmetaugcvideoseg.width, stmetaugcvideoseg.height, j(), h()));
    }

    private qz.c k() {
        com.tencent.biz.pubaccount.weishi.baseui.c<mz.d> cVar = this.f428077e;
        if (cVar instanceof c) {
            return ((c) cVar).i();
        }
        return null;
    }

    private ImageView l() {
        qz.c k3 = k();
        if (k3 != null) {
            return k3.A();
        }
        return null;
    }

    private int n(stSimpleMetaFeed stsimplemetafeed) {
        return f(stsimplemetafeed);
    }

    @Override // pz.a, com.tencent.widget.pull2refresh.BaseViewHolder
    /* renamed from: b */
    public void bindData(mz.d dVar) {
        super.bindData(dVar);
        com.tencent.biz.pubaccount.weishi.drama.c d16 = d();
        if (d16 != null) {
            g(dVar.i(), getLayoutPosition() - 1, d16.getFrom());
        }
    }

    @Override // pz.a
    public void e(int i3) {
        super.e(i3);
        com.tencent.biz.pubaccount.weishi.drama.c d16 = d();
        if (d16 == null || d16.U0() == null) {
            return;
        }
        d16.U0().R0(o());
        d16.U0().Q0(o());
    }

    public int h() {
        return 0;
    }

    public com.tencent.biz.pubaccount.weishi.player.e i() {
        return this.f428079h;
    }

    public int j() {
        return 0;
    }

    public ViewGroup m() {
        qz.c k3 = k();
        if (k3 != null) {
            return k3.B();
        }
        return null;
    }

    protected boolean o() {
        return false;
    }

    public void p(com.tencent.biz.pubaccount.weishi.player.e eVar) {
        this.f428079h = eVar;
    }

    public void g(stSimpleMetaFeed stsimplemetafeed, int i3, String str) {
        com.tencent.biz.pubaccount.weishi.player.e i16;
        if (stsimplemetafeed == null) {
            p(null);
            return;
        }
        if (i() == null) {
            i16 = new com.tencent.biz.pubaccount.weishi.player.e();
        } else {
            i16 = i();
        }
        com.tencent.biz.pubaccount.weishi.player.a aVar = this.f428080i;
        if (aVar == null) {
            aVar = new g(this);
        }
        i16.f81136l = aVar;
        i16.f81127c = x10.a.a(stsimplemetafeed);
        i16.f81125a = m();
        i16.f81130f = n(stsimplemetafeed);
        i16.f81132h = 0L;
        i16.f81134j = true;
        i16.f81131g = i3;
        i16.f81135k = "drama_preview";
        this.f428080i = i16.f81136l;
        p(i16);
    }
}
