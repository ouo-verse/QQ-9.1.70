package w53;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes21.dex */
public class b {
    public static void c(@NonNull String str, @NonNull String str2) {
        QLog.e("MODULE_GY_WINK :" + str, 1, str2);
    }

    public static void d(@NonNull String str, @NonNull String str2, @Nullable Throwable th5) {
        QLog.e("MODULE_GY_WINK :" + str, 1, str2, th5);
    }

    public static void e(@NonNull String str, @Nullable Throwable th5) {
        QLog.e("MODULE_GY_WINK :" + str, 1, th5, new Object[0]);
    }

    public static void f(@NonNull String str, @NonNull String str2) {
        QLog.i("MODULE_GY_WINK :" + str, 1, str2);
    }

    public static void g(@NonNull String str, @NonNull String str2) {
        QLog.w("MODULE_GY_WINK :" + str, 1, str2);
    }

    public static void h(@NonNull String str, @NonNull String str2, @Nullable Throwable th5) {
        QLog.w("MODULE_GY_WINK :" + str, 1, str2, th5);
    }

    public static void a(@NonNull String str, @NonNull String str2) {
    }

    public static void b(@NonNull String str, @NonNull String str2, @Nullable Throwable th5) {
    }
}
