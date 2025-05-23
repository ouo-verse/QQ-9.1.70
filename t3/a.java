package t3;

import com.tencent.mobileqq.injector.ae;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final c f435344a;

    /* renamed from: b, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Coms/RefreshLayout/Inject_RefreshConfigProvider.yml", version = 1)
    private static final ArrayList<Class<? extends c>> f435345b;

    /* renamed from: c, reason: collision with root package name */
    private static c f435346c;

    /* compiled from: P */
    /* renamed from: t3.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class C11271a implements c {
        C11271a() {
        }

        @Override // t3.c
        public boolean a() {
            return false;
        }

        @Override // t3.c
        public boolean isDebugVersion() {
            return false;
        }
    }

    static {
        c c11271a = new C11271a();
        f435344a = c11271a;
        ArrayList<Class<? extends c>> arrayList = new ArrayList<>();
        f435345b = arrayList;
        arrayList.add(ae.class);
        try {
            if (!arrayList.isEmpty()) {
                c11271a = arrayList.get(0).newInstance();
            }
            f435346c = c11271a;
        } catch (Throwable unused) {
            f435346c = f435344a;
        }
    }

    public static c a() {
        return f435346c;
    }
}
