package xy2;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseBooleanArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class d {

    /* renamed from: f, reason: collision with root package name */
    static final c f449080f = new a();

    /* renamed from: a, reason: collision with root package name */
    private final List<C11578d> f449081a;

    /* renamed from: b, reason: collision with root package name */
    private final List<f> f449082b;

    /* renamed from: d, reason: collision with root package name */
    private final SparseBooleanArray f449084d = new SparseBooleanArray();

    /* renamed from: c, reason: collision with root package name */
    private final e<f, C11578d> f449083c = new e<>();

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private final C11578d f449085e = a();

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements c {
        a() {
        }

        private boolean b(float[] fArr) {
            if (fArr[2] <= 0.05f) {
                return true;
            }
            return false;
        }

        private boolean c(float[] fArr) {
            float f16 = fArr[0];
            if (f16 < 10.0f || f16 > 37.0f || fArr[1] > 0.82f) {
                return false;
            }
            return true;
        }

        private boolean d(float[] fArr) {
            if (fArr[2] >= 0.95f) {
                return true;
            }
            return false;
        }

        @Override // xy2.d.c
        public boolean a(int i3, float[] fArr) {
            if (!d(fArr) && !b(fArr) && !c(fArr)) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        private final List<C11578d> f449086a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        private final Bitmap f449087b;

        /* renamed from: c, reason: collision with root package name */
        private final List<f> f449088c;

        /* renamed from: d, reason: collision with root package name */
        private int f449089d;

        /* renamed from: e, reason: collision with root package name */
        private int f449090e;

        /* renamed from: f, reason: collision with root package name */
        private int f449091f;

        /* renamed from: g, reason: collision with root package name */
        private final List<c> f449092g;

        /* renamed from: h, reason: collision with root package name */
        @Nullable
        private Rect f449093h;

        public b(@NonNull Bitmap bitmap) {
            ArrayList arrayList = new ArrayList();
            this.f449088c = arrayList;
            this.f449089d = 16;
            this.f449090e = 12544;
            this.f449091f = -1;
            ArrayList arrayList2 = new ArrayList();
            this.f449092g = arrayList2;
            if (bitmap != null && !bitmap.isRecycled()) {
                arrayList2.add(d.f449080f);
                this.f449087b = bitmap;
                this.f449086a = null;
                arrayList.add(f.f449110e);
                arrayList.add(f.f449111f);
                arrayList.add(f.f449112g);
                arrayList.add(f.f449113h);
                arrayList.add(f.f449114i);
                arrayList.add(f.f449115j);
                return;
            }
            throw new IllegalArgumentException("Bitmap is not valid");
        }

        private int[] c(Bitmap bitmap) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int[] iArr = new int[width * height];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            Rect rect = this.f449093h;
            if (rect == null) {
                return iArr;
            }
            int width2 = rect.width();
            int height2 = this.f449093h.height();
            int[] iArr2 = new int[width2 * height2];
            for (int i3 = 0; i3 < height2; i3++) {
                Rect rect2 = this.f449093h;
                System.arraycopy(iArr, ((rect2.top + i3) * width) + rect2.left, iArr2, i3 * width2, width2);
            }
            return iArr2;
        }

        private Bitmap d(Bitmap bitmap) {
            int max;
            int i3;
            double d16 = -1.0d;
            if (this.f449090e > 0) {
                int width = bitmap.getWidth() * bitmap.getHeight();
                int i16 = this.f449090e;
                if (width > i16) {
                    d16 = Math.sqrt(i16 / width);
                }
            } else if (this.f449091f > 0 && (max = Math.max(bitmap.getWidth(), bitmap.getHeight())) > (i3 = this.f449091f)) {
                d16 = i3 / max;
            }
            if (d16 <= 0.0d) {
                return bitmap;
            }
            return Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(bitmap.getWidth() * d16), (int) Math.ceil(bitmap.getHeight() * d16), false);
        }

        @NonNull
        public b a() {
            this.f449092g.clear();
            return this;
        }

        @NonNull
        public d b() {
            List<C11578d> list;
            c[] cVarArr;
            Bitmap bitmap = this.f449087b;
            if (bitmap != null) {
                Bitmap d16 = d(bitmap);
                Rect rect = this.f449093h;
                if (d16 != this.f449087b && rect != null) {
                    double width = d16.getWidth() / this.f449087b.getWidth();
                    rect.left = (int) Math.floor(rect.left * width);
                    rect.top = (int) Math.floor(rect.top * width);
                    rect.right = Math.min((int) Math.ceil(rect.right * width), d16.getWidth());
                    rect.bottom = Math.min((int) Math.ceil(rect.bottom * width), d16.getHeight());
                }
                int[] c16 = c(d16);
                int i3 = this.f449089d;
                if (this.f449092g.isEmpty()) {
                    cVarArr = null;
                } else {
                    List<c> list2 = this.f449092g;
                    cVarArr = (c[]) list2.toArray(new c[list2.size()]);
                }
                xy2.a aVar = new xy2.a(c16, i3, cVarArr);
                if (d16 != this.f449087b) {
                    d16.recycle();
                }
                list = aVar.d();
            } else {
                list = this.f449086a;
                if (list == null) {
                    throw new AssertionError();
                }
            }
            d dVar = new d(list, this.f449088c);
            dVar.c();
            return dVar;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface c {
        boolean a(@ColorInt int i3, @NonNull float[] fArr);
    }

    /* compiled from: P */
    /* renamed from: xy2.d$d, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public static final class C11578d {

        /* renamed from: a, reason: collision with root package name */
        private final int f449094a;

        /* renamed from: b, reason: collision with root package name */
        private final int f449095b;

        /* renamed from: c, reason: collision with root package name */
        private final int f449096c;

        /* renamed from: d, reason: collision with root package name */
        private final int f449097d;

        /* renamed from: e, reason: collision with root package name */
        private final int f449098e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f449099f;

        /* renamed from: g, reason: collision with root package name */
        private int f449100g;

        /* renamed from: h, reason: collision with root package name */
        private int f449101h;

        /* renamed from: i, reason: collision with root package name */
        @Nullable
        private float[] f449102i;

        public C11578d(@ColorInt int i3, int i16) {
            this.f449094a = Color.red(i3);
            this.f449095b = Color.green(i3);
            this.f449096c = Color.blue(i3);
            this.f449097d = i3;
            this.f449098e = i16;
        }

        private void a() {
            int m3;
            int m16;
            if (!this.f449099f) {
                int c16 = xy2.b.c(-1, this.f449097d, 4.5f);
                int c17 = xy2.b.c(-1, this.f449097d, 3.0f);
                if (c16 != -1 && c17 != -1) {
                    this.f449101h = xy2.b.m(-1, c16);
                    this.f449100g = xy2.b.m(-1, c17);
                    this.f449099f = true;
                    return;
                }
                int c18 = xy2.b.c(-16777216, this.f449097d, 4.5f);
                int c19 = xy2.b.c(-16777216, this.f449097d, 3.0f);
                if (c18 != -1 && c19 != -1) {
                    this.f449101h = xy2.b.m(-16777216, c18);
                    this.f449100g = xy2.b.m(-16777216, c19);
                    this.f449099f = true;
                    return;
                }
                if (c16 != -1) {
                    m3 = xy2.b.m(-1, c16);
                } else {
                    m3 = xy2.b.m(-16777216, c18);
                }
                this.f449101h = m3;
                if (c17 != -1) {
                    m16 = xy2.b.m(-1, c17);
                } else {
                    m16 = xy2.b.m(-16777216, c19);
                }
                this.f449100g = m16;
                this.f449099f = true;
            }
        }

        @ColorInt
        public int b() {
            a();
            return this.f449101h;
        }

        @NonNull
        public float[] c() {
            if (this.f449102i == null) {
                this.f449102i = new float[3];
            }
            xy2.b.j(this.f449094a, this.f449095b, this.f449096c, this.f449102i);
            return this.f449102i;
        }

        public int d() {
            return this.f449098e;
        }

        @ColorInt
        public int e() {
            return this.f449097d;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || C11578d.class != obj.getClass()) {
                return false;
            }
            C11578d c11578d = (C11578d) obj;
            if (this.f449098e == c11578d.f449098e && this.f449097d == c11578d.f449097d) {
                return true;
            }
            return false;
        }

        @ColorInt
        public int f() {
            a();
            return this.f449100g;
        }

        public int hashCode() {
            return (this.f449097d * 31) + this.f449098e;
        }

        @NonNull
        public String toString() {
            return C11578d.class.getSimpleName() + " [RGB: #" + Integer.toHexString(e()) + "] [HSL: " + Arrays.toString(c()) + "] [Population: " + this.f449098e + "] [Title Text: #" + Integer.toHexString(f()) + "] [Body Text: #" + Integer.toHexString(b()) + ']';
        }
    }

    d(List<C11578d> list, List<f> list2) {
        this.f449081a = list;
        this.f449082b = list2;
    }

    @Nullable
    private C11578d a() {
        int size = this.f449081a.size();
        int i3 = Integer.MIN_VALUE;
        C11578d c11578d = null;
        for (int i16 = 0; i16 < size; i16++) {
            C11578d c11578d2 = this.f449081a.get(i16);
            if (c11578d2.d() > i3) {
                i3 = c11578d2.d();
                c11578d = c11578d2;
            }
        }
        return c11578d;
    }

    @NonNull
    public static b b(@NonNull Bitmap bitmap) {
        return new b(bitmap);
    }

    private float d(C11578d c11578d, f fVar) {
        int i3;
        float f16;
        float f17;
        float[] c16 = c11578d.c();
        C11578d c11578d2 = this.f449085e;
        if (c11578d2 != null) {
            i3 = c11578d2.d();
        } else {
            i3 = 1;
        }
        float f18 = 0.0f;
        if (fVar.g() > 0.0f) {
            f16 = fVar.g() * (1.0f - Math.abs(c16[1] - fVar.i()));
        } else {
            f16 = 0.0f;
        }
        if (fVar.a() > 0.0f) {
            f17 = fVar.a() * (1.0f - Math.abs(c16[2] - fVar.h()));
        } else {
            f17 = 0.0f;
        }
        if (fVar.f() > 0.0f) {
            f18 = fVar.f() * (c11578d.d() / i3);
        }
        return f16 + f17 + f18;
    }

    @Nullable
    private C11578d e(f fVar) {
        C11578d m3 = m(fVar);
        if (m3 != null && fVar.j()) {
            this.f449084d.append(m3.e(), true);
        }
        return m3;
    }

    @Nullable
    private C11578d m(f fVar) {
        int size = this.f449081a.size();
        float f16 = 0.0f;
        C11578d c11578d = null;
        for (int i3 = 0; i3 < size; i3++) {
            C11578d c11578d2 = this.f449081a.get(i3);
            if (r(c11578d2, fVar)) {
                float d16 = d(c11578d2, fVar);
                if (c11578d == null || d16 > f16) {
                    c11578d = c11578d2;
                    f16 = d16;
                }
            }
        }
        return c11578d;
    }

    private boolean r(C11578d c11578d, f fVar) {
        float[] c16 = c11578d.c();
        if (c16[1] >= fVar.e() && c16[1] <= fVar.c() && c16[2] >= fVar.d() && c16[2] <= fVar.b() && !this.f449084d.get(c11578d.e())) {
            return true;
        }
        return false;
    }

    void c() {
        int size = this.f449082b.size();
        for (int i3 = 0; i3 < size; i3++) {
            f fVar = this.f449082b.get(i3);
            fVar.k();
            this.f449083c.m(fVar, e(fVar));
        }
        this.f449084d.clear();
    }

    @ColorInt
    public int f(@NonNull f fVar, @ColorInt int i3) {
        C11578d o16 = o(fVar);
        if (o16 != null) {
            return o16.e();
        }
        return i3;
    }

    @Nullable
    public C11578d g() {
        return o(f.f449115j);
    }

    @Nullable
    public C11578d h() {
        return o(f.f449112g);
    }

    @ColorInt
    public int i(@ColorInt int i3) {
        C11578d c11578d = this.f449085e;
        if (c11578d != null) {
            return c11578d.e();
        }
        return i3;
    }

    @Nullable
    public C11578d j() {
        return this.f449085e;
    }

    @Nullable
    public C11578d k() {
        return o(f.f449113h);
    }

    @Nullable
    public C11578d l() {
        return o(f.f449110e);
    }

    @Nullable
    public C11578d n() {
        return o(f.f449114i);
    }

    @Nullable
    public C11578d o(@NonNull f fVar) {
        return this.f449083c.e(fVar);
    }

    @ColorInt
    public int p(@ColorInt int i3) {
        return f(f.f449111f, i3);
    }

    @Nullable
    public C11578d q() {
        return o(f.f449111f);
    }
}
