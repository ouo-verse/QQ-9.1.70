package x25;

import c45.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import p35.ah;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class o extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public m25.c f447122d;

    /* renamed from: e, reason: collision with root package name */
    public ah f447123e;

    /* renamed from: f, reason: collision with root package name */
    public final List<n> f447124f;

    public o(m25.c cVar, ah ahVar, List<n> list) {
        this.f447122d = cVar;
        this.f447123e = ahVar;
        this.f447124f = list;
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new o(null, null, new ArrayList()));
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f447122d, new b.d(new m25.c(null, null, 15)))), TuplesKt.to(2, new c45.h(2, this.f447123e, new b.d(new ah(null, null, 0, null, null, 0, null, 0, 0, null, null, null, null, 0, 0, null, null, null, null, null, null, 2097151)))), TuplesKt.to(3, new c45.h(3, this.f447124f, new b.f(new b.d(new n(0L, null, 0L, 7, null)), false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f447122d = (m25.c) obj;
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common.feed.StPoiInfoV2");
            this.f447123e = (ah) obj;
        } else {
            if (i3 != 3) {
                return;
            }
            List<n> list = this.f447124f;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.poi_svr.poi_svr.PoiTag>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        }
    }
}
