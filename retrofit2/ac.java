package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.b;
import retrofit2.e;
import retrofit2.h;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ac {

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<Method, Object> f431233a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    final Call.Factory f431234b;

    /* renamed from: c, reason: collision with root package name */
    final HttpUrl f431235c;

    /* renamed from: d, reason: collision with root package name */
    final List<h.a> f431236d;

    /* renamed from: e, reason: collision with root package name */
    final int f431237e;

    /* renamed from: f, reason: collision with root package name */
    final List<e.a> f431238f;

    /* renamed from: g, reason: collision with root package name */
    final int f431239g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    final Executor f431240h;

    /* renamed from: i, reason: collision with root package name */
    final boolean f431241i;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    class a implements InvocationHandler {

        /* renamed from: a, reason: collision with root package name */
        private final Object[] f431242a = new Object[0];

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Class f431243b;

        a(Class cls) {
            this.f431243b = cls;
        }

        @Override // java.lang.reflect.InvocationHandler
        @Nullable
        public Object invoke(Object obj, Method method, @Nullable Object[] objArr) throws Throwable {
            if (method.getDeclaringClass() == Object.class) {
                return method.invoke(this, objArr);
            }
            if (objArr == null) {
                objArr = this.f431242a;
            }
            w wVar = u.f431362b;
            if (wVar.c(method)) {
                return wVar.b(method, this.f431243b, obj, objArr);
            }
            return ac.this.c(this.f431243b, method).a(obj, objArr);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        private Call.Factory f431245a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        private HttpUrl f431246b;

        /* renamed from: c, reason: collision with root package name */
        private final List<h.a> f431247c = new ArrayList();

        /* renamed from: d, reason: collision with root package name */
        private final List<e.a> f431248d = new ArrayList();

        /* renamed from: e, reason: collision with root package name */
        @Nullable
        private Executor f431249e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f431250f;

        public b a(h.a aVar) {
            List<h.a> list = this.f431247c;
            Objects.requireNonNull(aVar, "factory == null");
            list.add(aVar);
            return this;
        }

        public b b(String str) {
            Objects.requireNonNull(str, "baseUrl == null");
            return c(HttpUrl.get(str));
        }

        public b c(HttpUrl httpUrl) {
            Objects.requireNonNull(httpUrl, "baseUrl == null");
            if ("".equals(httpUrl.pathSegments().get(r0.size() - 1))) {
                this.f431246b = httpUrl;
                return this;
            }
            throw new IllegalArgumentException("baseUrl must end in /: " + httpUrl);
        }

        public ac d() {
            if (this.f431246b != null) {
                Call.Factory factory = this.f431245a;
                if (factory == null) {
                    factory = new OkHttpClient();
                }
                Call.Factory factory2 = factory;
                Executor executor = this.f431249e;
                if (executor == null) {
                    executor = u.f431361a;
                }
                Executor executor2 = executor;
                c cVar = u.f431363c;
                ArrayList arrayList = new ArrayList(this.f431248d);
                List<? extends e.a> a16 = cVar.a(executor2);
                arrayList.addAll(a16);
                List<? extends h.a> b16 = cVar.b();
                int size = b16.size();
                ArrayList arrayList2 = new ArrayList(this.f431247c.size() + 1 + size);
                arrayList2.add(new retrofit2.b());
                arrayList2.addAll(this.f431247c);
                arrayList2.addAll(b16);
                return new ac(factory2, this.f431246b, Collections.unmodifiableList(arrayList2), size, Collections.unmodifiableList(arrayList), a16.size(), executor2, this.f431250f);
            }
            throw new IllegalStateException("Base URL required.");
        }

        public b e(Executor executor) {
            Objects.requireNonNull(executor, "executor == null");
            this.f431249e = executor;
            return this;
        }
    }

    ac(Call.Factory factory, HttpUrl httpUrl, List<h.a> list, int i3, List<e.a> list2, int i16, @Nullable Executor executor, boolean z16) {
        this.f431234b = factory;
        this.f431235c = httpUrl;
        this.f431236d = list;
        this.f431237e = i3;
        this.f431238f = list2;
        this.f431239g = i16;
        this.f431240h = executor;
        this.f431241i = z16;
    }

    private void j(Class<?> cls) {
        if (cls.isInterface()) {
            ArrayDeque arrayDeque = new ArrayDeque(1);
            arrayDeque.add(cls);
            while (!arrayDeque.isEmpty()) {
                Class<?> cls2 = (Class) arrayDeque.removeFirst();
                if (cls2.getTypeParameters().length != 0) {
                    StringBuilder sb5 = new StringBuilder("Type parameters are unsupported on ");
                    sb5.append(cls2.getName());
                    if (cls2 != cls) {
                        sb5.append(" which is an interface of ");
                        sb5.append(cls.getName());
                    }
                    throw new IllegalArgumentException(sb5.toString());
                }
                Collections.addAll(arrayDeque, cls2.getInterfaces());
            }
            if (this.f431241i) {
                w wVar = u.f431362b;
                for (Method method : cls.getDeclaredMethods()) {
                    if (!wVar.c(method) && !Modifier.isStatic(method.getModifiers()) && !method.isSynthetic()) {
                        c(cls, method);
                    }
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("API declarations must be interfaces.");
    }

    public e<?, ?> a(Type type, Annotation[] annotationArr) {
        return d(null, type, annotationArr);
    }

    public <T> T b(Class<T> cls) {
        j(cls);
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new a(cls));
    }

    ad<?> c(Class<?> cls, Method method) {
        while (true) {
            Object obj = this.f431233a.get(method);
            if (obj instanceof ad) {
                return (ad) obj;
            }
            if (obj == null) {
                Object obj2 = new Object();
                synchronized (obj2) {
                    obj = this.f431233a.putIfAbsent(method, obj2);
                    if (obj == null) {
                        try {
                            ad<?> b16 = ad.b(this, cls, method);
                            this.f431233a.put(method, b16);
                            return b16;
                        } catch (Throwable th5) {
                            this.f431233a.remove(method);
                            throw th5;
                        }
                    }
                }
            }
            synchronized (obj) {
                Object obj3 = this.f431233a.get(method);
                if (obj3 != null) {
                    return (ad) obj3;
                }
            }
        }
    }

    public e<?, ?> d(@Nullable e.a aVar, Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "returnType == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int indexOf = this.f431238f.indexOf(aVar) + 1;
        int size = this.f431238f.size();
        for (int i3 = indexOf; i3 < size; i3++) {
            e<?, ?> a16 = this.f431238f.get(i3).a(type, annotationArr, this);
            if (a16 != null) {
                return a16;
            }
        }
        StringBuilder sb5 = new StringBuilder("Could not locate call adapter for ");
        sb5.append(type);
        sb5.append(".\n");
        if (aVar != null) {
            sb5.append("  Skipped:");
            for (int i16 = 0; i16 < indexOf; i16++) {
                sb5.append("\n   * ");
                sb5.append(this.f431238f.get(i16).getClass().getName());
            }
            sb5.append('\n');
        }
        sb5.append("  Tried:");
        int size2 = this.f431238f.size();
        while (indexOf < size2) {
            sb5.append("\n   * ");
            sb5.append(this.f431238f.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb5.toString());
    }

    public <T> h<T, RequestBody> e(@Nullable h.a aVar, Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "parameterAnnotations == null");
        Objects.requireNonNull(annotationArr2, "methodAnnotations == null");
        int indexOf = this.f431236d.indexOf(aVar) + 1;
        int size = this.f431236d.size();
        for (int i3 = indexOf; i3 < size; i3++) {
            h<T, RequestBody> hVar = (h<T, RequestBody>) this.f431236d.get(i3).c(type, annotationArr, annotationArr2, this);
            if (hVar != null) {
                return hVar;
            }
        }
        StringBuilder sb5 = new StringBuilder("Could not locate RequestBody converter for ");
        sb5.append(type);
        sb5.append(".\n");
        if (aVar != null) {
            sb5.append("  Skipped:");
            for (int i16 = 0; i16 < indexOf; i16++) {
                sb5.append("\n   * ");
                sb5.append(this.f431236d.get(i16).getClass().getName());
            }
            sb5.append('\n');
        }
        sb5.append("  Tried:");
        int size2 = this.f431236d.size();
        while (indexOf < size2) {
            sb5.append("\n   * ");
            sb5.append(this.f431236d.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb5.toString());
    }

    public <T> h<ResponseBody, T> f(@Nullable h.a aVar, Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int indexOf = this.f431236d.indexOf(aVar) + 1;
        int size = this.f431236d.size();
        for (int i3 = indexOf; i3 < size; i3++) {
            h<ResponseBody, T> hVar = (h<ResponseBody, T>) this.f431236d.get(i3).d(type, annotationArr, this);
            if (hVar != null) {
                return hVar;
            }
        }
        StringBuilder sb5 = new StringBuilder("Could not locate ResponseBody converter for ");
        sb5.append(type);
        sb5.append(".\n");
        if (aVar != null) {
            sb5.append("  Skipped:");
            for (int i16 = 0; i16 < indexOf; i16++) {
                sb5.append("\n   * ");
                sb5.append(this.f431236d.get(i16).getClass().getName());
            }
            sb5.append('\n');
        }
        sb5.append("  Tried:");
        int size2 = this.f431236d.size();
        while (indexOf < size2) {
            sb5.append("\n   * ");
            sb5.append(this.f431236d.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb5.toString());
    }

    public <T> h<T, RequestBody> g(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        return e(null, type, annotationArr, annotationArr2);
    }

    public <T> h<ResponseBody, T> h(Type type, Annotation[] annotationArr) {
        return f(null, type, annotationArr);
    }

    public <T> h<T, String> i(Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int size = this.f431236d.size();
        for (int i3 = 0; i3 < size; i3++) {
            h<T, String> hVar = (h<T, String>) this.f431236d.get(i3).e(type, annotationArr, this);
            if (hVar != null) {
                return hVar;
            }
        }
        return b.d.f431262a;
    }
}
