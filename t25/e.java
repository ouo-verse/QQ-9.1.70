package t25;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class e extends j {

    /* renamed from: d, reason: collision with root package name */
    public d f435342d;

    /* renamed from: e, reason: collision with root package name */
    public double f435343e;

    public e() {
        this(null, 0.0d, 3, null);
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new e(null, 0.0d, 3, null));
    }

    public /* synthetic */ e(d dVar, double d16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, 0.0d);
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.f435342d, new b.d(new d(0.0d, 0.0d, 3, null)))), TuplesKt.to(2, new h(2, Double.valueOf(this.f435343e), new b.e.c(false))));
        return mapOf;
    }

    public e(d dVar, double d16) {
        this.f435342d = dVar;
        this.f435343e = d16;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.heatmap.NBPLatLng");
            this.f435342d = (d) obj;
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Double");
            this.f435343e = ((Double) obj).doubleValue();
        }
    }
}
