package wz0;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a {
    public static double a(int i3) {
        return b(i3, 44100, 2, 2);
    }

    public static double b(int i3, int i16, int i17, int i18) {
        return (((i3 / i17) / i18) / i16) * 1000.0d;
    }

    public static int c(int i3) {
        return d(i3, 44100, 2, 2);
    }

    public static int d(int i3, int i16, int i17, int i18) {
        return ((int) ((i3 / 1000.0f) * i16)) * i17 * i18;
    }

    public static int e(float f16) {
        return ((int) (f16 * 44100.0f)) * 2 * 2;
    }
}
