package vb2;

import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class b implements ub2.a {

    /* renamed from: f, reason: collision with root package name */
    private static boolean f441331f = false;

    /* renamed from: h, reason: collision with root package name */
    private static volatile b f441332h;

    /* renamed from: d, reason: collision with root package name */
    private List<c> f441333d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private ub2.a f441334e;

    public static b c() {
        if (f441332h == null) {
            synchronized (b.class) {
                if (f441332h == null) {
                    f441332h = new b();
                }
            }
        }
        return f441332h;
    }

    public List<c> b() {
        return this.f441333d;
    }

    public void d() {
        this.f441333d.clear();
        this.f441334e = null;
        f441332h = null;
    }

    public void e() {
        if (!f441331f) {
            return;
        }
        new a().c(this);
    }

    public void f(ub2.a aVar) {
        this.f441334e = aVar;
    }

    @Override // ub2.a
    public void g(List<c> list) {
        this.f441333d = list;
        ub2.a aVar = this.f441334e;
        if (aVar != null) {
            aVar.g(list);
        }
    }

    @Override // ub2.a
    public void a(int i3, String str) {
    }
}
