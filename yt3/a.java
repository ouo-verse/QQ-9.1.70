package yt3;

import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {

    /* renamed from: g, reason: collision with root package name */
    private static a f451175g;

    /* renamed from: a, reason: collision with root package name */
    private boolean f451176a = false;

    /* renamed from: b, reason: collision with root package name */
    private boolean f451177b = true;

    /* renamed from: c, reason: collision with root package name */
    private boolean f451178c = true;

    /* renamed from: d, reason: collision with root package name */
    private int f451179d = 3000;

    /* renamed from: e, reason: collision with root package name */
    private int f451180e = 3;

    /* renamed from: f, reason: collision with root package name */
    private Map<String, Map<String, String>> f451181f = new HashMap();

    public static synchronized a c() {
        a aVar;
        synchronized (a.class) {
            if (f451175g == null) {
                f451175g = new a();
            }
            aVar = f451175g;
        }
        return aVar;
    }

    public int a() {
        return this.f451180e;
    }

    public int b() {
        return this.f451179d;
    }

    public boolean d() {
        return this.f451176a;
    }

    public boolean e() {
        return this.f451177b;
    }

    public boolean f() {
        return this.f451178c;
    }
}
