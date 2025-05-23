package r4;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes36.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public int f430698a;

    /* renamed from: e, reason: collision with root package name */
    public b f430702e;

    /* renamed from: h, reason: collision with root package name */
    public boolean f430705h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f430706i = false;

    /* renamed from: j, reason: collision with root package name */
    public int f430707j = -1;

    /* renamed from: k, reason: collision with root package name */
    public int f430708k = -1;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<b> f430699b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    public ArrayList<b> f430700c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<b> f430701d = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    public boolean f430703f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f430704g = false;

    public c(String str, int i3, boolean z16) {
        this.f430705h = false;
        this.f430698a = i3;
        this.f430705h = z16;
        b(str);
    }

    public boolean a() {
        return this.f430704g;
    }

    protected void b(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f430702e = null;
            return;
        }
        h hVar = new h();
        hVar.h(str);
        if (!hVar.e()) {
            this.f430702e = null;
            return;
        }
        this.f430702e = hVar;
        ArrayList<b> arrayList = this.f430699b;
        if (arrayList != null && this.f430700c != null) {
            arrayList.add(0, hVar);
            if (!this.f430705h) {
                this.f430700c.add(0, this.f430702e);
            }
        }
        this.f430702e.f430688a = this.f430705h;
    }

    public void c() {
        if (f() && a() && !this.f430703f) {
            this.f430701d.clear();
            Iterator<b> it = this.f430699b.iterator();
            while (it.hasNext()) {
                this.f430701d.add(it.next());
            }
            this.f430703f = true;
        }
    }

    public ArrayList<b> d() {
        if (!f()) {
            return null;
        }
        if (this.f430706i && this.f430705h) {
            this.f430703f = true;
        }
        if (this.f430703f) {
            if (this.f430701d.size() != this.f430699b.size()) {
                this.f430701d.clear();
                Iterator<b> it = this.f430699b.iterator();
                while (it.hasNext()) {
                    this.f430701d.add(it.next());
                }
            }
        } else if (this.f430701d.size() != this.f430700c.size()) {
            this.f430701d.clear();
            Iterator<b> it5 = this.f430700c.iterator();
            while (it5.hasNext()) {
                this.f430701d.add(it5.next());
            }
        }
        return this.f430701d;
    }

    public int e() {
        if (!f() || d() == null) {
            return 0;
        }
        return d().size();
    }

    public boolean f() {
        ArrayList<b> arrayList;
        b bVar = this.f430702e;
        return (bVar == null || !bVar.e() || (arrayList = this.f430699b) == null || arrayList.isEmpty()) ? false : true;
    }

    public void g() {
        if (f() && a() && this.f430703f) {
            this.f430701d.clear();
            Iterator<b> it = this.f430700c.iterator();
            while (it.hasNext()) {
                this.f430701d.add(it.next());
            }
            this.f430703f = false;
        }
    }
}
