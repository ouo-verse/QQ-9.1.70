package qv2;

import android.util.Base64;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.oskplayer.util.SecretUtils;
import com.tencent.qqlive.tvkplayer.tools.httpdns.TVKHttpDnsCryptoUtils;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import pw2.n;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static String f429685a = "EncryptUtil";

    public static byte[] a(String str, String str2, byte[] bArr) {
        if (str != null && str2 != null && bArr != null) {
            try {
                SecretKey generateSecret = SecretKeyFactory.getInstance(TVKHttpDnsCryptoUtils.ENCRYPTION_TYPE_DES).generateSecret(new DESKeySpec(str.getBytes("UTF-8")));
                Cipher cipher = Cipher.getInstance(SecretUtils.ALGORITHM_DES);
                cipher.init(1, generateSecret, new IvParameterSpec(str2.getBytes("UTF-8")));
                return cipher.doFinal(bArr);
            } catch (Throwable th5) {
                n.b(f429685a, th5.getMessage());
            }
        }
        return null;
    }

    public static String b(String str) {
        byte[] bArr;
        int length = 8 - (str.length() % 8);
        StringBuilder sb5 = new StringBuilder(str);
        if (length < 8) {
            for (int i3 = 0; i3 < length; i3++) {
                sb5.append(ContainerUtils.FIELD_DELIMITER);
            }
        }
        try {
            bArr = a("livep@!1", "12345678", sb5.toString().getBytes("UTF-8"));
        } catch (Exception e16) {
            e16.printStackTrace();
            bArr = null;
        }
        if (bArr == null) {
            return str;
        }
        byte[] bArr2 = new byte[bArr.length + 1];
        bArr2[0] = 1;
        System.arraycopy(bArr, 0, bArr2, 1, bArr.length);
        return Base64.encodeToString(bArr2, 2);
    }
}
