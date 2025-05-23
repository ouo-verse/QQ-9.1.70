package q1;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.j;
import com.google.common.base.p;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.logging.Level;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public final class e implements Closeable {

    /* renamed from: h, reason: collision with root package name */
    private static final c f428171h;

    /* renamed from: d, reason: collision with root package name */
    @VisibleForTesting
    final c f428172d;

    /* renamed from: e, reason: collision with root package name */
    private final Deque<Closeable> f428173e = new ArrayDeque(4);

    /* renamed from: f, reason: collision with root package name */
    @MonotonicNonNullDecl
    private Throwable f428174f;

    /* compiled from: P */
    @VisibleForTesting
    /* loaded from: classes2.dex */
    static final class a implements c {

        /* renamed from: a, reason: collision with root package name */
        static final a f428175a = new a();

        a() {
        }

        @Override // q1.e.c
        public void a(Closeable closeable, Throwable th5, Throwable th6) {
            d.f428170a.log(Level.WARNING, "Suppressing exception thrown when closing " + closeable, th6);
        }
    }

    /* compiled from: P */
    @VisibleForTesting
    /* loaded from: classes2.dex */
    static final class b implements c {

        /* renamed from: a, reason: collision with root package name */
        static final b f428176a = new b();

        /* renamed from: b, reason: collision with root package name */
        static final Method f428177b = b();

        b() {
        }

        private static Method b() {
            try {
                return Throwable.class.getMethod("addSuppressed", Throwable.class);
            } catch (Throwable unused) {
                return null;
            }
        }

        static boolean c() {
            if (f428177b != null) {
                return true;
            }
            return false;
        }

        @Override // q1.e.c
        public void a(Closeable closeable, Throwable th5, Throwable th6) {
            if (th5 == th6) {
                return;
            }
            try {
                f428177b.invoke(th5, th6);
            } catch (Throwable unused) {
                a.f428175a.a(closeable, th5, th6);
            }
        }
    }

    /* compiled from: P */
    @VisibleForTesting
    /* loaded from: classes2.dex */
    interface c {
        void a(Closeable closeable, Throwable th5, Throwable th6);
    }

    static {
        c cVar;
        if (b.c()) {
            cVar = b.f428176a;
        } else {
            cVar = a.f428175a;
        }
        f428171h = cVar;
    }

    @VisibleForTesting
    e(c cVar) {
        this.f428172d = (c) j.m(cVar);
    }

    public static e a() {
        return new e(f428171h);
    }

    @CanIgnoreReturnValue
    public <C extends Closeable> C b(@NullableDecl C c16) {
        if (c16 != null) {
            this.f428173e.addFirst(c16);
        }
        return c16;
    }

    public RuntimeException c(Throwable th5) throws IOException {
        j.m(th5);
        this.f428174f = th5;
        p.h(th5, IOException.class);
        throw new RuntimeException(th5);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Throwable th5 = this.f428174f;
        while (!this.f428173e.isEmpty()) {
            Closeable removeFirst = this.f428173e.removeFirst();
            try {
                removeFirst.close();
            } catch (Throwable th6) {
                if (th5 == null) {
                    th5 = th6;
                } else {
                    this.f428172d.a(removeFirst, th5, th6);
                }
            }
        }
        if (this.f428174f == null && th5 != null) {
            p.h(th5, IOException.class);
            throw new AssertionError(th5);
        }
    }
}
