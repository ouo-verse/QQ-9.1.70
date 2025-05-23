package rn2;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    public static b f431742c = new b();

    /* renamed from: a, reason: collision with root package name */
    public long f431743a = 0;

    /* renamed from: b, reason: collision with root package name */
    public Map<Long, WeakReference<Object>> f431744b = new ConcurrentHashMap();

    b() {
    }

    public static b b() {
        return f431742c;
    }

    public synchronized long a(Object obj) {
        if (obj == null) {
            return Long.MIN_VALUE;
        }
        long j3 = this.f431743a;
        this.f431743a = 1 + j3;
        this.f431744b.put(Long.valueOf(j3), new WeakReference<>(obj));
        return j3;
    }

    public synchronized Object c(long j3) {
        WeakReference<Object> weakReference = this.f431744b.get(Long.valueOf(j3));
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }
}
