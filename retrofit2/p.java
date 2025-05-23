package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import kotlin.coroutines.Continuation;
import okhttp3.Call;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.ae;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class p<ResponseT, ReturnT> extends ad<ReturnT> {

    /* renamed from: a, reason: collision with root package name */
    private final aa f431287a;

    /* renamed from: b, reason: collision with root package name */
    private final Call.Factory f431288b;

    /* renamed from: c, reason: collision with root package name */
    private final h<ResponseBody, ResponseT> f431289c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class a<ResponseT, ReturnT> extends p<ResponseT, ReturnT> {

        /* renamed from: d, reason: collision with root package name */
        private final e<ResponseT, ReturnT> f431290d;

        a(aa aaVar, Call.Factory factory, h<ResponseBody, ResponseT> hVar, e<ResponseT, ReturnT> eVar) {
            super(aaVar, factory, hVar);
            this.f431290d = eVar;
        }

        @Override // retrofit2.p
        protected ReturnT c(d<ResponseT> dVar, Object[] objArr) {
            return this.f431290d.b(dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class b<ResponseT> extends p<ResponseT, Object> {

        /* renamed from: d, reason: collision with root package name */
        private final e<ResponseT, d<ResponseT>> f431291d;

        /* renamed from: e, reason: collision with root package name */
        private final boolean f431292e;

        /* renamed from: f, reason: collision with root package name */
        private final boolean f431293f;

        b(aa aaVar, Call.Factory factory, h<ResponseBody, ResponseT> hVar, e<ResponseT, d<ResponseT>> eVar, boolean z16, boolean z17) {
            super(aaVar, factory, hVar);
            this.f431291d = eVar;
            this.f431292e = z16;
            this.f431293f = z17;
        }

        @Override // retrofit2.p
        protected Object c(d<ResponseT> dVar, Object[] objArr) {
            d<ResponseT> b16 = this.f431291d.b(dVar);
            Continuation continuation = (Continuation) objArr[objArr.length - 1];
            try {
                if (this.f431293f) {
                    return KotlinExtensions.d(b16, continuation);
                }
                if (this.f431292e) {
                    return KotlinExtensions.b(b16, continuation);
                }
                return KotlinExtensions.a(b16, continuation);
            } catch (LinkageError e16) {
                throw e16;
            } catch (ThreadDeath e17) {
                throw e17;
            } catch (VirtualMachineError e18) {
                throw e18;
            } catch (Throwable th5) {
                return KotlinExtensions.e(th5, continuation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class c<ResponseT> extends p<ResponseT, Object> {

        /* renamed from: d, reason: collision with root package name */
        private final e<ResponseT, d<ResponseT>> f431294d;

        c(aa aaVar, Call.Factory factory, h<ResponseBody, ResponseT> hVar, e<ResponseT, d<ResponseT>> eVar) {
            super(aaVar, factory, hVar);
            this.f431294d = eVar;
        }

        @Override // retrofit2.p
        protected Object c(d<ResponseT> dVar, Object[] objArr) {
            d<ResponseT> b16 = this.f431294d.b(dVar);
            Continuation continuation = (Continuation) objArr[objArr.length - 1];
            try {
                return KotlinExtensions.c(b16, continuation);
            } catch (Exception e16) {
                return KotlinExtensions.e(e16, continuation);
            }
        }
    }

    p(aa aaVar, Call.Factory factory, h<ResponseBody, ResponseT> hVar) {
        this.f431287a = aaVar;
        this.f431288b = factory;
        this.f431289c = hVar;
    }

    private static <ResponseT, ReturnT> e<ResponseT, ReturnT> d(ac acVar, Method method, Type type, Annotation[] annotationArr) {
        try {
            return (e<ResponseT, ReturnT>) acVar.a(type, annotationArr);
        } catch (RuntimeException e16) {
            throw ae.o(method, e16, "Unable to create call adapter for %s", type);
        }
    }

    private static <ResponseT> h<ResponseBody, ResponseT> e(ac acVar, Method method, Type type) {
        try {
            return acVar.h(type, method.getAnnotations());
        } catch (RuntimeException e16) {
            throw ae.o(method, e16, "Unable to create converter for %s", type);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <ResponseT, ReturnT> p<ResponseT, ReturnT> f(ac acVar, Method method, aa aaVar) {
        Type genericReturnType;
        boolean z16;
        boolean z17;
        boolean m3;
        boolean z18 = aaVar.f431203l;
        Annotation[] annotations = method.getAnnotations();
        if (z18) {
            Type[] genericParameterTypes = method.getGenericParameterTypes();
            Type f16 = ae.f(0, (ParameterizedType) genericParameterTypes[genericParameterTypes.length - 1]);
            if (ae.h(f16) == ab.class && (f16 instanceof ParameterizedType)) {
                f16 = ae.g(0, (ParameterizedType) f16);
                m3 = false;
                z17 = true;
            } else if (ae.h(f16) != d.class) {
                m3 = ae.m(f16);
                z17 = false;
            } else {
                throw ae.n(method, "Suspend functions should not return Call, as they already execute asynchronously.\nChange its return type to %s", ae.g(0, (ParameterizedType) f16));
            }
            genericReturnType = new ae.b(null, d.class, f16);
            annotations = SkipCallbackExecutorImpl.ensurePresent(annotations);
            z16 = m3;
        } else {
            genericReturnType = method.getGenericReturnType();
            z16 = false;
            z17 = false;
        }
        e d16 = d(acVar, method, genericReturnType, annotations);
        Type a16 = d16.a();
        if (a16 != Response.class) {
            if (a16 != ab.class) {
                if (aaVar.f431195d.equals("HEAD") && !Void.class.equals(a16) && !ae.m(a16)) {
                    throw ae.n(method, "HEAD method must use Void or Unit as response type.", new Object[0]);
                }
                h e16 = e(acVar, method, a16);
                Call.Factory factory = acVar.f431234b;
                if (!z18) {
                    return new a(aaVar, factory, e16, d16);
                }
                if (z17) {
                    return new c(aaVar, factory, e16, d16);
                }
                return new b(aaVar, factory, e16, d16, false, z16);
            }
            throw ae.n(method, "Response must include generic type (e.g., Response<String>)", new Object[0]);
        }
        throw ae.n(method, "'" + ae.h(a16).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // retrofit2.ad
    @Nullable
    public final ReturnT a(Object obj, Object[] objArr) {
        return c(new r(this.f431287a, obj, objArr, this.f431288b, this.f431289c), objArr);
    }

    @Nullable
    protected abstract ReturnT c(d<ResponseT> dVar, Object[] objArr);
}
