package tz3;

import android.util.DisplayMetrics;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes25.dex */
public class k {

    /* renamed from: q, reason: collision with root package name */
    private static boolean f437952q = true;

    /* renamed from: a, reason: collision with root package name */
    private int f437953a;

    /* renamed from: b, reason: collision with root package name */
    private int f437954b;

    /* renamed from: c, reason: collision with root package name */
    private int f437955c;

    /* renamed from: d, reason: collision with root package name */
    private int f437956d;

    /* renamed from: e, reason: collision with root package name */
    private int f437957e;

    /* renamed from: f, reason: collision with root package name */
    private float f437958f;

    /* renamed from: g, reason: collision with root package name */
    private float f437959g;

    /* renamed from: i, reason: collision with root package name */
    private boolean f437961i;

    /* renamed from: j, reason: collision with root package name */
    private int f437962j;

    /* renamed from: k, reason: collision with root package name */
    private int f437963k;

    /* renamed from: l, reason: collision with root package name */
    private float f437964l;

    /* renamed from: m, reason: collision with root package name */
    private float f437965m;

    /* renamed from: n, reason: collision with root package name */
    private float f437966n;

    /* renamed from: o, reason: collision with root package name */
    private float f437967o;

    /* renamed from: h, reason: collision with root package name */
    private volatile AtomicBoolean f437960h = new AtomicBoolean();

    /* renamed from: p, reason: collision with root package name */
    private boolean f437968p = false;

    public k() {
        DisplayMetrics displayMetrics = wz3.g.a().getDisplayMetrics();
        int i3 = displayMetrics.widthPixels;
        int i16 = displayMetrics.heightPixels;
        if (this.f437968p) {
            this.f437963k = Math.max(i3, i16);
            this.f437962j = Math.min(i3, i16);
        } else {
            this.f437963k = Math.min(i3, i16);
            this.f437962j = Math.max(i3, i16);
        }
        v(8000);
        G(12);
        B(3);
        y(1.5f);
        x(1);
        s(5.0f);
        t(5.0f);
        r(true);
        u(true);
        E(16.0f);
        q(0.0f);
        A(5.0f);
        z(4.0f);
    }

    public static boolean p() {
        return f437952q;
    }

    public static void w(boolean z16) {
        f437952q = z16;
    }

    public void A(float f16) {
        this.f437966n = wz3.d.b(f16);
    }

    public void B(int i3) {
        this.f437955c = i3;
    }

    public void C(int i3) {
        this.f437963k = i3;
    }

    public void D(int i3) {
        this.f437962j = i3;
    }

    public void E(float f16) {
        this.f437964l = wz3.d.b(f16);
    }

    public void F(boolean z16) {
        if (this.f437968p != z16) {
            int i3 = this.f437962j;
            this.f437962j = this.f437963k;
            this.f437963k = i3;
        }
        this.f437968p = z16;
    }

    public void G(int i3) {
        this.f437954b = wz3.d.b(i3);
    }

    public float a() {
        return this.f437965m;
    }

    public float b() {
        return this.f437958f;
    }

    public float c() {
        return this.f437959g;
    }

    public int d() {
        return this.f437953a;
    }

    public int e() {
        return this.f437957e;
    }

    public int f() {
        return this.f437956d;
    }

    public float g() {
        return this.f437967o;
    }

    public float h() {
        return this.f437966n;
    }

    public int i() {
        return this.f437955c;
    }

    public int j() {
        return this.f437963k;
    }

    public int k() {
        return this.f437962j;
    }

    public float l() {
        return this.f437964l;
    }

    public int m() {
        return this.f437954b;
    }

    public boolean n() {
        return this.f437960h.get();
    }

    public boolean o() {
        return this.f437961i;
    }

    public void q(float f16) {
        this.f437965m = f16;
    }

    public void r(boolean z16) {
        this.f437960h.set(z16);
    }

    public void s(float f16) {
        this.f437958f = wz3.d.b(f16);
    }

    public void t(float f16) {
        this.f437959g = wz3.d.b(f16);
    }

    public void u(boolean z16) {
        this.f437961i = z16;
    }

    public void v(int i3) {
        this.f437953a = i3;
    }

    public void x(int i3) {
        this.f437957e = wz3.d.b(i3);
    }

    public void y(float f16) {
        this.f437956d = wz3.d.b(f16);
    }

    public void z(float f16) {
        this.f437967o = wz3.d.b(f16);
    }
}
