package rx.internal.util.unsafe;

/* loaded from: classes29.dex */
public final class Pow2 {
    Pow2() {
        throw new IllegalStateException("No instances!");
    }

    public static boolean isPowerOfTwo(int i3) {
        if ((i3 & (i3 - 1)) == 0) {
            return true;
        }
        return false;
    }

    public static int roundToPowerOfTwo(int i3) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i3 - 1));
    }
}
