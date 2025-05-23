package t74;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes36.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final String f435532a = "c";

    /* renamed from: b, reason: collision with root package name */
    private static long f435533b;

    public static String a(Context context) {
        String str = Build.FINGERPRINT;
        return str == null ? "" : str;
    }

    public static long b() {
        if (MobileQQ.sMobileQQ == null) {
            QLog.i(f435532a, 1, "getTotalMemorySize application null ");
            return 0L;
        }
        long j3 = f435533b;
        if (j3 != 0) {
            return j3;
        }
        ActivityManager activityManager = (ActivityManager) MobileQQ.sMobileQQ.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        long j16 = memoryInfo.totalMem / 1048576;
        f435533b = j16;
        return j16;
    }
}
