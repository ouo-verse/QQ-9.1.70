package wy2;

import android.os.Build;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;

/* compiled from: P */
/* loaded from: classes20.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f446751a = true;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f446752b = true;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f446753c = true;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f446754d = true;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f446755e = true;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f446756f = true;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f446757g = true;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f446758h = true;

    /* renamed from: i, reason: collision with root package name */
    public static boolean f446759i = true;

    /* renamed from: j, reason: collision with root package name */
    public static boolean f446760j = true;

    /* renamed from: k, reason: collision with root package name */
    public static boolean f446761k = true;

    /* renamed from: l, reason: collision with root package name */
    public static boolean f446762l = false;

    /* renamed from: m, reason: collision with root package name */
    public static boolean f446763m = false;

    /* renamed from: n, reason: collision with root package name */
    public static int f446764n;

    static {
        String model = DeviceInfoMonitor.getModel();
        String str = Build.MANUFACTURER;
        if (str.equalsIgnoreCase("htc")) {
            e.a().f(model);
            return;
        }
        if (!str.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING) && !str.equalsIgnoreCase("samsng")) {
            if (str.equalsIgnoreCase("motorola")) {
                e.a().k(model);
                return;
            }
            if (str.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HUAWEI)) {
                e.a().g(model);
                return;
            }
            if (str.equalsIgnoreCase("zte")) {
                e.a().q(model);
                return;
            }
            if (str.equalsIgnoreCase("meizu")) {
                e.a().j(model);
                return;
            }
            if (str.equalsIgnoreCase("alps")) {
                e.a().b(model);
                return;
            }
            if (!str.equalsIgnoreCase("k-touch") && !str.equalsIgnoreCase("sprd")) {
                if (!str.equalsIgnoreCase("yulong") && !str.equalsIgnoreCase("coolpad")) {
                    if (str.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_LENOVO)) {
                        e.a().i(model);
                        return;
                    }
                    if (str.equalsIgnoreCase("bbk")) {
                        e.a().n(model);
                        return;
                    }
                    if (str.equalsIgnoreCase("gionee")) {
                        e.a().e(model);
                        return;
                    }
                    if (str.equalsIgnoreCase("eton")) {
                        e.a().d(model);
                        return;
                    }
                    if (str.equalsIgnoreCase("doov")) {
                        e.a().c(model);
                        return;
                    } else if (str.equalsIgnoreCase("sony ericsson")) {
                        e.a().m(model);
                        return;
                    } else {
                        if ("xiaomi".equalsIgnoreCase(str)) {
                            e.a().o(model);
                            return;
                        }
                        return;
                    }
                }
                e.a().p(model);
                return;
            }
            e.a().h(model);
            return;
        }
        e.a().l(model);
    }
}
