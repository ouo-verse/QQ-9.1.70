package s35;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class d extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public int f433229d;

    /* renamed from: e, reason: collision with root package name */
    public int f433230e;

    /* renamed from: f, reason: collision with root package name */
    public int f433231f;

    public d() {
        this(0, 0, 0, 7, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new d(0, 0, 0, 7, null));
    }

    public /* synthetic */ d(int i3, int i16, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, 0, 0);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f433229d), new b.e.h(false))), TuplesKt.to(2, new c45.h(2, Integer.valueOf(this.f433230e), new b.e.h(false))), TuplesKt.to(3, new c45.h(3, Integer.valueOf(this.f433231f), new b.e.h(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f433229d = ((Integer) obj).intValue();
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f433230e = ((Integer) obj).intValue();
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f433231f = ((Integer) obj).intValue();
        }
    }

    public d(int i3, int i16, int i17) {
        this.f433229d = i3;
        this.f433230e = i16;
        this.f433231f = i17;
    }
}
