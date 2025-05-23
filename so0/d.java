package so0;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.guild.api.channel.IGuildChannelApi;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static String f434026a;

    public static boolean a() {
        if (f434026a == null) {
            f434026a = ((IGuildChannelApi) QRoute.api(IGuildChannelApi.class)).getCurrentThemeId();
            return false;
        }
        String currentThemeId = ((IGuildChannelApi) QRoute.api(IGuildChannelApi.class)).getCurrentThemeId();
        if (f434026a.equals(currentThemeId)) {
            return false;
        }
        f434026a = currentThemeId;
        return true;
    }

    public static ViewGroup.LayoutParams b(ViewGroup.LayoutParams layoutParams, int i3, int i16) {
        if (layoutParams == null) {
            return new ViewGroup.LayoutParams(i3, i16);
        }
        return layoutParams;
    }

    public static boolean c(View view, float f16, float f17) {
        if (view == null) {
            return false;
        }
        view.getLocationOnScreen(new int[2]);
        int i3 = (int) (f16 - r1[0]);
        int i16 = (int) (f17 - r1[1]);
        if (i3 < 0 || i16 < 0 || i3 >= view.getMeasuredWidth() || i16 >= view.getMeasuredHeight()) {
            return false;
        }
        return true;
    }

    public static boolean d(View view, MotionEvent motionEvent) {
        return c(view, motionEvent.getRawX(), motionEvent.getRawY());
    }
}
