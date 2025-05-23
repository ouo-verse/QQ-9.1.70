package q53;

import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes21.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, String> f428423a;

    /* renamed from: b, reason: collision with root package name */
    private HashMap<String, Object> f428424b;

    /* compiled from: P */
    /* renamed from: q53.a$a, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public static final class C11057a {

        /* renamed from: a, reason: collision with root package name */
        protected static final a f428425a = new a();
    }

    private void a() {
        if (this.f428424b == null) {
            this.f428424b = new HashMap<>();
        }
    }

    private void b() {
        if (this.f428423a == null) {
            this.f428423a = new HashMap<>();
        }
    }

    public static a d() {
        return C11057a.f428425a;
    }

    private String e(String str) {
        return ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount() + "_" + str;
    }

    public String c(String str) {
        HashMap<String, String> hashMap = this.f428423a;
        if (hashMap == null) {
            return null;
        }
        return hashMap.get(e(str));
    }

    public void f(String str, String str2) {
        b();
        this.f428423a.put(e(str), str2);
    }

    public void g(String str, Object obj) {
        a();
        this.f428424b.put(e(str), obj);
    }
}
