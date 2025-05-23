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
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class a extends j {
    public final List<c> C;
    public int D;
    public c45.a E;

    /* renamed from: d, reason: collision with root package name */
    public String f444534d;

    /* renamed from: e, reason: collision with root package name */
    public String f444535e;

    /* renamed from: f, reason: collision with root package name */
    public int f444536f;

    /* renamed from: h, reason: collision with root package name */
    public String f444537h;

    /* renamed from: i, reason: collision with root package name */
    public String f444538i;

    /* renamed from: m, reason: collision with root package name */
    public c45.a f444539m;

    public /* synthetic */ a(String str, String str2, int i3, String str3, String str4, c45.a aVar, List list, int i16, int i17) {
        this((i17 & 1) != 0 ? "" : str, (i17 & 2) != 0 ? "" : str2, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? "" : str3, (i17 & 16) != 0 ? "" : str4, (i17 & 32) != 0 ? c45.a.f30290b : aVar, (List<c>) ((i17 & 64) != 0 ? new ArrayList() : list), (i17 & 128) != 0 ? 0 : i16, (i17 & 256) != 0 ? c45.a.f30290b : null);
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new a((String) null, (String) null, 0, (String) null, (String) null, (c45.a) null, (List) null, 0, 511));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f444534d = (String) obj;
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f444535e = (String) obj;
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f444536f = ((Integer) obj).intValue();
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f444537h = (String) obj;
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f444538i = (String) obj;
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
                this.f444539m = (c45.a) obj;
                return;
            case 7:
                List<c> list = this.C;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.zplan.vas_mob_proxy_svr.VasTransInfo>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
                return;
            case 8:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.D = ((Integer) obj).intValue();
                return;
            case 9:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
                this.E = (c45.a) obj;
                return;
            default:
                return;
        }
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.f444534d, new b.e.g(false))), TuplesKt.to(2, new h(2, this.f444535e, new b.e.g(false))), TuplesKt.to(3, new h(3, Integer.valueOf(this.f444536f), new b.e.h(false))), TuplesKt.to(4, new h(4, this.f444537h, new b.e.g(false))), TuplesKt.to(5, new h(5, this.f444538i, new b.e.g(false))), TuplesKt.to(6, new h(6, this.f444539m, new b.e.C0167b(false))), TuplesKt.to(7, new h(7, this.C, new b.f(new b.d(new c()), false))), TuplesKt.to(8, new h(8, Integer.valueOf(this.D), new b.e.C0168e(false))), TuplesKt.to(9, new h(9, this.E, new b.e.C0167b(false))));
        return mapOf;
    }

    public a(String str, String str2, int i3, String str3, String str4, c45.a aVar, List<c> list, int i16, c45.a aVar2) {
        this.f444534d = str;
        this.f444535e = str2;
        this.f444536f = i3;
        this.f444537h = str3;
        this.f444538i = str4;
        this.f444539m = aVar;
        this.C = list;
        this.D = i16;
        this.E = aVar2;
    }
}
