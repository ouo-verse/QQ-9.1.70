package v1;

/* compiled from: P */
/* loaded from: classes2.dex */
final class d {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(b bVar) {
        return b(bVar, true) + b(bVar, false);
    }

    private static int b(b bVar, boolean z16) {
        int e16;
        int d16;
        byte b16;
        if (z16) {
            e16 = bVar.d();
        } else {
            e16 = bVar.e();
        }
        if (z16) {
            d16 = bVar.e();
        } else {
            d16 = bVar.d();
        }
        byte[][] c16 = bVar.c();
        int i3 = 0;
        for (int i16 = 0; i16 < e16; i16++) {
            byte b17 = -1;
            int i17 = 0;
            for (int i18 = 0; i18 < d16; i18++) {
                if (z16) {
                    b16 = c16[i16][i18];
                } else {
                    b16 = c16[i18][i16];
                }
                if (b16 == b17) {
                    i17++;
                } else {
                    if (i17 >= 5) {
                        i3 += (i17 - 5) + 3;
                    }
                    i17 = 1;
                    b17 = b16;
                }
            }
            if (i17 > 5) {
                i3 += (i17 - 5) + 3;
            }
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(b bVar) {
        byte[][] c16 = bVar.c();
        int e16 = bVar.e();
        int d16 = bVar.d();
        int i3 = 0;
        for (int i16 = 0; i16 < d16 - 1; i16++) {
            int i17 = 0;
            while (i17 < e16 - 1) {
                byte[] bArr = c16[i16];
                byte b16 = bArr[i17];
                int i18 = i17 + 1;
                if (b16 == bArr[i18]) {
                    byte[] bArr2 = c16[i16 + 1];
                    if (b16 == bArr2[i17] && b16 == bArr2[i18]) {
                        i3++;
                    }
                }
                i17 = i18;
            }
        }
        return i3 * 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(b bVar) {
        int i3;
        int i16;
        int i17;
        int i18;
        byte[][] c16 = bVar.c();
        int e16 = bVar.e();
        int d16 = bVar.d();
        int i19 = 0;
        for (int i26 = 0; i26 < d16; i26++) {
            for (int i27 = 0; i27 < e16; i27++) {
                int i28 = i27 + 6;
                if (i28 < e16) {
                    byte[] bArr = c16[i26];
                    if (bArr[i27] == 1 && bArr[i27 + 1] == 0 && bArr[i27 + 2] == 1 && bArr[i27 + 3] == 1 && bArr[i27 + 4] == 1 && bArr[i27 + 5] == 0 && bArr[i28] == 1 && (((i17 = i27 + 10) < e16 && bArr[i27 + 7] == 0 && bArr[i27 + 8] == 0 && bArr[i27 + 9] == 0 && bArr[i17] == 0) || (i27 - 4 >= 0 && bArr[i27 - 1] == 0 && bArr[i27 - 2] == 0 && bArr[i27 - 3] == 0 && bArr[i18] == 0))) {
                        i19 += 40;
                    }
                }
                int i29 = i26 + 6;
                if (i29 < d16 && c16[i26][i27] == 1 && c16[i26 + 1][i27] == 0 && c16[i26 + 2][i27] == 1 && c16[i26 + 3][i27] == 1 && c16[i26 + 4][i27] == 1 && c16[i26 + 5][i27] == 0 && c16[i29][i27] == 1 && (((i3 = i26 + 10) < d16 && c16[i26 + 7][i27] == 0 && c16[i26 + 8][i27] == 0 && c16[i26 + 9][i27] == 0 && c16[i3][i27] == 0) || (i26 - 4 >= 0 && c16[i26 - 1][i27] == 0 && c16[i26 - 2][i27] == 0 && c16[i26 - 3][i27] == 0 && c16[i16][i27] == 0))) {
                    i19 += 40;
                }
            }
        }
        return i19;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(b bVar) {
        byte[][] c16 = bVar.c();
        int e16 = bVar.e();
        int d16 = bVar.d();
        int i3 = 0;
        for (int i16 = 0; i16 < d16; i16++) {
            byte[] bArr = c16[i16];
            for (int i17 = 0; i17 < e16; i17++) {
                if (bArr[i17] == 1) {
                    i3++;
                }
            }
        }
        return ((int) (Math.abs((i3 / (bVar.d() * bVar.e())) - 0.5d) * 20.0d)) * 10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0001. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0046 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean f(int i3, int i16, int i17) {
        int i18;
        int i19;
        int i26;
        int i27;
        switch (i3) {
            case 0:
                i17 += i16;
            case 1:
                i18 = i17 & 1;
                if (i18 == 0) {
                    return true;
                }
                return false;
            case 2:
                i18 = i16 % 3;
                if (i18 == 0) {
                }
                break;
            case 3:
                i18 = (i17 + i16) % 3;
                if (i18 == 0) {
                }
                break;
            case 4:
                i19 = i17 >>> 1;
                i26 = i16 / 3;
                i27 = i19 + i26;
                i18 = i27 & 1;
                if (i18 == 0) {
                }
                break;
            case 5:
                int i28 = i17 * i16;
                i18 = (i28 & 1) + (i28 % 3);
                if (i18 == 0) {
                }
                break;
            case 6:
                int i29 = i17 * i16;
                i27 = (i29 & 1) + (i29 % 3);
                i18 = i27 & 1;
                if (i18 == 0) {
                }
                break;
            case 7:
                i19 = (i17 * i16) % 3;
                i26 = (i17 + i16) & 1;
                i27 = i19 + i26;
                i18 = i27 & 1;
                if (i18 == 0) {
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid mask pattern: " + i3);
        }
    }
}
