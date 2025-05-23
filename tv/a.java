package tv;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private int[] f437514a = new int[8];

    /* renamed from: b, reason: collision with root package name */
    private int f437515b = 0;

    public void a(int i3) {
        int[] iArr = this.f437514a;
        int length = iArr.length;
        int i16 = this.f437515b;
        if (length == i16) {
            int[] iArr2 = new int[i16 + i16];
            System.arraycopy(iArr, 0, iArr2, 0, i16);
            this.f437514a = iArr2;
        }
        int[] iArr3 = this.f437514a;
        int i17 = this.f437515b;
        this.f437515b = i17 + 1;
        iArr3[i17] = i3;
    }

    public void b() {
        this.f437515b = 0;
        if (this.f437514a.length != 8) {
            this.f437514a = new int[8];
        }
    }

    public int[] c() {
        return this.f437514a;
    }

    public int d() {
        int i3 = this.f437515b - 1;
        this.f437515b = i3;
        return this.f437514a[i3];
    }

    public int e() {
        return this.f437515b;
    }
}
