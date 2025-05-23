package x25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class l extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public boolean f447109d;

    /* renamed from: e, reason: collision with root package name */
    public long f447110e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f447111f;

    /* renamed from: h, reason: collision with root package name */
    public long f447112h;

    public l() {
        this(false, 0L, false, 0L, 15, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new l(false, 0L, false, 0L, 15, null));
    }

    public /* synthetic */ l(boolean z16, long j3, boolean z17, long j16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(false, 0L, false, 0L);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Boolean.valueOf(this.f447109d), new b.e.a(false))), TuplesKt.to(2, new c45.h(2, Long.valueOf(this.f447110e), new b.e.f(false))), TuplesKt.to(3, new c45.h(3, Boolean.valueOf(this.f447111f), new b.e.a(false))), TuplesKt.to(4, new c45.h(4, Long.valueOf(this.f447112h), new b.e.f(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            this.f447109d = ((Boolean) obj).booleanValue();
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f447110e = ((Long) obj).longValue();
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            this.f447111f = ((Boolean) obj).booleanValue();
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f447112h = ((Long) obj).longValue();
        }
    }

    public l(boolean z16, long j3, boolean z17, long j16) {
        this.f447109d = z16;
        this.f447110e = j3;
        this.f447111f = z17;
        this.f447112h = j16;
    }
}
