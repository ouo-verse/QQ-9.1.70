package r;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes.dex */
public class k implements d {

    /* renamed from: k, reason: collision with root package name */
    private static final Bitmap.Config f430385k = Bitmap.Config.ARGB_8888;

    /* renamed from: a, reason: collision with root package name */
    private final l f430386a;

    /* renamed from: b, reason: collision with root package name */
    private final Set<Bitmap.Config> f430387b;

    /* renamed from: c, reason: collision with root package name */
    private final long f430388c;

    /* renamed from: d, reason: collision with root package name */
    private final a f430389d;

    /* renamed from: e, reason: collision with root package name */
    private long f430390e;

    /* renamed from: f, reason: collision with root package name */
    private long f430391f;

    /* renamed from: g, reason: collision with root package name */
    private int f430392g;

    /* renamed from: h, reason: collision with root package name */
    private int f430393h;

    /* renamed from: i, reason: collision with root package name */
    private int f430394i;

    /* renamed from: j, reason: collision with root package name */
    private int f430395j;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface a {
        void a(Bitmap bitmap);

        void b(Bitmap bitmap);
    }

    k(long j3, l lVar, Set<Bitmap.Config> set) {
        this.f430388c = j3;
        this.f430390e = j3;
        this.f430386a = lVar;
        this.f430387b = set;
        this.f430389d = new b();
    }

    @TargetApi(26)
    private static void c(Bitmap.Config config) {
        Bitmap.Config config2;
        if (Build.VERSION.SDK_INT >= 26) {
            config2 = Bitmap.Config.HARDWARE;
            if (config != config2) {
                return;
            }
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
    }

    @NonNull
    private static Bitmap d(int i3, int i16, @Nullable Bitmap.Config config) {
        if (config == null) {
            config = f430385k;
        }
        return Bitmap.createBitmap(i3, i16, config);
    }

    private void e() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            f();
        }
    }

    private void f() {
        Log.v("LruBitmapPool", "Hits=" + this.f430392g + ", misses=" + this.f430393h + ", puts=" + this.f430394i + ", evictions=" + this.f430395j + ", currentSize=" + this.f430391f + ", maxSize=" + this.f430390e + "\nStrategy=" + this.f430386a);
    }

    private void g() {
        n(this.f430390e);
    }

    @TargetApi(26)
    private static Set<Bitmap.Config> h() {
        Bitmap.Config config;
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        int i3 = Build.VERSION.SDK_INT;
        hashSet.add(null);
        if (i3 >= 26) {
            config = Bitmap.Config.HARDWARE;
            hashSet.remove(config);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private static l i() {
        return new o();
    }

    @Nullable
    private synchronized Bitmap j(int i3, int i16, @Nullable Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap bitmap;
        c(config);
        l lVar = this.f430386a;
        if (config != null) {
            config2 = config;
        } else {
            config2 = f430385k;
        }
        bitmap = lVar.get(i3, i16, config2);
        if (bitmap == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Missing bitmap=" + this.f430386a.a(i3, i16, config));
            }
            this.f430393h++;
        } else {
            this.f430392g++;
            this.f430391f -= this.f430386a.c(bitmap);
            this.f430389d.b(bitmap);
            m(bitmap);
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            Log.v("LruBitmapPool", "Get bitmap=" + this.f430386a.a(i3, i16, config));
        }
        e();
        return bitmap;
    }

    @TargetApi(19)
    private static void l(Bitmap bitmap) {
        bitmap.setPremultiplied(true);
    }

    private static void m(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        l(bitmap);
    }

    private synchronized void n(long j3) {
        while (this.f430391f > j3) {
            Bitmap removeLast = this.f430386a.removeLast();
            if (removeLast == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    Log.w("LruBitmapPool", "Size mismatch, resetting");
                    f();
                }
                this.f430391f = 0L;
                return;
            }
            this.f430389d.b(removeLast);
            this.f430391f -= this.f430386a.c(removeLast);
            this.f430395j++;
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Evicting bitmap=" + this.f430386a.b(removeLast));
            }
            e();
            removeLast.recycle();
        }
    }

    @Override // r.d
    public void a() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        n(0L);
    }

    @Override // r.d
    @NonNull
    public Bitmap b(int i3, int i16, Bitmap.Config config) {
        Bitmap j3 = j(i3, i16, config);
        if (j3 == null) {
            return d(i3, i16, config);
        }
        return j3;
    }

    @Override // r.d
    @NonNull
    public Bitmap get(int i3, int i16, Bitmap.Config config) {
        Bitmap j3 = j(i3, i16, config);
        if (j3 != null) {
            j3.eraseColor(0);
            return j3;
        }
        return d(i3, i16, config);
    }

    public long k() {
        return this.f430390e;
    }

    @Override // r.d
    public synchronized void put(Bitmap bitmap) {
        try {
            if (bitmap != null) {
                if (!bitmap.isRecycled()) {
                    if (bitmap.isMutable() && this.f430386a.c(bitmap) <= this.f430390e && this.f430387b.contains(bitmap.getConfig())) {
                        int c16 = this.f430386a.c(bitmap);
                        this.f430386a.put(bitmap);
                        this.f430389d.a(bitmap);
                        this.f430394i++;
                        this.f430391f += c16;
                        if (Log.isLoggable("LruBitmapPool", 2)) {
                            Log.v("LruBitmapPool", "Put bitmap in pool=" + this.f430386a.b(bitmap));
                        }
                        e();
                        g();
                        return;
                    }
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + this.f430386a.b(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.f430387b.contains(bitmap.getConfig()));
                    }
                    bitmap.recycle();
                    return;
                }
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            throw new NullPointerException("Bitmap must not be null");
        } catch (Throwable th5) {
            throw th5;
        }
    }

    @Override // r.d
    @SuppressLint({"InlinedApi"})
    public void trimMemory(int i3) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i3);
        }
        if (i3 < 40 && i3 < 20) {
            if (i3 >= 20 || i3 == 15) {
                n(k() / 2);
                return;
            }
            return;
        }
        a();
    }

    public k(long j3) {
        this(j3, i(), h());
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static final class b implements a {
        b() {
        }

        @Override // r.k.a
        public void a(Bitmap bitmap) {
        }

        @Override // r.k.a
        public void b(Bitmap bitmap) {
        }
    }
}
