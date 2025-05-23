package t;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.bumptech.glide.Registry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    private final r f435126a;

    /* renamed from: b, reason: collision with root package name */
    private final a f435127b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final Map<Class<?>, C11267a<?>> f435128a = new HashMap();

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: t.p$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C11267a<Model> {

            /* renamed from: a, reason: collision with root package name */
            final List<n<Model, ?>> f435129a;

            public C11267a(List<n<Model, ?>> list) {
                this.f435129a = list;
            }
        }

        a() {
        }

        public void a() {
            this.f435128a.clear();
        }

        @Nullable
        public <Model> List<n<Model, ?>> b(Class<Model> cls) {
            C11267a<?> c11267a = this.f435128a.get(cls);
            if (c11267a == null) {
                return null;
            }
            return (List<n<Model, ?>>) c11267a.f435129a;
        }

        public <Model> void c(Class<Model> cls, List<n<Model, ?>> list) {
            if (this.f435128a.put(cls, new C11267a<>(list)) == null) {
                return;
            }
            throw new IllegalStateException("Already cached loaders for model: " + cls);
        }
    }

    public p(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(new r(pool));
    }

    @NonNull
    private static <A> Class<A> b(@NonNull A a16) {
        return (Class<A>) a16.getClass();
    }

    @NonNull
    private synchronized <A> List<n<A, ?>> e(@NonNull Class<A> cls) {
        List<n<A, ?>> b16;
        b16 = this.f435127b.b(cls);
        if (b16 == null) {
            b16 = Collections.unmodifiableList(this.f435126a.c(cls));
            this.f435127b.c(cls, b16);
        }
        return b16;
    }

    public synchronized <Model, Data> void a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        this.f435126a.b(cls, cls2, oVar);
        this.f435127b.a();
    }

    @NonNull
    public synchronized List<Class<?>> c(@NonNull Class<?> cls) {
        return this.f435126a.g(cls);
    }

    @NonNull
    public <A> List<n<A, ?>> d(@NonNull A a16) {
        List<n<A, ?>> e16 = e(b(a16));
        if (!e16.isEmpty()) {
            int size = e16.size();
            List<n<A, ?>> emptyList = Collections.emptyList();
            boolean z16 = true;
            for (int i3 = 0; i3 < size; i3++) {
                n<A, ?> nVar = e16.get(i3);
                if (nVar.handles(a16)) {
                    if (z16) {
                        emptyList = new ArrayList<>(size - i3);
                        z16 = false;
                    }
                    emptyList.add(nVar);
                }
            }
            if (!emptyList.isEmpty()) {
                return emptyList;
            }
            throw new Registry.NoModelLoaderAvailableException(a16, e16);
        }
        throw new Registry.NoModelLoaderAvailableException(a16);
    }

    p(@NonNull r rVar) {
        this.f435127b = new a();
        this.f435126a = rVar;
    }
}
