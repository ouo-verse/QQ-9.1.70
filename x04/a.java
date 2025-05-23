package x04;

import java.io.Closeable;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a implements Closeable {

    /* renamed from: d, reason: collision with root package name */
    private final shark.b f446839d;

    /* renamed from: e, reason: collision with root package name */
    private final Map<String, Set<Long>> f446840e;

    public shark.b a() {
        return this.f446839d;
    }

    public void b(String str, Set<Long> set) {
        this.f446840e.put(str, set);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
