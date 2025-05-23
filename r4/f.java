package r4;

import java.util.ArrayList;
import r4.b;

/* compiled from: P */
/* loaded from: classes36.dex */
public class f extends b {

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<b.a> f430711c;

    public f() {
        g(1);
        this.f430711c = new ArrayList<>();
    }

    @Override // r4.b
    public int b() {
        if (e()) {
            return this.f430711c.size();
        }
        return 0;
    }

    @Override // r4.b
    public boolean e() {
        ArrayList<b.a> arrayList = this.f430711c;
        return (arrayList == null || arrayList.isEmpty()) ? false : true;
    }

    public b.a h(int i3) {
        if (e()) {
            return this.f430711c.get(i3);
        }
        return null;
    }

    public ArrayList<b.a> i() {
        if (e()) {
            return this.f430711c;
        }
        return null;
    }

    @Override // r4.b
    public void a(b.a aVar) {
        if (aVar == null) {
            return;
        }
        this.f430688a = aVar.f430693d;
        this.f430711c.add(aVar);
    }
}
