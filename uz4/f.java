package uz4;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public boolean f440699a;

    /* renamed from: b, reason: collision with root package name */
    public int f440700b;

    /* renamed from: c, reason: collision with root package name */
    public String f440701c;

    /* renamed from: d, reason: collision with root package name */
    public String f440702d;

    /* renamed from: e, reason: collision with root package name */
    public Throwable f440703e;

    public static f a(int i3, Throwable th5) {
        boolean z16;
        f fVar = new f();
        if (i3 >= 200 && i3 < 300) {
            z16 = true;
        } else {
            z16 = false;
        }
        fVar.f440699a = z16;
        fVar.f440700b = i3;
        fVar.f440701c = th5.getMessage();
        fVar.f440702d = th5.getClass().getSimpleName();
        fVar.f440703e = th5;
        return fVar;
    }

    public final String toString() {
        return "UploadResult{success=" + this.f440699a + ", code=" + this.f440700b + ", errorMessage='" + this.f440701c + "', errorName='" + this.f440702d + "', throwable=" + this.f440703e + '}';
    }
}
