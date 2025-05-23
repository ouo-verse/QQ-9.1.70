package sx2;

import java.util.Comparator;
import tz3.g;
import tz3.i;

/* compiled from: P */
/* loaded from: classes19.dex */
public class d implements g {

    /* renamed from: a, reason: collision with root package name */
    private c f434940a;

    @Override // tz3.g
    public com.tencent.rfw.barrage.core.a a(i iVar, com.tencent.rfw.barrage.core.f fVar, Comparator<com.tencent.rfw.barrage.data.a> comparator, vz3.c cVar, vz3.a aVar) {
        c cVar2 = new c(iVar, fVar, comparator, cVar, aVar);
        this.f434940a = cVar2;
        return cVar2;
    }

    public c b() {
        return this.f434940a;
    }
}
