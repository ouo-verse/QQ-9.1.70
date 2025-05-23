package w5;

import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static String f444605a = "b";

    public static void a(String str, int i3, String str2) {
        QLog.d(str, i3, str2);
    }

    public static void b(String str, int i3, String str2) {
        a c16 = a.c(str);
        c16.d(str2, new Object[0]);
        e(c16, i3);
    }

    public static void c(String str, int i3, Throwable th5, Object... objArr) {
        StringBuilder sb5 = new StringBuilder((objArr.length * 30) + (th5 == null ? 0 : 128));
        for (Object obj : objArr) {
            if (obj != null) {
                sb5.append(obj.toString());
            }
        }
        a c16 = a.c(str);
        c16.d(sb5.toString(), new Object[0]);
        f(c16, i3, th5);
    }

    public static void g(String str, int i3, String str2) {
        if (!AppSetting.s()) {
            QLog.e(str, i3, str2);
            return;
        }
        throw new RuntimeException(str2);
    }

    public static void h(String str, int i3, Throwable th5) {
        if (!AppSetting.s()) {
            QLog.e(str, i3, th5, new Object[0]);
            return;
        }
        throw new RuntimeException(th5);
    }

    public static void i(String str, int i3, String str2) {
        QLog.i(str, i3, str2);
    }

    public static void j(String str, int i3, String str2) {
        QLog.w(str, i3, str2);
    }

    public static void d(String str, int i3, Object... objArr) {
        c(str, i3, null, objArr);
    }

    public static void e(a aVar, int i3) {
        f(aVar, i3, null);
    }

    public static void f(a aVar, int i3, Throwable th5) {
        if (aVar == null) {
            a c16 = a.c(f444605a);
            c16.d("error info is null", new Object[0]).a("maybe forget instantiate").b("check call stack where trigger");
            e(c16, 1);
        } else if (i3 != 2 || QLog.isColorLevel()) {
            QLog.e(aVar.f444600a, i3, aVar.toString(), th5);
        }
    }
}
