package u1;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: h, reason: collision with root package name */
    public static final a f438033h = new a(285, 256);

    /* renamed from: a, reason: collision with root package name */
    private int[] f438034a;

    /* renamed from: b, reason: collision with root package name */
    private int[] f438035b;

    /* renamed from: c, reason: collision with root package name */
    private b f438036c;

    /* renamed from: d, reason: collision with root package name */
    private b f438037d;

    /* renamed from: e, reason: collision with root package name */
    private final int f438038e;

    /* renamed from: f, reason: collision with root package name */
    private final int f438039f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f438040g = false;

    public a(int i3, int i16) {
        this.f438039f = i3;
        this.f438038e = i16;
        if (i16 <= 0) {
            f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i3, int i16) {
        return i3 ^ i16;
    }

    private void c() {
        if (!this.f438040g) {
            f();
        }
    }

    private void f() {
        int i3 = this.f438038e;
        this.f438034a = new int[i3];
        this.f438035b = new int[i3];
        int i16 = 1;
        int i17 = 0;
        while (true) {
            int i18 = this.f438038e;
            if (i17 >= i18) {
                break;
            }
            this.f438034a[i17] = i16;
            i16 <<= 1;
            if (i16 >= i18) {
                i16 = (i16 ^ this.f438039f) & (i18 - 1);
            }
            i17++;
        }
        for (int i19 = 0; i19 < this.f438038e - 1; i19++) {
            this.f438035b[this.f438034a[i19]] = i19;
        }
        this.f438036c = new b(this, new int[]{0});
        this.f438037d = new b(this, new int[]{1});
        this.f438040g = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b b(int i3, int i16) {
        c();
        if (i3 >= 0) {
            if (i16 == 0) {
                return this.f438036c;
            }
            int[] iArr = new int[i3 + 1];
            iArr[0] = i16;
            return new b(this, iArr);
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d(int i3) {
        c();
        return this.f438034a[i3];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b e() {
        c();
        return this.f438036c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g(int i3) {
        c();
        if (i3 != 0) {
            return this.f438034a[(this.f438038e - this.f438035b[i3]) - 1];
        }
        throw new ArithmeticException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h(int i3) {
        c();
        if (i3 != 0) {
            return this.f438035b[i3];
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i(int i3, int i16) {
        c();
        if (i3 != 0 && i16 != 0) {
            int[] iArr = this.f438034a;
            int[] iArr2 = this.f438035b;
            return iArr[(iArr2[i3] + iArr2[i16]) % (this.f438038e - 1)];
        }
        return 0;
    }
}
