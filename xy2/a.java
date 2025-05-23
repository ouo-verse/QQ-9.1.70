package xy2;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.TimingLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import xy2.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes20.dex */
public final class a {

    /* renamed from: g, reason: collision with root package name */
    private static final Comparator<b> f449059g = new C11577a();

    /* renamed from: a, reason: collision with root package name */
    final int[] f449060a;

    /* renamed from: b, reason: collision with root package name */
    final int[] f449061b;

    /* renamed from: c, reason: collision with root package name */
    final List<d.C11578d> f449062c;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    final d.c[] f449064e;

    /* renamed from: f, reason: collision with root package name */
    private final float[] f449065f = new float[3];

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    final TimingLogger f449063d = null;

    /* compiled from: P */
    /* renamed from: xy2.a$a, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    class C11577a implements Comparator<b> {
        C11577a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(b bVar, b bVar2) {
            return bVar2.g() - bVar.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        private int f449066a;

        /* renamed from: b, reason: collision with root package name */
        private int f449067b;

        /* renamed from: c, reason: collision with root package name */
        private int f449068c;

        /* renamed from: d, reason: collision with root package name */
        private int f449069d;

        /* renamed from: e, reason: collision with root package name */
        private int f449070e;

        /* renamed from: f, reason: collision with root package name */
        private int f449071f;

        /* renamed from: g, reason: collision with root package name */
        private int f449072g;

        /* renamed from: h, reason: collision with root package name */
        private int f449073h;

        /* renamed from: i, reason: collision with root package name */
        private int f449074i;

        b(int i3, int i16) {
            this.f449066a = i3;
            this.f449067b = i16;
            c();
        }

        final boolean a() {
            if (e() > 1) {
                return true;
            }
            return false;
        }

        final int b() {
            int f16 = f();
            a aVar = a.this;
            int[] iArr = aVar.f449060a;
            int[] iArr2 = aVar.f449061b;
            a.e(iArr, f16, this.f449066a, this.f449067b);
            Arrays.sort(iArr, this.f449066a, this.f449067b + 1);
            a.e(iArr, f16, this.f449066a, this.f449067b);
            int i3 = this.f449068c / 2;
            int i16 = this.f449066a;
            int i17 = 0;
            while (true) {
                int i18 = this.f449067b;
                if (i16 <= i18) {
                    i17 += iArr2[iArr[i16]];
                    if (i17 >= i3) {
                        return Math.min(i18 - 1, i16);
                    }
                    i16++;
                } else {
                    return this.f449066a;
                }
            }
        }

        final void c() {
            a aVar = a.this;
            int[] iArr = aVar.f449060a;
            int[] iArr2 = aVar.f449061b;
            int i3 = Integer.MAX_VALUE;
            int i16 = Integer.MIN_VALUE;
            int i17 = Integer.MIN_VALUE;
            int i18 = Integer.MIN_VALUE;
            int i19 = 0;
            int i26 = Integer.MAX_VALUE;
            int i27 = Integer.MAX_VALUE;
            for (int i28 = this.f449066a; i28 <= this.f449067b; i28++) {
                int i29 = iArr[i28];
                i19 += iArr2[i29];
                int k3 = a.k(i29);
                int j3 = a.j(i29);
                int i36 = a.i(i29);
                if (k3 > i16) {
                    i16 = k3;
                }
                if (k3 < i3) {
                    i3 = k3;
                }
                if (j3 > i17) {
                    i17 = j3;
                }
                if (j3 < i26) {
                    i26 = j3;
                }
                if (i36 > i18) {
                    i18 = i36;
                }
                if (i36 < i27) {
                    i27 = i36;
                }
            }
            this.f449069d = i3;
            this.f449070e = i16;
            this.f449071f = i26;
            this.f449072g = i17;
            this.f449073h = i27;
            this.f449074i = i18;
            this.f449068c = i19;
        }

        final d.C11578d d() {
            a aVar = a.this;
            int[] iArr = aVar.f449060a;
            int[] iArr2 = aVar.f449061b;
            int i3 = 0;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            for (int i19 = this.f449066a; i19 <= this.f449067b; i19++) {
                int i26 = iArr[i19];
                int i27 = iArr2[i26];
                i16 += i27;
                i3 += a.k(i26) * i27;
                i17 += a.j(i26) * i27;
                i18 += i27 * a.i(i26);
            }
            float f16 = i16;
            return new d.C11578d(a.b(Math.round(i3 / f16), Math.round(i17 / f16), Math.round(i18 / f16)), i16);
        }

        final int e() {
            return (this.f449067b + 1) - this.f449066a;
        }

        final int f() {
            int i3 = this.f449070e - this.f449069d;
            int i16 = this.f449072g - this.f449071f;
            int i17 = this.f449074i - this.f449073h;
            if (i3 >= i16 && i3 >= i17) {
                return -3;
            }
            if (i16 >= i3 && i16 >= i17) {
                return -2;
            }
            return -1;
        }

        final int g() {
            return ((this.f449070e - this.f449069d) + 1) * ((this.f449072g - this.f449071f) + 1) * ((this.f449074i - this.f449073h) + 1);
        }

        final b h() {
            if (a()) {
                int b16 = b();
                b bVar = new b(b16 + 1, this.f449067b);
                this.f449067b = b16;
                c();
                return bVar;
            }
            throw new IllegalStateException("Can not split a box with only 1 color");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int[] iArr, int i3, @Nullable d.c[] cVarArr) {
        this.f449064e = cVarArr;
        int[] iArr2 = new int[32768];
        this.f449061b = iArr2;
        for (int i16 = 0; i16 < iArr.length; i16++) {
            int g16 = g(iArr[i16]);
            iArr[i16] = g16;
            iArr2[g16] = iArr2[g16] + 1;
        }
        int i17 = 0;
        for (int i18 = 0; i18 < 32768; i18++) {
            if (iArr2[i18] > 0 && l(i18)) {
                iArr2[i18] = 0;
            }
            if (iArr2[i18] > 0) {
                i17++;
            }
        }
        int[] iArr3 = new int[i17];
        this.f449060a = iArr3;
        int i19 = 0;
        for (int i26 = 0; i26 < 32768; i26++) {
            if (iArr2[i26] > 0) {
                iArr3[i19] = i26;
                i19++;
            }
        }
        if (i17 <= i3) {
            this.f449062c = new ArrayList();
            for (int i27 = 0; i27 < i17; i27++) {
                int i28 = iArr3[i27];
                this.f449062c.add(new d.C11578d(a(i28), iArr2[i28]));
            }
            return;
        }
        this.f449062c = h(i3);
    }

    private static int a(int i3) {
        return b(k(i3), j(i3), i(i3));
    }

    static int b(int i3, int i16, int i17) {
        return Color.rgb(f(i3, 5, 8), f(i16, 5, 8), f(i17, 5, 8));
    }

    private List<d.C11578d> c(Collection<b> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<b> it = collection.iterator();
        while (it.hasNext()) {
            d.C11578d d16 = it.next().d();
            if (!n(d16)) {
                arrayList.add(d16);
            }
        }
        return arrayList;
    }

    static void e(int[] iArr, int i3, int i16, int i17) {
        if (i3 != -2) {
            if (i3 == -1) {
                while (i16 <= i17) {
                    int i18 = iArr[i16];
                    iArr[i16] = k(i18) | (i(i18) << 10) | (j(i18) << 5);
                    i16++;
                }
                return;
            }
            return;
        }
        while (i16 <= i17) {
            int i19 = iArr[i16];
            iArr[i16] = i(i19) | (j(i19) << 10) | (k(i19) << 5);
            i16++;
        }
    }

    private static int f(int i3, int i16, int i17) {
        int i18;
        if (i17 > i16) {
            i18 = i3 << (i17 - i16);
        } else {
            i18 = i3 >> (i16 - i17);
        }
        return i18 & ((1 << i17) - 1);
    }

    private static int g(int i3) {
        return f(Color.blue(i3), 8, 5) | (f(Color.red(i3), 8, 5) << 10) | (f(Color.green(i3), 8, 5) << 5);
    }

    private List<d.C11578d> h(int i3) {
        PriorityQueue<b> priorityQueue = new PriorityQueue<>(i3, f449059g);
        priorityQueue.offer(new b(0, this.f449060a.length - 1));
        o(priorityQueue, i3);
        return c(priorityQueue);
    }

    static int i(int i3) {
        return i3 & 31;
    }

    static int j(int i3) {
        return (i3 >> 5) & 31;
    }

    static int k(int i3) {
        return (i3 >> 10) & 31;
    }

    private boolean l(int i3) {
        int a16 = a(i3);
        xy2.b.d(a16, this.f449065f);
        return m(a16, this.f449065f);
    }

    private boolean m(int i3, float[] fArr) {
        d.c[] cVarArr = this.f449064e;
        if (cVarArr != null && cVarArr.length > 0) {
            int length = cVarArr.length;
            for (int i16 = 0; i16 < length; i16++) {
                if (!this.f449064e[i16].a(i3, fArr)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean n(d.C11578d c11578d) {
        return m(c11578d.e(), c11578d.c());
    }

    private void o(PriorityQueue<b> priorityQueue, int i3) {
        b poll;
        while (priorityQueue.size() < i3 && (poll = priorityQueue.poll()) != null && poll.a()) {
            priorityQueue.offer(poll.h());
            priorityQueue.offer(poll);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<d.C11578d> d() {
        return this.f449062c;
    }
}
