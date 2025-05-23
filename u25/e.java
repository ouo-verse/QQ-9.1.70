package u25;

import c45.b;
import c45.h;
import c45.j;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class e extends j {

    /* renamed from: d, reason: collision with root package name */
    public m25.c f438166d;

    /* renamed from: e, reason: collision with root package name */
    public final List<Integer> f438167e;

    public e(m25.c cVar, List<Integer> list) {
        this.f438166d = cVar;
        this.f438167e = list;
    }

    @Override // c45.j
    public final j decodeWith(c45.f fVar) {
        return fVar.g(new e(null, new ArrayList()));
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.f438166d, new b.d(new m25.c(null, null, 15)))), TuplesKt.to(2, new h(2, this.f438167e, new b.f(new b.e.h(false), true))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f438166d = (m25.c) obj;
        } else {
            if (i3 != 2) {
                return;
            }
            List<Integer> list = this.f438167e;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kotlin.Int>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        }
    }
}
