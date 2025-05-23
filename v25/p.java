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
public final class p extends c45.j {
    public int C;
    public final List<r25.b> D;
    public String E;
    public p25.a F;
    public final List<t35.a> G;

    /* renamed from: d, reason: collision with root package name */
    public long f440880d;

    /* renamed from: e, reason: collision with root package name */
    public o25.e f440881e;

    /* renamed from: f, reason: collision with root package name */
    public String f440882f;

    /* renamed from: h, reason: collision with root package name */
    public String f440883h;

    /* renamed from: i, reason: collision with root package name */
    public q25.g f440884i;

    /* renamed from: m, reason: collision with root package name */
    public int f440885m;

    public p() {
        this(0L, null, null, null, null, 2047);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new p(0L, null, null, null, null, 2047));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.f440880d = ((Long) obj).longValue();
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.map.GeoCoordinate");
                this.f440881e = (o25.e) obj;
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f440882f = (String) obj;
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f440883h = (String) obj;
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.status.StatusInfo");
                this.f440884i = (q25.g) obj;
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f440885m = ((Integer) obj).intValue();
                return;
            case 7:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.C = ((Integer) obj).intValue();
                return;
            case 8:
                List<r25.b> list = this.D;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.common.user.Dress>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
                return;
            case 9:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.E = (String) obj;
                return;
            case 10:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.mood.Mood");
                this.F = (p25.a) obj;
                return;
            case 11:
                List<t35.a> list2 = this.G;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.qqstranger.common.tag.Tag>");
                CollectionsKt__MutableCollectionsKt.addAll(list2, (Sequence) obj);
                return;
            default:
                return;
        }
    }

    public /* synthetic */ p(long j3, o25.e eVar, String str, String str2, List list, int i3) {
        this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) != 0 ? null : eVar, (i3 & 4) != 0 ? "" : str, (i3 & 8) != 0 ? "" : str2, null, 0, 0, (i3 & 128) != 0 ? new ArrayList() : list, (i3 & 256) != 0 ? "" : null, null, (i3 & 1024) != 0 ? new ArrayList() : null);
    }

    public p(long j3, o25.e eVar, String str, String str2, q25.g gVar, int i3, int i16, List<r25.b> list, String str3, p25.a aVar, List<t35.a> list2) {
        this.f440880d = j3;
        this.f440881e = eVar;
        this.f440882f = str;
        this.f440883h = str2;
        this.f440884i = gVar;
        this.f440885m = i3;
        this.C = i16;
        this.D = list;
        this.E = str3;
        this.F = aVar;
        this.G = list2;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        int i3 = 0;
        String str = null;
        String str2 = null;
        DefaultConstructorMarker defaultConstructorMarker = null;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Long.valueOf(this.f440880d), new b.e.i(false))), TuplesKt.to(2, new c45.h(2, this.f440881e, new b.d(new o25.e(0.0f, 0.0f, 7)))), TuplesKt.to(3, new c45.h(3, this.f440882f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, this.f440883h, new b.e.g(false))), TuplesKt.to(5, new c45.h(5, this.f440884i, new b.d(new q25.g(0, i3, null, null, null, null, null, null, str, str2, 1023, defaultConstructorMarker)))), TuplesKt.to(6, new c45.h(6, Integer.valueOf(this.f440885m), new b.e.h(false))), TuplesKt.to(7, new c45.h(7, Integer.valueOf(this.C), new b.e.h(false))), TuplesKt.to(8, new c45.h(8, this.D, new b.f(new b.d(new r25.b(0, (r25.c) null, 7)), false))), TuplesKt.to(9, new c45.h(9, this.E, new b.e.g(false))), TuplesKt.to(10, new c45.h(10, this.F, new b.d(new p25.a(0L, i3, 0 == true ? 1 : 0, 0L, 0L, 0, str, str2, 255, defaultConstructorMarker)))), TuplesKt.to(11, new c45.h(11, this.G, new b.f(new b.d(new t35.a(0, null, 63)), false))));
        return mapOf;
    }
}
