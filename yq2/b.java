package yq2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    protected String f451004a = getClass().getSimpleName();

    /* renamed from: b, reason: collision with root package name */
    private a<Integer, c> f451005b = new a<>();

    /* compiled from: P */
    /* loaded from: classes18.dex */
    private class a<K, V> {

        /* renamed from: a, reason: collision with root package name */
        private HashMap<K, CopyOnWriteArrayList<V>> f451006a = new HashMap<>();

        public a() {
        }

        public void a() {
            HashMap<K, CopyOnWriteArrayList<V>> hashMap = this.f451006a;
            if (hashMap != null) {
                hashMap.clear();
            }
        }

        public CopyOnWriteArrayList<V> b(K k3) {
            return this.f451006a.get(k3);
        }

        public void c(K k3, V v3) {
            CopyOnWriteArrayList<V> copyOnWriteArrayList = this.f451006a.get(k3);
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                this.f451006a.put(k3, copyOnWriteArrayList);
            }
            if (!copyOnWriteArrayList.contains(v3)) {
                copyOnWriteArrayList.add(v3);
            }
        }

        public void d(V v3) {
            for (Map.Entry<K, CopyOnWriteArrayList<V>> entry : this.f451006a.entrySet()) {
                CopyOnWriteArrayList<V> value = entry.getValue();
                int i3 = 0;
                while (i3 < value.size()) {
                    V v16 = value.get(i3);
                    if (v16 != v3 && (v16 == null || !v16.equals(v3))) {
                        i3++;
                    } else {
                        entry.getValue().remove(v3);
                    }
                }
            }
        }
    }

    public synchronized void a(c cVar, int... iArr) {
        for (int i3 : iArr) {
            this.f451005b.c(Integer.valueOf(i3), cVar);
        }
    }

    public synchronized void b() {
        a<Integer, c> aVar = this.f451005b;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void c(int i3, Object... objArr) {
        CopyOnWriteArrayList<c> b16;
        synchronized (this) {
            b16 = this.f451005b.b(Integer.valueOf(i3));
        }
        if (b16 != null && !b16.isEmpty()) {
            Iterator<c> it = b16.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next != null) {
                    next.notify(this, i3, objArr);
                }
            }
        }
    }

    public synchronized void d(int i3) {
        CopyOnWriteArrayList<c> b16 = this.f451005b.b(Integer.valueOf(i3));
        if (b16 != null) {
            b16.clear();
        }
    }

    public synchronized void e(c cVar) {
        this.f451005b.d(cVar);
    }
}
