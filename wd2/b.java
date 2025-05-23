package wd2;

import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f445484a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b, reason: collision with root package name */
    private static long[] f445485b = new long[256];

    static {
        long j3;
        for (int i3 = 0; i3 < 256; i3++) {
            long j16 = i3;
            for (int i16 = 0; i16 < 8; i16++) {
                if ((((int) j16) & 1) != 0) {
                    j3 = -7661587058870466123L;
                } else {
                    j3 = 0;
                }
                j16 = (j16 >> 1) ^ j3;
            }
            f445485b[i3] = j16;
        }
    }

    private static String a(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            char[] cArr = new char[bArr.length * 2];
            for (int i3 = 0; i3 < bArr.length; i3++) {
                byte b16 = bArr[i3];
                int i16 = i3 * 2;
                char[] cArr2 = f445484a;
                cArr[i16 + 1] = cArr2[b16 & RegisterType.DOUBLE_HI];
                cArr[i16] = cArr2[((byte) (b16 >>> 4)) & RegisterType.DOUBLE_HI];
            }
            return new String(cArr);
        }
        return null;
    }

    public static String b(String str) {
        return c(str, KeyPropertiesCompact.DIGEST_MD5);
    }

    public static String c(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str2);
            messageDigest.update(str.getBytes());
            return a(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }
}
