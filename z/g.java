package z;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.gifdecoder.GifDecoder;
import h0.k;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private final GifDecoder f451671a;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f451672b;

    /* renamed from: c, reason: collision with root package name */
    private final List<b> f451673c;

    /* renamed from: d, reason: collision with root package name */
    final RequestManager f451674d;

    /* renamed from: e, reason: collision with root package name */
    private final r.d f451675e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f451676f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f451677g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f451678h;

    /* renamed from: i, reason: collision with root package name */
    private com.bumptech.glide.f<Bitmap> f451679i;

    /* renamed from: j, reason: collision with root package name */
    private a f451680j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f451681k;

    /* renamed from: l, reason: collision with root package name */
    private a f451682l;

    /* renamed from: m, reason: collision with root package name */
    private Bitmap f451683m;

    /* renamed from: n, reason: collision with root package name */
    private com.bumptech.glide.load.h<Bitmap> f451684n;

    /* renamed from: o, reason: collision with root package name */
    private a f451685o;

    /* renamed from: p, reason: collision with root package name */
    private int f451686p;

    /* renamed from: q, reason: collision with root package name */
    private int f451687q;

    /* renamed from: r, reason: collision with root package name */
    private int f451688r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class a extends e0.c<Bitmap> {
        private Bitmap C;

        /* renamed from: h, reason: collision with root package name */
        private final Handler f451689h;

        /* renamed from: i, reason: collision with root package name */
        final int f451690i;

        /* renamed from: m, reason: collision with root package name */
        private final long f451691m;

        a(Handler handler, int i3, long j3) {
            this.f451689h = handler;
            this.f451690i = i3;
            this.f451691m = j3;
        }

        @Override // e0.h
        public void b(@Nullable Drawable drawable) {
            this.C = null;
        }

        Bitmap d() {
            return this.C;
        }

        @Override // e0.h
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void g(@NonNull Bitmap bitmap, @Nullable f0.d<? super Bitmap> dVar) {
            this.C = bitmap;
            this.f451689h.sendMessageAtTime(this.f451689h.obtainMessage(1, this), this.f451691m);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface b {
        void a();
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    private class c implements Handler.Callback {
        c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 1) {
                g.this.m((a) message.obj);
                return true;
            }
            if (i3 == 2) {
                g.this.f451674d.k((a) message.obj);
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(com.bumptech.glide.b bVar, GifDecoder gifDecoder, int i3, int i16, com.bumptech.glide.load.h<Bitmap> hVar, Bitmap bitmap) {
        this(bVar.f(), com.bumptech.glide.b.t(bVar.h()), gifDecoder, null, i(com.bumptech.glide.b.t(bVar.h()), i3, i16), hVar, bitmap);
    }

    private static com.bumptech.glide.load.c g() {
        return new g0.b(Double.valueOf(Math.random()));
    }

    private static com.bumptech.glide.f<Bitmap> i(RequestManager requestManager, int i3, int i16) {
        return requestManager.i().a(com.bumptech.glide.request.e.f0(com.bumptech.glide.load.engine.g.f31693b).d0(true).Y(true).Q(i3, i16));
    }

    private void l() {
        boolean z16;
        if (this.f451676f && !this.f451677g) {
            if (this.f451678h) {
                if (this.f451685o == null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                h0.j.a(z16, "Pending target must be null when starting from the first frame");
                this.f451671a.b();
                this.f451678h = false;
            }
            a aVar = this.f451685o;
            if (aVar != null) {
                this.f451685o = null;
                m(aVar);
                return;
            }
            this.f451677g = true;
            long uptimeMillis = SystemClock.uptimeMillis() + this.f451671a.c();
            this.f451671a.advance();
            this.f451682l = new a(this.f451672b, this.f451671a.getCurrentFrameIndex(), uptimeMillis);
            this.f451679i.a(com.bumptech.glide.request.e.g0(g())).s0(this.f451671a).m0(this.f451682l);
        }
    }

    private void n() {
        Bitmap bitmap = this.f451683m;
        if (bitmap != null) {
            this.f451675e.put(bitmap);
            this.f451683m = null;
        }
    }

    private void p() {
        if (this.f451676f) {
            return;
        }
        this.f451676f = true;
        this.f451681k = false;
        l();
    }

    private void q() {
        this.f451676f = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f451673c.clear();
        n();
        q();
        a aVar = this.f451680j;
        if (aVar != null) {
            this.f451674d.k(aVar);
            this.f451680j = null;
        }
        a aVar2 = this.f451682l;
        if (aVar2 != null) {
            this.f451674d.k(aVar2);
            this.f451682l = null;
        }
        a aVar3 = this.f451685o;
        if (aVar3 != null) {
            this.f451674d.k(aVar3);
            this.f451685o = null;
        }
        this.f451671a.clear();
        this.f451681k = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteBuffer b() {
        return this.f451671a.getData().asReadOnlyBuffer();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap c() {
        a aVar = this.f451680j;
        if (aVar != null) {
            return aVar.d();
        }
        return this.f451683m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        a aVar = this.f451680j;
        if (aVar != null) {
            return aVar.f451690i;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap e() {
        return this.f451683m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f451671a.getFrameCount();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        return this.f451688r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        return this.f451671a.getByteSize() + this.f451686p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k() {
        return this.f451687q;
    }

    @VisibleForTesting
    void m(a aVar) {
        this.f451677g = false;
        if (this.f451681k) {
            this.f451672b.obtainMessage(2, aVar).sendToTarget();
            return;
        }
        if (!this.f451676f) {
            if (this.f451678h) {
                this.f451672b.obtainMessage(2, aVar).sendToTarget();
                return;
            } else {
                this.f451685o = aVar;
                return;
            }
        }
        if (aVar.d() != null) {
            n();
            a aVar2 = this.f451680j;
            this.f451680j = aVar;
            for (int size = this.f451673c.size() - 1; size >= 0; size--) {
                this.f451673c.get(size).a();
            }
            if (aVar2 != null) {
                this.f451672b.obtainMessage(2, aVar2).sendToTarget();
            }
        }
        l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(com.bumptech.glide.load.h<Bitmap> hVar, Bitmap bitmap) {
        this.f451684n = (com.bumptech.glide.load.h) h0.j.d(hVar);
        this.f451683m = (Bitmap) h0.j.d(bitmap);
        this.f451679i = this.f451679i.a(new com.bumptech.glide.request.e().Z(hVar));
        this.f451686p = k.g(bitmap);
        this.f451687q = bitmap.getWidth();
        this.f451688r = bitmap.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(b bVar) {
        if (!this.f451681k) {
            if (!this.f451673c.contains(bVar)) {
                boolean isEmpty = this.f451673c.isEmpty();
                this.f451673c.add(bVar);
                if (isEmpty) {
                    p();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(b bVar) {
        this.f451673c.remove(bVar);
        if (this.f451673c.isEmpty()) {
            q();
        }
    }

    g(r.d dVar, RequestManager requestManager, GifDecoder gifDecoder, Handler handler, com.bumptech.glide.f<Bitmap> fVar, com.bumptech.glide.load.h<Bitmap> hVar, Bitmap bitmap) {
        this.f451673c = new ArrayList();
        this.f451674d = requestManager;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new c()) : handler;
        this.f451675e = dVar;
        this.f451672b = handler;
        this.f451679i = fVar;
        this.f451671a = gifDecoder;
        o(hVar, bitmap);
    }
}
