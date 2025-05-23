package wy2;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a {
    public static boolean a() {
        if (b("meizu", null, null)) {
            return true;
        }
        return false;
    }

    public static boolean b(String str, String str2, String str3) {
        boolean z16;
        if (!TextUtils.isEmpty(str)) {
            z16 = str.equalsIgnoreCase(Build.MANUFACTURER);
        } else {
            z16 = false;
        }
        if (!z16) {
            return z16;
        }
        if (!TextUtils.isEmpty(str2)) {
            z16 = str2.equalsIgnoreCase(Build.BRAND);
        }
        if (!z16) {
            return z16;
        }
        if (!TextUtils.isEmpty(str3)) {
            return str3.equalsIgnoreCase(DeviceInfoMonitor.getModel());
        }
        return z16;
    }
}
