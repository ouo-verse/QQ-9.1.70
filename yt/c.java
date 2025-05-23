package yt;

import android.content.SharedPreferences;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static int f451163a;

    /* renamed from: b, reason: collision with root package name */
    private static Boolean f451164b;

    /* renamed from: c, reason: collision with root package name */
    private static Boolean f451165c;

    private static int a(String str) {
        f451163a = BaseApplication.getContext().getSharedPreferences("qav_ui_exp_root", 0).getInt("qq_av_camera_preview_1124" + str, 0);
        QLog.d("QavPreviewCameraABTestUtils", 1, "getABTestExpFromSP value:=" + f451163a);
        return f451163a;
    }

    private static int b() {
        if (b.f("qq_av_camera_preview_1124", "qq_av_camera_preview_1124_B")) {
            return 2;
        }
        if (b.f("qq_av_camera_preview_1124", "qq_av_camera_preview_1124_A")) {
            return 1;
        }
        return 0;
    }

    public static boolean c(String str) {
        boolean z16;
        if (f451164b != null) {
            f(str);
            QLog.d("QavPreviewCameraABTestUtils", 1, "isInviteCameraExp:=" + f451164b);
            return f451164b.booleanValue();
        }
        if (a(str) == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        Boolean valueOf = Boolean.valueOf(z16);
        f451164b = valueOf;
        if (valueOf.booleanValue()) {
            QLog.d("QavPreviewCameraABTestUtils", 1, "sCurrentOperationExp sp fit");
        }
        boolean f16 = b.f("qq_av_camera_preview_1124", "qq_av_camera_preview_1124_B");
        if (f16) {
            QLog.d("QavPreviewCameraABTestUtils", 1, "isOperationUIExp hasExpB:=" + f16);
            f451164b = Boolean.TRUE;
        }
        e();
        QLog.d("QavPreviewCameraABTestUtils", 1, "isOperationUIExp sCurrentOperationExp:=" + f451164b);
        return f451164b.booleanValue();
    }

    private static void d(String str, int i3) {
        SharedPreferences.Editor edit = BaseApplication.getContext().getSharedPreferences("qav_ui_exp_root", 0).edit();
        edit.putInt("qq_av_camera_preview_1124" + str, i3);
        edit.commit();
        f451163a = i3;
    }

    private static void e() {
        int b16;
        if (f451165c == null && (b16 = b()) >= 1 && b16 <= 2 && b.g("qq_av_camera_preview_1124")) {
            f451165c = Boolean.TRUE;
        }
    }

    private static void f(String str) {
        int b16 = b();
        if (b16 != f451163a) {
            d(str, b16);
            QLog.d("QavPreviewCameraABTestUtils", 1, "updateABTestLocalSpValue expValue:=" + b16);
        }
        e();
    }
}
