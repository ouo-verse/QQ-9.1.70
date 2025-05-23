package sz;

import UserGrowth.stDramaFeed;
import UserGrowth.stDramaInfo;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.d;
import java.util.List;
import kz.g;
import mqq.util.WeakReference;
import nz.f;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b implements d {

    /* renamed from: d, reason: collision with root package name */
    private final WeakReference<nz.b> f435000d;

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class a implements jz.c<f> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ nz.b f435001d;

        a(nz.b bVar) {
            this.f435001d = bVar;
        }

        @Override // jz.c
        public void d0(List<f> list, boolean z16, boolean z17, Object obj) {
            this.f435001d.Uc(list, (stDramaInfo) obj);
        }

        @Override // jz.c
        public void i(int i3, String str, boolean z16, boolean z17) {
            this.f435001d.O0(i3, str);
        }
    }

    /* compiled from: P */
    /* renamed from: sz.b$b, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    class C11261b implements kz.a<stDramaFeed> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ nz.b f435003a;

        C11261b(nz.b bVar) {
            this.f435003a = bVar;
        }

        @Override // kz.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(stDramaFeed stdramafeed) {
            this.f435003a.Df(stdramafeed);
        }

        @Override // kz.a
        public void onFailure(int i3, String str) {
            this.f435003a.O0(i3, str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class c implements kz.a<stDramaFeed> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ nz.b f435005a;

        c(nz.b bVar) {
            this.f435005a = bVar;
        }

        @Override // kz.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(stDramaFeed stdramafeed) {
            this.f435005a.l6(stdramafeed);
        }

        @Override // kz.a
        public void onFailure(int i3, String str) {
            this.f435005a.O0(i3, str);
        }
    }

    public b(nz.b bVar) {
        this.f435000d = new WeakReference<>(bVar);
    }

    public void O() {
        nz.b x16 = x();
        if (x16 == null) {
            return;
        }
        kz.c.d().b(x16.k0(), new a(x16));
    }

    public void P(boolean z16, String str, int i3) {
        nz.b x16 = x();
        if (x16 == null) {
            return;
        }
        g gVar = new g(x16.k0(), str, i3, -1);
        gVar.n(true);
        kz.c.d().g(gVar, new C11261b(x16));
    }

    public void R(String str, int i3) {
        nz.b x16 = x();
        if (x16 == null || TextUtils.isEmpty(str)) {
            return;
        }
        kz.c.d().g(new g(x16.k0(), str, i3, -1), new c(x16));
    }

    public nz.b x() {
        return this.f435000d.get();
    }

    @Override // com.tencent.biz.pubaccount.weishi.d
    public void destroy() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.d
    public void detachView() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.d
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void attachView(nz.b bVar) {
    }
}
