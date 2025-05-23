package retrofit2;

import com.tencent.mtt.hippy.adapter.http.HttpHeader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class t<T> {

    /* compiled from: P */
    /* loaded from: classes29.dex */
    class a extends t<Iterable<T>> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.t
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(z zVar, @Nullable Iterable<T> iterable) throws IOException {
            if (iterable == null) {
                return;
            }
            Iterator<T> it = iterable.iterator();
            while (it.hasNext()) {
                t.this.a(zVar, it.next());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    class b extends t<Object> {
        b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // retrofit2.t
        void a(z zVar, @Nullable Object obj) throws IOException {
            if (obj == null) {
                return;
            }
            int length = Array.getLength(obj);
            for (int i3 = 0; i3 < length; i3++) {
                t.this.a(zVar, Array.get(obj, i3));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static final class c<T> extends t<T> {

        /* renamed from: a, reason: collision with root package name */
        private final Method f431316a;

        /* renamed from: b, reason: collision with root package name */
        private final int f431317b;

        /* renamed from: c, reason: collision with root package name */
        private final retrofit2.h<T, RequestBody> f431318c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(Method method, int i3, retrofit2.h<T, RequestBody> hVar) {
            this.f431316a = method;
            this.f431317b = i3;
            this.f431318c = hVar;
        }

        @Override // retrofit2.t
        void a(z zVar, @Nullable T t16) {
            if (t16 != null) {
                try {
                    zVar.l(this.f431318c.convert(t16));
                    return;
                } catch (IOException e16) {
                    throw ae.q(this.f431316a, e16, this.f431317b, "Unable to convert " + t16 + " to RequestBody", new Object[0]);
                }
            }
            throw ae.p(this.f431316a, this.f431317b, "Body parameter value must not be null.", new Object[0]);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static final class d<T> extends t<T> {

        /* renamed from: a, reason: collision with root package name */
        private final String f431319a;

        /* renamed from: b, reason: collision with root package name */
        private final retrofit2.h<T, String> f431320b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f431321c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public d(String str, retrofit2.h<T, String> hVar, boolean z16) {
            Objects.requireNonNull(str, "name == null");
            this.f431319a = str;
            this.f431320b = hVar;
            this.f431321c = z16;
        }

        @Override // retrofit2.t
        void a(z zVar, @Nullable T t16) throws IOException {
            String convert;
            if (t16 == null || (convert = this.f431320b.convert(t16)) == null) {
                return;
            }
            zVar.a(this.f431319a, convert, this.f431321c);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static final class e<T> extends t<Map<String, T>> {

        /* renamed from: a, reason: collision with root package name */
        private final Method f431322a;

        /* renamed from: b, reason: collision with root package name */
        private final int f431323b;

        /* renamed from: c, reason: collision with root package name */
        private final retrofit2.h<T, String> f431324c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f431325d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public e(Method method, int i3, retrofit2.h<T, String> hVar, boolean z16) {
            this.f431322a = method;
            this.f431323b = i3;
            this.f431324c = hVar;
            this.f431325d = z16;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.t
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(z zVar, @Nullable Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        T value = entry.getValue();
                        if (value != null) {
                            String convert = this.f431324c.convert(value);
                            if (convert != null) {
                                zVar.a(key, convert, this.f431325d);
                            } else {
                                throw ae.p(this.f431322a, this.f431323b, "Field map value '" + value + "' converted to null by " + this.f431324c.getClass().getName() + " for key '" + key + "'.", new Object[0]);
                            }
                        } else {
                            throw ae.p(this.f431322a, this.f431323b, "Field map contained null value for key '" + key + "'.", new Object[0]);
                        }
                    } else {
                        throw ae.p(this.f431322a, this.f431323b, "Field map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw ae.p(this.f431322a, this.f431323b, "Field map was null.", new Object[0]);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static final class f<T> extends t<T> {

        /* renamed from: a, reason: collision with root package name */
        private final String f431326a;

        /* renamed from: b, reason: collision with root package name */
        private final retrofit2.h<T, String> f431327b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f431328c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public f(String str, retrofit2.h<T, String> hVar, boolean z16) {
            Objects.requireNonNull(str, "name == null");
            this.f431326a = str;
            this.f431327b = hVar;
            this.f431328c = z16;
        }

        @Override // retrofit2.t
        void a(z zVar, @Nullable T t16) throws IOException {
            String convert;
            if (t16 == null || (convert = this.f431327b.convert(t16)) == null) {
                return;
            }
            zVar.b(this.f431326a, convert, this.f431328c);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static final class g<T> extends t<Map<String, T>> {

        /* renamed from: a, reason: collision with root package name */
        private final Method f431329a;

        /* renamed from: b, reason: collision with root package name */
        private final int f431330b;

        /* renamed from: c, reason: collision with root package name */
        private final retrofit2.h<T, String> f431331c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f431332d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public g(Method method, int i3, retrofit2.h<T, String> hVar, boolean z16) {
            this.f431329a = method;
            this.f431330b = i3;
            this.f431331c = hVar;
            this.f431332d = z16;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.t
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(z zVar, @Nullable Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        T value = entry.getValue();
                        if (value != null) {
                            zVar.b(key, this.f431331c.convert(value), this.f431332d);
                        } else {
                            throw ae.p(this.f431329a, this.f431330b, "Header map contained null value for key '" + key + "'.", new Object[0]);
                        }
                    } else {
                        throw ae.p(this.f431329a, this.f431330b, "Header map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw ae.p(this.f431329a, this.f431330b, "Header map was null.", new Object[0]);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static final class h extends t<Headers> {

        /* renamed from: a, reason: collision with root package name */
        private final Method f431333a;

        /* renamed from: b, reason: collision with root package name */
        private final int f431334b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public h(Method method, int i3) {
            this.f431333a = method;
            this.f431334b = i3;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.t
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(z zVar, @Nullable Headers headers) {
            if (headers != null) {
                zVar.c(headers);
                return;
            }
            throw ae.p(this.f431333a, this.f431334b, "Headers parameter must not be null.", new Object[0]);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static final class i<T> extends t<T> {

        /* renamed from: a, reason: collision with root package name */
        private final Method f431335a;

        /* renamed from: b, reason: collision with root package name */
        private final int f431336b;

        /* renamed from: c, reason: collision with root package name */
        private final Headers f431337c;

        /* renamed from: d, reason: collision with root package name */
        private final retrofit2.h<T, RequestBody> f431338d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(Method method, int i3, Headers headers, retrofit2.h<T, RequestBody> hVar) {
            this.f431335a = method;
            this.f431336b = i3;
            this.f431337c = headers;
            this.f431338d = hVar;
        }

        @Override // retrofit2.t
        void a(z zVar, @Nullable T t16) {
            if (t16 == null) {
                return;
            }
            try {
                zVar.d(this.f431337c, this.f431338d.convert(t16));
            } catch (IOException e16) {
                throw ae.p(this.f431335a, this.f431336b, "Unable to convert " + t16 + " to RequestBody", e16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static final class j<T> extends t<Map<String, T>> {

        /* renamed from: a, reason: collision with root package name */
        private final Method f431339a;

        /* renamed from: b, reason: collision with root package name */
        private final int f431340b;

        /* renamed from: c, reason: collision with root package name */
        private final retrofit2.h<T, RequestBody> f431341c;

        /* renamed from: d, reason: collision with root package name */
        private final String f431342d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(Method method, int i3, retrofit2.h<T, RequestBody> hVar, String str) {
            this.f431339a = method;
            this.f431340b = i3;
            this.f431341c = hVar;
            this.f431342d = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.t
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(z zVar, @Nullable Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        T value = entry.getValue();
                        if (value != null) {
                            zVar.d(Headers.of(HttpHeader.RSP.CONTENT_DISPOSITION, "form-data; name=\"" + key + "\"", "Content-Transfer-Encoding", this.f431342d), this.f431341c.convert(value));
                        } else {
                            throw ae.p(this.f431339a, this.f431340b, "Part map contained null value for key '" + key + "'.", new Object[0]);
                        }
                    } else {
                        throw ae.p(this.f431339a, this.f431340b, "Part map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw ae.p(this.f431339a, this.f431340b, "Part map was null.", new Object[0]);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static final class k<T> extends t<T> {

        /* renamed from: a, reason: collision with root package name */
        private final Method f431343a;

        /* renamed from: b, reason: collision with root package name */
        private final int f431344b;

        /* renamed from: c, reason: collision with root package name */
        private final String f431345c;

        /* renamed from: d, reason: collision with root package name */
        private final retrofit2.h<T, String> f431346d;

        /* renamed from: e, reason: collision with root package name */
        private final boolean f431347e;

        /* JADX INFO: Access modifiers changed from: package-private */
        public k(Method method, int i3, String str, retrofit2.h<T, String> hVar, boolean z16) {
            this.f431343a = method;
            this.f431344b = i3;
            Objects.requireNonNull(str, "name == null");
            this.f431345c = str;
            this.f431346d = hVar;
            this.f431347e = z16;
        }

        @Override // retrofit2.t
        void a(z zVar, @Nullable T t16) throws IOException {
            if (t16 != null) {
                zVar.f(this.f431345c, this.f431346d.convert(t16), this.f431347e);
                return;
            }
            throw ae.p(this.f431343a, this.f431344b, "Path parameter \"" + this.f431345c + "\" value must not be null.", new Object[0]);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static final class l<T> extends t<T> {

        /* renamed from: a, reason: collision with root package name */
        private final String f431348a;

        /* renamed from: b, reason: collision with root package name */
        private final retrofit2.h<T, String> f431349b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f431350c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public l(String str, retrofit2.h<T, String> hVar, boolean z16) {
            Objects.requireNonNull(str, "name == null");
            this.f431348a = str;
            this.f431349b = hVar;
            this.f431350c = z16;
        }

        @Override // retrofit2.t
        void a(z zVar, @Nullable T t16) throws IOException {
            String convert;
            if (t16 == null || (convert = this.f431349b.convert(t16)) == null) {
                return;
            }
            zVar.g(this.f431348a, convert, this.f431350c);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static final class m<T> extends t<Map<String, T>> {

        /* renamed from: a, reason: collision with root package name */
        private final Method f431351a;

        /* renamed from: b, reason: collision with root package name */
        private final int f431352b;

        /* renamed from: c, reason: collision with root package name */
        private final retrofit2.h<T, String> f431353c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f431354d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public m(Method method, int i3, retrofit2.h<T, String> hVar, boolean z16) {
            this.f431351a = method;
            this.f431352b = i3;
            this.f431353c = hVar;
            this.f431354d = z16;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.t
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(z zVar, @Nullable Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        T value = entry.getValue();
                        if (value != null) {
                            String convert = this.f431353c.convert(value);
                            if (convert != null) {
                                zVar.g(key, convert, this.f431354d);
                            } else {
                                throw ae.p(this.f431351a, this.f431352b, "Query map value '" + value + "' converted to null by " + this.f431353c.getClass().getName() + " for key '" + key + "'.", new Object[0]);
                            }
                        } else {
                            throw ae.p(this.f431351a, this.f431352b, "Query map contained null value for key '" + key + "'.", new Object[0]);
                        }
                    } else {
                        throw ae.p(this.f431351a, this.f431352b, "Query map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw ae.p(this.f431351a, this.f431352b, "Query map was null", new Object[0]);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static final class n<T> extends t<T> {

        /* renamed from: a, reason: collision with root package name */
        private final retrofit2.h<T, String> f431355a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f431356b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public n(retrofit2.h<T, String> hVar, boolean z16) {
            this.f431355a = hVar;
            this.f431356b = z16;
        }

        @Override // retrofit2.t
        void a(z zVar, @Nullable T t16) throws IOException {
            if (t16 == null) {
                return;
            }
            zVar.g(this.f431355a.convert(t16), null, this.f431356b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static final class o extends t<MultipartBody.Part> {

        /* renamed from: a, reason: collision with root package name */
        static final o f431357a = new o();

        o() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.t
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(z zVar, @Nullable MultipartBody.Part part) {
            if (part != null) {
                zVar.e(part);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static final class p extends t<Object> {

        /* renamed from: a, reason: collision with root package name */
        private final Method f431358a;

        /* renamed from: b, reason: collision with root package name */
        private final int f431359b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public p(Method method, int i3) {
            this.f431358a = method;
            this.f431359b = i3;
        }

        @Override // retrofit2.t
        void a(z zVar, @Nullable Object obj) {
            if (obj != null) {
                zVar.m(obj);
                return;
            }
            throw ae.p(this.f431358a, this.f431359b, "@Url parameter is null.", new Object[0]);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static final class q<T> extends t<T> {

        /* renamed from: a, reason: collision with root package name */
        final Class<T> f431360a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public q(Class<T> cls) {
            this.f431360a = cls;
        }

        @Override // retrofit2.t
        void a(z zVar, @Nullable T t16) {
            zVar.h(this.f431360a, t16);
        }
    }

    t() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(z zVar, @Nullable T t16) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final t<Object> b() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final t<Iterable<T>> c() {
        return new a();
    }
}
