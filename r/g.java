package r;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import r.m;

/* compiled from: P */
/* loaded from: classes.dex */
class g<K extends m, V> {

    /* renamed from: a, reason: collision with root package name */
    private final a<K, V> f430370a = new a<>();

    /* renamed from: b, reason: collision with root package name */
    private final Map<K, a<K, V>> f430371b = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class a<K, V> {

        /* renamed from: a, reason: collision with root package name */
        final K f430372a;

        /* renamed from: b, reason: collision with root package name */
        private List<V> f430373b;

        /* renamed from: c, reason: collision with root package name */
        a<K, V> f430374c;

        /* renamed from: d, reason: collision with root package name */
        a<K, V> f430375d;

        a() {
            this(null);
        }

        public void a(V v3) {
            if (this.f430373b == null) {
                this.f430373b = new ArrayList();
            }
            this.f430373b.add(v3);
        }

        @Nullable
        public V b() {
            int c16 = c();
            if (c16 > 0) {
                return this.f430373b.remove(c16 - 1);
            }
            return null;
        }

        public int c() {
            List<V> list = this.f430373b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        a(K k3) {
            this.f430375d = this;
            this.f430374c = this;
            this.f430372a = k3;
        }
    }

    private void b(a<K, V> aVar) {
        e(aVar);
        a<K, V> aVar2 = this.f430370a;
        aVar.f430375d = aVar2;
        aVar.f430374c = aVar2.f430374c;
        g(aVar);
    }

    private void c(a<K, V> aVar) {
        e(aVar);
        a<K, V> aVar2 = this.f430370a;
        aVar.f430375d = aVar2.f430375d;
        aVar.f430374c = aVar2;
        g(aVar);
    }

    private static <K, V> void e(a<K, V> aVar) {
        a<K, V> aVar2 = aVar.f430375d;
        aVar2.f430374c = aVar.f430374c;
        aVar.f430374c.f430375d = aVar2;
    }

    private static <K, V> void g(a<K, V> aVar) {
        aVar.f430374c.f430375d = aVar;
        aVar.f430375d.f430374c = aVar;
    }

    @Nullable
    public V a(K k3) {
        a<K, V> aVar = this.f430371b.get(k3);
        if (aVar == null) {
            aVar = new a<>(k3);
            this.f430371b.put(k3, aVar);
        } else {
            k3.a();
        }
        b(aVar);
        return aVar.b();
    }

    public void d(K k3, V v3) {
        a<K, V> aVar = this.f430371b.get(k3);
        if (aVar == null) {
            aVar = new a<>(k3);
            c(aVar);
            this.f430371b.put(k3, aVar);
        } else {
            k3.a();
        }
        aVar.a(v3);
    }

    @Nullable
    public V f() {
        for (a aVar = this.f430370a.f430375d; !aVar.equals(this.f430370a); aVar = aVar.f430375d) {
            V v3 = (V) aVar.b();
            if (v3 != null) {
                return v3;
            }
            e(aVar);
            this.f430371b.remove(aVar.f430372a);
            ((m) aVar.f430372a).a();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder("GroupedLinkedMap( ");
        a aVar = this.f430370a.f430374c;
        boolean z16 = false;
        while (!aVar.equals(this.f430370a)) {
            sb5.append('{');
            sb5.append(aVar.f430372a);
            sb5.append(':');
            sb5.append(aVar.c());
            sb5.append("}, ");
            aVar = aVar.f430374c;
            z16 = true;
        }
        if (z16) {
            sb5.delete(sb5.length() - 2, sb5.length());
        }
        sb5.append(" )");
        return sb5.toString();
    }
}
