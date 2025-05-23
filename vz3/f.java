package vz3;

/* compiled from: P */
/* loaded from: classes25.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private long f443792a;

    /* renamed from: b, reason: collision with root package name */
    private long f443793b;

    public f(long j3) {
        this.f443793b = j3;
        this.f443792a = j3;
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public f clone() {
        return new f(this.f443793b);
    }

    public void b() {
        this.f443793b = this.f443792a;
    }

    public void c(float f16) {
        this.f443793b = ((float) this.f443793b) * f16;
    }

    public long d() {
        return this.f443793b;
    }
}
