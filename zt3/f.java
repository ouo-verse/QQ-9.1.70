package zt3;

import com.tencent.qqlive.superplayer.vinfo.vod.TVKCGIVideoInfo;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private boolean f453345a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, TVKCGIVideoInfo> f453346b;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static f f453347a = new f();
    }

    public static f a() {
        return b.f453347a;
    }

    public synchronized boolean b() {
        return this.f453345a;
    }

    public synchronized void c(boolean z16) {
        this.f453345a = z16;
    }

    f() {
        this.f453346b = new HashMap(20);
    }
}
