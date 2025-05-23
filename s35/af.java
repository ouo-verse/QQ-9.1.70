package s35;

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

/* compiled from: P */
/* loaded from: classes36.dex */
public final class af extends c45.j {
    public d C;
    public String D;
    public String E;
    public String F;
    public final List<String> G;
    public String H;
    public final List<t35.a> I;
    public final List<t35.a> J;
    public int K;
    public boolean L;
    public g M;
    public final List<String> N;
    public final List<String> P;
    public int Q;
    public int R;
    public final List<String> S;
    public final List<e> T;
    public int U;
    public int V;
    public int W;
    public String X;
    public ag Y;
    public r Z;

    /* renamed from: a0, reason: collision with root package name */
    public aa f433202a0;

    /* renamed from: b0, reason: collision with root package name */
    public int f433203b0;

    /* renamed from: c0, reason: collision with root package name */
    public String f433204c0;

    /* renamed from: d, reason: collision with root package name */
    public String f433205d;

    /* renamed from: d0, reason: collision with root package name */
    public a f433206d0;

    /* renamed from: e, reason: collision with root package name */
    public long f433207e;

    /* renamed from: e0, reason: collision with root package name */
    public j25.c f433208e0;

    /* renamed from: f, reason: collision with root package name */
    public String f433209f;

    /* renamed from: f0, reason: collision with root package name */
    public final List<r25.b> f433210f0;

    /* renamed from: g0, reason: collision with root package name */
    public final List<t35.a> f433211g0;

    /* renamed from: h, reason: collision with root package name */
    public int f433212h;

    /* renamed from: h0, reason: collision with root package name */
    public final List<t35.a> f433213h0;

    /* renamed from: i, reason: collision with root package name */
    public String f433214i;

    /* renamed from: i0, reason: collision with root package name */
    public boolean f433215i0;

    /* renamed from: j0, reason: collision with root package name */
    public boolean f433216j0;

    /* renamed from: k0, reason: collision with root package name */
    public int f433217k0;

    /* renamed from: m, reason: collision with root package name */
    public int f433218m;

    public af() {
        this(null, 0L, null, 0, null, 0, null, null, null, null, null, null, null, null, 0, false, null, null, null, 0, 0, null, null, 0, 0, 0, null, null, null, null, 0, null, null, null, null, null, null, false, false, -1, 255);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new af(null, 0L, null, 0, null, 0, null, null, null, null, null, null, null, null, 0, false, null, null, null, 0, 0, null, null, 0, 0, 0, null, null, null, null, 0, null, null, null, null, null, null, false, false, -1, 255));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f433205d = (String) obj;
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.f433207e = ((Long) obj).longValue();
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f433209f = (String) obj;
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f433212h = ((Integer) obj).intValue();
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f433214i = (String) obj;
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f433218m = ((Integer) obj).intValue();
                return;
            case 7:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.Birthday");
                this.C = (d) obj;
                return;
            case 8:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.D = (String) obj;
                return;
            case 9:
            default:
                return;
            case 10:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.E = (String) obj;
                return;
            case 11:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.F = (String) obj;
                return;
            case 12:
                List<String> list = this.G;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kotlin.String>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
                return;
            case 13:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.H = (String) obj;
                return;
            case 14:
                List<t35.a> list2 = this.I;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.qqstranger.common.tag.Tag>");
                CollectionsKt__MutableCollectionsKt.addAll(list2, (Sequence) obj);
                return;
            case 15:
                List<t35.a> list3 = this.J;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.qqstranger.common.tag.Tag>");
                CollectionsKt__MutableCollectionsKt.addAll(list3, (Sequence) obj);
                return;
            case 16:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.Qqstranger_user_infoKt.MatchObj }");
                this.K = ((Integer) obj).intValue();
                return;
            case 17:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                this.L = ((Boolean) obj).booleanValue();
                return;
            case 18:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.FirstRelationOriginInfo");
                this.M = (g) obj;
                return;
            case 19:
                List<String> list4 = this.N;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kotlin.String>");
                CollectionsKt__MutableCollectionsKt.addAll(list4, (Sequence) obj);
                return;
            case 20:
                List<String> list5 = this.P;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kotlin.String>");
                CollectionsKt__MutableCollectionsKt.addAll(list5, (Sequence) obj);
                return;
            case 21:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.Q = ((Integer) obj).intValue();
                return;
            case 22:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.R = ((Integer) obj).intValue();
                return;
            case 23:
                List<String> list6 = this.S;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kotlin.String>");
                CollectionsKt__MutableCollectionsKt.addAll(list6, (Sequence) obj);
                return;
            case 24:
                List<e> list7 = this.T;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.DatingPurpose>");
                CollectionsKt__MutableCollectionsKt.addAll(list7, (Sequence) obj);
                return;
            case 25:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.Qqstranger_user_infoKt.GenderFixFlag }");
                this.U = ((Integer) obj).intValue();
                return;
            case 26:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.Qqstranger_user_infoKt.Verified }");
                this.V = ((Integer) obj).intValue();
                return;
            case 27:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.Qqstranger_user_infoKt.UserType }");
                this.W = ((Integer) obj).intValue();
                return;
            case 28:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.X = (String) obj;
                return;
            case 29:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.UserMood");
                this.Y = (ag) obj;
                return;
            case 30:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.LimitInfo");
                this.Z = (r) obj;
                return;
            case 31:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.TacitInfo");
                this.f433202a0 = (aa) obj;
                return;
            case 32:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.Qqstranger_user_infoKt.HeadType }");
                this.f433203b0 = ((Integer) obj).intValue();
                return;
            case 33:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f433204c0 = (String) obj;
                return;
            case 34:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.AvatarInfo");
                this.f433206d0 = (a) obj;
                return;
            case 35:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.kuolie.common.signal.SignalMeta");
                this.f433208e0 = (j25.c) obj;
                return;
            case 36:
                List<r25.b> list8 = this.f433210f0;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.common.user.Dress>");
                CollectionsKt__MutableCollectionsKt.addAll(list8, (Sequence) obj);
                return;
            case 37:
                List<t35.a> list9 = this.f433211g0;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.qqstranger.common.tag.Tag>");
                CollectionsKt__MutableCollectionsKt.addAll(list9, (Sequence) obj);
                return;
            case 38:
                List<t35.a> list10 = this.f433213h0;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.qqstranger.common.tag.Tag>");
                CollectionsKt__MutableCollectionsKt.addAll(list10, (Sequence) obj);
                return;
            case 39:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                this.f433215i0 = ((Boolean) obj).booleanValue();
                return;
            case 40:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                this.f433216j0 = ((Boolean) obj).booleanValue();
                return;
            case 41:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f433217k0 = ((Integer) obj).intValue();
                return;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ af(String str, long j3, String str2, int i3, String str3, int i16, d dVar, String str4, String str5, String str6, List list, String str7, List list2, List list3, int i17, boolean z16, g gVar, List list4, List list5, int i18, int i19, List list6, List list7, int i26, int i27, int i28, String str8, ag agVar, r rVar, aa aaVar, int i29, String str9, a aVar, j25.c cVar, List list8, List list9, List list10, boolean z17, boolean z18, int i36, int i37) {
        this((i36 & 1) != 0 ? "" : str, (i36 & 2) != 0 ? 0L : j3, (i36 & 4) != 0 ? "" : str2, (i36 & 8) != 0 ? 0 : i3, (i36 & 16) != 0 ? "" : str3, (i36 & 32) != 0 ? 0 : i16, (i36 & 64) != 0 ? null : dVar, (i36 & 128) != 0 ? "" : str4, (i36 & 256) != 0 ? "" : str5, (i36 & 512) != 0 ? "" : str6, (i36 & 1024) != 0 ? new ArrayList() : list, (i36 & 2048) != 0 ? "" : str7, (i36 & 4096) != 0 ? new ArrayList() : list2, (i36 & 8192) != 0 ? new ArrayList() : list3, (i36 & 16384) != 0 ? d.c.f30317b.b().getValue() : i17, (i36 & 32768) != 0 ? false : z16, (i36 & 65536) != 0 ? null : gVar, (i36 & 131072) != 0 ? new ArrayList() : list4, (i36 & 262144) != 0 ? new ArrayList() : list5, (i36 & 524288) != 0 ? 0 : i18, (i36 & 1048576) != 0 ? 0 : i19, (i36 & 2097152) != 0 ? new ArrayList() : list6, (i36 & 4194304) != 0 ? new ArrayList() : list7, (i36 & 8388608) != 0 ? d.c.f30317b.b().getValue() : i26, (i36 & 16777216) != 0 ? d.c.f30317b.b().getValue() : i27, (i36 & 33554432) != 0 ? d.c.f30317b.b().getValue() : i28, (i36 & 67108864) != 0 ? r16 : str8, (i36 & 134217728) != 0 ? null : agVar, (i36 & 268435456) != 0 ? null : rVar, (i36 & 536870912) != 0 ? null : aaVar, (i36 & 1073741824) != 0 ? d.c.f30317b.b().getValue() : i29, (i36 & Integer.MIN_VALUE) == 0 ? str9 : "", (i37 & 1) != 0 ? null : aVar, (i37 & 2) != 0 ? null : cVar, (i37 & 4) != 0 ? new ArrayList() : list8, (i37 & 8) != 0 ? new ArrayList() : list9, (i37 & 16) != 0 ? new ArrayList() : list10, (i37 & 32) != 0 ? false : z17, (i37 & 64) != 0 ? false : z18, 0);
        String str10;
        str10 = "";
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        int i3 = 0;
        int i16 = 3;
        int i17 = 63;
        int i18 = 7;
        DefaultConstructorMarker defaultConstructorMarker = null;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f433205d, new b.e.g(false))), TuplesKt.to(2, new c45.h(2, Long.valueOf(this.f433207e), new b.e.i(false))), TuplesKt.to(3, new c45.h(3, this.f433209f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, Integer.valueOf(this.f433212h), new b.e.h(false))), TuplesKt.to(5, new c45.h(5, this.f433214i, new b.e.g(false))), TuplesKt.to(6, new c45.h(6, Integer.valueOf(this.f433218m), new b.e.h(false))), TuplesKt.to(7, new c45.h(7, this.C, new b.d(new d(0, 0, 0, 7, null)))), TuplesKt.to(8, new c45.h(8, this.D, new b.e.g(false))), TuplesKt.to(10, new c45.h(10, this.E, new b.e.g(false))), TuplesKt.to(11, new c45.h(11, this.F, new b.e.g(false))), TuplesKt.to(12, new c45.h(12, this.G, new b.f(new b.e.g(false), false))), TuplesKt.to(13, new c45.h(13, this.H, new b.e.g(false))), TuplesKt.to(14, new c45.h(14, this.I, new b.f(new b.d(new t35.a(i3, null, i17)), false))), TuplesKt.to(15, new c45.h(15, this.J, new b.f(new b.d(new t35.a(i3, 0 == true ? 1 : 0, i17)), false))), TuplesKt.to(16, new c45.h(16, Integer.valueOf(this.K), new b.a(false))), TuplesKt.to(17, new c45.h(17, Boolean.valueOf(this.L), new b.e.a(false))), TuplesKt.to(18, new c45.h(18, this.M, new b.d(new g(0, null, 0L, 7, null)))), TuplesKt.to(19, new c45.h(19, this.N, new b.f(new b.e.g(false), false))), TuplesKt.to(20, new c45.h(20, this.P, new b.f(new b.e.g(false), false))), TuplesKt.to(21, new c45.h(21, Integer.valueOf(this.Q), new b.e.h(false))), TuplesKt.to(22, new c45.h(22, Integer.valueOf(this.R), new b.e.h(false))), TuplesKt.to(23, new c45.h(23, this.S, new b.f(new b.e.g(false), false))), TuplesKt.to(24, new c45.h(24, this.T, new b.f(new b.d(new e(0, "")), false))), TuplesKt.to(25, new c45.h(25, Integer.valueOf(this.U), new b.a(false))), TuplesKt.to(26, new c45.h(26, Integer.valueOf(this.V), new b.a(false))), TuplesKt.to(27, new c45.h(27, Integer.valueOf(this.W), new b.a(false))), TuplesKt.to(28, new c45.h(28, this.X, new b.e.g(false))), TuplesKt.to(29, new c45.h(29, this.Y, new b.d(new ag(i3, 0 == true ? 1 : 0, i16, 0 == true ? 1 : 0)))), TuplesKt.to(30, new c45.h(30, this.Z, new b.d(new r(0 == true ? 1 : 0, false, null, i18, defaultConstructorMarker)))), TuplesKt.to(31, new c45.h(31, this.f433202a0, new b.d(new aa(0 == true ? 1 : 0, null, 0 == true ? 1 : 0, i18, defaultConstructorMarker)))), TuplesKt.to(32, new c45.h(32, Integer.valueOf(this.f433203b0), new b.a(false))), TuplesKt.to(33, new c45.h(33, this.f433204c0, new b.e.g(false))), TuplesKt.to(34, new c45.h(34, this.f433206d0, new b.d(new a(0 == true ? 1 : 0, 0 == true ? 1 : 0, i16, 0 == true ? 1 : 0)))), TuplesKt.to(35, new c45.h(35, this.f433208e0, new b.d(new j25.c(0L, 0 == true ? 1 : 0, null, 0L, 0L, null, 63, null)))), TuplesKt.to(36, new c45.h(36, this.f433210f0, new b.f(new b.d(new r25.b(i3, (r25.c) (0 == true ? 1 : 0), 7)), false))), TuplesKt.to(37, new c45.h(37, this.f433211g0, new b.f(new b.d(new t35.a(i3, 0 == true ? 1 : 0, i17)), false))), TuplesKt.to(38, new c45.h(38, this.f433213h0, new b.f(new b.d(new t35.a(i3, 0 == true ? 1 : 0, i17)), false))), TuplesKt.to(39, new c45.h(39, Boolean.valueOf(this.f433215i0), new b.e.a(false))), TuplesKt.to(40, new c45.h(40, Boolean.valueOf(this.f433216j0), new b.e.a(false))), TuplesKt.to(41, new c45.h(41, Integer.valueOf(this.f433217k0), new b.e.h(false))));
        return mapOf;
    }

    public af(String str, long j3, String str2, int i3, String str3, int i16, d dVar, String str4, String str5, String str6, List<String> list, String str7, List<t35.a> list2, List<t35.a> list3, int i17, boolean z16, g gVar, List<String> list4, List<String> list5, int i18, int i19, List<String> list6, List<e> list7, int i26, int i27, int i28, String str8, ag agVar, r rVar, aa aaVar, int i29, String str9, a aVar, j25.c cVar, List<r25.b> list8, List<t35.a> list9, List<t35.a> list10, boolean z17, boolean z18, int i36) {
        this.f433205d = str;
        this.f433207e = j3;
        this.f433209f = str2;
        this.f433212h = i3;
        this.f433214i = str3;
        this.f433218m = i16;
        this.C = dVar;
        this.D = str4;
        this.E = str5;
        this.F = str6;
        this.G = list;
        this.H = str7;
        this.I = list2;
        this.J = list3;
        this.K = i17;
        this.L = z16;
        this.M = gVar;
        this.N = list4;
        this.P = list5;
        this.Q = i18;
        this.R = i19;
        this.S = list6;
        this.T = list7;
        this.U = i26;
        this.V = i27;
        this.W = i28;
        this.X = str8;
        this.Y = agVar;
        this.Z = rVar;
        this.f433202a0 = aaVar;
        this.f433203b0 = i29;
        this.f433204c0 = str9;
        this.f433206d0 = aVar;
        this.f433208e0 = cVar;
        this.f433210f0 = list8;
        this.f433211g0 = list9;
        this.f433213h0 = list10;
        this.f433215i0 = z17;
        this.f433216j0 = z18;
        this.f433217k0 = i36;
    }
}
