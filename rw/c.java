package rw;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    ArrayList<a> f432585a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    boolean f432586b = false;

    /* renamed from: c, reason: collision with root package name */
    boolean f432587c = false;

    /* renamed from: d, reason: collision with root package name */
    public int f432588d = -1;

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        this.f432585a.add(aVar);
    }

    public ArrayList<a> b() {
        return this.f432585a;
    }

    public a c(int i3) {
        Iterator<a> it = this.f432585a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.b() == i3) {
                return next;
            }
        }
        return null;
    }

    public ArrayList<a> d() {
        ArrayList<a> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < this.f432585a.size(); i3++) {
            if (this.f432585a.get(i3).h()) {
                arrayList.add(this.f432585a.get(i3));
            }
        }
        return arrayList;
    }

    public boolean e() {
        return this.f432586b;
    }

    public void f() {
        this.f432585a.clear();
    }

    public void g(int i3) {
        h(c(i3));
    }

    public void h(a aVar) {
        if (aVar == null) {
            return;
        }
        this.f432585a.remove(aVar);
    }

    public void i(boolean z16) {
        this.f432586b = z16;
    }
}
