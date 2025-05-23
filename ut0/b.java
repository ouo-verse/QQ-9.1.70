package ut0;

import android.graphics.Point;
import android.view.WindowManager;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class b {
    public static int a() {
        WindowManager windowManager = (WindowManager) BaseApplication.getContext().getSystemService("window");
        if (windowManager == null) {
            return -1;
        }
        Point point = new Point();
        windowManager.getDefaultDisplay().getRealSize(point);
        return point.y;
    }

    public static int b() {
        WindowManager windowManager = (WindowManager) BaseApplication.getContext().getSystemService("window");
        if (windowManager == null) {
            return -1;
        }
        Point point = new Point();
        windowManager.getDefaultDisplay().getRealSize(point);
        return point.x;
    }

    public static boolean c() {
        if (BaseApplication.getContext().getResources().getConfiguration().orientation == 2) {
            return true;
        }
        return false;
    }
}
