package rz;

import java.util.HashSet;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes36.dex */
public class c implements a {

    /* renamed from: d, reason: collision with root package name */
    private HashSet<a> f432977d = new HashSet<>();

    @Override // rz.a
    public void e() {
        Iterator<a> it = this.f432977d.iterator();
        while (it.hasNext()) {
            it.next().e();
        }
    }

    @Override // rz.a
    public void h() {
        Iterator<a> it = this.f432977d.iterator();
        while (it.hasNext()) {
            it.next().h();
        }
    }

    @Override // rz.a
    public void j() {
        Iterator<a> it = this.f432977d.iterator();
        while (it.hasNext()) {
            it.next().j();
        }
    }

    @Override // rz.a
    public void k() {
        Iterator<a> it = this.f432977d.iterator();
        while (it.hasNext()) {
            it.next().k();
        }
    }

    @Override // rz.a
    public void onPageDestroy() {
        Iterator<a> it = this.f432977d.iterator();
        while (it.hasNext()) {
            it.next().onPageDestroy();
        }
    }

    @Override // rz.a
    public void onPagePause() {
        Iterator<a> it = this.f432977d.iterator();
        while (it.hasNext()) {
            it.next().onPagePause();
        }
    }

    public void a(HashSet<a> hashSet) {
        if (hashSet != null) {
            this.f432977d.addAll(hashSet);
        }
    }
}
