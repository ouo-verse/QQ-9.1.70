package r1;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import java.math.RoundingMode;
import s1.c;

/* compiled from: P */
@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    static final byte[] f430457a = {9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0};

    /* renamed from: b, reason: collision with root package name */
    @VisibleForTesting
    static final int[] f430458b = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};

    /* renamed from: c, reason: collision with root package name */
    @VisibleForTesting
    static final int[] f430459c = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, Integer.MAX_VALUE};

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f430460d = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600};

    /* renamed from: e, reason: collision with root package name */
    @VisibleForTesting
    static int[] f430461e = {Integer.MAX_VALUE, Integer.MAX_VALUE, 65536, 2345, 477, 193, 110, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33};

    /* compiled from: P */
    /* renamed from: r1.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class C11104a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f430462a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            f430462a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f430462a[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f430462a[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f430462a[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f430462a[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f430462a[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f430462a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f430462a[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static boolean a(int i3) {
        boolean z16;
        boolean z17 = false;
        if (i3 > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if ((i3 & (i3 - 1)) == 0) {
            z17 = true;
        }
        return z16 & z17;
    }

    @VisibleForTesting
    static int b(int i3, int i16) {
        return (~(~(i3 - i16))) >>> 31;
    }

    public static int c(int i3, RoundingMode roundingMode) {
        b.a(HippyTKDListViewAdapter.X, i3);
        switch (C11104a.f430462a[roundingMode.ordinal()]) {
            case 1:
                b.b(a(i3));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 32 - Integer.numberOfLeadingZeros(i3 - 1);
            case 6:
            case 7:
            case 8:
                int numberOfLeadingZeros = Integer.numberOfLeadingZeros(i3);
                return (31 - numberOfLeadingZeros) + b((-1257966797) >>> numberOfLeadingZeros, i3);
            default:
                throw new AssertionError();
        }
        return 31 - Integer.numberOfLeadingZeros(i3);
    }

    @Beta
    public static int d(int i3, int i16) {
        return c.b(i3 + i16);
    }

    @Beta
    public static int e(int i3, int i16) {
        return c.b(i3 * i16);
    }
}
