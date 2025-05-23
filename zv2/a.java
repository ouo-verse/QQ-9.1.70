package zv2;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import pw2.n;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f453547a = new AtomicInteger(0);

    /* renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, Integer> f453548b = new ConcurrentHashMap<>();

    public static int a() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("sClickCntCount before = ");
        AtomicInteger atomicInteger = f453547a;
        sb5.append(atomicInteger);
        n.e("QAdClickCntCounter", sb5.toString());
        int andIncrement = atomicInteger.getAndIncrement();
        if (andIncrement >= 99) {
            atomicInteger.set(0);
        }
        return andIncrement;
    }
}
