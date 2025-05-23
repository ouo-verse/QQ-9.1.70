package zr;

import android.view.MotionEvent;

/* compiled from: P */
/* loaded from: classes36.dex */
public class e {
    public static float b(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() > 1) {
            return c(motionEvent.getX(1) - motionEvent.getX(0), motionEvent.getY(1) - motionEvent.getY(0));
        }
        return 0.0f;
    }

    public static float c(float f16, float f17) {
        float f18;
        float degrees = (float) Math.toDegrees(Math.asin(f17 / e(f16, f17)));
        if (!Float.isNaN(degrees)) {
            if (f17 >= 0.0f && f16 >= 0.0f) {
                return degrees;
            }
            if (f17 < 0.0f || f16 > 0.0f) {
                if (f17 <= 0.0f && f16 >= 0.0f) {
                    return degrees;
                }
                f18 = (f17 <= 0.0f && f16 <= 0.0f) ? -180.0f : 180.0f;
            }
            return f18 - degrees;
        }
        return 0.0f;
    }

    public static float d(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() > 1) {
            return e(motionEvent.getX(0) - motionEvent.getX(1), motionEvent.getY(0) - motionEvent.getY(1));
        }
        return 1.0f;
    }

    public static float[] a(MotionEvent motionEvent) {
        float[] fArr = new float[2];
        if (motionEvent.getPointerCount() > 1) {
            fArr[0] = (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
            fArr[1] = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
        }
        return fArr;
    }

    public static float e(float f16, float f17) {
        float sqrt = (float) Math.sqrt((f16 * f16) + (f17 * f17));
        if (Float.isNaN(sqrt)) {
            return 1.0f;
        }
        return sqrt;
    }
}
