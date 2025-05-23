package v25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class k extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public m25.c f440861d;

    /* renamed from: e, reason: collision with root package name */
    public p f440862e;

    public k() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new k(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0));
    }

    public /* synthetic */ k(m25.c cVar, p pVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, null);
    }

    public k(m25.c cVar, p pVar) {
        this.f440861d = cVar;
        this.f440862e = pVar;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f440861d, new b.d(new m25.c(null, 0 == true ? 1 : 0, 15)))), TuplesKt.to(2, new c45.h(2, this.f440862e, new b.d(new p(0L, null, null, null, null, 2047)))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f440861d = (m25.c) obj;
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.map_svr.nearby_map_svr.Person");
            this.f440862e = (p) obj;
        }
    }
}
