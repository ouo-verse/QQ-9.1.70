package uq3;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes22.dex */
public class h {
    public static String a(String str, String str2, String str3) {
        try {
            if (c(str)) {
                return str;
            }
            String[] split = str3.split(":");
            if (split.length > 1) {
                String str4 = split[0];
                String str5 = split[1];
                if (str2 == null || str2.trim().isEmpty()) {
                    str2 = b(str);
                }
                if (!str4.trim().isEmpty() && !str5.trim().isEmpty()) {
                    String replace = str.replace(str2, String.format("%s:%s", str4, str5));
                    QLog.d("QCircleUrlUtil", 1, "convertDomainToIp newUrl:" + replace);
                    return replace;
                }
            }
            QLog.d("QCircleUrlUtil", 1, "convertDomainToIp use old url");
            return str;
        } catch (Exception e16) {
            QLog.d("QCircleUrlUtil", 1, "convertDomainToIp error:" + Log.getStackTraceString(e16) + ",use old url");
            return str;
        }
    }

    public static String b(String str) {
        try {
            return Uri.parse(str).getHost();
        } catch (Exception e16) {
            QLog.d("QCircleUrlUtil", 1, "getUrlHost error:" + Log.getStackTraceString(e16));
            return null;
        }
    }

    private static boolean c(String str) {
        if (str.startsWith("/storage")) {
            QLog.d("QCircleUrlUtil", 1, "isNativeUrl local url return:" + str);
            return true;
        }
        return false;
    }

    public static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.startsWith("http://") && !str.startsWith("https://")) {
            return false;
        }
        return true;
    }
}
