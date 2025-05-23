package t25;

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
public final class a extends j {
    public int C;
    public boolean D;
    public float E;
    public b F;

    /* renamed from: d, reason: collision with root package name */
    public final List<e> f435330d;

    /* renamed from: e, reason: collision with root package name */
    public b f435331e;

    /* renamed from: f, reason: collision with root package name */
    public c f435332f;

    /* renamed from: h, reason: collision with root package name */
    public float f435333h;

    /* renamed from: i, reason: collision with root package name */
    public int f435334i;

    /* renamed from: m, reason: collision with root package name */
    public int f435335m;

    public a() {
        this(null, null, null, 0.0f, 0, 0, 0, false, 0.0f, null, 1023, null);
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new a(null, null, null, 0.0f, 0, 0, 0, false, 0.0f, null, 1023, null));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                List<e> list = this.f435330d;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.heatmap.NBPWeightedLatLng>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.heatmap.NBPGradientData");
                this.f435331e = (b) obj;
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.heatmap.NBPIntensityRange");
                this.f435332f = (c) obj;
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Float");
                this.f435333h = ((Float) obj).floatValue();
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f435334i = ((Integer) obj).intValue();
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f435335m = ((Integer) obj).intValue();
                return;
            case 7:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.C = ((Integer) obj).intValue();
                return;
            case 8:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                this.D = ((Boolean) obj).booleanValue();
                return;
            case 9:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Float");
                this.E = ((Float) obj).floatValue();
                return;
            case 10:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.heatmap.NBPGradientData");
                this.F = (b) obj;
                return;
            default:
                return;
        }
    }

    public /* synthetic */ a(List list, b bVar, c cVar, float f16, int i3, int i16, int i17, boolean z16, float f17, b bVar2, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(new ArrayList(), null, null, 0.0f, 0, 0, 0, false, 0.0f, null);
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.f435330d, new b.f(new b.d(new e(null, 0.0d, 3, null)), false))), TuplesKt.to(2, new h(2, this.f435331e, new b.d(new b(null, null, 3, null)))), TuplesKt.to(3, new h(3, this.f435332f, new b.d(new c(0.0f, 0.0f, 3, null)))), TuplesKt.to(4, new h(4, Float.valueOf(this.f435333h), new b.e.d(false))), TuplesKt.to(5, new h(5, Integer.valueOf(this.f435334i), new b.e.C0168e(false))), TuplesKt.to(6, new h(6, Integer.valueOf(this.f435335m), new b.e.C0168e(false))), TuplesKt.to(7, new h(7, Integer.valueOf(this.C), new b.e.C0168e(false))), TuplesKt.to(8, new h(8, Boolean.valueOf(this.D), new b.e.a(false))), TuplesKt.to(9, new h(9, Float.valueOf(this.E), new b.e.d(false))), TuplesKt.to(10, new h(10, this.F, new b.d(new b(null, null, 3, null)))));
        return mapOf;
    }

    public a(List<e> list, b bVar, c cVar, float f16, int i3, int i16, int i17, boolean z16, float f17, b bVar2) {
        this.f435330d = list;
        this.f435331e = bVar;
        this.f435332f = cVar;
        this.f435333h = f16;
        this.f435334i = i3;
        this.f435335m = i16;
        this.C = i17;
        this.D = z16;
        this.E = f17;
        this.F = bVar2;
    }
}
