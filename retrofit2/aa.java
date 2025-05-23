package retrofit2;

import com.tencent.mtt.hippy.adapter.http.HttpHeader;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import kotlin.coroutines.Continuation;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPut;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.OPTIONS;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.QueryName;
import retrofit2.http.Tag;
import retrofit2.http.Url;
import retrofit2.t;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes29.dex */
public final class aa {

    /* renamed from: a, reason: collision with root package name */
    private final Class<?> f431192a;

    /* renamed from: b, reason: collision with root package name */
    private final Method f431193b;

    /* renamed from: c, reason: collision with root package name */
    private final HttpUrl f431194c;

    /* renamed from: d, reason: collision with root package name */
    final String f431195d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private final String f431196e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private final Headers f431197f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    private final MediaType f431198g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f431199h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f431200i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f431201j;

    /* renamed from: k, reason: collision with root package name */
    private final t<?>[] f431202k;

    /* renamed from: l, reason: collision with root package name */
    final boolean f431203l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class a {

        /* renamed from: y, reason: collision with root package name */
        private static final Pattern f431204y = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");

        /* renamed from: z, reason: collision with root package name */
        private static final Pattern f431205z = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");

        /* renamed from: a, reason: collision with root package name */
        final ac f431206a;

        /* renamed from: b, reason: collision with root package name */
        final Class<?> f431207b;

        /* renamed from: c, reason: collision with root package name */
        final Method f431208c;

        /* renamed from: d, reason: collision with root package name */
        final Annotation[] f431209d;

        /* renamed from: e, reason: collision with root package name */
        final Annotation[][] f431210e;

        /* renamed from: f, reason: collision with root package name */
        final Type[] f431211f;

        /* renamed from: g, reason: collision with root package name */
        boolean f431212g;

        /* renamed from: h, reason: collision with root package name */
        boolean f431213h;

        /* renamed from: i, reason: collision with root package name */
        boolean f431214i;

        /* renamed from: j, reason: collision with root package name */
        boolean f431215j;

        /* renamed from: k, reason: collision with root package name */
        boolean f431216k;

        /* renamed from: l, reason: collision with root package name */
        boolean f431217l;

        /* renamed from: m, reason: collision with root package name */
        boolean f431218m;

        /* renamed from: n, reason: collision with root package name */
        boolean f431219n;

        /* renamed from: o, reason: collision with root package name */
        @Nullable
        String f431220o;

        /* renamed from: p, reason: collision with root package name */
        boolean f431221p;

        /* renamed from: q, reason: collision with root package name */
        boolean f431222q;

        /* renamed from: r, reason: collision with root package name */
        boolean f431223r;

        /* renamed from: s, reason: collision with root package name */
        @Nullable
        String f431224s;

        /* renamed from: t, reason: collision with root package name */
        @Nullable
        Headers f431225t;

        /* renamed from: u, reason: collision with root package name */
        @Nullable
        MediaType f431226u;

        /* renamed from: v, reason: collision with root package name */
        @Nullable
        Set<String> f431227v;

        /* renamed from: w, reason: collision with root package name */
        @Nullable
        t<?>[] f431228w;

        /* renamed from: x, reason: collision with root package name */
        boolean f431229x;

        a(ac acVar, Class<?> cls, Method method) {
            this.f431206a = acVar;
            this.f431207b = cls;
            this.f431208c = method;
            this.f431209d = method.getAnnotations();
            this.f431211f = method.getGenericParameterTypes();
            this.f431210e = method.getParameterAnnotations();
        }

        private static Class<?> a(Class<?> cls) {
            if (Boolean.TYPE == cls) {
                return Boolean.class;
            }
            if (Byte.TYPE == cls) {
                return Byte.class;
            }
            if (Character.TYPE == cls) {
                return Character.class;
            }
            if (Double.TYPE == cls) {
                return Double.class;
            }
            if (Float.TYPE == cls) {
                return Float.class;
            }
            if (Integer.TYPE == cls) {
                return Integer.class;
            }
            if (Long.TYPE == cls) {
                return Long.class;
            }
            if (Short.TYPE == cls) {
                return Short.class;
            }
            return cls;
        }

        private Headers c(String[] strArr, boolean z16) {
            Headers.Builder builder = new Headers.Builder();
            for (String str : strArr) {
                int indexOf = str.indexOf(58);
                if (indexOf != -1 && indexOf != 0 && indexOf != str.length() - 1) {
                    String substring = str.substring(0, indexOf);
                    String trim = str.substring(indexOf + 1).trim();
                    if ("Content-Type".equalsIgnoreCase(substring)) {
                        try {
                            this.f431226u = MediaType.get(trim);
                        } catch (IllegalArgumentException e16) {
                            throw ae.o(this.f431208c, e16, "Malformed content type: %s", trim);
                        }
                    } else if (z16) {
                        builder.addUnsafeNonAscii(substring, trim);
                    } else {
                        builder.add(substring, trim);
                    }
                } else {
                    throw ae.n(this.f431208c, "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
                }
            }
            return builder.build();
        }

        private void d(String str, String str2, boolean z16) {
            String str3 = this.f431220o;
            if (str3 == null) {
                this.f431220o = str;
                this.f431221p = z16;
                if (str2.isEmpty()) {
                    return;
                }
                int indexOf = str2.indexOf(63);
                if (indexOf != -1 && indexOf < str2.length() - 1) {
                    String substring = str2.substring(indexOf + 1);
                    if (f431204y.matcher(substring).find()) {
                        throw ae.n(this.f431208c, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", substring);
                    }
                }
                this.f431224s = str2;
                this.f431227v = h(str2);
                return;
            }
            throw ae.n(this.f431208c, "Only one HTTP method is allowed. Found: %s and %s.", str3, str);
        }

        private void e(Annotation annotation) {
            if (annotation instanceof DELETE) {
                d("DELETE", ((DELETE) annotation).value(), false);
                return;
            }
            if (annotation instanceof GET) {
                d("GET", ((GET) annotation).value(), false);
                return;
            }
            if (annotation instanceof HEAD) {
                d("HEAD", ((HEAD) annotation).value(), false);
                return;
            }
            if (annotation instanceof PATCH) {
                d("PATCH", ((PATCH) annotation).value(), true);
                return;
            }
            if (annotation instanceof POST) {
                d("POST", ((POST) annotation).value(), true);
                return;
            }
            if (annotation instanceof PUT) {
                d(HttpPut.METHOD_NAME, ((PUT) annotation).value(), true);
                return;
            }
            if (annotation instanceof OPTIONS) {
                d(HttpOptions.METHOD_NAME, ((OPTIONS) annotation).value(), false);
                return;
            }
            if (annotation instanceof HTTP) {
                HTTP http = (HTTP) annotation;
                d(http.method(), http.path(), http.hasBody());
                return;
            }
            if (annotation instanceof retrofit2.http.Headers) {
                retrofit2.http.Headers headers = (retrofit2.http.Headers) annotation;
                String[] value = headers.value();
                if (value.length != 0) {
                    this.f431225t = c(value, headers.allowUnsafeNonAsciiValues());
                    return;
                }
                throw ae.n(this.f431208c, "@Headers annotation is empty.", new Object[0]);
            }
            if (annotation instanceof Multipart) {
                if (!this.f431222q) {
                    this.f431223r = true;
                    return;
                }
                throw ae.n(this.f431208c, "Only one encoding annotation is allowed.", new Object[0]);
            }
            if (annotation instanceof FormUrlEncoded) {
                if (!this.f431223r) {
                    this.f431222q = true;
                    return;
                }
                throw ae.n(this.f431208c, "Only one encoding annotation is allowed.", new Object[0]);
            }
        }

        @Nullable
        private t<?> f(int i3, Type type, @Nullable Annotation[] annotationArr, boolean z16) {
            t<?> tVar;
            if (annotationArr != null) {
                tVar = null;
                for (Annotation annotation : annotationArr) {
                    t<?> g16 = g(i3, type, annotationArr, annotation);
                    if (g16 != null) {
                        if (tVar == null) {
                            tVar = g16;
                        } else {
                            throw ae.p(this.f431208c, i3, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                        }
                    }
                }
            } else {
                tVar = null;
            }
            if (tVar == null) {
                if (z16) {
                    try {
                        if (ae.h(type) == Continuation.class) {
                            this.f431229x = true;
                            return null;
                        }
                    } catch (NoClassDefFoundError unused) {
                    }
                }
                throw ae.p(this.f431208c, i3, "No Retrofit annotation found.", new Object[0]);
            }
            return tVar;
        }

        @Nullable
        private t<?> g(int i3, Type type, Annotation[] annotationArr, Annotation annotation) {
            if (annotation instanceof Url) {
                j(i3, type);
                if (!this.f431219n) {
                    if (!this.f431215j) {
                        if (!this.f431216k) {
                            if (!this.f431217l) {
                                if (!this.f431218m) {
                                    if (this.f431224s != null) {
                                        throw ae.p(this.f431208c, i3, "@Url cannot be used with @%s URL", this.f431220o);
                                    }
                                    this.f431219n = true;
                                    if (type != HttpUrl.class && type != String.class && type != URI.class && (!(type instanceof Class) || !"android.net.Uri".equals(((Class) type).getName()))) {
                                        throw ae.p(this.f431208c, i3, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
                                    }
                                    return new t.p(this.f431208c, i3);
                                }
                                throw ae.p(this.f431208c, i3, "A @Url parameter must not come after a @QueryMap.", new Object[0]);
                            }
                            throw ae.p(this.f431208c, i3, "A @Url parameter must not come after a @QueryName.", new Object[0]);
                        }
                        throw ae.p(this.f431208c, i3, "A @Url parameter must not come after a @Query.", new Object[0]);
                    }
                    throw ae.p(this.f431208c, i3, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                throw ae.p(this.f431208c, i3, "Multiple @Url method annotations found.", new Object[0]);
            }
            if (annotation instanceof Path) {
                j(i3, type);
                if (!this.f431216k) {
                    if (!this.f431217l) {
                        if (!this.f431218m) {
                            if (!this.f431219n) {
                                if (this.f431224s == null) {
                                    throw ae.p(this.f431208c, i3, "@Path can only be used with relative url on @%s", this.f431220o);
                                }
                                this.f431215j = true;
                                Path path = (Path) annotation;
                                String value = path.value();
                                i(i3, value);
                                return new t.k(this.f431208c, i3, value, this.f431206a.i(type, annotationArr), path.encoded());
                            }
                            throw ae.p(this.f431208c, i3, "@Path parameters may not be used with @Url.", new Object[0]);
                        }
                        throw ae.p(this.f431208c, i3, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
                    }
                    throw ae.p(this.f431208c, i3, "A @Path parameter must not come after a @QueryName.", new Object[0]);
                }
                throw ae.p(this.f431208c, i3, "A @Path parameter must not come after a @Query.", new Object[0]);
            }
            if (annotation instanceof Query) {
                j(i3, type);
                Query query = (Query) annotation;
                String value2 = query.value();
                boolean encoded = query.encoded();
                Class<?> h16 = ae.h(type);
                this.f431216k = true;
                if (Iterable.class.isAssignableFrom(h16)) {
                    if (type instanceof ParameterizedType) {
                        return new t.l(value2, this.f431206a.i(ae.g(0, (ParameterizedType) type), annotationArr), encoded).c();
                    }
                    throw ae.p(this.f431208c, i3, h16.getSimpleName() + " must include generic type (e.g., " + h16.getSimpleName() + "<String>)", new Object[0]);
                }
                if (h16.isArray()) {
                    return new t.l(value2, this.f431206a.i(a(h16.getComponentType()), annotationArr), encoded).b();
                }
                return new t.l(value2, this.f431206a.i(type, annotationArr), encoded);
            }
            if (annotation instanceof QueryName) {
                j(i3, type);
                boolean encoded2 = ((QueryName) annotation).encoded();
                Class<?> h17 = ae.h(type);
                this.f431217l = true;
                if (Iterable.class.isAssignableFrom(h17)) {
                    if (type instanceof ParameterizedType) {
                        return new t.n(this.f431206a.i(ae.g(0, (ParameterizedType) type), annotationArr), encoded2).c();
                    }
                    throw ae.p(this.f431208c, i3, h17.getSimpleName() + " must include generic type (e.g., " + h17.getSimpleName() + "<String>)", new Object[0]);
                }
                if (h17.isArray()) {
                    return new t.n(this.f431206a.i(a(h17.getComponentType()), annotationArr), encoded2).b();
                }
                return new t.n(this.f431206a.i(type, annotationArr), encoded2);
            }
            if (annotation instanceof QueryMap) {
                j(i3, type);
                Class<?> h18 = ae.h(type);
                this.f431218m = true;
                if (Map.class.isAssignableFrom(h18)) {
                    Type i16 = ae.i(type, h18, Map.class);
                    if (i16 instanceof ParameterizedType) {
                        ParameterizedType parameterizedType = (ParameterizedType) i16;
                        Type g16 = ae.g(0, parameterizedType);
                        if (String.class == g16) {
                            return new t.m(this.f431208c, i3, this.f431206a.i(ae.g(1, parameterizedType), annotationArr), ((QueryMap) annotation).encoded());
                        }
                        throw ae.p(this.f431208c, i3, "@QueryMap keys must be of type String: " + g16, new Object[0]);
                    }
                    throw ae.p(this.f431208c, i3, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                throw ae.p(this.f431208c, i3, "@QueryMap parameter type must be Map.", new Object[0]);
            }
            if (annotation instanceof Header) {
                j(i3, type);
                Header header = (Header) annotation;
                String value3 = header.value();
                Class<?> h19 = ae.h(type);
                if (Iterable.class.isAssignableFrom(h19)) {
                    if (type instanceof ParameterizedType) {
                        return new t.f(value3, this.f431206a.i(ae.g(0, (ParameterizedType) type), annotationArr), header.allowUnsafeNonAsciiValues()).c();
                    }
                    throw ae.p(this.f431208c, i3, h19.getSimpleName() + " must include generic type (e.g., " + h19.getSimpleName() + "<String>)", new Object[0]);
                }
                if (h19.isArray()) {
                    return new t.f(value3, this.f431206a.i(a(h19.getComponentType()), annotationArr), header.allowUnsafeNonAsciiValues()).b();
                }
                return new t.f(value3, this.f431206a.i(type, annotationArr), header.allowUnsafeNonAsciiValues());
            }
            if (annotation instanceof HeaderMap) {
                if (type == Headers.class) {
                    return new t.h(this.f431208c, i3);
                }
                j(i3, type);
                Class<?> h26 = ae.h(type);
                if (Map.class.isAssignableFrom(h26)) {
                    Type i17 = ae.i(type, h26, Map.class);
                    if (i17 instanceof ParameterizedType) {
                        ParameterizedType parameterizedType2 = (ParameterizedType) i17;
                        Type g17 = ae.g(0, parameterizedType2);
                        if (String.class == g17) {
                            return new t.g(this.f431208c, i3, this.f431206a.i(ae.g(1, parameterizedType2), annotationArr), ((HeaderMap) annotation).allowUnsafeNonAsciiValues());
                        }
                        throw ae.p(this.f431208c, i3, "@HeaderMap keys must be of type String: " + g17, new Object[0]);
                    }
                    throw ae.p(this.f431208c, i3, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                throw ae.p(this.f431208c, i3, "@HeaderMap parameter type must be Map or Headers.", new Object[0]);
            }
            if (annotation instanceof Field) {
                j(i3, type);
                if (this.f431222q) {
                    Field field = (Field) annotation;
                    String value4 = field.value();
                    boolean encoded3 = field.encoded();
                    this.f431212g = true;
                    Class<?> h27 = ae.h(type);
                    if (Iterable.class.isAssignableFrom(h27)) {
                        if (type instanceof ParameterizedType) {
                            return new t.d(value4, this.f431206a.i(ae.g(0, (ParameterizedType) type), annotationArr), encoded3).c();
                        }
                        throw ae.p(this.f431208c, i3, h27.getSimpleName() + " must include generic type (e.g., " + h27.getSimpleName() + "<String>)", new Object[0]);
                    }
                    if (h27.isArray()) {
                        return new t.d(value4, this.f431206a.i(a(h27.getComponentType()), annotationArr), encoded3).b();
                    }
                    return new t.d(value4, this.f431206a.i(type, annotationArr), encoded3);
                }
                throw ae.p(this.f431208c, i3, "@Field parameters can only be used with form encoding.", new Object[0]);
            }
            if (annotation instanceof FieldMap) {
                j(i3, type);
                if (this.f431222q) {
                    Class<?> h28 = ae.h(type);
                    if (Map.class.isAssignableFrom(h28)) {
                        Type i18 = ae.i(type, h28, Map.class);
                        if (i18 instanceof ParameterizedType) {
                            ParameterizedType parameterizedType3 = (ParameterizedType) i18;
                            Type g18 = ae.g(0, parameterizedType3);
                            if (String.class == g18) {
                                h i19 = this.f431206a.i(ae.g(1, parameterizedType3), annotationArr);
                                this.f431212g = true;
                                return new t.e(this.f431208c, i3, i19, ((FieldMap) annotation).encoded());
                            }
                            throw ae.p(this.f431208c, i3, "@FieldMap keys must be of type String: " + g18, new Object[0]);
                        }
                        throw ae.p(this.f431208c, i3, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                    }
                    throw ae.p(this.f431208c, i3, "@FieldMap parameter type must be Map.", new Object[0]);
                }
                throw ae.p(this.f431208c, i3, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
            }
            if (annotation instanceof Part) {
                j(i3, type);
                if (this.f431223r) {
                    Part part = (Part) annotation;
                    this.f431213h = true;
                    String value5 = part.value();
                    Class<?> h29 = ae.h(type);
                    if (value5.isEmpty()) {
                        if (Iterable.class.isAssignableFrom(h29)) {
                            if (type instanceof ParameterizedType) {
                                if (MultipartBody.Part.class.isAssignableFrom(ae.h(ae.g(0, (ParameterizedType) type)))) {
                                    return t.o.f431357a.c();
                                }
                                throw ae.p(this.f431208c, i3, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                            }
                            throw ae.p(this.f431208c, i3, h29.getSimpleName() + " must include generic type (e.g., " + h29.getSimpleName() + "<String>)", new Object[0]);
                        }
                        if (h29.isArray()) {
                            if (MultipartBody.Part.class.isAssignableFrom(h29.getComponentType())) {
                                return t.o.f431357a.b();
                            }
                            throw ae.p(this.f431208c, i3, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                        }
                        if (MultipartBody.Part.class.isAssignableFrom(h29)) {
                            return t.o.f431357a;
                        }
                        throw ae.p(this.f431208c, i3, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    }
                    Headers of5 = Headers.of(HttpHeader.RSP.CONTENT_DISPOSITION, "form-data; name=\"" + value5 + "\"", "Content-Transfer-Encoding", part.encoding());
                    if (Iterable.class.isAssignableFrom(h29)) {
                        if (type instanceof ParameterizedType) {
                            Type g19 = ae.g(0, (ParameterizedType) type);
                            if (!MultipartBody.Part.class.isAssignableFrom(ae.h(g19))) {
                                return new t.i(this.f431208c, i3, of5, this.f431206a.g(g19, annotationArr, this.f431209d)).c();
                            }
                            throw ae.p(this.f431208c, i3, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                        }
                        throw ae.p(this.f431208c, i3, h29.getSimpleName() + " must include generic type (e.g., " + h29.getSimpleName() + "<String>)", new Object[0]);
                    }
                    if (h29.isArray()) {
                        Class<?> a16 = a(h29.getComponentType());
                        if (!MultipartBody.Part.class.isAssignableFrom(a16)) {
                            return new t.i(this.f431208c, i3, of5, this.f431206a.g(a16, annotationArr, this.f431209d)).b();
                        }
                        throw ae.p(this.f431208c, i3, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                    if (!MultipartBody.Part.class.isAssignableFrom(h29)) {
                        return new t.i(this.f431208c, i3, of5, this.f431206a.g(type, annotationArr, this.f431209d));
                    }
                    throw ae.p(this.f431208c, i3, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                }
                throw ae.p(this.f431208c, i3, "@Part parameters can only be used with multipart encoding.", new Object[0]);
            }
            if (annotation instanceof PartMap) {
                j(i3, type);
                if (this.f431223r) {
                    this.f431213h = true;
                    Class<?> h36 = ae.h(type);
                    if (Map.class.isAssignableFrom(h36)) {
                        Type i26 = ae.i(type, h36, Map.class);
                        if (i26 instanceof ParameterizedType) {
                            ParameterizedType parameterizedType4 = (ParameterizedType) i26;
                            Type g26 = ae.g(0, parameterizedType4);
                            if (String.class == g26) {
                                Type g27 = ae.g(1, parameterizedType4);
                                if (!MultipartBody.Part.class.isAssignableFrom(ae.h(g27))) {
                                    return new t.j(this.f431208c, i3, this.f431206a.g(g27, annotationArr, this.f431209d), ((PartMap) annotation).encoding());
                                }
                                throw ae.p(this.f431208c, i3, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                            }
                            throw ae.p(this.f431208c, i3, "@PartMap keys must be of type String: " + g26, new Object[0]);
                        }
                        throw ae.p(this.f431208c, i3, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                    }
                    throw ae.p(this.f431208c, i3, "@PartMap parameter type must be Map.", new Object[0]);
                }
                throw ae.p(this.f431208c, i3, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
            }
            if (annotation instanceof Body) {
                j(i3, type);
                if (!this.f431222q && !this.f431223r) {
                    if (!this.f431214i) {
                        try {
                            h g28 = this.f431206a.g(type, annotationArr, this.f431209d);
                            this.f431214i = true;
                            return new t.c(this.f431208c, i3, g28);
                        } catch (RuntimeException e16) {
                            throw ae.q(this.f431208c, e16, i3, "Unable to create @Body converter for %s", type);
                        }
                    }
                    throw ae.p(this.f431208c, i3, "Multiple @Body method annotations found.", new Object[0]);
                }
                throw ae.p(this.f431208c, i3, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
            }
            if (!(annotation instanceof Tag)) {
                return null;
            }
            j(i3, type);
            Class<?> h37 = ae.h(type);
            for (int i27 = i3 - 1; i27 >= 0; i27--) {
                t<?> tVar = this.f431228w[i27];
                if ((tVar instanceof t.q) && ((t.q) tVar).f431360a.equals(h37)) {
                    throw ae.p(this.f431208c, i3, "@Tag type " + h37.getName() + " is duplicate of " + u.f431362b.a(this.f431208c, i27) + " and would always overwrite its value.", new Object[0]);
                }
            }
            return new t.q(h37);
        }

        static Set<String> h(String str) {
            Matcher matcher = f431204y.matcher(str);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            while (matcher.find()) {
                linkedHashSet.add(matcher.group(1));
            }
            return linkedHashSet;
        }

        private void i(int i3, String str) {
            if (f431205z.matcher(str).matches()) {
                if (this.f431227v.contains(str)) {
                    return;
                } else {
                    throw ae.p(this.f431208c, i3, "URL \"%s\" does not contain \"{%s}\".", this.f431224s, str);
                }
            }
            throw ae.p(this.f431208c, i3, "@Path parameter name must match %s. Found: %s", f431204y.pattern(), str);
        }

        private void j(int i3, Type type) {
            if (!ae.j(type)) {
            } else {
                throw ae.p(this.f431208c, i3, "Parameter type must not include a type variable or wildcard: %s", type);
            }
        }

        aa b() {
            for (Annotation annotation : this.f431209d) {
                e(annotation);
            }
            if (this.f431220o != null) {
                if (!this.f431221p) {
                    if (!this.f431223r) {
                        if (this.f431222q) {
                            throw ae.n(this.f431208c, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                        }
                    } else {
                        throw ae.n(this.f431208c, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                    }
                }
                int length = this.f431210e.length;
                this.f431228w = new t[length];
                int i3 = length - 1;
                int i16 = 0;
                while (true) {
                    boolean z16 = true;
                    if (i16 >= length) {
                        break;
                    }
                    t<?>[] tVarArr = this.f431228w;
                    Type type = this.f431211f[i16];
                    Annotation[] annotationArr = this.f431210e[i16];
                    if (i16 != i3) {
                        z16 = false;
                    }
                    tVarArr[i16] = f(i16, type, annotationArr, z16);
                    i16++;
                }
                if (this.f431224s == null && !this.f431219n) {
                    throw ae.n(this.f431208c, "Missing either @%s URL or @Url parameter.", this.f431220o);
                }
                boolean z17 = this.f431222q;
                if (!z17 && !this.f431223r && !this.f431221p && this.f431214i) {
                    throw ae.n(this.f431208c, "Non-body HTTP method cannot contain @Body.", new Object[0]);
                }
                if (z17 && !this.f431212g) {
                    throw ae.n(this.f431208c, "Form-encoded method must contain at least one @Field.", new Object[0]);
                }
                if (this.f431223r && !this.f431213h) {
                    throw ae.n(this.f431208c, "Multipart method must contain at least one @Part.", new Object[0]);
                }
                return new aa(this);
            }
            throw ae.n(this.f431208c, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
        }
    }

    aa(a aVar) {
        this.f431192a = aVar.f431207b;
        this.f431193b = aVar.f431208c;
        this.f431194c = aVar.f431206a.f431235c;
        this.f431195d = aVar.f431220o;
        this.f431196e = aVar.f431224s;
        this.f431197f = aVar.f431225t;
        this.f431198g = aVar.f431226u;
        this.f431199h = aVar.f431221p;
        this.f431200i = aVar.f431222q;
        this.f431201j = aVar.f431223r;
        this.f431202k = aVar.f431228w;
        this.f431203l = aVar.f431229x;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static aa b(ac acVar, Class<?> cls, Method method) {
        return new a(acVar, cls, method).b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Request a(@Nullable Object obj, Object[] objArr) throws IOException {
        t<?>[] tVarArr = this.f431202k;
        int length = objArr.length;
        if (length == tVarArr.length) {
            z zVar = new z(this.f431195d, this.f431194c, this.f431196e, this.f431197f, this.f431198g, this.f431199h, this.f431200i, this.f431201j);
            if (this.f431203l) {
                length--;
            }
            ArrayList arrayList = new ArrayList(length);
            for (int i3 = 0; i3 < length; i3++) {
                arrayList.add(objArr[i3]);
                tVarArr[i3].a(zVar, objArr[i3]);
            }
            return zVar.k().tag(q.class, new q(this.f431192a, obj, this.f431193b, arrayList)).build();
        }
        throw new IllegalArgumentException("Argument count (" + length + ") doesn't match expected count (" + tVarArr.length + ")");
    }
}
