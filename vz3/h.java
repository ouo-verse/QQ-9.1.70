package vz3;

import android.graphics.Point;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final long f443801a;

    /* renamed from: b, reason: collision with root package name */
    public final Point f443802b;

    /* renamed from: c, reason: collision with root package name */
    public final int f443803c;

    /* renamed from: d, reason: collision with root package name */
    public float f443804d = 0.0f;

    /* renamed from: e, reason: collision with root package name */
    public float f443805e = 0.0f;

    public h(long j3, Point point, int i3) {
        this.f443801a = j3;
        this.f443802b = point;
        this.f443803c = i3;
    }

    public float a() {
        return this.f443802b.x - this.f443804d;
    }

    public float b() {
        return this.f443802b.y - this.f443805e;
    }

    public void c(float f16, float f17) {
        this.f443804d = f16;
        this.f443805e = f17;
    }

    public String toString() {
        return "TouchPoint{mTime=" + this.f443801a + ", mPoint=" + this.f443802b + ", mDistanceOfError=" + this.f443803c + '}';
    }
}
