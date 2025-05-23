package pw2;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes19.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public static String f427771a = "QAdLocalClickIdCounter";

    /* renamed from: b, reason: collision with root package name */
    private static AtomicInteger f427772b = new AtomicInteger(0);

    public static int a() {
        n.e(f427771a, "sLocalClickId=" + f427772b);
        return f427772b.getAndIncrement();
    }
}
