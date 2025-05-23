package ux2;

import tvideo.Video;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private int f440547a;

    /* renamed from: b, reason: collision with root package name */
    private Video f440548b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f440549c;

    /* renamed from: d, reason: collision with root package name */
    private long f440550d;

    /* renamed from: e, reason: collision with root package name */
    private long f440551e;

    a() {
    }

    public static a a() {
        return new a();
    }

    public int b() {
        return this.f440547a;
    }

    public Video c() {
        return this.f440548b;
    }

    public long d() {
        return this.f440550d;
    }

    public boolean e() {
        return this.f440549c;
    }

    public a f(int i3) {
        this.f440547a = i3;
        return this;
    }

    public a g(Video video) {
        this.f440548b = video;
        return this;
    }

    public a h(long j3) {
        this.f440550d = j3;
        return this;
    }

    public a i(boolean z16) {
        this.f440549c = z16;
        return this;
    }

    public a j(long j3) {
        this.f440551e = j3;
        return this;
    }

    public String toString() {
        return "FSLoadBarrageListBean{mContextHashCode=" + this.f440547a + ", mFeed=" + this.f440548b + ", isLoadMore=" + this.f440549c + ", feedPlayTime=" + this.f440550d + "}";
    }
}
