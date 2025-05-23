package xr;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public float f448421a;

    /* renamed from: b, reason: collision with root package name */
    public float f448422b;

    /* renamed from: c, reason: collision with root package name */
    public float f448423c;

    /* renamed from: d, reason: collision with root package name */
    public float f448424d;

    public b(float f16, float f17, float f18, float f19) {
        this.f448421a = f16;
        this.f448422b = f17;
        this.f448423c = f18;
        this.f448424d = f19;
    }

    public static boolean a(b bVar, b bVar2) {
        return Float.compare(bVar.f448424d, bVar2.f448424d) != 0;
    }

    public void b(b bVar) {
        this.f448423c *= bVar.f448423c;
        this.f448421a -= bVar.f448421a;
        this.f448422b -= bVar.f448422b;
    }

    public void c(float f16, float f17, float f18, float f19) {
        this.f448421a = f16;
        this.f448422b = f17;
        this.f448423c = f18;
        this.f448424d = f19;
    }

    public String toString() {
        return "CropHomeing{x=" + this.f448421a + ", y=" + this.f448422b + ", scale=" + this.f448423c + ", rotate=" + this.f448424d + '}';
    }
}
