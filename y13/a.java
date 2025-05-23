package y13;

import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    @QAutoInject(configPath = "AutoInjectYml/Business/Vas/Inject_AppSetting.yml", version = 1)
    public static com.tencent.mobileqq.inject.b f449270a;

    /* renamed from: b, reason: collision with root package name */
    private static ArrayList f449271b;

    static {
        ArrayList arrayList = new ArrayList();
        f449271b = arrayList;
        arrayList.add(com.tencent.mobileqq.injector.d.class);
        a();
    }

    @QAutoInitMethod
    static void a() {
        f449270a = (com.tencent.mobileqq.inject.b) com.tencent.mobileqq.qroute.utils.b.a(f449271b);
    }
}
