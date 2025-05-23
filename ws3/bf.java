package ws3;

/* compiled from: P */
/* loaded from: classes36.dex */
public final /* synthetic */ class bf {
    public static /* synthetic */ String a(long j3, int i3) {
        long a16;
        if (j3 == 0) {
            return "0";
        }
        if (j3 > 0) {
            return Long.toString(j3, i3);
        }
        if (i3 < 2 || i3 > 36) {
            i3 = 10;
        }
        int i16 = 64;
        char[] cArr = new char[64];
        int i17 = i3 - 1;
        if ((i3 & i17) == 0) {
            int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i3);
            do {
                i16--;
                cArr[i16] = Character.forDigit(((int) j3) & i17, i3);
                j3 >>>= numberOfTrailingZeros;
            } while (j3 != 0);
        } else {
            if ((i3 & 1) == 0) {
                a16 = (j3 >>> 1) / (i3 >>> 1);
            } else {
                a16 = it0.i.a(j3, i3);
            }
            long j16 = i3;
            cArr[63] = Character.forDigit((int) (j3 - (a16 * j16)), i3);
            i16 = 63;
            while (a16 > 0) {
                i16--;
                cArr[i16] = Character.forDigit((int) (a16 % j16), i3);
                a16 /= j16;
            }
        }
        return new String(cArr, i16, 64 - i16);
    }
}
