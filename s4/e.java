package s4;

import android.view.View;

/* compiled from: P */
/* loaded from: classes36.dex */
public class e {

    /* renamed from: b, reason: collision with root package name */
    private View f433299b;

    /* renamed from: c, reason: collision with root package name */
    private View f433300c;

    /* renamed from: g, reason: collision with root package name */
    private a f433304g;

    /* renamed from: d, reason: collision with root package name */
    private int f433301d = -1;

    /* renamed from: e, reason: collision with root package name */
    private float f433302e = -1.0f;

    /* renamed from: f, reason: collision with root package name */
    private int f433303f = -1;

    /* renamed from: i, reason: collision with root package name */
    public boolean f433306i = false;

    /* renamed from: j, reason: collision with root package name */
    public boolean f433307j = true;

    /* renamed from: h, reason: collision with root package name */
    private int[] f433305h = new int[2];

    /* renamed from: a, reason: collision with root package name */
    private int f433298a = hashCode();

    /* compiled from: P */
    /* loaded from: classes36.dex */
    public interface a {
        float a(int i3, int i16, int i17);

        boolean b(int i3, int i16, int i17);

        void c(View view, float f16, int i3, float f17);
    }

    public e(View view, View view2) {
        this.f433299b = view;
        this.f433300c = view2;
    }

    public boolean a(int i3) {
        int i16;
        int i17;
        a aVar = this.f433304g;
        if (aVar == null || (i16 = this.f433301d) <= 0 || (i17 = this.f433303f) <= 0) {
            return false;
        }
        return aVar.b(i3, i16, i17);
    }

    public boolean b() {
        return (this.f433299b == null || this.f433300c == null) ? false : true;
    }

    public float c(int i3) {
        a aVar = this.f433304g;
        if (aVar == null || !this.f433307j) {
            return 0.0f;
        }
        return aVar.a(i3, this.f433301d, this.f433303f);
    }

    public void d(float f16) {
        View view;
        int i3;
        a aVar = this.f433304g;
        if (aVar == null || (view = this.f433300c) == null || (i3 = this.f433303f) <= 0 || !this.f433307j) {
            return;
        }
        aVar.c(view, f16, i3, this.f433302e);
    }

    public void e(a aVar) {
        this.f433304g = aVar;
    }

    public void f() {
        View view = this.f433299b;
        if (view != null) {
            if (this.f433301d > 0 && this.f433303f > 0) {
                this.f433306i = true;
                return;
            }
            view.getLocationOnScreen(this.f433305h);
            int height = this.f433299b.getHeight();
            int i3 = this.f433305h[1];
            if (i3 > 0 && height > 0) {
                this.f433301d = i3;
                this.f433303f = height;
                this.f433302e = this.f433299b.getTranslationY();
                this.f433306i = true;
                return;
            }
            this.f433306i = false;
            return;
        }
        this.f433306i = false;
    }

    public int hashCode() {
        if (b()) {
            return (this.f433299b.getId() * 31) + this.f433300c.getId();
        }
        return super.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.f433298a == ((e) obj).f433298a;
    }
}
