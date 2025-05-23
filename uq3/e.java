package uq3;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class e {

    /* renamed from: b, reason: collision with root package name */
    private static volatile e f439804b;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, QRouteApi> f439805a = new HashMap(0);

    e() {
    }

    public static e b() {
        if (f439804b == null) {
            synchronized (e.class) {
                if (f439804b == null) {
                    f439804b = new e();
                }
            }
        }
        return f439804b;
    }

    private <T extends QRouteApi> void c(String str, QRouteApi qRouteApi) {
        if (qRouteApi == null) {
            return;
        }
        this.f439805a.put(str, qRouteApi);
    }

    public <T extends QRouteApi> T a(Class<T> cls) {
        String name = cls.getName();
        T t16 = (T) this.f439805a.get(name);
        if (t16 == null) {
            T t17 = (T) QRoute.api(cls);
            c(name, t17);
            return t17;
        }
        return t16;
    }
}
