package r11;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/* compiled from: P */
/* loaded from: classes7.dex */
public class d implements a {

    /* renamed from: a, reason: collision with root package name */
    private SecureRandom f430488a = a();

    private SecureRandom a() {
        SecureRandom secureRandom;
        try {
            secureRandom = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException unused) {
            secureRandom = new SecureRandom();
        }
        secureRandom.nextInt();
        return secureRandom;
    }
}
