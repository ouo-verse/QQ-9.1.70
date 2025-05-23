package z60;

import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private boolean f452000a = false;

    /* renamed from: b, reason: collision with root package name */
    private boolean f452001b = false;

    /* renamed from: c, reason: collision with root package name */
    private int f452002c = 0;

    /* renamed from: d, reason: collision with root package name */
    private long f452003d = 0;

    /* renamed from: e, reason: collision with root package name */
    private long f452004e = 0;

    /* renamed from: f, reason: collision with root package name */
    private FeedCloudMeta$StFeed f452005f = null;

    public FeedCloudMeta$StFeed a() {
        return this.f452005f;
    }

    public int b() {
        return this.f452002c;
    }

    public long c() {
        return this.f452004e;
    }

    public long d() {
        return this.f452003d;
    }

    public boolean e() {
        return this.f452001b;
    }

    public boolean f() {
        return this.f452000a;
    }

    public void g() {
        this.f452002c = 0;
        this.f452003d = 0L;
        this.f452004e = 0L;
        this.f452005f = null;
        this.f452000a = false;
        this.f452001b = false;
    }

    public void h(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.f452005f = feedCloudMeta$StFeed;
    }

    public void i(boolean z16) {
        this.f452001b = z16;
    }

    public void j(boolean z16) {
        this.f452000a = z16;
    }

    public void k(int i3) {
        this.f452002c = i3;
    }

    public void l(long j3) {
        this.f452004e = j3;
    }

    public void m(long j3) {
        this.f452003d = j3;
    }
}
