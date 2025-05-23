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
public final class c extends j {

    /* renamed from: d, reason: collision with root package name */
    public float f435338d;

    /* renamed from: e, reason: collision with root package name */
    public float f435339e;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public c() {
        this(r2, r2, 3, null);
        float f16 = 0.0f;
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        float f16 = 0.0f;
        return fVar.g(new c(f16, f16, 3, null));
    }

    public /* synthetic */ c(float f16, float f17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(0.0f, 0.0f);
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, Float.valueOf(this.f435338d), new b.e.d(false))), TuplesKt.to(2, new h(2, Float.valueOf(this.f435339e), new b.e.d(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Float");
            this.f435338d = ((Float) obj).floatValue();
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Float");
            this.f435339e = ((Float) obj).floatValue();
        }
    }

    public c(float f16, float f17) {
        this.f435338d = f16;
        this.f435339e = f17;
    }
}
