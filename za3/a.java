package za3;

import com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback;
import com.tencent.mobileqq.winkreport.crashreport.WinkCrashReportParams;

/* compiled from: P */
/* loaded from: classes21.dex */
public final /* synthetic */ class a {
    public static String a(IWinkCrashReportCallback iWinkCrashReportCallback) {
        return null;
    }

    public static void b(IWinkCrashReportCallback iWinkCrashReportCallback) {
        WinkCrashReportParams.putFragmentParams(iWinkCrashReportCallback.getLogTag(), 0);
    }

    public static void c(IWinkCrashReportCallback iWinkCrashReportCallback) {
        WinkCrashReportParams.putFragmentParams(iWinkCrashReportCallback.getLogTag(), 1);
    }

    public static void d(IWinkCrashReportCallback iWinkCrashReportCallback) {
        WinkCrashReportParams.putFragmentParams(iWinkCrashReportCallback.getLogTag(), 2);
    }

    public static void e(IWinkCrashReportCallback iWinkCrashReportCallback, int i3) {
        WinkCrashReportParams.putFragmentParams(iWinkCrashReportCallback.getLogTag(), i3);
    }

    public static void f(IWinkCrashReportCallback iWinkCrashReportCallback) {
        WinkCrashReportParams.putFragmentParams(iWinkCrashReportCallback.getLogTag(), 9);
    }

    public static void g(IWinkCrashReportCallback iWinkCrashReportCallback) {
        WinkCrashReportParams.putFragmentParams(iWinkCrashReportCallback.getLogTag(), 8);
    }

    public static void h(IWinkCrashReportCallback iWinkCrashReportCallback, boolean z16) {
        int i3;
        String logTag = iWinkCrashReportCallback.getLogTag();
        if (z16) {
            i3 = 7;
        } else {
            i3 = 5;
        }
        WinkCrashReportParams.putFragmentParams(logTag, i3);
    }

    public static void i(IWinkCrashReportCallback iWinkCrashReportCallback) {
        WinkCrashReportParams.putFragmentParams(iWinkCrashReportCallback.getLogTag(), 6);
    }

    public static void j(IWinkCrashReportCallback iWinkCrashReportCallback) {
        WinkCrashReportParams.putFragmentParams(iWinkCrashReportCallback.getLogTag(), 4);
    }

    public static void k(IWinkCrashReportCallback iWinkCrashReportCallback) {
        WinkCrashReportParams.putFragmentParams(iWinkCrashReportCallback.getLogTag(), 3);
    }
}
