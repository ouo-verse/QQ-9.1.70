package u25;

import c45.b;
import c45.h;
import c45.j;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class b extends j {

    /* renamed from: d, reason: collision with root package name */
    public n25.f f438161d;

    /* renamed from: e, reason: collision with root package name */
    public m25.c f438162e;

    public b() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // c45.j
    public final j decodeWith(c45.f fVar) {
        return fVar.g(new b(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0));
    }

    public /* synthetic */ b(n25.f fVar, m25.c cVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, null);
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.f438161d, new b.d(new n25.f(null, 0, null, 0, 63)))), TuplesKt.to(2, new h(2, this.f438162e, new b.d(new m25.c(null, null, 15)))));
        return mapOf;
    }

    public b(n25.f fVar, m25.c cVar) {
        this.f438161d = fVar;
        this.f438162e = cVar;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.feed.LikeInfo");
            this.f438161d = (n25.f) obj;
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f438162e = (m25.c) obj;
        }
    }
}
