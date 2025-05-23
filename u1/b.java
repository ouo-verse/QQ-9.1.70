package u1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final a f438041a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f438042b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, int[] iArr) {
        if (iArr.length != 0) {
            this.f438041a = aVar;
            int length = iArr.length;
            int i3 = 1;
            if (length > 1 && iArr[0] == 0) {
                while (i3 < length && iArr[i3] == 0) {
                    i3++;
                }
                if (i3 == length) {
                    this.f438042b = aVar.e().f438042b;
                    return;
                }
                int[] iArr2 = new int[length - i3];
                this.f438042b = iArr2;
                System.arraycopy(iArr, i3, iArr2, 0, iArr2.length);
                return;
            }
            this.f438042b = iArr;
            return;
        }
        throw new IllegalArgumentException();
    }

    b a(b bVar) {
        if (this.f438041a.equals(bVar.f438041a)) {
            if (f()) {
                return bVar;
            }
            if (bVar.f()) {
                return this;
            }
            int[] iArr = this.f438042b;
            int[] iArr2 = bVar.f438042b;
            if (iArr.length <= iArr2.length) {
                iArr = iArr2;
                iArr2 = iArr;
            }
            int[] iArr3 = new int[iArr.length];
            int length = iArr.length - iArr2.length;
            System.arraycopy(iArr, 0, iArr3, 0, length);
            for (int i3 = length; i3 < iArr.length; i3++) {
                iArr3[i3] = a.a(iArr2[i3 - length], iArr[i3]);
            }
            return new b(this.f438041a, iArr3);
        }
        throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b[] b(b bVar) {
        if (this.f438041a.equals(bVar.f438041a)) {
            if (!bVar.f()) {
                b e16 = this.f438041a.e();
                int g16 = this.f438041a.g(bVar.c(bVar.e()));
                b bVar2 = this;
                while (bVar2.e() >= bVar.e() && !bVar2.f()) {
                    int e17 = bVar2.e() - bVar.e();
                    int i3 = this.f438041a.i(bVar2.c(bVar2.e()), g16);
                    b h16 = bVar.h(e17, i3);
                    e16 = e16.a(this.f438041a.b(e17, i3));
                    bVar2 = bVar2.a(h16);
                }
                return new b[]{e16, bVar2};
            }
            throw new IllegalArgumentException("Divide by 0");
        }
        throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }

    int c(int i3) {
        return this.f438042b[(r0.length - 1) - i3];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] d() {
        return this.f438042b;
    }

    int e() {
        return this.f438042b.length - 1;
    }

    boolean f() {
        if (this.f438042b[0] != 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b g(b bVar) {
        if (this.f438041a.equals(bVar.f438041a)) {
            if (!f() && !bVar.f()) {
                int[] iArr = this.f438042b;
                int length = iArr.length;
                int[] iArr2 = bVar.f438042b;
                int length2 = iArr2.length;
                int[] iArr3 = new int[(length + length2) - 1];
                for (int i3 = 0; i3 < length; i3++) {
                    int i16 = iArr[i3];
                    for (int i17 = 0; i17 < length2; i17++) {
                        int i18 = i3 + i17;
                        iArr3[i18] = a.a(iArr3[i18], this.f438041a.i(i16, iArr2[i17]));
                    }
                }
                return new b(this.f438041a, iArr3);
            }
            return this.f438041a.e();
        }
        throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b h(int i3, int i16) {
        if (i3 >= 0) {
            if (i16 == 0) {
                return this.f438041a.e();
            }
            int length = this.f438042b.length;
            int[] iArr = new int[i3 + length];
            for (int i17 = 0; i17 < length; i17++) {
                iArr[i17] = this.f438041a.i(this.f438042b[i17], i16);
            }
            return new b(this.f438041a, iArr);
        }
        throw new IllegalArgumentException();
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder(e() * 8);
        for (int e16 = e(); e16 >= 0; e16--) {
            int c16 = c(e16);
            if (c16 != 0) {
                if (c16 < 0) {
                    sb5.append(" - ");
                    c16 = -c16;
                } else if (sb5.length() > 0) {
                    sb5.append(" + ");
                }
                if (e16 == 0 || c16 != 1) {
                    int h16 = this.f438041a.h(c16);
                    if (h16 == 0) {
                        sb5.append('1');
                    } else if (h16 == 1) {
                        sb5.append('a');
                    } else {
                        sb5.append("a^");
                        sb5.append(h16);
                    }
                }
                if (e16 != 0) {
                    if (e16 == 1) {
                        sb5.append('x');
                    } else {
                        sb5.append("x^");
                        sb5.append(e16);
                    }
                }
            }
        }
        return sb5.toString();
    }
}
