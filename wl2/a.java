package wl2;

/* compiled from: P */
/* loaded from: classes36.dex */
public abstract class a<T, P> {

    /* renamed from: a, reason: collision with root package name */
    private volatile T f445792a;

    protected abstract T a(P p16);

    public final T b(P p16) {
        if (this.f445792a == null) {
            synchronized (this) {
                if (this.f445792a == null) {
                    this.f445792a = a(p16);
                }
            }
        }
        return this.f445792a;
    }
}
