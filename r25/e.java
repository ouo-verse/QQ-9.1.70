package r25;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import n35.w;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class e extends j {
    public int C;
    public int D;
    public String E;
    public int F;
    public String G;
    public boolean H;
    public final List<b> I;
    public String J;
    public int K;
    public String L;
    public int M;
    public String N;
    public a P;
    public final List<t35.a> Q;
    public boolean R;
    public boolean S;
    public int T;
    public int U;
    public int V;
    public String W;
    public d X;
    public d Y;
    public d Z;

    /* renamed from: a0, reason: collision with root package name */
    public d f430609a0;

    /* renamed from: d, reason: collision with root package name */
    public long f430610d;

    /* renamed from: e, reason: collision with root package name */
    public long f430611e;

    /* renamed from: f, reason: collision with root package name */
    public int f430612f;

    /* renamed from: h, reason: collision with root package name */
    public int f430613h;

    /* renamed from: i, reason: collision with root package name */
    public String f430614i;

    /* renamed from: m, reason: collision with root package name */
    public w f430615m;

    public e() {
        this(0L, null, null, 0, null, LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new e(0L, null, null, 0, null, LockFreeTaskQueueCore.MAX_CAPACITY_MASK));
    }

    public /* synthetic */ e(long j3, List list, String str, int i3, String str2, int i16) {
        this((i16 & 1) != 0 ? 0L : j3, 0L, 0, 0, (i16 & 16) != 0 ? "" : null, null, 0, 0, (i16 & 256) != 0 ? "" : null, 0, (i16 & 1024) != 0 ? "" : null, false, (i16 & 4096) != 0 ? new ArrayList() : list, (i16 & 8192) != 0 ? "" : str, (i16 & 16384) != 0 ? 0 : i3, (32768 & i16) != 0 ? "" : str2, 0, (131072 & i16) != 0 ? "" : null, null, (524288 & i16) != 0 ? new ArrayList() : null, false, false, 0, 0, 0, (i16 & 33554432) != 0 ? "" : null, null, null, null, null);
    }

    public e(long j3, long j16, int i3, int i16, String str, w wVar, int i17, int i18, String str2, int i19, String str3, boolean z16, List<b> list, String str4, int i26, String str5, int i27, String str6, a aVar, List<t35.a> list2, boolean z17, boolean z18, int i28, int i29, int i36, String str7, d dVar, d dVar2, d dVar3, d dVar4) {
        this.f430610d = j3;
        this.f430611e = j16;
        this.f430612f = i3;
        this.f430613h = i16;
        this.f430614i = str;
        this.f430615m = wVar;
        this.C = i17;
        this.D = i18;
        this.E = str2;
        this.F = i19;
        this.G = str3;
        this.H = z16;
        this.I = list;
        this.J = str4;
        this.K = i26;
        this.L = str5;
        this.M = i27;
        this.N = str6;
        this.P = aVar;
        this.Q = list2;
        this.R = z17;
        this.S = z18;
        this.T = i28;
        this.U = i29;
        this.V = i36;
        this.W = str7;
        this.X = dVar;
        this.Y = dVar2;
        this.Z = dVar3;
        this.f430609a0 = dVar4;
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        long j3 = 0;
        int i3 = 0;
        int i16 = 0;
        int i17 = 7;
        DefaultConstructorMarker defaultConstructorMarker = null;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, Long.valueOf(this.f430610d), new b.e.i(false))), TuplesKt.to(2, new h(2, Long.valueOf(this.f430611e), new b.e.i(false))), TuplesKt.to(3, new h(3, Integer.valueOf(this.f430612f), new b.e.h(false))), TuplesKt.to(4, new h(4, Integer.valueOf(this.f430613h), new b.e.h(false))), TuplesKt.to(5, new h(5, this.f430614i, new b.e.g(false))), TuplesKt.to(6, new h(6, this.f430615m, new b.d(new w(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0)))), TuplesKt.to(7, new h(7, Integer.valueOf(this.C), new b.e.h(false))), TuplesKt.to(8, new h(8, Integer.valueOf(this.D), new b.e.h(false))), TuplesKt.to(9, new h(9, this.E, new b.e.g(false))), TuplesKt.to(10, new h(10, Integer.valueOf(this.F), new b.e.h(false))), TuplesKt.to(11, new h(11, this.G, new b.e.g(false))), TuplesKt.to(12, new h(12, Boolean.valueOf(this.H), new b.e.a(false))), TuplesKt.to(1001, new h(1001, this.I, new b.f(new b.d(new b(0, (c) (0 == true ? 1 : 0), 7)), false))), TuplesKt.to(10001, new h(10001, this.J, new b.e.g(false))), TuplesKt.to(10002, new h(10002, Integer.valueOf(this.K), new b.e.h(false))), TuplesKt.to(10003, new h(10003, this.L, new b.e.g(false))), TuplesKt.to(10004, new h(10004, Integer.valueOf(this.M), new b.e.h(false))), TuplesKt.to(10005, new h(10005, this.N, new b.e.g(false))), TuplesKt.to(10006, new h(10006, this.P, new b.d(new a(0, 0, 0, 7, null)))), TuplesKt.to(10007, new h(10007, this.Q, new b.f(new b.d(new t35.a(0, null, 63)), false))), TuplesKt.to(10008, new h(10008, Boolean.valueOf(this.R), new b.e.a(false))), TuplesKt.to(10009, new h(10009, Boolean.valueOf(this.S), new b.e.a(false))), TuplesKt.to(10010, new h(10010, Integer.valueOf(this.T), new b.e.h(false))), TuplesKt.to(20001, new h(20001, Integer.valueOf(this.U), new b.e.h(false))), TuplesKt.to(20002, new h(20002, Integer.valueOf(this.V), new b.e.h(false))), TuplesKt.to(20003, new h(20003, this.W, new b.e.g(false))), TuplesKt.to(30001, new h(30001, this.X, new b.d(new d(j3, i3, i16, i17, defaultConstructorMarker)))), TuplesKt.to(30002, new h(30002, this.Y, new b.d(new d(j3, i3, i16, i17, defaultConstructorMarker)))), TuplesKt.to(30005, new h(30005, this.Z, new b.d(new d(j3, i3, i16, i17, defaultConstructorMarker)))), TuplesKt.to(30006, new h(30006, this.f430609a0, new b.d(new d(j3, i3, i16, i17, defaultConstructorMarker)))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1001) {
            List<b> list = this.I;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.common.user.Dress>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
            return;
        }
        if (i3 == 30001) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.user.UpdateTrace");
            this.X = (d) obj;
            return;
        }
        if (i3 == 30002) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.user.UpdateTrace");
            this.Y = (d) obj;
            return;
        }
        if (i3 == 30005) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.user.UpdateTrace");
            this.Z = (d) obj;
            return;
        }
        if (i3 != 30006) {
            switch (i3) {
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                    this.f430610d = ((Long) obj).longValue();
                    return;
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                    this.f430611e = ((Long) obj).longValue();
                    return;
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                    this.f430612f = ((Integer) obj).intValue();
                    return;
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                    this.f430613h = ((Integer) obj).intValue();
                    return;
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                    this.f430614i = (String) obj;
                    return;
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.MsgInfo");
                    this.f430615m = (w) obj;
                    return;
                case 7:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                    this.C = ((Integer) obj).intValue();
                    return;
                case 8:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                    this.D = ((Integer) obj).intValue();
                    return;
                case 9:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                    this.E = (String) obj;
                    return;
                case 10:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                    this.F = ((Integer) obj).intValue();
                    return;
                case 11:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                    this.G = (String) obj;
                    return;
                case 12:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                    this.H = ((Boolean) obj).booleanValue();
                    return;
                default:
                    switch (i3) {
                        case 10001:
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                            this.J = (String) obj;
                            return;
                        case 10002:
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                            this.K = ((Integer) obj).intValue();
                            return;
                        case 10003:
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                            this.L = (String) obj;
                            return;
                        case 10004:
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                            this.M = ((Integer) obj).intValue();
                            return;
                        case 10005:
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                            this.N = (String) obj;
                            return;
                        case 10006:
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.user.Birthday");
                            this.P = (a) obj;
                            return;
                        case 10007:
                            List<t35.a> list2 = this.Q;
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.qqstranger.common.tag.Tag>");
                            CollectionsKt__MutableCollectionsKt.addAll(list2, (Sequence) obj);
                            return;
                        case 10008:
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                            this.R = ((Boolean) obj).booleanValue();
                            return;
                        case 10009:
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                            this.S = ((Boolean) obj).booleanValue();
                            return;
                        case 10010:
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                            this.T = ((Integer) obj).intValue();
                            return;
                        default:
                            switch (i3) {
                                case 20001:
                                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                                    this.U = ((Integer) obj).intValue();
                                    return;
                                case 20002:
                                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                                    this.V = ((Integer) obj).intValue();
                                    return;
                                case 20003:
                                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                                    this.W = (String) obj;
                                    return;
                                default:
                                    return;
                            }
                    }
            }
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.user.UpdateTrace");
        this.f430609a0 = (d) obj;
    }
}
