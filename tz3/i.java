package tz3;

import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import com.tencent.rfw.barrage.data.RFWViewBarrage;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public class i {

    /* renamed from: l, reason: collision with root package name */
    private static volatile k f437930l;

    /* renamed from: m, reason: collision with root package name */
    private static com.tencent.rfw.barrage.data.c f437931m;

    /* renamed from: a, reason: collision with root package name */
    private final vz3.b<Drawable> f437932a;

    /* renamed from: b, reason: collision with root package name */
    private final SparseArray<e> f437933b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f437934c;

    /* renamed from: d, reason: collision with root package name */
    private d f437935d;

    /* renamed from: e, reason: collision with root package name */
    private c f437936e;

    /* renamed from: f, reason: collision with root package name */
    private tz3.a f437937f;

    /* renamed from: g, reason: collision with root package name */
    private List<uz3.f> f437938g;

    /* renamed from: h, reason: collision with root package name */
    private uz3.g f437939h;

    /* renamed from: i, reason: collision with root package name */
    private g f437940i;

    /* renamed from: j, reason: collision with root package name */
    private int f437941j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f437942k;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private boolean f437943a;

        /* renamed from: b, reason: collision with root package name */
        private d f437944b;

        /* renamed from: c, reason: collision with root package name */
        private c f437945c;

        /* renamed from: d, reason: collision with root package name */
        private List<uz3.f> f437946d;

        /* renamed from: e, reason: collision with root package name */
        public tz3.a f437947e;

        /* renamed from: f, reason: collision with root package name */
        private g f437948f;

        /* renamed from: g, reason: collision with root package name */
        private int f437949g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f437950h;

        static /* synthetic */ h d(b bVar) {
            bVar.getClass();
            return null;
        }

        static /* synthetic */ f e(b bVar) {
            bVar.getClass();
            return null;
        }

        static /* synthetic */ tz3.b f(b bVar) {
            bVar.getClass();
            return null;
        }

        public b k(uz3.f fVar) {
            this.f437946d.add(fVar);
            return this;
        }

        public i l() {
            return new i(this);
        }

        public b m(tz3.a aVar) {
            this.f437947e = aVar;
            return this;
        }

        public b n(c cVar) {
            this.f437945c = cVar;
            return this;
        }

        public b o(int i3) {
            this.f437949g = i3;
            return this;
        }

        public b p(d dVar) {
            this.f437944b = dVar;
            return this;
        }

        public b q(g gVar) {
            this.f437948f = gVar;
            return this;
        }

        b() {
            this.f437946d = new ArrayList();
            this.f437950h = false;
        }
    }

    private void a() {
        if (!this.f437934c && this.f437935d == null) {
            throw new IllegalArgumentException("Barrage module need an IBarragePlayTimeSupplier or is live setter for computing timeline");
        }
    }

    public static com.tencent.rfw.barrage.data.c i() {
        if (f437931m == null) {
            synchronized (i.class) {
                if (f437931m == null) {
                    f437931m = new com.tencent.rfw.barrage.data.c();
                }
            }
        }
        return f437931m;
    }

    public static k l() {
        if (f437930l != null) {
            return f437930l;
        }
        synchronized (i.class) {
            k kVar = f437930l;
            if (f437930l == null) {
                f437930l = new k();
            }
        }
        return f437930l;
    }

    private void m(b bVar) {
        ArrayList arrayList = new ArrayList();
        this.f437938g = arrayList;
        arrayList.addAll(bVar.f437946d);
    }

    public static b o() {
        return new b();
    }

    public void b() {
        this.f437932a.e(0);
    }

    public com.tencent.rfw.barrage.data.a c(int i3) {
        com.tencent.rfw.barrage.data.a aVar;
        if (i3 == -2147483647) {
            return new RFWViewBarrage(this);
        }
        tz3.a aVar2 = this.f437937f;
        if (aVar2 != null) {
            aVar = aVar2.a(this, i3);
        } else {
            aVar = null;
        }
        if (aVar == null) {
            return new com.tencent.rfw.barrage.data.b(this);
        }
        return aVar;
    }

    public com.tencent.rfw.barrage.core.a d(i iVar, com.tencent.rfw.barrage.core.f fVar, Comparator<com.tencent.rfw.barrage.data.a> comparator, vz3.c cVar, vz3.a aVar) {
        g gVar = this.f437940i;
        if (gVar != null) {
            return gVar.a(iVar, fVar, comparator, cVar, aVar);
        }
        return new com.tencent.rfw.barrage.core.g(iVar, fVar, comparator, cVar, aVar);
    }

    public uz3.f e(com.tencent.rfw.barrage.data.a aVar) {
        List<uz3.f> f16 = f();
        uz3.f fVar = null;
        if (f16 == null) {
            return null;
        }
        int size = f16.size();
        int i3 = 0;
        while (true) {
            if (i3 < size) {
                uz3.f fVar2 = f16.get(i3);
                if (fVar2 == null) {
                    break;
                }
                if (fVar2.a(aVar)) {
                    fVar = fVar2;
                    break;
                }
                i3++;
            } else {
                break;
            }
        }
        if (fVar == null) {
            return this.f437939h;
        }
        return fVar;
    }

    public List<uz3.f> f() {
        return this.f437938g;
    }

    public e g(int i3) {
        e eVar = this.f437933b.get(i3);
        if (eVar == null) {
            synchronized (i.class) {
                eVar = this.f437933b.get(i3);
            }
        }
        if (eVar == null) {
            return i();
        }
        return eVar;
    }

    public int h() {
        return (int) Math.ceil(wz3.f.d(l()));
    }

    public long j() {
        d dVar = this.f437935d;
        if (dVar == null) {
            return -1L;
        }
        return dVar.a();
    }

    public int k() {
        return this.f437941j;
    }

    public boolean n() {
        if (!this.f437934c && j() >= 0) {
            return false;
        }
        return true;
    }

    public void p(com.tencent.rfw.barrage.data.a aVar) {
        c cVar = this.f437936e;
        if (cVar != null) {
            cVar.a(aVar);
        }
    }

    i(b bVar) {
        this.f437933b = new SparseArray<>();
        this.f437934c = false;
        this.f437939h = new uz3.g();
        this.f437934c = bVar.f437943a;
        this.f437935d = bVar.f437944b;
        this.f437936e = bVar.f437945c;
        b.d(bVar);
        b.e(bVar);
        bVar.getClass();
        this.f437937f = bVar.f437947e;
        b.f(bVar);
        this.f437940i = bVar.f437948f;
        this.f437941j = bVar.f437949g;
        this.f437942k = bVar.f437950h;
        this.f437932a = new vz3.b<>();
        m(bVar);
        a();
    }
}
