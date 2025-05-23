package sr1;

import android.view.ViewGroup;

/* compiled from: P */
/* loaded from: classes14.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private h f434309a;

    /* renamed from: b, reason: collision with root package name */
    private ViewGroup f434310b;

    /* renamed from: c, reason: collision with root package name */
    private ViewGroup f434311c;

    /* renamed from: d, reason: collision with root package name */
    private ViewGroup f434312d;

    public b(h hVar) {
        this.f434309a = hVar;
        e(hVar);
    }

    private void e(h hVar) {
        this.f434310b = hVar.f();
        this.f434311c = hVar.b();
        this.f434312d = hVar.d();
    }

    public ViewGroup a() {
        return this.f434311c;
    }

    public h b() {
        return this.f434309a;
    }

    public ViewGroup c() {
        return this.f434312d;
    }

    public ViewGroup d() {
        return this.f434310b;
    }
}
