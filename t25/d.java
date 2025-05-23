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
public final class d extends j {

    /* renamed from: d, reason: collision with root package name */
    public double f435340d;

    /* renamed from: e, reason: collision with root package name */
    public double f435341e;

    public d() {
        this(0.0d, 0.0d, 3, null);
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new d(0.0d, 0.0d, 3, null));
    }

    public /* synthetic */ d(double d16, double d17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(0.0d, 0.0d);
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, Double.valueOf(this.f435340d), new b.e.c(false))), TuplesKt.to(2, new h(2, Double.valueOf(this.f435341e), new b.e.c(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Double");
            this.f435340d = ((Double) obj).doubleValue();
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Double");
            this.f435341e = ((Double) obj).doubleValue();
        }
    }

    public d(double d16, double d17) {
        this.f435340d = d16;
        this.f435341e = d17;
    }
}
