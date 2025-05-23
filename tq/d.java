package tq;

import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.ttpic.baseutils.report.ReportUtil;
import org.light.PerformanceMonitor;
import org.light.utils.LightLogUtil;

/* compiled from: P */
/* loaded from: classes36.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static int f437091a;

    /* renamed from: b, reason: collision with root package name */
    private static int f437092b;

    public static void a() {
        boolean c16 = AECameraPrefsUtil.f().c("KEY_LIGHT_SDK_PERF_SWITCH", false, 4);
        ms.a.f("LightPerformance", "ReportUtil.setEnablePerfReport:" + c16);
        b(c16);
    }

    public static boolean c() {
        if (f437092b != 0) {
            return false;
        }
        a();
        return false;
    }

    public static void d() {
        if (c()) {
            int i3 = f437091a + 1;
            f437091a = i3;
            if (i3 % 100 == 0) {
                ms.a.f("LightPerformance", "lightSDK performance:\n" + PerformanceMonitor.getPerformanceData());
            }
        }
    }

    public static void e(boolean z16) {
        ms.a.f("LightPerformance", "setPerformanceEnable:" + z16);
        AECameraPrefsUtil.f().l("KEY_LIGHT_SDK_PERF_SWITCH", z16, 4);
        b(z16);
    }

    private static void b(boolean z16) {
        f437092b = z16 ? 2 : 1;
        ReportUtil.setEnablePerfReport(z16);
        try {
            LightLogUtil.setMinPriority(z16 ? 3 : 6);
        } catch (Throwable th5) {
            ms.a.c("LightPerformance", "initParams :error!" + th5.getMessage());
        }
        f437091a = 0;
    }
}
