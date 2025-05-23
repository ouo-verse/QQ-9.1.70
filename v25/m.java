package v25;

import c45.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class m extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public m25.c f440865d;

    /* renamed from: e, reason: collision with root package name */
    public final List<q> f440866e;

    /* renamed from: f, reason: collision with root package name */
    public final List<o25.a> f440867f;

    public m() {
        this(null, null, null, 7, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new m(null, null, null, 7, null));
    }

    public /* synthetic */ m(m25.c cVar, List list, List list2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, new ArrayList(), new ArrayList());
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f440865d, new b.d(new m25.c(null, 0 == true ? 1 : 0, 15)))), TuplesKt.to(2, new c45.h(2, this.f440866e, new b.f(new b.d(new q(0, null, null, null, null, 31, null)), false))), TuplesKt.to(3, new c45.h(3, this.f440867f, new b.f(new b.d(new o25.a(0, null, null, null, null, 31, null)), false))));
        return mapOf;
    }

    public m(m25.c cVar, List<q> list, List<o25.a> list2) {
        this.f440865d = cVar;
        this.f440866e = list;
        this.f440867f = list2;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f440865d = (m25.c) obj;
        } else if (i3 == 2) {
            List<q> list = this.f440866e;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.map_svr.nearby_map_svr.RecIcon>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        } else {
            if (i3 != 3) {
                return;
            }
            List<o25.a> list2 = this.f440867f;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.common.map.Area>");
            CollectionsKt__MutableCollectionsKt.addAll(list2, (Sequence) obj);
        }
    }
}
