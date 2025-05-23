package t;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.engine.GlideException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import t.n;

/* compiled from: P */
/* loaded from: classes.dex */
class q<Model, Data> implements n<Model, Data> {

    /* renamed from: a, reason: collision with root package name */
    private final List<n<Model, Data>> f435130a;

    /* renamed from: b, reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f435131b;

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class a<Data> implements com.bumptech.glide.load.data.d<Data>, d.a<Data> {
        private boolean C;

        /* renamed from: d, reason: collision with root package name */
        private final List<com.bumptech.glide.load.data.d<Data>> f435132d;

        /* renamed from: e, reason: collision with root package name */
        private final Pools.Pool<List<Throwable>> f435133e;

        /* renamed from: f, reason: collision with root package name */
        private int f435134f;

        /* renamed from: h, reason: collision with root package name */
        private Priority f435135h;

        /* renamed from: i, reason: collision with root package name */
        private d.a<? super Data> f435136i;

        /* renamed from: m, reason: collision with root package name */
        @Nullable
        private List<Throwable> f435137m;

        a(@NonNull List<com.bumptech.glide.load.data.d<Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            this.f435133e = pool;
            h0.j.c(list);
            this.f435132d = list;
            this.f435134f = 0;
        }

        private void e() {
            if (this.C) {
                return;
            }
            if (this.f435134f < this.f435132d.size() - 1) {
                this.f435134f++;
                b(this.f435135h, this.f435136i);
            } else {
                h0.j.d(this.f435137m);
                this.f435136i.c(new GlideException("Fetch failed", new ArrayList(this.f435137m)));
            }
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public Class<Data> a() {
            return this.f435132d.get(0).a();
        }

        @Override // com.bumptech.glide.load.data.d
        public void b(@NonNull Priority priority, @NonNull d.a<? super Data> aVar) {
            this.f435135h = priority;
            this.f435136i = aVar;
            this.f435137m = this.f435133e.acquire();
            this.f435132d.get(this.f435134f).b(priority, this);
            if (this.C) {
                cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.d.a
        public void c(@NonNull Exception exc) {
            ((List) h0.j.d(this.f435137m)).add(exc);
            e();
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
            this.C = true;
            Iterator<com.bumptech.glide.load.data.d<Data>> it = this.f435132d.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public void cleanup() {
            List<Throwable> list = this.f435137m;
            if (list != null) {
                this.f435133e.release(list);
            }
            this.f435137m = null;
            Iterator<com.bumptech.glide.load.data.d<Data>> it = this.f435132d.iterator();
            while (it.hasNext()) {
                it.next().cleanup();
            }
        }

        @Override // com.bumptech.glide.load.data.d.a
        public void d(@Nullable Data data) {
            if (data != null) {
                this.f435136i.d(data);
            } else {
                e();
            }
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public DataSource getDataSource() {
            return this.f435132d.get(0).getDataSource();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(@NonNull List<n<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
        this.f435130a = list;
        this.f435131b = pool;
    }

    @Override // t.n
    public n.a<Data> a(@NonNull Model model, int i3, int i16, @NonNull com.bumptech.glide.load.e eVar) {
        n.a<Data> a16;
        int size = this.f435130a.size();
        ArrayList arrayList = new ArrayList(size);
        com.bumptech.glide.load.c cVar = null;
        for (int i17 = 0; i17 < size; i17++) {
            n<Model, Data> nVar = this.f435130a.get(i17);
            if (nVar.handles(model) && (a16 = nVar.a(model, i3, i16, eVar)) != null) {
                cVar = a16.f435123a;
                arrayList.add(a16.f435125c);
            }
        }
        if (arrayList.isEmpty() || cVar == null) {
            return null;
        }
        return new n.a<>(cVar, new a(arrayList, this.f435131b));
    }

    @Override // t.n
    public boolean handles(@NonNull Model model) {
        Iterator<n<Model, Data>> it = this.f435130a.iterator();
        while (it.hasNext()) {
            if (it.next().handles(model)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.f435130a.toArray()) + '}';
    }
}
