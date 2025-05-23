package y64;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class a {
    public static float a(@NonNull Context context, int i3) {
        return TypedValue.applyDimension(1, i3, context.getResources().getDisplayMetrics());
    }

    public static float b(@NonNull DisplayMetrics displayMetrics, float f16) {
        return TypedValue.applyDimension(1, f16, displayMetrics);
    }

    public static float c(@NonNull DisplayMetrics displayMetrics, int i3) {
        return TypedValue.applyDimension(1, i3, displayMetrics);
    }

    public static boolean d(View view, float f16, float f17) {
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

    public static boolean e(View view, MotionEvent motionEvent) {
        return d(view, motionEvent.getRawX(), motionEvent.getRawY());
    }
}
