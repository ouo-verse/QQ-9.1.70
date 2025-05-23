package retrofit2;

import android.annotation.TargetApi;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import retrofit2.e;

/* compiled from: P */
@TargetApi(24)
@IgnoreJRERequirement
/* loaded from: classes29.dex */
final class g extends e.a {

    /* compiled from: P */
    @IgnoreJRERequirement
    /* loaded from: classes29.dex */
    private static final class a<R> implements e<R, CompletableFuture<R>> {

        /* renamed from: a, reason: collision with root package name */
        private final Type f431265a;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        @IgnoreJRERequirement
        /* renamed from: retrofit2.g$a$a, reason: collision with other inner class name */
        /* loaded from: classes29.dex */
        public class C11136a implements f<R> {

            /* renamed from: a, reason: collision with root package name */
            private final CompletableFuture<R> f431266a;

            public C11136a(CompletableFuture<R> completableFuture) {
                this.f431266a = completableFuture;
            }

            @Override // retrofit2.f
            public void onFailure(d<R> dVar, Throwable th5) {
                this.f431266a.completeExceptionally(th5);
            }

            @Override // retrofit2.f
            public void onResponse(d<R> dVar, ab<R> abVar) {
                if (abVar.d()) {
                    this.f431266a.complete(abVar.a());
                } else {
                    this.f431266a.completeExceptionally(new HttpException(abVar));
                }
            }
        }

        a(Type type) {
            this.f431265a = type;
        }

        @Override // retrofit2.e
        public Type a() {
            return this.f431265a;
        }

        @Override // retrofit2.e
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public CompletableFuture<R> b(d<R> dVar) {
            b bVar = new b(dVar);
            dVar.g(new C11136a(bVar));
            return bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @IgnoreJRERequirement
    /* loaded from: classes29.dex */
    public static final class b<T> extends CompletableFuture<T> {

        /* renamed from: d, reason: collision with root package name */
        private final d<?> f431268d;

        b(d<?> dVar) {
            this.f431268d = dVar;
        }

        @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
        public boolean cancel(boolean z16) {
            if (z16) {
                this.f431268d.cancel();
            }
            return super.cancel(z16);
        }
    }

    /* compiled from: P */
    @IgnoreJRERequirement
    /* loaded from: classes29.dex */
    private static final class c<R> implements e<R, CompletableFuture<ab<R>>> {

        /* renamed from: a, reason: collision with root package name */
        private final Type f431269a;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        @IgnoreJRERequirement
        /* loaded from: classes29.dex */
        public class a implements f<R> {

            /* renamed from: a, reason: collision with root package name */
            private final CompletableFuture<ab<R>> f431270a;

            public a(CompletableFuture<ab<R>> completableFuture) {
                this.f431270a = completableFuture;
            }

            @Override // retrofit2.f
            public void onFailure(d<R> dVar, Throwable th5) {
                this.f431270a.completeExceptionally(th5);
            }

            @Override // retrofit2.f
            public void onResponse(d<R> dVar, ab<R> abVar) {
                this.f431270a.complete(abVar);
            }
        }

        c(Type type) {
            this.f431269a = type;
        }

        @Override // retrofit2.e
        public Type a() {
            return this.f431269a;
        }

        @Override // retrofit2.e
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public CompletableFuture<ab<R>> b(d<R> dVar) {
            b bVar = new b(dVar);
            dVar.g(new a(bVar));
            return bVar;
        }
    }

    @Override // retrofit2.e.a
    @Nullable
    public e<?, ?> a(Type type, Annotation[] annotationArr, ac acVar) {
        if (e.a.c(type) != CompletableFuture.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            Type b16 = e.a.b(0, (ParameterizedType) type);
            if (e.a.c(b16) != ab.class) {
                return new a(b16);
            }
            if (b16 instanceof ParameterizedType) {
                return new c(e.a.b(0, (ParameterizedType) b16));
            }
            throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
        }
        throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
    }
}
