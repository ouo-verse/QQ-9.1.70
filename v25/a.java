package v25;

import c45.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import n35.w;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class a extends c45.j {
    public int C;
    public int D;
    public int E;
    public String F;
    public String G;
    public String H;
    public final List<n25.m> I;
    public int J;
    public int K;
    public n25.b L;
    public final List<String> M;
    public boolean N;
    public final List<Integer> P;
    public float Q;
    public r25.e R;
    public String S;

    /* renamed from: d, reason: collision with root package name */
    public String f440824d;

    /* renamed from: e, reason: collision with root package name */
    public long f440825e;

    /* renamed from: f, reason: collision with root package name */
    public o25.e f440826f;

    /* renamed from: h, reason: collision with root package name */
    public String f440827h;

    /* renamed from: i, reason: collision with root package name */
    public q25.g f440828i;

    /* renamed from: m, reason: collision with root package name */
    public n25.j f440829m;

    public a() {
        this(null, 0L, null, null, null, null, 0, 0, null, null, null, null, 0, null, null, null, 4194303);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new a(null, 0L, null, null, null, null, 0, 0, null, null, null, null, 0, null, 0 == true ? 1 : 0, null, 4194303));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f440824d = (String) obj;
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.f440825e = ((Long) obj).longValue();
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.map.GeoCoordinate");
                this.f440826f = (o25.e) obj;
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f440827h = (String) obj;
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.status.StatusInfo");
                this.f440828i = (q25.g) obj;
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.feed.StImage");
                this.f440829m = (n25.j) obj;
                return;
            case 7:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.C = ((Integer) obj).intValue();
                return;
            case 8:
            default:
                return;
            case 9:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.D = ((Integer) obj).intValue();
                return;
            case 10:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.E = ((Integer) obj).intValue();
                return;
            case 11:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.F = (String) obj;
                return;
            case 12:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.G = (String) obj;
                return;
            case 13:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.H = (String) obj;
                return;
            case 14:
                List<n25.m> list = this.I;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.common.feed.Topic>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
                return;
            case 15:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.J = ((Integer) obj).intValue();
                return;
            case 16:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.K = ((Integer) obj).intValue();
                return;
            case 17:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.feed.CityWalkInfo");
                this.L = (n25.b) obj;
                return;
            case 18:
                List<String> list2 = this.M;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kotlin.String>");
                CollectionsKt__MutableCollectionsKt.addAll(list2, (Sequence) obj);
                return;
            case 19:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                this.N = ((Boolean) obj).booleanValue();
                return;
            case 20:
                List<Integer> list3 = this.P;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kotlin.Int{ kuikly.com.tencent.trpcprotocol.lplan.map_svr.nearby_map_svr.Nearby_map_svrKt.FeedTag }>");
                CollectionsKt__MutableCollectionsKt.addAll(list3, (Sequence) obj);
                return;
            case 21:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Float");
                this.Q = ((Float) obj).floatValue();
                return;
            case 22:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.user.User");
                this.R = (r25.e) obj;
                return;
            case 23:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.S = (String) obj;
                return;
        }
    }

    public /* synthetic */ a(String str, long j3, o25.e eVar, String str2, q25.g gVar, n25.j jVar, int i3, int i16, String str3, String str4, String str5, List list, int i17, n25.b bVar, List list2, String str6, int i18) {
        this((i18 & 1) != 0 ? "" : str, (i18 & 2) != 0 ? 0L : j3, (i18 & 4) != 0 ? null : eVar, (i18 & 8) != 0 ? "" : str2, (i18 & 16) != 0 ? null : gVar, (i18 & 32) != 0 ? null : jVar, (i18 & 64) != 0 ? 0 : i3, 0, (i18 & 256) != 0 ? 0 : i16, (i18 & 512) != 0 ? "" : str3, (i18 & 1024) != 0 ? "" : str4, (i18 & 2048) != 0 ? "" : str5, (i18 & 4096) != 0 ? new ArrayList() : list, 0, (i18 & 16384) != 0 ? 0 : i17, (32768 & i18) != 0 ? null : bVar, (65536 & i18) != 0 ? new ArrayList() : list2, false, (262144 & i18) != 0 ? new ArrayList() : null, 0.0f, null, (i18 & 2097152) != 0 ? "" : str6);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f440824d, new b.e.g(false))), TuplesKt.to(2, new c45.h(2, Long.valueOf(this.f440825e), new b.e.i(false))), TuplesKt.to(3, new c45.h(3, this.f440826f, new b.d(new o25.e(0.0f, 0.0f, 7)))), TuplesKt.to(4, new c45.h(4, this.f440827h, new b.e.g(false))), TuplesKt.to(5, new c45.h(5, this.f440828i, new b.d(new q25.g(0, 0, null, null, null, null, null, null, null, null, 1023, null)))), TuplesKt.to(6, new c45.h(6, this.f440829m, new b.d(new n25.j((w) null, (String) (0 == true ? 1 : 0), 7)))), TuplesKt.to(7, new c45.h(7, Integer.valueOf(this.C), new b.e.h(false))), TuplesKt.to(9, new c45.h(9, Integer.valueOf(this.D), new b.e.h(false))), TuplesKt.to(10, new c45.h(10, Integer.valueOf(this.E), new b.e.h(false))), TuplesKt.to(11, new c45.h(11, this.F, new b.e.g(false))), TuplesKt.to(12, new c45.h(12, this.G, new b.e.g(false))), TuplesKt.to(13, new c45.h(13, this.H, new b.e.g(false))), TuplesKt.to(14, new c45.h(14, this.I, new b.f(new b.d(new n25.m(0 == true ? 1 : 0, 15)), false))), TuplesKt.to(15, new c45.h(15, Integer.valueOf(this.J), new b.e.h(false))), TuplesKt.to(16, new c45.h(16, Integer.valueOf(this.K), new b.e.h(false))), TuplesKt.to(17, new c45.h(17, this.L, new b.d(new n25.b(0 == true ? 1 : 0, 1, 0 == true ? 1 : 0)))), TuplesKt.to(18, new c45.h(18, this.M, new b.f(new b.e.g(false), false))), TuplesKt.to(19, new c45.h(19, Boolean.valueOf(this.N), new b.e.a(false))), TuplesKt.to(20, new c45.h(20, this.P, new b.f(new b.a(false), true))), TuplesKt.to(21, new c45.h(21, Float.valueOf(this.Q), new b.e.d(false))), TuplesKt.to(22, new c45.h(22, this.R, new b.d(new r25.e(0L, null, null, 0, null, LockFreeTaskQueueCore.MAX_CAPACITY_MASK)))), TuplesKt.to(23, new c45.h(23, this.S, new b.e.g(false))));
        return mapOf;
    }

    public a(String str, long j3, o25.e eVar, String str2, q25.g gVar, n25.j jVar, int i3, int i16, int i17, String str3, String str4, String str5, List<n25.m> list, int i18, int i19, n25.b bVar, List<String> list2, boolean z16, List<Integer> list3, float f16, r25.e eVar2, String str6) {
        this.f440824d = str;
        this.f440825e = j3;
        this.f440826f = eVar;
        this.f440827h = str2;
        this.f440828i = gVar;
        this.f440829m = jVar;
        this.C = i3;
        this.D = i16;
        this.E = i17;
        this.F = str3;
        this.G = str4;
        this.H = str5;
        this.I = list;
        this.J = i18;
        this.K = i19;
        this.L = bVar;
        this.M = list2;
        this.N = z16;
        this.P = list3;
        this.Q = f16;
        this.R = eVar2;
        this.S = str6;
    }
}
