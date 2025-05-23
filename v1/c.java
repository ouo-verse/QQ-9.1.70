package v1;

import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f440732a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f440733a;

        static {
            int[] iArr = new int[Mode.values().length];
            f440733a = iArr;
            try {
                iArr[Mode.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f440733a[Mode.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f440733a[Mode.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f440733a[Mode.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static void a(String str, com.google.zxing.common.a aVar, String str2) throws WriterException {
        try {
            for (byte b16 : str.getBytes(str2)) {
                aVar.c(b16, 8);
            }
        } catch (UnsupportedEncodingException e16) {
            throw new WriterException(e16);
        }
    }

    static void b(CharSequence charSequence, com.google.zxing.common.a aVar) throws WriterException {
        int length = charSequence.length();
        int i3 = 0;
        while (i3 < length) {
            int o16 = o(charSequence.charAt(i3));
            if (o16 != -1) {
                int i16 = i3 + 1;
                if (i16 < length) {
                    int o17 = o(charSequence.charAt(i16));
                    if (o17 != -1) {
                        aVar.c((o16 * 45) + o17, 11);
                        i3 += 2;
                    } else {
                        throw new WriterException();
                    }
                } else {
                    aVar.c(o16, 6);
                    i3 = i16;
                }
            } else {
                throw new WriterException();
            }
        }
    }

    static void c(String str, Mode mode, com.google.zxing.common.a aVar, String str2) throws WriterException {
        int i3 = a.f440733a[mode.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        e(str, aVar);
                        return;
                    }
                    throw new WriterException("Invalid mode: " + mode);
                }
                a(str, aVar, str2);
                return;
            }
            b(str, aVar);
            return;
        }
        h(str, aVar);
    }

    private static void d(CharacterSetECI characterSetECI, com.google.zxing.common.a aVar) {
        aVar.c(Mode.ECI.getBits(), 4);
        aVar.c(characterSetECI.getValue(), 8);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0036 A[LOOP:0: B:4:0x0009->B:11:0x0036, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0045 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static void e(String str, com.google.zxing.common.a aVar) throws WriterException {
        int i3;
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            for (int i16 = 0; i16 < length; i16 += 2) {
                int i17 = ((bytes[i16] & 255) << 8) | (bytes[i16 + 1] & 255);
                int i18 = 33088;
                if (i17 < 33088 || i17 > 40956) {
                    if (i17 >= 57408 && i17 <= 60351) {
                        i18 = 49472;
                    } else {
                        i3 = -1;
                        if (i3 == -1) {
                            aVar.c(((i3 >> 8) * 192) + (i3 & 255), 13);
                        } else {
                            throw new WriterException("Invalid byte sequence");
                        }
                    }
                }
                i3 = i17 - i18;
                if (i3 == -1) {
                }
            }
        } catch (UnsupportedEncodingException e16) {
            throw new WriterException(e16);
        }
    }

    static void f(int i3, Version version, Mode mode, com.google.zxing.common.a aVar) throws WriterException {
        int characterCountBits = mode.getCharacterCountBits(version);
        int i16 = 1 << characterCountBits;
        if (i3 < i16) {
            aVar.c(i3, characterCountBits);
            return;
        }
        throw new WriterException(i3 + " is bigger than " + (i16 - 1));
    }

    static void g(Mode mode, com.google.zxing.common.a aVar) {
        aVar.c(mode.getBits(), 4);
    }

    static void h(CharSequence charSequence, com.google.zxing.common.a aVar) {
        int length = charSequence.length();
        int i3 = 0;
        while (i3 < length) {
            int charAt = charSequence.charAt(i3) - '0';
            int i16 = i3 + 2;
            if (i16 < length) {
                aVar.c((charAt * 100) + ((charSequence.charAt(i3 + 1) - '0') * 10) + (charSequence.charAt(i16) - '0'), 10);
                i3 += 3;
            } else {
                i3++;
                if (i3 < length) {
                    aVar.c((charAt * 10) + (charSequence.charAt(i3) - '0'), 7);
                    i3 = i16;
                } else {
                    aVar.c(charAt, 4);
                }
            }
        }
    }

    private static int i(b bVar) {
        return d.a(bVar) + d.c(bVar) + d.d(bVar) + d.e(bVar);
    }

    private static int j(com.google.zxing.common.a aVar, ErrorCorrectionLevel errorCorrectionLevel, Version version, b bVar) throws WriterException {
        int i3 = Integer.MAX_VALUE;
        int i16 = -1;
        for (int i17 = 0; i17 < 8; i17++) {
            e.a(aVar, errorCorrectionLevel, version, i17, bVar);
            int i18 = i(bVar);
            if (i18 < i3) {
                i16 = i17;
                i3 = i18;
            }
        }
        return i16;
    }

    private static Mode k(String str, String str2) {
        if ("Shift_JIS".equals(str2)) {
            if (r(str)) {
                return Mode.KANJI;
            }
            return Mode.BYTE;
        }
        boolean z16 = false;
        boolean z17 = false;
        for (int i3 = 0; i3 < str.length(); i3++) {
            char charAt = str.charAt(i3);
            if (charAt >= '0' && charAt <= '9') {
                z17 = true;
            } else if (o(charAt) != -1) {
                z16 = true;
            } else {
                return Mode.BYTE;
            }
        }
        if (z16) {
            return Mode.ALPHANUMERIC;
        }
        if (z17) {
            return Mode.NUMERIC;
        }
        return Mode.BYTE;
    }

    private static Version l(int i3, ErrorCorrectionLevel errorCorrectionLevel) throws WriterException {
        for (int i16 = 1; i16 <= 40; i16++) {
            Version versionForNumber = Version.getVersionForNumber(i16);
            if (versionForNumber.getTotalCodewords() - versionForNumber.getECBlocksForLevel(errorCorrectionLevel).getTotalECCodewords() >= (i3 + 7) / 8) {
                return versionForNumber;
            }
        }
        throw new WriterException("Data too big");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static f m(String str, ErrorCorrectionLevel errorCorrectionLevel, Map<EncodeHintType, ?> map) throws WriterException {
        String str2;
        int i3;
        int i16;
        int length;
        CharacterSetECI characterSetECIByName;
        if (map == null) {
            str2 = null;
        } else {
            str2 = (String) map.get(EncodeHintType.CHARACTER_SET);
        }
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        Mode k3 = k(str, str2);
        com.google.zxing.common.a aVar = new com.google.zxing.common.a();
        Mode mode = Mode.BYTE;
        if (k3 == mode && !"ISO-8859-1".equals(str2) && (characterSetECIByName = CharacterSetECI.getCharacterSetECIByName(str2)) != null) {
            d(characterSetECIByName, aVar);
        }
        g(k3, aVar);
        com.google.zxing.common.a aVar2 = new com.google.zxing.common.a();
        c(str, k3, aVar2, str2);
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.QRCODE_VERSION;
            if (map.containsKey(encodeHintType)) {
                i3 = ((Integer) map.get(encodeHintType)).intValue();
                int f16 = aVar.f();
                if (i3 != 0) {
                    i16 = 40;
                } else {
                    i16 = i3;
                }
                Version l3 = l(f16 + k3.getCharacterCountBits(Version.getVersionForNumber(i16)) + aVar2.f(), errorCorrectionLevel);
                if (i3 != 0) {
                    if (i3 >= l3.getVersionNumber()) {
                        l3 = Version.getVersionForNumber(i3);
                    } else {
                        throw new WriterException("Requested version is too small: " + i3);
                    }
                }
                com.google.zxing.common.a aVar3 = new com.google.zxing.common.a();
                aVar3.b(aVar);
                if (k3 != mode) {
                    length = aVar2.g();
                } else {
                    length = str.length();
                }
                f(length, l3, k3, aVar3);
                aVar3.b(aVar2);
                Version.ECBlocks eCBlocksForLevel = l3.getECBlocksForLevel(errorCorrectionLevel);
                int totalCodewords = l3.getTotalCodewords() - eCBlocksForLevel.getTotalECCodewords();
                s(totalCodewords, aVar3);
                com.google.zxing.common.a q16 = q(aVar3, l3.getTotalCodewords(), totalCodewords, eCBlocksForLevel.getNumBlocks());
                f fVar = new f();
                fVar.c(errorCorrectionLevel);
                fVar.f(k3);
                fVar.g(l3);
                int dimensionForVersion = l3.getDimensionForVersion();
                b bVar = new b(dimensionForVersion, dimensionForVersion);
                int j3 = j(q16, errorCorrectionLevel, l3, bVar);
                fVar.d(j3);
                e.a(q16, errorCorrectionLevel, l3, j3, bVar);
                fVar.e(bVar);
                return fVar;
            }
        }
        i3 = 0;
        int f162 = aVar.f();
        if (i3 != 0) {
        }
        Version l36 = l(f162 + k3.getCharacterCountBits(Version.getVersionForNumber(i16)) + aVar2.f(), errorCorrectionLevel);
        if (i3 != 0) {
        }
        com.google.zxing.common.a aVar32 = new com.google.zxing.common.a();
        aVar32.b(aVar);
        if (k3 != mode) {
        }
        f(length, l36, k3, aVar32);
        aVar32.b(aVar2);
        Version.ECBlocks eCBlocksForLevel2 = l36.getECBlocksForLevel(errorCorrectionLevel);
        int totalCodewords2 = l36.getTotalCodewords() - eCBlocksForLevel2.getTotalECCodewords();
        s(totalCodewords2, aVar32);
        com.google.zxing.common.a q162 = q(aVar32, l36.getTotalCodewords(), totalCodewords2, eCBlocksForLevel2.getNumBlocks());
        f fVar2 = new f();
        fVar2.c(errorCorrectionLevel);
        fVar2.f(k3);
        fVar2.g(l36);
        int dimensionForVersion2 = l36.getDimensionForVersion();
        b bVar2 = new b(dimensionForVersion2, dimensionForVersion2);
        int j36 = j(q162, errorCorrectionLevel, l36, bVar2);
        fVar2.d(j36);
        e.a(q162, errorCorrectionLevel, l36, j36, bVar2);
        fVar2.e(bVar2);
        return fVar2;
    }

    static byte[] n(byte[] bArr, int i3) {
        int length = bArr.length;
        int[] iArr = new int[length + i3];
        for (int i16 = 0; i16 < length; i16++) {
            iArr[i16] = bArr[i16] & 255;
        }
        new u1.c(u1.a.f438033h).b(iArr, i3);
        byte[] bArr2 = new byte[i3];
        for (int i17 = 0; i17 < i3; i17++) {
            bArr2[i17] = (byte) iArr[length + i17];
        }
        return bArr2;
    }

    static int o(int i3) {
        int[] iArr = f440732a;
        if (i3 < iArr.length) {
            return iArr[i3];
        }
        return -1;
    }

    static void p(int i3, int i16, int i17, int i18, int[] iArr, int[] iArr2) throws WriterException {
        if (i18 < i17) {
            int i19 = i3 % i17;
            int i26 = i17 - i19;
            int i27 = i3 / i17;
            int i28 = i27 + 1;
            int i29 = i16 / i17;
            int i36 = i29 + 1;
            int i37 = i27 - i29;
            int i38 = i28 - i36;
            if (i37 == i38) {
                if (i17 == i26 + i19) {
                    if (i3 == ((i29 + i37) * i26) + ((i36 + i38) * i19)) {
                        if (i18 < i26) {
                            iArr[0] = i29;
                            iArr2[0] = i37;
                            return;
                        } else {
                            iArr[0] = i36;
                            iArr2[0] = i38;
                            return;
                        }
                    }
                    throw new WriterException("Total bytes mismatch");
                }
                throw new WriterException("RS blocks mismatch");
            }
            throw new WriterException("EC bytes mismatch");
        }
        throw new WriterException("Block ID too large");
    }

    static com.google.zxing.common.a q(com.google.zxing.common.a aVar, int i3, int i16, int i17) throws WriterException {
        if (aVar.g() == i16) {
            ArrayList arrayList = new ArrayList(i17);
            int i18 = 0;
            int i19 = 0;
            int i26 = 0;
            for (int i27 = 0; i27 < i17; i27++) {
                int[] iArr = new int[1];
                int[] iArr2 = new int[1];
                p(i3, i16, i17, i27, iArr, iArr2);
                int i28 = iArr[0];
                byte[] bArr = new byte[i28];
                aVar.i(i18 * 8, bArr, 0, i28);
                byte[] n3 = n(bArr, iArr2[0]);
                arrayList.add(new v1.a(bArr, n3));
                i19 = Math.max(i19, i28);
                i26 = Math.max(i26, n3.length);
                i18 += iArr[0];
            }
            if (i16 == i18) {
                com.google.zxing.common.a aVar2 = new com.google.zxing.common.a();
                for (int i29 = 0; i29 < i19; i29++) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        byte[] a16 = ((v1.a) it.next()).a();
                        if (i29 < a16.length) {
                            aVar2.c(a16[i29], 8);
                        }
                    }
                }
                for (int i36 = 0; i36 < i26; i36++) {
                    Iterator it5 = arrayList.iterator();
                    while (it5.hasNext()) {
                        byte[] b16 = ((v1.a) it5.next()).b();
                        if (i36 < b16.length) {
                            aVar2.c(b16[i36], 8);
                        }
                    }
                }
                if (i3 == aVar2.g()) {
                    return aVar2;
                }
                throw new WriterException("Interleaving error: " + i3 + " and " + aVar2.g() + " differ.");
            }
            throw new WriterException("Data bytes does not match offset");
        }
        throw new WriterException("Number of bits and data bytes does not match");
    }

    private static boolean r(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i3 = 0; i3 < length; i3 += 2) {
                int i16 = bytes[i3] & 255;
                if ((i16 < 129 || i16 > 159) && (i16 < 224 || i16 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    static void s(int i3, com.google.zxing.common.a aVar) throws WriterException {
        int i16;
        int i17 = i3 << 3;
        if (aVar.f() <= i17) {
            for (int i18 = 0; i18 < 4 && aVar.f() < i17; i18++) {
                aVar.a(false);
            }
            int f16 = aVar.f() & 7;
            if (f16 > 0) {
                while (f16 < 8) {
                    aVar.a(false);
                    f16++;
                }
            }
            int g16 = i3 - aVar.g();
            for (int i19 = 0; i19 < g16; i19++) {
                if ((i19 & 1) == 0) {
                    i16 = 236;
                } else {
                    i16 = 17;
                }
                aVar.c(i16, 8);
            }
            if (aVar.f() == i17) {
                return;
            } else {
                throw new WriterException("Bits size does not equal capacity");
            }
        }
        throw new WriterException("data bits cannot fit in the QR Code" + aVar.f() + " > " + i17);
    }
}
