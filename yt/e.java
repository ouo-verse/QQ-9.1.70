package yt;

import android.content.SharedPreferences;
import com.tencent.av.utils.af;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static int f451166a;

    /* renamed from: b, reason: collision with root package name */
    private static Boolean f451167b;

    /* renamed from: c, reason: collision with root package name */
    private static Boolean f451168c;

    private static int a(String str) {
        f451166a = BaseApplication.getContext().getSharedPreferences("qav_ui_exp_root", 0).getInt("exp_qq_qav_ui_icons_0518" + str, 0);
        QLog.d("QavUIABTestUtils", 1, "getABTestExpFromSP value:=" + f451166a);
        return f451166a;
    }

    private static int b() {
        if (b.f("exp_qq_qav_ui_icons_0518", "exp_qq_qav_ui_icons_0518_B")) {
            return 2;
        }
        if (b.f("exp_qq_qav_ui_icons_0518", "exp_qq_qav_ui_icons_0518_C")) {
            return 3;
        }
        if (b.f("exp_qq_qav_ui_icons_0518", "exp_qq_qav_ui_icons_0518_D")) {
            return 4;
        }
        if (b.d("exp_qq_qav_ui_icons_0518")) {
            return 1;
        }
        return 0;
    }

    public static boolean c(String str) {
        if (f451167b != null) {
            g(str);
            return f451167b.booleanValue();
        }
        int b16 = af.b();
        boolean z16 = false;
        if (d()) {
            if (af.b() == 3 || af.b() == 4) {
                z16 = true;
            }
            f451167b = Boolean.valueOf(z16);
            QLog.d("QavUIABTestUtils", 1, "isCameraExp switchValue:=" + b16);
            return f451167b.booleanValue();
        }
        int a16 = a(str);
        if (a16 == 3 || a16 == 4) {
            z16 = true;
        }
        Boolean valueOf = Boolean.valueOf(z16);
        f451167b = valueOf;
        if (valueOf.booleanValue()) {
            QLog.d("QavUIABTestUtils", 1, "isCameraExp sp fit");
        }
        boolean f16 = b.f("exp_qq_qav_ui_icons_0518", "exp_qq_qav_ui_icons_0518_C");
        boolean f17 = b.f("exp_qq_qav_ui_icons_0518", "exp_qq_qav_ui_icons_0518_D");
        if (f16 || f17) {
            QLog.d("QavUIABTestUtils", 1, "isCameraExp hasExpC:=" + f16 + ", hasExpD:=" + f17);
            f451167b = Boolean.TRUE;
        }
        f();
        QLog.d("QavUIABTestUtils", 1, "isCameraExp sCurrentCameraExp:=" + f451167b);
        return f451167b.booleanValue();
    }

    private static boolean d() {
        int b16 = af.b();
        if (b16 >= 1 && b16 <= 4) {
            return true;
        }
        return false;
    }

    private static void e(String str, int i3) {
        SharedPreferences.Editor edit = BaseApplication.getContext().getSharedPreferences("qav_ui_exp_root", 0).edit();
        edit.putInt("exp_qq_qav_ui_icons_0518" + str, i3);
        edit.commit();
        f451166a = i3;
    }

    private static void f() {
        int b16;
        if (f451168c == null && (b16 = b()) >= 1 && b16 <= 4 && b.g("exp_qq_qav_ui_icons_0518")) {
            f451168c = Boolean.TRUE;
        }
    }

    public static void g(String str) {
        if (d()) {
            return;
        }
        int b16 = b();
        if (b16 != f451166a) {
            e(str, b16);
            QLog.d("QavUIABTestUtils", 1, "updateABTestLocalSpValue expValue:=" + b16);
        }
        f();
    }
}
