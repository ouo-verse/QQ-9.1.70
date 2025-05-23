package w25;

import c45.b;
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

/* compiled from: P */
/* loaded from: classes36.dex */
public final class a extends j {
    public String C;
    public long D;
    public long E;
    public String F;
    public String G;
    public String H;

    /* renamed from: d, reason: collision with root package name */
    public int f444465d;

    /* renamed from: e, reason: collision with root package name */
    public String f444466e;

    /* renamed from: f, reason: collision with root package name */
    public String f444467f;

    /* renamed from: h, reason: collision with root package name */
    public String f444468h;

    /* renamed from: i, reason: collision with root package name */
    public final List<g> f444469i;

    /* renamed from: m, reason: collision with root package name */
    public String f444470m;

    public a() {
        this(0, null, null, null, null, null, null, 0L, 0L, null, null, null, 4095, null);
    }

    @Override // c45.j
    public final j decodeWith(c45.f fVar) {
        return fVar.g(new a(0, null, null, null, null, null, null, 0L, 0L, null, null, null, 4095, null));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f444465d = ((Integer) obj).intValue();
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f444466e = (String) obj;
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f444467f = (String) obj;
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f444468h = (String) obj;
                return;
            case 5:
                List<g> list = this.f444469i;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.mood_svr.mood_svr.User>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f444470m = (String) obj;
                return;
            case 7:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.C = (String) obj;
                return;
            case 8:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.D = ((Long) obj).longValue();
                return;
            case 9:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.E = ((Long) obj).longValue();
                return;
            case 10:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.F = (String) obj;
                return;
            case 11:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.G = (String) obj;
                return;
            case 12:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.H = (String) obj;
                return;
            default:
                return;
        }
    }

    public /* synthetic */ a(int i3, String str, String str2, String str3, List list, String str4, String str5, long j3, long j16, String str6, String str7, String str8, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, "", "", "", new ArrayList(), "", "", 0L, 0L, "", "", "");
    }

    public a(int i3, String str, String str2, String str3, List<g> list, String str4, String str5, long j3, long j16, String str6, String str7, String str8) {
        this.f444465d = i3;
        this.f444466e = str;
        this.f444467f = str2;
        this.f444468h = str3;
        this.f444469i = list;
        this.f444470m = str4;
        this.C = str5;
        this.D = j3;
        this.E = j16;
        this.F = str6;
        this.G = str7;
        this.H = str8;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f444465d), new b.e.h(false))), TuplesKt.to(2, new c45.h(2, this.f444466e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, this.f444467f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, this.f444468h, new b.e.g(false))), TuplesKt.to(5, new c45.h(5, this.f444469i, new b.f(new b.d(new g(0L, null, null, null, null, null, false, null, 0, 0, 1023, null)), false))), TuplesKt.to(6, new c45.h(6, this.f444470m, new b.e.g(false))), TuplesKt.to(7, new c45.h(7, this.C, new b.e.g(false))), TuplesKt.to(8, new c45.h(8, Long.valueOf(this.D), new b.e.i(false))), TuplesKt.to(9, new c45.h(9, Long.valueOf(this.E), new b.e.i(false))), TuplesKt.to(10, new c45.h(10, this.F, new b.e.g(false))), TuplesKt.to(11, new c45.h(11, this.G, new b.e.g(false))), TuplesKt.to(12, new c45.h(12, this.H, new b.e.g(false))));
        return mapOf;
    }
}
