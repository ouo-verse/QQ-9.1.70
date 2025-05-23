package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import okhttp3.Request;
import retrofit2.e;
import retrofit2.i;

/* compiled from: P */
/* loaded from: classes29.dex */
final class i extends e.a {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final Executor f431272a;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    class a implements e<Object, d<?>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Type f431273a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Executor f431274b;

        a(Type type, Executor executor) {
            this.f431273a = type;
            this.f431274b = executor;
        }

        @Override // retrofit2.e
        public Type a() {
            return this.f431273a;
        }

        @Override // retrofit2.e
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public d<Object> b(d<Object> dVar) {
            Executor executor = this.f431274b;
            if (executor != null) {
                return new b(executor, dVar);
            }
            return dVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class b<T> implements d<T> {

        /* renamed from: d, reason: collision with root package name */
        final Executor f431276d;

        /* renamed from: e, reason: collision with root package name */
        final d<T> f431277e;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes29.dex */
        public class a implements f<T> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ f f431278a;

            a(f fVar) {
                this.f431278a = fVar;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void c(f fVar, Throwable th5) {
                fVar.onFailure(b.this, th5);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void d(f fVar, ab abVar) {
                if (b.this.f431277e.isCanceled()) {
                    fVar.onFailure(b.this, new IOException("Canceled"));
                } else {
                    fVar.onResponse(b.this, abVar);
                }
            }

            @Override // retrofit2.f
            public void onFailure(d<T> dVar, final Throwable th5) {
                Executor executor = b.this.f431276d;
                final f fVar = this.f431278a;
                executor.execute(new Runnable() { // from class: retrofit2.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        i.b.a.this.c(fVar, th5);
                    }
                });
            }

            @Override // retrofit2.f
            public void onResponse(d<T> dVar, final ab<T> abVar) {
                Executor executor = b.this.f431276d;
                final f fVar = this.f431278a;
                executor.execute(new Runnable() { // from class: retrofit2.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        i.b.a.this.d(fVar, abVar);
                    }
                });
            }
        }

        b(Executor executor, d<T> dVar) {
            this.f431276d = executor;
            this.f431277e = dVar;
        }

        @Override // retrofit2.d
        public void cancel() {
            this.f431277e.cancel();
        }

        @Override // retrofit2.d
        public ab<T> execute() throws IOException {
            return this.f431277e.execute();
        }

        @Override // retrofit2.d
        public void g(f<T> fVar) {
            Objects.requireNonNull(fVar, "callback == null");
            this.f431277e.g(new a(fVar));
        }

        @Override // retrofit2.d
        public boolean isCanceled() {
            return this.f431277e.isCanceled();
        }

        @Override // retrofit2.d
        public Request request() {
            return this.f431277e.request();
        }

        @Override // retrofit2.d
        public d<T> clone() {
            return new b(this.f431276d, this.f431277e.clone());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(@Nullable Executor executor) {
        this.f431272a = executor;
    }

    @Override // retrofit2.e.a
    @Nullable
    public e<?, ?> a(Type type, Annotation[] annotationArr, ac acVar) {
        Executor executor = null;
        if (e.a.c(type) != d.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            Type g16 = ae.g(0, (ParameterizedType) type);
            if (!ae.l(annotationArr, SkipCallbackExecutor.class)) {
                executor = this.f431272a;
            }
            return new a(g16, executor);
        }
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }
}
