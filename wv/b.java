package wv;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b implements wv.a {

    /* renamed from: a, reason: collision with root package name */
    private int f446554a = 0;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final b f446555a = new b();
    }

    b() {
    }

    public static b b() {
        return a.f446555a;
    }

    public int a() {
        return this.f446554a;
    }

    public void c() {
        this.f446554a = 0;
    }

    @Override // wv.a
    public void onDraw() {
        this.f446554a++;
    }
}
