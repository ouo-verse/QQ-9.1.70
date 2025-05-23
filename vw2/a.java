package vw2;

import ww2.d;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected ww2.b f443605a;

    /* renamed from: b, reason: collision with root package name */
    protected d f443606b;

    /* renamed from: c, reason: collision with root package name */
    protected ww2.a f443607c;

    protected abstract ww2.a a();

    protected abstract ww2.b b();

    protected abstract d c();

    public <S extends ww2.a> S d() {
        return (S) this.f443607c;
    }

    public <S extends ww2.b> S e() {
        return (S) this.f443605a;
    }

    public <S extends d> S f() {
        return (S) this.f443606b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g() {
        this.f443605a = b();
        this.f443606b = c();
        this.f443607c = a();
    }
}
