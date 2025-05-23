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
public final class c extends c45.j {
    public final List<o25.g> C;
    public final List<t> D;

    /* renamed from: d, reason: collision with root package name */
    public m25.c f440835d;

    /* renamed from: e, reason: collision with root package name */
    public final List<p> f440836e;

    /* renamed from: f, reason: collision with root package name */
    public final List<a> f440837f;

    /* renamed from: h, reason: collision with root package name */
    public final List<o25.a> f440838h;

    /* renamed from: i, reason: collision with root package name */
    public int f440839i;

    /* renamed from: m, reason: collision with root package name */
    public int f440840m;

    public c() {
        this(null, null, null, null, 0, 0, null, null, 255, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new c(null, null, null, null, 0, 0, null, null, 255, null));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
                this.f440835d = (m25.c) obj;
                return;
            case 2:
                List<p> list = this.f440836e;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.map_svr.nearby_map_svr.Person>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
                return;
            case 3:
                List<a> list2 = this.f440837f;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.map_svr.nearby_map_svr.Feed>");
                CollectionsKt__MutableCollectionsKt.addAll(list2, (Sequence) obj);
                return;
            case 4:
                List<o25.a> list3 = this.f440838h;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.common.map.Area>");
                CollectionsKt__MutableCollectionsKt.addAll(list3, (Sequence) obj);
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f440839i = ((Integer) obj).intValue();
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f440840m = ((Integer) obj).intValue();
                return;
            case 7:
                List<o25.g> list4 = this.C;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.common.map.OperationMarker>");
                CollectionsKt__MutableCollectionsKt.addAll(list4, (Sequence) obj);
                return;
            case 8:
                List<t> list5 = this.D;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.map_svr.nearby_map_svr.SimplePoi>");
                CollectionsKt__MutableCollectionsKt.addAll(list5, (Sequence) obj);
                return;
            default:
                return;
        }
    }

    public /* synthetic */ c(m25.c cVar, List list, List list2, List list3, int i3, int i16, List list4, List list5, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, new ArrayList(), new ArrayList(), new ArrayList(), 0, 0, new ArrayList(), new ArrayList());
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f440835d, new b.d(new m25.c(null, null, 15)))), TuplesKt.to(2, new c45.h(2, this.f440836e, new b.f(new b.d(new p(0L, null, null, null, null, 2047)), false))), TuplesKt.to(3, new c45.h(3, this.f440837f, new b.f(new b.d(new a(null, 0L, null, null, null, null, 0, 0, null, null, null, null, 0, null, null, null, 4194303)), false))), TuplesKt.to(4, new c45.h(4, this.f440838h, new b.f(new b.d(new o25.a(0, null, null, null, null, 31, null)), false))), TuplesKt.to(5, new c45.h(5, Integer.valueOf(this.f440839i), new b.e.h(false))), TuplesKt.to(6, new c45.h(6, Integer.valueOf(this.f440840m), new b.e.h(false))), TuplesKt.to(7, new c45.h(7, this.C, new b.f(new b.d(new o25.g(null, 0, 0, null, null, 31, null)), false))), TuplesKt.to(8, new c45.h(8, this.D, new b.f(new b.d(new t(null, null, null, false, false, 31, null)), false))));
        return mapOf;
    }

    public c(m25.c cVar, List<p> list, List<a> list2, List<o25.a> list3, int i3, int i16, List<o25.g> list4, List<t> list5) {
        this.f440835d = cVar;
        this.f440836e = list;
        this.f440837f = list2;
        this.f440838h = list3;
        this.f440839i = i3;
        this.f440840m = i16;
        this.C = list4;
        this.D = list5;
    }
}
