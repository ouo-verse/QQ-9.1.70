package r4;

import android.text.TextUtils;
import java.util.ArrayList;
import r4.b;

/* compiled from: P */
/* loaded from: classes36.dex */
public class h extends b {

    /* renamed from: c, reason: collision with root package name */
    public b.a f430713c;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<b.a> f430714d;

    public h() {
        g(0);
        this.f430688a = false;
    }

    @Override // r4.b
    public int b() {
        if (e()) {
            return this.f430714d.size();
        }
        return 0;
    }

    @Override // r4.b
    public boolean e() {
        ArrayList<b.a> arrayList;
        b.a aVar = this.f430713c;
        return (aVar == null || TextUtils.isEmpty(aVar.f430690a) || (arrayList = this.f430714d) == null || arrayList.size() != 1) ? false : true;
    }

    public void h(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f430713c = null;
            this.f430714d = null;
            return;
        }
        b.a aVar = new b.a();
        this.f430713c = aVar;
        aVar.f430690a = str;
        aVar.f430691b = null;
        aVar.f430692c = false;
        if (this.f430714d == null) {
            this.f430714d = new ArrayList<>();
        }
        this.f430714d.clear();
        this.f430714d.add(this.f430713c);
    }

    @Override // r4.b
    public void a(b.a aVar) {
    }
}
