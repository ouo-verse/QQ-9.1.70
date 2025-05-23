package vh4;

import android.content.Context;
import android.os.Build;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static int f441699a;

    public static boolean a(Context context) {
        if (f441699a == 0) {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 26 && i3 < 28 && LiuHaiUtils.hasNotchInScreen_AndroidO(context)) {
                if (QLog.isColorLevel()) {
                    QLog.d("FloatingScreenUtils", 2, "AndroidO With Notch in Screen.");
                }
                f441699a = 1;
            } else {
                f441699a = 2;
            }
        }
        if (f441699a == 1) {
            return true;
        }
        return false;
    }
}
