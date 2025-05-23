package v1;

import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Version;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static final int[][] f440734a = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};

    /* renamed from: b, reason: collision with root package name */
    private static final int[][] f440735b = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};

    /* renamed from: c, reason: collision with root package name */
    private static final int[][] f440736c = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, 132, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, 142, 170}};

    /* renamed from: d, reason: collision with root package name */
    private static final int[][] f440737d = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.google.zxing.common.a aVar, ErrorCorrectionLevel errorCorrectionLevel, Version version, int i3, b bVar) throws WriterException {
        c(bVar);
        d(version, bVar);
        l(errorCorrectionLevel, i3, bVar);
        s(version, bVar);
        f(aVar, i3, bVar);
    }

    static int b(int i3, int i16) {
        int n3 = n(i16);
        int i17 = i3 << (n3 - 1);
        while (n(i17) >= n3) {
            i17 ^= i16 << (n(i17) - n3);
        }
        return i17;
    }

    static void c(b bVar) {
        bVar.a((byte) -1);
    }

    static void d(Version version, b bVar) throws WriterException {
        j(bVar);
        e(bVar);
        r(version, bVar);
        k(bVar);
    }

    private static void e(b bVar) throws WriterException {
        if (bVar.b(8, bVar.d() - 8) != 0) {
            bVar.f(8, bVar.d() - 8, 1);
            return;
        }
        throw new WriterException();
    }

    static void f(com.google.zxing.common.a aVar, int i3, b bVar) throws WriterException {
        boolean z16;
        int e16 = bVar.e() - 1;
        int d16 = bVar.d() - 1;
        int i16 = 0;
        int i17 = -1;
        while (e16 > 0) {
            if (e16 == 6) {
                e16--;
            }
            while (d16 >= 0 && d16 < bVar.d()) {
                for (int i18 = 0; i18 < 2; i18++) {
                    int i19 = e16 - i18;
                    if (o(bVar.b(i19, d16))) {
                        if (i16 < aVar.f()) {
                            z16 = aVar.e(i16);
                            i16++;
                        } else {
                            z16 = false;
                        }
                        if (i3 != -1 && d.f(i3, i19, d16)) {
                            z16 = !z16;
                        }
                        bVar.g(i19, d16, z16);
                    }
                }
                d16 += i17;
            }
            i17 = -i17;
            d16 += i17;
            e16 -= 2;
        }
        if (i16 == aVar.f()) {
            return;
        }
        throw new WriterException("Not all bits consumed: " + i16 + '/' + aVar.f());
    }

    private static void g(int i3, int i16, b bVar) throws WriterException {
        for (int i17 = 0; i17 < 8; i17++) {
            int i18 = i3 + i17;
            if (o(bVar.b(i18, i16))) {
                bVar.f(i18, i16, 0);
            } else {
                throw new WriterException();
            }
        }
    }

    private static void h(int i3, int i16, b bVar) {
        for (int i17 = 0; i17 < 5; i17++) {
            for (int i18 = 0; i18 < 5; i18++) {
                bVar.f(i3 + i18, i16 + i17, f440735b[i17][i18]);
            }
        }
    }

    private static void i(int i3, int i16, b bVar) {
        for (int i17 = 0; i17 < 7; i17++) {
            for (int i18 = 0; i18 < 7; i18++) {
                bVar.f(i3 + i18, i16 + i17, f440734a[i17][i18]);
            }
        }
    }

    private static void j(b bVar) throws WriterException {
        int length = f440734a[0].length;
        i(0, 0, bVar);
        i(bVar.e() - length, 0, bVar);
        i(0, bVar.e() - length, bVar);
        g(0, 7, bVar);
        g(bVar.e() - 8, 7, bVar);
        g(0, bVar.e() - 8, bVar);
        m(7, 0, bVar);
        m((bVar.d() - 7) - 1, 0, bVar);
        m(7, bVar.d() - 7, bVar);
    }

    private static void k(b bVar) {
        int i3 = 8;
        while (i3 < bVar.e() - 8) {
            int i16 = i3 + 1;
            int i17 = i16 % 2;
            if (o(bVar.b(i3, 6))) {
                bVar.f(i3, 6, i17);
            }
            if (o(bVar.b(6, i3))) {
                bVar.f(6, i3, i17);
            }
            i3 = i16;
        }
    }

    static void l(ErrorCorrectionLevel errorCorrectionLevel, int i3, b bVar) throws WriterException {
        com.google.zxing.common.a aVar = new com.google.zxing.common.a();
        p(errorCorrectionLevel, i3, aVar);
        for (int i16 = 0; i16 < aVar.f(); i16++) {
            boolean e16 = aVar.e((aVar.f() - 1) - i16);
            int[] iArr = f440737d[i16];
            bVar.g(iArr[0], iArr[1], e16);
            if (i16 < 8) {
                bVar.g((bVar.e() - i16) - 1, 8, e16);
            } else {
                bVar.g(8, (bVar.d() - 7) + (i16 - 8), e16);
            }
        }
    }

    private static void m(int i3, int i16, b bVar) throws WriterException {
        for (int i17 = 0; i17 < 7; i17++) {
            int i18 = i16 + i17;
            if (o(bVar.b(i3, i18))) {
                bVar.f(i3, i18, 0);
            } else {
                throw new WriterException();
            }
        }
    }

    static int n(int i3) {
        int i16 = 0;
        while (i3 != 0) {
            i3 >>>= 1;
            i16++;
        }
        return i16;
    }

    private static boolean o(int i3) {
        if (i3 == -1) {
            return true;
        }
        return false;
    }

    static void p(ErrorCorrectionLevel errorCorrectionLevel, int i3, com.google.zxing.common.a aVar) throws WriterException {
        if (f.b(i3)) {
            int bits = (errorCorrectionLevel.getBits() << 3) | i3;
            aVar.c(bits, 5);
            aVar.c(b(bits, 1335), 10);
            com.google.zxing.common.a aVar2 = new com.google.zxing.common.a();
            aVar2.c(21522, 15);
            aVar.j(aVar2);
            if (aVar.f() == 15) {
                return;
            }
            throw new WriterException("should not happen but we got: " + aVar.f());
        }
        throw new WriterException("Invalid mask pattern");
    }

    static void q(Version version, com.google.zxing.common.a aVar) throws WriterException {
        aVar.c(version.getVersionNumber(), 6);
        aVar.c(b(version.getVersionNumber(), 7973), 12);
        if (aVar.f() == 18) {
            return;
        }
        throw new WriterException("should not happen but we got: " + aVar.f());
    }

    private static void r(Version version, b bVar) {
        if (version.getVersionNumber() < 2) {
            return;
        }
        int[] iArr = f440736c[version.getVersionNumber() - 1];
        for (int i3 : iArr) {
            for (int i16 : iArr) {
                if (i16 != -1 && i3 != -1 && o(bVar.b(i16, i3))) {
                    h(i16 - 2, i3 - 2, bVar);
                }
            }
        }
    }

    static void s(Version version, b bVar) throws WriterException {
        if (version.getVersionNumber() < 7) {
            return;
        }
        com.google.zxing.common.a aVar = new com.google.zxing.common.a();
        q(version, aVar);
        int i3 = 17;
        for (int i16 = 0; i16 < 6; i16++) {
            for (int i17 = 0; i17 < 3; i17++) {
                boolean e16 = aVar.e(i3);
                i3--;
                bVar.g(i16, (bVar.d() - 11) + i17, e16);
                bVar.g((bVar.d() - 11) + i17, i16, e16);
            }
        }
    }
}
