package t;

import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import t.n;

/* compiled from: P */
/* loaded from: classes.dex */
public class v<Model> implements n<Model, Model> {

    /* renamed from: a, reason: collision with root package name */
    private static final v<?> f435155a = new v<>();

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class a<Model> implements o<Model, Model> {

        /* renamed from: a, reason: collision with root package name */
        private static final a<?> f435156a = new a<>();

        @Deprecated
        public a() {
        }

        public static <T> a<T> a() {
            return (a<T>) f435156a;
        }

        @Override // t.o
        @NonNull
        public n<Model, Model> b(r rVar) {
            return v.b();
        }
    }

    @Deprecated
    public v() {
    }

    public static <T> v<T> b() {
        return (v<T>) f435155a;
    }

    @Override // t.n
    public n.a<Model> a(@NonNull Model model, int i3, int i16, @NonNull com.bumptech.glide.load.e eVar) {
        return new n.a<>(new g0.b(model), new b(model));
    }

    @Override // t.n
    public boolean handles(@NonNull Model model) {
        return true;
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static class b<Model> implements com.bumptech.glide.load.data.d<Model> {

        /* renamed from: d, reason: collision with root package name */
        private final Model f435157d;

        b(Model model) {
            this.f435157d = model;
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public Class<Model> a() {
            return (Class<Model>) this.f435157d.getClass();
        }

        @Override // com.bumptech.glide.load.data.d
        public void b(@NonNull Priority priority, @NonNull d.a<? super Model> aVar) {
            aVar.d(this.f435157d);
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.d
        public void cleanup() {
        }
    }
}
