package r;

import android.util.Log;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* compiled from: P */
/* loaded from: classes.dex */
public final class i implements r.b {

    /* renamed from: a, reason: collision with root package name */
    private final g<a, Object> f430376a = new g<>();

    /* renamed from: b, reason: collision with root package name */
    private final b f430377b = new b();

    /* renamed from: c, reason: collision with root package name */
    private final Map<Class<?>, NavigableMap<Integer, Integer>> f430378c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private final Map<Class<?>, r.a<?>> f430379d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private final int f430380e;

    /* renamed from: f, reason: collision with root package name */
    private int f430381f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class a implements m {

        /* renamed from: a, reason: collision with root package name */
        private final b f430382a;

        /* renamed from: b, reason: collision with root package name */
        int f430383b;

        /* renamed from: c, reason: collision with root package name */
        private Class<?> f430384c;

        a(b bVar) {
            this.f430382a = bVar;
        }

        @Override // r.m
        public void a() {
            this.f430382a.c(this);
        }

        void b(int i3, Class<?> cls) {
            this.f430383b = i3;
            this.f430384c = cls;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f430383b != aVar.f430383b || this.f430384c != aVar.f430384c) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i3;
            int i16 = this.f430383b * 31;
            Class<?> cls = this.f430384c;
            if (cls != null) {
                i3 = cls.hashCode();
            } else {
                i3 = 0;
            }
            return i16 + i3;
        }

        public String toString() {
            return "Key{size=" + this.f430383b + "array=" + this.f430384c + '}';
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static final class b extends c<a> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // r.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public a a() {
            return new a(this);
        }

        a e(int i3, Class<?> cls) {
            a b16 = b();
            b16.b(i3, cls);
            return b16;
        }
    }

    public i(int i3) {
        this.f430380e = i3;
    }

    private void d(int i3, Class<?> cls) {
        NavigableMap<Integer, Integer> k3 = k(cls);
        Integer num = k3.get(Integer.valueOf(i3));
        if (num != null) {
            if (num.intValue() == 1) {
                k3.remove(Integer.valueOf(i3));
                return;
            } else {
                k3.put(Integer.valueOf(i3), Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + i3 + ", this: " + this);
    }

    private void e() {
        f(this.f430380e);
    }

    private void f(int i3) {
        while (this.f430381f > i3) {
            Object f16 = this.f430376a.f();
            h0.j.d(f16);
            r.a g16 = g(f16);
            this.f430381f -= g16.a(f16) * g16.b();
            d(g16.a(f16), f16.getClass());
            if (Log.isLoggable(g16.getTag(), 2)) {
                Log.v(g16.getTag(), "evicted: " + g16.a(f16));
            }
        }
    }

    private <T> r.a<T> g(T t16) {
        return h(t16.getClass());
    }

    private <T> r.a<T> h(Class<T> cls) {
        r.a<T> aVar = (r.a) this.f430379d.get(cls);
        if (aVar == null) {
            if (cls.equals(int[].class)) {
                aVar = new h();
            } else if (cls.equals(byte[].class)) {
                aVar = new f();
            } else {
                throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
            }
            this.f430379d.put(cls, aVar);
        }
        return aVar;
    }

    @Nullable
    private <T> T i(a aVar) {
        return (T) this.f430376a.a(aVar);
    }

    private <T> T j(a aVar, Class<T> cls) {
        r.a<T> h16 = h(cls);
        T t16 = (T) i(aVar);
        if (t16 != null) {
            this.f430381f -= h16.a(t16) * h16.b();
            d(h16.a(t16), cls);
        }
        if (t16 == null) {
            if (Log.isLoggable(h16.getTag(), 2)) {
                Log.v(h16.getTag(), "Allocated " + aVar.f430383b + " bytes");
            }
            return h16.newArray(aVar.f430383b);
        }
        return t16;
    }

    private NavigableMap<Integer, Integer> k(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.f430378c.get(cls);
        if (navigableMap == null) {
            TreeMap treeMap = new TreeMap();
            this.f430378c.put(cls, treeMap);
            return treeMap;
        }
        return navigableMap;
    }

    private boolean l() {
        int i3 = this.f430381f;
        if (i3 != 0 && this.f430380e / i3 < 2) {
            return false;
        }
        return true;
    }

    private boolean m(int i3) {
        if (i3 <= this.f430380e / 2) {
            return true;
        }
        return false;
    }

    private boolean n(int i3, Integer num) {
        if (num != null && (l() || num.intValue() <= i3 * 8)) {
            return true;
        }
        return false;
    }

    @Override // r.b
    public synchronized void a() {
        f(0);
    }

    @Override // r.b
    public synchronized <T> T b(int i3, Class<T> cls) {
        a e16;
        Integer ceilingKey = k(cls).ceilingKey(Integer.valueOf(i3));
        if (n(i3, ceilingKey)) {
            e16 = this.f430377b.e(ceilingKey.intValue(), cls);
        } else {
            e16 = this.f430377b.e(i3, cls);
        }
        return (T) j(e16, cls);
    }

    @Override // r.b
    public synchronized <T> T c(int i3, Class<T> cls) {
        return (T) j(this.f430377b.e(i3, cls), cls);
    }

    @Override // r.b
    public synchronized <T> void put(T t16) {
        Class<?> cls = t16.getClass();
        r.a<T> h16 = h(cls);
        int a16 = h16.a(t16);
        int b16 = h16.b() * a16;
        if (!m(b16)) {
            return;
        }
        a e16 = this.f430377b.e(a16, cls);
        this.f430376a.d(e16, t16);
        NavigableMap<Integer, Integer> k3 = k(cls);
        Integer num = k3.get(Integer.valueOf(e16.f430383b));
        Integer valueOf = Integer.valueOf(e16.f430383b);
        int i3 = 1;
        if (num != null) {
            i3 = 1 + num.intValue();
        }
        k3.put(valueOf, Integer.valueOf(i3));
        this.f430381f += b16;
        e();
    }

    @Override // r.b
    public synchronized void trimMemory(int i3) {
        try {
            if (i3 >= 40) {
                a();
            } else if (i3 >= 20 || i3 == 15) {
                f(this.f430380e / 2);
            }
        } catch (Throwable th5) {
            throw th5;
        }
    }
}
