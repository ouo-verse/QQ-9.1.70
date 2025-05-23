package w35;

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

/* compiled from: P */
/* loaded from: classes36.dex */
public final class b extends j {

    /* renamed from: d, reason: collision with root package name */
    public int f444540d;

    /* renamed from: e, reason: collision with root package name */
    public String f444541e;

    /* renamed from: f, reason: collision with root package name */
    public c45.a f444542f;

    /* renamed from: h, reason: collision with root package name */
    public final List<c> f444543h;

    /* renamed from: i, reason: collision with root package name */
    public long f444544i;

    /* renamed from: m, reason: collision with root package name */
    public String f444545m;

    public b() {
        this(0, null, null, null, 0L, null, 63, null);
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new b(0, null, null, null, 0L, null, 63, null));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f444540d = ((Integer) obj).intValue();
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f444541e = (String) obj;
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
                this.f444542f = (c45.a) obj;
                return;
            case 4:
                List<c> list = this.f444543h;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.zplan.vas_mob_proxy_svr.VasTransInfo>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.f444544i = ((Long) obj).longValue();
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f444545m = (String) obj;
                return;
            default:
                return;
        }
    }

    public /* synthetic */ b(int i3, String str, c45.a aVar, List list, long j3, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, "", c45.a.f30290b, new ArrayList(), 0L, "");
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, Integer.valueOf(this.f444540d), new b.e.C0168e(false))), TuplesKt.to(2, new h(2, this.f444541e, new b.e.g(false))), TuplesKt.to(3, new h(3, this.f444542f, new b.e.C0167b(false))), TuplesKt.to(4, new h(4, this.f444543h, new b.f(new b.d(new c()), false))), TuplesKt.to(5, new h(5, Long.valueOf(this.f444544i), new b.e.f(false))), TuplesKt.to(6, new h(6, this.f444545m, new b.e.g(false))));
        return mapOf;
    }

    public b(int i3, String str, c45.a aVar, List<c> list, long j3, String str2) {
        this.f444540d = i3;
        this.f444541e = str;
        this.f444542f = aVar;
        this.f444543h = list;
        this.f444544i = j3;
        this.f444545m = str2;
    }
}
