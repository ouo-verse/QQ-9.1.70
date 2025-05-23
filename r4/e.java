package r4;

import java.util.ArrayList;
import r4.b;

/* compiled from: P */
/* loaded from: classes36.dex */
public class e extends c {

    /* renamed from: l, reason: collision with root package name */
    private int f430710l;

    public e(String str, int i3, boolean z16) {
        super(str, i3, z16);
        this.f430710l = 2;
    }

    @Override // r4.c
    public boolean f() {
        return super.f();
    }

    public void h(b.a aVar) {
        if (!f() || aVar == null) {
            return;
        }
        if (k(aVar)) {
            d dVar = new d();
            dVar.a(aVar);
            i(dVar);
        } else {
            this.f430699b.get(r0.size() - 1).a(aVar);
        }
    }

    public int j() {
        return 4;
    }

    private void i(b bVar) {
        if (bVar != null && bVar.e() && f()) {
            if (!bVar.f430688a && this.f430700c.size() < this.f430710l) {
                this.f430700c.add(bVar);
            }
            this.f430699b.add(bVar);
            this.f430704g = this.f430700c.size() != this.f430699b.size();
        }
    }

    private boolean k(b.a aVar) {
        if (aVar == null || !f()) {
            return false;
        }
        ArrayList<b> arrayList = this.f430699b;
        b bVar = arrayList.get(arrayList.size() - 1);
        if (!bVar.f() && bVar.b() < j()) {
            return aVar.f430693d && !bVar.f430688a;
        }
        return true;
    }
}
