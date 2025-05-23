package rw;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private int f432576a;

    /* renamed from: b, reason: collision with root package name */
    private String f432577b;

    /* renamed from: c, reason: collision with root package name */
    private int f432578c;

    /* renamed from: f, reason: collision with root package name */
    private String f432581f;

    /* renamed from: d, reason: collision with root package name */
    public int f432579d = -1;

    /* renamed from: e, reason: collision with root package name */
    public boolean f432580e = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f432582g = true;

    /* renamed from: h, reason: collision with root package name */
    private boolean f432583h = true;

    /* renamed from: i, reason: collision with root package name */
    private boolean f432584i = false;

    public a(int i3, String str, int i16) {
        this.f432576a = i3;
        this.f432577b = str;
        this.f432578c = i16;
    }

    public String a() {
        return this.f432581f;
    }

    public int b() {
        return this.f432576a;
    }

    public int c() {
        return b.c(this.f432576a);
    }

    public int d() {
        return this.f432578c;
    }

    public String e() {
        return this.f432577b;
    }

    public boolean f() {
        return this.f432582g;
    }

    public boolean g() {
        return this.f432584i;
    }

    public boolean h() {
        return this.f432583h;
    }

    public void i(boolean z16) {
        this.f432582g = z16;
    }

    public void j(String str) {
        this.f432581f = str;
    }

    public void k(boolean z16) {
        this.f432584i = z16;
    }

    public void l(int i3) {
        this.f432578c = i3;
    }

    public void m(String str) {
        if (!TextUtils.equals(str, this.f432577b)) {
            this.f432580e = true;
        }
        this.f432577b = str;
    }

    public void n(boolean z16) {
        this.f432583h = z16;
    }
}
