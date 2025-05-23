package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import kotlin.Unit;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.h;
import retrofit2.http.Streaming;

/* compiled from: P */
/* loaded from: classes29.dex */
final class b extends h.a {

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static final class a implements h<ResponseBody, ResponseBody> {

        /* renamed from: a, reason: collision with root package name */
        static final a f431259a = new a();

        a() {
        }

        @Override // retrofit2.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ResponseBody convert(ResponseBody responseBody) throws IOException {
            try {
                return ae.a(responseBody);
            } finally {
                responseBody.close();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static final class d implements h<Object, String> {

        /* renamed from: a, reason: collision with root package name */
        static final d f431262a = new d();

        d() {
        }

        @Override // retrofit2.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String convert(Object obj) {
            return obj.toString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static final class e implements h<ResponseBody, Unit> {

        /* renamed from: a, reason: collision with root package name */
        static final e f431263a = new e();

        e() {
        }

        @Override // retrofit2.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit convert(ResponseBody responseBody) {
            responseBody.close();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static final class f implements h<ResponseBody, Void> {

        /* renamed from: a, reason: collision with root package name */
        static final f f431264a = new f();

        f() {
        }

        @Override // retrofit2.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void convert(ResponseBody responseBody) {
            responseBody.close();
            return null;
        }
    }

    @Override // retrofit2.h.a
    @Nullable
    public h<?, RequestBody> c(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, ac acVar) {
        if (RequestBody.class.isAssignableFrom(ae.h(type))) {
            return C11135b.f431260a;
        }
        return null;
    }

    @Override // retrofit2.h.a
    @Nullable
    public h<ResponseBody, ?> d(Type type, Annotation[] annotationArr, ac acVar) {
        if (type == ResponseBody.class) {
            if (ae.l(annotationArr, Streaming.class)) {
                return c.f431261a;
            }
            return a.f431259a;
        }
        if (type == Void.class) {
            return f.f431264a;
        }
        if (ae.m(type)) {
            return e.f431263a;
        }
        return null;
    }

    /* compiled from: P */
    /* renamed from: retrofit2.b$b, reason: collision with other inner class name */
    /* loaded from: classes29.dex */
    static final class C11135b implements h<RequestBody, RequestBody> {

        /* renamed from: a, reason: collision with root package name */
        static final C11135b f431260a = new C11135b();

        C11135b() {
        }

        @Override // retrofit2.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RequestBody convert(RequestBody requestBody) {
            return requestBody;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static final class c implements h<ResponseBody, ResponseBody> {

        /* renamed from: a, reason: collision with root package name */
        static final c f431261a = new c();

        c() {
        }

        @Override // retrofit2.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ResponseBody convert(ResponseBody responseBody) {
            return responseBody;
        }
    }
}
