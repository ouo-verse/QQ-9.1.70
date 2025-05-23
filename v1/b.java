package v1;

import java.lang.reflect.Array;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final byte[][] f440729a;

    /* renamed from: b, reason: collision with root package name */
    private final int f440730b;

    /* renamed from: c, reason: collision with root package name */
    private final int f440731c;

    public b(int i3, int i16) {
        this.f440729a = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i16, i3);
        this.f440730b = i3;
        this.f440731c = i16;
    }

    public void a(byte b16) {
        for (int i3 = 0; i3 < this.f440731c; i3++) {
            for (int i16 = 0; i16 < this.f440730b; i16++) {
                this.f440729a[i3][i16] = b16;
            }
        }
    }

    public byte b(int i3, int i16) {
        return this.f440729a[i16][i3];
    }

    public byte[][] c() {
        return this.f440729a;
    }

    public int d() {
        return this.f440731c;
    }

    public int e() {
        return this.f440730b;
    }

    public void f(int i3, int i16, int i17) {
        this.f440729a[i16][i3] = (byte) i17;
    }

    public void g(int i3, int i16, boolean z16) {
        this.f440729a[i16][i3] = z16 ? (byte) 1 : (byte) 0;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder((this.f440730b * 2 * this.f440731c) + 2);
        for (int i3 = 0; i3 < this.f440731c; i3++) {
            for (int i16 = 0; i16 < this.f440730b; i16++) {
                byte b16 = this.f440729a[i3][i16];
                if (b16 != 0) {
                    if (b16 != 1) {
                        sb5.append("  ");
                    } else {
                        sb5.append(" 1");
                    }
                } else {
                    sb5.append(" 0");
                }
            }
            sb5.append('\n');
        }
        return sb5.toString();
    }
}
