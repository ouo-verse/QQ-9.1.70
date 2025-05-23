package s5;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.album.ui.widget.NumberShiftingView;
import com.tencent.mobileqq.utils.QQTheme;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {
    public static void e(ImageView imageView) {
        if (!QQTheme.isNowThemeIsNightForQzone() || imageView == null) {
            return;
        }
        f(imageView, Color.parseColor("#999999"));
    }

    public static void f(ImageView imageView, int i3) {
        if (!QQTheme.isNowThemeIsNightForQzone() || imageView == null) {
            return;
        }
        imageView.setColorFilter(i3);
    }

    public static void g(View view) {
        if (!QQTheme.isNowThemeIsNightForQzone() || view == null) {
            return;
        }
        view.setBackgroundColor(Color.parseColor("#1A1A1A"));
    }

    public static void h(View view) {
        if (!QQTheme.isNowThemeIsNightForQzone() || view == null) {
            return;
        }
        view.setBackgroundColor(Color.parseColor("#000000"));
    }

    public static void i(ViewGroup viewGroup) {
        if (!QQTheme.isNowThemeIsNightForQzone() || viewGroup == null) {
            return;
        }
        viewGroup.setBackgroundColor(Color.parseColor("#000000"));
    }

    public static void j(EditText editText) {
        if (!QQTheme.isNowThemeIsNightForQzone() || editText == null) {
            return;
        }
        editText.setHintTextColor(Color.parseColor("#999999"));
    }

    public static void k(TextView textView) {
        if (!QQTheme.isNowThemeIsNightForQzone() || textView == null) {
            return;
        }
        textView.setTextColor(Color.parseColor("#999999"));
    }

    public static void l(NumberShiftingView numberShiftingView) {
        if (!QQTheme.isNowThemeIsNightForQzone() || numberShiftingView == null) {
            return;
        }
        numberShiftingView.setmTextColor(Color.parseColor("#999999"));
    }

    public static void m(TextView textView) {
        if (!QQTheme.isNowThemeIsNightForQzone() || textView == null) {
            return;
        }
        textView.setTextColor(Color.parseColor("#FFFFFF"));
    }

    public static void a(ImageView imageView, int i3) {
        b(imageView, i3, true);
    }

    public static void b(ImageView imageView, int i3, boolean z16) {
        if (imageView != null) {
            if (QQTheme.isNowThemeIsNightForQzone() || !z16) {
                imageView.setColorFilter(i3);
            }
        }
    }

    public static void c(ImageView imageView, int i3) {
        if (imageView == null) {
            return;
        }
        imageView.setColorFilter(imageView.getContext().getResources().getColor(i3));
    }

    public static void d(ImageView imageView, Context context, int i3, ImageView.ScaleType scaleType) {
        if (imageView == null || context == null || !QQTheme.isNowThemeIsNightForQzone()) {
            return;
        }
        imageView.setScaleType(scaleType);
        imageView.setImageDrawable(context.getDrawable(i3));
    }
}
