package wy3;

import android.util.Log;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes25.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f446775a;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    private static class a implements com.tencent.mobileqq.qqperftool.common.d {
        a() {
        }

        public void a(String str, String str2, Throwable th5) {
            QLog.d(str, 2, str2, th5);
        }

        public void b(String str, String str2, Throwable th5) {
            QLog.w(str, 1, str2, th5);
        }

        @Override // com.tencent.mobileqq.qqperftool.common.d
        public void d(String str, String str2) {
            QLog.d(str, 2, str2);
        }

        @Override // com.tencent.mobileqq.qqperftool.common.d
        public void e(String str, String str2, Throwable th5) {
            QLog.e(str, 1, str2, th5);
        }

        @Override // com.tencent.mobileqq.qqperftool.common.d
        public void i(String str, String str2) {
            QLog.d(str, 2, str2);
        }

        @Override // com.tencent.mobileqq.qqperftool.common.d
        public void w(String str, String str2) {
            QLog.w(str, 1, str2);
        }

        @Override // com.tencent.mobileqq.qqperftool.common.d
        public void e(String str, String str2) {
            QLog.e(str, 1, str2);
        }
    }

    public static void a(String str, String str2) {
        if (f446775a != null) {
            f446775a.d(str, str2);
        } else {
            Log.d(str, str2);
        }
    }

    public static void b(String str, String str2, Throwable th5) {
        if (f446775a != null) {
            f446775a.a(str, str2, th5);
        } else {
            Log.d(str, str2, th5);
        }
    }

    public static void c(String str, String str2) {
        if (f446775a != null) {
            f446775a.e(str, str2);
        } else {
            Log.e(str, str2);
        }
    }

    public static void d(String str, String str2, Throwable th5) {
        if (f446775a != null) {
            f446775a.e(str, str2, th5);
        } else {
            Log.e(str, str2, th5);
        }
    }

    public static void e(String str, String str2) {
        if (f446775a != null) {
            f446775a.i(str, str2);
        } else {
            Log.i(str, str2);
        }
    }

    public static boolean f() {
        if (f446775a == null) {
            f446775a = new a();
            if (!wy3.a.f().m(f446775a)) {
                f446775a = null;
            }
        }
        if (f446775a != null) {
            return true;
        }
        return false;
    }

    public static void g(String str, String str2) {
        if (f446775a != null) {
            f446775a.w(str, str2);
        } else {
            Log.w(str, str2);
        }
    }

    public static void h(String str, String str2, Throwable th5) {
        if (f446775a != null) {
            f446775a.b(str, str2, th5);
        } else {
            Log.w(str, str2, th5);
        }
    }
}
