package qe4;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.lang.reflect.Method;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static String f428887a;

    public static String a(Context context) {
        if (!TextUtils.isEmpty(f428887a)) {
            return f428887a;
        }
        String d16 = d();
        f428887a = d16;
        if (!TextUtils.isEmpty(d16)) {
            return f428887a;
        }
        String c16 = c();
        f428887a = c16;
        if (!TextUtils.isEmpty(c16)) {
            return f428887a;
        }
        String b16 = b(context);
        f428887a = b16;
        return b16;
    }

    public static String b(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null) {
            return null;
        }
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        if (activityManager != null && (runningAppProcesses = SystemMethodProxy.getRunningAppProcesses(activityManager)) != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return null;
    }

    public static String c() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            if (!(invoke instanceof String)) {
                return null;
            }
            return (String) invoke;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }

    public static String d() {
        String processName;
        if (Build.VERSION.SDK_INT >= 28) {
            processName = Application.getProcessName();
            return processName;
        }
        return null;
    }
}
