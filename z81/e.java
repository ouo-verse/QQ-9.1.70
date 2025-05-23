package z81;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class e {
    public static int a(String str) {
        return BaseApplication.getContext().getSharedPreferences("UniformUtils", 0).getInt(str, 0);
    }

    public static void b(String str, int i3) {
        BaseApplication.getContext().getSharedPreferences("UniformUtils", 0).edit().putInt(str, i3).commit();
    }

    public static void c(Context context, View view, boolean z16, int i3) {
        if (ScreenUtil.checkDeviceHasNavigationBar(context)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (z16) {
                i3 += ScreenUtil.getNavigationBarHeight(context);
            }
            if (marginLayoutParams.bottomMargin == i3) {
                return;
            }
            marginLayoutParams.bottomMargin = i3;
            view.setLayoutParams(marginLayoutParams);
        }
    }

    public static void d(Context context, View view) {
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            int statusBarHeight = ImmersiveUtils.getStatusBarHeight(context);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams.topMargin = statusBarHeight;
            view.setLayoutParams(marginLayoutParams);
        }
    }
}
