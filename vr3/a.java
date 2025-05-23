package vr3;

import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.qmethod.pandoraex.core.k;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a<T> {

    /* renamed from: a, reason: collision with root package name */
    public String f443216a;

    /* renamed from: b, reason: collision with root package name */
    public String f443217b;

    /* renamed from: c, reason: collision with root package name */
    public final Set<String> f443218c = new HashSet();

    /* renamed from: d, reason: collision with root package name */
    public final Set<String> f443219d = new HashSet();

    /* renamed from: e, reason: collision with root package name */
    public T f443220e;

    /* renamed from: f, reason: collision with root package name */
    public Class f443221f;

    /* renamed from: g, reason: collision with root package name */
    public String f443222g;

    /* renamed from: h, reason: collision with root package name */
    public String f443223h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f443224i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f443225j;

    /* renamed from: k, reason: collision with root package name */
    public Lock f443226k;

    /* renamed from: l, reason: collision with root package name */
    public long f443227l;

    /* renamed from: m, reason: collision with root package name */
    private k<T> f443228m;

    /* compiled from: P */
    /* renamed from: vr3.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static class C11438a<T> {

        /* renamed from: a, reason: collision with root package name */
        private String f443229a;

        /* renamed from: b, reason: collision with root package name */
        private String f443230b;

        /* renamed from: c, reason: collision with root package name */
        private Class<T> f443231c;

        /* renamed from: d, reason: collision with root package name */
        private final Set<String> f443232d = new HashSet();

        /* renamed from: e, reason: collision with root package name */
        private final Set<String> f443233e = new HashSet();

        /* renamed from: f, reason: collision with root package name */
        private T f443234f;

        /* renamed from: g, reason: collision with root package name */
        private k<T> f443235g;

        /* renamed from: h, reason: collision with root package name */
        private String f443236h;

        /* renamed from: i, reason: collision with root package name */
        private String f443237i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f443238j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f443239k;

        /* renamed from: l, reason: collision with root package name */
        private Lock f443240l;

        /* renamed from: m, reason: collision with root package name */
        private long f443241m;

        public static <T> C11438a<T> n(k<T> kVar) {
            return o(kVar).k(true).b("cache_only").b("memory");
        }

        public static <T> C11438a<T> o(k<T> kVar) {
            return new C11438a().b("ban").i(kVar);
        }

        public static <T> C11438a<T> p(k<T> kVar) {
            return n(kVar).b(QQPermissionConstants.Permission.STORAGE_GROUP);
        }

        public C11438a<T> a(String str) {
            this.f443233e.add(str);
            return this;
        }

        public C11438a<T> b(String str) {
            this.f443232d.add(str);
            return this;
        }

        public C11438a<T> c(String str) {
            this.f443230b = str;
            return this;
        }

        public a<T> d() {
            a<T> aVar = new a<>();
            aVar.f443216a = this.f443229a;
            aVar.f443217b = this.f443230b;
            aVar.f443218c.addAll(this.f443232d);
            aVar.f443219d.addAll(this.f443233e);
            aVar.f443220e = this.f443234f;
            aVar.f443221f = this.f443231c;
            aVar.f443222g = this.f443236h;
            aVar.f443223h = this.f443237i;
            aVar.f443224i = this.f443238j;
            aVar.f443225j = this.f443239k;
            aVar.f443226k = this.f443240l;
            aVar.f443227l = this.f443241m;
            ((a) aVar).f443228m = this.f443235g;
            return aVar;
        }

        public T e() throws Throwable {
            return (T) com.tencent.qmethod.pandoraex.core.b.d().b(d(), this.f443235g, null, new Object[0]);
        }

        public C11438a<T> f(String str) {
            this.f443229a = str;
            return this;
        }

        public C11438a<T> g(long j3) {
            this.f443241m = j3;
            return this;
        }

        public C11438a<T> h(Lock lock) {
            this.f443240l = lock;
            return this;
        }

        public C11438a<T> i(k<T> kVar) {
            this.f443235g = kVar;
            return this;
        }

        public C11438a<T> j(T t16) {
            this.f443234f = t16;
            return this;
        }

        public C11438a<T> k(boolean z16) {
            this.f443238j = z16;
            return this;
        }

        public C11438a<T> l(String str, String str2) {
            this.f443236h = str;
            this.f443237i = str2;
            return this;
        }

        public C11438a<T> m(Class cls) {
            this.f443231c = cls;
            return this;
        }
    }

    public Object b(Object obj) {
        k<T> kVar = this.f443228m;
        if (kVar != null && obj != null) {
            return kVar.convertFrom(obj);
        }
        return obj;
    }

    public Object c(Object obj) {
        k<T> kVar = this.f443228m;
        if (kVar == null) {
            return obj;
        }
        return kVar.convertTo(obj);
    }

    public boolean d() {
        return this.f443218c.contains("memory");
    }
}
