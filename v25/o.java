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
public final class o extends c45.j {
    public String C;

    /* renamed from: d, reason: collision with root package name */
    public m25.c f440874d;

    /* renamed from: e, reason: collision with root package name */
    public final List<p> f440875e;

    /* renamed from: f, reason: collision with root package name */
    public final List<a> f440876f;

    /* renamed from: h, reason: collision with root package name */
    public final List<n25.l> f440877h;

    /* renamed from: i, reason: collision with root package name */
    public n25.l f440878i;

    /* renamed from: m, reason: collision with root package name */
    public boolean f440879m;

    public o() {
        this(null, null, null, null, null, false, null, 127, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new o(null, null, null, null, null, false, null, 127, null));
    }

    public /* synthetic */ o(m25.c cVar, List list, List list2, List list3, n25.l lVar, boolean z16, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, new ArrayList(), new ArrayList(), new ArrayList(), null, false, "");
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        String str = null;
        List list = null;
        int i3 = 0;
        n25.b bVar = null;
        List list2 = null;
        r25.e eVar = null;
        q25.g gVar = null;
        long j3 = 0;
        boolean z16 = false;
        int i16 = 0;
        int i17 = 2097151;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f440874d, new b.d(new m25.c(null, 0 == true ? 1 : 0, 15)))), TuplesKt.to(2, new c45.h(2, this.f440875e, new b.f(new b.d(new p(0L, null, null, null, null, 2047)), false))), TuplesKt.to(3, new c45.h(3, this.f440876f, new b.f(new b.d(new a(str, 0L, null, null, null, null, 0, 0, null, null, null, list, i3, bVar, list2, null, 4194303)), false))), TuplesKt.to(4, new c45.h(4, this.f440877h, new b.f(new b.d(new n25.l(str, eVar, gVar, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, j3, 0 == true ? 1 : 0, z16, i16, list, i3, bVar, list2, i17)), false))), TuplesKt.to(5, new c45.h(5, this.f440878i, new b.d(new n25.l(str, eVar, gVar, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, j3, 0 == true ? 1 : 0, z16, i16, list, i3, bVar, list2, i17)))), TuplesKt.to(6, new c45.h(6, Boolean.valueOf(this.f440879m), new b.e.a(false))), TuplesKt.to(7, new c45.h(7, this.C, new b.e.g(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
                this.f440874d = (m25.c) obj;
                return;
            case 2:
                List<p> list = this.f440875e;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.map_svr.nearby_map_svr.Person>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
                return;
            case 3:
                List<a> list2 = this.f440876f;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.map_svr.nearby_map_svr.Feed>");
                CollectionsKt__MutableCollectionsKt.addAll(list2, (Sequence) obj);
                return;
            case 4:
                List<n25.l> list3 = this.f440877h;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.common.feed.StatusFeed>");
                CollectionsKt__MutableCollectionsKt.addAll(list3, (Sequence) obj);
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.feed.StatusFeed");
                this.f440878i = (n25.l) obj;
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                this.f440879m = ((Boolean) obj).booleanValue();
                return;
            case 7:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.C = (String) obj;
                return;
            default:
                return;
        }
    }

    public o(m25.c cVar, List<p> list, List<a> list2, List<n25.l> list3, n25.l lVar, boolean z16, String str) {
        this.f440874d = cVar;
        this.f440875e = list;
        this.f440876f = list2;
        this.f440877h = list3;
        this.f440878i = lVar;
        this.f440879m = z16;
        this.C = str;
    }
}
