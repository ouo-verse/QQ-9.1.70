package r;

import android.graphics.Bitmap;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* compiled from: P */
@RequiresApi(19)
/* loaded from: classes.dex */
public class o implements l {

    /* renamed from: d, reason: collision with root package name */
    private static final Bitmap.Config[] f430396d;

    /* renamed from: e, reason: collision with root package name */
    private static final Bitmap.Config[] f430397e;

    /* renamed from: f, reason: collision with root package name */
    private static final Bitmap.Config[] f430398f;

    /* renamed from: g, reason: collision with root package name */
    private static final Bitmap.Config[] f430399g;

    /* renamed from: h, reason: collision with root package name */
    private static final Bitmap.Config[] f430400h;

    /* renamed from: a, reason: collision with root package name */
    private final c f430401a = new c();

    /* renamed from: b, reason: collision with root package name */
    private final g<b, Bitmap> f430402b = new g<>();

    /* renamed from: c, reason: collision with root package name */
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> f430403c = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f430404a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f430404a = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f430404a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f430404a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f430404a[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @VisibleForTesting
    /* loaded from: classes.dex */
    public static final class b implements m {

        /* renamed from: a, reason: collision with root package name */
        private final c f430405a;

        /* renamed from: b, reason: collision with root package name */
        int f430406b;

        /* renamed from: c, reason: collision with root package name */
        private Bitmap.Config f430407c;

        public b(c cVar) {
            this.f430405a = cVar;
        }

        @Override // r.m
        public void a() {
            this.f430405a.c(this);
        }

        public void b(int i3, Bitmap.Config config) {
            this.f430406b = i3;
            this.f430407c = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f430406b != bVar.f430406b || !h0.k.c(this.f430407c, bVar.f430407c)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i3;
            int i16 = this.f430406b * 31;
            Bitmap.Config config = this.f430407c;
            if (config != null) {
                i3 = config.hashCode();
            } else {
                i3 = 0;
            }
            return i16 + i3;
        }

        public String toString() {
            return o.f(this.f430406b, this.f430407c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class c extends r.c<b> {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // r.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public b a() {
            return new b(this);
        }

        public b e(int i3, Bitmap.Config config) {
            b b16 = b();
            b16.b(i3, config);
            return b16;
        }
    }

    static {
        Bitmap.Config config;
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            int length = configArr.length - 1;
            config = Bitmap.Config.RGBA_F16;
            configArr[length] = config;
        }
        f430396d = configArr;
        f430397e = configArr;
        f430398f = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        f430399g = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        f430400h = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    private void d(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> h16 = h(bitmap.getConfig());
        Integer num2 = h16.get(num);
        if (num2 != null) {
            if (num2.intValue() == 1) {
                h16.remove(num);
                return;
            } else {
                h16.put(num, Integer.valueOf(num2.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + b(bitmap) + ", this: " + this);
    }

    private b e(int i3, Bitmap.Config config) {
        b e16 = this.f430401a.e(i3, config);
        for (Bitmap.Config config2 : g(config)) {
            Integer ceilingKey = h(config2).ceilingKey(Integer.valueOf(i3));
            if (ceilingKey != null && ceilingKey.intValue() <= i3 * 8) {
                if (ceilingKey.intValue() == i3) {
                    if (config2 == null) {
                        if (config == null) {
                            return e16;
                        }
                    } else if (config2.equals(config)) {
                        return e16;
                    }
                }
                this.f430401a.c(e16);
                return this.f430401a.e(ceilingKey.intValue(), config2);
            }
        }
        return e16;
    }

    static String f(int i3, Bitmap.Config config) {
        return "[" + i3 + "](" + config + ")";
    }

    private static Bitmap.Config[] g(Bitmap.Config config) {
        Bitmap.Config config2;
        if (Build.VERSION.SDK_INT >= 26) {
            config2 = Bitmap.Config.RGBA_F16;
            if (config2.equals(config)) {
                return f430397e;
            }
        }
        int i3 = a.f430404a[config.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return new Bitmap.Config[]{config};
                    }
                    return f430400h;
                }
                return f430399g;
            }
            return f430398f;
        }
        return f430396d;
    }

    private NavigableMap<Integer, Integer> h(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.f430403c.get(config);
        if (navigableMap == null) {
            TreeMap treeMap = new TreeMap();
            this.f430403c.put(config, treeMap);
            return treeMap;
        }
        return navigableMap;
    }

    @Override // r.l
    public String a(int i3, int i16, Bitmap.Config config) {
        return f(h0.k.f(i3, i16, config), config);
    }

    @Override // r.l
    public String b(Bitmap bitmap) {
        return f(h0.k.g(bitmap), bitmap.getConfig());
    }

    @Override // r.l
    public int c(Bitmap bitmap) {
        return h0.k.g(bitmap);
    }

    @Override // r.l
    @Nullable
    public Bitmap get(int i3, int i16, Bitmap.Config config) {
        b e16 = e(h0.k.f(i3, i16, config), config);
        Bitmap a16 = this.f430402b.a(e16);
        if (a16 != null) {
            d(Integer.valueOf(e16.f430406b), a16);
            a16.reconfigure(i3, i16, config);
        }
        return a16;
    }

    @Override // r.l
    public void put(Bitmap bitmap) {
        b e16 = this.f430401a.e(h0.k.g(bitmap), bitmap.getConfig());
        this.f430402b.d(e16, bitmap);
        NavigableMap<Integer, Integer> h16 = h(bitmap.getConfig());
        Integer num = h16.get(Integer.valueOf(e16.f430406b));
        Integer valueOf = Integer.valueOf(e16.f430406b);
        int i3 = 1;
        if (num != null) {
            i3 = 1 + num.intValue();
        }
        h16.put(valueOf, Integer.valueOf(i3));
    }

    @Override // r.l
    @Nullable
    public Bitmap removeLast() {
        Bitmap f16 = this.f430402b.f();
        if (f16 != null) {
            d(Integer.valueOf(h0.k.g(f16)), f16);
        }
        return f16;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("SizeConfigStrategy{groupedMap=");
        sb5.append(this.f430402b);
        sb5.append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.f430403c.entrySet()) {
            sb5.append(entry.getKey());
            sb5.append('[');
            sb5.append(entry.getValue());
            sb5.append("], ");
        }
        if (!this.f430403c.isEmpty()) {
            sb5.replace(sb5.length() - 2, sb5.length(), "");
        }
        sb5.append(")}");
        return sb5.toString();
    }
}
