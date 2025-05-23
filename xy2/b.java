package xy2;

import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.FloatRange;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import com.tencent.mapsdk.internal.by;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<double[]> f449076a = new ThreadLocal<>();

    public static double a(@ColorInt int i3, @ColorInt int i16) {
        if (Color.alpha(i16) == 255) {
            if (Color.alpha(i3) < 255) {
                i3 = g(i3, i16);
            }
            double b16 = b(i3) + 0.05d;
            double b17 = b(i16) + 0.05d;
            return Math.max(b16, b17) / Math.min(b16, b17);
        }
        throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i16));
    }

    @FloatRange(from = 0.0d, to = by.f147964a)
    public static double b(@ColorInt int i3) {
        double[] l3 = l();
        e(i3, l3);
        return l3[1] / 100.0d;
    }

    public static int c(@ColorInt int i3, @ColorInt int i16, float f16) {
        int i17 = 255;
        if (Color.alpha(i16) == 255) {
            double d16 = f16;
            if (a(m(i3, 255), i16) < d16) {
                return -1;
            }
            int i18 = 0;
            for (int i19 = 0; i19 <= 10 && i17 - i18 > 1; i19++) {
                int i26 = (i18 + i17) / 2;
                if (a(m(i3, i26), i16) < d16) {
                    i18 = i26;
                } else {
                    i17 = i26;
                }
            }
            return i17;
        }
        throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i16));
    }

    public static void d(@ColorInt int i3, @NonNull float[] fArr) {
        j(Color.red(i3), Color.green(i3), Color.blue(i3), fArr);
    }

    public static void e(@ColorInt int i3, @NonNull double[] dArr) {
        k(Color.red(i3), Color.green(i3), Color.blue(i3), dArr);
    }

    private static int f(int i3, int i16) {
        return 255 - (((255 - i16) * (255 - i3)) / 255);
    }

    public static int g(@ColorInt int i3, @ColorInt int i16) {
        int alpha = Color.alpha(i16);
        int alpha2 = Color.alpha(i3);
        int f16 = f(alpha2, alpha);
        return Color.argb(f16, h(Color.red(i3), alpha2, Color.red(i16), alpha, f16), h(Color.green(i3), alpha2, Color.green(i16), alpha, f16), h(Color.blue(i3), alpha2, Color.blue(i16), alpha, f16));
    }

    private static int h(int i3, int i16, int i17, int i18, int i19) {
        if (i19 == 0) {
            return 0;
        }
        return (((i3 * 255) * i16) + ((i17 * i18) * (255 - i16))) / (i19 * 255);
    }

    private static float i(float f16, float f17, float f18) {
        if (f16 < f17) {
            return f17;
        }
        if (f16 > f18) {
            return f18;
        }
        return f16;
    }

    public static void j(@IntRange(from = 0, to = 255) int i3, @IntRange(from = 0, to = 255) int i16, @IntRange(from = 0, to = 255) int i17, @NonNull float[] fArr) {
        float f16;
        float abs;
        float f17 = i3 / 255.0f;
        float f18 = i16 / 255.0f;
        float f19 = i17 / 255.0f;
        float max = Math.max(f17, Math.max(f18, f19));
        float min = Math.min(f17, Math.min(f18, f19));
        float f26 = max - min;
        float f27 = (max + min) / 2.0f;
        if (max == min) {
            f16 = 0.0f;
            abs = 0.0f;
        } else {
            if (max == f17) {
                f16 = ((f18 - f19) / f26) % 6.0f;
            } else if (max == f18) {
                f16 = ((f19 - f17) / f26) + 2.0f;
            } else {
                f16 = 4.0f + ((f17 - f18) / f26);
            }
            abs = f26 / (1.0f - Math.abs((2.0f * f27) - 1.0f));
        }
        float f28 = (f16 * 60.0f) % 360.0f;
        if (f28 < 0.0f) {
            f28 += 360.0f;
        }
        fArr[0] = i(f28, 0.0f, 360.0f);
        fArr[1] = i(abs, 0.0f, 1.0f);
        fArr[2] = i(f27, 0.0f, 1.0f);
    }

    public static void k(@IntRange(from = 0, to = 255) int i3, @IntRange(from = 0, to = 255) int i16, @IntRange(from = 0, to = 255) int i17, @NonNull double[] dArr) {
        double pow;
        double pow2;
        double pow3;
        if (dArr.length == 3) {
            double d16 = i3 / 255.0d;
            if (d16 < 0.04045d) {
                pow = d16 / 12.92d;
            } else {
                pow = Math.pow((d16 + 0.055d) / 1.055d, 2.4d);
            }
            double d17 = i16 / 255.0d;
            if (d17 < 0.04045d) {
                pow2 = d17 / 12.92d;
            } else {
                pow2 = Math.pow((d17 + 0.055d) / 1.055d, 2.4d);
            }
            double d18 = i17 / 255.0d;
            if (d18 < 0.04045d) {
                pow3 = d18 / 12.92d;
            } else {
                pow3 = Math.pow((d18 + 0.055d) / 1.055d, 2.4d);
            }
            dArr[0] = ((0.4124d * pow) + (0.3576d * pow2) + (0.1805d * pow3)) * 100.0d;
            dArr[1] = ((0.2126d * pow) + (0.7152d * pow2) + (0.0722d * pow3)) * 100.0d;
            dArr[2] = ((pow * 0.0193d) + (pow2 * 0.1192d) + (pow3 * 0.9505d)) * 100.0d;
            return;
        }
        throw new IllegalArgumentException("outXyz must have a length of 3.");
    }

    private static double[] l() {
        ThreadLocal<double[]> threadLocal = f449076a;
        double[] dArr = threadLocal.get();
        if (dArr == null) {
            double[] dArr2 = new double[3];
            threadLocal.set(dArr2);
            return dArr2;
        }
        return dArr;
    }

    @ColorInt
    public static int m(@ColorInt int i3, @IntRange(from = 0, to = 255) int i16) {
        if (i16 >= 0 && i16 <= 255) {
            return (i3 & 16777215) | (i16 << 24);
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }
}
