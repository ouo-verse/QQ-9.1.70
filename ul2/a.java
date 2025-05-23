package ul2;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.mobileqq.activity.qwallet.utils.OSUtils;
import com.tencent.mobileqq.qwallet.utils.d;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private Activity f439135a;

    /* renamed from: b, reason: collision with root package name */
    private Window f439136b;

    /* renamed from: c, reason: collision with root package name */
    private View f439137c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f439138d;

    /* renamed from: e, reason: collision with root package name */
    private int f439139e;

    /* renamed from: f, reason: collision with root package name */
    private int f439140f = 0;

    public a(Activity activity, int i3, View view) {
        this.f439135a = activity;
        this.f439136b = activity.getWindow();
        this.f439137c = view;
        this.f439139e = i3;
        a(i3);
    }

    private void a(int i3) {
        boolean z16;
        try {
            if (ImmersiveUtils.isSupporImmersive() == 1) {
                int i16 = Build.VERSION.SDK_INT;
                boolean z17 = false;
                int i17 = 256;
                if (!OSUtils.isEMUI3_1()) {
                    if (this.f439137c != null) {
                        i17 = 1280;
                    }
                    i17 = d(i17);
                    this.f439136b.clearFlags(67108864);
                    this.f439136b.addFlags(Integer.MIN_VALUE);
                    this.f439136b.setStatusBarColor(0);
                } else {
                    this.f439136b.addFlags(4194304);
                }
                this.f439136b.getDecorView().setSystemUiVisibility(i17);
                if (i16 >= 24) {
                    z17 = this.f439135a.isInMultiWindowMode();
                    z16 = this.f439135a.isInPictureInPictureMode();
                } else {
                    z16 = false;
                }
                if (this.f439137c != null && !z17 && !z16) {
                    e(i3);
                }
            }
        } catch (Throwable th5) {
            QLog.e("ImmersionBar", 1, "initStateBar: ", th5);
        }
    }

    public static boolean b() {
        if (!OSUtils.isMIUI6More()) {
            OSUtils.isFlymeOS4More();
            return true;
        }
        return true;
    }

    private static void c(Window window, boolean z16) {
        if (window != null) {
            Class<?> cls = window.getClass();
            try {
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i3 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
                Class<?> cls3 = Integer.TYPE;
                Method method = cls.getMethod("setExtraFlags", cls3, cls3);
                if (z16) {
                    method.invoke(window, Integer.valueOf(i3), Integer.valueOf(i3));
                } else {
                    method.invoke(window, 0, Integer.valueOf(i3));
                }
            } catch (Exception e16) {
                QLog.e("ImmersionBar", 1, "error msg in qqpay-api module: ", e16);
            }
        }
    }

    private int d(int i3) {
        if (this.f439138d) {
            return i3 | 8192;
        }
        return i3;
    }

    private void e(int i3) {
        ViewGroup.LayoutParams layoutParams = this.f439137c.getLayoutParams();
        layoutParams.height = ImmersiveUtils.getStatusBarHeight(this.f439135a);
        this.f439137c.setLayoutParams(layoutParams);
        int i16 = this.f439140f;
        if (i16 != 0) {
            this.f439137c.setBackgroundResource(i16);
        } else {
            this.f439137c.setBackgroundColor(i3);
        }
    }

    public void f(boolean z16) {
        this.f439138d = z16;
        try {
            if (b()) {
                a(this.f439139e);
                if (OSUtils.isMIUI6More()) {
                    c(this.f439136b, z16);
                }
                if (OSUtils.isFlymeOS4More()) {
                    d.b(this.f439135a, z16);
                }
            }
        } catch (Exception e16) {
            QLog.e("ImmersionBar", 1, "error msg in qqpay-api module: ", e16);
        }
    }
}
