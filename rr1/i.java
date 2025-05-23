package rr1;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes14.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private int f432017a = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f432018b = 1000;

    /* renamed from: c, reason: collision with root package name */
    private int f432019c = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f432020d = 3;

    /* renamed from: e, reason: collision with root package name */
    private int f432021e = 3;

    /* renamed from: f, reason: collision with root package name */
    private int f432022f = 0;

    /* renamed from: g, reason: collision with root package name */
    private float f432023g = 0.0f;

    public int a() {
        return this.f432020d;
    }

    public float b() {
        return this.f432023g;
    }

    public int c() {
        return this.f432021e;
    }

    public int d() {
        return this.f432019c;
    }

    public int e() {
        return this.f432018b;
    }

    public int f() {
        return this.f432017a;
    }

    public int g() {
        return this.f432022f;
    }

    public boolean h() {
        if (this.f432017a == 1 && this.f432020d == 1) {
            return true;
        }
        return false;
    }

    public boolean i() {
        if (this.f432020d == 1) {
            return true;
        }
        return false;
    }

    public boolean j() {
        if (this.f432017a == 3 && this.f432021e != 1) {
            return true;
        }
        return false;
    }

    public i k(int i3) {
        this.f432020d = i3;
        return this;
    }

    public i l(float f16) {
        this.f432023g = f16;
        return this;
    }

    public i m(int i3) {
        this.f432021e = i3;
        return this;
    }

    public i n(int i3) {
        this.f432019c = i3;
        return this;
    }

    public i o(int i3) {
        this.f432018b = i3;
        return this;
    }

    public i p(int i3) {
        this.f432017a = i3;
        return this;
    }

    public i q(int i3) {
        this.f432022f = i3;
        return this;
    }

    @NonNull
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("mMoveState = " + this.f432017a);
        sb5.append(" mMoveProgress = " + this.f432018b);
        sb5.append(" mMoveDirection = " + this.f432019c);
        sb5.append(" mTriggerMoveSourceType = " + this.f432022f);
        sb5.append(" mBeginMoveFoldStatus = " + this.f432020d);
        sb5.append(" mEndMoveFoldStatus = " + this.f432021e);
        return sb5.toString();
    }
}
