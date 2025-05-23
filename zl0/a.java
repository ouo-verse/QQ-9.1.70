package zl0;

import com.tencent.gdt.tangram.ad.qzone.AdClickData;

/* compiled from: P */
/* loaded from: classes36.dex */
public abstract class a extends vl0.a {

    /* renamed from: a, reason: collision with root package name */
    protected int f452725a = 0;

    /* renamed from: b, reason: collision with root package name */
    protected boolean f452726b = false;

    /* renamed from: c, reason: collision with root package name */
    protected boolean f452727c = true;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f452728d = true;

    public a(AdClickData adClickData, yl0.a aVar) {
        e(adClickData, aVar);
    }

    public final int a() {
        return this.f452725a;
    }

    public final boolean b() {
        return this.f452728d;
    }

    public final boolean c() {
        return this.f452726b;
    }

    public final boolean d() {
        return this.f452727c;
    }

    public abstract void f(yl0.a aVar, AdClickData adClickData);

    protected void e(AdClickData adClickData, yl0.a aVar) {
    }
}
