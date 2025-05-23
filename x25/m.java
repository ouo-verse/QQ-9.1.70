package x25;

import c45.b;
import c45.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import p35.ah;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class m extends c45.j {
    public boolean C;
    public final List<r35.a> D;
    public l E;
    public long F;
    public String G;
    public int H;
    public l25.b I;
    public r35.a J;

    /* renamed from: d, reason: collision with root package name */
    public ah f447113d;

    /* renamed from: e, reason: collision with root package name */
    public final List<n> f447114e;

    /* renamed from: f, reason: collision with root package name */
    public long f447115f;

    /* renamed from: h, reason: collision with root package name */
    public final List<k> f447116h;

    /* renamed from: i, reason: collision with root package name */
    public long f447117i;

    /* renamed from: m, reason: collision with root package name */
    public final List<n> f447118m;

    public m() {
        this(null, null, 0L, null, 0L, null, false, null, null, 0L, null, 0, null, null, 16383, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new m(null, null, 0L, null, 0L, null, false, null, null, 0L, null, 0, null, null, 16383, null));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common.feed.StPoiInfoV2");
                this.f447113d = (ah) obj;
                return;
            case 2:
                List<n> list = this.f447114e;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.poi_svr.poi_svr.PoiTag>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.f447115f = ((Long) obj).longValue();
                return;
            case 4:
                List<k> list2 = this.f447116h;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.poi_svr.poi_svr.PoiActUser>");
                CollectionsKt__MutableCollectionsKt.addAll(list2, (Sequence) obj);
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.f447117i = ((Long) obj).longValue();
                return;
            case 6:
                List<n> list3 = this.f447118m;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.poi_svr.poi_svr.PoiTag>");
                CollectionsKt__MutableCollectionsKt.addAll(list3, (Sequence) obj);
                return;
            case 7:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                this.C = ((Boolean) obj).booleanValue();
                return;
            case 8:
                List<r35.a> list4 = this.D;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.qqstranger.common.meta.Image>");
                CollectionsKt__MutableCollectionsKt.addAll(list4, (Sequence) obj);
                return;
            case 9:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.poi_svr.poi_svr.PoiActivateInfo");
                this.E = (l) obj;
                return;
            case 10:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.F = ((Long) obj).longValue();
                return;
            case 11:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.G = (String) obj;
                return;
            case 12:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.lplan.poi_svr.poi_svr.Poi_svrKt.PoiDataType }");
                this.H = ((Integer) obj).intValue();
                return;
            case 13:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.channel_feed.ChChannelSign");
                this.I = (l25.b) obj;
                return;
            case 14:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common.meta.Image");
                this.J = (r35.a) obj;
                return;
            default:
                return;
        }
    }

    public /* synthetic */ m(ah ahVar, List list, long j3, List list2, long j16, List list3, boolean z16, List list4, l lVar, long j17, String str, int i3, l25.b bVar, r35.a aVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, new ArrayList(), 0L, new ArrayList(), 0L, new ArrayList(), false, new ArrayList(), null, 0L, "", d.c.f30317b.b().getValue(), null, null);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        String str = null;
        long j3 = 0;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f447113d, new b.d(new ah(null, null, 0, null, str, 0, null, 0, 0, null, null, null, null, 0, 0, null, null, null, null, null, null, 2097151)))), TuplesKt.to(2, new c45.h(2, this.f447114e, new b.f(new b.d(new n(j3, str, 0L, 7, 0 == true ? 1 : 0)), false))), TuplesKt.to(3, new c45.h(3, Long.valueOf(this.f447115f), new b.e.f(false))), TuplesKt.to(4, new c45.h(4, this.f447116h, new b.f(new b.d(new k()), false))), TuplesKt.to(5, new c45.h(5, Long.valueOf(this.f447117i), new b.e.i(false))), TuplesKt.to(6, new c45.h(6, this.f447118m, new b.f(new b.d(new n(j3, str, 0L, 7, 0 == true ? 1 : 0)), false))), TuplesKt.to(7, new c45.h(7, Boolean.valueOf(this.C), new b.e.a(false))), TuplesKt.to(8, new c45.h(8, this.D, new b.f(new b.d(new r35.a(0, 0, str, 7, null)), false))), TuplesKt.to(9, new c45.h(9, this.E, new b.d(new l(false, 0L, 0 == true ? 1 : 0, 0L, 15, 0 == true ? 1 : 0)))), TuplesKt.to(10, new c45.h(10, Long.valueOf(this.F), new b.e.f(false))), TuplesKt.to(11, new c45.h(11, this.G, new b.e.g(false))), TuplesKt.to(12, new c45.h(12, Integer.valueOf(this.H), new b.a(false))), TuplesKt.to(13, new c45.h(13, this.I, new b.d(new l25.b(0L, 7)))), TuplesKt.to(14, new c45.h(14, this.J, new b.d(new r35.a(0, 0, null, 7, null)))));
        return mapOf;
    }

    public m(ah ahVar, List<n> list, long j3, List<k> list2, long j16, List<n> list3, boolean z16, List<r35.a> list4, l lVar, long j17, String str, int i3, l25.b bVar, r35.a aVar) {
        this.f447113d = ahVar;
        this.f447114e = list;
        this.f447115f = j3;
        this.f447116h = list2;
        this.f447117i = j16;
        this.f447118m = list3;
        this.C = z16;
        this.D = list4;
        this.E = lVar;
        this.F = j17;
        this.G = str;
        this.H = i3;
        this.I = bVar;
        this.J = aVar;
    }
}
