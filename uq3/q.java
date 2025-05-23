package uq3;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
@Deprecated
/* loaded from: classes22.dex */
public class q {
    public static String a(Context context, String str) {
        if (context != null) {
            SharedPreferences a16 = g.a(QMMKVFile.PREFIX_2, true, true);
            if (a16 != null) {
                return a16.getString(str, "");
            }
            QLog.e("SharePreferenceUtils", 1, "get error,sp is null!");
        }
        return "";
    }

    private static void b(String str, String str2) {
        SharedPreferences a16 = g.a(QMMKVFile.PREFIX_2, true, true);
        if (a16 != null) {
            SharedPreferences.Editor edit = a16.edit();
            edit.putString(str, str2);
            edit.apply();
            return;
        }
        QLog.e("SharePreferenceUtils", 1, "save error,sp is null!");
    }

    public static void c(Context context, String str, String str2) {
        b(str, str2);
    }
}
