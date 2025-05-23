package yt;

import com.tencent.av.abtest.api.IQavABTestApi;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class b {
    private static IQavABTestApi a(String str) {
        return ((IQavABTestApi) QRoute.api(IQavABTestApi.class)).loadExperiment(str);
    }

    public static String b(String str) {
        IQavABTestApi a16 = a(str);
        if (a16 == null) {
            return "";
        }
        return a16.getAssignment();
    }

    public static String c(String str) {
        IQavABTestApi a16 = a(str);
        if (a16 == null) {
            return "";
        }
        return a16.getGrayId();
    }

    public static boolean d(String str) {
        IQavABTestApi a16 = a(str);
        if (a16 == null || a16.isExperiment() || !a16.isContrast()) {
            return false;
        }
        return true;
    }

    public static boolean e(String str) {
        IQavABTestApi a16 = a(str);
        if (a16 == null) {
            return false;
        }
        if (a16.isExperiment()) {
            return true;
        }
        a16.isContrast();
        return false;
    }

    public static boolean f(String str, String str2) {
        IQavABTestApi a16 = a(str);
        if (a16 != null && a16.isExpHit(str2)) {
            return true;
        }
        return false;
    }

    public static boolean g(String str) {
        IQavABTestApi a16 = a(str);
        if (a16 == null) {
            return false;
        }
        return a16.reportExpExposure();
    }
}
