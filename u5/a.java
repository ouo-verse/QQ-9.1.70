package u5;

import android.util.DisplayMetrics;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static float f438263a = 0.0f;

    /* renamed from: b, reason: collision with root package name */
    public static int f438264b = 0;

    /* renamed from: c, reason: collision with root package name */
    public static int f438265c = 0;

    /* renamed from: d, reason: collision with root package name */
    public static int f438266d = 0;

    /* renamed from: e, reason: collision with root package name */
    public static String f438267e = null;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f438268f = false;

    static {
        DisplayMetrics displayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
        f438263a = displayMetrics.density;
        f438264b = displayMetrics.widthPixels;
        f438265c = displayMetrics.heightPixels;
        f438266d = displayMetrics.densityDpi;
        f438267e = ("screen_width=" + f438264b) + ContainerUtils.FIELD_DELIMITER + ("screen_height=" + f438265c);
    }

    public static float a() {
        return f438263a;
    }

    public static int b() {
        return f438266d;
    }

    public static int c() {
        return BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
    }

    public static int d() {
        return ViewUtils.getScreenWidth();
    }

    public static boolean e() {
        return f438268f;
    }

    public static void f() {
        DisplayMetrics displayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
        f438264b = displayMetrics.widthPixels;
        f438265c = displayMetrics.heightPixels;
    }

    public static void g(boolean z16) {
        f438268f = z16;
    }
}
