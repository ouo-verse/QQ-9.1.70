package yn4;

import android.graphics.drawable.Drawable;
import androidx.annotation.ColorRes;
import androidx.annotation.StringRes;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c {
    public static int a(@ColorRes int i3) {
        return BaseApplication.getContext().getResources().getColor(i3);
    }

    public static Drawable b(int i3) {
        return BaseApplication.getContext().getResources().getDrawable(i3);
    }

    public static String c(@StringRes int i3) {
        return BaseApplication.getContext().getResources().getString(i3);
    }
}
