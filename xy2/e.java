package xy2;

import android.support.annotation.Nullable;
import java.util.ConcurrentModificationException;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes20.dex */
public class e<K, V> {

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    static Object[] f449103d;

    /* renamed from: e, reason: collision with root package name */
    static int f449104e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    static Object[] f449105f;

    /* renamed from: g, reason: collision with root package name */
    static int f449106g;

    /* renamed from: a, reason: collision with root package name */
    int[] f449107a = c.f449077a;

    /* renamed from: b, reason: collision with root package name */
    Object[] f449108b = c.f449079c;

    /* renamed from: c, reason: collision with root package name */
    int f449109c = 0;

    private void a(int i3) {
        if (i3 == 8) {
            synchronized (e.class) {
                Object[] objArr = f449105f;
                if (objArr != null) {
                    this.f449108b = objArr;
                    f449105f = (Object[]) objArr[0];
                    this.f449107a = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f449106g--;
                    return;
                }
            }
        } else if (i3 == 4) {
            synchronized (e.class) {
                Object[] objArr2 = f449103d;
                if (objArr2 != null) {
                    this.f449108b = objArr2;
                    f449103d = (Object[]) objArr2[0];
                    this.f449107a = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f449104e--;
                    return;
                }
            }
        }
        this.f449107a = new int[i3];
        this.f449108b = new Object[i3 << 1];
    }

    private static int b(int[] iArr, int i3, int i16) {
        try {
            return c.a(iArr, i3, i16);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private static void d(int[] iArr, Object[] objArr, int i3) {
        if (iArr.length == 8) {
            synchronized (e.class) {
                if (f449106g < 10) {
                    objArr[0] = f449105f;
                    objArr[1] = iArr;
                    for (int i16 = (i3 << 1) - 1; i16 >= 2; i16--) {
                        objArr[i16] = null;
                    }
                    f449105f = objArr;
                    f449106g++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (e.class) {
                if (f449104e < 10) {
                    objArr[0] = f449103d;
                    objArr[1] = iArr;
                    for (int i17 = (i3 << 1) - 1; i17 >= 2; i17--) {
                        objArr[i17] = null;
                    }
                    f449103d = objArr;
                    f449104e++;
                }
            }
        }
    }

    private boolean l(Map<?, ?> map) {
        if (n() != map.size()) {
            return false;
        }
        for (int i3 = 0; i3 < this.f449109c; i3++) {
            try {
                K k3 = k(i3);
                V o16 = o(i3);
                Object obj = map.get(k3);
                if (o16 == null) {
                    if (obj != null || !map.containsKey(k3)) {
                        return false;
                    }
                } else if (!o16.equals(obj)) {
                    return false;
                }
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        }
        return true;
    }

    public boolean c(@Nullable Object obj) {
        if (h(obj) >= 0) {
            return true;
        }
        return false;
    }

    @Nullable
    public V e(Object obj) {
        return f(obj, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (n() != eVar.n()) {
                return false;
            }
            for (int i3 = 0; i3 < this.f449109c; i3++) {
                try {
                    K k3 = k(i3);
                    V o16 = o(i3);
                    Object e16 = eVar.e(k3);
                    if (o16 == null) {
                        if (e16 != null || !eVar.c(k3)) {
                            return false;
                        }
                    } else if (!o16.equals(e16)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        return l((Map) obj);
    }

    public V f(Object obj, V v3) {
        int h16 = h(obj);
        if (h16 >= 0) {
            return (V) this.f449108b[(h16 << 1) + 1];
        }
        return v3;
    }

    int g(Object obj, int i3) {
        int i16 = this.f449109c;
        if (i16 == 0) {
            return -1;
        }
        int b16 = b(this.f449107a, i16, i3);
        if (b16 < 0) {
            return b16;
        }
        if (obj.equals(this.f449108b[b16 << 1])) {
            return b16;
        }
        int i17 = b16 + 1;
        while (i17 < i16 && this.f449107a[i17] == i3) {
            if (obj.equals(this.f449108b[i17 << 1])) {
                return i17;
            }
            i17++;
        }
        for (int i18 = b16 - 1; i18 >= 0 && this.f449107a[i18] == i3; i18--) {
            if (obj.equals(this.f449108b[i18 << 1])) {
                return i18;
            }
        }
        return ~i17;
    }

    public int h(@Nullable Object obj) {
        if (obj == null) {
            return i();
        }
        return g(obj, obj.hashCode());
    }

    public int hashCode() {
        int hashCode;
        int[] iArr = this.f449107a;
        Object[] objArr = this.f449108b;
        int i3 = this.f449109c;
        int i16 = 1;
        int i17 = 0;
        int i18 = 0;
        while (i17 < i3) {
            Object obj = objArr[i16];
            int i19 = iArr[i17];
            if (obj == null) {
                hashCode = 0;
            } else {
                hashCode = obj.hashCode();
            }
            i18 += hashCode ^ i19;
            i17++;
            i16 += 2;
        }
        return i18;
    }

    int i() {
        int i3 = this.f449109c;
        if (i3 == 0) {
            return -1;
        }
        int b16 = b(this.f449107a, i3, 0);
        if (b16 < 0) {
            return b16;
        }
        if (this.f449108b[b16 << 1] == null) {
            return b16;
        }
        int i16 = b16 + 1;
        while (i16 < i3 && this.f449107a[i16] == 0) {
            if (this.f449108b[i16 << 1] == null) {
                return i16;
            }
            i16++;
        }
        for (int i17 = b16 - 1; i17 >= 0 && this.f449107a[i17] == 0; i17--) {
            if (this.f449108b[i17 << 1] == null) {
                return i17;
            }
        }
        return ~i16;
    }

    public boolean j() {
        if (this.f449109c <= 0) {
            return true;
        }
        return false;
    }

    public K k(int i3) {
        return (K) this.f449108b[i3 << 1];
    }

    @Nullable
    public V m(K k3, V v3) {
        int i3;
        int g16;
        int i16 = this.f449109c;
        if (k3 == null) {
            g16 = i();
            i3 = 0;
        } else {
            int hashCode = k3.hashCode();
            i3 = hashCode;
            g16 = g(k3, hashCode);
        }
        if (g16 >= 0) {
            int i17 = (g16 << 1) + 1;
            Object[] objArr = this.f449108b;
            V v16 = (V) objArr[i17];
            objArr[i17] = v3;
            return v16;
        }
        int i18 = ~g16;
        int[] iArr = this.f449107a;
        if (i16 >= iArr.length) {
            int i19 = 8;
            if (i16 >= 8) {
                i19 = (i16 >> 1) + i16;
            } else if (i16 < 4) {
                i19 = 4;
            }
            Object[] objArr2 = this.f449108b;
            a(i19);
            if (i16 == this.f449109c) {
                int[] iArr2 = this.f449107a;
                if (iArr2.length > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    System.arraycopy(objArr2, 0, this.f449108b, 0, objArr2.length);
                }
                d(iArr, objArr2, i16);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i18 < i16) {
            int[] iArr3 = this.f449107a;
            int i26 = i18 + 1;
            System.arraycopy(iArr3, i18, iArr3, i26, i16 - i18);
            Object[] objArr3 = this.f449108b;
            System.arraycopy(objArr3, i18 << 1, objArr3, i26 << 1, (this.f449109c - i18) << 1);
        }
        int i27 = this.f449109c;
        if (i16 == i27) {
            int[] iArr4 = this.f449107a;
            if (i18 < iArr4.length) {
                iArr4[i18] = i3;
                Object[] objArr4 = this.f449108b;
                int i28 = i18 << 1;
                objArr4[i28] = k3;
                objArr4[i28 + 1] = v3;
                this.f449109c = i27 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public int n() {
        return this.f449109c;
    }

    public V o(int i3) {
        return (V) this.f449108b[(i3 << 1) + 1];
    }

    public String toString() {
        if (j()) {
            return "{}";
        }
        StringBuilder sb5 = new StringBuilder(this.f449109c * 28);
        sb5.append('{');
        for (int i3 = 0; i3 < this.f449109c; i3++) {
            if (i3 > 0) {
                sb5.append(", ");
            }
            K k3 = k(i3);
            if (k3 != this) {
                sb5.append(k3);
            } else {
                sb5.append("(this Map)");
            }
            sb5.append('=');
            V o16 = o(i3);
            if (o16 != this) {
                sb5.append(o16);
            } else {
                sb5.append("(this Map)");
            }
        }
        sb5.append('}');
        return sb5.toString();
    }
}
