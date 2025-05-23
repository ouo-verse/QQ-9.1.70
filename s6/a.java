package s6;

import android.text.SpannableString;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private int f433367a;

    /* renamed from: b, reason: collision with root package name */
    private SpannableString f433368b;

    /* renamed from: c, reason: collision with root package name */
    private int f433369c;

    /* renamed from: d, reason: collision with root package name */
    private int f433370d;

    /* renamed from: e, reason: collision with root package name */
    private Object f433371e;

    /* renamed from: f, reason: collision with root package name */
    private int f433372f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f433373g;

    public a() {
        this.f433367a = 0;
        this.f433368b = null;
        this.f433369c = 0;
        this.f433370d = 0;
        this.f433371e = null;
        this.f433372f = 0;
        this.f433373g = true;
    }

    public int a() {
        return this.f433370d;
    }

    public int b() {
        return this.f433369c;
    }

    public SpannableString c() {
        return this.f433368b;
    }

    public int d() {
        return this.f433367a;
    }

    public int e() {
        return this.f433372f;
    }

    public boolean f() {
        return this.f433373g;
    }

    public void g(boolean z16, com.qzone.detail.ui.component.a aVar) {
        this.f433373g = z16;
        if (aVar != null) {
            aVar.k(this);
        }
    }

    public void h(int i3, com.qzone.detail.ui.component.a aVar) {
        this.f433369c = i3;
        if (aVar != null) {
            aVar.k(this);
        }
    }

    public a(int i3, String str, int i16, Object obj, int i17) {
        this.f433367a = 0;
        this.f433368b = null;
        this.f433369c = 0;
        this.f433370d = 0;
        this.f433371e = null;
        this.f433372f = 0;
        this.f433373g = true;
        SpannableString spannableString = new SpannableString(str);
        this.f433369c = i3;
        this.f433368b = spannableString;
        this.f433370d = i16;
        this.f433371e = obj;
        this.f433372f = i17;
    }
}
