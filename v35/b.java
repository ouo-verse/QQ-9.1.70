package v35;

import c45.b;
import c45.h;
import c45.j;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class b extends j {

    /* renamed from: d, reason: collision with root package name */
    public float f440925d;

    /* renamed from: e, reason: collision with root package name */
    public float f440926e;

    /* renamed from: f, reason: collision with root package name */
    public float f440927f;

    /* renamed from: h, reason: collision with root package name */
    public float f440928h;

    public b() {
        this(0.0f, 0.0f, 0.0f, 0.0f, 15, null);
    }

    @Override // c45.j
    public final j decodeWith(c45.f fVar) {
        return fVar.g(new b(0.0f, 0.0f, 0.0f, 0.0f, 15, null));
    }

    public /* synthetic */ b(float f16, float f17, float f18, float f19, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, Float.valueOf(this.f440925d), new b.e.d(false))), TuplesKt.to(2, new h(2, Float.valueOf(this.f440926e), new b.e.d(false))), TuplesKt.to(3, new h(3, Float.valueOf(this.f440927f), new b.e.d(false))), TuplesKt.to(4, new h(4, Float.valueOf(this.f440928h), new b.e.d(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Float");
            this.f440925d = ((Float) obj).floatValue();
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Float");
            this.f440926e = ((Float) obj).floatValue();
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Float");
            this.f440927f = ((Float) obj).floatValue();
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Float");
            this.f440928h = ((Float) obj).floatValue();
        }
    }

    public b(float f16, float f17, float f18, float f19) {
        this.f440925d = f16;
        this.f440926e = f17;
        this.f440927f = f18;
        this.f440928h = f19;
    }
}
