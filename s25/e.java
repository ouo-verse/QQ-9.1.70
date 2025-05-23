package s25;

import c45.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import n25.k;
import n25.m;
import n35.w;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class e extends c45.j {
    public w C;
    public m25.c D;
    public final List<m> E;
    public int F;
    public n25.b G;
    public final List<String> H;

    /* renamed from: d, reason: collision with root package name */
    public int f433133d;

    /* renamed from: e, reason: collision with root package name */
    public int f433134e;

    /* renamed from: f, reason: collision with root package name */
    public int f433135f;

    /* renamed from: h, reason: collision with root package name */
    public c45.a f433136h;

    /* renamed from: i, reason: collision with root package name */
    public k f433137i;

    /* renamed from: m, reason: collision with root package name */
    public final List<w> f433138m;

    public /* synthetic */ e(int i3, int i16, int i17, c45.a aVar, k kVar, List list, w wVar, m25.c cVar, List list2, int i18, n25.b bVar, List list3, int i19) {
        this((i19 & 1) != 0 ? 0 : i3, (i19 & 2) != 0 ? 0 : i16, (i19 & 4) != 0 ? 0 : i17, (i19 & 8) != 0 ? c45.a.f30290b : aVar, (i19 & 16) != 0 ? null : kVar, (i19 & 32) != 0 ? new ArrayList() : list, (i19 & 64) != 0 ? null : wVar, (i19 & 128) != 0 ? null : cVar, (i19 & 256) != 0 ? new ArrayList() : list2, (i19 & 512) == 0 ? i18 : 0, (i19 & 1024) == 0 ? bVar : null, (i19 & 2048) != 0 ? new ArrayList() : list3);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new e(0, 0, 0, null, null, null, null, null, null, 0, null, null, 4095));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f433133d = ((Integer) obj).intValue();
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f433134e = ((Integer) obj).intValue();
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f433135f = ((Integer) obj).intValue();
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
                this.f433136h = (c45.a) obj;
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.feed.StPoiInfoV2");
                this.f433137i = (k) obj;
                return;
            case 6:
                List<w> list = this.f433138m;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.MsgInfo>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
                return;
            case 7:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.MsgInfo");
                this.C = (w) obj;
                return;
            case 8:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
                this.D = (m25.c) obj;
                return;
            case 9:
                List<m> list2 = this.E;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.common.feed.Topic>");
                CollectionsKt__MutableCollectionsKt.addAll(list2, (Sequence) obj);
                return;
            case 10:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.F = ((Integer) obj).intValue();
                return;
            case 11:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.feed.CityWalkInfo");
                this.G = (n25.b) obj;
                return;
            case 12:
                List<String> list3 = this.H;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kotlin.String>");
                CollectionsKt__MutableCollectionsKt.addAll(list3, (Sequence) obj);
                return;
            default:
                return;
        }
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f433133d), new b.e.h(false))), TuplesKt.to(2, new c45.h(2, Integer.valueOf(this.f433134e), new b.e.h(false))), TuplesKt.to(3, new c45.h(3, Integer.valueOf(this.f433135f), new b.e.h(false))), TuplesKt.to(4, new c45.h(4, this.f433136h, new b.e.C0167b(false))), TuplesKt.to(5, new c45.h(5, this.f433137i, new b.d(new k((String) null, (String) null, 0, (String) null, (String) null, 0, (n25.i) null, 0, 0, (String) null, (String) null, (String) null, (String) null, 0, 0, (String) null, (String) null, (String) null, (String) null, (String) null, 2097151)))), TuplesKt.to(6, new c45.h(6, this.f433138m, new b.f(new b.d(new w(null, null, 3, null)), false))), TuplesKt.to(7, new c45.h(7, this.C, new b.d(new w(null, null, 3, null)))), TuplesKt.to(8, new c45.h(8, this.D, new b.d(new m25.c(null, null, 15)))), TuplesKt.to(9, new c45.h(9, this.E, new b.f(new b.d(new m(null, 15)), false))), TuplesKt.to(10, new c45.h(10, Integer.valueOf(this.F), new b.e.h(false))), TuplesKt.to(11, new c45.h(11, this.G, new b.d(new n25.b(null, 1, null)))), TuplesKt.to(12, new c45.h(12, this.H, new b.f(new b.e.g(false), false))));
        return mapOf;
    }

    public e(int i3, int i16, int i17, c45.a aVar, k kVar, List<w> list, w wVar, m25.c cVar, List<m> list2, int i18, n25.b bVar, List<String> list3) {
        this.f433133d = i3;
        this.f433134e = i16;
        this.f433135f = i17;
        this.f433136h = aVar;
        this.f433137i = kVar;
        this.f433138m = list;
        this.C = wVar;
        this.D = cVar;
        this.E = list2;
        this.F = i18;
        this.G = bVar;
        this.H = list3;
    }
}
