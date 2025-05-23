package zv;

import android.content.Intent;
import android.os.SystemClock;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: m0, reason: collision with root package name */
    static volatile b f453488m0;
    public long A;
    public long B;
    public long C;
    public long D;
    public long E;
    public long F;
    public long G;
    public long H;
    public boolean I;
    public boolean J;
    public long K;
    public boolean L;
    public long M;
    public boolean N;
    public long O;
    public boolean P;
    public long Q;
    public boolean R;
    public long S;
    public boolean T;
    public long U;
    public boolean V;
    public long W;
    public boolean X;
    public long Y;
    public boolean Z;

    /* renamed from: a, reason: collision with root package name */
    public int f453489a;

    /* renamed from: a0, reason: collision with root package name */
    public long f453490a0;

    /* renamed from: b, reason: collision with root package name */
    public int f453491b;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f453492b0;

    /* renamed from: c, reason: collision with root package name */
    public boolean f453493c;

    /* renamed from: c0, reason: collision with root package name */
    public long f453494c0;

    /* renamed from: d, reason: collision with root package name */
    public long f453495d;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f453496d0;

    /* renamed from: e, reason: collision with root package name */
    public long f453497e;

    /* renamed from: e0, reason: collision with root package name */
    public long f453498e0;

    /* renamed from: f, reason: collision with root package name */
    public long f453499f;

    /* renamed from: f0, reason: collision with root package name */
    public boolean f453500f0;

    /* renamed from: g, reason: collision with root package name */
    public long f453501g;

    /* renamed from: g0, reason: collision with root package name */
    public long f453502g0;

    /* renamed from: h, reason: collision with root package name */
    public long f453503h;

    /* renamed from: i, reason: collision with root package name */
    public long f453505i;

    /* renamed from: i0, reason: collision with root package name */
    public boolean f453506i0;

    /* renamed from: j, reason: collision with root package name */
    public long f453507j;

    /* renamed from: k, reason: collision with root package name */
    public long f453509k;

    /* renamed from: k0, reason: collision with root package name */
    public boolean f453510k0;

    /* renamed from: l, reason: collision with root package name */
    public long f453511l;

    /* renamed from: l0, reason: collision with root package name */
    public long f453512l0;

    /* renamed from: m, reason: collision with root package name */
    public long f453513m;

    /* renamed from: n, reason: collision with root package name */
    public long f453514n;

    /* renamed from: o, reason: collision with root package name */
    public long f453515o;

    /* renamed from: p, reason: collision with root package name */
    public long f453516p;

    /* renamed from: q, reason: collision with root package name */
    public long f453517q;

    /* renamed from: r, reason: collision with root package name */
    public long f453518r;

    /* renamed from: s, reason: collision with root package name */
    public long f453519s;

    /* renamed from: t, reason: collision with root package name */
    public long f453520t;

    /* renamed from: u, reason: collision with root package name */
    public long f453521u;

    /* renamed from: v, reason: collision with root package name */
    public long f453522v;

    /* renamed from: w, reason: collision with root package name */
    public long f453523w;

    /* renamed from: x, reason: collision with root package name */
    public long f453524x;

    /* renamed from: y, reason: collision with root package name */
    public long f453525y;

    /* renamed from: z, reason: collision with root package name */
    public long f453526z;

    /* renamed from: h0, reason: collision with root package name */
    public String f453504h0 = "";

    /* renamed from: j0, reason: collision with root package name */
    public String f453508j0 = "";

    b() {
    }

    public static b a() {
        if (f453488m0 == null) {
            synchronized (b.class) {
                if (f453488m0 == null) {
                    f453488m0 = new b();
                }
            }
        }
        return f453488m0;
    }

    public void b(Intent intent, String str) {
        this.f453504h0 = str;
        if (intent != null) {
            this.f453509k = SystemClock.elapsedRealtime();
            boolean booleanExtra = intent.getBooleanExtra("isSender", false);
            this.f453493c = booleanExtra;
            if (booleanExtra) {
                this.f453509k = SystemClock.elapsedRealtime();
                this.f453511l = 0L;
                this.f453495d = intent.getLongExtra("senderStartTime", 0L);
                return;
            }
            this.f453526z = SystemClock.elapsedRealtime();
        }
    }

    public void c() {
        this.f453510k0 = false;
        this.f453493c = false;
        this.f453495d = 0L;
        this.f453497e = 0L;
        this.f453499f = 0L;
        this.f453501g = 0L;
        this.f453503h = 0L;
        this.f453505i = 0L;
        this.f453507j = 0L;
        this.f453509k = 0L;
        this.f453511l = 0L;
        this.f453513m = 0L;
        this.f453514n = 0L;
        this.f453515o = 0L;
        this.f453516p = 0L;
        this.f453517q = 0L;
        this.f453518r = 0L;
        this.f453519s = 0L;
        this.f453520t = 0L;
        this.f453521u = 0L;
        this.f453522v = 0L;
        this.f453523w = 0L;
        this.f453524x = 0L;
        this.f453525y = 0L;
        this.f453526z = 0L;
        this.A = 0L;
        this.B = 0L;
        this.C = 0L;
        this.D = 0L;
        this.E = 0L;
        this.F = 0L;
        this.G = 0L;
        this.H = 0L;
        this.I = false;
        this.J = false;
        this.f453506i0 = false;
        this.K = 0L;
        this.L = false;
        this.M = 0L;
        this.N = false;
        this.O = 0L;
        this.P = false;
        this.Q = 0L;
        this.R = false;
        this.S = 0L;
        this.T = false;
        this.U = 0L;
        this.V = false;
        this.W = 0L;
        this.X = false;
        this.Y = 0L;
        this.Z = false;
        this.f453490a0 = 0L;
        this.f453492b0 = false;
        this.f453494c0 = 0L;
        this.f453496d0 = false;
        this.f453498e0 = 0L;
        this.f453500f0 = false;
        this.f453502g0 = 0L;
    }
}
