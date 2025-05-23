package s;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import h0.k;
import i0.a;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: P */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private final h0.g<com.bumptech.glide.load.c, String> f433044a = new h0.g<>(1000);

    /* renamed from: b, reason: collision with root package name */
    private final Pools.Pool<b> f433045b = i0.a.d(10, new a());

    /* compiled from: P */
    /* loaded from: classes.dex */
    class a implements a.d<b> {
        a() {
        }

        @Override // i0.a.d
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b create() {
            try {
                return new b(MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA256));
            } catch (NoSuchAlgorithmException e16) {
                throw new RuntimeException(e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class b implements a.f {

        /* renamed from: d, reason: collision with root package name */
        final MessageDigest f433047d;

        /* renamed from: e, reason: collision with root package name */
        private final i0.c f433048e = i0.c.a();

        b(MessageDigest messageDigest) {
            this.f433047d = messageDigest;
        }

        @Override // i0.a.f
        @NonNull
        public i0.c h() {
            return this.f433048e;
        }
    }

    private String a(com.bumptech.glide.load.c cVar) {
        b bVar = (b) h0.j.d(this.f433045b.acquire());
        try {
            cVar.b(bVar.f433047d);
            return k.v(bVar.f433047d.digest());
        } finally {
            this.f433045b.release(bVar);
        }
    }

    public String b(com.bumptech.glide.load.c cVar) {
        String f16;
        synchronized (this.f433044a) {
            f16 = this.f433044a.f(cVar);
        }
        if (f16 == null) {
            f16 = a(cVar);
        }
        synchronized (this.f433044a) {
            this.f433044a.j(cVar, f16);
        }
        return f16;
    }
}
