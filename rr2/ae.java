package rr2;

import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.timiqqid.helper.YoloLog;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ae {

    /* renamed from: a, reason: collision with root package name */
    private static String f432027a = "YuekangmaDecodeHelper";

    private static int e(char c16) {
        if (c16 >= '0' && c16 <= '9') {
            return c16 - '0';
        }
        char c17 = 'a';
        if (c16 < 'a' || c16 > 'f') {
            c17 = EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET;
            if (c16 < 'A' || c16 > 'F') {
                return 0;
            }
        }
        return (c16 - c17) + 10;
    }

    private static byte[] f(String str) {
        byte[] bArr = new byte[str.length() / 2];
        for (int i3 = 0; i3 < str.length(); i3 += 2) {
            bArr[i3 / 2] = (byte) ((e(str.charAt(i3)) * 16) + e(str.charAt(i3 + 1)));
        }
        return bArr;
    }

    public static Cipher g() {
        try {
            YoloLog.d(f432027a, new Function0() { // from class: rr2.ad
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    String h16;
                    h16 = ae.h();
                    return h16;
                }
            });
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding");
            cipher.init(2, new SecretKeySpec("e0XxEhkWSJcA6Aps".getBytes(StandardCharsets.UTF_8), KeyPropertiesCompact.KEY_ALGORITHM_AES));
            return cipher;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String h() {
        return "aesKey:e0XxEhkWSJcA6Aps";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String i(String str) {
        return "encryptCid:" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String j(String str) {
        return "cid:" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String k(Exception exc) {
        return "cipher doFinal failed,message:" + exc.getMessage();
    }

    public static String l(final String str, Cipher cipher) {
        try {
            YoloLog.d(f432027a, new Function0() { // from class: rr2.aa
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    String i3;
                    i3 = ae.i(str);
                    return i3;
                }
            });
            final String str2 = new String(cipher.doFinal(f(str)), StandardCharsets.UTF_8);
            YoloLog.d(f432027a, new Function0() { // from class: rr2.ab
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    String j3;
                    j3 = ae.j(str2);
                    return j3;
                }
            });
            return str2;
        } catch (Exception e16) {
            e16.printStackTrace();
            YoloLog.e(f432027a, new Function0() { // from class: rr2.ac
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    String k3;
                    k3 = ae.k(e16);
                    return k3;
                }
            });
            return null;
        }
    }
}
