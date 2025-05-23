package v84;

import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {
    public static String a() {
        return TPReportKeys.Common.COMMON_ONLINE;
    }

    public static String b() {
        SimpleAccount firstSimpleAccount = MobileQQ.sMobileQQ.getFirstSimpleAccount();
        if (firstSimpleAccount != null) {
            return firstSimpleAccount.getUin();
        }
        return "";
    }

    public static void c(String str, String str2) {
        QLog.e("ZplanDatabase_" + str, 1, str2);
    }

    public static void d(String str, String str2, Throwable th5) {
        QLog.e("ZplanDatabase_" + str, 1, str2, th5);
    }

    public static void e(String str, String str2) {
        QLog.i("ZplanDatabase_" + str, 1, str2);
    }
}
