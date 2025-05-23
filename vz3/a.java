package vz3;

import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicLong f443779a = new AtomicLong(0);

    /* renamed from: b, reason: collision with root package name */
    private final AtomicLong f443780b = new AtomicLong(0);

    /* renamed from: c, reason: collision with root package name */
    private final AtomicLong f443781c = new AtomicLong(0);

    public long a() {
        return this.f443779a.get();
    }

    public long b() {
        return this.f443780b.get();
    }

    public void c() {
        this.f443779a.set(0L);
        this.f443780b.set(0L);
    }

    public void d(long j3) {
        this.f443779a.set(j3);
    }

    public long e() {
        this.f443780b.set(SystemClock.uptimeMillis() - this.f443781c.get());
        AtomicLong atomicLong = this.f443779a;
        atomicLong.set(atomicLong.get() + this.f443780b.get());
        f();
        return this.f443780b.get();
    }

    public void f() {
        this.f443781c.set(SystemClock.uptimeMillis());
    }
}
