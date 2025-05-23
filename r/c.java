package r;

import java.util.Queue;
import r.m;

/* compiled from: P */
/* loaded from: classes.dex */
abstract class c<T extends m> {

    /* renamed from: a, reason: collision with root package name */
    private final Queue<T> f430369a = h0.k.e(20);

    abstract T a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public T b() {
        T poll = this.f430369a.poll();
        if (poll == null) {
            return a();
        }
        return poll;
    }

    public void c(T t16) {
        if (this.f430369a.size() < 20) {
            this.f430369a.offer(t16);
        }
    }
}
