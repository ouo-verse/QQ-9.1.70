package y25;

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
import t25.d;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class a extends j {

    /* renamed from: d, reason: collision with root package name */
    public final List<d> f449292d;

    /* renamed from: e, reason: collision with root package name */
    public int f449293e;

    /* renamed from: f, reason: collision with root package name */
    public int f449294f;

    /* renamed from: h, reason: collision with root package name */
    public int f449295h;

    /* renamed from: i, reason: collision with root package name */
    public int f449296i;

    public a(List<d> list, int i3, int i16, int i17, int i18) {
        this.f449292d = list;
        this.f449293e = i3;
        this.f449294f = i16;
        this.f449295h = i17;
        this.f449296i = i18;
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new a(new ArrayList(), 0, 0, 0, 0));
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.f449292d, new b.f(new b.d(new d(0.0d, 0.0d, 3, null)), false))), TuplesKt.to(2, new h(2, Integer.valueOf(this.f449293e), new b.e.C0168e(false))), TuplesKt.to(3, new h(3, Integer.valueOf(this.f449294f), new b.e.C0168e(false))), TuplesKt.to(4, new h(4, Integer.valueOf(this.f449295h), new b.e.C0168e(false))), TuplesKt.to(5, new h(5, Integer.valueOf(this.f449296i), new b.e.C0168e(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            List<d> list = this.f449292d;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.heatmap.NBPLatLng>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f449293e = ((Integer) obj).intValue();
            return;
        }
        if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f449294f = ((Integer) obj).intValue();
        } else if (i3 == 4) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f449295h = ((Integer) obj).intValue();
        } else {
            if (i3 != 5) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f449296i = ((Integer) obj).intValue();
        }
    }
}
