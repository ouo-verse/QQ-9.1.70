package t;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.Registry;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import t.n;

/* compiled from: P */
/* loaded from: classes.dex */
public class r {

    /* renamed from: e, reason: collision with root package name */
    private static final c f435138e = new c();

    /* renamed from: f, reason: collision with root package name */
    private static final n<Object, Object> f435139f = new a();

    /* renamed from: a, reason: collision with root package name */
    private final List<b<?, ?>> f435140a;

    /* renamed from: b, reason: collision with root package name */
    private final c f435141b;

    /* renamed from: c, reason: collision with root package name */
    private final Set<b<?, ?>> f435142c;

    /* renamed from: d, reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f435143d;

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static class a implements n<Object, Object> {
        a() {
        }

        @Override // t.n
        @Nullable
        public n.a<Object> a(@NonNull Object obj, int i3, int i16, @NonNull com.bumptech.glide.load.e eVar) {
            return null;
        }

        @Override // t.n
        public boolean handles(@NonNull Object obj) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class b<Model, Data> {

        /* renamed from: a, reason: collision with root package name */
        private final Class<Model> f435144a;

        /* renamed from: b, reason: collision with root package name */
        final Class<Data> f435145b;

        /* renamed from: c, reason: collision with root package name */
        final o<? extends Model, ? extends Data> f435146c;

        public b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
            this.f435144a = cls;
            this.f435145b = cls2;
            this.f435146c = oVar;
        }

        public boolean a(@NonNull Class<?> cls) {
            return this.f435144a.isAssignableFrom(cls);
        }

        public boolean b(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            if (a(cls) && this.f435145b.isAssignableFrom(cls2)) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class c {
        c() {
        }

        @NonNull
        public <Model, Data> q<Model, Data> a(@NonNull List<n<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            return new q<>(list, pool);
        }
    }

    public r(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(pool, f435138e);
    }

    private <Model, Data> void a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar, boolean z16) {
        int i3;
        b<?, ?> bVar = new b<>(cls, cls2, oVar);
        List<b<?, ?>> list = this.f435140a;
        if (z16) {
            i3 = list.size();
        } else {
            i3 = 0;
        }
        list.add(i3, bVar);
    }

    @NonNull
    private <Model, Data> n<Model, Data> e(@NonNull b<?, ?> bVar) {
        return (n) h0.j.d(bVar.f435146c.b(this));
    }

    @NonNull
    private static <Model, Data> n<Model, Data> f() {
        return (n<Model, Data>) f435139f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized <Model, Data> void b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        a(cls, cls2, oVar, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public synchronized <Model> List<n<Model, ?>> c(@NonNull Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (b<?, ?> bVar : this.f435140a) {
                if (!this.f435142c.contains(bVar) && bVar.a(cls)) {
                    this.f435142c.add(bVar);
                    arrayList.add(e(bVar));
                    this.f435142c.remove(bVar);
                }
            }
        } catch (Throwable th5) {
            this.f435142c.clear();
            throw th5;
        }
        return arrayList;
    }

    @NonNull
    public synchronized <Model, Data> n<Model, Data> d(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z16 = false;
            for (b<?, ?> bVar : this.f435140a) {
                if (this.f435142c.contains(bVar)) {
                    z16 = true;
                } else if (bVar.b(cls, cls2)) {
                    this.f435142c.add(bVar);
                    arrayList.add(e(bVar));
                    this.f435142c.remove(bVar);
                }
            }
            if (arrayList.size() > 1) {
                return this.f435141b.a(arrayList, this.f435143d);
            }
            if (arrayList.size() == 1) {
                return (n) arrayList.get(0);
            }
            if (z16) {
                return f();
            }
            throw new Registry.NoModelLoaderAvailableException((Class<?>) cls, (Class<?>) cls2);
        } catch (Throwable th5) {
            this.f435142c.clear();
            throw th5;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public synchronized List<Class<?>> g(@NonNull Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (b<?, ?> bVar : this.f435140a) {
            if (!arrayList.contains(bVar.f435145b) && bVar.a(cls)) {
                arrayList.add(bVar.f435145b);
            }
        }
        return arrayList;
    }

    @VisibleForTesting
    r(@NonNull Pools.Pool<List<Throwable>> pool, @NonNull c cVar) {
        this.f435140a = new ArrayList();
        this.f435142c = new HashSet();
        this.f435143d = pool;
        this.f435141b = cVar;
    }
}
