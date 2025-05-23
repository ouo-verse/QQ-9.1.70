package r7;

import java.util.Random;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final Random f430897a = new Random();

    public static long a() {
        return System.currentTimeMillis();
    }

    public static long b() {
        return (((System.currentTimeMillis() / 1000) / 86400) * 86400) + f430897a.nextInt(86400);
    }
}
