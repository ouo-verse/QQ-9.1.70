package s;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import p.b;
import s.a;

/* compiled from: P */
/* loaded from: classes.dex */
public class e implements a {

    /* renamed from: b, reason: collision with root package name */
    private final File f433023b;

    /* renamed from: c, reason: collision with root package name */
    private final long f433024c;

    /* renamed from: e, reason: collision with root package name */
    private p.b f433026e;

    /* renamed from: d, reason: collision with root package name */
    private final c f433025d = new c();

    /* renamed from: a, reason: collision with root package name */
    private final j f433022a = new j();

    @Deprecated
    protected e(File file, long j3) {
        this.f433023b = file;
        this.f433024c = j3;
    }

    public static a c(File file, long j3) {
        return new e(file, j3);
    }

    private synchronized p.b d() throws IOException {
        if (this.f433026e == null) {
            this.f433026e = p.b.t(this.f433023b, 1, 1, this.f433024c);
        }
        return this.f433026e;
    }

    @Override // s.a
    public void a(com.bumptech.glide.load.c cVar, a.b bVar) {
        p.b d16;
        String b16 = this.f433022a.b(cVar);
        this.f433025d.a(b16);
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Log.v("DiskLruCacheWrapper", "Put: Obtained: " + b16 + " for for Key: " + cVar);
            }
            try {
                d16 = d();
            } catch (IOException e16) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e16);
                }
            }
            if (d16.r(b16) != null) {
                return;
            }
            b.c o16 = d16.o(b16);
            if (o16 != null) {
                try {
                    if (bVar.write(o16.f(0))) {
                        o16.e();
                    }
                    o16.b();
                    return;
                } catch (Throwable th5) {
                    o16.b();
                    throw th5;
                }
            }
            throw new IllegalStateException("Had two simultaneous puts for: " + b16);
        } finally {
            this.f433025d.b(b16);
        }
    }

    @Override // s.a
    public File b(com.bumptech.glide.load.c cVar) {
        String b16 = this.f433022a.b(cVar);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + b16 + " for for Key: " + cVar);
        }
        try {
            b.e r16 = d().r(b16);
            if (r16 == null) {
                return null;
            }
            return r16.a(0);
        } catch (IOException e16) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e16);
            return null;
        }
    }
}
